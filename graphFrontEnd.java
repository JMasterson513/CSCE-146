//Joseph Masterson

public class graphFrontEnd {

	public static void main(String[] args) {
		
		linkedGraph graph = new linkedGraph(); //Creates an object of type graph
		
		//Adds the vertexes
		graph.addVertex("v1");
		graph.addVertex("v2");
		graph.addVertex("v3");
		graph.addVertex("v4");
		graph.addVertex("v5");
		graph.addVertex("v6");
		graph.addVertex("v7");
		
		//Adds the edges
		graph.addEdge("v1", "v5", 1);
		graph.addEdge("v2", "v1", 1);
		graph.addEdge("v3", "v1", 1);
		graph.addEdge("v4", "v2", 1);
		graph.addEdge("v5", "v2", 1);
		graph.addEdge("v5", "v3", 1);
		graph.addEdge("v5", "v7", 1);
		graph.addEdge("v6", "v3", 1);
		graph.addEdge("v7", "v4", 1);
		graph.addEdge("v7", "v6", 1);
		graph.findCycles(); //prints out the cycles
		
	}
	
	
}
