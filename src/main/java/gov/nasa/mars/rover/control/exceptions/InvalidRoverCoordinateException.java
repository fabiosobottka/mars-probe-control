package gov.nasa.mars.rover.control.exceptions;

public class InvalidRoverCoordinateException extends RuntimeException {

	private static final long serialVersionUID = -3616777315386808992L;
	
	public InvalidRoverCoordinateException() {
		super("Invalid rover coordinate exception");
	}
	
	public InvalidRoverCoordinateException(final String message) {
		super(message);
	}

}
