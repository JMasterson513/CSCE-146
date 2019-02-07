//Joseph Masterson

public class StringCircularLinkedList {

	private class ListNode
	{
		//instance variable
		private String data;
		private ListNode link;
		
		//Constructor
		public ListNode(String aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//Instance Variables
	private ListNode head; //the first element of the list
	private ListNode tail; //last element of the list, connects to the head
	private ListNode curr; //current element of the list
	private ListNode prev; //former element of the list
	private int size; //contains how many elements are in the list
	
	//Constructor - sets everything to null
	public StringCircularLinkedList()
	{
		head = null;
		tail = null;
		curr = null;
		prev = null;
		size = 0;
	}
	
	//returns the size of the list
	public int getSize()
	{
		return size;
	}
	
	/* Inserts data into the list
	 *  Checks if there are elements in the list
	 *  If no then sets the data as the head
	 *  If yes then sets the data as the tail
	 *  Increments the size
	 */
	public void insert(String aData)
	{
		//Creates the node to be added
		ListNode newNode = new ListNode(aData, null);
		newNode.link = head; 
		
		//checks if there is a head
		if(head == null)
		{
			head = newNode;
			newNode.link = head;
			curr = head;
			tail = head;
		}
		
		//inserts it at the tail
		else
		{
			tail.link = newNode;
			tail = newNode;
		}
		size++;
	}
	
	/* Moves the current forward by one node
	 * Moves the current to its link and the previous to current
	 */
	public void goToNext()
	{
		if(curr == null)
			return;
		prev = curr;
		curr = curr.link;
	}
	

	/* Method to move the current back by one element
	 * Moves the current back to the previous and then goes through the whole list to find the element previous to the previous
	 */
	public void goToPrev()
	{	
		if(prev == null)
			return;
		curr = prev;
		
		ListNode temp = prev;
		for(int i = 0; i < size - 1; i++)
			temp = temp.link;
		prev = temp;
	}
	
	/* Gets the data at the current element
	 * If the current element is not null, it returns the data 
	 */
	public String getDataAtCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	
	/* Sets data at the current element
	 * If the current element is not null, replaces the data with the parameter
	 */
	public void setDataAtCurrent(String aData)
	{
		if(curr != null)
			curr.data = aData;
	}
	
	/* Inserts the data after the current
	 * Checks where the current is in the list and then inserts the data
	 * Make sure that the links are set up correctly
	 */
	public void insertAfterCurrent(String aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(curr == null)
			return;
		else if(curr == head)
		{
			head.link = newNode;
			size++;
			return;
		}
		else if(curr == tail)
		{
			curr.link = newNode;
			newNode.link = head;
			size++;
			return;
		}
		curr.link = newNode;
		size++;
	}
	
	/* Deletes the current element of the list
	 * Switches the links to bypass the current element thus erasing the element
	 * Decreases the size
	 */
	public void deleteCurrent()
	{
		if(curr != null && prev == tail)
		{
			head = head.link;
			size--;
			return;
		}
		
		prev.link = curr.link;
		curr = curr.link;
		size--;
	}
	
	/* Method to print the values of the list
	 * Uses a while loop and the size of the list to get and print each value
	 */
	public void print()
	{
		ListNode temp = head;
		int compare = 0;
		
		while(compare < size)
		{
			System.out.println(temp.data);
			compare++;
			temp = temp.link;
		}
		System.out.println();;
	}
	
	/* Method to check whether a value is in the list or not
	 * uses a while loop to loop through the list once and compares each value
	 */
	public boolean isInList(String aData)
	{
		ListNode temp = head;
		int compare = 0;
		
		while(compare < size)
		{
			if(temp.data.equals(aData))
				return true;
			compare++;
			temp = temp.link;
		}
		return false;
	}
}
