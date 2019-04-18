//Joseph Masterson
import java.util.Scanner;

public class RobotFrontEnd {
	
	public static final int SIZE = 10;
	public static void main(String[] args)
	{
		Scanner key = new Scanner(System.in); //Scanner to accept user input
		String notPlayAgain = "false"; //Controls the loop
		
		while(!notPlayAgain.equals("true"))
		{
		
			//Creates instance of each of the classes
			RobotQueue que = new RobotQueue();
			NewGameBoard gBoard = new NewGameBoard();
			Robot robot = new Robot();
			
			//gets the file for the board
			System.out.println("Welcome to the Robot Simulator\n"
					+ "Enter file for the Board: ");
			String boardFile = key.nextLine(); 
			
			 //gets the file for the commands
			System.out.println("Enter file for the Robot Commands");
			String commandFile = key.nextLine();
			
			//Reads the commands in from the file
			que.readFromFile(commandFile);
			
			gBoard.readFromFile(boardFile); //Reads in the board from the file
			String[][] board = gBoard.getGameBoard(); //Sets the board equal to a matrix of Strings
			
			int result = 1; //condition on whether to exit loop or not
			int count = 0; //counts how many times the program has looped
			
			//Loop that prints the board and moves the robot
			while(result != 0)
			{
				//checks to see if the robot will hit a mine
				if(board[robot.getY()][robot.getX()].equals("X"))
				{
					System.out.println("CRASH!\n" + 
							"Simulation end");
					break; //breaks out of the loop
				}
				
				//checks to see if the robot has left the board
				else if(robot.getX() >= SIZE || robot.getY() >= SIZE)
				{
					System.out.println("CRASH!\n" + 
							"Simulation end");
					break; //breaks out of the loop
				}
				
				//Prints the game board along with the position of the robot
				for(int i = 0; i < SIZE; i++)
				{
					for(int j = 0; j < SIZE; j++)
					{
						//Checks to see if it is in the spot of the robot
						if(i == robot.getY() && j == robot.getX())
						{
							//Prints the robot
							System.out.print("O");
							continue;
						}
						
						System.out.print(board[i][j]); //prints the board
					}
					System.out.println();
				}
				System.out.print("\n");
		
				//Pulls up the top command
				String command = que.dequeue(); 
				
				//Checks to see if the command exists 
				if(command != null)
				{
					//Performs the command correlating to the string
					switch(command)
					{
						case "Move Down":
							robot.moveDown(SIZE);
							break;
						case "Move Up":
							robot.moveUp();
							break;
						case "Move Right":
							robot.moveRight(SIZE);
							break;
						case "Move Left":
							robot.moveLeft();
							break;
						default:
							System.out.println("Something went wrong");
							break;
					}
				}
				
				//Ends the program if the queue is out of instructions
				else
				{
					System.out.println("Simulation End");
					result = 0;
					break;
				}
				
				//Prints what step the program is currently on 
				System.out.println("Command " + count);
				count++;
			}
			
			//Prompts the user to play again
			System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
			notPlayAgain = key.nextLine();
		}
	
		//Closes the Scanner
		key.close();
		System.exit(0);
	}
}
