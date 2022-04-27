package gov.nasa.mars.probe.control.entities;

import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;

public class Coordinate {

	private Integer value;

	public Coordinate() {}

	public Coordinate(final Integer value) {
		super();
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(final Integer value) throws InvalidProbeCoordinateException {
		
		if(value < 0)
			throw new InvalidProbeCoordinateException();
		
		this.value = value;
	}

}
