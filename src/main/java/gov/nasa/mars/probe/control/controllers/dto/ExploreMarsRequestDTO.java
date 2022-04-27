package gov.nasa.mars.probe.control.controllers.dto;

import java.util.List;

public class ExploreMarsRequestDTO {

	private PlateauCoordinatesRequestDTO plateauUpperRightCoordinates;

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
