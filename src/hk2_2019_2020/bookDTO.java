package hk2_2019_2020;

public class bookDTO {
	private int bookCode;
	private String bookName;
	private int amount; 
	private int price;
	
	public bookDTO(int bookCode, String bookName, int amount, int price) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.amount = amount;
		this.price = price;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
