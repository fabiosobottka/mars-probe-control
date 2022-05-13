package gov.nasa.mars.rover.control.domain;

public class Plateau {

	private Long id;

	private Position upperRightPosition;

	private Position bottomLeftPosition;

	public Plateau(final Long id, final Position upperRightPosition, final Position bottomLeftPosition) {
		this.id = id;
		this.upperRightPosition = upperRightPosition;
		this.bottomLeftPosition = bottomLeftPosition;
	}

	public Long getId() {
		return id;
	}

	public Position getUpperRightPosition() {
		return upperRightPosition;
	}

	public Position getBottomLeftPosition() {
		return bottomLeftPosition;
	}

}
