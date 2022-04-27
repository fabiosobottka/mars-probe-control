package gov.nasa.mars.probe.control.entities;

import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;

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

		if(upperRightCoordinateX.getValue() <= 0)
			throw new InvalidProbeCoordinateException("Upper right coordinate X has to be greater than zero");
		
		this.upperRightCoordinateX = upperRightCoordinateX;
	}

	public Coordinate getUpperRightCoordinateY() {
		return upperRightCoordinateY;
	}

	public void setUpperRightCoordinateY(final Coordinate upperRightCoordinateY) {
		
		if(upperRightCoordinateY.getValue() <= 0)
			throw new InvalidProbeCoordinateException("Upper right coordinate Y has to be greater than zero");
		
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
