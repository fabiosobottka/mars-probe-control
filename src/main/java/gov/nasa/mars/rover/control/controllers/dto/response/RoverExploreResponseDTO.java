package gov.nasa.mars.rover.control.controllers.dto.response;

public class RoverExploreResponseDTO {

	private Long id;

	private Long x;

	private Long y;

	private String direction;

	public RoverExploreResponseDTO(final Long id, final Long x, final Long y, final String direction) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Long getId() {
		return id;
	}

	public Long getX() {
		return x;
	}

	public Long getY() {
		return y;
	}

	public String getDirection() {
		return direction;
	}

}
