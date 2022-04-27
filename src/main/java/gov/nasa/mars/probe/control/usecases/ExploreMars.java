package gov.nasa.mars.probe.control.usecases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import gov.nasa.mars.probe.control.entities.CardinalPoint;
import gov.nasa.mars.probe.control.entities.Plateau;
import gov.nasa.mars.probe.control.entities.Probe;
import gov.nasa.mars.probe.control.entities.ProbePosition;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeInstructionsException;

@Service
public class ExploreMars {

	public ProbePosition execute(final Probe probe, final Plateau plateau, final String commands) throws Exception {

		validateProbeExploringInstructions(commands);

		final char[] commandsArray = commands.toCharArray();
		for (char direction : commandsArray) {

			switch (direction) {
			case 'L':
				moveNinetyDegreesToLeft(probe);
				break;
			case 'R':
				moveNinetyDegreesToRight(probe);
				break;
			case 'M':
				moveForward(probe, plateau);
				break;
			default:
				break;
			}
		}

		return probe.getPosition();
	}

	//
	// private
	//

	private void validateProbeExploringInstructions(final String commands) {

		final Pattern pattern = Pattern.compile("[LRM]+");
		final Matcher matcher = pattern.matcher(commands);
		
		if(!matcher.matches())
			throw new InvalidProbeInstructionsException();
	}

	private void moveForward(final Probe probe, final Plateau plateau) throws InvalidProbeCoordinateException {

		final CardinalPoint cardinalPoint = probe.getPosition().getCardinalPoint();
		final Integer probeUpperRightCoordinateY = plateau.getUpperRightCoordinateY().getValue();
		final Integer probeUpperRightCoordinateX = plateau.getUpperRightCoordinateX().getValue();

		Integer probeCoordinateY;
		Integer probeCoordinateX;

		switch (cardinalPoint) {
		case NORTH:
			probeCoordinateY = probe.getPosition().getCoordinateY().getValue();
			if (probeCoordinateY < probeUpperRightCoordinateY) {
				probe.getPosition().getCoordinateY().setValue(probeCoordinateY+1);
			}
			break;
		case EAST:
			probeCoordinateX = probe.getPosition().getCoordinateX().getValue();
			if (probeCoordinateX < probeUpperRightCoordinateX) {
				probe.getPosition().getCoordinateX().setValue(probeCoordinateX+1);
			}
			break;
		case SOUTH:
			probeCoordinateY = probe.getPosition().getCoordinateY().getValue();
			if (probeCoordinateY > 0) {
				probe.getPosition().getCoordinateY().setValue(probeCoordinateY-1);
			}
			break;
		case WEST:
			probeCoordinateX = probe.getPosition().getCoordinateX().getValue();
			if (probeCoordinateX > 0) {
				probe.getPosition().getCoordinateX().setValue(probeCoordinateX-1);
			}
			break;
		default:
			break;
		}

	}

	private void moveNinetyDegreesToRight(final Probe probe) {

		final CardinalPoint cardinalPoint = probe.getPosition().getCardinalPoint();

		switch (cardinalPoint) {
		case NORTH:
			probe.getPosition().setCardinalPoint(CardinalPoint.EAST);
			break;
		case EAST:
			probe.getPosition().setCardinalPoint(CardinalPoint.SOUTH);
			break;
		case SOUTH:
			probe.getPosition().setCardinalPoint(CardinalPoint.WEST);
			break;
		case WEST:
			probe.getPosition().setCardinalPoint(CardinalPoint.NORTH);
			break;
		default:
			break;
		}

	}

	private void moveNinetyDegreesToLeft(final Probe probe) {

		final CardinalPoint cardinalPoint = probe.getPosition().getCardinalPoint();

		switch (cardinalPoint) {
		case NORTH:
			probe.getPosition().setCardinalPoint(CardinalPoint.WEST);
			break;
		case WEST:
			probe.getPosition().setCardinalPoint(CardinalPoint.SOUTH);
			break;
		case SOUTH:
			probe.getPosition().setCardinalPoint(CardinalPoint.EAST);
			break;
		case EAST:
			probe.getPosition().setCardinalPoint(CardinalPoint.NORTH);
			break;
		default:
			break;
		}

	}

}
