//Joseph Masterson

public class InputString {

	private String input; //The string given by the user
	private int bortNum; //the number of times bort is used in the given string
	
	//Default Constructor
	public InputString()
	{
		this.input = "No Input";
		this.bortNum = 0;
	}
	
	//Parameterized Constructor - cannot set the number of borts in the constructor
	public InputString(String anInput)
	{
		this.setInput(anInput);
	}

	public String getInput() 
	{
		return input;
	}

	public int getBortNum() 
	{
		return bortNum;
	}

	public void setInput(String anInput) 
	{
		this.input = anInput;
	}

	private void setBortNum(int aBortNum)
	{
		if(aBortNum >= 0)
			this.bortNum = aBortNum;
	}
	
	public void calculateBortNumRe()
	{
		calculateBortNumRe(this.input.toLowerCase(), 0);
	}
	
	private void calculateBortNumRe(String aLine, int aCount)
	{
		if(aLine.length() < 4)
		{
			setBortNum(aCount);
			return;
		}
		else if(aLine.contains("bort"))
			aCount++;
		int index = aLine.indexOf("bort") + 4;
		aLine = aLine.substring(index);
		calculateBortNumRe(aLine, aCount);
	}	
}
