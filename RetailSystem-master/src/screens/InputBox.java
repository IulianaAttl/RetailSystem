/*
 * Class Name: InputBox.java
 * Class Description: Lets the user input the dimensions and weight limit of a box.
 * Created By: Tami Adeduntan (C18327556)
 */

package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import objects.Box;

public class InputBox extends JFrame{
	
	ArrayList<Box> list = null;

	public InputBox(ArrayList<Box> boxList) {
		list = boxList;
		
		// create elements
		JPanel panel = new JPanel();
	
		//label and textfields for user input
		JLabel label = new JLabel("Enter length: ");
		JTextField length = new JTextField(20);
		JLabel label2 = new JLabel("Enter width: ");
		JTextField width = new JTextField(20);
		JLabel label3 = new JLabel("Enter height: ");
		JTextField height = new JTextField(20);
		JLabel label4 = new JLabel("Enter weight limit: ");
		JTextField weight = new JTextField(20);
		
		//create button
		JButton createButton = new JButton("Create Box");
		JButton exit = new JButton("Exit");

		//reads data from textfields and creates a product object using the data
			createButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (length.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Length is empty", "Error", JOptionPane.ERROR_MESSAGE);							
						}
						
						else if (width.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Width is empty", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						else if(height.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Height is empty", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						else if(weight.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Weight limit is empty", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						else {
							Box aBox = new Box(Integer.parseInt(length.getText()), Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), Integer.parseInt(weight.getText()));
							list.add(aBox);				
							JOptionPane.showMessageDialog(null, "Box has been created", "Information", JOptionPane.INFORMATION_MESSAGE);
						}					
					}			
				});
			
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}				
			});
			
		// add elements to the panel and add panel to the JFrame
		panel.add(label);
		panel.add(length);
		panel.add(label2);
		panel.add(width);
		panel.add(label3);
		panel.add(height);
		panel.add(label4);
		panel.add(weight);
		panel.add(createButton);
		panel.add(exit);
		add(panel);
		panel.setLayout(new MigLayout ("center center, wrap, gapy 20"));
		
		
		// set frame properties
		setTitle("Item Boxing Screen - Box Dimensions");
		setSize(580, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
