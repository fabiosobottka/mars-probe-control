package gov.nasa.mars.rover.control.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import gov.nasa.mars.rover.control.entities.CardinalPoint;
import gov.nasa.mars.rover.control.entities.Plateau;
import gov.nasa.mars.rover.control.entities.Rover;
import gov.nasa.mars.rover.control.entities.RoverPosition;
import gov.nasa.mars.rover.control.exceptions.InvalidPlateauCoordinateException;
import gov.nasa.mars.rover.control.exceptions.InvalidRoverCoordinateException;
import gov.nasa.mars.rover.control.exceptions.InvalidRoverInstructionsException;
import gov.nasa.mars.rover.control.fixtures.PlateauFixture;
import gov.nasa.mars.rover.control.fixtures.RoverFixture;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExploreMarsUnitTest {

	@InjectMocks
	private ExploreMars exploreMars;

	@Test
	public void shouldExploreMarsTestCase01() throws Exception {

		final Rover rover = RoverFixture.withSpecifications(1L, 2L, CardinalPoint.NORTH);
		final Plateau plateau = PlateauFixture.defaultValues();

		final RoverPosition position = exploreMars.execute(rover, plateau, "LMLMLMLMM");

		assertEquals(1, position.getCoordinateX().getValue());
		assertEquals(3, position.getCoordinateY().getValue());
		assertEquals(CardinalPoint.NORTH, position.getCardinalPoint());
	}

	@Test
	public void shouldExploreMarsTestCase02() throws Exception {

		final Rover rover = RoverFixture.withSpecifications(3L, 3L, CardinalPoint.EAST);
		final Plateau plateau = PlateauFixture.defaultValues();

		final RoverPosition position = exploreMars.execute(rover, plateau, "MMRMMRMRRM");

		assertEquals(5, position.getCoordinateX().getValue());
		assertEquals(1, position.getCoordinateY().getValue());
		assertEquals(CardinalPoint.EAST, position.getCardinalPoint());
	}

	@Test()
	public void shouldThrowInvalidRoverInstructionsException() {

		assertThrows(InvalidRoverInstructionsException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(3L, 3L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(rover, plateau, "MMRMMRMRRMJD");

		});
	}
	
	@Test()
	public void shouldThrowInvalidRoverCoordenateExceptionTestCase01() {

		assertThrows(InvalidRoverCoordinateException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(-3L, 3L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(rover, plateau, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidRoverCoordenateExceptionTestCase02() {

		assertThrows(InvalidRoverCoordinateException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(3L, -3L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(rover, plateau, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidPlateauCoordenateExceptionTestCase01() {

		assertThrows(InvalidPlateauCoordinateException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(1L, 2L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.withSpecifications(0L, 5L);

			exploreMars.execute(rover, plateau, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidPlateauCoordenateExceptionTestCase02() {

		assertThrows(InvalidPlateauCoordinateException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(1L, 2L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.withSpecifications(5L, 0L);

			exploreMars.execute(rover, plateau, "MMRMMRMRRM");

		});
	}

}
