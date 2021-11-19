package it.epicode.gestioneincendi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.epicode.gestioneincendi.ControlloSonda;
import it.epicode.gestioneincendi.Sonda;

class SondaTest {

	@Test
	void testAddObserver() {
		Sonda s1 = new Sonda(1l, 1234.0, 331.0);
		ControlloSonda c1 = new ControlloSonda(1l);
		s1.addObserver(c1);
		assertEquals(1, s1.getListaObservers().size(), "Il numero degli observers dovrebbere essere 1");
	}

	@Test
	void testRemoveObserver() {
		Sonda s1 = new Sonda(1l, 1234.0, 331.0);
		ControlloSonda c1 = new ControlloSonda(1l);
		s1.addObserver(c1);
		s1.removeObserver(c1);
		assertEquals(0, s1.getListaObservers().size(), "Il numero degli observers dovrebbere essere 0");
	}

	@Test
	void testFumoSopraSoglia() {
		Sonda s1 = new Sonda(1l, 1234.0, 331.0);
		s1.setSmokeLevel(10);
		assertTrue(s1.getSmokeLevel() >= s1.getSMOKE_TRESHOLD(),
				"SmokeLevel dovrebbe essere maggiore o uguale di SMOKE_TRESHOLD");
	}

	@Test
	void testFumoSottoSoglia() {
		Sonda s1 = new Sonda(1l, 1234.0, 331.0);
		s1.setSmokeLevel(2);
		assertFalse(s1.getSmokeLevel() >= s1.getSMOKE_TRESHOLD(),
				"SmokeLevel dovrebbe essere minore di SMOKE_TRESHOLD");
	}

}
