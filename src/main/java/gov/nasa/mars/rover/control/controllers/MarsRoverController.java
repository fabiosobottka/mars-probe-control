package gov.nasa.mars.rover.control.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.mars.rover.control.controllers.converter.RoverPositionRespondeDTOConverter;
import gov.nasa.mars.rover.control.controllers.dto.request.ExploreMarsRequestDTO;
import gov.nasa.mars.rover.control.controllers.dto.request.RoverInstructionsRequestDTO;
import gov.nasa.mars.rover.control.controllers.dto.request.RoverPositionRequestDTO;
import gov.nasa.mars.rover.control.controllers.dto.response.RoverPositionRespondeDTO;
import gov.nasa.mars.rover.control.entities.Rover;
import gov.nasa.mars.rover.control.entities.Plateau;
import gov.nasa.mars.rover.control.entities.builder.CoordinateBuilder;
import gov.nasa.mars.rover.control.entities.builder.RoverBuilder;
import gov.nasa.mars.rover.control.entities.builder.RoverPositionBuilder;
import gov.nasa.mars.rover.control.entities.builder.PlateauBuilder;
import gov.nasa.mars.rover.control.usecases.ExploreMars;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mars/rover")
@Api(value = "MarsRover", tags = { "MarsRover" })
public class MarsRoverController {
	
	private static Logger log = LoggerFactory.getLogger(MarsRoverController.class);
	
	@Autowired
	private ExploreMars exploreMars;

	@ApiOperation(value = "Explore mars operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Explore mars operation successfully executed"),
            @ApiResponse(code = 400, message = "Explore mars invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
	@PostMapping(path = "/explore", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoverPositionRespondeDTO>> explore(@Valid @RequestBody final ExploreMarsRequestDTO request) {

		
		log.info("Received explore mars request");
		final List<RoverPositionRespondeDTO> response = new ArrayList<>();
		
		final Plateau plateu = buildPlateau(request);
		request.getRoverInstructions().stream().forEach(roverInstructionRequest -> {

			final Rover rover = buildRover(roverInstructionRequest);
			try {
				final var roverPosition = 
						exploreMars.execute(rover, plateu, roverInstructionRequest.getExploreInstructionsCommand());
				
				response.add(RoverPositionRespondeDTOConverter.toDTO(roverPosition));
			} catch (final Exception e) {
				log.error("Failed exploration", e);
				throw new RuntimeException(e);
			}
		});
		
		log.info("Mars has been explored");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	private Rover buildRover(final RoverInstructionsRequestDTO roverInstruction) {
		final RoverPositionRequestDTO roverPosition = roverInstruction.getRoverPosition();
		
		return RoverBuilder.create()
				.setPosition(RoverPositionBuilder.create()
						.setCoordinateX(CoordinateBuilder.create()
								.setValue(roverPosition.getCoordinateX())
								.build())
						.setCoordinateY(CoordinateBuilder.create()
								.setValue(roverPosition.getCoordinateY())
								.build())
						.setCardinalPoint(roverPosition.getCardinalPoint())
						.build())
				.build();
	}


	private Plateau buildPlateau(final ExploreMarsRequestDTO request) {

		return PlateauBuilder.create()
				.setBottomLeftX(CoordinateBuilder.create()
				.setValue(0L)
				.build())
				.setBottomLeftY(CoordinateBuilder.create()
						.setValue(0L)
						.build())
				.setUpperRightCoordinateX(CoordinateBuilder.create()
						.setValue(request.getPlateauUpperRightCoordinates().getUpperRightCoordinateX())
						.build())
				.setUpperRightCoordinateY(CoordinateBuilder.create()
						.setValue(request.getPlateauUpperRightCoordinates().getUpperRightCoordinateY())
						.build())
				.build();
	}

}
