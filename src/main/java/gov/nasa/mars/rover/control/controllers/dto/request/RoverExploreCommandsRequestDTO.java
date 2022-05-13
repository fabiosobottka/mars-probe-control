package gov.nasa.mars.rover.control.controllers.dto.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class RoverExploreCommandsRequestDTO {
	
	@ApiModelProperty(
			notes = "Rover instructions command sequence | Allowed values - L(LEFT) or R(RIGHT) or M(MOVE)", 
			example = "LMLMRMRMLMLMLMLMM",
			required = true, 
			position = 1
			)
	@NotEmpty
	private String exploreInstructionsCommand;
	
	public RoverExploreCommandsRequestDTO() {}

	public RoverExploreCommandsRequestDTO(final String exploreInstructionsCommand) {
		super();
		this.exploreInstructionsCommand = exploreInstructionsCommand;
	}

	public String getExploreInstructionsCommand() {
		return exploreInstructionsCommand;
	}

	public void setExploreInstructionsCommand(final String exploreInstructionsCommand) {
		this.exploreInstructionsCommand = exploreInstructionsCommand;
	}

}
