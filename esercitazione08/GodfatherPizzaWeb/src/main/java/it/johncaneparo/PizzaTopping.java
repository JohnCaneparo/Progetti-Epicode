package it.johncaneparo;

import lombok.Getter;

@Getter
public class PizzaTopping implements Pizza {

	private Pizza pizza;
	protected String name;
	protected Double calories;
	protected Double price;

	public PizzaTopping(String name, Double calories, double price) {
		this.name = name;
		this.calories = calories;
		this.price = price;
	}
	
	public PizzaTopping(Pizza pizza) {
		this.pizza = pizza;
		this.name = pizza.getName();
		this.calories = pizza.getCalories();
		this.price = pizza.getPrice();
	}

//	@Override
//	public Double getCalories() {
//		return calories;
//	}
//
//	@Override
//	public String getName() {
//		return name;
//	}
//
//	@Override
//	public Double getPrice() {
//		return price;
//	}

	@Override
	public String getMenuItemLine() {
		return getName() + ", price = " + getPrice() + ", calories = " + getCalories();
	}

}
