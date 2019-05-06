import java.io.File;
import java.util.*;

public class findWords {
	
	private char[][] table;
	private static LinkedList<String> dictionary; //linked list of all the words in the dictionary file
	private static String fileName = "dict2.txt"; //name of the dictionary file being read in
	private static final int DEF_SIZE = 5; //default size of the table
	private static LinkedList<String> previousWords = new LinkedList<String>();
	LinkedList<String> markedVerts = new LinkedList<String>();
	
	//Default Constructor only
	public findWords()
	{
		table = new char[DEF_SIZE][DEF_SIZE]; //initializes the table
		readFromFile(fileName); //initializes the dictionary
	}
	
	//Method to add a vertex to the graph, just adds char in the correct order
	public void addVert(char aChar)
	{
		for(int i = 0; i < table.length; i++)
			for(int j = 0; j < table[i].length; j++)
			{
				if(isNull(i, j)) //checks to see if the current element is null or not
				{
					table[i][j] = aChar; //adds the character to the null element
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
	
	
	public void findWord()
	{
		String word = "";
		for(int i = 0; i < table.length; i++)
			for(int j = 0; j < table[i].length; j++)
			{
				markedVerts.clear();
				System.out.println("Starting at " + i + " " + j);
				findWord(i, j, word);
			}
	}
	
	private void findWord(int row, int column, String word)
	{
		
		markedVerts.clear();
		for(int i = 0; i < word.length(); i++)
		{
			char addChar = word.charAt(i);
			markedVerts.add(getIndex(addChar, markedVerts)); //TODO
		}
		
		char aChar = table[row][column];
		word = word + aChar;
		//System.out.println("Word :" + word);
		
		if(word.length() > 6)
			return;
		if(word.length() > 1 && dictionary.contains(word.toLowerCase()) && !previousWords.contains(word))
		{
			System.out.println("Found Word: " + word);
			previousWords.add(word);
		}
		
		LinkedList<Character> surroundingChars = getSurrounding(row, column);
		int size = surroundingChars.size();
		for(int i = 0; i < size; i++)
		{
			char tempChar = surroundingChars.remove();
			String index = getIndex(tempChar, markedVerts); 
			if(!markedVerts.contains(index))
				findWord(Integer.parseInt(index.charAt(0)), Integer.parseInt(index.charAt(1)), word);
		}
	}
	
	private LinkedList<Character> getSurrounding(int row, int column)
	{
		
		LinkedList<Character> temp = new LinkedList<Character>();
		for(int i = row - 1; i <= row + 1; i++)
		{
			for(int j = column - 1; j <= column + 1; j++)
			{
				if(isValid(i, j))
					temp.add(table[i][j]);
			}
		}
		return temp;
	}

	public boolean isValid(int i, int j)
	{
		if(i < 0 || i >= table.length || j < 0 || j >= table.length)
			return false;
		return true;
	}
	
	//Problem with this method - only gets the first one
	private String getIndex(char aChar, LinkedList<String> markedVerts)
	{
		String ret = null;
		for(int i = 0; i < table.length; i++)
			for(int j = 0; j < table[i].length; j++)
			{
				if(markedVerts.contains(Integer.toString(i) + Integer.toString(j)))
					continue;
				else if(table[i][j] == aChar)
				{
					ret = Integer.toString(i) + Integer.toString(j);
					return ret;
				}
			}
		return ret;
	}
	
	//Reads in the dictionary and creates a linked list of it 
	private void readFromFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			dictionary = new LinkedList<String>();
				
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
				System.out.print(table[i][j] + " ");
			System.out.println();
		}
	}
	
	
	
}
