package gov.nasa.mars.probe.control.entities;

public enum CardinalPoint {

	NORTH('N'), 
	EAST('L'), 
	SOUTH('S'), 
	WEST('O');
	
	private Character value;

	private CardinalPoint(final Character value) {
		this.value = value;
	}

	public Character getValue() {
		return value;
	}

}