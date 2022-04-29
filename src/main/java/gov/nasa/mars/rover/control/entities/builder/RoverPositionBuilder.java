package gov.nasa.mars.rover.control.entities.builder;

import gov.nasa.mars.rover.control.entities.CardinalPoint;
import gov.nasa.mars.rover.control.entities.Coordinate;
import gov.nasa.mars.rover.control.entities.RoverPosition;

public class RoverPositionBuilder {

	private Coordinate coordinateX;

	private Coordinate coordinateY;

	private CardinalPoint cardinalPoint;

	public static RoverPositionBuilder create() {
		return new RoverPositionBuilder();
	}

	public RoverPositionBuilder setCoordinateX(final Coordinate coordinateX) {
		this.coordinateX = coordinateX;
		return this;
	}

	public RoverPositionBuilder setCoordinateY(final Coordinate coordinateY) {
		this.coordinateY = coordinateY;
		return this;
	}

	public RoverPositionBuilder setCardinalPoint(final CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
		return this;
	}

	public RoverPosition build() {
		return new RoverPosition(coordinateX, coordinateY, cardinalPoint);
	}

}
