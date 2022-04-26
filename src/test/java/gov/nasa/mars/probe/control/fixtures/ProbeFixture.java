package gov.nasa.mars.probe.control.fixtures;

import gov.nasa.mars.probe.control.entities.CardinalPoint;
import gov.nasa.mars.probe.control.entities.Probe;
import gov.nasa.mars.probe.control.entities.builder.CoordinateBuilder;
import gov.nasa.mars.probe.control.entities.builder.ProbeBuilder;
import gov.nasa.mars.probe.control.entities.builder.ProbePositionBuilder;

public class ProbeFixture {

	public static Probe defaultValues() {
		return ProbeBuilder.create()
				.setPosition(
						ProbePositionBuilder.create()
							.setCoordinateX(CoordinateBuilder.create()
									.setValue(1)
									.build())
							.setCoordinateY(CoordinateBuilder.create()
									.setValue(2)
									.build())
							.setCardinalPoint(CardinalPoint.NORTH)
							.build())
				.build();
	}
	
	public static Probe withSpecifications(
			final Integer coordinateX, 
			final Integer coordinateY, 
			final CardinalPoint cardinalPoint) {
		
		return ProbeBuilder.create()
				.setPosition(
						ProbePositionBuilder.create()
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
