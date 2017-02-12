package assign2Package;
import java.io.*;
import java.util.*;
/**
 * Inventory is class that holds an array of products
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class Inventory implements Serializable{
	
	public ArrayList<Product> inventory = new ArrayList<Product>();
	/**
	 * Creates an inventory array from a file. If no file exists then
	 * the array is empty
	 */
	public Inventory()
	{
		try {
            FileInputStream fis = new FileInputStream("InventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Product> products =
                  (ArrayList<Product>)ois.readObject();  // explicit cast reqd
            fis.close();
            this.inventory = products;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find datafile.");
        } catch (IOException e)  {
            System.out.println("Problem with file input.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found on input from file.");
        }
        
 
	}
	/**
	 * Adds a product to the array. Also checks for duplicates
	 * @param p The product to add
	 */
	public void add(Product p) {
		int index = -1; //numeric value that updates if sku is found,
			//index = -1 means index not found
		
		for (Product s : inventory) {
			if (s.getSku() == p.getSku()) {
				index = inventory.indexOf(s);
				break;
			}
		}
		if (index == -1)
			inventory.add(p);
		else
			System.out.println("A product with that SKU already exists.");
	}
	/**
	 * Removes product from the array if the sku exists
	 * @param sku The sku of the movie to be removed
	 */
	public void remove(int sku) {
		int index = -1;//numeric value that updates if sku is found, 
		//index = -1 means index not found
		
		for (Product p : inventory) {
			if (p.getSku() == sku) {
				index = inventory.indexOf(p);
				break;
			}
		}

		if (index == -1)
			System.out.println("No match found in the inventory, sorry.");
		else {
			inventory.remove(index);
			System.out.println("Product successfully removed from inventory.");
		}
	}
	/**
	 * Displays info for a specific product
	 * @param sku The sku to search for.
	 */
	public void displayInfo(int sku) {
		for (Product p : inventory) {
			if (p.getSku() == sku) {
				if (p instanceof Toy){
					Toy toy = (Toy)p;
					p.displayInstance(toy);
				}
				else if (p instanceof Movie){
					Movie movie = (Movie)p;
					p.displayInstance(movie);
				}
				
				else{
					Book book = (Book)p;
					p.displayInstance(book);
				}
			}
		}	
		System.out.println("SKU not found.");
	}
	/**
	 * Displays all of the products in order by SKU
	 */
	public void displayBySku() {		
		Comparator<Product> comp = new ProductBySku();
		Collections.sort(inventory, comp);
		for (Product p : inventory) {
			if (p instanceof Toy){
				System.out.print("Toy\t");
			}
			else if (p instanceof Movie){
				System.out.print("Movie\t");
			}
			
			else{
				System.out.print("Book\t");
			}
			p.displayt();
		}
				
	}

	/**
	 * Displays all of the products in order by Title
	 */	
	public void displayByTitle() {	
		Comparator<Product> comp = new ProductByTitle();
		Collections.sort(inventory, comp);
		for (Product p : inventory) {
			if (p instanceof Toy){
				System.out.print("Toy\t");
			}
			else if (p instanceof Movie){
				System.out.print("Movie\t");
			}
			
			else{
				System.out.print("Book\t");
			}					
			p.displayt();
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


