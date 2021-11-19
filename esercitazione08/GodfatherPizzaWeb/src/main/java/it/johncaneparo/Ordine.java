package it.johncaneparo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Ordine {
	private static final Logger logger = LoggerFactory.getLogger(Ordine.class);

	private Integer numeroOrdine;
	private Map<MenuItem, Integer> ordinato = new HashMap<>();
	private Tavolo tavolo;
	private StatoOrdine stato;
	private Integer numeroCoperti;
	private final Double COSTO_COPERTO = 0.5;
	private Double totale;

	public Ordine() {
	}

	public Ordine(Integer numeroOrdine, Tavolo tavolo, StatoOrdine stato, Integer numeroCoperti) {
		this.numeroOrdine = numeroOrdine;
		this.tavolo = tavolo;
		this.stato = stato;
		this.numeroCoperti = numeroCoperti;
	}

	public Integer getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(Integer numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public Map<MenuItem, Integer> getOrdinato() {
		return ordinato;
	}

	public void setOrdinato(Map<MenuItem, Integer> ordinato) {
		this.ordinato = ordinato;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public StatoOrdine getStato() {
		return stato;
	}

	public void setStato(StatoOrdine stato) {
		this.stato = stato;
	}

	public Integer getNumeroCoperti() {
		return numeroCoperti;
	}

	public void setNumeroCoperti(Integer numeroCoperti) {
		this.numeroCoperti = numeroCoperti;
	}

	public void addMenuItem(MenuItem item) {
		if (ordinato.containsKey(item)) {
			ordinato.replace(item, ordinato.get(item), ordinato.get(item) + 1);
		} else {
			ordinato.put(item, 1);
		}
	}

	public void removeMenuItem(MenuItem item) {
		if (ordinato.containsKey(item)) {
			if(ordinato.get(item) > 1) {
				ordinato.replace(item, ordinato.get(item), ordinato.get(item) - 1);
			} else {
				ordinato.remove(item);
			}
		}
		
	}

//	public Double getTotale(Ordine ordine) {
//		Double totale = ordine.getNumeroCoperti() * COSTO_COPERTO;
//
//		for (MenuItem key : ordine.getOrdinato().keySet()) {
//			totale += key.getPrice() * (ordine.getOrdinato().get(key));
//		}
//		logger.info("Il costo totale dell'ordine è: " + totale);
//		this.totale = totale;
//		return totale;
//	}
	
	public double getTotale() {
		totale = COSTO_COPERTO * numeroCoperti;
		ordinato.forEach((i, p) -> totale += i.getPrice() * p);
		setTotale(totale);
		return Math.round(totale);
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}
	
	
//
//	public void stampaOrdine(Ordine o1) {
//		System.out.println("-----ORDINE-----");
//		o1.getOrdinato().forEach((key, value) -> {
//			logger.info(key.getName());
//			logger.info(", x" + value);
////			System.out.print("key: " + key.getName());
////			System.out.println(", x" + value);
//		});
//	}
}
