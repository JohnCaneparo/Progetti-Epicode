package it.johncaneparo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Menu {

	private List<Pizza> menuPizza = new ArrayList<>();
	private List<PizzaTopping> menuTopping = new ArrayList<>();
	private List<Drink> menuDrink = new ArrayList<>();
	private List<Franchise> menuFranchise = new ArrayList<>();

//	public List<Pizza> getMenuPizza() {
//		return menuPizza;
//	}
//
//	public List<PizzaTopping> getMenuTopping() {
//		return menuTopping;
//	}
//
//	public List<Drink> getMenuDrink() {
//		return menuDrink;
//	}
//
//	public List<Franchise> getMenuFranchise() {
//		return menuFranchise;
//	}
	
	public void costruisciMenu() {
		menuPizza.add(new PizzaMargherita());
		menuPizza.add(new PizzaHawaiian());
		menuPizza.add(new PizzaSalami());
		
		menuTopping.add(new ToppingCheese());
		menuTopping.add(new ToppingHam());
		
		menuDrink.add(new DrinkLemonade());
		
		menuFranchise.add(new FranchiseMug());
	}
	
	public void stampaPizza() {
		for(Pizza p : menuPizza) {
			System.out.println(p.getMenuItemLine());
		}
		System.out.println();
		System.out.println("Pizze Family Size");
		for(Pizza p : menuPizza) {
		PizzaFamilySize pfs = new PizzaFamilySize(p);
		System.out.println(pfs.getMenuItemLine());
		}
		
	}
	
	public void stampaTopping() {
		for(PizzaTopping p : menuTopping) {
			System.out.println(p.getMenuItemLine());
		}
	}
	
	public void stampaDrink() {
		for(Drink d : menuDrink) {
			System.out.println(d.getMenuItemLine());
		}
	}
	
	public void stampaFranchise() {
		for(Franchise f : menuFranchise) {
			System.out.println(f.getMenuItemLine());
		}
	}
}


