//Joseph Masterson

public class RightTriangle extends Shape {
	
	//Instance variables
	private double sideOne;
	private double sideTwo;
	
	//Parameterized Constructor
	public RightTriangle(double aSideOne, double aSideTwo)
	{
		super(aSideOne * aSideTwo * 0.5); //properly calculates and sets the area
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
		//checks the input
		if(sideOne >= 0)
			this.sideOne = sideOne;
	}

	//sets the length of side two
	public void setSideTwo(double sideTwo) 
	{
		//checks the input
		if(sideTwo >= 0)
			this.sideTwo = sideTwo;
	}
	
	//returns the type - right triangle
	public String getType()
	{
		return "Right Triangle";
	}

	//returns the information of the instance
	public String toString()
	{
		return this.getType() + " Side 1: " + this.sideOne + " Side 2: " + this.sideTwo + super.toString();
	}
}
