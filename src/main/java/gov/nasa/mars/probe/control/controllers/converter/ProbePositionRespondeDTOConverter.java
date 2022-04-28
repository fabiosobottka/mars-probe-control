package gov.nasa.mars.probe.control.controllers.converter;

import gov.nasa.mars.probe.control.controllers.dto.response.ProbePositionRespondeDTO;
import gov.nasa.mars.probe.control.controllers.dto.response.builder.ProbePositionRespondeDTOBuilder;
import gov.nasa.mars.probe.control.entities.ProbePosition;

public class ProbePositionRespondeDTOConverter {
	
	public static ProbePositionRespondeDTO toDTO(final ProbePosition probePosition) {

        return ProbePositionRespondeDTOBuilder.create()
        		.setCoordinateX(probePosition.getCoordinateX().getValue())
        		.setCoordinateY(probePosition.getCoordinateY().getValue())
        		.setCardinalPoint(probePosition.getCardinalPoint())
        		.build();
    }

}
