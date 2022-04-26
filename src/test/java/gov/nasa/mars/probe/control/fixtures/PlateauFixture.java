package gov.nasa.mars.probe.control.fixtures;

import gov.nasa.mars.probe.control.entities.Plateau;
import gov.nasa.mars.probe.control.entities.builder.CoordinateBuilder;
import gov.nasa.mars.probe.control.entities.builder.PlateauBuilder;

public class PlateauFixture {

	public static Plateau defaultValues() {
		return PlateauBuilder.create()
				.setBottomLeftX(CoordinateBuilder.create()
						.setValue(0)
						.build())
				.setBottomLeftY(CoordinateBuilder.create()
						.setValue(0)
						.build())
				.setUpperRightCoordinateX(CoordinateBuilder.create()
						.setValue(5)
						.build())
				.setUpperRightCoordinateY(CoordinateBuilder.create()
						.setValue(5)
						.build())
				.build();
	}

}
