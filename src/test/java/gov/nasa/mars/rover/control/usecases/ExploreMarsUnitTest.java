package gov.nasa.mars.rover.control.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import gov.nasa.mars.rover.control.domain.Direction;
import gov.nasa.mars.rover.control.domain.Rover;
import gov.nasa.mars.rover.control.exceptions.InvalidPlateauPositionException;
import gov.nasa.mars.rover.control.exceptions.InvalidPositionException;
import gov.nasa.mars.rover.control.exceptions.InvalidRoverInstructionsException;
import gov.nasa.mars.rover.control.fixtures.RoverFixture;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExploreMarsUnitTest {

	@InjectMocks
	private ExplorePlanet explorePlanet;

	@Test
	public void shouldExploreMarsTestCase01() throws Exception {

		Rover rover = RoverFixture.withSpecifications(1L, 2L, Direction.NORTH);

		rover = explorePlanet.execute(rover, "LMLMLMLMM");

		assertEquals(1, rover.getPosition().getX());
		assertEquals(3, rover.getPosition().getY());
		assertEquals(Direction.NORTH, rover.getDirection());
	}

	@Test
	public void shouldExploreMarsTestCase02() throws Exception {

		Rover rover = RoverFixture.withSpecifications(3L, 3L, Direction.EAST);

		rover = explorePlanet.execute(rover, "MMRMMRMRRM");

		assertEquals(5, rover.getPosition().getX());
		assertEquals(1, rover.getPosition().getY());
		assertEquals(Direction.EAST, rover.getDirection());
	}

	@Test()
	public void shouldThrowInvalidRoverInstructionsException() {

		assertThrows(InvalidRoverInstructionsException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(3L, 3L, Direction.EAST);

			explorePlanet.execute(rover, "MMRMMRMRRMJD");

		});
	}
	
	@Test()
	public void shouldThrowInvalidRoverCoordenateExceptionTestCase01() {

		assertThrows(InvalidPositionException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(-3L, 3L, Direction.EAST);

			explorePlanet.execute(rover, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidRoverCoordenateExceptionTestCase02() {

		assertThrows(InvalidPositionException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(3L, -3L, Direction.EAST);

			explorePlanet.execute(rover, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidPlateauCoordenateExceptionTestCase01() {

		assertThrows(InvalidPlateauPositionException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(1L, 2L, Direction.EAST);

			explorePlanet.execute(rover, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidPlateauCoordenateExceptionTestCase02() {

		assertThrows(InvalidPlateauPositionException.class, () -> {

			final Rover rover = RoverFixture.withSpecifications(1L, 2L, Direction.EAST);

			explorePlanet.execute(rover, "MMRMMRMRRM");

		});
	}

}
