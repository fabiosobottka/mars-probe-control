package gov.nasa.mars.rover.control.gateways.database.providers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.nasa.mars.rover.control.domain.Plateau;
import gov.nasa.mars.rover.control.domain.Position;
import gov.nasa.mars.rover.control.gateways.database.entities.PlateauData;
import gov.nasa.mars.rover.control.gateways.database.repositories.PlateauRepository;

@Component
public class PlateauDatabaseProvider {
	
	@Autowired
	private PlateauRepository repository;

	public Plateau createPlateau(final Plateau plateau) {
		
		PlateauData plateauData = createPlateauData(plateau);
		plateauData = repository.save(plateauData);
		
		return convertToDomain(plateauData);
	}
	
	private Plateau convertToDomain(final PlateauData plateauData) {
		
		final Position upperRightPosition = 
				new Position(plateauData.getUpperRightPositionX(), plateauData.getUpperRightPositionY());
		
		final Position bottomLeft = 
				new Position(plateauData.getBottomLeftPositionX(), plateauData.getBottomLeftPositionY());
		
		return new Plateau(plateauData.getId(), upperRightPosition, bottomLeft);
	}

	private PlateauData createPlateauData(final Plateau plateau) {
		
		final Position upperRightPosition = plateau.getUpperRightPosition();
		final Position bottomLeftPosition = plateau.getBottomLeftPosition();
		
		return new PlateauData(null, upperRightPosition.getX(), upperRightPosition.getY(), bottomLeftPosition.getX(), bottomLeftPosition.getY(), LocalDateTime.now(), null);
	}

}
