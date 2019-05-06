//Joseph Masterson

public class wordFinderFrontEnd {

	public static void main(String[] args) {
		
		//Creates a graph of type graph
		graph graph = new graph();
		
		//Adds elements to the graph
		graph.addVert('R');
		graph.addVert('A');
		graph.addVert('H');
		graph.addVert('J');
		graph.addVert('M');
		graph.addVert('Y');
		graph.addVert('U');
		graph.addVert('W');
		graph.addVert('W');
		graph.addVert('K');
		graph.addVert('R');
		graph.addVert('X');
		graph.addVert('N');
		graph.addVert('F');
		graph.addVert('M');
		graph.addVert('Q');
		graph.addVert('G');
		graph.addVert('E');
		graph.addVert('E');
		graph.addVert('B');
		graph.addVert('E');
		graph.addVert('O');
		graph.addVert('A');
		graph.addVert('P');
		graph.addVert('E');
		graph.print();
		System.out.println();
		graph.findWords();
		
		
		
	

		
		
	}

}
