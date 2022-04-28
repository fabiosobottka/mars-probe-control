package gov.nasa.mars.probe.control.controllers.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import gov.nasa.mars.probe.control.exceptions.InvalidProbeInstructionsException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Probe instructions information request")
public class ProbeInstructionsRequestDTO {

	@ApiModelProperty(notes = "Probe position.", required = true, position = 0)
	@NotNull
	private ProbePositionRequestDTO probePosition;

	@ApiModelProperty(
			notes = "Probe instructions command sequence | Allowed values - L(LEFT) or R(RIGHT) or M(MOVE)", 
			example = "LMLMRMRMLMLMLMLMM",
			required = true, 
			position = 1
			)
	@NotEmpty
	private String exploreInstructionsCommand;

	public ProbeInstructionsRequestDTO() {}

	public ProbeInstructionsRequestDTO(
			final ProbePositionRequestDTO probePosition,
			final String exploreInstructionsCommand) {
		super();
		this.probePosition = probePosition;
		this.exploreInstructionsCommand = exploreInstructionsCommand;
	}

	public ProbePositionRequestDTO getProbePosition() {
		return probePosition;
	}

	public String getExploreInstructionsCommand() {
		return exploreInstructionsCommand;
	}

	public void setProbePosition(final ProbePositionRequestDTO probePosition) {
		this.probePosition = probePosition;
	}

	public void setExploreInstructionsCommand(final String exploreInstructionsCommand) {
		
		final Pattern pattern = Pattern.compile("[LRM]+");
		final Matcher matcher = pattern.matcher(exploreInstructionsCommand);
		
		if(!matcher.matches())
			throw new InvalidProbeInstructionsException();
		
		this.exploreInstructionsCommand = exploreInstructionsCommand;
	}

}
