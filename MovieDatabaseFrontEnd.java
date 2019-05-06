//Joseph Masterson
import java.util.Scanner;

public class MovieDatabaseFrontEnd {

	public static final String FILE_NAME = "movieDatabase.txt";
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		MovieDatabase base = new MovieDatabase();
		
		while(true)
		{
			printOptions();
			int option = key.nextInt();
			key.nextLine();
			
			switch(option) {
			case 0:
				System.out.println("Goodbye");
				key.close();
				System.exit(0);
				break;
			case 1:
				base.add(makeMovie());
				break;
			case 2:
				System.out.println("Please enter the title of the movie you would like to remove");
				String remTitle = key.nextLine();
				base.remove(remTitle);
				break;
			case 3:
				//Search for a title
				System.out.println("Please enter the title of the movie(s) you would like to search for");
				String searchTitle = key.nextLine();
				base.searchTitle(searchTitle);
				break;
			case 4:
				//search for director
				System.out.println("Please enter the director of the movie(s) you would like to search for");
				String searchDirector = key.nextLine();
				base.searDirector(searchDirector);
				break; 
			case 5:
				//search by year
				System.out.println("Please enter the year of the movie(s) you would like to search for");
				int searchYear = key.nextInt();
				key.nextLine();
				base.searchYear(searchYear);
				break;
			case 6:
				//search by rating
				System.out.println("Please enter the rating of the movie(s) you would like to search for");
				int searchRate = key.nextInt();
				key.nextLine();
				base.searchRating(searchRate);
				break;
			case 7:
				base.print();
				break;
			case 8:
				base.writeToFile(FILE_NAME);
				System.out.println("Finished Writing the Database");
				break;
			case 9:
				base.readMovieFile(FILE_NAME);
				System.out.println("Finished Loading the Database");
				break;
			default:
				System.out.println("Something went wrong please try again");
			}
		}
	}
	
	public static void printOptions()
	{
		System.out.println("Welcome to the Movie Database "
				+ "Please enter a number for the option you would like"
				+ "\n1: To Add a Movie \n2: To Remove a Movie by its Title"
				+ "\n3: To search for a Title \n4: To search for Movies by a Director"
				+ "\n5: To search for Movies of a given Year \n6: To search for Movies of a certain Rating"
				+ "\n7: To print out all Movies  \n8: To print to a database file"
				+ "\n9: To load a database file  \n0: To quit");
	}
	
	public static Movie makeMovie()
	{
		Scanner key = new Scanner(System.in);
		
		//Gets the title
		System.out.println("Enter the title of the movie");
		String addTitle = key.nextLine();
		
		//Gets the year
		System.out.println("Enter the year the movie was released");
		int addYear = key.nextInt();
		
		//Gets the rating
		System.out.println("Enter the rating of the movie between 1 and 5");
		int addRating = key.nextInt();
		key.nextLine();
		
		//Gets the director
		System.out.println("Enter the director of the movie");
		String addDirector = key.nextLine();
		
		//Gets the gross
		System.out.println("Enter the box office gross of the movie");
		int addGross = key.nextInt();
		key.nextLine();
		
		//initializes the movie
		Movie aMovie = new Movie(addTitle, addYear, addRating, addDirector, addGross);
		 
		//returns the movie
		return aMovie;
	}
}
