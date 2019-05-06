//Joseph Masterson

public class SongPlaylist {

	//Instance variables
	private GenQueueLL<Song> playlist = new GenQueueLL<Song>(); //a linked queue of type song
	
	//takes an instance of a song and adds it to the queue
	public void addSong(Song aSong)
	{
		playlist.enqueue(aSong);
	}
	
	//Returns but does not remove the song at the head of the queue
	public Song getCurrentSong()
	{
		Song retSong = playlist.peek();
		return retSong;
	}
	
	//Advances the current song by one second or removes the current song and starts the next song
	public void advanceOneSecond()
	{
		//gets the current song
		Song curr = getCurrentSong();
		
		//Increases the current time by one if there is at least one second left
		if(curr.getTimeRemaining() > 0)
		{
			int currTimeInc = curr.getCurrentTime() + 1;
			curr.setCurrentTime(currTimeInc);
		}
		
		//If the current song has no time remaining it is removed
		else if (curr.getTimeRemaining() <= 0)
		{
			playlist.dequeue();
		}
	}
}
