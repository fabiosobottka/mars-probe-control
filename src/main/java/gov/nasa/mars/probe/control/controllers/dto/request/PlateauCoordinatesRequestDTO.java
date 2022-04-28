package gov.nasa.mars.probe.control.controllers.dto.request;

import javax.validation.constraints.NotNull;

import gov.nasa.mars.probe.control.exceptions.InvalidPlateauCoordinateException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Plateau coordinates information request")
public class PlateauCoordinatesRequestDTO {

	@ApiModelProperty(notes = "Upper Right Coordinate X has to be greater than zero", example = "5" ,required = true, position = 0)
	@NotNull
	private Long upperRightCoordinateX;

	@ApiModelProperty(notes = "Upper Right Coordinate Y has to be greater than zero", example = "5", required = true, position = 1)
	@NotNull
	private Long upperRightCoordinateY;

	public PlateauCoordinatesRequestDTO() {}

	public PlateauCoordinatesRequestDTO(
			final Long upperRightCoordinateX,
			final Long upperRightCoordinateY) {
		super();
		this.upperRightCoordinateX = upperRightCoordinateX;
		this.upperRightCoordinateY = upperRightCoordinateY;
	}

	public Long getUpperRightCoordinateX() {
		return upperRightCoordinateX;
	}

	public Long getUpperRightCoordinateY() {
		return upperRightCoordinateY;
	}

	public void setUpperRightCoordinateX(final Long upperRightCoordinateX) {
		
		if(upperRightCoordinateX <= 0)
			throw new InvalidPlateauCoordinateException("Upper right coordinate X has to be greater than zero");
		
		this.upperRightCoordinateX = upperRightCoordinateX;
	}

	public void setUpperRightCoordinateY(final Long upperRightCoordinateY) {
		
		if(upperRightCoordinateY <= 0)
			throw new InvalidPlateauCoordinateException("Upper right coordinate Y has to be greater than zero");
		
		this.upperRightCoordinateY = upperRightCoordinateY;
	}

}
