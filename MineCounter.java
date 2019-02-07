//Joseph Masterson

import java.util.Random;

public class MineCounter {
	
	//Instance Variables
	private int arraySize;
	private String[][] gameBoard;
	
	//Default Constructor
	public MineCounter()
	{
		this.arraySize = 0;
		gameBoard = new String[arraySize][arraySize]; 
	}
	
	//Parameterized Constructor
	public MineCounter(int xArraySize)
	{
		this.setArraySize(xArraySize);
		gameBoard = new String[arraySize][arraySize];
	}
	
	//Accessor
	public int getArraySize()
	{
		return this.arraySize;
	}
	
	//Mutator
	public void setArraySize(int xArraySize)
	{
		if(xArraySize > 0)
		{
			this.arraySize = xArraySize;
		}
	}
	
	
	//Methods creates an empty gameBoard
	public void emptyBoard()
	{
		for(int i = 0; i < gameBoard.length; i++)
			for(int j = 0; j < gameBoard[i].length; j++)
				gameBoard[i][j] = "-";
	}
	
	
	//Randomly sets the mines onto the board
	public void setMines(int num)
	{
		int mineCounter = 0;
		
		while(mineCounter < num)
		{
			Random rand = new Random();
			
			int i = rand.nextInt(this.arraySize - 1);
			int j = rand.nextInt(this.arraySize - 1);
			
			if(gameBoard[i][j] != "*")
			{
				gameBoard[i][j] = "*";
				mineCounter++;
			}
		}
	}
	
	//Prints out the gameBoard
	public void printMines()
	{
		for(int i = 0; i < gameBoard.length; i++)
		{
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
	}
	
	//gets the number of mines adjacent to each element of the array
	public void getCount()
	{
		for(int i = 0; i < gameBoard.length; i++)
		{
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				//Keeps the mines as mines
				 if(gameBoard[i][j].equals("*"))
				 {
					 gameBoard[i][j] = "*";
				 }
				 
				 else
				 {
					 //initializes the count
					 int counter = 0;
					 
					 //For the first row
					 if(i == 0 && j != 0)
					 {
						 for(int k = 0; k <= i + 1; k++)
						 {
							 for(int l = j - 1; l <= j + 1 && l < this.arraySize; l++)
							 {
								 if(gameBoard[k][l].equals("*"))
								 {
									 counter++;
								 }
								 gameBoard[i][j] = Integer.toString(counter);
							 }
						 }
					 }
					 
					 //First column
					 else if(i != 0 && j == 0)
					 {
						 for(int k = i - 1; k <= i + 1 && k < this.arraySize; k++)
						 {
							 for(int l = 0; l <= j + 1; l++)
							 {
								 if(gameBoard[k][l].equals("*"))
								 {
									 counter++;
								 }
								 gameBoard[i][j] = Integer.toString(counter);
							 }
						 }
					 }
					 
					 //first element
					 else if(i == 0 && j == 0)
					 {
						 for(int k = 0; k <= i + 1; k++)
						 {
							 for(int l = 0; l <= j + 1; l++)
							 {
								 if(gameBoard[k][l].equals("*"))
								 {
									 counter++;
								 }
								 gameBoard[i][j] = Integer.toString(counter);
							 }
						 }
					 }
					 
					 //The majority of the array
					 else 
					 {
						 for(int k = i - 1; k <= i + 1 && k < this.arraySize; k++)
						 {
							 for(int l = j - 1; l <= j + 1 && l < this.arraySize; l++)
							 {
								 if(gameBoard[k][l].equals("*"))
								 {
									 counter++;
								 }
								 gameBoard[i][j] = Integer.toString(counter);
							 }
						 }
					 }
				 }
			}
		}
	} 
	
}