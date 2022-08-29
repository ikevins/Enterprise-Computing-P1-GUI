// Test
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	private int counts = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton button1;
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		button1 = new JButton("Click me");
		label = new JLabel("Number of clicks: 0");
		
		
		panel.add(button1);
		panel.add(label);
		
		button1.addActionListener(this);
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Project1 GUI");
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new GUI();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		counts++;
		label.setText("Number of clicks: " + counts);
		
	}

}
