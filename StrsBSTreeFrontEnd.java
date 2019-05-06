//Joseph Masterson

public class StrsBSTreeFrontEnd {

	public static void main(String[] args)
	{
		//Creates an instance of a Binary Tree of Strings
		StrBSTree tree = new StrBSTree();
		
		System.out.println("Testing the tree"
				+ "\nInserting 10 Words");
		System.out.println("Inserting buzzwigs" 
				+ "\nInserting ABBREVIATIONS"
				+ "\nInserting Cat"  
				+ "\nInserting food"
				+ "\nInserting abovementioned"
				+ "\nInserting ABSORBABILITIES"
				+ "\nInserting VOLATILITY" 
				+  "\nInserting I" 
				+ "\nInserting TWIRLIEST" 
				+ "\nInserting at");
		
		//Inserts the ten words
		tree.insert("buzzwigs");
		tree.insert("ABBREVIATIONS");
		tree.insert("Cat");
		tree.insert("food");
		tree.insert("abovementioned");
		tree.insert("ABSORBABILITIES");
		tree.insert("VOLATILITY");
		tree.insert("I");
		tree.insert("TWIRLIEST");
		tree.insert("at");
		
		//Prints out the pre-order traversal
		System.out.println("\nPrinting pre-order traversal");
		tree.printPreOrder();
		
		//Removes the word food
		System.out.println("\nRemoving the word \"food\"");
		tree.remove("food");
		tree.printPreOrder();
		
		//Gets the depth of the input word
		System.out.println("\nThe depth of TWIRLIEST is " + tree.getDepth("TWIRLIEST"));

	}
}
