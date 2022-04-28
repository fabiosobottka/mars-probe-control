package gov.nasa.mars.probe.control.entities;

import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;

public class Plateau {

	private Coordinate upperRightCoordinateX;

	private Coordinate upperRightCoordinateY;

	private Coordinate bottomLeftCoordinateX;

	private Coordinate bottomLeftCoordinateY;

	public Plateau() {}

	public Plateau(
			final Coordinate upperRightCoordinateX, 
			final Coordinate upperRightCoordinateY, 
			final Coordinate bottomLeftCoordinateX,
			final Coordinate bottomLeftCoordinateY) {
		super();
		this.upperRightCoordinateX = upperRightCoordinateX;
		this.upperRightCoordinateY = upperRightCoordinateY;
		this.bottomLeftCoordinateX = bottomLeftCoordinateX;
		this.bottomLeftCoordinateY = bottomLeftCoordinateY;
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

	public Coordinate getBottomLeftCoordinateX() {
		return bottomLeftCoordinateX;
	}

	public void setBottomLeftCoordinateX(final Coordinate bottomLeftCoordinateX) {
		this.bottomLeftCoordinateX = bottomLeftCoordinateX;
	}

	public Coordinate getBottomLeftCoordinateY() {
		return bottomLeftCoordinateY;
	}

	public void setBottomLeftCoordinateY(final Coordinate bottomLeftCoordinateY) {
		this.bottomLeftCoordinateY = bottomLeftCoordinateY;
	}

}
