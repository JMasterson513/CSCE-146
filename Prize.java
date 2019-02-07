//Joseph Masterson

public class Prize {

	//Instance Variables
	private String name;
	private int price;
	
	//Default Constructor
	public Prize()
	
	{
		this.name = "No Name";
		this.price = 0;
	}
	//Parameterized Constructor
	public Prize(String aName, int aPrice)
	{
		this.setName(aName);
		this.setPrice(aPrice);
	}
	
	//Getters
	public String getName() 
	{
		return name;
	}
	
	public int getPrice() 
	{
		return price;
	}
	
	//Setters
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	public void setPrice(int aPrice) 
	{
		if(aPrice > 0)
		{
			this.price = aPrice;
		}
			
	}
	
	
}
