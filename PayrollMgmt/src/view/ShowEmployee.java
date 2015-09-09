package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowEmployee implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		JLabel showEmp = new JLabel("Showing the Employee List");
		panel.add(showEmp);
		frame.add(panel);
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
