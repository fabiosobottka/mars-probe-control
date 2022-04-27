package gov.nasa.mars.probe.control.controllers.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import gov.nasa.mars.probe.control.entities.ProbePosition;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeInstructionsException;

public class ProbeInstructionsRequestDTO {

	@NotNull
	private ProbePosition probePosition;

	@NotEmpty
	@NotNull
	private String exploreInstructionsCommand;

	public ProbeInstructionsRequestDTO() {}

	public ProbeInstructionsRequestDTO(
			@NotNull ProbePosition probePosition,
			@NotEmpty @NotNull String exploreInstructionsCommand) {
		super();
		this.probePosition = probePosition;
		this.exploreInstructionsCommand = exploreInstructionsCommand;
	}

	public ProbePosition getProbePosition() {
		return probePosition;
	}

	public String getExploreInstructionsCommand() {
		return exploreInstructionsCommand;
	}

	public void setProbePosition(final ProbePosition probePosition) {
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
