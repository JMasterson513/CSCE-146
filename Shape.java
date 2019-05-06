//Joseph Masterson

public class Shape implements Comparable<Shape>{

	//Instance variable
	private double area;

	//Parameterized Constructor
	public Shape(double xArea)
	{
		this.setArea(xArea);
	}
	
	//Returns the area 
	public double getArea()
	{
		return area;
	}
	
	//Sets the area
	public void setArea(double area)
	{
		//checks the input area
		if(area >= 0)
			this.area = area;
			
	}
	
	//Method to comapre two shapes
	public int compareTo(Shape aShape)
	{
		if(area < aShape.area) //less than
			return -1;
		else if(area > aShape.area) //greater than
			return 1;
		else //equal
			return 0;
	}
	
	//Returns the type of the instance in this case unclassified
	public String getType()
	{
		return "Unclassified";
	}
	
	//Returns the area of the shape
	public String toString()
	{
		return " Area: " + this.area;
	}
	
}
