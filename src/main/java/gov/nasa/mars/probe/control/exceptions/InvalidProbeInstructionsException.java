package gov.nasa.mars.probe.control.exceptions;

public class InvalidProbeInstructionsException extends RuntimeException {

	private static final long serialVersionUID = -5644918374418604013L;

	public InvalidProbeInstructionsException() {
		super("Invalid probe instructions exception. Possible instructions values: 'L' - Left | 'R' - Right | 'M' - Move");
	}

}
