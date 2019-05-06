//Joseph Masterson

public class Song {

	//Instance Variables
	private String name;
	private String artist;
	private int length;
	private int currentTime;
	
	//Default Constructor
	public Song()
	{
		this.name = "No Name";
		this.artist = "No artist";
		this.length = 0;
		this.currentTime = 0;
	}
	
	//Parameterized Constructor
	public Song(String aName, String anArtist, int aLength)
	{
		this.setName(aName); //sets the name of the song
		this.setArtist(anArtist); //sets the song artist
		this.setLength(aLength); //sets the length of the song
	}

	//returns the name of the song
	public String getName() 
	{
		return name;
	}

	//returns the artist
	public String getArtist() 
	{
		return artist;
	}

	//returns the length of the song
	public int getLength() {
		return length;
	}

	//returns the current time in the song
	public int getCurrentTime() {
		return currentTime;
	}

	//sets the name of the song
	public void setName(String aName) 
	{
		this.name = aName;
	}

	//sets the artist of the song
	public void setArtist(String anArtist) 
	{
		this.artist = anArtist;
	}

	//sets the length of the song
	public void setLength(int aLength)
	{
		if(aLength >= 0)
			this.length = aLength;
		else
			this.length = 0;
	}

	//sets the current time in the song
	public void setCurrentTime(int aCurrentTime) 
	{
		if(aCurrentTime >= 0)
			this.currentTime = aCurrentTime;
		else
			this.currentTime = 0;
	}
	
	//returns a string with the name, artist, and total length
	public String toString()
	{
		return "Name: " + this.name + " Artist: " + this.artist + " Total Length: " + this.length;
	}
	
	//Returns the value of length - currentTime
	public int getTimeRemaining()
	{
		int remain = this.length - this.currentTime;
		return remain;
	}
}
