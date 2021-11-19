package it.johncaneparo;

public class ToppingHam extends PizzaTopping {

	public ToppingHam() {
		super("Ham", 0.99, 35d);
	}

	public ToppingHam(Pizza pizza) {
		super(pizza);
		name = pizza.getName() + "+ Ham";
		price = pizza.getPrice() + 0.99;
		calories = pizza.getCalories() + 35d;
	}

}
