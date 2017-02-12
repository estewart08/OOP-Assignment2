package assign2Package;
import java.text.*;
import java.io.*;
/**
 * A Product is an object that contains information about that product.
 * Such as product sku, title, price, quantity of that product. Also contains
 * specific variables for each product. move-upc, book-author,isbn toy-weight
 * @author Dylan Wagner
 * @author Ethan Stewart
 *
 */
public class Product implements Comparable<Product>, Serializable{

	private int sku;//numeric value for the sku
	private String title;//string value for the product title
	private float price;//float value for the product price
	private int quantity;//numeric value for quantity of some product
	private DecimalFormat priceFormat = new DecimalFormat("$##0.00");//formats
	//the float to 2 decimal places.

	Product() {}
	
	/**
	 * Constructor for Product
	 */	
	
	Product(int sku, String title, float price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * Formatting for sorting by title
	 */		
	public int compareTo(Product rhs){
		return title.compareTo(rhs.title);
	}
	
	
	/**
	 * Format for displaying a single product
	 */
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("SKU: " + sku);
		System.out.println("Price: " + priceFormat.format(price));
		System.out.println("Quantity: " + quantity);		
	}
	public void displayInstance(Product p){
		p.display();
	}
	
	/**
	 * Format for displaying the table of products
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
	/**
	 * Getter for the title of the Product
	 * @return Returns the title as string
	 */	

	public String getTitle() {
		return this.title;
	}

}
