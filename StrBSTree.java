//Joseph Masterson

public class StrBSTree {

	private class Node
	{
		//Instance Variables
		private String data;
		private Node leftChild; //length of the string is less than
		private Node rightChild; //length of the string is greater than or equal to
		
		//Default Constructor
		public Node(String aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	
	//Instance variable
	private Node root;
	
	//Default Constructor
	public StrBSTree()
	{
		root = null;
	}
	
	//Method to insert
	public void insert(String aData)
	{
		if(root == null) //no tree yet
			root = new Node(aData);
		else //uses recursive method
			insert(root, aData);
	}
	
	//Recursive method to insert
	private Node insert(Node aNode, String aData)
	{
		if(aNode == null) //found a leaf
			aNode = new Node(aData);
		else if(aData.length() - aNode.data.length() < 0) //go left
			aNode.leftChild = insert(aNode.leftChild, aData);
		else //go right
			aNode.rightChild = insert(aNode.rightChild, aData);
		return aNode;		
	}
	
	//Method to delete a node
	public void remove(String aData)
	{
		root = remove(root, aData); //calls the recursive method
	}
	
	//Recursive method to delete
	private Node remove(Node aNode, String aData)
	{
		//Did not find the value
		if(aNode == null)
			return null;
		
		if(aData.length() - aNode.data.length() < 0) //go left
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if(aData.length() - aNode.data.length() > 0) //go right
			aNode.rightChild = remove(aNode.rightChild, aData);
		else //found the node
		{
			if(aNode.rightChild == null) //None or only left child
				return aNode.leftChild;
			if(aNode.leftChild == null) //right child only
				return aNode.rightChild;
			
			//Two children
			//find minimum in tree
			Node min = findMinInTree(aNode.leftChild);
			aNode.data = min.data;
			remove(aNode.rightChild, min.data); //remove the duplicate
		}
		return aNode;
	}
	
	//Finds the minimum in the tree
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null) //if the tree does not exist
			return null;
		if(aNode.leftChild == null) //found the min node
			return aNode;
		else //gotta keep going
			return findMinInTree(aNode.leftChild); //always go left cause less is on the left
	}
	
	//Prints the tree in pre order
	public void printPreOrder()
	{
		printPreOrder(root);
	}
	
	//Recursive method to print the tree pre order
	private void printPreOrder(Node aNode)
	{
		if(aNode == null) //ran out of values
			return;
		System.out.println(aNode.data); //process
		if(aNode.leftChild != null) //left
			printPreOrder(aNode.leftChild);
		if(aNode.rightChild != null) //right
			printPreOrder(aNode.rightChild);
	}
	
	//Gets the depth of a certain input
	public int getDepth(String aData)
	{ 
		return getDepth(aData, root, 0);
	}
	
	private int getDepth(String aData, Node aNode, int count)
	{
		//if the node does not exist return -1
		if(aNode == null)
			return -1;
		//If we have found the right node return the count
		else if(aNode.data.equals(aData))
			return count;
		//If we are still searching increment the count
		count++;
		
		if(aData.length() - aNode.data.length() < 0) //go left
			return getDepth(aData, aNode.leftChild, count);
		else if(aData.length() - aNode.data.length() > 0) //go right
			return getDepth(aData, aNode.rightChild, count);
		return count;
	}
}
