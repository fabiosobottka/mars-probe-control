package gov.nasa.mars.rover.control.fixtures;

import gov.nasa.mars.rover.control.domain.Direction;
import gov.nasa.mars.rover.control.domain.Plateau;
import gov.nasa.mars.rover.control.domain.Position;
import gov.nasa.mars.rover.control.domain.Rover;

public class RoverFixture {

	public static Rover defaultValues() {
		
		
		final Plateau plateau = PlateauFixture.defaultValues();
		final Direction direction = Direction.NORTH;
		
		final Position position = new Position(1L, 2L);
		final Rover rover = new Rover(1L, plateau, direction);
		rover.registerPosition(position);
		
		return new Rover(1L, plateau, direction);
	}
	
	public static Rover withSpecifications(
			final Long coordinateX, 
			final Long coordinateY, 
			final Direction direction) {
		
		final Plateau plateau = PlateauFixture.defaultValues();
		
		final Position position = new Position(coordinateX, coordinateY);
		final Rover rover = new Rover(1L, plateau, direction);
		rover.registerPosition(position);
		return rover;
	}

}
