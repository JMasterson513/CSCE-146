//Joseph Masterson

public class Robot {

	//Instance variables
	private int x; //keeps track of the x position
	private int y; //keeps track of the y position
	
	//Default Constructor
	public Robot()
	{
		this.x = 0; 
		this.y = 0;
	}
	
	//Returns the x position
	public int getX()
	{
		return this.x;
	}
	
	//Returns the y position
	public int getY()
	{
		return this.y;
	}
	
	//Moves the y position up 1 while it remains in bounds
	public void moveUp()
	{
		if(this.y - 1 >= 0)
			this.y--;
	}
	
	//Moves the y position down 1 while it remains in bounds
	public void moveDown(int param)
	{
		if(this.y + 1 <= param)
			this.y++;
	}
	
	//Decreases the x position by 1 while it remains in bounds
	public void moveLeft()
	{
		if(this.x - 1 >= 0)
			this.x--;
	}
	
	//Increases the x position by 1 while it remains in bounds
	public void moveRight(int param)
	{
		if(this.x + 1 <= param)
			this.x++;
	}
}
