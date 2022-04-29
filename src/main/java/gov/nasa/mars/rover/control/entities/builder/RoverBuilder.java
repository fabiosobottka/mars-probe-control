package gov.nasa.mars.rover.control.entities.builder;

import gov.nasa.mars.rover.control.entities.RoverPosition;
import gov.nasa.mars.rover.control.entities.Rover;

public class RoverBuilder {

	private RoverPosition position;

	public static RoverBuilder create() {
		return new RoverBuilder();
	}

	public RoverBuilder setPosition(final RoverPosition position) {
		this.position = position;
		return this;
	}

	public Rover build() {
		return new Rover(position);
	}

}
