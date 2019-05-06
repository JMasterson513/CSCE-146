//Joseph Masterson

public class LinkedListQueue<T> {

	private class ListNode
	{
		//Instance variables for the inner class
		private T data;
		private ListNode link;
		
		//Default Constructor
		public ListNode()
		{
			data = null;
			link = null;
		}
		
		//Parameterized Constructor
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//Instance variables for the outer class
	private ListNode head; //first node in the queue
	private ListNode tail; //last node in the queue
	
	//Adds a new node to the end of the queue
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		
		if(head == null)
		{
			head = tail = newNode;
			return;
		}
		
		tail.link = newNode;
		tail = newNode;
	}
	
	//Removes and returns the first node
	public T dequeue()
	{
		if(head == null)
			return null;
		
		T returnValue = head.data;
		head = head.link;
		return returnValue;
	}
	
	//Returns the data in the first node, but does not remove the node
	public T peek()
	{
		if(head == null)
			return null;
		
		return head.data;
	}
	
	//Prints out the queue
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}	
}
