package hk2_2019_2020;

import java.sql.*;
import java.util.*;

public class ex2_DAO {
	mySQLConnect dc = new mySQLConnect();
	
	public ex2_DAO() {
		
	}
	
	public List<bookDTO> getAllBook() {
		List<bookDTO> books = new ArrayList<bookDTO>();  
		if(dc.openConnection()) {
			try {
				String sql = "select * from book";
				Statement statement = dc.connection.createStatement();
				
				ResultSet rs = statement.executeQuery(sql);
				
				while(rs.next()) {
					bookDTO book = new bookDTO(rs.getInt("id"), rs.getString("name"), rs.getInt("amount"), rs.getInt("price"));
					books.add(book);
				}
			}
			catch (SQLException e) {
				System.out.print(e);
			}
			finally {
				dc.closeConnection();
			}
		}
		return books;
	}
	public boolean insert(bookDTO b) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
				String sql = "insert into book(id, name, amount, price) values (?, ?, ?, ?)";
				PreparedStatement statement = dc.connection.prepareCall(sql);
				
				statement.setInt(1, b.getBookCode());
				statement.setString(2, b.getBookName());
				statement.setInt(3, b.getAmount());
				statement.setInt(4, b.getPrice());
				
				if(statement.executeUpdate()>=1) {
					result = true;
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
			finally {
				dc.closeConnection();
			}
		}
		return result;
	}
	
	public boolean hasExist(bookDTO b) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
				String sql = "select * from book where id=" + b.getBookCode();
				Statement statement = dc.connection.createStatement();
				
				ResultSet rs = statement.executeQuery(sql);
				result = rs.next();
			}
			catch (SQLException e) {
				System.out.print(e);
			}
			finally {
				dc.closeConnection();
			}
		}
		
		return result;
	}
	
	
}
