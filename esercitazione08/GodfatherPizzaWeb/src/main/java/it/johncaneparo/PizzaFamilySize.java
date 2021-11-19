package it.johncaneparo;

public class PizzaFamilySize implements Pizza {

	private Pizza pizza;
	private Double calories = 1.95;
	private Double price = 4.15d;
	
	public PizzaFamilySize(Pizza pizza) {
		this.pizza = pizza;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public Double getCalories() {
		return pizza.getCalories() + calories;
	}

	@Override
	public String getName() {
		return pizza.getName() + " Family Size";
	}

	@Override
	public Double getPrice() {
		return pizza.getPrice() + price;
	}

	@Override
	public String getMenuItemLine() {
		return getName() + ", price = " + getPrice() + ", calories = " + getCalories();
	}
	
}
