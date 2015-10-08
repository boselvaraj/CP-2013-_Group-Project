package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEmployee implements ActionListener{

	public static JFrame frame = new JFrame("New Employee");
	
	public AddEmployee() {
		frame = new JFrame("New Employee");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		LoginFrame.dispose();
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JLabel firstNameLbl = new JLabel("First Name : ");
		JLabel lastNameLbl = new JLabel("Last Name : ");
		JLabel empIDLbl = new JLabel("Employee ID: ");
		
		JTextField firstName = new JTextField();
		JTextField lastName = new JTextField();
		JTextField empID = new JTextField();
		
		JButton submit = new JButton("Submit");
		
		submit.addActionListener(new EmployeeAddListener(firstName, lastName,empID));
		
		GridBagConstraints cst1 = new GridBagConstraints();
		cst1.fill = GridBagConstraints.NONE;
		cst1.gridx = 0;
		cst1.gridy = 0;
		cst1.weightx = 1.0; 
		cst1.weighty = 1.0;
		
		panel.add(firstNameLbl, cst1);
		
		GridBagConstraints cst2 = new GridBagConstraints();
		cst2.fill = GridBagConstraints.HORIZONTAL;
		cst2.gridx = 1;
		cst2.gridy = 0;
		cst2.weightx = 1.0; 
		cst2.weighty = 1.0;
		
		panel.add(firstName, cst2);
		
		
		GridBagConstraints cst3 = new GridBagConstraints();
		cst3.fill = GridBagConstraints.NONE;
		cst3.gridx = 0;
		cst3.gridy = 1;
		cst3.weightx = 1.0; 
		cst3.weighty = 1.0;
		
		panel.add(lastNameLbl, cst3);
		
		
		GridBagConstraints cst4 = new GridBagConstraints();
		cst4.fill = GridBagConstraints.HORIZONTAL;
		cst4.gridx = 1;
		cst4.gridy = 1;
		cst4.weightx = 1.0; 
		cst4.weighty = 1.0;
		
		panel.add(lastName, cst4);
		
		GridBagConstraints cst5 = new GridBagConstraints();
		cst5.fill = GridBagConstraints.NONE;
		cst5.gridx = 0;
		cst5.gridy = 2;
		cst5.weightx = 1.0; 
		cst5.weighty = 1.0;
		
		
		panel.add(empIDLbl, cst5);
		
		GridBagConstraints cst6 = new GridBagConstraints();
		cst6.fill = GridBagConstraints.HORIZONTAL;
		cst6.gridx = 1;
		cst6.gridy = 2;
		cst6.weightx = 1.0; 
		cst6.weighty = 1.0;
		
		
		panel.add(empID, cst6);

		GridBagConstraints cst7 = new GridBagConstraints();
		cst7.fill = GridBagConstraints.NONE;
		cst7.gridx = 0;
		cst7.gridy = 3;
		cst7.gridwidth = 2;
		cst7.weightx = 2.0; 
		cst7.weighty = 1.0;
		
		
		panel.add(submit, cst7);
		
		frame.add(panel);
		frame.setMinimumSize(new Dimension(700, 700));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
