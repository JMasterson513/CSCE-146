//Joseph Masterson
import java.util.Scanner;

public class BortNumFrontEnd {
	
	public static void main(String[] args)
	{
		//Creates an object of type Scanner
		Scanner key = new Scanner(System.in);
		
		//Prompts the user for input
		System.out.println("Enter any number of strings and I will sort by BORT’s. "
				+ "Once you’re done entering sentences enter \"quit\"");
		String input = "nothing yet";
		
		//Initializes a linked list for the input
		genLinkedList<String> bortList = new genLinkedList<String>();
		
		//Adds the input to the linked list while the input is not quit
		while(!input.equals("quit"))
		{
			input = key.nextLine(); //takes in the input
			if(!input.equals("quit")) //makes sure the input is not quit
				bortList.insert(input);
		}
		
		//Initializes an array of type InputString, the size of the linked list
		InputString[] a = new InputString[bortList.getSize()];
		
		//Loops through the linked list and adds the nodes to the array
		for(int i = 0; i < bortList.getSize(); i++)
		{
			InputString value = new InputString(bortList.getCurrent()); //creates an object of type input string with the string in the list
			value.calculateBortNumRe(); //calculates the number of borts in the string
			a[i] = value; //adds the object to the array
			bortList.goToNext(); //goes to the next element of the list
		}
		
		//Uses merge sort on the array of type InputString
		mergeSort(a);
		
		System.out.println("\nBORT SORTED!!!!\n");
		
		//Prints out the Strings ordered by the number of borts
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i].getInput());
		
		//closes the Scanner
		key.close();
	}
	
	
	public static void mergeSort(InputString[] a)
	{
		int size = a.length;
		
		//returns if the array is sorted
		if(size < 2)
			return;
		
		//splits the input array into two smaller arrays
		int mid = size / 2; 
		int leftSide = mid;
		int rightSide = size - mid;
		InputString[] left = new InputString[leftSide];
		InputString[] right = new InputString[rightSide];
		
		//assigns the the left array half the elements of the input array
		for(int i = 0; i < mid; i++)
			left[i] = a[i];
		
		//assigns the right array to the other half of the elements of the input array
		for(int i = mid; i < size; i++)
			right[i - mid] = a[i];
		
		mergeSort(left); //Recursively sorts the left half
		mergeSort(right); //Recursively sorts the right half
		merge(left, right, a); //Sorts and merges the arrays into the original array
	}
	
	public static void merge(InputString[] left, InputString[] right, InputString[] a)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0; //left index
		int j = 0; //right index
		int k = 0; //a index
		
		while(i < leftSize && j < rightSize)
		{
			//checks and swaps the elements of the array depending on the number of borts for each element
			if(left[i].getBortNum() <= right[j].getBortNum())
			{
				a[k] = left[i]; 
				i++;
				k++;
			}
			
			else
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i < leftSize)
		{
			a[k] = left[i];
			i++;
			k++;
		}
		
		while(j < rightSize)
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}
}
