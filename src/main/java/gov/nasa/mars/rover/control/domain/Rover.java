package gov.nasa.mars.rover.control.domain;

import gov.nasa.mars.rover.control.exceptions.InvalidDirectionException;
import gov.nasa.mars.rover.control.exceptions.InvalidPositionException;

public class Rover {

	private Long id;

	private Plateau plateau;

	private Direction direction;

	private Position position;

	public Rover(final Long id, final Plateau plateau, final Direction direction) {
		this.id = id;
		this.plateau = plateau;
		this.direction = direction;
	}

	public void registerPosition(final Position position) {

		if (position.getX() < 0)
			throw new InvalidPositionException("Rover position X cannot be a negative number");

		if (position.getY() < 0)
			throw new InvalidPositionException("Rover position Y cannot be a negative number");
		
		this.position = position;
	}
	
	public void updateDirection(final Direction direction) {
		
		if(this.direction == direction)
			throw new InvalidDirectionException("Direção não pode ser a mesma");
		
		this.direction = direction;
	}

	public Long getId() {
		return id;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public Direction getDirection() {
		return direction;
	}

	public Position getPosition() {
		return position;
	}

}
