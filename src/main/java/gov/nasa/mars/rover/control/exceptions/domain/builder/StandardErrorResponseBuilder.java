package gov.nasa.mars.rover.control.exceptions.domain.builder;

import gov.nasa.mars.rover.control.exceptions.domain.StandardErrorResponse;

public class StandardErrorResponseBuilder {

	private Integer status;
	private String message;

	public static StandardErrorResponseBuilder create() {
		return new StandardErrorResponseBuilder();
	}

	public StandardErrorResponseBuilder setStatus(final Integer status) {
		this.status = status;
		return this;
	}

	public StandardErrorResponseBuilder setMessage(final String message) {
		this.message = message;
		return this;
	}
	
	public StandardErrorResponse build() {
		return new StandardErrorResponse(status, message);
	}

}
