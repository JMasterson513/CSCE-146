//Joseph Masterson
import java.util.*;
import java.io.*;

public class RobotQueue {

	//Instance variable
	private GenLLQueue<String> queue = new GenLLQueue<String>();
	
	/*Reads in the instructions from a file
	 * The file is formatted as one instruction per line
	 */
	public void readFromFile(String fileName)
	{
		try
		{
			//Creates an instance of a Scanner 
			Scanner fileScanner = new Scanner(new File(fileName));
			String input; //Initializes the input sting
			
			//Read the body
			while(fileScanner.hasNextLine())
			{
				input = fileScanner.nextLine(); //read the line
				queue.enqueue(input); //adds the line to the queue
			}
			fileScanner.close(); //closes the scanner
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Removes and returns the next command
	public String dequeue()
	{
		String command = queue.dequeue();
		return command;
	}
}
