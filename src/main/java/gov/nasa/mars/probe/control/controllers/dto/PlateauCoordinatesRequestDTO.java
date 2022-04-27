package gov.nasa.mars.probe.control.controllers.dto;

import gov.nasa.mars.probe.control.entities.Coordinate;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;

public class PlateauCoordinatesRequestDTO {

	private Coordinate upperRightCoordinateX;

	private Coordinate upperRightCoordinateY;

	public PlateauCoordinatesRequestDTO() {}

	public PlateauCoordinatesRequestDTO(
			final Coordinate upperRightCoordinateX,
			final Coordinate upperRightCoordinateY) {
		super();
		this.upperRightCoordinateX = upperRightCoordinateX;
		this.upperRightCoordinateY = upperRightCoordinateY;
	}

	public Coordinate getUpperRightCoordinateX() {
		return upperRightCoordinateX;
	}

	public Coordinate getUpperRightCoordinateY() {
		return upperRightCoordinateY;
	}

	public void setUpperRightCoordinateX(final Coordinate upperRightCoordinateX) {
		
		if(upperRightCoordinateX.getValue() <= 0)
			throw new InvalidProbeCoordinateException("Upper right coordinate X has to be greater than zero");
		
		this.upperRightCoordinateX = upperRightCoordinateX;
	}

	public void setUpperRightCoordinateY(final Coordinate upperRightCoordinateY) {
		
		if(upperRightCoordinateY.getValue() <= 0)
			throw new InvalidProbeCoordinateException("Upper right coordinate Y has to be greater than zero");
		
		this.upperRightCoordinateY = upperRightCoordinateY;
	}

}
