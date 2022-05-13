package gov.nasa.mars.rover.control.exceptions;

public class InvalidPlateauPositionException extends RuntimeException {

	private static final long serialVersionUID = -1719133155615773072L;
	
	public InvalidPlateauPositionException() {
		super("Upper right position has to be greater than zero");
	}

	public InvalidPlateauPositionException(final String message) {
		super(message);
	}

}
