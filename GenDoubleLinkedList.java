//Joseph Masterson

public class GenDoubleLinkedList<T> {
	
	private class ListNode{
		
		//Instance variables
		private T data; //the data stored in the link
		private ListNode prevLink; //a link pointing to the previous node
		private ListNode nextLink; //a link pointing to the next node
		
		//Default Constructor
		public ListNode()
		{
			data = null; 
			prevLink = null;
			nextLink = null;
		}
	
		//Parameterized Constructor
		public ListNode(T aData, ListNode aPrevLink, ListNode aNextLink)
		{
			data = aData;
			prevLink = aPrevLink;
			nextLink = aNextLink;
		}
	}
	
	//Instance Variables
	private ListNode head; //first element of the list
	private ListNode curr; //current element of the list
	
	//Constructor
	public GenDoubleLinkedList()
	{
		head = new ListNode();
		curr = head;
	}

	/*Moves the current forward by one
	 * Sets the curr equal to its next link
	 */
	public void goToNext()
	{
		if(curr != null)
			curr = curr.nextLink;
	}
	
	/*Moves the current backwards by one
	 * Sets curr equal to its previous link
	 */
	public void goToPrev()
	{
		if(curr.prevLink != null)
			curr = curr.prevLink;
	}
	
	// returns the data at current
	public T getDataAtCurrent()
	{
		if(curr == null)
			return null;
		return curr.data;
	}
	
	//Sets the data at current
	public void setDataAtCurrent(T aData)
	{
		if(curr != null)
			curr.data = aData;
	}
	
	/* Inserts a node after current
	 * checks to see if there is a current, if not sets the head
	 * checks to see if currents is at the tail, if so sets the previous link to the former end
	 * Otherwise inserts a node in between two other nodes
	 */
	public void insertNodeAfterCurrent(T aData)
	{
		ListNode newNode = new ListNode(aData, null, null);
		if(curr == null) //No list yet
		{
			head = newNode; //no links
			curr = head;
		}
		
		//if current is at the tail
		else if(curr.nextLink == null)
		{
			curr.nextLink = newNode;
			newNode.prevLink = curr;
		}
		
		
		//Curr is anywhere but the tail
		else
		{
			newNode.nextLink = curr.nextLink;
			newNode.prevLink = curr;
			curr.nextLink = newNode;
		}
	}
	
	/* Deletes the current node
	 * checks to see if current is at the head, if so moves the head forward
	 * checks to see if current is at the tail, if so moves the current backwards and drops the link
	 * else moves the next link of the previous node past current 
	 */
	public void deleteCurrentNode()
	{
		//current is at the head
		if(curr.prevLink == null)
			head = curr.nextLink;
			
			
		//if current is at the tail
		if(curr.nextLink == null)
		{
			curr = curr.prevLink;
			curr.nextLink = null;
		}
		
		else
		{
			ListNode temp = curr.prevLink;
			temp.nextLink = curr.nextLink;
			temp = curr.nextLink;
			temp.prevLink = curr.prevLink;
		}
		
	}
	
	/* Prints the list
	 * Loops through the list and prints the data
	 */
	public void showList()
	{
		for(ListNode temp = head; temp != null; temp = temp.nextLink)
			System.out.println(temp.data);
	}
	
	/* Checks to see if the entered value is in the list
	 * loops through each element and compares the entered value to the current value
	 */
	public boolean inList(T aData)
	{
		for(ListNode temp = head; temp.nextLink != null; temp = temp.nextLink)
		{
			if(temp.data.equals(aData))
				return true;
		}
		return false;
	}
	
	/* Inserts a new node at the end of the link
	 * checks to see if data exists at the head, if not becomes the head
	 * else loops until the end of the list and then adds the new node
	 */
	public void insert(T aData)
	{
		ListNode newNode = new ListNode(aData, null, null);
		
		//if the head is empty
		if(head.data == null)
		{
			head = newNode;
			curr = head;
			return;
		}
		
		ListNode temp = head;
		while(temp.nextLink != null)
			temp = temp.nextLink;
		temp.nextLink = newNode;
		newNode.prevLink = temp;
	}
}
