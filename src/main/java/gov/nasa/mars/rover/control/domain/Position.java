package gov.nasa.mars.rover.control.domain;

public class Position {

	private Long x;

	private Long y;

	public Position(final Long x, final Long y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(final Direction direction, final Plateau plateau) {
		
		final Long upperRightPositionX = plateau.getUpperRightPosition().getX();
		final Long upperRightPositionY = plateau.getUpperRightPosition().getY();
		final Long bottomLeftPositionX = plateau.getBottomLeftPosition().getX();
		final Long bottomLeftPositionY = plateau.getBottomLeftPosition().getY();
		
		switch (direction) {
		case NORTH:
			if(this.y < upperRightPositionY) {
				this.y++;
			}
			break;
		case EAST:
			if(this.x < upperRightPositionX) {
				this.x++;
			}
			break;
		case SOUTH:
			if(this.y > bottomLeftPositionY) {
				this.y--;
			}
			break;
		case WEST:
			if(this.x > bottomLeftPositionX) {
				this.x--;
			}
			break;
		default:
			break;
		}
	}

	public Long getX() {
		return x;
	}

	public Long getY() {
		return y;
	}

}
