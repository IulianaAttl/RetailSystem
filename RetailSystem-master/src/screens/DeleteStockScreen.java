/*
 * Class Name: DeleteStockScreen.java
 * Class Description: This screen allows the user to delete a certain stock item from the system.
 * Created By: Joshua Chukwuezi (C18709101)
 */

package screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import objects.Item;

public class DeleteStockScreen extends JFrame {
	ArrayList<Item> list = null;
	
	public DeleteStockScreen(ArrayList<Item> itemList) {
		list = itemList;
		
		//add components
		JPanel panel = new JPanel();
		
		JLabel itemToDeleteLbl = new JLabel("Select item to delete");
		JComboBox comboItemID;
		
		JLabel nameLbl = new JLabel("Item name: ");
		JLabel typeLbl = new JLabel("Item type: ");
		JLabel quantityLbl = new JLabel("Item quantity: ");
		JTextField nameField = new JTextField(20);
		JTextField typeField = new JTextField(20);
		JTextField quantityField = new JTextField(20);
		
		String[] idList = new String[list.size()];
		for (int i=0; i<list.size(); i++) {
			idList[i] = Integer.toString(list.get(i).getItemID());
		}
		
		comboItemID = new JComboBox(idList);
		
		JButton deleteBtn = new JButton("DELETE ITEM");
		
		//when item is selected it will display the details on the screen
		comboItemID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item tempItem;
				tempItem = itemList.get(Integer.parseInt((String) comboItemID.getSelectedItem())-1);
				
				nameField.setText(tempItem.getItemName());
				typeField.setText(tempItem.getTypeOfItem());
				quantityField.setText(Integer.toString(tempItem.getItemQuantity()));
				
				//format the text
				nameField.setEditable(false);
				nameField.setSelectedTextColor(Color.GRAY);
				
				typeField.setEditable(false);
				typeField.setSelectedTextColor(Color.GRAY);
				
				quantityField.setEditable(false);
				quantityField.setSelectedTextColor(Color.GRAY);
			}
		});
		
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = Integer.parseInt((String) comboItemID.getSelectedItem()) - 1;
				itemList.remove(position);
				
				//clearing textFields
				nameField.setText("");
				typeField.setText("");
				quantityField.setText("");
				
			}
		});
		
		
		add(panel);
		panel.add(itemToDeleteLbl);
		panel.add(comboItemID, "wrap");
		
		panel.add(nameLbl);
		panel.add(nameField, "wrap");
		
		panel.add(typeLbl);
		panel.add(typeField, "wrap");
		
		panel.add(quantityLbl);
		panel.add(quantityField, "wrap");
		
		panel.add(deleteBtn);
		
		// set frame properties
		setTitle("Delete Item Screen");
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
	}
	
}
