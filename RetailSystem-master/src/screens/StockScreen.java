/*
 * Class Name: StockScreen.java
 * Class Description: This class hosts the buttons to manage stock items, such as adding and viewing stock items, 
 * updating a stock item and deleting a stock item.
 * Created By: Joshua Chukwuezi (C18709101)
 */

package screens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import objects.Item;

public class StockScreen extends JFrame{
	ArrayList<Item> itemList = new ArrayList<Item>();
	public StockScreen(ArrayList<Item> list) {
		itemList = list;
		// create elements
		JPanel panel = new JPanel();
		JButton addStockBtn = new JButton("ADD STOCK");
		JButton updateStockBtn = new JButton("UPDATE STOCK");
		JButton deleteStockBtn = new JButton("DELETE STOCK");

		// setting title and font
		JLabel title;
		title = new JLabel("Manage Stock Items"); 
		Font rstitle = new Font("Arial", Font.PLAIN, 30);
		title.setFont(rstitle);

		addStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStockScreen(itemList);
			}
		});

		updateStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStockScreen(itemList);
			}
		});

		deleteStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStockScreen(itemList);
			}
		});


		// add elements to the panel and add panel to the JFrame
		add(panel);
		panel.setLayout(new MigLayout("", "20", "20"));
		panel.add(title, "span 3, align center, wrap");
		panel.add(addStockBtn);
		panel.add(updateStockBtn);
		panel.add(deleteStockBtn);

		// set frame properties
		setTitle("Stock Screen");
		setSize(370, 100);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}
}
