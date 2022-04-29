package gov.nasa.mars.rover.control.fixtures;

import gov.nasa.mars.rover.control.entities.Plateau;
import gov.nasa.mars.rover.control.entities.builder.CoordinateBuilder;
import gov.nasa.mars.rover.control.entities.builder.PlateauBuilder;

public class PlateauFixture {

	public static Plateau defaultValues() {
		return PlateauBuilder.create()
				.setBottomLeftX(CoordinateBuilder.create()
						.setValue(0L)
						.build())
				.setBottomLeftY(CoordinateBuilder.create()
						.setValue(0L)
						.build())
				.setUpperRightCoordinateX(CoordinateBuilder.create()
						.setValue(5L)
						.build())
				.setUpperRightCoordinateY(CoordinateBuilder.create()
						.setValue(5L)
						.build())
				.build();
	}
	
	public static Plateau withSpecifications(final Long upperRightCoordinateX, final Long upperRightCoordinateY) {
		return PlateauBuilder.create()
				.setBottomLeftX(CoordinateBuilder.create()
						.setValue(0L)
						.build())
				.setBottomLeftY(CoordinateBuilder.create()
						.setValue(0L)
						.build())
				.setUpperRightCoordinateX(CoordinateBuilder.create()
						.setValue(upperRightCoordinateX)
						.build())
				.setUpperRightCoordinateY(CoordinateBuilder.create()
						.setValue(upperRightCoordinateY)
						.build())
				.build();
	}

}
