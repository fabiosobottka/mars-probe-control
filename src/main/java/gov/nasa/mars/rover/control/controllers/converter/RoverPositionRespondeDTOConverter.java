package gov.nasa.mars.rover.control.controllers.converter;

import gov.nasa.mars.rover.control.controllers.dto.response.RoverPositionRespondeDTO;
import gov.nasa.mars.rover.control.controllers.dto.response.builder.RoverPositionRespondeDTOBuilder;
import gov.nasa.mars.rover.control.entities.RoverPosition;

public class RoverPositionRespondeDTOConverter {
	
	public static RoverPositionRespondeDTO toDTO(final RoverPosition roverPosition) {

        return RoverPositionRespondeDTOBuilder.create()
        		.setCoordinateX(roverPosition.getCoordinateX().getValue())
        		.setCoordinateY(roverPosition.getCoordinateY().getValue())
        		.setCardinalPoint(roverPosition.getCardinalPoint())
        		.build();
    }

}
