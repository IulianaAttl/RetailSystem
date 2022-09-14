/*
 * Class Name: ChangeScreen.java
 * Class Description: This screen shows the change screen calculator that lets the user input the amount to pay and the payment a customer has made.
 * If a shopping basket has been made, the total cost from it will be automatically input for the user.
 * Created By: George Bursuc (C18399946)
 */

package screens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import objects.Order;

public class ChangeScreen extends JFrame{
	Order basket = null;
	JTextField amountField = new JTextField(20);

	public ChangeScreen(Order shoppingBasket) {
		basket = shoppingBasket;
		boolean emptyBasket = true;

		// create elements
		JPanel panel = new JPanel();
		JLabel amountLabel= new JLabel("Amount Due in Basket in \u20AC: (blank if no basket has been made)");
		JLabel paymentLabel= new JLabel("Amount Paid in \u20AC: ");
		JTextField paymentField = new JTextField(20);
		JButton calculateBttn = new JButton("Calculate Change");
		JButton exitBttn = new JButton("Exit");
		JButton clear = new JButton("clear");
		
		// setting title and font
		JLabel title;
		title = new JLabel("Change Calculator"); 
		Font rstitle = new Font("Arial", Font.PLAIN, 30);
		title.setFont(rstitle);

		// check if an order item (shopping basket) exists in the system yet
		if (basket != null && basket.getCost() > 0.0) { // if an order exists then fill in the order total into amountField
			amountField.setText(Double.toString(basket.getCost()));
			emptyBasket = false;
		}

		// button that calculates the change
		calculateBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the values from the text fields
				double amount = Double.parseDouble(amountField.getText());
				double payment = Double.parseDouble(paymentField.getText());
				// make sure the payment is enough to pay for the amount due
				if (payment >= amount) {
					String amountDue;
					amountDue = calculateChange(amount, payment);
					JOptionPane.showMessageDialog(null, "Change Due: " + amountDue, "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Error - Payment cannot cover the amount due.", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});

		// button that clears the calculator fields
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountField.setText("");
				paymentField.setText("");
			}
		});
				
		// button that closes the change calculator window
		exitBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// add elements to the panel and add panel to the JFrame
		//panel.setLayout(new MigLayout("", "275!"));
		panel.setLayout(new MigLayout("", "20", "20"));
		panel.add(title, "span 2, align center, wrap");
		panel.add(amountLabel, "wrap");
		panel.add(amountField, "wrap");
		panel.add(paymentLabel, "wrap");
		panel.add(paymentField, "wrap");
		panel.add(calculateBttn, "split 2");
		panel.add(clear, "wrap");
		panel.add(exitBttn);
		add(panel);

		// set frame properties
		setTitle("Change Calculator");
		setSize(450, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// show pop up window to inform user that the amount field has taken the total value from the shopping basket
		if (!emptyBasket)
			JOptionPane.showMessageDialog(null, "Since a shopping basket has been made recently, the total \n"
					+ "from it has been automatically filled into the calculator.", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	public String calculateChange(double amountDueDoub, double paymentDoub) {
		// convert payment due and payment to cents to avoid double/floating point errors
		int amountDue = (int) (amountDueDoub * 100);
		int payment = (int) (paymentDoub * 100);
		
		// find how much the customer is owed
		int changeDue = payment - amountDue;

		// setup array of all notes and coins for change in cents
		Integer[] changeList = {50000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

		// store the list of change needed to give back customer
		String changeDueList = "\n";

		// keep track of the change currently being compared to the change due and the count of how many of that change to give
		int currentChange;
		int currentChangeCount;

		// going through each type of change starting at 500 euro note
		for (int x = 0; x < changeList.length; x++) {
			// to avoid repeatedly accessing array for the current change being compared
			currentChange = changeList[x];

			// reset count value for every iteration
			currentChangeCount = 0;

			// check if a note/coin can be taken away from the amount due
			if (changeDue >= currentChange) {
				// check if the change can be represented with a euro sign or cent sign and add to the change due list
				if (currentChange >= 100) // the current change is more than or equal to one euro
					changeDueList += ("\u20AC" + String.valueOf(currentChange/100) + ": ");
				else 
					changeDueList += (String.valueOf(currentChange) + "c: ");

				// keep taking away value of change selected and increment the count of how many of that change is needed
				while(changeDue >= currentChange) {
					changeDue -= currentChange;
					currentChangeCount++;
				}

				// add the count to the change due list
				changeDueList += String.valueOf(currentChangeCount) + "\n";
			}
		}
		
		// if the list was never added to, then it means the customer has paid the exact amount and there is no change to give
		if (changeDueList.equals("\n"))
			return "No change is needed";
		else
			return changeDueList;
	}
	
}
