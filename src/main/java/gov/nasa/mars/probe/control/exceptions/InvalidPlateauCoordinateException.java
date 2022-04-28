package gov.nasa.mars.probe.control.exceptions;

public class InvalidPlateauCoordinateException extends RuntimeException {

	private static final long serialVersionUID = -1719133155615773072L;
	
	public InvalidPlateauCoordinateException() {
		super("Upper right coordinate has to be greater than zero");
	}

	public InvalidPlateauCoordinateException(final String message) {
		super(message);
	}

}
