//Joseph Masterson

public class ProcessHeap {
	
	private Process[] heap; // an array of type Process which represents the heap
	private int size; //number of elements in the array
	public static final int DEF_SIZE = 128; //Default Size for the array
	
	//Default Constructor
	public ProcessHeap()
	{
		init(DEF_SIZE);
	}
	
	//Parameterized Constructor
	public ProcessHeap(int aSize)
	{
		init(aSize);
	}
	
	//Method which creates an array of the input size
	private void init(int aSize)
	{
		//Unable to initialize
		if(aSize <= 0)
			return;
		heap = new Process[aSize]; //initializes array
		size = 0; //nothing currently in array
	}
	
	//Inserts a new process into the heap
	public void insert(Process aProcess)
	{
		//Heap is full
		if(size >= heap.length)
			return;
		heap[size] = aProcess; //sets the element
		bubbleUp(); //puts element in the proper place
		size++; //increases the size
	}

	//Bubbles the elements up to the correct spot
	private void bubbleUp()
	{
		int index = size; //last index
		
		//While the ordering is till wring
		while(index > 0 &&
				heap[(index - 1) / 2].getPriority() - heap[index].getPriority() < 0)
		{
			//SWAP
			Process temp = heap[(index - 1) / 2];
			heap[(index - 1) / 2] = heap[index];
			heap[index] = temp;
			index = (index - 1) / 2;
		}	
	}
	
	//Returns the element at the head
	public Process peek()
	{
		return heap[0];
	}
	
	//Removes the element at the head
	public Process remove()
	{
		Process retVal = heap[0]; //Return value is the root
		heap[0] = heap[size - 1];
		heap[size - 1] = null; //removes duplicate
		size--; //Decrease the size of the heap
		bubbleDown();
		return retVal; //returns value
	}
	
	//Bubbles down to keep heap organized
	private void bubbleDown()
	{
		int index = 0;
		while(index * 2 + 1 < size) //While we have a left child
		{
			//Assume the left is larger
			int bigIndex = index * 2 + 1;
			
			//Confirm that it is
			if(index * 2 + 2 < size &&
					heap[index * 2 + 1].getPriority() - heap[index * 2 + 2].getPriority() < 0)
				bigIndex = index * 2 + 2;
			
			//Check is parent is less than child
			if(heap[index].getPriority() - heap[bigIndex].getPriority() < 0)
			{
				//Swap
				Process temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
	
			else
				break;	//parent was larger than both children
			index = bigIndex;
		}
	}
	
	
	//Prints the heap in breadth order
	public void printHeap()
	{
		for(int i = 0; i < size; i++)
			System.out.println(heap[i]);
	}
	
	//Checks to see if the heap is empty or not
	public boolean isEmpty()
	{
		if(heap == null) //if the heap is empty
			return true;
		return false; //heap is not empty
	}
	
	//Prints the heap in reverse sorted order
	public void heapSort()
	{
		for(int i = 0; i < size; i++)
			System.out.println(this.remove());
	}
}
