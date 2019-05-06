//Joseph Masterson

public class Sorter {

	private static Cylinder[] heap; //static array to be used as a heap
	private static int lastIndex; //last null element of the heap
	
	//Bubble Sort Method
	public static void bubbleSort(Cylinder[] a)
	{
		boolean hasSwapped = true;
			
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i < a.length - 1; i++)
			{
				//If they are in the wrong place
				if(a[i].getVolume() > a[i + 1].getVolume())
				{
					//Swap
					Cylinder temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					hasSwapped = true;	
				}
			}
		}
	}
	
	//Merge sort method
	public static void mergeSort(Cylinder[] a)
	{
		//Gets the size of the array
		int size = a.length;
		
		//Halting Condition
		if(size < 2)
			return;
		
		int mid = size / 2; //middle
		int leftSide = mid; 
		int rightSide = size - mid;
		Cylinder[] left = new Cylinder[leftSide]; //divides array in left half
		Cylinder[] right = new Cylinder[rightSide]; //divides array in right half
		
		//Fills the left array
		for(int i = 0; i < mid; i++)
			left[i] = a[i];
		
		//Fills the right array
		for(int i = mid; i < size; i++)
			right[i - mid] = a[i];
		
		mergeSort(left); //calls self on left
		mergeSort(right); //calls self on right
		merge(left, right, a); //calls merge method
	}
	
	//Sorts and merges the arrays into one whole
	public static void merge(Cylinder[] left, Cylinder[] right, Cylinder[] a)
	{
		int leftSize = left.length; //the length of the left array
		int rightSize = right.length; //the length of the right array
		int i = 0; //left index
		int j = 0; //right index
		int k = 0; //a index
		
		//Puts the arrays in the correct order
		while(i < leftSize && j < rightSize)
		{
			if(left[i].getVolume() <= right[j].getVolume()) //puts left element
			{
				a[k] = left[i];
				i++;
				k++;
			}
			
			else //puts right element
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i < leftSize) //if other side ran out
		{
			a[k] = left[i];
			i++;
			k++;
		}
		
		while(j < rightSize) //if other side ran out
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	//Heap Sort method
	public static void heapSort(Cylinder[] a)
	{
		heap = new Cylinder[a.length]; //initializes the static heap of the size of the array
		lastIndex = 0; //sets the last null index to 0
		
		//Insert Method
		for(int i = 0; i < a.length; i++)
		{
			//Sets the null element of the input array
			heap[lastIndex] = a[i];
			
			//bubbleUp method
			int index = lastIndex;
			
			while(index > 0 && heap[(index - 1) / 2].getVolume() > heap[index].getVolume()) //checks to see if its in the right place
			{
				//Swap
				Cylinder temp = heap[(index - 1) / 2];
				heap[(index - 1) / 2] = heap[index];
				heap[index] = temp;
				index = (index - 1) / 2;
			}
			lastIndex++; //increases the null element
		}
		
		//Method to delete
		for(int i = 0; i < a.length; i++)
		{
			Cylinder temp = heap[0]; //gets the element at the head
			heap[0] = heap[lastIndex - 1]; //sets the head element to the last element in the array
			heap[lastIndex - 1] = null; //makes the last element null
			lastIndex--; //decreases the last index
			a[i] = temp; //adds element at head to the original array
			
			
			//Bubble Down Method
			int index = 0; //start from root
			while(index * 2 + 1 < lastIndex && index * 2 + 2 < lastIndex) //makes sure it is not out of bounds
			{
				int rIndex = index * 2 + 2; //calculates the right child
				int smallIndex = index * 2 + 1; //assume left is smaller
				if(heap[smallIndex].getVolume() > heap[rIndex].getVolume()) //checks to see if the left is smaller
					smallIndex = index * 2 + 2; //right was actually smaller
				
				//Checks to see if they need to be swapped
				if(heap[index].getVolume() > heap[smallIndex].getVolume())
				{
					//swap
					Cylinder swap = heap[index];
					heap[index] = heap[smallIndex];
					heap[smallIndex] = swap;
				}
				else
					break; //did not have to swap
				index = smallIndex; //moves the index
			}
		}
	}
}
