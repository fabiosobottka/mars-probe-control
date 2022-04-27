package gov.nasa.mars.probe.control.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import gov.nasa.mars.probe.control.entities.CardinalPoint;
import gov.nasa.mars.probe.control.entities.Plateau;
import gov.nasa.mars.probe.control.entities.Probe;
import gov.nasa.mars.probe.control.entities.ProbePosition;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeCoordinateException;
import gov.nasa.mars.probe.control.exceptions.InvalidProbeInstructionsException;
import gov.nasa.mars.probe.control.fixtures.PlateauFixture;
import gov.nasa.mars.probe.control.fixtures.ProbeFixture;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExploreMarsUnitTest {

	@InjectMocks
	private ExploreMars exploreMars;

	@Test
	public void shouldExploreMarsTestCase01() throws Exception {

		final Probe probe = ProbeFixture.withSpecifications(1, 2, CardinalPoint.NORTH);
		final Plateau plateau = PlateauFixture.defaultValues();

		final ProbePosition position = exploreMars.execute(probe, plateau, "LMLMLMLMM");

		assertEquals(1, position.getCoordinateX().getValue());
		assertEquals(3, position.getCoordinateY().getValue());
		assertEquals(CardinalPoint.NORTH, position.getCardinalPoint());
	}

	@Test
	public void shouldExploreMarsTestCase02() throws Exception {

		final Probe probe = ProbeFixture.withSpecifications(3, 3, CardinalPoint.EAST);
		final Plateau plateau = PlateauFixture.defaultValues();

		final ProbePosition position = exploreMars.execute(probe, plateau, "MMRMMRMRRM");

		assertEquals(5, position.getCoordinateX().getValue());
		assertEquals(1, position.getCoordinateY().getValue());
		assertEquals(CardinalPoint.EAST, position.getCardinalPoint());
	}

	@Test()
	public void shouldThrowInvalidInstructionsException() {

		assertThrows(InvalidProbeInstructionsException.class, () -> {

			final Probe probe = ProbeFixture.withSpecifications(3, 3, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(probe, plateau, "MMRMMRMRRMJD");

		});
	}
	
	@Test()
	public void shouldThrowInvalidCoordenateException() {

		assertThrows(InvalidProbeCoordinateException.class, () -> {

			final Probe probe = ProbeFixture.withSpecifications(-3, 3, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(probe, plateau, "MMRMMRMRRM");

		});
	}

}
