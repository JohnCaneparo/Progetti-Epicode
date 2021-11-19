package it.johncaneparo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuConfig {

	@Bean
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	public PizzaHawaiian pizzaHawaiaan() {
		return new PizzaHawaiian();
	}

	@Bean
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}


	@Bean
	public ToppingCheese toppingCheese() {
		return new ToppingCheese();
	}

	@Bean
	public ToppingHam toppingHam() {
		return new ToppingHam();
	}

	@Bean
	public DrinkLemonade drinkLemonade() {
		return new DrinkLemonade();
	}

	@Bean
	public FranchiseMug franchiseMug() {
		return new FranchiseMug();
	}
	
	@Bean
	public Menu creaMenu() {
		Menu m = new Menu();
		m.getMenuPizza().add(pizzaMargherita());
		m.getMenuPizza().add(pizzaHawaiaan());
		m.getMenuPizza().add(pizzaSalami());
		m.getMenuTopping().add(toppingCheese());
		m.getMenuTopping().add(toppingHam());
		m.getMenuDrink().add(drinkLemonade());
		m.getMenuFranchise().add(franchiseMug());
		return m;
	}

}
