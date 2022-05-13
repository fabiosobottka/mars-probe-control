package gov.nasa.mars.rover.control.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nasa.mars.rover.control.controllers.dto.request.RoverInstructionsRequestDTO;
import gov.nasa.mars.rover.control.controllers.dto.request.RoverPositionRequestDTO;
import gov.nasa.mars.rover.control.domain.Direction;
import gov.nasa.mars.rover.control.domain.Plateau;
import gov.nasa.mars.rover.control.domain.Position;
import gov.nasa.mars.rover.control.domain.Rover;
import gov.nasa.mars.rover.control.gateways.database.providers.RoverDatabaseProvider;

@Service
public class CreateRover {

	@Autowired
	private RoverDatabaseProvider roverDatabaseProvider;

	public Rover execute(final RoverInstructionsRequestDTO roverInstructionRequest, final Plateau plateau) {
		final Rover rover = buildRover(roverInstructionRequest, plateau);
		return roverDatabaseProvider.createRover(rover);
	}

	private Rover buildRover(final RoverInstructionsRequestDTO roverInstructionRequest, final Plateau plateau) {
		
		final RoverPositionRequestDTO roverPositionRequest = roverInstructionRequest.getRoverPosition();
		
		final Position position = new Position(roverPositionRequest.getX(), roverPositionRequest.getY());
		final Direction direction = Direction.valueOf(roverPositionRequest.getDirection());
		
		final Rover rover = new Rover(null, plateau, direction);
		rover.registerPosition(position);
		
		return rover;
	}

}
