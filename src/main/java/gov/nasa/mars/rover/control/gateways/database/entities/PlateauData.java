package gov.nasa.mars.rover.control.gateways.database.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Plateau")
public class PlateauData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "upper_right_perimeter_position_x")
	private Long upperRightPositionX;

	@Column(name = "upper_right_perimeter_position_y")
	private Long upperRightPositionY;

	@Column(name = "bottom_left_perimeter_position_x")
	private Long bottomLeftPositionX;

	@Column(name = "bottom_left_perimeter_position_y")
	private Long bottomLeftPositionY;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	public PlateauData() {}

	public PlateauData(
			final Long id, 
			final Long upperRightPositionX, 
			final Long upperRightPositionY, 
			final Long bottomLeftPositionX,
			final Long bottomLeftPositionY, 
			final LocalDateTime createdAt, 
			final LocalDateTime updatedAt) {
		this.id = id;
		this.upperRightPositionX = upperRightPositionX;
		this.upperRightPositionY = upperRightPositionY;
		this.bottomLeftPositionX = bottomLeftPositionX;
		this.bottomLeftPositionY = bottomLeftPositionY;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public Long getUpperRightPositionX() {
		return upperRightPositionX;
	}

	public Long getUpperRightPositionY() {
		return upperRightPositionY;
	}

	public Long getBottomLeftPositionX() {
		return bottomLeftPositionX;
	}

	public Long getBottomLeftPositionY() {
		return bottomLeftPositionY;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setUpperRightPositionX(final Long upperRightPositionX) {
		this.upperRightPositionX = upperRightPositionX;
	}

	public void setUpperRightPositionY(final Long upperRightPositionY) {
		this.upperRightPositionY = upperRightPositionY;
	}

	public void setBottomLeftPositionX(final Long bottomLeftPositionX) {
		this.bottomLeftPositionX = bottomLeftPositionX;
	}

	public void setBottomLeftPositionY(final Long bottomLeftPositionY) {
		this.bottomLeftPositionY = bottomLeftPositionY;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(final LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
