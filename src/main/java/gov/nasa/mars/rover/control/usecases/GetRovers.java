package gov.nasa.mars.rover.control.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nasa.mars.rover.control.controllers.dto.response.RoverResponseDTO;
import gov.nasa.mars.rover.control.gateways.database.providers.RoverDatabaseProvider;
import gov.nasa.mars.rover.control.utils.Pagination;

@Service
public class GetRovers {
	
	@Autowired
	private RoverDatabaseProvider databaseProvider;

	public Pagination<RoverResponseDTO> execute(final Integer pageNumber, final Integer pageSize) {
		
		return databaseProvider.getAllWithPagination(pageNumber, pageSize);
	}

}
