package hk2_2019_2020;

import java.util.*;

public class ex2_BUS {
	
	ex2_DAO d = new ex2_DAO();
	
	public String insert(bookDTO b) {
		// test 
		List<bookDTO> books = d.getAllBook();
		for(int i=0; i<books.size(); i++) {
			if(b.getBookCode()==books.get(i).getBookCode()) {
				return "bookCode has existed";
			}
		}
		if(d.insert(b)) {
			return "insert book successfully";
		}
		return "insert book failed";
	}
	
	public List<bookDTO> getAllBook() {
		return d.getAllBook();
	}
	
	public int getAllAmount() {
		int totalAmount = 0;
		List<bookDTO> books = d.getAllBook();
		for(int i=0; i<books.size(); i++) {
			totalAmount += books.get(i).getAmount();
		}
		return totalAmount;
	}
}
