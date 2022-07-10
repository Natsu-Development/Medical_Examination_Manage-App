package hk2_2019_2020;

import java.sql.*;

public class mySQLConnect {
	public Connection connection;
	public boolean openConnection() {
		 try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?useSSL=false", "root", "");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	 }
	 
	 public void closeConnection() {
		 try {
			 if(connection!=null) {
				 connection.close();
			 } 
		 } catch(SQLException e) {
			 System.out.println(e);
		 }
	 }
}
