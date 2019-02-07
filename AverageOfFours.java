//Joseph Masterson

import java.util.Random; //imports random number generator


public class AverageOfFours {

	public static final int value = 9;
	public static final int bigArray = 4;
	public static final int smallArray = bigArray / 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creates the random number generator
		Random ran = new Random();
		
		
		//Creates the 4 by 4 array
		int[][] four = new int[bigArray][bigArray];
		
		//Set random values to each element of the four by four array
		for(int i = 0; i < four.length; i++)
			for(int j = 0; j < four[i].length; j++)
				four[i][j] = ran.nextInt(value);
		
		//Creates the 2 by 2 array
		int[][] two = new int[smallArray][smallArray];
		
		//Initialize the sums and average
		int quadOne  = 0;
		int averageOne = 0;
		int quadTwo = 0;
		int averageTwo = 0;
		int quadThree  = 0;
		int averageThree = 0;
		int quadFour  = 0;
		int averageFour = 0; 
		
		//Calculates the averages and sets 2 by 2 array
		for(int i = 0; i < four.length; i++) {
			for(int j = 0; j< four[i].length; j++)
			{
				if(i < bigArray / 2 && j < bigArray / 2)
				{
					quadOne += four[i][j];
					averageOne = quadOne / bigArray;
					two[0][0] = averageOne;
					
				}
				
				else if(i >= bigArray / 2 && j < bigArray / 2)
				{
					quadTwo += four[i][j];
					averageTwo = quadTwo / bigArray;
					two[1][0] = averageTwo;
				}
				
				else if(i < bigArray / 2 && j >= bigArray / 2)
				{
					quadThree += four[i][j];
					averageThree = quadThree / bigArray;
					two[0][1] = averageThree;
				}
				
				else
				{
					quadFour += four[i][j];
					averageFour = quadFour / bigArray;
					two[1][1] = averageFour;
				}
			}
		}
		
		//Prints the 4 by 4 matrix
		System.out.println("Initial Matrix:");
		for(int i = 0; i < four.length; i++)
		{
			
			for(int j = 0; j < four[i].length; j++)
			{
				System.out.print(four[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//Prints the 2 by 2 matrix
		System.out.println("Result Matrix:");
		for(int i = 0; i < two.length; i++)
		{
			
			for(int j = 0; j < two[i].length; j++)
			{
				System.out.print(two[i][j] + " ");
			}
			System.out.println();
		}

	}

}
