//Joseph Masterson

public class GenLinkedList <T>{

	private class ListNode{
		
		//Instance variables
		private T data;
		private ListNode link;
		
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//Instance variables
	private ListNode head; //first element of the list
	private ListNode curr; //element currently on
	private ListNode prev; //the previous element
	
	//Constructor
	public GenLinkedList()
	{
		head = null;
		curr = null;
		prev = null;
	}
	
	//Method to insert data
	public void insert(T aData)
	{
		ListNode newNode = new ListNode(aData, null); 
		
		//Checks to see if the node should be added at the head
		if(head == null)
		{
			head = newNode;
			curr = head;
			return;
		}
		
		//Adds the new node at the tail
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}
	
	//Deletes the current node
	public void remove()
	{
		//checks to make sure current is not at the head
		if(curr != null && prev != null)
		{
			//move links foward
			prev.link = curr.link;
			curr = curr.link;
		}
			
		//In case current is at the head
		else if(curr != null && prev == null)			
		{
			//move head foward
			head = head.link;
			curr = head;
		}
	}
	
	//Gets the value at the current node
	public T getCurrent()
	{
		//makes sure the value exists before returning it
		if(curr != null)
			return curr.data;
		else
			return null;
	}
	
	//Moves the current to the next node
	public void goToNext()
	{
		//makes sure current is not null before moving forward
		if(curr != null)
		{
			prev = curr;
			curr = curr.link;
		}
		else
			return;
	}
	
	//Moves current back a node
	public void goToPrev()
	{
		//makes sure the previous node exists
		if(curr == null || prev == null)
			return;
		curr = prev;
		
		//finds the node previous to the previous node
		ListNode temp = head;
		while(temp != prev)
		{
			temp = temp.link;
		}
		prev = temp;
	}
	
	//resets the current back to the head and the previous to null
	public void reset()
	{
		curr = head;
		prev = null;
	}
	
	//prints out the values stored in the list
	public void print()
	{
		//loops through the entirety of the list
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	//Checks to see if there is more elements of the list
	public boolean hasMore()
	{
		return curr != null;
	}
	
	//Finds a specific node in the list
	private ListNode findNode(T aData)
	{
		//loops through the list looking for the specific node
		ListNode temp = head;
		while( temp != null)
		{
			if(temp.data.equals(aData))
				return temp;
			temp = temp.link;
		}
		return null;
	}
	
	//Goes to the node found by the findNode method
	public void goToNode(T aData)
	{
		//loops through until current is at the proper node
		ListNode temp = this.findNode(aData);
		
		if(temp == null)
			return;
		this.reset();
		while(this.hasMore() && curr != null)
			this.goToNext();
	}	
}
