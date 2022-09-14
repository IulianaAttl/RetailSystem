/*
 * Class Name: Order.java
 * Class Description: This class creates an order of items in the shopping basket and total cost.
 * Created By: Iuliana Attl (C18379476) 
 */

package objects;

import java.util.ArrayList;

public class Order {
	//global variables
	private ArrayList<ShoppingBasket> basket;
	private double cost;

	//constructors
	public Order(ArrayList<ShoppingBasket> basket, double cost) {
		this.basket = basket;
		this.cost = cost;
	}

	public Order() {
		this.basket = null;
		this.cost = 0;
	}

	//getters and setters
	public ArrayList<ShoppingBasket> getBasket() {
		return basket;
	}

	public void setBasket(ArrayList<ShoppingBasket> basket) {
		this.basket = basket;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	//method that displays the order
	public String toString() {
		return displayElements() + "\nTotal Cost: " + this.cost;
	}

	//method that displays the items in the basket
	public String displayElements() {
		String display = "";
		for(ShoppingBasket bas : basket) {
			display = display + bas.toString();
		}
		return display;
	}
}
