//Joseph Masterson
import java.io.File;
import java.util.*;

public class graph {
	
	//Instance Variable
	private static LinkedList<String> dictionary; //linked list of all the words in the dictionary file
	private static int[][] markedVerts; //list of all the marked vertices
	private static String fileName = "dict2.txt"; //name of the dictionary file being read in
	private char[][] table; //the graph itself
	private static final int DEF_SIZE = 5; //default size of the table
	
	//Default Constructor
	public graph()
	{
		init(DEF_SIZE);
		readFromFile(fileName); //initializes the dictionary
	}
	
	//Parameterized Constructor
	public graph(int size)
	{
		init(size);
		readFromFile(fileName); //initializes the dictionary
	}
	
	//Method to initialize the two arrays
	private void init(int size)
	{
		if(size <= 0)
			return;
		
		table = new char[size][size];
		markedVerts = new int[size][size];
	}
	
	//Method to add a vertex to the graph, just adds char in the correct order
	public void addVert(char aChar)
	{
		for(int i = 0; i < table.length; i++)
			for(int j = 0; j < table[i].length; j++)
			{
				if(isNull(i, j)) //checks to see if the current element is null or not
				{
					table[i][j] = aChar; //adds the character to the null element then leaves
					return;
				}
			}
	}
	
	//Method to check to see if the element is null or not
	private boolean isNull(int i, int j)
	{
		if(table[i][j] == 0) //checks if the element is null
			return true;
		else 
			return false;
	}
	
	//Public method to find the words 
	public void findWords()
	{
		setmarkedVerts(); //sets all the values in the markedVerts array equal to 0
		
		for(int i = 0; i < table.length; i++)
			for(int j = 0; j < table[i].length; j++) //calls every element
			{
				markedVerts[i][j] = 1; //adds the current element to the markedVerts
				System.out.println("Starting at " + i + " " + j);
				findWords(i, j, ""); //calls the recursive method
				setmarkedVerts(); //defaults it again
			}
	}
	
	//Private recursive findWords method
	private void findWords(int row, int col, String word)
	{
		//If the word is longer than 6 we stop
		if(word.length() > 6)
			return;
		
		//Adds the character to the word
		word = word + table[row][col];
		
		//If the word is at least 2 chars long and in the dictionary
		if(word.length() > 1 && dictionary.contains(word.toLowerCase()))
			System.out.println("Word found: " + word); //WE FOUND A WORD!!!!
		
		//Checks all the adjacent elements
		for(int i = row - 1; i <= row + 1; i++)
		{
			for(int j = col - 1; j <= col + 1; j++)
			{
				if(isValid(i, j) && markedVerts[i][j] != 1 && (i != row || j != col))
				{
					markedVerts[i][j] = 1; //adds it to the checked verts array
					findWords(i, j, word); //recursively calls the method
					markedVerts[i][j] = 0; //removes it from the array
				}
			}
		}
	}
	
	//Checks to see if the value is valid
	public boolean isValid(int i, int j)
	{
		if(i < 0 || i >= table.length || j < 0 || j >= table.length) //if it is out of bounds
			return false;
		return true;
	}
	
	//Sets all the values in the array to 0
	private void setmarkedVerts()
	{
		for(int i = 0; i < table.length; i++)
			for(int j = 0; j < table[i].length; j++)
				markedVerts[i][j] = 0;
	}
	
	
	//Reads in the dictionary and creates a linked list of it 
	private void readFromFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName)); //creates a file Scan
			dictionary = new LinkedList<String>(); //initializes the dictionary
			
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine(); //reads in from the file
				dictionary.add(fileLine.toLowerCase()); //adds line to the dictionary
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	//Method to print out the table
	public void print()
	{
		for(int i = 0; i < table.length; i++)
		{
			for(int j = 0; j < table[i].length; j++)
				System.out.print(table[i][j] + " "); //prints out the character and a space
			System.out.println(); //proper formatting
		}
	}
	
	
	
	
	
	
	
	
}
