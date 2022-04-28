package gov.nasa.mars.probe.control.entities;

import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;

public class Coordinate {

	private Long value;

	public Coordinate() {}

	public Coordinate(final Long value) {
		super();
		this.value = value;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(final Long value) throws InvalidProbeCoordinateException {
		
		if(value < 0)
			throw new InvalidProbeCoordinateException();
		
		this.value = value;
	}

}
