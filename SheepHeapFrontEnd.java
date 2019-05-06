//Joseph Masterson

public class SheepHeapFrontEnd {

	public static void main(String[] args) {
		
		//Initializes a heap of fifteen sheep
		MinHeap heap = new MinHeap(15);
		
		//Adds fifteen sheep to the heap
		System.out.println("Adding Sheep to the heap\n" 
				+ "Adding Sheep 1 - Joe, 100\n"
				+ "Adding Sheep 2 - Gabe, 105\n"
				+ "Adding Sheep 3 - Ravi, 97\n"
				+ "Adding Sheep 4 - Lucas, 51\n"
				+ "Adding Sheep 5 - Brendan, 341\n"
				+ "Adding Sheep 6 - Blake, 15\n"
				+ "Adding Sheep 7 - Claire, 67\n"
				+ "Adding Sheep 8 - Alex, 115\n"
				+ "Adding Sheep 9 - Adam, 134\n"
				+ "Adding Sheep 10 - Dakota, 167\n"
				+ "Adding Sheep 11 - Jacob, 1\n"
				+ "Adding Sheep 12 - Adele, 200\n"
				+ "Adding Sheep 13 - John, 2015\n"
				+ "Adding Sheep 14 - Jeremy, 101\n"
				+ "Adding Sheep 15 - DeAngelo, 198");
		
		heap.addSheep(new Sheep("Joe", 100)); //Sheep 1
		heap.addSheep(new Sheep("Gabe", 105)); //Sheep 2
		heap.addSheep(new Sheep("Ravi", 97)); //Sheep 3
		heap.addSheep(new Sheep("Lucas", 51)); //Sheep 4
		heap.addSheep(new Sheep("Brendan", 341)); //Sheep 5
		heap.addSheep(new Sheep("Blake", 15)); //Sheep 6
		heap.addSheep(new Sheep("Claire", 67)); //Sheep 7
		heap.addSheep(new Sheep("Alex", 115)); //Sheep 8
		heap.addSheep(new Sheep("Adam", 134)); //Sheep 9
		heap.addSheep(new Sheep("Dakota", 167)); //Sheep 10
		heap.addSheep(new Sheep("Jacob", 1)); //Sheep 11
		heap.addSheep(new Sheep("Adele", 200)); //Sheep 12
		heap.addSheep(new Sheep("John", 2015)); //Sheep 13
		heap.addSheep(new Sheep("Jeremy", 101)); //Sheep 14
 		heap.addSheep(new Sheep("DeAngelo", 198)); //Sheep 15
		
 		//Demonstrates the sheep roll call method
 		System.out.println("\nSheep Breadth Order");
 		heap.sheepRollCall();
 		
 		//Demonstrates the remove emthid
 		System.out.println("\nRemoving 5 Sheep from the Heap");
 		for(int i = 0; i < 5; i++)
 			System.out.println("Removing Sheep: " + i + " " + heap.removeSheep());
 		heap.sheepRollCall();
 		
 		//Demonstrates the heap sort method
 		System.out.println("\nPrinting Sheep in Order");
 		Sheep[] array = heap.sheepHeapSort();
 		for(int i = 0; i < array.length; i++)
 			System.out.println(array[i].toString());
 		
 		//Shows that the heap sort clones and thus does not remove the heap
 		System.out.println("\nIt was Succesfully Cloned");
 		heap.sheepRollCall();
 		
	}

}
