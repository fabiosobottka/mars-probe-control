package gov.nasa.mars.rover.control.exceptions;

public class InvalidPositionException extends RuntimeException {

	private static final long serialVersionUID = -3616777315386808992L;
	
	public InvalidPositionException() {
		super("Invalid rover coordinate exception");
	}
	
	public InvalidPositionException(final String message) {
		super(message);
	}

}
