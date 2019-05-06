//Joseph Masterson
import java.util.*;
import java.io.*;


public class MovieDatabase {

	private GenLinkedList<Movie> database;
	private static final String DELIM = "\t";
	
	//Default constructor
	public MovieDatabase()
	{
		database = new GenLinkedList<Movie>();
	}
	
	//Adds a movie to the list
	public void add(Movie aMovie)
	{
		//utilizes the method from the GenLinkedList class
		database.insert(aMovie);
	}
	
	//Deletes the current element of the linked list
	public void remove(String title)
	{
		//Sets the  current back from the head
		database.reset();
		Movie curr = database.getCurrent();
		while(!curr.getName().equals(title)) //checks to see if the title of the movie is the same as that of the movie in the list
		{
			database.goToNext();
		}
		database.remove(); //removes the movie
	}
	
	//Creates a linked list from the data read in a file
	public void readMovieFile(String fileName)
	{
		database = new GenLinkedList<Movie>();
		try
		{
			database = new GenLinkedList<Movie>();
			
			Scanner fileScanner = new Scanner(new File(fileName));
			
			while(fileScanner.hasNextLine())
			{
				String nextLine = fileScanner.nextLine();
				String[] splitString = nextLine.split(DELIM);
				if(splitString.length != 5)
					continue;
				database.insert(new Movie(splitString[0],
						Integer.parseInt(splitString[1]),
						Integer.parseInt(splitString[2]),
						splitString[3],
						Integer.parseInt(splitString[4])));
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Writes the list to a file
	public void writeToFile(String fileName)
	{
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			database.reset();
			
			//writes each instance of movie to the file
			while(database.hasMore())
			{
				Movie aMovie = database.getCurrent();
				
				fileWriter.println(aMovie.getName() + DELIM +
						aMovie.getYear() + DELIM + 
						aMovie.getRating() + DELIM +
						aMovie.getDirector() + DELIM +
						aMovie.getGross());
				database.goToNext();
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Prints out the elements of the linked list
	public void print()
	{
		//sets the current back to the head
		database.reset();
		
		//prints each element of the list
		while(database.hasMore())
		{
			Movie aMovie = database.getCurrent();
			System.out.println(aMovie.toString());
			database.goToNext();
		}
		
	}
	
	//create a method to search by title
	public GenLinkedList<Movie> searchTitle(String criteria)
	{
		//resets the current and loops through
		database.reset();
		GenLinkedList<Movie> result = new GenLinkedList<Movie>();
		boolean check = false;
		while(database.hasMore())
		{
			if(criteria.equals(database.getCurrent().getName()))
			{
				result.insert(database.getCurrent());
				check = true;
			}
			database.goToNext();
		}
		
		//prints off whether the movie was found or not
		if(!check)
			System.out.println("Movie was not found");
		else
		{
			System.out.println("Search Results");
			result.print();
		}
		return result;
	}
	
	//Method to search by the director 
	public GenLinkedList<Movie> searDirector(String criteria)
	{
		//resets the current and loops through
		database.reset();
		GenLinkedList<Movie> result = new GenLinkedList<Movie>();
		boolean check = false;
		while(database.hasMore())
		{
			if(criteria.equals(database.getCurrent().getDirector()))
			{
				result.insert(database.getCurrent());
				check = true;
			}
			database.goToNext();
			}
				
		//prints off whether the movie was found or not
		if(!check)
			System.out.println("Movie was not found");
		else
		{
			System.out.println("Search Results");
			result.print();
		}		
		return result;
	}
	
	//method to search by year
	public GenLinkedList<Movie> searchYear(int crit)
	{
	 	//resets the current and loops through
		database.reset();		
		GenLinkedList<Movie> result = new GenLinkedList<Movie>();
		boolean check = false;
		while(database.hasMore())
		{			
			if(crit == database.getCurrent().getYear())
			{
				result.insert(database.getCurrent());
				check = true;
			}
			database.goToNext();
		}
		
		//prints off whether the movie was found or not			
		if(!check)
			System.out.println("Movie was not found");
		else	
		{
			System.out.println("Search Results");
			result.print();
		}
		return result;	
	}
	
	//method to search by rating
	public GenLinkedList<Movie> searchRating(int rating)
	{
		//resets the current and loops through
		database.reset();
		GenLinkedList<Movie> result = new GenLinkedList<Movie>();
		boolean check = false;
		while(database.hasMore())
		{
			if(rating == database.getCurrent().getRating())
			{
				result.insert(database.getCurrent());
				check = true;
			}
			database.goToNext();
		}
					
		//prints off whether the movie was found or not
		if(!check)
			System.out.println("Movie was not found");
		else
		{
			System.out.println("Search Results");
			result.print();
		}		
		return result;	
	}
}
