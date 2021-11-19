package it.johncaneparo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class GestioneOrdine {

	public static List<Ordine> listaOrdini;

	public GestioneOrdine() {
		listaOrdini = new ArrayList<Ordine>();
	}

	public void popolaListaOrdine() {

		PizzaMargherita p1 = new PizzaMargherita();
		PizzaSalami p3 = new PizzaSalami();
		ToppingCheese pt = new ToppingCheese(p3);

		PizzaHawaiian p4 = new PizzaHawaiian();
		ToppingHam pt1 = new ToppingHam(p4);
		DrinkLemonade d1 = new DrinkLemonade();

		Tavolo t1 = new Tavolo(1, 5, false);
		Tavolo t2 = new Tavolo(2, 6, false);
		Ordine o1 = new Ordine(1, t1, StatoOrdine.IN_CORSO, 5);
		Ordine o2 = new Ordine(2, t2, StatoOrdine.IN_CORSO, 6);

		o1.addMenuItem(p1);
		o1.addMenuItem(p1);
		o1.addMenuItem(p3);
		o1.addMenuItem(pt);

		o2.addMenuItem(d1);
		o2.addMenuItem(d1);
		o2.addMenuItem(d1);
		o2.addMenuItem(d1);
		o2.addMenuItem(p1);
		o2.addMenuItem(pt1);
		o2.addMenuItem(pt);
		o2.addMenuItem(p3);
		o2.addMenuItem(p1);
		o2.addMenuItem(p3);
		o2.addMenuItem(pt);

		listaOrdini.add(o1);
		listaOrdini.add(o2);
	}

	public Ordine getOrdineById(Integer n) {
		return listaOrdini.stream().filter(o -> o.getNumeroOrdine() == n).findFirst().orElseThrow();
	}
}
