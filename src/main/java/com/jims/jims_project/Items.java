/**
 * 
 */
package com.jims.jims_project;

import java.text.NumberFormat;

/**
 * Items class implements Item Interface, represents concrete and base class 
 * for GroceryItem, BookItem and ElectronicItem classes
 */ 
public class Items implements Item  
{
	//Currency formatter used in this project
	NumberFormat fdollar = NumberFormat.getCurrencyInstance();

	protected String id;
	protected String name;
	protected int quantity;
	protected double price;
	protected String category;
	
	/**
	 * Non-parameterized constructor for Items class
	 */
	public Items()
	{
		
	}
	
	/**
	 * parameterized constructor for Items class
	 * @param id the id of the items the user will input
	 * @param name the name of the items the user will input
	 * @param quantity the quantity of items the user will input
	 * @param price the price of the items the user will input
	 * @param category the category of the items the user will input
	 */
	public Items(String id, String name, int quantity, double price, String category) 
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}
	
	
	/**
	 * @return the id of the item
	 */
	@Override
	public String getId() 
	{
		return id;
	}
	
	/**
	 * 
	 * @param id, the id of the item 
	 */
	public void setId(String id) 
	{
		this.id = id;
	}
	
	/**
	 * 
	 * @return the name of the item 
	 */
	@Override
	public String getName() 
	{
		return name;
	}
	
	/**
	 * @param name the name of the item
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @return the quantity of items
	 */
	@Override
	public int getQuantity() 
	{
		return quantity;
	}
	
	/**
	 * 
	 * @param quantity the quantity of items
	 */
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	
	/**
	 *
	 * @return price the price of items.
	 */
	@Override
	public double getPrice() 
	{
		return price;
	}
	
	
	/**
	 *
	 * @param price the price of the item
	 */
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	/**
	 * @return the category of the items
	 */
	@Override
	public String getCategory() 
	{
		return category;
	}
	
	/**
	 * 
	 * @param category the category of the items
	 */
	public void setCategory(String category) 
	{
		this.category = category;
	}
	
	/**
	 * 
	 * @return the id, name, quantity, price and category of the items 
	 */
	public String toString() 
	{
		return ("ITEMS :\n" + "ID: " + id + "\nName: " + name + "\nQuantity: " + quantity + "\nPrice: " + price
				+ "\nCategory: " + category + "\n" );
	}

	
}
