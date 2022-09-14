/*
 * Class Name: BoxingScreen.java
 * Class Description: This screen has buttons that let the user enter items to be packed and boxes to be used for packing.
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

public class BoxingScreen extends JFrame{
	ArrayList<Box> bList = null;
	ArrayList<Item> iList = null;
	public BoxingScreen(ArrayList<Box> boxList, ArrayList<Item> itemList) {
		bList = boxList;
		iList = itemList;

		JPanel panel = new JPanel();
		JButton enterBox = new JButton("Enter Box");
		JButton enterItem = new JButton("Enter Item");

		// setting title and font
		JLabel title;
		title = new JLabel("Item Packer"); 
		Font rstitle = new Font("Arial", Font.PLAIN, 30);
		title.setFont(rstitle);
		
		//action listener for when the total button is clicked
		enterBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InputBox(bList);
			}
		});

		enterItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InputItem(iList);
			}
		});

		panel.setLayout(new MigLayout("", "20", "20"));
		panel.add(title, "span 2, align center, wrap");
		panel.add(enterBox);
		panel.add(enterItem);
		add(panel);
		
		setTitle("Boxing Screen");
		setSize(280, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}
}
