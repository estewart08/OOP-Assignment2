package assign1Package;
import java.io.*;
import java.util.*;
/**
 * Inventory is an object that holds an array of movies
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class Inventory implements Serializable{
	
	public ArrayList<Movie> inventory = new ArrayList<Movie>();
	/**
	 * Creates an inventory array from a file. If no file exists then
	 * the array is empty
	 */
	public Inventory()
	{
		try {
            FileInputStream fis = new FileInputStream("InventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Movie> movies =
                  (ArrayList<Movie>)ois.readObject();  // explicit cast reqd
            fis.close();
            this.inventory = movies;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find datafile.");
        } catch (IOException e)  {
            System.out.println("Problem with file input.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found on input from file.");
        }
        
 
	}
	/**
	 * Adds movie to the array.Also checks for duplicate
	 * @param e The movie to add
	 */
	public void add(Movie e) {
		int index = -1; //numeric value that updates if sku is found,
			//index = -1 means index not found
		
		for (Movie m : inventory) {
			if (m.getSku() == e.getSku()) {
				index = inventory.indexOf(m);
				break;
			}
		}
		if (index == -1)
			inventory.add(e);
		else
			System.out.println("A movie with that SKU already exists.");
	}
	/**
	 * Removes movie from array if the sku exists
	 * @param sku The sku of the movie to be removed
	 */
	public void remove(int sku) {
		int index = -1;//numeric value that updates if sku is found, 
		//index = -1 means index not found
		
		for (Movie m : inventory) {
			if (m.getSku() == sku) {
				index = inventory.indexOf(m);
				break;
			}
		}

		if (index == -1)
			System.out.println("No match found in the inventory, sorry.");
		else {
			inventory.remove(index);
			System.out.println("Movie successfully removed from inventory.");
		}
	}
	/**
	 * Displays info for a specific movie
	 * @param sku The sku to search for.
	 */
	public void displayInfo(int sku) {
		for (Movie m : inventory) {
			if (m.getSku() == sku) {
				m.display();
				break;
			}
		}	
	}
	/**
	 * Displays all of the movies in a table form
	 */
	public void displayTable() {
		System.out.println("Inventory Table:\n");
		for (Movie m : inventory) {
			m.displayt();
		}
	}
	/**
	 * Saves the inventory array to a file so it can be reused.
	 */
	public void save()
	{
       try {
            FileOutputStream fos = new FileOutputStream("InventoryFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inventory);  //ArrayList and contents are serializable
            fos.close();
     } catch (IOException e) {
            System.out.println("Problem with file output");
        }
		
	}
	
	
}


