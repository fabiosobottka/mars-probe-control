package gov.nasa.mars.rover.control.controllers.dto.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class RoverPositionRequestDTO {

	@ApiModelProperty(notes = "Hover position coordinate X", example = "1", required = true, position = 0)
	@NotNull
	private Long x;

	@ApiModelProperty(notes = "Hover position coordinate Y", example = "2", required = true, position = 1)
	@NotNull
	private Long y;

	@ApiModelProperty(notes = "Hover position cardinal point", example = "NORTH", required = true, position = 2)
	@NotNull
	private String direction;

	public RoverPositionRequestDTO() {}

	public RoverPositionRequestDTO(
			final Long x, 
			final Long y,
			final String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Long getX() {
		return x;
	}

	public Long getY() {
		return y;
	}

	public String getDirection() {
		return direction;
	}

	public void setX(final Long x) {
		this.x = x;
	}

	public void setY(final Long y) {
		this.y = y;
	}

	public void setDirection(final String direction) {
		this.direction = direction;
	}

}
