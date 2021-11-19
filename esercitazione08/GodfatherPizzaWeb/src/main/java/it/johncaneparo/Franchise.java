package it.johncaneparo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Franchise implements MenuItem {

	private String name;
	private Double price;

//	public Franchise(String name, Double price) {
//		this.name = name;
//		this.price = price;
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
		return getName() + ", price = " + getPrice();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Franchise other = (Franchise) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

}