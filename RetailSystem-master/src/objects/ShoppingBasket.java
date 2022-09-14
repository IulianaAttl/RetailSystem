/*
 * Class Name: ShoppingBasket.java
 * Class Description: This class creates a shopping basket item with information such as the item chosen, quantity chosen and total cost after VAT.
 * Created By: Iuliana Attl (C18379476) 
 */

package objects;

public class ShoppingBasket {
	//global variables
	private Item item;
	private int quantity;
	private double cost;

	//constructor
	public ShoppingBasket(Item item, int quantity, double cost) {
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
	}

	//getters and setters
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	//display method for the items in the shopping basket
	public String toString() {
		return "\n" + this.item + "\nQuantity :" + this.quantity + "\nCost: " + this.cost;
	}
}