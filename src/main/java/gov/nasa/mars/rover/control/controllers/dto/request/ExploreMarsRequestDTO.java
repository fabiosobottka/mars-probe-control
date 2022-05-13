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
	private PlateauUpperRightPositionRequestDTO plateauUpperRightPosition;

	@ApiModelProperty(notes = "Rover instructions request", required = true, position = 1)
	@NotNull
	@Size(min = 1)
	private List<RoverInstructionsRequestDTO> roverInstructions;

	public ExploreMarsRequestDTO() {}

	public ExploreMarsRequestDTO(final PlateauUpperRightPositionRequestDTO plateauUpperRightPosition,
			final List<RoverInstructionsRequestDTO> roverInstructions) {
		this.plateauUpperRightPosition = plateauUpperRightPosition;
		this.roverInstructions = roverInstructions;
	}

	public PlateauUpperRightPositionRequestDTO getPlateauUpperRightPosition() {
		return plateauUpperRightPosition;
	}

	public List<RoverInstructionsRequestDTO> getRoverInstructions() {
		return roverInstructions;
	}

	public void setPlateauUpperRightPosition(final PlateauUpperRightPositionRequestDTO plateauUpperRightPosition) {
		this.plateauUpperRightPosition = plateauUpperRightPosition;
	}

	public void setRoverInstructions(final List<RoverInstructionsRequestDTO> roverInstructions) {
		this.roverInstructions = roverInstructions;
	}

}
