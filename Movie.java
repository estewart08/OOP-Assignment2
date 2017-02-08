package assign1Package;

public class Movie extends Product {
	
	private int upc;
	
	Movie() {}
	
	Movie(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	
	Movie (int sku, String title, float price, int quantity, int upc) {
		this(sku, title, price, quantity);
		this.upc = upc;
	}
	
}
