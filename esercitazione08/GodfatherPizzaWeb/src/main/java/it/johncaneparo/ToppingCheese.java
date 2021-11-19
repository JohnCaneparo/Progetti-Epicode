package it.johncaneparo;

public class ToppingCheese extends PizzaTopping {

	public ToppingCheese() {
		super("Cheese", 0.69, 92d);
	}

	public ToppingCheese(Pizza pizza) {
		super(pizza);
		name = pizza.getName() + "+ Cheese";
		price = pizza.getPrice() + 0.69;
		calories = pizza.getCalories() + 92d;
	}

}
