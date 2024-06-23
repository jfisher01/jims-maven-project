package com.jims.jims_project;
import java.util.Scanner;
/**
 * ElectrnonicItem class extends Items class, implements Item Interface and represents electronics items
 * 
 *
 */
public class ElectronicItem extends Items implements Item 
{
	
	private String brandName ;
	
	Scanner keyboardInput = new Scanner(System.in);
	
	/**
	 * Non-parameterized constructor for electronic items class
	 */
	public ElectronicItem()
	{
		super();
	}
	

	/**
	 * Parameterized constructor for electronic items class
	 * @param id the id of the electronic items
	 * @param name the name of the electronic items
	 * @param quantity the quantity of the electronic items
	 * @param price the price of the electronic items
	 * @param category the category of the electronic items
	 * @param brandName the brand name of the electronic items
	 */
	public ElectronicItem(String id, String name, int quantity, double price, String category, String brandName) 
	{
		super(id, name, quantity, price, category);
		this.brandName = brandName;
		
	}



	/**
	 * @param id the id of the electronic items
	 */
	@Override
	public void setId(String id) 
	{
		this.id = id;
	}

	/**
	 * @param name the name of the electronic items
	 */
	@Override
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @param quantity the quantity of the electronic items
	 */
	@Override
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	/**
	 * @param price the price of the electronic items
	 */
	@Override
	public void setPrice(double price) 
	{
		this.price = price;
	}

	/**
	 * @param category the category of the electronic items
	 */
	@Override
	public void setCategory(String category) 
	{
		this.category = category;
	}
	
	

	/**
	 * @return the brandName of the electronic items
	 */
	public String getBrandName() 
	{
		return brandName;
	}


	/**
	 * @param brandName the brandName of the electronic items
	 */
	public void setBrandName(String brandName) 
	{
		this.brandName = brandName;
	}



	/**
	 * @return the id of the electronic items
	 */
	@Override
	public String getId() 
	{
		// TODO Auto-generated method stub
		return id;
	}

	/**
	 * @return the name of the electronic items
	 */
	@Override
	public String getName() 
	{
		// TODO Auto-generated method stub
		return name;
	}
    
	
	/**
	 * @return the quantity of electronic items
	 */
	@Override
	public int getQuantity() 
	{
		// TODO Auto-generated method stub
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
	 * @return the price of the electronic item
	 */
	@Override
	public double getPrice() 
	{
		// TODO Auto-generated method stub
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
	 * @return the category of the electronic items
	 */
	@Override
	public String getCategory() 
	{
			return category;
	}
	
	/**
	 * 
	 *@return the electronic item's object
	 */
	public ElectronicItem enterElectronicItem() {
		
		
		System.out.println("We need information for the electronic items\n");	
		try {
					
			System.out.println("Enter the electronic items Id: ");
			id = keyboardInput.nextLine();

			System.out.println("Enter the electronic items name: ");
			name = keyboardInput.nextLine();

			System.out.println("Enter the electronic items quantity: ");
			quantity = keyboardInput.nextInt();

			System.out.println("Enter  the electronic items price: ");
			price = keyboardInput.nextDouble();
			
			keyboardInput.nextLine();
			System.out.print("Enter  the electronic items category: ");
			category = keyboardInput.nextLine();

			System.out.print("Enter  the electronic items brand: ");
			brandName = keyboardInput.nextLine();
			
			new ElectronicItem(id, name, quantity, price, category, brandName);

			// Adds new item to inventory
			InventoryManager.addItem(new ElectronicItem(id, name, quantity, price, category, brandName));
			
			} 
		catch (Exception e) 
			{
			// TODO Auto-generated catch block
			System.out.println("Input mismatch!");
			System.exit(0);
			}
			return new ElectronicItem(id, name, quantity, price, category, brandName);

			}
	
	
	/**

	 * @return the id, name, quantity, price, category and brand name of the electronic item
	 */
	@Override
	public String toString() 
	{
		
		return ("ELECTRONIC ITEMS :\n" + "ID: " + id + "\nName: " + name + "\nQuantity: " + quantity + "\nPrice: " + fdollar.format(price)
				+ "\nCategory: " + category + "\nBrand Name: " + brandName + "\n\n");
	}
	
}
