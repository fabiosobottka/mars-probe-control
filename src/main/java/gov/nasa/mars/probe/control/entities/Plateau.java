package gov.nasa.mars.probe.control.entities;

public class Plateau {

	private Coordinate upperRightCoordinateX;

	private Coordinate upperRightCoordinateY;

	private Coordinate bottomLeftX;

	private Coordinate bottomLeftY;

	public Plateau() {}

	public Plateau(
			final Coordinate upperRightCoordinateX, 
			final Coordinate upperRightCoordinateY, 
			final Coordinate bottomLeftX,
			final Coordinate bottomLeftY) {
		super();
		this.upperRightCoordinateX = upperRightCoordinateX;
		this.upperRightCoordinateY = upperRightCoordinateY;
		this.bottomLeftX = bottomLeftX;
		this.bottomLeftY = bottomLeftY;
	}

	public Coordinate getUpperRightCoordinateX() {
		return upperRightCoordinateX;
	}

	public void setUpperRightCoordinateX(final Coordinate upperRightCoordinateX) {
		this.upperRightCoordinateX = upperRightCoordinateX;
	}

	public Coordinate getUpperRightCoordinateY() {
		return upperRightCoordinateY;
	}

	public void setUpperRightCoordinateY(final Coordinate upperRightCoordinateY) {
		this.upperRightCoordinateY = upperRightCoordinateY;
	}

	public Coordinate getBottomLeftX() {
		return bottomLeftX;
	}

	public void setBottomLeftX(final Coordinate bottomLeftX) {
		this.bottomLeftX = bottomLeftX;
	}

	public Coordinate getBottomLeftY() {
		return bottomLeftY;
	}

	public void setBottomLeftY(final Coordinate bottomLeftY) {
		this.bottomLeftY = bottomLeftY;
	}

}
