/*
 * Class Name: AddStockScreen.java
 * Class Description: This class lets the user add a stock item to the system and view stock items currently in the system.
 * Created By: Joshua Chukwuezi (C18709101) & Tami Adeduntan (C18327556)
 */

package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import objects.Item;


public class AddStockScreen extends JFrame {
	ArrayList<Item> list = null;
	Item aItem;

	public AddStockScreen(ArrayList<Item> itemList) {
		list = itemList;
		//adding components
		JPanel panel = new JPanel();

		String [] itemTypes = {"Luxury", "Essential", "Gift"};
		JLabel itemTypeLbl =  new JLabel("Select Item Type");
		JComboBox comboItem = new JComboBox(itemTypes);

		JLabel itemNameLbl = new JLabel("Enter item name");
		JTextField itemNameField = new JTextField(20);

		JLabel itemQuantityLbl = new JLabel("Enter item quantity");
		JTextField itemQuantityField = new JTextField(20);

		JButton submitBtn = new JButton("ADD ITEM");
		JButton viewButton = new JButton("VIEW ITEM");

		JTextArea bottomArea = new JTextArea(30, 30);
		JScrollPane bottomScrollPane = new JScrollPane(bottomArea);

		//constraints
		//for scroll pane
		bottomScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bottomScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = itemNameField.getText();
				int quantity =  Integer.parseInt(itemQuantityField.getText());
				String type = comboItem.getSelectedItem().toString();

				aItem = new Item(name, type, quantity);
				itemList.add(aItem);				
			}
		});

		//displays the items added in the textarea
		viewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				bottomArea.setText("");
				for (Item aItem : itemList) {
					bottomArea.append(aItem + "\n");
				}
			}

		});

		bottomArea.setEditable(false);

		panel.setLayout(new MigLayout());
		panel.add(itemNameLbl);
		panel.add(itemNameField, "wrap");
		panel.add(itemQuantityLbl);
		panel.add(itemQuantityField, "wrap");
		panel.add(itemTypeLbl);
		panel.add(comboItem, "wrap");
		panel.add(submitBtn, "wrap");
		panel.add(viewButton, "wrap");
		panel.add(bottomScrollPane);
		add(panel);

		setTitle("Add Item Customer Screen");
		setSize(580, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
