package gov.nasa.mars.probe.control.controllers.dto.request;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Explore mars request")
public class ExploreMarsRequestDTO {

	@ApiModelProperty(notes = "Plateau coordinates request", required = true, position = 0)
	@NotNull
	private PlateauCoordinatesRequestDTO plateauUpperRightCoordinates;

	@ApiModelProperty(notes = "Probe instructions request", required = true, position = 1)
	@NotNull
	@Size(min = 1)
	private List<ProbeInstructionsRequestDTO> probeInstructions;

	public ExploreMarsRequestDTO() {}

	public ExploreMarsRequestDTO(
			final PlateauCoordinatesRequestDTO plateauUpperRightCoordinates,
			final List<ProbeInstructionsRequestDTO> probeInstructions) {
		super();
		this.plateauUpperRightCoordinates = plateauUpperRightCoordinates;
		this.probeInstructions = probeInstructions;
	}

	public PlateauCoordinatesRequestDTO getPlateauUpperRightCoordinates() {
		return plateauUpperRightCoordinates;
	}

	public void setPlateauUpperRightCoordinates(final PlateauCoordinatesRequestDTO plateauUpperRightCoordinates) {
		this.plateauUpperRightCoordinates = plateauUpperRightCoordinates;
	}

	public List<ProbeInstructionsRequestDTO> getProbeInstructions() {
		return probeInstructions;
	}

	public void setProbeInstructions(final List<ProbeInstructionsRequestDTO> probeInstructions) {
		this.probeInstructions = probeInstructions;
	}

}
