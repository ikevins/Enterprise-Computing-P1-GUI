package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

public class GUI {
//test
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblOutputLabel;
	private JLabel lblOutputLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel;
	private JLabel lblEnterQuantityFor;
	private JLabel lblDetailsForItem;
	private JLabel lblOrderSubtotalFor;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private String itemID;
	private String quantity;
	private int discount = 0;
	private int itemCounter = 1;	
	private double orderSubtotal = 0;
	private double taxRate = 6;
	private String [] itemHolder = new String [4];
	private String [] cart = new String [100];
	StringBuilder currentCart = new StringBuilder();
	StringBuilder finalInvoice = new StringBuilder();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy, hh:mm:ss a z");
	Date date = new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setAction(action_4);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 250, 450, 30);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_2);
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 210, 450, 30);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setAction(action);
		btnNewButton_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 170, 450, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setAction(action_1);
		btnNewButton_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_3.setBounds(470, 170, 450, 30);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setEnabled(false);
		
		btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setAction(action_3);
		btnNewButton_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_4.setBounds(470, 210, 450, 30);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setEnabled(false);
		
		btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setAction(action_5);
		btnNewButton_5.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_5.setBounds(470, 250, 450, 30);
		frame.getContentPane().add(btnNewButton_5);
		
		lblNewLabel = new JLabel("Enter item ID for item #1:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 450, 30);
		frame.getContentPane().add(lblNewLabel);
		
		lblEnterQuantityFor = new JLabel("Enter quantity for item #1:");
		lblEnterQuantityFor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterQuantityFor.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEnterQuantityFor.setBounds(10, 50, 450, 30);
		frame.getContentPane().add(lblEnterQuantityFor);
		
		lblDetailsForItem = new JLabel("Details for item #1:");
		lblDetailsForItem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetailsForItem.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDetailsForItem.setBounds(10, 90, 450, 30);
		frame.getContentPane().add(lblDetailsForItem);
		
		lblOrderSubtotalFor = new JLabel("Order subtotal for 0 item(s):");
		lblOrderSubtotalFor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderSubtotalFor.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOrderSubtotalFor.setBounds(10, 130, 450, 30);
		frame.getContentPane().add(lblOrderSubtotalFor);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField.setBounds(470, 10, 450, 30);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(470, 50, 450, 30);
		frame.getContentPane().add(textField_1);
		
		lblOutputLabel = new JLabel("");
		lblOutputLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblOutputLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOutputLabel.setBounds(470, 90, 450, 30);
		frame.getContentPane().add(lblOutputLabel);
		
		lblOutputLabel_1 = new JLabel("");
		lblOutputLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblOutputLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOutputLabel_1.setBounds(470, 130, 450, 30);
		frame.getContentPane().add(lblOutputLabel_1);
	}
	
	public String[] searchInventory(String fileName, String itemID) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileName));
		String [] split = new String[4];
        while(scan.hasNext()) {
            String itemDetails = scan.nextLine().toString();
            split = itemDetails.split(", ");
            if(split[0].equals(itemID)){
            	return split;
            }
        }
        return null;
	}
	
	public String viewOrder() {
		for(int i = 1; i < itemCounter; i++) {
			currentCart.append((cart[i] + "\n"));
		}
		return currentCart.toString();
	}
	
	public String finishOrder() {
		finalInvoice.append("Date: " + dateFormat.format(date) + "\n\n");
		finalInvoice.append("Number of line items: " + (itemCounter - 1) + "\n\n");
		finalInvoice.append("Item# / ID / Title / Price / Qty / Disc % / Subtotal:\n\n");
		finalInvoice.append(viewOrder() + "\n");
		finalInvoice.append("Order subtotal: " + orderSubtotal + "\n\n");
		finalInvoice.append("Tax rate: " + taxRate + "%\n\n");
		finalInvoice.append("Tax amount: $" + (orderSubtotal * (taxRate * 0.01) + "\n\n"));
		
		return finalInvoice.toString();
		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Process Item #1");
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			itemID = textField.getText();
			quantity = textField_1.getText();
			GUI inventorySearch = new GUI();
			try {
				itemHolder = inventorySearch.searchInventory("src/main/inventory.txt", itemID);
				if(itemHolder == null) {
					JOptionPane.showMessageDialog(null, "Item ID " + itemID + " not in file");
					textField.setText("");
					textField_1.setText("");
				}
				if(Integer.parseInt(quantity) > 0 && Integer.parseInt(quantity) < 5) {
					discount = 0;
				}
				else if(Integer.parseInt(quantity) > 4 && Integer.parseInt(quantity) < 10) {
					discount = 10;
				}
				else if(Integer.parseInt(quantity) > 9 && Integer.parseInt(quantity) < 15) {
					discount = 15;
				}
				else {
					discount = 20;
				}
				lblDetailsForItem.setText("Details for item #" + itemCounter + ":");
				lblOutputLabel.setText(itemHolder[0] + " " + itemHolder[1] + " $" + itemHolder[3] + " " + Integer.parseInt(quantity) + " " + discount + "% " + "$" + String.format("%.2f", Double.parseDouble(itemHolder[3])));
				btnNewButton_3.setEnabled(true);
				btnNewButton_2.setEnabled(false);
				
				//File outputFile = new File("transactions.txt")
				
				
			} catch (FileNotFoundException | NumberFormatException | NullPointerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Confirm Item #1");
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "Item #" + itemCounter + " accepted. Added to your cart.");
		    cart[itemCounter] = (itemCounter + ". " + itemHolder[0] + " " + itemHolder[1] + " $" + itemHolder[3] + " " + Integer.parseInt(quantity) + " " + discount + "% " + "$" + String.format("%.2f", Double.parseDouble(itemHolder[3])));  
			itemCounter++;
			// Update the label for the next item
			lblNewLabel.setText("Enter item ID for item #" + itemCounter + ":");
			lblEnterQuantityFor.setText("Enter quantity for item #" + itemCounter + ":");
			lblOrderSubtotalFor.setText("Order subtotal for " + (itemCounter - 1) + " item(s):");
			btnNewButton_2.setText("Process Item #" + itemCounter + ":");
			btnNewButton_3.setText("Confirm Item #" + itemCounter + ":");
			if(discount == 0) {
				orderSubtotal += (Double.parseDouble(itemHolder[3]) * Integer.parseInt(quantity));
			}
			else {
				orderSubtotal += (Double.parseDouble(itemHolder[3]) * Integer.parseInt(quantity) * (1 - (discount * 0.01)));
			}
			lblOutputLabel_1.setText("$" + String.format("%.2f", orderSubtotal));
			textField.setText("");
			textField_1.setText("");
			btnNewButton_1.setEnabled(true);
			btnNewButton_2.setEnabled(true);
			btnNewButton_3.setEnabled(false);
			btnNewButton_4.setEnabled(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "View Order");
		}
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, viewOrder());
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Finish Order");
		}
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, finishOrder());
			System.exit(0);
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "New Order");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Exit");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
