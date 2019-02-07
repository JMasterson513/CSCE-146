//Joseph Masterson
import java.util.*;
import java.io.*;


public class ShowCase {

	//Constant
	public static final String DELIM = "\t";
		
	//Instance variables
	private Prize[] showCase;
	private int showLength;
	
	//Default Constructor
	public ShowCase()
	{
		this.showLength = 0;
		this.showCase = new Prize[this.showLength];
	}
	
	//Parameterized Constructor
	public ShowCase(int aShowLength)
	{
		this.setShowLength(aShowLength);
		this.showCase = new Prize[this.showLength];
	}
	
	//getter for show case length
	public int getShowLength()
	{
		return this.showLength;
	}
	
	//Setter for show case length
	public void setShowLength(int aShowLength)
	{
		if(aShowLength > 0)
			this.showLength = aShowLength;
	}
	
	/*Reads the file and creates the prize list array
	 * counts the number of lines and then creates an array of that size
	 * then reads the file and adds elements to the array
	 */
	public Prize[] readPrizeFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			
			//Counter to get the size of the array
			int counter = 0;
			
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				counter++;
			}
			
			//Initializes the array read from the file
			Prize[] prizeList = new Prize[counter];
			
			//Pass through the file again to and reset the scanner
			fileScanner = new Scanner(new File(fileName));
			counter = 0;
			
			while(fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine(); //reads the line
				String[] splitLine = line.split(DELIM); //splits the line at the tab
				if(splitLine.length != 2) //checks the line
					continue;
				prizeList[counter] = new Prize(splitLine[0], Integer.parseInt(splitLine[1]));
				counter++;
			}
			
			//Closes the scanner and returns the array
			fileScanner.close();
			return prizeList;
		}
		catch(Exception e) //catches the exceptions
		{
			System.out.println(e);
		}
		return null;
	}
	
	/*Populate the show case with five random elements from the prize list
	 * uses the random class to randomly select the prizes in the showCase
	 */
	public Prize[] popShowCase(Prize[] prizeList)
	{
		//Declares an object of type random
		Random rand = new Random();
		
		//Populates the showCase array with random elements from the prizeList
		for(int i = 0; i < this.showLength; i++)
		{
			int take = rand.nextInt(prizeList.length - 1);
			
			this.showCase[i] = prizeList[take];
		}
		//Returns the showCase
		return this.showCase;
	}
	
	//Prints the names of the items in the showCase
	public void printName()
	{
		for(Prize p : this.showCase)
			System.out.println(p.getName());
	}
	
	//Totals the price of the prizes in the showCase
	public double showCasePrice()
	{
		double value = 0;
		for(int i = 0; i < this.showLength; i++)
			value += this.showCase[i].getPrice();
		return value;
	}
	
	//Compares the guess to the total price
	public String compare(double guess)
	{
		double total = this.showCasePrice();
		
		if(guess < total && total - guess < 2000)
			return "Your guess was under!  You win!";
		else if(guess == total)
			return "Your guess was the exact number! You win!";
		else
			return "I'm sorry but that guess was bad.  You lose for being bad";
	}
}
