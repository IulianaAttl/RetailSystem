/*
 * Class Name: HomeScreen.java
 * Class Description: This screen is the main home screen of the program and it allows the user to access various parts of the system such as:
 * viewing and managing stock items, creating a shopping basket using items within the system, calculating change needed for a purchase and
 * an item box packer that packs items into the least amount of boxes.
 * Created By: Tami Adeduntan (C18327556)
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
import objects.Box;
import objects.Item;
import objects.Order;

public class HomeScreen extends JFrame{
	// array list to store the stock items
	ArrayList<Item> itemList = new ArrayList<Item>();
	// array list to store the boxes
	ArrayList<Box> boxList = new ArrayList<Box>();
	// global order to store the last order from the shopping basket, to be used for change calculator
	Order shoppingBasket = new Order();
	
	public HomeScreen() {
		// create elements 
		JPanel panel = new JPanel();
		JButton stockButton = new JButton("Stock");
		JButton calculatorButton = new JButton("Calculator");
		JButton itemButton = new JButton("Item Packing");
		JButton shoppingButton = new JButton("Shopping Basket");
		JButton exitButton = new JButton("Exit");
		
		// setting title and font
		JLabel title;
		title = new JLabel("Retail System"); 
		Font rstitle = new Font("Arial", Font.PLAIN, 30);
        title.setFont(rstitle); 
		
		// BUTTONS
		// displays the stock window
		stockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockScreen(itemList);
			}
		});
		
		calculatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeScreen(shoppingBasket);
			}
		});

		itemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BoxingScreen(boxList, itemList);
			}
		});
		
		shoppingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShoppingScreen(itemList, shoppingBasket);
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
    
		// add elements to the panel, configure miglayout and add panel to the JFrame
		panel.setLayout(new MigLayout("", "20", "20"));
		panel.add(title, "span 5, align center, wrap");
		panel.add(stockButton);
		panel.add(calculatorButton);
		panel.add(itemButton);
		panel.add(shoppingButton);
		panel.add(exitButton);
		add(panel);
    
		// set frame properties
		setTitle("Home Screen");
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// constructor for the main home screen
	public static void main(String[] args) {
		new HomeScreen();
	}

}
