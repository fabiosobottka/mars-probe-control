package gov.nasa.mars.rover.control.controllers.dto.request;

import javax.validation.constraints.NotNull;

import gov.nasa.mars.rover.control.exceptions.InvalidPlateauPositionException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Plateau coordinates information request")
public class PlateauUpperRightPositionRequestDTO {

	@ApiModelProperty(notes = "Upper Right Coordinate X has to be greater than zero", example = "5" ,required = true, position = 0)
	@NotNull
	private Long upperRightPositionX;

	@ApiModelProperty(notes = "Upper Right Coordinate Y has to be greater than zero", example = "5", required = true, position = 1)
	@NotNull
	private Long upperRightPositionY;

	public PlateauUpperRightPositionRequestDTO() {}

	public PlateauUpperRightPositionRequestDTO(
			final Long upperRightCoordinateX,
			final Long upperRightCoordinateY) {
		super();
		this.upperRightPositionX = upperRightCoordinateX;
		this.upperRightPositionY = upperRightCoordinateY;
	}

	public Long getUpperRightPositionX() {
		return upperRightPositionX;
	}

	public Long getUpperRightPositionY() {
		return upperRightPositionY;
	}

	public void setUpperRightPositionX(final Long upperRightCoordinateX) {
		
		if(upperRightCoordinateX <= 0)
			throw new InvalidPlateauPositionException("Upper right coordinate X has to be greater than zero");
		
		this.upperRightPositionX = upperRightCoordinateX;
	}

	public void setUpperRightPositionY(final Long upperRightCoordinateY) {
		
		if(upperRightCoordinateY <= 0)
			throw new InvalidPlateauPositionException("Upper right coordinate Y has to be greater than zero");
		
		this.upperRightPositionY = upperRightCoordinateY;
	}

}
