//Joseph Masterson

public class Sheep{
	
	//Instance Variables
	private String name; //name of the sheep
	private double weight; //weight of the sheep
	
	//Default Constructor
	public Sheep()
	{
		this.name = "No Name";
		this.weight = 0.0;
	}
	
	//Parameterized Constructor
	public Sheep(String aName, double aWeight)
	{
		this.setName(aName);
		this.setWeight(aWeight);
	}

	//Returns the name of the sheep
	public String getName() 
	{
		return name;
	}

	//Returns the weight of the sheep
	public double getWeight() 
	{
		return weight;
	}

	//Sets the name of the sheep
	public void setName(String aName) 
	{
		this.name = aName;
	}

	//Sets the weight of the sheep, has to be greater than -
	public void setWeight(double aWeight) 
	{
		if(aWeight > 0)
			this.weight = aWeight;
		else
			this.weight = 0;
	}
	
	//Returns the instance variables
	public String toString()
	{
		return "Name: " + this.name + " Weight: " + this.weight;
	}
	

}
