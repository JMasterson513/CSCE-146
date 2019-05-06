
public class test {

	public static void main(String[] args)
	{
		InputString[] testA = new InputString[6];
		
		testA[0] = new InputString("Bort");
		testA[1] = new InputString("bortbortbortbort");
		testA[2] = new InputString("bortbortbort");
		testA[3] = new InputString("bortbort");
		testA[4] = new InputString("bort");
		testA[5] = new InputString("!");
		
		
		
		
		for(int i = 0; i < testA.length; i++)
		{
			testA[i].calculateBortNumRe();
			System.out.println(testA[i].getInput() + " " + testA[i].getBortNum());
		}
	}
	public static void mergeSort(InputString[] a)
	{
		int size = a.length;
		
		if(size < 2)
			return;
		
		int mid = size / 2;
		int leftSide = mid;
		int rightSide = size - mid;
		InputString[] left = new InputString[leftSide];
		InputString[] right = new InputString[rightSide];
		
		for(int i = 0; i < mid; i++)
			left[i] = a[i];
		
		for(int i = mid; i < size; i++)
			right[i - mid] = a[i];
		
		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
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
