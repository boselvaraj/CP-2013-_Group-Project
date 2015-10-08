package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Employee;
import control.PostgreSQLJDBC;

public class ShowEmployee implements ActionListener, MouseListener{

	public static JFrame frame = null;
	
	public ShowEmployee() {
		frame = new JFrame("Employee List");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		LoginFrame.dispose();
		JPanel panel = new JPanel();
		List<Employee> empList = getAllEmployees();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints cst1 = new GridBagConstraints();
		cst1.fill = GridBagConstraints.NONE;
		cst1.gridx = 0;
		cst1.gridy = 0;
		cst1.weightx = 1.0; // --> You miss this for the top panel
		cst1.weighty = 1.0;
		
		
		panel.add(new JLabel("Employee ID"), cst1);
		cst1.gridx = 1;
		cst1.gridy = 0;
		panel.add(new JLabel("First Name") , cst1);
		cst1.gridx = 2;
		cst1.gridy = 0;
		panel.add(new JLabel("Last Name"), cst1);
		cst1.gridx = 3;
		cst1.gridy = 0;
		panel.add(new JLabel("Hours Worked"), cst1);
		cst1.gridx = 4;
		cst1.gridy = 0;
		panel.add(new JLabel("Pay"), cst1);
		
		
		int i = 1;
		for (Employee employee : empList) 
		{
			JLabel id = new JLabel(employee.getId());
			JLabel fName = new JLabel(employee.getfName());
			JLabel lName = new JLabel(employee.getlName());
			JLabel hoursWorked = new JLabel("" + employee.getHoursWorked());
			JLabel pay = new JLabel(""+employee.getPay());
			
			id.setName("empID");
			id.addMouseListener(this);
			
			GridBagConstraints cstID = new GridBagConstraints();
			cstID.fill = GridBagConstraints.NONE;
			cstID.gridx = 0;
			cstID.gridy = i;
			cstID.weightx = 1.0; 
			cstID.weighty = 1.0;
				
			panel.add(id, cstID);
			
			GridBagConstraints cstFN = new GridBagConstraints();
			cstFN.fill = GridBagConstraints.NONE;
			cstFN.gridx = 1;
			cstFN.gridy = i;
			cstFN.weightx = 1.0; 
			cstFN.weighty = 1.0;
			
			panel.add(fName, cstFN);
			
			GridBagConstraints cstLN = new GridBagConstraints();
			cstLN.fill = GridBagConstraints.NONE;
			cstLN.gridx = 2;
			cstLN.gridy = i;
			cstLN.weightx = 1.0;
			cstLN.weighty = 1.0;
			
			panel.add(lName, cstLN);
			
			GridBagConstraints cstHW = new GridBagConstraints();
			cstHW.fill = GridBagConstraints.NONE;
			cstHW.gridx = 3;
			cstHW.gridy = i;
			cstHW.weightx = 1.0;
			cstHW.weighty = 1.0;
			
			panel.add(hoursWorked, cstHW);
			
			GridBagConstraints cstP = new GridBagConstraints();
			cstP.fill = GridBagConstraints.NONE;
			cstP.gridx = 4;
			cstP.gridy = i;
			cstP.weightx = 1.0;
			cstP.weighty = 1.0;
			
			panel.add(pay, cstP);
			
			i++;
				
		}
		JButton back = new JButton("Back");
		back.addActionListener(new LoginFrame());
		
		GridBagConstraints cst7 = new GridBagConstraints();
		cst7.fill = GridBagConstraints.NONE;
		cst7.gridx = 0;
		cst7.gridy = i;
		cst7.gridwidth = 3;
		cst7.weightx = 3.0; // --> You miss this for the top panel
		cst7.weighty = 1.0;
		
		
		panel.add(back, cst7);
		
		frame.add(panel);
		frame.setMinimumSize(new Dimension(700, 700));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> list = new ArrayList<>();
		
		try 
		{
			Statement st = PostgreSQLJDBC.connection.createStatement();
			
			ResultSet rs = st.executeQuery("select * from employee");
			 while (rs.next()) {
                Employee emp = new Employee();
                 emp.setId(rs.getString("empID"));
                 emp.setfName(rs.getString("firstName"));
                 emp.setlName(rs.getString("lastName"));
                 emp.setHoursWorked(rs.getInt("hoursWorked"));
                 emp.setPay(rs.getInt("pay"));
                 
                 list.add(emp);
             }		
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public Employee getEmployee(String empID)
	{
		Employee emp = new Employee();
		
		try 
		{
			Statement st = PostgreSQLJDBC.connection.createStatement();
			ResultSet rs = st.executeQuery("select * from employee where empID = '" + empID + "'");
			 while (rs.next()) {

                 emp.setId(rs.getString("empID"));
                 emp.setfName(rs.getString("firstName"));
                 emp.setlName(rs.getString("lastName"));
                 emp.setHoursWorked(rs.getInt("hoursWorked"));
                 emp.setPay(rs.getInt("pay"));
                 
             }		
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		JLabel lbl = (JLabel) arg0.getComponent();
		if(lbl.getName().equals("empID"))
		{
			Employee emp = getEmployee(lbl.getText());
			EditEmployee.show(emp);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
