//Joseph Masterson

public class GenQueueLL<T> {

	//Internal class list node
	private class ListNode{
		
		//Instance variables
		private T data; //saves the data
		private ListNode link; //creates a link to the next node
		
		//Parameterized Constructor
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//Back in outer class
	
	//Instance varaibles
	private ListNode head; //first element of the queue
	private ListNode tail; //last element of the queue
	
	//Default constructor
	public GenQueueLL()
	{
		head = tail = null;
	}
	
	//adds elements at the tail of the queue
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		
		if(head == null) //checks to see if the head is empty
		{
			head = tail = newNode;
			return;
		}
		
		//adds at the tail
		tail.link = newNode;
		tail = newNode;
	}
	
	//returns and then removes elements from the head
	public T dequeue()
	{
		if(head == null) //checks to see if head is empty
			return null;
		
		//returns value at the head and then removes it
		T ret = head.data;
		head = head.link;
		return ret;
	}
	
	//returns the element at the head, does not remove it from the queue
	public T peek()
	{ 
		if(head == null) //checks to see if the head is empty
			return null;
		return head.data;
	}
	
	//Prints out the elements of the queue
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	
}
