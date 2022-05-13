package gov.nasa.mars.rover.control.exceptions;

public class InvalidDirectionException extends RuntimeException {

	private static final long serialVersionUID = 4021913891705945630L;
	
	public InvalidDirectionException(String message) {
		super(message);
	}

}
