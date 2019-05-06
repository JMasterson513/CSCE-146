//Joseph Masterson
import java.util.Scanner;

public class SongPlaylistFrontEnd {

	public static void main(String[] args) {
		
		//Creates an instance of the scanner
		Scanner key = new Scanner(System.in);
		
		//Welcomes user to the program
		System.out.println("Welcome to the Song PlayList!");

		int quit = 0; //value which tests whether to quit or not
		
	
		//Creates an instance of the playlist
		SongPlaylist playlist = new SongPlaylist();
		
		//A condition to check the loop - it is the sum of the lengths
		int counterCheck = 1;
		
		//Loop to continue prompting the user
		while(quit != 9)
		{
			//prints out the user's options
			System.out.println("\nEnter 1: to Add a Song\n" + 
					"Enter 2: to Start the Playlist\n" + 
					"Enter 9: to Quit");
			quit = key.nextInt(); 
			key.nextLine();
	
			//counts the elapsed time
			int counter = 0;
			switch(quit)
			{
				case 1: //adds a new song to the playlist
					System.out.println("Enter the name, the artist, and the total time (seconds)");
					String name = key.nextLine();
					String artist = key.nextLine();
					int time = key.nextInt();
					playlist.addSong(new Song(name, artist, time)); //adds the song to the playlist
					counterCheck += time; //increases countercheck by the length of the new song
					break;
				case 2: //prints out the playlist
					while(counter < counterCheck) //while the elapsed time is less than the total time
					{
						//prints out the details of the current song and the elapsed time
						System.out.println(playlist.getCurrentSong().toString() 
								+ " Elapsed Time: " + counter);
						playlist.advanceOneSecond(); //advances the songs by one second
						counter++; //increases the counter
					}
					break;
				case 9: //quits the program
					System.out.println("Goodbye");
					break;
				default: //defautlt in case an invalid value is entered
					System.out.println("Incorrect Value Entered");
					break;
			}
		}
		key.close(); //closes the scanner
		System.exit(0);
	}

}
