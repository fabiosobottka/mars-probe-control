package gov.nasa.mars.probe.control.entities.builder;

import gov.nasa.mars.probe.control.entities.Probe;
import gov.nasa.mars.probe.control.entities.ProbePosition;

public class ProbeBuilder {

	private ProbePosition position;

	public static ProbeBuilder create() {
		return new ProbeBuilder();
	}

	public ProbeBuilder setPosition(final ProbePosition position) {
		this.position = position;
		return this;
	}

	public Probe build() {
		return new Probe(position);
	}

}
