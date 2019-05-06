//Joseph Masterson

public class ShapeFrontEnd {

	//Name of the shaoe file
	public static final String FILE_NAME = "shapeFile.txt";
	public static void main(String[] args) {
		
		System.out.println("Welcome to the shape tree tester!\n"
				+ "Reading from File\n");
		ShapeManager tree = new ShapeManager(FILE_NAME); //initializes a shape manager, puts in the file name
		
		//Prints the pre-order traversal of the tree
		System.out.println("\nPrinting Pre-Order");
		tree.printPreOrder();
		
		//Prints the in-order traversal of the tree
		System.out.println("\nPrinting In-Order");
		tree.printInOrder();
		
		//Prints the post-order traversal of the tree
		System.out.println("\nPrinting Post-Order");
		tree.printPostOrder();
		
		//Finds the maximum area in the tree
		System.out.println("\nThe Max Area is: " + tree.findMaxArea());
		
		//Deletes a rectangle of area 20 and then prints the tree in-order
		System.out.println("\nDeleting Rectangle Side 1: 2.0 Side 2: 7.0 Area: 14.0");
		tree.deleteItem(new Shape(20));
		System.out.println("Printing In-Order");
		tree.printInOrder();
		
		//Deletes all shapes with areas greater than 30 and then prints in order
		System.out.println("\nDeleting Values Larger than 30");
		tree.deleteGreaterThan(30);
		System.out.println("Printing In-Order");
		tree.printInOrder();
	}
}
