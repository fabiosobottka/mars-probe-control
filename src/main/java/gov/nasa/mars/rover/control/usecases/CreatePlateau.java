package gov.nasa.mars.rover.control.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nasa.mars.rover.control.controllers.dto.request.PlateauUpperRightPositionRequestDTO;
import gov.nasa.mars.rover.control.domain.Plateau;
import gov.nasa.mars.rover.control.domain.Position;
import gov.nasa.mars.rover.control.gateways.database.providers.PlateauDatabaseProvider;

@Service
public class CreatePlateau {
	
	@Autowired
	private PlateauDatabaseProvider databaseProvider;

	public Plateau execute(final PlateauUpperRightPositionRequestDTO plateauUpperRightPosition) {
		final Plateau plateau = buildPlateau(plateauUpperRightPosition);
		return databaseProvider.createPlateau(plateau);
	}

	private Plateau buildPlateau(final PlateauUpperRightPositionRequestDTO plateauUpperRightPosition) {
		
		final Position upperRightPerimeterPosition = 
				new Position(plateauUpperRightPosition.getUpperRightPositionX(), plateauUpperRightPosition.getUpperRightPositionY());
		
		final Position bottomLeftPerimeterPosition = 
				new Position(0L, 0L);
		
		return new Plateau(null, upperRightPerimeterPosition, bottomLeftPerimeterPosition);
	}

}
