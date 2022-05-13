package gov.nasa.mars.rover.control.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nasa.mars.rover.control.domain.Rover;
import gov.nasa.mars.rover.control.gateways.database.providers.RoverDatabaseProvider;

@Service
public class GetRoverById {
	
	@Autowired
	private RoverDatabaseProvider databaseProvider;

	public Rover execute(final Long roverId) {
		
		return databaseProvider.getById(roverId);
	}

}
