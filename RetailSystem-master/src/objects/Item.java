/*
 * Class Name: Item.java
 * Class Description: This class creates an item class that stores the item name, item type, quantity and item ID.
 * Created By: Joshua Chukwuezi (C18709101)
 */

package objects;

public class Item {

	private String itemName;
	private String typeOfItem;
	private int itemQuantity;
	private int itemID;
	private static int uniqueID = 1;
	private Item tempItem;

	public Item(String name, String type, int quantity) {
		this.itemName = name;
		this.typeOfItem = type;
		this.itemQuantity = quantity;
		this.itemID = createID();
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public static int createID() {
		return uniqueID++;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTypeOfItem() {
		return typeOfItem;
	}

	public void setTypeOfItem(String typeOfItem) {
		this.typeOfItem = typeOfItem;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public Item getTempItem() {
		return tempItem;
	}

	public void setTempItem(Item tempItem) {
		this.tempItem = tempItem;
	}

	public String toString() {
		return
				"\nItem ID: " + this.itemID
				+ "\nItem Name: " + this.itemName
				+ "\nItem Type: " + this.typeOfItem 
				+ "\nItem Quantity: " + this.itemQuantity;
	}

	//display in the shopping screen combo box item info
	public String displayInCombo() {
		return "Item ID: " + this.itemID + " Item Name: " + this.itemName;
	}

}
