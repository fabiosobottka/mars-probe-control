package gov.nasa.mars.rover.control.fixtures;

import gov.nasa.mars.rover.control.entities.CardinalPoint;
import gov.nasa.mars.rover.control.entities.Rover;
import gov.nasa.mars.rover.control.entities.builder.CoordinateBuilder;
import gov.nasa.mars.rover.control.entities.builder.RoverBuilder;
import gov.nasa.mars.rover.control.entities.builder.RoverPositionBuilder;

public class RoverFixture {

	public static Rover defaultValues() {
		return RoverBuilder.create()
				.setPosition(
						RoverPositionBuilder.create()
							.setCoordinateX(CoordinateBuilder.create()
									.setValue(1L)
									.build())
							.setCoordinateY(CoordinateBuilder.create()
									.setValue(2L)
									.build())
							.setCardinalPoint(CardinalPoint.NORTH)
							.build())
				.build();
	}
	
	public static Rover withSpecifications(
			final Long coordinateX, 
			final Long coordinateY, 
			final CardinalPoint cardinalPoint) {
		
		return RoverBuilder.create()
				.setPosition(
						RoverPositionBuilder.create()
							.setCoordinateX(CoordinateBuilder.create()
									.setValue(coordinateX)
									.build())
							.setCoordinateY(CoordinateBuilder.create()
									.setValue(coordinateY)
									.build())
							.setCardinalPoint(cardinalPoint)
							.build())
				.build();
	}

}
