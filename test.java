
public class test {
	
	public static void main(String[] args) {
		
		Cylinder[] a = new Cylinder[5];
		
		for(int i = 0; i < 5; i++)
		{
			a[i] = new Cylinder(i, 10);
		}
		
		Sorter.heapSort(a);
		
		//for(int i = 0; i < 5; i++)
		//	System.out.println(a[i].getVolume());
	}

}

/*
//BubbleDown
int index = 0;
while(index * 2 + 1 < lastIndex)
{
	int bigIndex = index * 2 + 1; //assume left is large
	
	if(index * 2 + 2 < lastIndex && heap[index * 2 + 1].getVolume() > heap[index * 2 + 2].getVolume())
		bigIndex = index * 2 + 2; //right was actually larger
	
	
	if(heap[index].getVolume() > heap[bigIndex].getVolume())
	{
		//swap
		Cylinder temp = heap[index];
		heap[index] = heap[bigIndex];
		heap[bigIndex] = temp;
	}
	else
		break; //did not have to swap
	index = bigIndex;
}
a[i] = top;
}*/