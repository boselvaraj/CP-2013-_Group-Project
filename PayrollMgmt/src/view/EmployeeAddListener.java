package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

import control.PostgreSQLJDBC;

public class EmployeeAddListener implements ActionListener {

	JTextField firstName;
	JTextField lastName;
	JTextField empID;
	public EmployeeAddListener(JTextField firstName, JTextField lastName, JTextField empID) {
		this.firstName = firstName;
		this.lastName= lastName;
		this.empID = empID;
	}

	@Override 
	public void actionPerformed(ActionEvent arg0) {
		AddEmployee.frame.dispose();
		try 
		{
			
			Statement st = PostgreSQLJDBC.connection.createStatement();
			st.executeUpdate("insert into employee values ( \'"+ empID.getText() + "\',\'"+ firstName.getText() + "\',\'" +lastName.getText() + "\' , 0 , 0)");
			PostgreSQLJDBC.connection.close();
			PostgreSQLJDBC.initailize();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		LoginFrame.initializeLogin();

	}

}
