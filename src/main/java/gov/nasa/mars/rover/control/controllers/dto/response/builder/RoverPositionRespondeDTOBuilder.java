package gov.nasa.mars.rover.control.controllers.dto.response.builder;

import gov.nasa.mars.rover.control.controllers.dto.response.RoverPositionRespondeDTO;
import gov.nasa.mars.rover.control.entities.CardinalPoint;

public class RoverPositionRespondeDTOBuilder {

	private Long coordinateX;

	private Long coordinateY;

	private CardinalPoint cardinalPoint;

	public static RoverPositionRespondeDTOBuilder create() {
		return new RoverPositionRespondeDTOBuilder();
	}

	public RoverPositionRespondeDTOBuilder setCoordinateX(final Long coordinateX) {
		this.coordinateX = coordinateX;
		return this;
	}

	public RoverPositionRespondeDTOBuilder setCoordinateY(final Long coordinateY) {
		this.coordinateY = coordinateY;
		return this;
	}

	public RoverPositionRespondeDTOBuilder setCardinalPoint(final CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
		return this;
	}

	public RoverPositionRespondeDTO build() {
		return new RoverPositionRespondeDTO(coordinateX, coordinateY, cardinalPoint);
	}

}
