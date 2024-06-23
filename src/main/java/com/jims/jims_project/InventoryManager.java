package com.jims.jims_project;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * This class controls inventory operations, manages inventory of BookItem,GroceryItem and
 * ElectronicItem items and provides CRUD - Create New, Read, Update and Delete - operations.
 * 
 */
public class InventoryManager {
	
	private File inventoryFile;
	private String fileName = "inventory.log";
	public static Scanner keyboardInput = new Scanner(System.in);

	// External class objects used in this class
	BookItem book = new BookItem();
	ElectronicItem electronic = new ElectronicItem();
	GroceryItem grocery = new GroceryItem();
	Items anyItem = new Items();

	// ArrayList that stores the inventory items
	protected static ArrayList<Items> items = new ArrayList<Items>();

	/**
	 * Non-parameterized constructor for this class
	 */
	public InventoryManager() {

	}

	/**
	 * Parameterized Constructor for Inventory Manager class
	 * 
	 * @param inventoryFile object that stores user's inventory log
	 * @param fileName      the name of the file the user stores inventory log
	 */
	public InventoryManager(String fileName, File inventoryFile) {
		super();
		this.inventoryFile = inventoryFile;
		this.fileName = fileName;

	}

	/**
	 * @return the fileName for the inventory log file
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName user will save the list of items
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the inventoryFile where the user stores the list of items
	 */
	public File getInventoryFile() {

		return inventoryFile;
	}

	/**
	 * @param inventoryFile the inventoryFile the user will enter the list of items
	 */
	public void setInventoryFile(File inventoryFile) {
		this.inventoryFile = inventoryFile;
	}

	/**
	 * @param anyItem the anyItem the user adds to the items inventory
	 * @return items the user added to the inventory and confirmation message
	 */

	public ArrayList<Items> setGroceryItemId() {
		
		System.out.println("Enter the id of items to update");
		
		try {
			String itemId = keyboardInput.next();
			
			System.out.println("Please enter new id");
			String newId = keyboardInput.next();	
				
			for(int i = 0; i < items.size(); i++) 
				
				if( items.get(i) instanceof GroceryItem && items.get(i).getId().equals(itemId) ) 
					items.get(i).setId(newId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				return items;
	}
		
		public ArrayList<Items> setElectronicItemId() {
			
			System.out.println("Enter the id of items to update");
			
			try {
				String itemId = keyboardInput.next();
				
				System.out.println("Please enter new id");
				
				String newId = keyboardInput.next();
				
				for(int i = 0; i < items.size(); i++) 
					
				if( items.get(i) instanceof ElectronicItem && items.get(i).getId().equals(itemId) ) 
					items.get(i).setId(newId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				return items;
			
		}
		
		public ArrayList<Items> setBookItemId() {
			
			System.out.println("Enter the id of items to update");
			
			try {
				String itemId = keyboardInput.next();
				
				System.out.println("Please enter new id");
				String newId = keyboardInput.next();
				
				for(int i = 0; i < items.size(); i++) 
				if( items.get(i) instanceof BookItem && items.get(i).getId().equals(itemId)) 
					items.get(i).setId(newId);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				return items;	
			}	
			

	/**
	 * @param anyItem the anyItem the user adds to the items inventory
	 * @return items the user added to the inventory and confirmation message
	 */

	public static ArrayList<Items> addItem(Items anyItem) {
		items.add(anyItem);
		System.out.println(anyItem.getClass().getSimpleName() + " was added successfully!\n");

		return items;
	}

	
	/**
	 * @see void method remove()
	 */
	public static void remove() {
		
		System.out.println("Enter item's id");
		
		String Itemid = keyboardInput.next();

		for (Items anyItem : items) {
			
			if (anyItem.getId().equals(Itemid) && anyItem instanceof BookItem) {
				items.remove(anyItem);
				
				System.out.println(anyItem.getClass().getSimpleName() + " was removed successfully!\n");
				
				break; 	
			} 
			else if (anyItem.getId().equals(Itemid) && anyItem instanceof ElectronicItem) {
				     items.remove(anyItem);	
				
				System.out.println(anyItem.getClass().getSimpleName() + " was removed successfully!\n");
				break;
			}
			
			else if (anyItem.getId().equals(Itemid) && anyItem instanceof GroceryItem) {
				items.remove(anyItem);
				
				System.out.println(anyItem.getClass().getSimpleName() + " was removed successfully!\n");
				break;
			}
			else {
				System.out.println("Item not found!");

				break;
			}
		}
	}

	
	/**
	 * @see void method clear()
	 */
	public void clear() {
		
		items.clear();
		
		System.out.println("All Item are removed successfully");

		System.out.println(items);
	}

	/**
	 * @see void method addNewItem()
	 */
	public void addNewItem() {
		int selectNumber = 0;

		do {

			showItemsMenu();

			try {
				selectNumber = keyboardInput.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (selectNumber == 1) {

				book.enterBookItem();
			}

			else if (selectNumber == 2) {
				electronic.enterElectronicItem();
				break;
			}

			else if (selectNumber == 3) {

				grocery.enterGroceryItem();

				break;
			}

			else {
				System.out.println("Exit or wrong selection!");

			}

		} while (selectNumber > 0 && selectNumber < 4);
		System.out.println("You exited addNewItem function!");
	}

	
	/**
	 * @see void method createFile()
	 */
	public void createFile() {

		try {

			inventoryFile = new File(fileName);

			if (inventoryFile.createNewFile()) {
				System.out.println("File created: " + inventoryFile.getName());
			}

			else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			System.out.println("An error occurred.");

			System.out.println(e.getMessage());
		}
	}

	
	/**
	 * @see void method readAndViewInentoryLog()
	 */
	public void readAndViewInventoryLog() {
		Scanner file = null;

		try {
			file = new Scanner(new FileInputStream(fileName));

			if (!file.hasNextLine() || file.equals(null)) {

				System.out.println("Inventory log is empty\n");
			}

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException has occurred!");

			System.exit(0);
		}

		while (file.hasNextLine() == true) {
			fileName = file.nextLine();

			System.out.println(fileName);
		}

		file.close();
	}

	
	/**
	 * @param fileName the name of the file where the user saves inventory Logs
	 */
	public void saveInventoryLog(String fileName) {
		this.fileName = fileName;

		if (items.isEmpty()) {
			System.out.println("Inventory log file " + getFileName() + " is empty\n");

		} else {
			try (PrintWriter printwriter = new PrintWriter(new FileWriter(fileName, true))) {
				printwriter.println(items);

				System.out.println("This category was appended to the file.\n");

				printwriter.close();
			}

			catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	
	/**
	 * @return all the items in the inventory
	 */
	public ArrayList<Items> getItems() {
		
		if (items.isEmpty()) {
			
			System.out.println("Inventory is empty\n");

			return items;
		}
		return items;
	}

	
	/**
	 * @param anyItem the items in the inventory the user wants to view
	 */
	public void viewItem(Items anyItem) {
		
		if (items.isEmpty()) {
			
			System.out.println("Inventory is empty\n");	
		} 
		
	else {
			for (Items allItems : items) {
				
				System.out.println(allItems);

			}

		}
	}

	
	/**
	 * @see void method showItemsMenu()
	 */
	public void showItemsMenu() {
		
		System.out.println("Select a number for item's type or 4 to exit");

		System.out.println("1. Book item \n" + "2. Electronic item\n" + "3. Grocery item\n" + "4. to exit");

	}

	/**
	 * @return string values of inventory items
	 */
	@Override
	public String toString() {
		return ("Items: " + items.toString());

	}
}
