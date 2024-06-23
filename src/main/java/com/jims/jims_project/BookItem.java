package com.jims.jims_project;

import java.util.Scanner;

/**
 *BookItem class extends Items class, implements Item Interface and represents book items
 * 
 *
 */
public class BookItem extends Items implements Item 
{

	private String author;
	
	Scanner keyboardInput = new Scanner(System.in);
	/**
	 * Non-parameterized constructor for BookItem class
	 */
	public BookItem()
	{
		super();
	}
		
	/**
	 * Parametric constructor for BookItem class
	 * @param id
	 * @param name the id of book item
	 * @param quantity the quantity of book items
	 * @param price the price of book item
	 * @param category the category of item
	 * @param author the author of book items
	 */
	public BookItem(String id, String name, int quantity, double price, String category, String author) 
	{
		super(id, name, quantity, price, category);
		this.author = author;
		
	}

	/**
	 * @param id the id of book item
	 */
	@Override
	public void setId(String id) 
	{
		this.id = id;
	}

	/**
	 * @param name the name of the book item
	 */
	@Override
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @param quantity the quantity of book items
	 */
	@Override
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	/** 
	 * @param price the price of the book item
	 */
	@Override
	public void setPrice(double price) 
	{
		this.price = price;
	}

	/**
	 * @param category the category of the book item
	 */
	@Override
	public void setCategory(String category) 
	{
		this.category = category;
	}
	
	
	
	/**
	 * @return the author of the book item
	 */
	public String getAuthor() 
	{ 
		return author;
	}


	/**
	 * @param author the author of the book item
	 */
	public void setAuthor(String author) 
	{
		this.author = author;
	}


	/**
	 * @return the id of the book item
	 */
	@Override
	public String getId() 
	{
		
		return id;
	}
	
	/**
	 * @return name the name of the book item
	 */
	@Override
	public String getName() 
	{
		return name;
	}
	
	/**
	 * @return the quantity of the book items
	 */
	@Override
	public int getQuantity() 
	{
		if(quantity < 0)
		{
			System.out.println("Quantity cannot be less than 0");
			return quantity;
		}
	else
		{
			 return quantity;
		}
	
		
	}
	
	/**
	 * @return the price of the book item
	 */
	@Override
	public double getPrice() 
	{
		if(price < 0)
		{
			System.out.println("Price cannot be less than 0");
			return price;
		}
	else
		{
			 return price;
		}
	
		
	}
	
	
	/**
	 * @return the category of the book item
	 */
	@Override
	public String getCategory() 
	{
		
		return category;
	}
	
	/**
	 * 
	 * @return new Book item with the information the user entered
	 */
	public BookItem enterBookItem() {
		
		System.out.println("We need the information for book items\n");	
			try {
					
					System.out.println("Enter book's Id: ");
					id = keyboardInput.nextLine();

					System.out.println("Enter book's name: ");
					name = keyboardInput.nextLine();

					System.out.println("Enter book's quantity: ");
					quantity = keyboardInput.nextInt();

					System.out.println("Enter book's price: ");
					price = keyboardInput.nextDouble();

					keyboardInput.nextLine();
					System.out.print("Enter book's category: \n");
					category = keyboardInput.nextLine();
					
					System.out.print("Enter book's author: ");
					author = keyboardInput.nextLine();

					 new BookItem(id, name, quantity, price, category, author);

					// Adds new item to inventory
					InventoryManager.addItem(new BookItem(id, name, quantity, price, category, author));
				
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					System.out.println("Input mismatch!");
					System.exit(0);
				}
				return new BookItem(id, name, quantity, price, category, author);
			}
	
	
	/**
	 * @return id, name, quantity, price, category and author of the book items
	 */
	@Override
	public String toString() 
	{
			
		return ("BOOK ITEMS :\n" + "ID: " + id + "\nName: " + name + "\nQuantity: " + quantity + "\nPrice: " + fdollar.format(price)
				+ "\nCategory: " + category + "\nAuthor: " + author + "\n\n");
	}

}
