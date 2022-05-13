package gov.nasa.mars.rover.control.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import gov.nasa.mars.rover.control.exceptions.InvalidPositionException;
import gov.nasa.mars.rover.control.exceptions.InvalidRoverInstructionsException;
import gov.nasa.mars.rover.control.exceptions.InvalidPlateauPositionException;
import gov.nasa.mars.rover.control.exceptions.domain.StandardErrorResponse;
import gov.nasa.mars.rover.control.exceptions.domain.builder.StandardErrorResponseBuilder;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	private static Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(value = { InvalidRoverInstructionsException.class })
	protected ResponseEntity<Object> handleConflict(final InvalidRoverInstructionsException exception, final WebRequest request) {

		log.error("InvalidRoverInstructionsException", exception);
		final StandardErrorResponse response = StandardErrorResponseBuilder.create()
				.setStatus(400)
				.setMessage(exception.getMessage())
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(value = { InvalidPositionException.class })
	protected ResponseEntity<Object> handleConflict(final InvalidPositionException exception, final WebRequest request) {

		log.error("InvalidRoverCoordinateException", exception);
		
		final StandardErrorResponse response = StandardErrorResponseBuilder.create()
				.setStatus(400)
				.setMessage(exception.getMessage())
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(value = { InvalidPlateauPositionException.class })
	protected ResponseEntity<Object> handleConflict(final InvalidPlateauPositionException exception, final WebRequest request) {

		log.error("InvalidPlateauCoordinateException", exception);
		
		final StandardErrorResponse response = StandardErrorResponseBuilder.create()
				.setStatus(400)
				.setMessage(exception.getMessage())
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}
