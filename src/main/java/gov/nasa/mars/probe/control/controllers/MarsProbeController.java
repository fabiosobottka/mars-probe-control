package gov.nasa.mars.probe.control.controllers;

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

import gov.nasa.mars.probe.control.controllers.converter.ProbePositionRespondeDTOConverter;
import gov.nasa.mars.probe.control.controllers.dto.request.ExploreMarsRequestDTO;
import gov.nasa.mars.probe.control.controllers.dto.request.ProbeInstructionsRequestDTO;
import gov.nasa.mars.probe.control.controllers.dto.request.ProbePositionRequestDTO;
import gov.nasa.mars.probe.control.controllers.dto.response.ProbePositionRespondeDTO;
import gov.nasa.mars.probe.control.entities.Plateau;
import gov.nasa.mars.probe.control.entities.Probe;
import gov.nasa.mars.probe.control.entities.builder.CoordinateBuilder;
import gov.nasa.mars.probe.control.entities.builder.PlateauBuilder;
import gov.nasa.mars.probe.control.entities.builder.ProbeBuilder;
import gov.nasa.mars.probe.control.entities.builder.ProbePositionBuilder;
import gov.nasa.mars.probe.control.usecases.ExploreMars;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mars/probe")
@Api(value = "MarsProbe", tags = { "MarsProbe" })
public class MarsProbeController {
	
	private static Logger log = LoggerFactory.getLogger(MarsProbeController.class);
	
	@Autowired
	private ExploreMars exploreMars;

	@ApiOperation(value = "Explore mars operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Explore mars operation successfully executed"),
            @ApiResponse(code = 400, message = "Explore mars invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
	@PostMapping(path = "/explore", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProbePositionRespondeDTO>> explore(@Valid @RequestBody final ExploreMarsRequestDTO request) {

		
		log.info("Received explore mars request");
		final List<ProbePositionRespondeDTO> response = new ArrayList<>();
		
		final Plateau plateu = buildPlateau(request);
		request.getProbeInstructions().stream().forEach(probeInstructionRequest -> {

			final Probe probe = buildProbe(probeInstructionRequest);
			try {
				final var probePosition = 
						exploreMars.execute(probe, plateu, probeInstructionRequest.getExploreInstructionsCommand());
				
				response.add(ProbePositionRespondeDTOConverter.toDTO(probePosition));
			} catch (final Exception e) {
				log.error("Failed exploration", e);
			}
		});
		
		log.info("Mars has been explored");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	private Probe buildProbe(final ProbeInstructionsRequestDTO probeInstruction) {
		final ProbePositionRequestDTO probePosition = probeInstruction.getProbePosition();
		
		return ProbeBuilder.create()
				.setPosition(ProbePositionBuilder.create()
						.setCoordinateX(CoordinateBuilder.create()
								.setValue(probePosition.getCoordinateX())
								.build())
						.setCoordinateY(CoordinateBuilder.create()
								.setValue(probePosition.getCoordinateY())
								.build())
						.setCardinalPoint(probePosition.getCardinalPoint())
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
