package gov.nasa.mars.rover.control.entities;

import gov.nasa.mars.rover.control.exceptions.InvalidRoverCoordinateException;

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

	public void setValue(final Long value) throws InvalidRoverCoordinateException {
		
		if(value < 0)
			throw new InvalidRoverCoordinateException();
		
		this.value = value;
	}

}
