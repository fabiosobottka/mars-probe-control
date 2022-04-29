package gov.nasa.mars.rover.control.controllers.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import gov.nasa.mars.rover.control.exceptions.InvalidRoverInstructionsException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Rover instructions information request")
public class RoverInstructionsRequestDTO {

	@ApiModelProperty(notes = "Rover position.", required = true, position = 0)
	@NotNull
	private RoverPositionRequestDTO roverPosition;

	@ApiModelProperty(
			notes = "Rover instructions command sequence | Allowed values - L(LEFT) or R(RIGHT) or M(MOVE)", 
			example = "LMLMRMRMLMLMLMLMM",
			required = true, 
			position = 1
			)
	@NotEmpty
	private String exploreInstructionsCommand;

	public RoverInstructionsRequestDTO() {}

	public RoverInstructionsRequestDTO(
			final RoverPositionRequestDTO roverPosition,
			final String exploreInstructionsCommand) {
		super();
		this.roverPosition = roverPosition;
		this.exploreInstructionsCommand = exploreInstructionsCommand;
	}

	public RoverPositionRequestDTO getRoverPosition() {
		return roverPosition;
	}

	public String getExploreInstructionsCommand() {
		return exploreInstructionsCommand;
	}

	public void setRoverPosition(final RoverPositionRequestDTO roverPosition) {
		this.roverPosition = roverPosition;
	}

	public void setExploreInstructionsCommand(final String exploreInstructionsCommand) {
		
		final Pattern pattern = Pattern.compile("[LRM]+");
		final Matcher matcher = pattern.matcher(exploreInstructionsCommand);
		
		if(!matcher.matches())
			throw new InvalidRoverInstructionsException();
		
		this.exploreInstructionsCommand = exploreInstructionsCommand;
	}

}
