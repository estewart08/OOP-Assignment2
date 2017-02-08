package assign1Package;
import java.text.*;
import java.io.*;
/**
 * A movie is an object that contains information about that movie.
 * Such as movie sku, title, price and quantity of that movie.
 * @author Dylan Wagner
 * @author Ethan Stewart
 *
 */
public class Movie implements Serializable{

	private int sku;//numeric value for the sku
	private String title;//string value for the movie title
	private float price;//float value for the movie price
	private int quantity;//numeric value for quantity of some movie
	private DecimalFormat priceFormat = new DecimalFormat("$##0.00");//formats
	//the float to 2 decimal places.

	Movie(int movieID, String movieTitle, float moviePrice, int movieQuantity) {
		this.sku = movieID;
		this.title = movieTitle;
		this.price = moviePrice;
		this.quantity = movieQuantity;
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
