//Joseph Masterson
import java.util.Random;

public class SortingComparison {

	public static final int RUN_NUM = 20; //number of times to run the sort
	public static final int RAND_MAX = 1000; //maximum value of the random number and size of array
	public static int quickNum; //value which counts quickSort
	public static void main(String[] args) 
	{
		Random rand = new Random(); //instance of type Random
		int selectionCount = 0; //value for selection sort
		int bubbleCount = 0; //value for bubble sort
		int mergeCount = 0; //value for merge sort
		int quickCount = 0; //value for quick sort
		
		System.out.println("----------------------\n"
				+ "Sorting Method Complexity Tester\n"
				+ "----------------------");
		
		//Runs 20 times
		for(int i = 0; i < RUN_NUM; i++)
		{
			System.out.println("-----------\n"
					+ "Running Test " + i);
			
			//Initializes the original array
			int[] a = new int[RAND_MAX];
			
			//Populates the array
			for(int j = 0; j < RAND_MAX; j++)
				a[j] = rand.nextInt(RAND_MAX);
			
			//Selection Sort
			int[] b = a.clone(); //clones the array
			selectionCount += selectionSort(b); //increases selection count
			
			//Bubble Sort
			int[] c = a.clone(); //clones the array
			bubbleCount += bubbleSort(c); //increases bubble count
			
			//Merge Sort
			int[] d = a.clone(); //clones the array
			mergeCount += mergeSort(d); //increases the merge count
			
			//Quick Sort
			quickNum = 0; //makes sure quickNum is 0
			int[] e = a.clone(); //clones the array
			quickSort(e, 0, RAND_MAX - 1); //runs quick sort
			quickCount += quickNum; //increases quick count
			
			
			System.out.println("Test " + i + " Completed"
					+ "\n-----------");
			
		}

		//Calculates the average number of checks and prints it
		System.out.println("----------------------\n"
				+ "Average Checks\n"
				+ "----------------------\n"
				+ "Selection Sort: " + selectionCount / RUN_NUM 
				+ "\nBubble Sort: " + bubbleCount / RUN_NUM
				+ "\nMerge Sort: " + mergeCount / RUN_NUM
				+ "\nQuick Sort: " + quickCount / RUN_NUM);
	}
	
	//500500
	//Selection sort method returns the count
	public static int selectionSort(int[] a)
	{
		int count = 0;
		int size = a.length;
		
		for(int i = 0; i < size; i++)
		{
			int min = i; //minimum index
			for(int j = i + 1; j < size; j++)
			{
				//compares each value to the min
				if(a[j] < a[min])
					min = j;
				count++;
			}
			//switch the values
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
		return count;
	}
	
	//one million
	//Bubble sort methd=od
	public static int bubbleSort(int[] a)
	{
		boolean hasSwapped = true;
		int count = 0;
		
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i < a.length - 1; i++)
			{
				count++;
				if(a[i] > a[i + 1])
				{
					//swaps the elements
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					hasSwapped = true;
				}
			}
		}
		return count;
	}
	
	//9000 or 10000
	//Merge Sort Method
	public static int mergeSort(int[] a)
	{
		int size = a.length;
		int count = 0;
		
		if(size < 2)
			return 0;
		
		//Splits the input array into two arrays
		int mid = size / 2;
		int leftSide = mid;
		int rightSide = size - mid;
		int[] left = new int[leftSide];
		int[] right = new int[rightSide];
		
		for(int i = 0; i < mid; i++)
			left[i] = a[i];
		
		for(int i = mid; i < size; i++)
			right[i - mid] = a[i];
		
		mergeSort(left); //breaks down the left array
		mergeSort(right); //breaks down the right array
		count += merge(left, right, a); //sorts the arrays and puts them together
		return count; //returns the count
	}
	
	//sorts the arrays and orders them
	public static int merge(int[] left, int[] right, int[] a)
	{
		
		int leftSize = left.length; //size of the left array
		int rightSize = right.length; //size of the right array
		int i = 0; //left index
		int j = 0; //right index
		int k = 0; //a index
		int count = 0;
		
		while(i < leftSize && j < rightSize)
		{
			//checks the left array compared to the right array
			if(left[i] <= right[j])
			{
				a[k] = left[i]; //adds left elements
				i++;
				k++;
			}
			
			else
			{
				a[k] = right[j]; //adds right elements
				j++;
				k++;
			}
			count++;
		}
		
		//adds remaining elements
		while(i < leftSize)
		{
			a[k] = left[i];
			i++;
			k++;
			count++;
		}
		
		//adds remaining elements
		while(j < rightSize)
		{
			a[k] = right[j];
			j++;
			k++;
			count++;
		}
		return count;
	}
	
	//close to merge sort but high variance
	//quick sort method
	public static void quickSort(int[] a, int leftIndex, int rightIndex)
	{
		//calls partition to sort the array
		int pIndex = partition(a, leftIndex, rightIndex);
		
		//sorts the lefr array
		if(leftIndex < pIndex - 1)
			 quickSort(a, leftIndex, pIndex - 1);

		//sorts the right array
		if(rightIndex > pIndex)
			quickSort(a, pIndex, rightIndex);
	}
	
	//
	public static int partition(int[] a, int leftIndex, int rightIndex)
	{
		int i = leftIndex; //left index of the array
		int j = rightIndex; //right index of the array
		int pivot = a[(i + j) / 2]; //value not index
		
		while(i <= j)
		{
			//checks to see if the value at the left is less than the pivot
			while(a[i] < pivot)
			{
				i++;
				quickNum++;
			}
			
			//checks to see if the value at the right is greater than the pivot
			while(a[j] > pivot)
			{
				j--;
				quickNum++;
			}
			
			//swaps the values in the left and right
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
}
