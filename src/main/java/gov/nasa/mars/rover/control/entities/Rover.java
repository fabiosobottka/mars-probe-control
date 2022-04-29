package gov.nasa.mars.rover.control.entities;

public class Rover {

	private RoverPosition position;

	public Rover() {}

	public Rover(final RoverPosition position) {
		super();
		this.position = position;
	}

	public RoverPosition getPosition() {
		return position;
	}

	public void setPosition(final RoverPosition position) {
		this.position = position;
	}

}
