package gov.nasa.mars.rover.control.fixtures;

import gov.nasa.mars.rover.control.domain.Plateau;
import gov.nasa.mars.rover.control.domain.Position;

public class PlateauFixture {

	public static Plateau defaultValues() {
		
		final Position bottomLeftPosition = new Position(0L, 0L);
		final Position upperRightPosition = new Position(5L, 5L);
		
		
		return new Plateau(1L, upperRightPosition, bottomLeftPosition);
	}
	
	public static Plateau withSpecifications(final Long upperRightCoordinateX, final Long upperRightCoordinateY) {
		
		final Position bottomLeftPosition = new Position(0L, 0L);
		final Position upperRightPosition = new Position(upperRightCoordinateX, upperRightCoordinateY);
		
		return new Plateau(1L, upperRightPosition, bottomLeftPosition);
	}

}
