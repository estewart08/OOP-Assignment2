package assign1Package;

public class Book extends Product {

	private int isbn;
	private String author;
	
	Book() {}
	
	Book(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	
	Book(int sku, String title, float price, int quantity, int isbn, String author) {
		this(sku, title, price, quantity);
		this.isbn = isbn;
		this.author = author;
	}

}
