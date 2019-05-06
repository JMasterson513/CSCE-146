//Joseph Masterson

import java.util.LinkedList;

public class linkedGraph {
	
	//Private class for the vertex
	private class Vertex
	{
		String name; //must be unique
		LinkedList<Edge> neig; //all the edges going from the vertex
		
		//Parameterized Constructor
		public Vertex(String aName)
		{
			name = aName;
			neig = new LinkedList<Edge>();
		}
	}
	
	//Private class for the edge
	private class Edge
	{
		Vertex toVert; //a vertex
		double weight; //the weight of the edge
		
		//Parameterized Constructor
		public Edge(Vertex aV, double aW)
		{
			toVert = aV; 
			weight = aW;
		}
	}
	
	private Vertex origin; //this is where we start from and arbitrary
	private LinkedList<Vertex> vertices; //this is linkedGraph
	
	//Default constructor
	public linkedGraph()
	{
		origin = null;
		vertices = new LinkedList<Vertex>();
	}
	
	//Method to add vertices to the graph
	public void addVertex(String aName)
	{
		//Found a duplicate
		if(isVertContained(aName))
			return;
		Vertex v = new Vertex(aName); //new vertex
		vertices.add(v); //adds it 
		if(origin == null) //sets the origin
			origin = v;
	}
	
	//Checks to see if this vertex already exists
	private boolean isVertContained(String aName)
	{
		return getVert(aName) != null;
	}
	
	//Adds edges to the graph
	public void addEdge(String fromVert, String toVert, double weight)
	{
		Vertex v1 = getVert(fromVert);
		Vertex v2 = getVert(toVert);
		if(v1 == null || v2 == null)
			return; //one or both vertices was not found
		v1.neig.add(new Edge(v2, weight)); //adds an edge
	}
	
	//Gets the vertex for a certain name
	private Vertex getVert(String aName)
	{
		for(Vertex v : vertices)
			if(v.name.equals(aName))
				return v;
		return null;
	}

	private LinkedList<Vertex> markedVerts = new LinkedList<Vertex>(); //vertices we pass
	
	//Print depth first method
	public void printDFS()
	{
		markedVerts.clear(); //clears the marked vertices
		printDFS(origin); //starts printDFS from the origin
	}
	
	//Recursive private method from printDFS starts at a vertex
	private void printDFS(Vertex v)
	{
		//Cannot travel to a marked vertex
		if(markedVerts.contains(v))
			return;
		System.out.println(v.name); //prints the name
		markedVerts.add(v); //adds it to the list
		for(Edge e : v.neig) //fonds the next vertex
			printDFS(e.toVert);
	}
	
	private String cycle = ""; //String of the vertices we append to
	
	//Method to find all the cycles
	public void findCycles()
	{
		markedVerts.clear(); 
		for(Vertex v : vertices) //starts it from each of the vertices
		{
			markedVerts.clear(); //clears the list of all the vertices we have encountered
			findCycle(v); //calls the findCycle method 
		}
	}
	
	//Recursive findCycle method
	public void findCycle(Vertex v)
	{
		if(markedVerts.contains(v)) //if we have been here
		{
			if(cycle.substring(0, 2).equals(v.name)) //if it is the starting vertex
			{
				//Just converts them all to just number
				String temp = v.name.replace("v", " ");
				System.out.println(cycle.replace("v", " ") + temp);
			}
			return; //return if not the starting vertex
		}
		markedVerts.add(v); //adds the vertex to the list
		cycle = cycle + v.name; //lengthens the cycle string
		for(Edge e : v.neig)
			findCycle(e.toVert); //finds the next vertex
		cycle = cycle.substring(0, cycle.length() - 2); //cuts the substring
		markedVerts.remove(v); //removes the vertex
	}	
			
}