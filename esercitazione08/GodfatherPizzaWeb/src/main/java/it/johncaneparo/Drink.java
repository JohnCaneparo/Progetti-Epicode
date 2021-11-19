package it.johncaneparo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Drink implements FoodItem {

	private String name;
	private Double price;
	private Double calories;

//	public Drink(String name, Double price, Double calories) {
//		this.name = name;
//		this.price = price;
//		this.calories = calories;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//	public void setCalories(Double calories) {
//		this.calories = calories;
//	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public String getMenuItemLine() {
		return getName() + ", price = " + getPrice() + ", calories = " + getCalories();
	}

	@Override
	public Double getCalories() {
		return calories;
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
		Drink other = (Drink) obj;
		return Objects.equals(calories, other.calories) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}
	
}
