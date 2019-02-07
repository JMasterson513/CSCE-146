//Joseph Masterson

import java.util.Scanner;

public class ShowCaseGame {
	
	public static final int SHOWCASE_SIZE = 5;
	public static final String FILE_NAME = "prizeList.txt";
	public static void main(String[] args) {
	
		//Creates an object of class ShowCase
		ShowCase overall = new ShowCase(SHOWCASE_SIZE);
		
		//Creates an object of class Scanner
		Scanner key = new Scanner(System.in);
		
		//Creates the array of prizes
		Prize[] prizeList = overall.readPrizeFile(FILE_NAME);
		
		
		String quit = "yes";
		
		while(!quit.equalsIgnoreCase("no"))
		{
			//Creates the show case array
			overall.popShowCase(prizeList);
			
			//Prints the name of the five prizes
			System.out.println("Welcome to the showcase show down!\n"
					+ "Your prizes are:");
			overall.printName();
			
			//Prompts the user for the prize of the prizes
			System.out.println("You must guess the total cost of all without going over\n"
					+ "Enter your guess:");
			double guess = key.nextDouble();	
			key.nextLine();
			
			//Calculates the distance between the guess and the actual price and thus the verdict
			System.out.println("You guessed " + guess + " the actual price is " + overall.showCasePrice()
			+ "\n" + overall.compare(guess) + "\nWould you like to play again? Enter 'no' to quit");
			quit = key.nextLine();
		}
		
		//Closes the scanner
		key.close();
		
		//Quits the program
		System.exit(0);
	}

}
