package gov.nasa.mars.rover.control.exceptions;

public class InvalidRoverInstructionsException extends RuntimeException {

	private static final long serialVersionUID = -5644918374418604013L;

	public InvalidRoverInstructionsException() {
		super("Invalid rover instructions exception. Possible instructions values: 'L' - Left | 'R' - Right | 'M' - Move");
	}

}
