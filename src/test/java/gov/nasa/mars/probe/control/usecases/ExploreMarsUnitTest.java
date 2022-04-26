package gov.nasa.mars.probe.control.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import gov.nasa.mars.probe.control.entities.CardinalPoint;
import gov.nasa.mars.probe.control.entities.Plateau;
import gov.nasa.mars.probe.control.entities.Probe;
import gov.nasa.mars.probe.control.entities.ProbePosition;
import gov.nasa.mars.probe.control.fixtures.PlateauFixture;
import gov.nasa.mars.probe.control.fixtures.ProbeFixture;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExploreMarsUnitTest {

	@InjectMocks
	private ExploreMars exploreMars;

	@Test
	public void shouldExploreMarsTestCase01() {

		final Probe probe = ProbeFixture.defaultValues();
		final Plateau plateau = PlateauFixture.defaultValues();

		ProbePosition position = exploreMars.execute(probe, plateau, "LMLMLMLMM");
		
		assertEquals(1, position.getCoordinateX().getValue());
		assertEquals(3, position.getCoordinateY().getValue());
		assertEquals(position.getCardinalPoint(), CardinalPoint.NORTH);
	}

}
