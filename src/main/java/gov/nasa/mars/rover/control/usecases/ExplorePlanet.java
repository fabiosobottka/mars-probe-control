package gov.nasa.mars.rover.control.usecases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nasa.mars.rover.control.domain.Rover;
import gov.nasa.mars.rover.control.exceptions.InvalidRoverInstructionsException;
import gov.nasa.mars.rover.control.gateways.database.providers.RoverDatabaseProvider;

@Service
public class ExplorePlanet {
	
	private static Logger log = LoggerFactory.getLogger(ExplorePlanet.class);
	
	@Autowired
	private RoverDatabaseProvider databaseProvider;

	public Rover execute(final Rover rover, final String commands) throws Exception {
		
		log.info("Validating rover explore instructions...");
		validateRoverExploreInstructions(commands);
		
		final char[] commandsArray = commands.toCharArray();
		
		for (char roverCommand : commandsArray) {

			switch (roverCommand) {
			case 'L':
				rover.updateDirection(rover.getDirection().moveToLeft());
				break;
			case 'R':
				rover.updateDirection(rover.getDirection().moveToRight());
				break;
			case 'M':
				rover.getPosition().move(rover.getDirection(), rover.getPlateau());
				break;
			default:
				break;
			}
		}
		
		databaseProvider.update(rover);
		
		log.info("Exploration completed");
		return rover;
	}

	//
	// private
	//
	
	private void validateRoverExploreInstructions(final String commands) {

		final Pattern pattern = Pattern.compile("[LRM]+");
		final Matcher matcher = pattern.matcher(commands);
		
		if(!matcher.matches())
			throw new InvalidRoverInstructionsException();
	}

}
