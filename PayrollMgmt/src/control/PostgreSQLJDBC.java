package control;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
	public static Connection connection = null;
	static 
	{
		initailize();
	}
	
	public static void initailize() {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/admin",
            "admin", "123");
         connection.createStatement().executeQuery("select * from test");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
	
	public static void main(String[] args) {
		initailize();
	}
}
