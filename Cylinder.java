//Joseph Masterson

public class Cylinder {
	
	//Instance Variables
	private double baseRadius; //non-negative
	private double height; //non-negative
	
	//default constructor
	public Cylinder()
	{
		this.baseRadius = 0; 
		this.height = 0;
	}
	
	//Parameterized Constructor
	public Cylinder(double aBaseRadius, double aHeight)
	{
		this.setBaseRadius(aBaseRadius);
		this.setHeight(aHeight);
	}

	//Returns the base radius
	public double getBaseRadius() 
	{
		return baseRadius;
	}

	//Returns the height
	public double getHeight() 
	{
		return height;
	}
	 
	
	//Calculates the volume of the cylinder
	public double getVolume()
	{
		return Math.PI * this.height * Math.pow(this.baseRadius, 2);
	}

	//Sets the base radius checks if greater than 0
	public void setBaseRadius(double aBaseRadius) 
	{
		if(aBaseRadius > 0)
			this.baseRadius = aBaseRadius;
		else
			this.baseRadius = 0;
	}

	//Sets the height checks if greater than 0
	public void setHeight(double aHeight) 
	{
		if(aHeight > 0)
			this.height = aHeight;
		else
			this.height = 0;
	}	
}
