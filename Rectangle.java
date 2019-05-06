//Joseph Masterson

public class Rectangle extends Shape {

	//Instance variables
	private double sideOne;
	private double sideTwo;
	
	//Parameterized constructor
	public Rectangle(double aSideOne, double aSideTwo)
	{
		super(aSideOne * aSideTwo); //properly calculates and sets the area
		this.setSideOne(aSideOne);
		this.setSideTwo(aSideTwo);
	}

	//returns the length of side one
	public double getSideOne() 
	{
		return sideOne;
	}

	//returns the length of side two
	public double getSideTwo() 
	{
		return sideTwo;
	}

	//sets the length of side one
	public void setSideOne(double sideOne) 
	{
		//checks the value
		if(sideOne >= 0)
			this.sideOne = sideOne;
	}

	//sets the length of side two
	public void setSideTwo(double sideTwo) 
	{
		//checks the value
		if(sideTwo >= 0)
			this.sideTwo = sideTwo;
	}
	
	//returns the type - rectangle
	public String getType()
	{
		return "Rectangle";
	}
	
	//returns the instance information of the rectangle
	public String toString()
	{
		return this.getType() + " Side 1: " + this.sideOne + " Side 2: " + this.sideTwo + super.toString();
	}
	
	
}
