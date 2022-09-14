/*
 * Class Name: UpdateStockScreen.java
 * Class Description: This screen lets the user update the quantity of a stock item in the system.
 * Created By: Joshua Chukwuezi (C18709101)
 */

package screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import objects.Item;

public class UpdateStockScreen extends JFrame {
	ArrayList<Item> list = null;
	public UpdateStockScreen(ArrayList<Item> itemList) {
		list = itemList;
		
		//adding components
		JPanel panel = new JPanel();
		
		JLabel itemToUpdateLbl = new JLabel("Select item to update");
	
		JLabel itemNameLbl = new JLabel("Item name : ");
		JTextField itemNameField = new JTextField(20);
		
		JLabel updatedQuantityLbl = new JLabel("Update item quantity : ");
		JTextField updatedQuantityField = new JTextField(20);
		
		JLabel origQuantityLbl = new JLabel("Original item quantity : ");
		JTextField origQuantityField = new JTextField(20);
		
		JLabel itemTypeLbl = new JLabel("Type of Item : ");
		JTextField itemTypeField = new JTextField(20);
		
		
		JButton submitBtn = new JButton("UPDATE ITEM");
		
		//creating array to put id numbers into checkbox 
		String[] idList = new String[list.size()];
		for (int i=0; i<list.size(); i++) {
			idList[i] = Integer.toString(list.get(i).getItemID());
		}
		
		JComboBox comboItemID = new JComboBox(idList);
		
		comboItemID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to update stock, create temporary item (with updated stock) to replace former item 
				Item tempItem;
				
				//item ID's start from 1 but array starts from 0 so minus 1 to get the item in the actual position
				tempItem = itemList.get(Integer.parseInt((String) comboItemID.getSelectedItem())-1);
				
				//update details in the text field
				itemNameField.setText(tempItem.getItemName());
				itemTypeField.setText(tempItem.getTypeOfItem());
				origQuantityField.setText(Integer.toString(tempItem.getItemQuantity()));
				
				//format the text
				itemNameField.setEditable(false);
				itemNameField.setSelectedTextColor(Color.GRAY);
				
				itemTypeField.setEditable(false);
				itemTypeField.setSelectedTextColor(Color.GRAY);
				
				origQuantityField.setEditable(false);
				origQuantityField.setSelectedTextColor(Color.GRAY);
			}		
		});
		
		
		
		//button to update the new details of the item
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//variable to store the item id and position
				int position = Integer.parseInt((String) comboItemID.getSelectedItem()) - 1;
				
				//creating temporary customer to put to new stock levels in entered by user
				Item tempItem = new Item();
				
				tempItem.setItemID(position + 1);
				tempItem.setItemName(itemNameField.getText());
				tempItem.setTypeOfItem(itemTypeField.getSelectedText());
				
				//I want to add the quantity entered plus the old quantity
				//for now I will just add the new quantity and come back to it
				//tempItem.setItemQuantity(Integer.parseInt(updatedQuantityField.getText()));
				
				//updated quantity
				int updatedQuantity = Integer.parseInt(updatedQuantityField.getText()) + itemList.get(position).getItemQuantity();
				tempItem.setItemQuantity(updatedQuantity);
				
				//I will replace the item in the arraylist with the item with the updated stock
				itemList.set(position, tempItem);
				
				//set updated quantity
				origQuantityField.setText(Integer.toString(updatedQuantity));
				origQuantityField.setEditable(false);
				origQuantityField.setSelectedTextColor(Color.GRAY);
			}
		});
		
	
		
		
		panel.setLayout(new MigLayout());
		panel.add(itemToUpdateLbl);
		panel.add(comboItemID, "wrap");
		
		panel.add(itemNameLbl);
		panel.add(itemNameField, "wrap");
	
		panel.add(itemTypeLbl);
		panel.add(itemTypeField, "wrap");
		
		panel.add(origQuantityLbl);
		panel.add(origQuantityField, "wrap");
		
		panel.add(updatedQuantityLbl);
		panel.add(updatedQuantityField, "wrap");
		
		panel.add(submitBtn);
		
		add(panel);
		
		// set frame properties
		setTitle("Update Item Screen");
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
		
}
