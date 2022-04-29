package gov.nasa.mars.rover.control.controllers.dto.response;

import gov.nasa.mars.rover.control.entities.CardinalPoint;

public class RoverPositionRespondeDTO {

	private Long coordinateX;

	private Long coordinateY;

	private CardinalPoint cardinalPoint;

	public RoverPositionRespondeDTO(final Long coordinateX, final Long coordinateY, final CardinalPoint cardinalPoint) {
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
