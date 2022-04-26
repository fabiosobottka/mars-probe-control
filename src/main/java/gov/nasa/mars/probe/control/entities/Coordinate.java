package gov.nasa.mars.probe.control.entities;

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

	public void setValue(final Integer value) {
		this.value = value;
	}

}
