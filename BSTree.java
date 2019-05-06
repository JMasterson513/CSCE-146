//Joseph Masterson

public class BSTree<T extends Comparable<T>> {
	
	//Inner class
	private class Node
	{
		private T data; //data stored in the node
		private Node leftChild; //less than
		private Node rightChild; //greater than or equal to
		
		//Parameterized Constructor
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	
	//Instance Variables
	private Node root;
	
	//Default Constructor
	public BSTree()
	{
		root = null;
	}
	
	//Inserts into the tree
	public void insert(T aData)
	{
		//If the tree is not initialized inserts a node
		if(root == null)
			root = new Node(aData);
		else //uses recursion
			insert(root, aData);
	}
	
	//Recursive Method to insert the node 
	private Node insert(Node aNode, T aData)
	{
		//Found where it goes
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data) < 0) //go left
			aNode.leftChild = insert(aNode.leftChild, aData);
		else //go right
			aNode.rightChild = insert(aNode.rightChild, aData);
		return aNode;
	}

	//Deletes node with the input data
	public void delete(T aData)
	{
		//Calls the recursive method
		root = delete(root, aData);
	}
	
	//Recursive Method to delete node with the input data
	private Node delete(Node aNode, T aData)
	{
		//Node could not be found
		if(aNode == null)
			return null;
		if(aData.compareTo(aNode.data) < 0) //go left
			aNode.leftChild = delete(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0) //go right
			aNode.rightChild = delete(aNode.rightChild, aData);
		else //found it
		{
			if(aNode.rightChild == null) //checks if there is only one child
				return aNode.leftChild;
			if(aNode.leftChild == null) //checks if there is only one child
				return aNode.rightChild;
			
			//Have both children
			//Moves min up to node
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data; 
			aNode.rightChild = delete(aNode.rightChild, temp.data); //delete the duplicate
		}
		return aNode; //returns node
	}
	
	//Method to find the minimum in the tree
	private Node findMinInTree(Node aNode)
	{
		//If there is no tree
		if(aNode == null)
			return null;
		//We have found the minimum
		if(aNode.leftChild == null)
			return aNode;
		else //go left, keep searching
			return findMinInTree(aNode.leftChild);
	}
	
	//Prints the pre-order traversal
	public void printPreOrder()
	{
		//calls recursive method starting at the root
		printPreOrder(root);
	}
	
	//Recursive method to complete the pre-order traversal
	private void printPreOrder(Node aNode)
	{
		//Checks to see if we have finsihed
		if(aNode == null)
			return;
		System.out.println(aNode.data); //process
		if(aNode.leftChild != null) //left
			printPreOrder(aNode.leftChild);
		if(aNode.rightChild != null) //right
			printPreOrder(aNode.rightChild);
	}
	
	//Prints the in order traversal
	public void printInOrder()
	{
		//Calls recursive method starting at the root
		printInOrder(root);
	}
	
	//Recursive method to complete the in-order traversal
	private void printInOrder(Node aNode)
	{
		//done going through the tree
		if(aNode == null)
			return;
		if(aNode.leftChild != null) //left
			printInOrder(aNode.leftChild);
		System.out.println(aNode.data); //process
		if(aNode.rightChild != null) //right
			printInOrder(aNode.rightChild); 
	}
	
	//Prints the post-order traversal
	public void printPostOrder()
	{
		printPostOrder(root);
	}
	
	//Recursive method to complete the post-order traversal
	private void printPostOrder(Node aNode)
	{
		//done traversing the tree
		if(aNode == null)
			return;
		if(aNode.leftChild != null) //left
			printPostOrder(aNode.leftChild);
		if(aNode.rightChild != null) //right
			printPostOrder(aNode.rightChild);
		System.out.println(aNode.data); //process
	}
	
	//Finds the max in the tree
	public T findMaxInTree()
	{
		//Checks to see if there is a tree
		if(root == null)
			return null;
		else //recursively calls starting at the root
			return findMaxInTree(root).data;
	}
	
	//Recursive method to find the max in the tree
	private Node findMaxInTree(Node aNode)
	{
		//Nothing larger, we have found int
		if(aNode.rightChild == null)
			return aNode;
		else //go right and continue
			return findMaxInTree(aNode.rightChild);
	}
	
	//Delete all nodes greater than the input value
	public void deleteGreaterThan(T aData)
	{
		//makes sure there is a tree
		if(root == null)
			return;
		//Calls the recursive method starting at the root
		deleteGreaterThan(root, aData);
	}
	
	//Recursive method to delete values greater than the input
	private void deleteGreaterThan(Node aNode, T aData)
	{
		//Out of values to delete
		if(aNode == null)
			return;
		
		//If the node is less than the data, go right
		if(aData.compareTo(aNode.data) > 0)
			deleteGreaterThan(aNode.rightChild, aData);
		else //start deleting
		{
			//Delete all the right children
			deleteGreaterThan(aNode.rightChild, aData);
			//Check the left children
			deleteGreaterThan(aNode.leftChild, aData);
			//Delete the current node
			delete(aNode.data);
		}
			
	}
}
