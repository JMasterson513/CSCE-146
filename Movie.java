//Joseph Masterson

public class Movie {

	//Instance Variables
	private String name;
	private int year;
	private int rating; // 1 to 5
	private String director;
	private int gross;
	
	//Default constructor
	public Movie()
	{
		this.name = "No Name";
		this.year = 0;
		this.rating = 1;
		this.director = "No Director";
		this.gross = 0;
	}
	
	//Parameterized Constructor
	public Movie(String aName, int aYear, int aRating, String aDirector, int aGross)
	{
		this.setName(aName);
		this.setYear(aYear);
		this.setRating(aRating);
		this.setDirector(aDirector);
		this.setGross(aGross);
	}

	//Accessors
	public String getName() 
	{
		return name;
	}

	public int getYear() 
	{
		return year;
	}
	
	public int getRating() 
	{
		return rating;
	}

	public String getDirector() 
	{
		return director;
	}
	
	public int getGross() 
	{
		return gross;
	}
	
	public void setName(String aName) 
	{
		this.name = aName;
	}

	//Mutators
	public void setYear(int aYear)
	{
		if(aYear >= 0)
			this.year = aYear;
		else
			this.year = 0;
	}
	
	public void setRating(int aRating) 
	{
		if(aRating < 0 || aRating > 5)
			this.rating = 1;
		this.rating = aRating;
	}

	public void setDirector(String aDirector) 
	{
		this.director = aDirector;
	}

	public void setGross(int aGross) 
	{
		this.gross = aGross;
	}
	
	//Checks to see if two objects of class movie are equal
	public boolean equals(Movie aMovie)
	{
		return aMovie != null &&
				this.name.equals(aMovie.getName()) &&
				this.year == aMovie.getYear() &&
				this.rating == aMovie.getRating() &&
				this.director.equals(aMovie.getDirector()) &&
				this.gross == aMovie.getGross();
	}
	
	//overrides the equals method inherent to class object
	public boolean equals(Object o)
	{
		return equals((Movie)o);
	}
	
	//Checks to make sure the object is not empty
	public int compareTo(Movie aMovie)
	{
		if(aMovie != null)
			return 1;
		return 0;
	}
	
	//Returns a string with all the characteristics of a movie
	public String toString()
	{
		return "Name: " + this.name + " Year: " + this.year 
				+ " Rating: " + this.rating + " Director: " + this.director
				+ " Box Office Gross: " + this.gross;
	}
	
	
}
