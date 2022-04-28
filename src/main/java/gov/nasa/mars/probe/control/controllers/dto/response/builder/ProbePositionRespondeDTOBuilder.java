package gov.nasa.mars.probe.control.controllers.dto.response.builder;

import gov.nasa.mars.probe.control.controllers.dto.response.ProbePositionRespondeDTO;
import gov.nasa.mars.probe.control.entities.CardinalPoint;

public class ProbePositionRespondeDTOBuilder {

	private Long coordinateX;

	private Long coordinateY;

	private CardinalPoint cardinalPoint;

	public static ProbePositionRespondeDTOBuilder create() {
		return new ProbePositionRespondeDTOBuilder();
	}

	public ProbePositionRespondeDTOBuilder setCoordinateX(final Long coordinateX) {
		this.coordinateX = coordinateX;
		return this;
	}

	public ProbePositionRespondeDTOBuilder setCoordinateY(final Long coordinateY) {
		this.coordinateY = coordinateY;
		return this;
	}

	public ProbePositionRespondeDTOBuilder setCardinalPoint(final CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
		return this;
	}

	public ProbePositionRespondeDTO build() {
		return new ProbePositionRespondeDTO(coordinateX, coordinateY, cardinalPoint);
	}

}
