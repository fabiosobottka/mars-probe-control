package gov.nasa.mars.rover.control.entities.builder;

import gov.nasa.mars.rover.control.entities.Coordinate;
import gov.nasa.mars.rover.control.entities.Plateau;

public class PlateauBuilder {

	private Coordinate upperRightCoordinateX;

	private Coordinate upperRightCoordinateY;

	private Coordinate bottomLeftX;

	private Coordinate bottomLeftY;

	public static PlateauBuilder create() {
		return new PlateauBuilder();
	}

	public PlateauBuilder setUpperRightCoordinateX(final Coordinate upperRightCoordinateX) {
		this.upperRightCoordinateX = upperRightCoordinateX;
		return this;
	}

	public PlateauBuilder setUpperRightCoordinateY(final Coordinate upperRightCoordinateY) {
		this.upperRightCoordinateY = upperRightCoordinateY;
		return this;
	}

	public PlateauBuilder setBottomLeftX(final Coordinate bottomLeftX) {
		this.bottomLeftX = bottomLeftX;
		return this;
	}

	public PlateauBuilder setBottomLeftY(final Coordinate bottomLeftY) {
		this.bottomLeftY = bottomLeftY;
		return this;
	}

	public Plateau build() {
		return new Plateau(upperRightCoordinateX, upperRightCoordinateY, bottomLeftX, bottomLeftY);
	}

}
