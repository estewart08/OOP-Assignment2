package assign1Package;
import java.util.Scanner;

public class UserMenu {
	
	UserMenu() {}
	
	private int userChoice; //numeric value for user input to handle menu and do-while
	private char productCat; //char value for product category case 1 of switch
	private Scanner input = new Scanner(System.in);
	private Inventory products = new Inventory();
	
	int sku;   //numeric value for SKU input
	String title;  //String value for title input
	float price; //float value for price of product input
	int quantity; //numeric value for quantity of product input
	int upc; //numeric value for Movie UPC input
	int isbn; //numeric value for Book ISBN input
	String author; //String value for Book author input
	int weight; //numeric value for Toy weight input
	
	public int getNumericMenuOption() {

		System.out.println("What can I help you with?\n");
		System.out.println("1. Add product ");
		System.out.println("2. Remove product ");
		System.out.println("3. Find product by sku ");
		System.out.println("4. Display inventory sorted by sku ");
		System.out.println("5. Display inventory sorted by title ");
		System.out.println("6. Process a sale ");
		System.out.println("7. Quit the program ");

		return userChoice = input.nextInt();
	}
	
	public void handleUserChoice() {
		switch (this.userChoice)
		{
			case 1:
				System.out.println("Enter the product type.");
				System.out.println("Enter M for Movie, B for Book, or T for Toy: ");
				
				productCat = Character.toUpperCase(input.next().charAt(0));
				
				if (productCat == 'M')
					this.addMovie();
				else if (productCat == 'B')
					this.addBook();
				else if (productCat == 'T')
					this.addToy();
				else
					System.out.println("Invalid category.");
				
				break;
			
			case 2:
				System.out.println("Enter the SKU for the movie "
					+ "to be removed: ");
				sku = input.nextInt();
				products.remove(sku);
				break;
				
			case 3:
				System.out.println("Enter the SKU of product to find: ");
				sku = input.nextInt();
				products.displayInfo(sku);
				break;
			
			case 4:
				products.displayTable();
				break;
				
			case 5:
				products.save();
				break;
				
			default:
				System.out.println("Invalid menu option.");
		}
	}
	
	private void addMovie() {
		input.nextLine();
		System.out.println("Enter the SKU: ");
		sku = input.nextInt();
		input.nextLine();
		System.out.println("Enter the title: ");
		title = input.nextLine();
		System.out.println("Enter the price: ");
		price = input.nextFloat();
		System.out.println("Enter the quantity: ");
		quantity = input.nextInt();
		System.out.println("Enter the UPC: ");
		upc = input.nextInt();
		
		products.add(new Movie(sku, title, price, 
			quantity, upc));
	}
	
	private void addBook() {
		input.nextLine();
		System.out.println("Enter the SKU: ");
		sku = input.nextInt();	
		input.nextLine();
		System.out.println("Enter the title: ");
		title = input.nextLine();
		System.out.println("Enter the price: ");
		price = input.nextFloat();
		System.out.println("Enter the quantity: ");
		quantity = input.nextInt();
		System.out.println("Enter the ISBN: ");
		isbn = input.nextInt();
		System.out.println("Enter the author: ");
		author = input.nextLine();
		
		products.add(new Book(sku, title, price, 
			quantity, isbn, author));
	}
	
	private void addToy() {
		input.nextLine();
		System.out.println("Enter the SKU: ");
		sku = input.nextInt();	
		input.nextLine();
		System.out.println("Enter the title: ");
		title = input.nextLine();
		System.out.println("Enter the price: ");
		price = input.nextFloat();
		System.out.println("Enter the quantity: ");
		quantity = input.nextInt();
		System.out.println("Enter the weight in ounces: ");
		weight = input.nextInt();	
		
		products.add(new Toy(sku, title, price, 
			quantity, weight));
	}
}
