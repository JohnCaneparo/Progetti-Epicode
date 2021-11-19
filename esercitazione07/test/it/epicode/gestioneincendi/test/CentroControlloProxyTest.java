package it.epicode.gestioneincendi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.epicode.gestioneincendi.ControlloSonda;
import it.epicode.gestioneincendi.InfoSonda;
import it.epicode.gestioneincendi.Sonda;

class CentroControlloProxyTest {

	@Test
	void testRilevaIncendio() {
		Sonda s1 = new Sonda(1l, 1234.0, 331.0);
		s1.setSmokeLevel(10);
		InfoSonda is1 = new InfoSonda(s1);
		assertEquals(is1.getSmokeLevel(), s1.getSmokeLevel());
	}

}
