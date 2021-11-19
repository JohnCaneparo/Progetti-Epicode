package it.johncaneparo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PizzaBase implements Pizza {

	private final String name;
	private final Double price;
	private final Double calories;

//	public PizzaBase(String name, Double price, Double calories) {
//		this.name = name;
//		this.price = price;
//		this.calories = calories;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public Double getPrice() {
//		return price;
//	}
//
//	public Double getCalories() {
//		return calories;
//	}

	public String getMenuItemLine() {
		return getName() + ", price = " + getPrice() + ", calories = " + getCalories();
	}

	@Override
	public int hashCode() {
		return Objects.hash(calories, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaBase other = (PizzaBase) obj;
		return Objects.equals(calories, other.calories) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}

	
}