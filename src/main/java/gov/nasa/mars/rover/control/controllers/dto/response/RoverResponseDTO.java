package gov.nasa.mars.rover.control.controllers.dto.response;

public class RoverResponseDTO {

	private Long id;

	private Long positionX;

	private Long positionY;

	private String direction;

	public RoverResponseDTO(Long id, Long positionX, Long positionY, String direction) {
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
	}

	public Long getId() {
		return id;
	}

	public Long getPositionX() {
		return positionX;
	}

	public Long getPositionY() {
		return positionY;
	}

	public String getDirection() {
		return direction;
	}

}
