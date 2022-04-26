package gov.nasa.mars.probe.control.entities;

public class Probe {

	private ProbePosition position;

	public Probe() {}

	public Probe(final ProbePosition position) {
		super();
		this.position = position;
	}

	public ProbePosition getPosition() {
		return position;
	}

	public void setPosition(final ProbePosition position) {
		this.position = position;
	}

}
