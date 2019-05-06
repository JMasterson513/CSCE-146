//Joseph Masterson

public class Process {

	//Instance variables
	private String name; //name of the process
	private double completionTime; //length of time taken to complete the process
	
	//Default Constructor
	public Process()
	{
		this.name = "No Name";
		this.completionTime = 0;
	}
	
	//Parameterized Constructor
	public Process(String aName, double aCompletionTime)
	{
		this.setName(aName);
		this.setCompletionTime(aCompletionTime);
	}

	//Returns the name of the process
	public String getName() 
	{
		return name;
	}

	//Returns the completion time of the process
	public double getCompletionTime() 
	{
		return completionTime;
	}

	//Sets the name of the process
	public void setName(String aName) 
	{
		this.name = aName;
	}

	//Sets the completion time to whatever value is passed in
	public void setCompletionTime(double aCompletionTime) 
	{
		if(aCompletionTime >= 0.0)
			this.completionTime = aCompletionTime;
		else
			completionTime = 0;
	}
	
	//Returns the values for each instance variable
	public String toString()
	{
		return "Name: " + this.name + " Completion Time: " + this.completionTime;
	}
	
}
