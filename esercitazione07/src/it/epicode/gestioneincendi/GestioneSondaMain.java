package it.epicode.gestioneincendi;

public class GestioneSondaMain {

	public static void main(String[] args) {

		ControlloSonda c1 = new ControlloSonda(1l);
		ControlloSonda c2 = new ControlloSonda(2l);

		Sonda s1 = new Sonda(1l, 1234.0, 331.0);

		s1.observers.add(c1);
		s1.observers.add(c2);
		s1.observers.remove(c2);

		s1.setSmokeLevel(10);
	}

}
