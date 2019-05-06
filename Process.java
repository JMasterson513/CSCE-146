//Joseph Masterson

public class Process {
	
	private int priority; //corresponds to where it will be in the heap, greater than 0
	private double time; //how long the process will take to run, greater than 0
	private String name; //name of the process
	
	//Default Constructor
	public Process()
	{
		this.priority = 1; //default priority is 1
		this.time = 1; //default time is 1
		this.name = "No Name";
	}
	
	//Parameterized Constructor
	public Process(String aName, int aPriority, double aTime)
	{
		this.setName(aName); //sets the name
		this.setPriority(aPriority); //sets the priority
		this.setTime(aTime); //sets the time
	}

	//Returns the priority
	public int getPriority() 
	{
		return priority;
	}

	//Returns the time
	public double getTime() 
	{
		return time;
	}

	//Returns the name
	public String getName() 
	{
		return name;
	}

	//Sets the priority
	public void setPriority(int aPriority) 
	{
		//checks input
		if(aPriority > 0)
			this.priority = aPriority;
		else
			this.priority = 1;
	}

	//Sets the time
	public void setTime(double aTime) 
	{
		//checks input
		if(aTime > 0)
			this.time = aTime;
		else
			this.time = 1;
	}

	//Sets the name
	public void setName(String aName) 
	{
		this.name = aName;
	}

	//Returns a string of the instance variables 
	public String toString()
	{
		return "Name: " + this.name + " Time: " + this.time + " Priority: " + this.priority;
	}
	
}
