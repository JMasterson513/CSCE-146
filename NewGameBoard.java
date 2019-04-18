//Joseph Masterson
import java.util.*;
import java.io.*;

public class NewGameBoard {

	//Instance variable
	private String[][] board;
	public static final int SIZE = 10; //Standard size of the board
	
	//Default Constructor
	public NewGameBoard()
	{
		this.board = new String[SIZE][SIZE];
	}
	
	//Returns the board
	public String[][] getGameBoard()
	{
		return this.board;
	}

	/*Method which reads in a gameBoard from the file
	 * the file is formatted with no spaces and is just characters across
	 */
	public void readFromFile(String fileName)
	{
		try
		{
			//Creates a Scanner to read from the file
			Scanner fileScanner = new Scanner(new File(fileName));
			int vertical = 0; //Keeps track of the current row
			
			while(fileScanner.hasNextLine())
			{
				String input = fileScanner.nextLine(); //reads in the command from the file
				
				//Loops through the input and adds it to the board
				for(int i = 0; i < SIZE; i++)
				{
					char newElement = input.charAt(i);
					this.board[vertical][i] = String.valueOf(newElement); //adds each character of the line into the board one by one
				}
				vertical++; //increases the current row by one
			}
			fileScanner.close(); //closes the Scanner
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
