package example.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SSample1_1 {
	
	public static void main(String args[]) {
		
		System.out.print("system start up ...");
		
		JFrame frame = new JFrame("Title");
		frame.setBounds(100, 100, 200, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JButton button = new JButton("OK");
		
		panel.add(button);
		frame.add(panel);
		
		frame.setVisible(true);
		
		
	}
}
