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
import gov.nasa.mars.probe.control.exceptions.InvalidPlateauCoordinateException;
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

		final Probe probe = ProbeFixture.withSpecifications(1L, 2L, CardinalPoint.NORTH);
		final Plateau plateau = PlateauFixture.defaultValues();

		final ProbePosition position = exploreMars.execute(probe, plateau, "LMLMLMLMM");

		assertEquals(1, position.getCoordinateX().getValue());
		assertEquals(3, position.getCoordinateY().getValue());
		assertEquals(CardinalPoint.NORTH, position.getCardinalPoint());
	}

	@Test
	public void shouldExploreMarsTestCase02() throws Exception {

		final Probe probe = ProbeFixture.withSpecifications(3L, 3L, CardinalPoint.EAST);
		final Plateau plateau = PlateauFixture.defaultValues();

		final ProbePosition position = exploreMars.execute(probe, plateau, "MMRMMRMRRM");

		assertEquals(5, position.getCoordinateX().getValue());
		assertEquals(1, position.getCoordinateY().getValue());
		assertEquals(CardinalPoint.EAST, position.getCardinalPoint());
	}

	@Test()
	public void shouldThrowInvalidProbeInstructionsException() {

		assertThrows(InvalidProbeInstructionsException.class, () -> {

			final Probe probe = ProbeFixture.withSpecifications(3L, 3L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(probe, plateau, "MMRMMRMRRMJD");

		});
	}
	
	@Test()
	public void shouldThrowInvalidProbeCoordenateExceptionTestCase01() {

		assertThrows(InvalidProbeCoordinateException.class, () -> {

			final Probe probe = ProbeFixture.withSpecifications(-3L, 3L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(probe, plateau, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidProbeCoordenateExceptionTestCase02() {

		assertThrows(InvalidProbeCoordinateException.class, () -> {

			final Probe probe = ProbeFixture.withSpecifications(3L, -3L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.defaultValues();

			exploreMars.execute(probe, plateau, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidPlateauCoordenateExceptionTestCase01() {

		assertThrows(InvalidPlateauCoordinateException.class, () -> {

			final Probe probe = ProbeFixture.withSpecifications(1L, 2L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.withSpecifications(0L, 5L);

			exploreMars.execute(probe, plateau, "MMRMMRMRRM");

		});
	}
	
	@Test()
	public void shouldThrowInvalidPlateauCoordenateExceptionTestCase02() {

		assertThrows(InvalidPlateauCoordinateException.class, () -> {

			final Probe probe = ProbeFixture.withSpecifications(1L, 2L, CardinalPoint.EAST);
			final Plateau plateau = PlateauFixture.withSpecifications(5L, 0L);

			exploreMars.execute(probe, plateau, "MMRMMRMRRM");

		});
	}

}
