package gov.nasa.mars.probe.control.entities.builder;

import gov.nasa.mars.probe.control.entities.CardinalPoint;
import gov.nasa.mars.probe.control.entities.Coordinate;
import gov.nasa.mars.probe.control.entities.ProbePosition;

public class ProbePositionBuilder {

	private Coordinate coordinateX;

	private Coordinate coordinateY;

	private CardinalPoint cardinalPoint;

	public static ProbePositionBuilder create() {
		return new ProbePositionBuilder();
	}

	public ProbePositionBuilder setCoordinateX(final Coordinate coordinateX) {
		this.coordinateX = coordinateX;
		return this;
	}

	public ProbePositionBuilder setCoordinateY(final Coordinate coordinateY) {
		this.coordinateY = coordinateY;
		return this;
	}

	public ProbePositionBuilder setCardinalPoint(final CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
		return this;
	}

	public ProbePosition build() {
		return new ProbePosition(coordinateX, coordinateY, cardinalPoint);
	}

}
