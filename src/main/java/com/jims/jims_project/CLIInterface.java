package com.jims.jims_project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class organized operations on more visual and readable interface for the entire application
 */
public class CLIInterface extends InventoryManager
{
	
	Scanner keyboardInput = new Scanner(System.in);
	
	/**
	 * Non-parameterized constructor for CLIInterface class
	 */
	public CLIInterface() 
	{
		super();
	}
	
	
	/**
	 * Parametric constructor for CLIInterface class
	 * @param inventoryFile the inventoryFile that user enters list of items 
	 * @param fileName the name of the file that contains user's items entry logs
	 */
	public CLIInterface( String fileName, File inventoryFile) 
	{
		super( );
		
	}
	
	
	/**
	 * @see void method showMenu()
	 */
	public void showMenu()
	{
	String appMenu = "1. Add new item\n" + "2. View items\n" + "3. Update item\n" 
	                  + "4. Delete item\n" + "5. Save inventory log\n" + "6. Delete all items\n" + "7. To Exit";
	
	System.out.println("\nWELCOME TO THE JAVA INVENTORY MANAGEMENT SYSTEM!\n" + 
						"..................................................." + 
						"\nPLEASE CHOOSE AN OPTION: ");
	System.out.println(appMenu);
	
	}
	
	
	/**
	 * @see void method userChoiseMenu()
	 */
	public void userChoiseMenu()
	{
		InventoryManager anyItem = new InventoryManager();
			
			int userChoice =0;
			
			String confirm = "";
	
		do {
			showMenu();
			//userChoice++;
		
		try {
			 userChoice = keyboardInput.nextInt();
			
			switch(userChoice)
			{
			case 1 ://Add new items to inventory
				   addNewItem();
				
					break;
					
			case 2: //View inventory items or inventory log
					System.out.println("Enter 1 to view inventory item(s): \n"
										+ "Enter 2 to view inventory log\n");
					
					userChoice = keyboardInput.nextInt();
					
					if(userChoice == 1)
					{
						//anyItem.viewItem(items);
						System.out.println(anyItem.getItems());
					}
					
					else
					{   
						readAndViewInventoryLog();
					}
					break;
					
			case 3: //Update item
				System.out.println("Please enter : " + "1 for book item\n" + "2 for electronic ite\n" + "3. for grocery item");
				int choice = keyboardInput.nextInt();
				
				if(choice == 1) {
					setBookItemId();
				}
				else if(choice == 2) {
					setElectronicItemId();
				}
				else if (choice == 3) {
					setGroceryItemId();
				}
				else {
					System.out.println("Invalid entry!");
				}
			  
				break;
				
			case 4: //delete an items
				System.out.println("Are you sure you want to delete this items? ");
				
				System.out.println("Enter y to delete this item or n to quit");	
				
				 confirm = keyboardInput.next() ;
				
				if(confirm.equalsIgnoreCase("y")) {
					InventoryManager.remove();
				}
				else {
					break;
				}		
					break;
						
			case 5: //Save item(s) to inventory log file
					anyItem.saveInventoryLog(anyItem.getFileName());
					break;
					
			case 6: //Clears all items in the inventory
				System.out.println("Are you sure you want to delete all items? ");
				
				System.out.println("Enter y to delete all items or n to quit");	
				
				 confirm = keyboardInput.next() ;
				
				if(confirm.equalsIgnoreCase("y")) {
					anyItem.clear();
				}
				else {
					break;
				}
				
				break;
					
			default ://Default 
					System.out.println("Wrong input!"); 
					break;
			
			}			
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
		System.out.println("Wrong input!\n");
			System.exit(0);
		
		}
		
	}while(userChoice > 0 && userChoice < 7 );
		System.out.println("Thank you for using JIMS. Goodbye!");
	
}
}
