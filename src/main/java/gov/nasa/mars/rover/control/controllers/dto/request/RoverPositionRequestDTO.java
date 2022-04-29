package gov.nasa.mars.rover.control.controllers.dto.request;

import javax.validation.constraints.NotNull;

import gov.nasa.mars.rover.control.entities.CardinalPoint;
import io.swagger.annotations.ApiModelProperty;

public class RoverPositionRequestDTO {

	@ApiModelProperty(notes = "Hover position coordinate X", example = "1", required = true, position = 0)
	@NotNull
	private Long coordinateX;

	@ApiModelProperty(notes = "Hover position coordinate Y", example = "2", required = true, position = 1)
	@NotNull
	private Long coordinateY;

	@ApiModelProperty(notes = "Hover position cardinal point", example = "NORTH", required = true, position = 2)
	@NotNull
	private CardinalPoint cardinalPoint;

	public RoverPositionRequestDTO() {}

	public RoverPositionRequestDTO(
			final Long coordinateX, 
			final Long coordinateY,
			final CardinalPoint cardinalPoint) {
		super();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.cardinalPoint = cardinalPoint;
	}

	public Long getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(final Long coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Long getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(final Long coordinateY) {
		this.coordinateY = coordinateY;
	}

	public CardinalPoint getCardinalPoint() {
		return cardinalPoint;
	}

	public void setCardinalPoint(final CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
	}

}
