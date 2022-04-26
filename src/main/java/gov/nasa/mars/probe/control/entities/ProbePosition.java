package gov.nasa.mars.probe.control.entities;

public class ProbePosition {

	private Coordinate coordinateX;

	private Coordinate coordinateY;

	private CardinalPoint cardinalPoint;

	public ProbePosition() {}

	public ProbePosition(
			final Coordinate coordinateX, 
			final Coordinate coordinateY,
			final CardinalPoint cardinalPoint) {
		super();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.cardinalPoint = cardinalPoint;
	}

	public Coordinate getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(final Coordinate coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Coordinate getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(final Coordinate coordinateY) {
		this.coordinateY = coordinateY;
	}

	public CardinalPoint getCardinalPoint() {
		return cardinalPoint;
	}

	public void setCardinalPoint(final CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
	}

}
