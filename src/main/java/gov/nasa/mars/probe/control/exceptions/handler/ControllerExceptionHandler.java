package gov.nasa.mars.probe.control.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import gov.nasa.mars.probe.control.exceptions.InvalidPlateauCoordinateException;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeInstructionsException;
import gov.nasa.mars.probe.control.exceptions.domain.StandardErrorResponse;
import gov.nasa.mars.probe.control.exceptions.domain.builder.StandardErrorResponseBuilder;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { InvalidProbeInstructionsException.class })
	protected ResponseEntity<Object> handleConflict(final InvalidProbeInstructionsException exception, final WebRequest request) {

		final StandardErrorResponse response = StandardErrorResponseBuilder.create()
				.setStatus(400)
				.setMessage(exception.getMessage())
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(value = { InvalidProbeCoordinateException.class })
	protected ResponseEntity<Object> handleConflict(final InvalidProbeCoordinateException exception, final WebRequest request) {

		final StandardErrorResponse response = StandardErrorResponseBuilder.create()
				.setStatus(400)
				.setMessage(exception.getMessage())
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(value = { InvalidPlateauCoordinateException.class })
	protected ResponseEntity<Object> handleConflict(final InvalidPlateauCoordinateException exception, final WebRequest request) {

		final StandardErrorResponse response = StandardErrorResponseBuilder.create()
				.setStatus(400)
				.setMessage(exception.getMessage())
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}
