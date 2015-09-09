package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginFrame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JButton add = new JButton("Add Employee");
		add.addActionListener(new AddEmployee());
		
		GridBagConstraints cst = new GridBagConstraints();
		cst.fill = GridBagConstraints.NONE;
		cst.gridx = 0;
		cst.gridy = 0;
		cst.weightx = 1.0; // --> You miss this for the top panel
		cst.weighty = 1.0;

		
		panel.add(add, cst);
		JButton show = new JButton("Show Employee");
		show.addActionListener(new ShowEmployee());
		
		GridBagConstraints cst1 = new GridBagConstraints();
		cst1.fill = GridBagConstraints.NONE;
		cst1.gridx = 1;
		cst1.gridy = 0;
		cst1.weightx = 1.0; // --> You miss this for the top panel
		cst1.weighty = 1.0;
		
		
		panel.add(show, cst1);
		
		frame.add(panel);
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
