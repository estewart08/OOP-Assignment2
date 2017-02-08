package assign1Package;
import java.text.*;
import java.io.*;
/**
 * A Product is an object that contains information about that product.
 * Such as product sku, title, price and quantity of that product.
 * @author Dylan Wagner
 * @author Ethan Stewart
 *
 */
public class Product implements Serializable{

	private int sku;//numeric value for the sku
	private String title;//string value for the product title
	private float price;//float value for the product price
	private int quantity;//numeric value for quantity of some product
	private DecimalFormat priceFormat = new DecimalFormat("$##0.00");//formats
	//the float to 2 decimal places.

	Product() {}
	
	Product(int sku, String title, float price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Format for displaying a single movie
	 */
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("SKU: " + sku);
		System.out.println("Price: " + priceFormat.format(price));
		System.out.println("Quantity: " + quantity);
		System.out.println();
	}
	
	/**
	 * Format for displaying the table of movies
	 */
	public void displayt(){
		System.out.println(sku + "\t" + quantity + "\t" + 
	    priceFormat.format(price)+ "\t" + title);
	}
	
	/**
	 * Getter for the sku
	 * @return Returns the sku number as int
	 */
	public int getSku() {
		return this.sku;
	}
	
}
