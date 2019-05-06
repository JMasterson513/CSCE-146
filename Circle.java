//Joseph Masterson

public class Circle extends Shape {
	
	//Instance variable
	private double radius;
	
	//Default Constructor
	public Circle(double aRadius)
	{
		super(Math.PI * Math.pow(aRadius, 2)); //calculate and properly sets the area
		this.setRadius(aRadius); 
	}
	
	//returns the length of the radius
	public double getRadius() 
	{
		return radius;
	}

	//sets the radius
	public void setRadius(double radius) 
	{
		if(radius >= 0) //makes sure the input radius is greater than or equal to 0
			this.radius = radius;
	}	
	
	//Returns the type of the circle
	public String getType()
	{
		return "Circle";
	}
	
	//Returns the info of the circle
	public String toString()
	{
		return this.getType() + " Radius: " + this.radius + super.toString();
	}

}
