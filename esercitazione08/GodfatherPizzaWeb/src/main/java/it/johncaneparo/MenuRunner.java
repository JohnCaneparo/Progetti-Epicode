package it.johncaneparo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MenuRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MenuRunner.class);

	@Value("${godfatherpizza.costocoperto}")
	private Double costoCoperto;

	@Override
	public void run(String... args) throws Exception {
//		Tavolo t1 = new Tavolo(1, 4, true);
//		Ordine ordine = creaOrdine(t1, 4, costoCoperto);
//		valorizzaOrdine(ordine);
//		stampaOrdine(ordine);
//		System.out.println();
//		getTotale(ordine);
		
		GestioneOrdine go = new GestioneOrdine();
		go.popolaListaOrdine();
		stampaOrdine(go.getOrdineById(1));
	}

	public Ordine creaOrdine(Tavolo tavolo, Integer numeroCoperti, Double costoCoperto) {
		Ordine ordine = new Ordine(1, tavolo, StatoOrdine.IN_CORSO, 4);
		return ordine;
	}

	public void valorizzaOrdine(Ordine ordine) {
		PizzaMargherita p1 = new PizzaMargherita();
		PizzaMargherita p2 = new PizzaMargherita();
		PizzaSalami p3 = new PizzaSalami();
		PizzaSalami p4 = new PizzaSalami();
		ToppingCheese pt = new ToppingCheese(p4);
		
		ordine.addMenuItem(p1);
		ordine.addMenuItem(p2);
		ordine.addMenuItem(p3);
		ordine.addMenuItem(pt);
	}

	public void stampaOrdine(Ordine o1) {
		System.out.println("-----ORDINE-----");
		o1.getOrdinato().forEach((key, value) -> {
			logger.info("key: " + key.getName());
			logger.info(", x" + value);
		});
	}
	
	public void getTotale(Ordine ordine) {
		Double totale = ordine.getNumeroCoperti() * costoCoperto;

		for (MenuItem key : ordine.getOrdinato().keySet()) {
			totale += key.getPrice() * (ordine.getOrdinato().get(key));
		}
		logger.info("Il costo totale dell'ordine è: " + totale);
	}
	
	
}
