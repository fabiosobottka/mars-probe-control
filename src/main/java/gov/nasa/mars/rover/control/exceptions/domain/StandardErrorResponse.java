package gov.nasa.mars.rover.control.exceptions.domain;

public class StandardErrorResponse {

	private Integer status;
	private String message;

	public StandardErrorResponse() {}

	public StandardErrorResponse(final Integer status, final String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(final Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}
