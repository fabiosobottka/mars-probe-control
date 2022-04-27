package gov.nasa.mars.probe.control.exceptions;

public class InvalidProbeCoordinateException extends RuntimeException {

	private static final long serialVersionUID = -3616777315386808992L;
	
	public InvalidProbeCoordinateException() {
		super("Invalid probe coordinate exception");
	}
	
	public InvalidProbeCoordinateException(final String message) {
		super(message);
	}

}
