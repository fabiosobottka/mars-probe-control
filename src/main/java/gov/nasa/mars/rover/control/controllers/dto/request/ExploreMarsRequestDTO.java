package gov.nasa.mars.rover.control.controllers.dto.request;

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

	@ApiModelProperty(notes = "Rover instructions request", required = true, position = 1)
	@NotNull
	@Size(min = 1)
	private List<RoverInstructionsRequestDTO> roverInstructions;

	public ExploreMarsRequestDTO() {}

	public ExploreMarsRequestDTO(
			final PlateauCoordinatesRequestDTO plateauUpperRightCoordinates,
			final List<RoverInstructionsRequestDTO> roverInstructions) {
		super();
		this.plateauUpperRightCoordinates = plateauUpperRightCoordinates;
		this.roverInstructions = roverInstructions;
	}

	public PlateauCoordinatesRequestDTO getPlateauUpperRightCoordinates() {
		return plateauUpperRightCoordinates;
	}

	public void setPlateauUpperRightCoordinates(final PlateauCoordinatesRequestDTO plateauUpperRightCoordinates) {
		this.plateauUpperRightCoordinates = plateauUpperRightCoordinates;
	}

	public List<RoverInstructionsRequestDTO> getRoverInstructions() {
		return roverInstructions;
	}

	public void setRoverInstructions(final List<RoverInstructionsRequestDTO> roverInstructions) {
		this.roverInstructions = roverInstructions;
	}

}
