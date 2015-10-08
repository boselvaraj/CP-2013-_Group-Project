package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.PostgreSQLJDBC;
import model.Employee;

public class EditEmployee 
{
	public static JFrame frame = null;
	
	public static void show(Employee emp)
	{
		frame = new JFrame("Edit Employee");
		ShowEmployee.frame.dispose();
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JLabel firstNameLbl = new JLabel("First Name : ");
		JLabel lastNameLbl = new JLabel("Last Name : ");
		JLabel empIDLbl = new JLabel("Employee ID: ");
	
		JLabel hoursLbl = new JLabel("Hours Worked: ");
		JLabel payLbl = new JLabel("Pay: ");
	
		JTextField firstName = new JTextField(emp.getfName());
		JTextField lastName = new JTextField(emp.getlName());
		JTextField empID = new JTextField(emp.getId());
	
		JTextField hours = new JTextField(emp.getHoursWorked());
		JTextField pay = new JTextField(emp.getPay());
	
		
		JButton save = new JButton("Save");
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement st = PostgreSQLJDBC.connection.createStatement();
					st.executeUpdate("update employee set firstName ='" + firstName.getText() + "', lastName ='" + lastName.getText()
							+"', empID ='"+ empID.getText() +"', hoursWorked ='"+ hours.getText() +
							"', pay ='"+ pay.getText() +"' where empID ='" + emp.getId() + "'");
					PostgreSQLJDBC.connection.close();
					PostgreSQLJDBC.initailize();
					frame.dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				LoginFrame.initializeLogin();
				
			}
		});
		
		GridBagConstraints cst1 = new GridBagConstraints();
		cst1.fill = GridBagConstraints.NONE;
		cst1.gridx = 0;
		cst1.gridy = 0;
		cst1.weightx = 1.0; // --> You miss this for the top panel
		cst1.weighty = 1.0;
		
		panel.add(firstNameLbl, cst1);
		
		GridBagConstraints cst2 = new GridBagConstraints();
		cst2.fill = GridBagConstraints.HORIZONTAL;
		cst2.gridx = 1;
		cst2.gridy = 0;
		cst2.weightx = 1.0; // --> You miss this for the top panel
		cst2.weighty = 1.0;
		
		panel.add(firstName, cst2);
		
		
		GridBagConstraints cst3 = new GridBagConstraints();
		cst3.fill = GridBagConstraints.NONE;
		cst3.gridx = 0;
		cst3.gridy = 1;
		cst3.weightx = 1.0; // --> You miss this for the top panel
		cst3.weighty = 1.0;
		
		panel.add(lastNameLbl, cst3);
		
		
		GridBagConstraints cst4 = new GridBagConstraints();
		cst4.fill = GridBagConstraints.HORIZONTAL;
		cst4.gridx = 1;
		cst4.gridy = 1;
		cst4.weightx = 1.0; // --> You miss this for the top panel
		cst4.weighty = 1.0;
		
		panel.add(lastName, cst4);
		
		GridBagConstraints cst5 = new GridBagConstraints();
		cst5.fill = GridBagConstraints.NONE;
		cst5.gridx = 0;
		cst5.gridy = 2;
		cst5.weightx = 1.0; // --> You miss this for the top panel
		cst5.weighty = 1.0;
		
		
		panel.add(empIDLbl, cst5);
		
		GridBagConstraints cst6 = new GridBagConstraints();
		cst6.fill = GridBagConstraints.HORIZONTAL;
		cst6.gridx = 1;
		cst6.gridy = 2;
		cst6.weightx = 1.0; // --> You miss this for the top panel
		cst6.weighty = 1.0;
		
		
		panel.add(empID, cst6);

		
		GridBagConstraints cst7 = new GridBagConstraints();
		cst7.fill = GridBagConstraints.NONE;
		cst7.gridx = 0;
		cst7.gridy = 3;
		cst7.weightx = 1.0; // --> You miss this for the top panel
		cst7.weighty = 1.0;
		
		
		panel.add(hoursLbl, cst7);
		
		GridBagConstraints cst8 = new GridBagConstraints();
		cst8.fill = GridBagConstraints.HORIZONTAL;
		cst8.gridx = 1;
		cst8.gridy = 3;
		cst8.weightx = 1.0; // --> You miss this for the top panel
		cst8.weighty = 1.0;
		
		
		panel.add(hours, cst8);

		GridBagConstraints cst9 = new GridBagConstraints();
		cst9.fill = GridBagConstraints.NONE;
		cst9.gridx = 0;
		cst9.gridy = 4;
		cst9.weightx = 1.0; // --> You miss this for the top panel
		cst9.weighty = 1.0;
		
		
		panel.add(payLbl, cst9);
		
		GridBagConstraints cst10 = new GridBagConstraints();
		cst10.fill = GridBagConstraints.HORIZONTAL;
		cst10.gridx = 1;
		cst10.gridy = 4;
		cst10.weightx = 1.0; // --> You miss this for the top panel
		cst10.weighty = 1.0;
		
		
		panel.add(pay, cst10);

		
		GridBagConstraints cst11 = new GridBagConstraints();
		cst11.fill = GridBagConstraints.NONE;
		cst11.gridx = 0;
		cst11.gridy = 5;
		cst11.gridwidth = 5;
		cst11.weightx = 5.0; // --> You miss this for the top panel
		cst11.weighty = 1.0;
		
		
		panel.add(save, cst11);
		
		frame.add(panel);
		frame.setMinimumSize(new Dimension(700, 700));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
