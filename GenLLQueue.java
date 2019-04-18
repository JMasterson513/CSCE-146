import LLQue.ListNode;

//Joseph Masterson

public class GenLLQueue<T> {

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
	private int size; //size of the queue
	
	//Adds a new node to the end of the queue
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		
		if(head == null)
		{
			head = tail = newNode;
			size++;
			return;
		}
		
		tail.link = newNode;
		tail = newNode;
		size++;
	}
	
	//Removes and returns the first node
	public T dequeue()
	{
		if(head == null)
			return null;
		
		T returnValue = head.data;
		head = head.link;
		size--;
		return returnValue;
	}
}