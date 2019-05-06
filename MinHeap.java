//Joseph Masterson

public class MinHeap {

	private Sheep[] heap; //array of sheep
	private int lastIndex; //the first null element
	public static final int DEF_SIZE = 128; //default size to set heap
	
	//Initializes heap with the default size
	public MinHeap()
	{
		init(DEF_SIZE);
	}
	
	//Initializes heap with the input size
	public MinHeap(int aSize)
	{
		init(aSize);
	}
	
	//Creates a heap of the proper size
	private void init(int aSize)
	{
		if(aSize <= 0)
			return;
		heap = new Sheep[aSize];
	}
	
	//Adds a sheep to the heap
	public void addSheep(Sheep aSheep)
	{
		//Heap is full
		if(lastIndex >= heap.length)
			return;
		heap[lastIndex] = aSheep;
		climbUp(); //puts the sheep in the proper place
		lastIndex++;
	}
	
	//Has the sheep climb the heap and get in the right place
	private void climbUp()
	{
		int index = lastIndex;
		
		while(index > 0 && heap[pIndex(index)].getWeight() > heap[index].getWeight()) //checks to see if its in the right place
		{
			//Swap
			Sheep temp = heap[pIndex(index)];
			heap[pIndex(index)] = heap[index];
			heap[index] = temp;
			index = pIndex(index);
		}
	}
	
	//Gets the index of the parent
	private int pIndex(int index)
	{
		return (index - 1) / 2;
	}
	
	//Index of the left child
	private int lIndex(int index)
	{
		return index * 2 + 1;
	}
	
	//Index of the right child
	private int rIndex(int index)
	{
		return index * 2 + 2;
	}
	
	//returns the first element
	public Sheep peekSheep()
	{
		return heap[0];
	}
	
	//Returns and then removes the first sheep in the heap
	public Sheep removeSheep()
	{
		Sheep temp = peekSheep();
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex - 1] = null;
		lastIndex--;
		climbDown();
		return temp;
	}
	
	//move the sheep down to the correct place
	private void climbDown()
	{
		int index = 0; //start from root
		while(lIndex(index) < lastIndex && rIndex(index) < lastIndex)
		{
			int rIndex = rIndex(index);
			int smallIndex = lIndex(index); //assume left is smaller
			if(heap[smallIndex].getWeight() > heap[rIndex].getWeight())
				smallIndex = rIndex(index); //right was actually smaller
			
			if(heap[index].getWeight() > heap[smallIndex].getWeight())
			{
				//swap
				Sheep temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			else
				break; //did not have to swap
			index = smallIndex;
		}
	}
	
	//Prints the sheep in breadth order
	public void sheepRollCall()
	{
		for(int i = 0; i < lastIndex; i++)
			System.out.println(heap[i].toString());
	}
	
	
	//Method to clone the heap
	public MinHeap clone()
	{
		MinHeap ret = new MinHeap(this.heap.length); //creates a new heap of the same size
		for(int i = 0; i < this.lastIndex; i++)
			ret.addSheep(new Sheep(heap[i].getName(), heap[i].getWeight())); //creates new sheep and add them to the heap
		return ret; //return the sheep
	}
	
	//Returns an array of sheeps properly sorted
	public Sheep[] sheepHeapSort()
	{
		int check = this.lastIndex;
		Sheep[] array = new Sheep[check]; //creates the array to be returned
		MinHeap clone = this.clone(); //clones the min heap
		
		//adds each element to the array
		for(int i = 0; i < check; i++)
		{
			if(this.heap[i] != null)
				array[i] = clone.removeSheep();
		}
		return array; //returns the array
	} 
}




















