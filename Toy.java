package assign1Package;

public class Toy extends Product {

	private int weight;
	
	Toy() {}
	
	Toy(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	
	Toy(int sku, String title, float price, int quantity, int weight) {
		this(sku, title, price, quantity);
		this.weight = weight;
	}
	
}
