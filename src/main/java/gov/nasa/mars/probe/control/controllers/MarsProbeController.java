package gov.nasa.mars.probe.control.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.mars.probe.control.controllers.dto.ExploreMarsRequestDTO;
import gov.nasa.mars.probe.control.controllers.dto.ProbeInstructionsRequestDTO;
import gov.nasa.mars.probe.control.entities.Plateau;
import gov.nasa.mars.probe.control.entities.Probe;
import gov.nasa.mars.probe.control.entities.ProbePosition;
import gov.nasa.mars.probe.control.entities.builder.CoordinateBuilder;
import gov.nasa.mars.probe.control.entities.builder.PlateauBuilder;
import gov.nasa.mars.probe.control.entities.builder.ProbeBuilder;
import gov.nasa.mars.probe.control.usecases.ExploreMars;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mars/probe")
@Api(value = "MarsProbe", description = "API for control probe operation in mars", tags = {"MarsProbe"})
public class MarsProbeController {
	
	@Autowired
	private ExploreMars exploreMars;

	@ApiOperation(value = "Explore mars operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Explore mars operation executed"),
            @ApiResponse(code = 400, message = "Explore mars invalid request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
	@PostMapping(path = "/explore", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProbePosition>> explore(@RequestBody final ExploreMarsRequestDTO request) {

		final List<ProbePosition> response = new ArrayList<>();
		
		final Plateau plateu = buildPlateauInfo(request);
		request.getProbeInstructions().stream().forEach(probeInstruction -> {

			final Probe probe = buildProbeInfo(probeInstruction);
			try {
				final var probePosition = 
						exploreMars.execute(probe, plateu, probeInstruction.getExploreInstructionsCommand());
				
				response.add(probePosition);
			} catch (final Exception e) {
				// TODO logs exception
			}
		});
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	private Probe buildProbeInfo(final ProbeInstructionsRequestDTO probeInstruction) {
		
		return ProbeBuilder.create()
				.setPosition(probeInstruction.getProbePosition())
				.build();
	}


	private Plateau buildPlateauInfo(final ExploreMarsRequestDTO request) {

		return PlateauBuilder.create()
				.setBottomLeftX(CoordinateBuilder.create()
				.setValue(0)
				.build())
				.setBottomLeftY(CoordinateBuilder.create()
						.setValue(0)
						.build())
				.setUpperRightCoordinateX(CoordinateBuilder.create()
						.setValue(request.getPlateauUpperRightCoordinates().getUpperRightCoordinateX().getValue())
						.build())
				.setUpperRightCoordinateY(CoordinateBuilder.create()
						.setValue(request.getPlateauUpperRightCoordinates().getUpperRightCoordinateY().getValue())
						.build())
				.build();
	}

}
