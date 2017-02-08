package assign1Package;
import java.util.*;
import java.io.*;
/**
 * Driver Class that contains a menu for the user to manipulate an
 * inventory array of movies.
 * @author Dylan Wagner
 * @author Ethan Stewart
 *
 */
public class InventoryDriver {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
 		// User Menu display and do-while loop
		int userChoice;  // numeric value for user's input
		int movieID;   //numeric value for sku input
		String movieTitle;  //string value for title input
		float moviePrice; //float value for price of movie input
		int movieQuantity; //numeric value for quantity of movie input
		Inventory movies = new Inventory();//instance of Inventory for array
			//manipulation
		
		do {

			Scanner input = new Scanner(System.in);

			System.out.println("What can I help you with?\n");
			System.out.println("1 - Add a movie to the inventory...");
			System.out.println("2 - Remove a movie from the inventory...");
			System.out.println("3 - Display the information for a movie...");
			System.out.println("4 - Display the inventory in a table...");
			System.out.println("5 - Quit...");

			userChoice = input.nextInt();

			switch (userChoice)
			{
				case 1:
					System.out.println("Enter the SKU: ");
					movieID = input.nextInt();
					input.nextLine();
					System.out.println("Enter the movie's title: ");
					movieTitle = input.nextLine();
					System.out.println("Enter the movie's price: ");
					moviePrice = input.nextFloat();
					System.out.println("Enter the quantity that you "
						+ "have in stock: ");
					movieQuantity = input.nextInt();
					
					movies.add(new Movie(movieID, movieTitle, moviePrice, 
						movieQuantity));
					break;
				
				case 2:
					System.out.println("Enter the SKU for the movie "
						+ "to be removed: ");
					movieID = input.nextInt();
					movies.remove(movieID);
					break;
					
				case 3:
					System.out.println("Enter the SKU for the movie you're "
						+ "looking for: ");
					movieID = input.nextInt();
					movies.displayInfo(movieID);
					break;
				
				case 4:
					movies.displayTable();
					break;
					
				case 5:
					movies.save();
					break;
					
				default:
					continue;
			}

		} while (userChoice != 5);
				
	}
}

