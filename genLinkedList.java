import GenLL.ListNode;

//Joseph Masterson

public class genLinkedList <T> {
	
	//Internal class
	private class ListNode
	{
		private T data;
		private ListNode link;
		
		//constructor
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
		
	//Instance variables
	private ListNode head; //points to the first item in the list
	private ListNode curr; //current node of interest
	private ListNode prev; //one node behind current
	private int size;
	
	public genLinkedList()
	{
		head = curr = prev = null;
		size = 0;
	}
	
	public void insert(T aData)
	{
		ListNode newNode = new ListNode(aData, null); //insert at the end of the list
		
		if(head == null) //the list is empty
		{
			/*two variables pointing at the same memory space currently
			 * but when the method is done running only the head will be pointing at the memory
			 */
			head = newNode;
			curr = head; //same as curr = newNode
			size++;
			return;
		}
		
		//Starts at the start of the list
		ListNode temp = head;
		
		/*moves object by object
		 * Equivalent to a for loop
		 */
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
		size++;
	}
	
	//Gets the value at current
	public T getCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	
	//Goes to the next element of the list
	public void goToNext()
	{
		if(curr == null)
			return;
		prev = curr;
		curr = curr.link;
	}
	
	public int getSize()
	{
		return size;
	}
}
