package gov.nasa.mars.rover.control.gateways.database.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rover")
public class RoverData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "plateau_id")
	private PlateauData plateau;

	@Column(name = "direction")
	private String direction;

	@Column(name = "position_x")
	private Long positionX;

	@Column(name = "position_y")
	private Long positionY;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	public RoverData() {}

	public RoverData(
			final Long id, 
			final PlateauData plateau, 
			final String direction, 
			final Long positionX, 
			final Long positionY,
			final LocalDateTime createdAt, 
			final LocalDateTime updatedAt) {
		this.id = id;
		this.plateau = plateau;
		this.direction = direction;
		this.positionX = positionX;
		this.positionY = positionY;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public PlateauData getPlateau() {
		return plateau;
	}

	public String getDirection() {
		return direction;
	}

	public Long getPositionX() {
		return positionX;
	}

	public Long getPositionY() {
		return positionY;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPlateau(PlateauData plateau) {
		this.plateau = plateau;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setPositionX(Long positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(Long positionY) {
		this.positionY = positionY;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
