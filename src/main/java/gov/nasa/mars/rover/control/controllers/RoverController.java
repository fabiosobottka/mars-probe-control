package gov.nasa.mars.rover.control.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.mars.rover.control.controllers.dto.request.ExploreMarsRequestDTO;
import gov.nasa.mars.rover.control.controllers.dto.request.RoverExploreCommandsRequestDTO;
import gov.nasa.mars.rover.control.controllers.dto.response.RoverResponseDTO;
import gov.nasa.mars.rover.control.domain.Direction;
import gov.nasa.mars.rover.control.domain.Plateau;
import gov.nasa.mars.rover.control.domain.Rover;
import gov.nasa.mars.rover.control.usecases.CreatePlateau;
import gov.nasa.mars.rover.control.usecases.CreateRover;
import gov.nasa.mars.rover.control.usecases.ExplorePlanet;
import gov.nasa.mars.rover.control.usecases.GetRoverById;
import gov.nasa.mars.rover.control.usecases.GetRovers;
import gov.nasa.mars.rover.control.utils.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rovers")
@Api(value = "Rover", tags = { "Rover" })
public class RoverController {

	private static Logger log = LoggerFactory.getLogger(RoverController.class);

	@Autowired
	private ExplorePlanet explore;

	@Autowired
	private CreateRover createRover;

	@Autowired
	private GetRovers getRovers;

	@Autowired
	private CreatePlateau createPlateau;

	@Autowired
	private GetRoverById getRoverById;

	@ApiOperation(value = "Explore Planet operation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Explore mars operation successfully executed"),
			@ApiResponse(code = 400, message = "Explore mars invalid request"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(path = "/explore", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoverResponseDTO>> explore(
			@Valid @RequestBody final ExploreMarsRequestDTO request) {

		log.info("Received explore mars request");
		final List<RoverResponseDTO> response = new ArrayList<>();

		final Plateau plateau = createPlateau.execute(request.getPlateauUpperRightPosition());

		request.getRoverInstructions().stream().forEach(roverInstructionRequest -> {

			Rover rover = createRover.execute(roverInstructionRequest, plateau);
			try {
				rover = explore.execute(rover, roverInstructionRequest.getExploreInstructionsCommand());
				response.add(convertToRoverExploreResponseDTO(rover));
			} catch (final Exception e) {
				log.error("Failed exploration", e);
				throw new RuntimeException(e);
			}
		});

		log.info("Mars has been explored");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping(path = "/{roverId}/explore")
	public ResponseEntity<RoverResponseDTO> explore(@PathVariable("roverId") final Long roverId, @RequestBody final RoverExploreCommandsRequestDTO request) throws Exception {
		
		final Rover rover = getRoverById.execute(roverId);

		final RoverResponseDTO response = convertToRoverExploreResponseDTO(
				explore.execute(rover, request.getExploreInstructionsCommand()));

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/{roverId}")
	public ResponseEntity<RoverResponseDTO> getById(@PathVariable("roverId") final Long roverId) {

		final RoverResponseDTO response = convertToRoverReponseDTO(getRoverById.execute(roverId));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	private RoverResponseDTO convertToRoverReponseDTO(final Rover rover) {
		
		final Long id = rover.getId();
		final Long positionX = rover.getPosition().getX();
		final Long positionY = rover.getPosition().getY();
		final RoverResponseDTO response = new RoverResponseDTO(id, positionX, positionY, rover.getDirection().name());
		return response;
	}

	@GetMapping
	public ResponseEntity<Pagination<RoverResponseDTO>> getAll(
			@RequestParam(name = "pageNumber", defaultValue = "0") @PositiveOrZero final Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "10") @Positive @Max(value = 100) @Min(value = 1) final Integer pageSize) {

		final Pagination<RoverResponseDTO> response = getRovers.execute(pageNumber, pageSize);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	private RoverResponseDTO convertToRoverExploreResponseDTO(final Rover rover) {

		final Long id = rover.getId();
		final Long x = rover.getPosition().getX();
		final Long y = rover.getPosition().getY();
		final Direction direction = rover.getDirection();

		return new RoverResponseDTO(id, x, y, direction.name());
	}

}
