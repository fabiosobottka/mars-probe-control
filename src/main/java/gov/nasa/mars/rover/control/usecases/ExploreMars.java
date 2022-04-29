package gov.nasa.mars.rover.control.usecases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gov.nasa.mars.rover.control.entities.CardinalPoint;
import gov.nasa.mars.rover.control.entities.RoverPosition;
import gov.nasa.mars.rover.control.entities.Rover;
import gov.nasa.mars.rover.control.entities.Plateau;
import gov.nasa.mars.rover.control.exceptions.InvalidRoverCoordinateException;
import gov.nasa.mars.rover.control.exceptions.InvalidRoverInstructionsException;
import gov.nasa.mars.rover.control.exceptions.InvalidPlateauCoordinateException;

@Service
public class ExploreMars {
	
	private static Logger log = LoggerFactory.getLogger(ExploreMars.class);

	public RoverPosition execute(final Rover rover, final Plateau plateau, final String commands) throws Exception {

		log.info("Validating rover...");
		validateRover(rover);
		
		log.info("Validating plateau...");
		validatePlateau(plateau);
		
		log.info("Validating rover explore instructions...");
		validateRoverExploreInstructions(commands);
		
		final char[] commandsArray = commands.toCharArray();
		
		for (char roverCommand : commandsArray) {

			switch (roverCommand) {
			case 'L':
				moveNinetyDegreesToLeft(rover);
				break;
			case 'R':
				moveNinetyDegreesToRight(rover);
				break;
			case 'M':
				moveForward(rover, plateau);
				break;
			default:
				break;
			}
		}
		log.info("Exploration completed - returning position");
		return rover.getPosition();
	}

	//
	// private
	//
	
	private void validateRover(final Rover rover) {
		
		if(rover.getPosition().getCoordinateX().getValue() < 0)
			throw new InvalidRoverCoordinateException("Rover coordinate X value cannot be a negative number");
		
		if(rover.getPosition().getCoordinateY().getValue() < 0)
			throw new InvalidRoverCoordinateException("Rover coordinate Y value cannot be a negative number");
		
	}
	
	private void validatePlateau(final Plateau plateau) {
		
		if(plateau.getUpperRightCoordinateX().getValue() <= 0)
			throw new InvalidPlateauCoordinateException("Upper right coordinate X has to be greater than zero");
		
		if(plateau.getUpperRightCoordinateY().getValue() <= 0)
			throw new InvalidPlateauCoordinateException("Upper right coordinate Y has to be greater than zero");
		
	}

	private void validateRoverExploreInstructions(final String commands) {

		final Pattern pattern = Pattern.compile("[LRM]+");
		final Matcher matcher = pattern.matcher(commands);
		
		if(!matcher.matches())
			throw new InvalidRoverInstructionsException();
	}

	private void moveForward(final Rover rover, final Plateau plateau) throws InvalidRoverCoordinateException {

		final CardinalPoint cardinalPointDirection = rover.getPosition().getCardinalPoint();
		final Long roverUpperRightCoordinateY = plateau.getUpperRightCoordinateY().getValue();
		final Long roverUpperRightCoordinateX = plateau.getUpperRightCoordinateX().getValue();

		Long roverCoordinateY;
		Long roverCoordinateX;

		switch (cardinalPointDirection) {
		case NORTH:
			roverCoordinateY = rover.getPosition().getCoordinateY().getValue();
			if (roverCoordinateY < roverUpperRightCoordinateY) {
				rover.getPosition().getCoordinateY().setValue(roverCoordinateY+1);
			}
			break;
		case EAST:
			roverCoordinateX = rover.getPosition().getCoordinateX().getValue();
			if (roverCoordinateX < roverUpperRightCoordinateX) {
				rover.getPosition().getCoordinateX().setValue(roverCoordinateX+1);
			}
			break;
		case SOUTH:
			roverCoordinateY = rover.getPosition().getCoordinateY().getValue();
			if (roverCoordinateY > plateau.getBottomLeftCoordinateY().getValue()) {
				rover.getPosition().getCoordinateY().setValue(roverCoordinateY-1);
			}
			break;
		case WEST:
			roverCoordinateX = rover.getPosition().getCoordinateX().getValue();
			if (roverCoordinateX > plateau.getBottomLeftCoordinateX().getValue()) {
				rover.getPosition().getCoordinateX().setValue(roverCoordinateX-1);
			}
			break;
		default:
			break;
		}
	}

	private void moveNinetyDegreesToRight(final Rover rover) {

		final CardinalPoint cardinalPointDirection = rover.getPosition().getCardinalPoint();

		switch (cardinalPointDirection) {
		case NORTH:
			rover.getPosition().setCardinalPoint(CardinalPoint.EAST);
			break;
		case EAST:
			rover.getPosition().setCardinalPoint(CardinalPoint.SOUTH);
			break;
		case SOUTH:
			rover.getPosition().setCardinalPoint(CardinalPoint.WEST);
			break;
		case WEST:
			rover.getPosition().setCardinalPoint(CardinalPoint.NORTH);
			break;
		default:
			break;
		}

	}

	private void moveNinetyDegreesToLeft(final Rover rover) {

		final CardinalPoint cardinalPointDirection = rover.getPosition().getCardinalPoint();

		switch (cardinalPointDirection) {
		case NORTH:
			rover.getPosition().setCardinalPoint(CardinalPoint.WEST);
			break;
		case WEST:
			rover.getPosition().setCardinalPoint(CardinalPoint.SOUTH);
			break;
		case SOUTH:
			rover.getPosition().setCardinalPoint(CardinalPoint.EAST);
			break;
		case EAST:
			rover.getPosition().setCardinalPoint(CardinalPoint.NORTH);
			break;
		default:
			break;
		}
	}

}
