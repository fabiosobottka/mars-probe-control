package gov.nasa.mars.rover.control.domain;

public enum Direction {

	NORTH('N') {
		@Override
		public Direction moveToLeft() {
			return Direction.WEST;
		}

		@Override
		public Direction moveToRight() {
			return Direction.EAST;
		}
	}, 
	EAST('L') {

		@Override
		public Direction moveToLeft() {
			return Direction.NORTH;
		}

		@Override
		public Direction moveToRight() {
			return Direction.SOUTH;
		}

		
	}, 
	SOUTH('S') {

		@Override
		public Direction moveToLeft() {
			return Direction.EAST;
		}

		@Override
		public Direction moveToRight() {
			return Direction.WEST;
		}
	}, 
	WEST('O') {

		@Override
		public Direction moveToLeft() {
			return Direction.SOUTH;
		}

		@Override
		public Direction moveToRight() {
			return Direction.NORTH;
		}
		
	};
	
	private Character value;

	private Direction(final Character value) {
		this.value = value;
	}

	public Character getValue() {
		return value;
	}
	
	public abstract Direction moveToLeft();
	public abstract Direction moveToRight();
}
