//Joseph Masterson

import java.io.File;
import java.util.Scanner;

public class ShapeManager {

	//Instance variable
	private BSTree<Shape> shapeTree;
	public static final String DELIM = "\t"; //delimiter for the file
	
	//Parameterized Constructor creates a tree by reading in a file
	public ShapeManager(String fileName)
	{
		shapeTree = readShapeFile(fileName);
	}
	
	//Adds a shape to the tree
	public void addItem(Shape aShape)
	{
		shapeTree.insert(aShape);
	}
	
	//removes a shape from the tree
	public void deleteItem(Shape aShape)
	{
		shapeTree.delete(aShape);
	}
	
	//Prints the pre-order traversal of the tree
	public void printPreOrder()
	{
		shapeTree.printPreOrder();
	}
	
	//Prints the in-order traversal of the tree
	public void printInOrder()
	{
		shapeTree.printInOrder();
	}
	
	//Prints the post-order traversal of the tree
	public void printPostOrder()
	{
		shapeTree.printPostOrder();
	}
	
	//Finds the maximum area of the tree
	public double findMaxArea()
	{
		//The method returns a shape, so this just returns the area of the shape
		Shape s = shapeTree.findMaxInTree();
		return s.getArea();
	}
		
	//Deletes all shapes with a greater area than the input value 
	public void deleteGreaterThan(double area)
	{
		//Creates an object shape with the input area since the method takes in a shape not a double
		Shape aShape = new Shape(area);
		shapeTree.deleteGreaterThan(aShape);
	}
	
	//Reads in a file and initializes a Binary Search Tree
	public BSTree<Shape> readShapeFile(String aFileName)
	{
		try
		{
			//Initializes a scanner
			Scanner fileScanner = new Scanner(new File(aFileName));
			BSTree<Shape> tree = new BSTree<Shape>(); //initializes a binary search tree of type shape
			
			//Continues while there are still lines in the file
			while(fileScanner.hasNextLine())
			{
				String input = fileScanner.nextLine(); //Read the line
				String[] splitLine = input.split(DELIM); //splits the line

				//Switch based on the type
				switch(splitLine[0])
				{
				//If the line is for a rectangle
				case "Rectangle":
					System.out.println(input); //print the line
					double sideOne = Double.parseDouble(splitLine[1]); //get side one
					double sideTwo = Double.parseDouble(splitLine[2]); //get side two
					tree.insert(new Rectangle(sideOne, sideTwo)); //insert a new rectangle into the tree
					break;
				//If the lines is for a circle
				case "Circle":
					System.out.println(input); //Prints the line
					double radius = Double.parseDouble(splitLine[1]); //gets the radius
					tree.insert(new Circle(radius)); //inserts a new circle into the tree
					break;
				//If the lines is for a Right Triangle
				case "Right Triangle":
					System.out.println(input); //Prints the line
					double tSideOne = Double.parseDouble(splitLine[1]); //gets side one
					double tSideTwo = Double.parseDouble(splitLine[2]); //gets side two
					tree.insert(new RightTriangle(tSideOne, tSideTwo)); //inserts a new right triangle into the tree
					break;
				//if the lines is for a shape which is not a rectangle, circle, or right triangle
				default:
					System.out.println("Not properly formatted line"); //prints a message
					break;
				}
			}
			fileScanner.close(); //closes the scanner
			return tree; //returns the tree
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
