//Joseph Masterson
import java.util.LinkedList;

public class adjMatrix {
	
	public static final int DEF_SIZE = 10;
	private double[][] adjMatrix;
	
	public adjMatrix()
	{
		init(DEF_SIZE);
	}
	
	public adjMatrix(int size)
	{
		init(size);
	}
	
	private void init(int size)
	{
		if(size <= 0)
			return;
		adjMatrix = new double[size][size];
	}
	
	public void addEdge(int toVert, int fromVert, double weight)
	{
		if(!isValid(toVert) || !isValid(fromVert))
			return;
		adjMatrix[toVert][fromVert] = weight;
	}
	
	private boolean isValid(int i)
	{
		return i >= 0 && i < adjMatrix.length;
	}
	
	private LinkedList<Integer> markedList = new LinkedList<Integer>();
	private String cycle;
	private int vertex;
	
	public void findCycles()
	{
		markedList.clear();
		
		for(int i = 1; i <= adjMatrix.length; i++)
		{
			markedList.clear();
			cycle = "";
			vertex = 1;
			findCycle(1);
			System.out.println();
		}
	}
	
	private void findCycle(int index)
	{
		if(index == vertex && markedList.contains(index))
		{
			System.out.println(cycle + vertex);
			cycle = cycle.substring(0, cycle.length() - 3);
			markedList.removeLast();
		}
		else if(markedList.contains(index))
		{
			cycle = cycle.substring(0, cycle.length() - 3);
			markedList.removeLast();
			return;
		}
		
		cycle = cycle + " " + Integer.toString(index) + " ";
		markedList.add(index);
		for(int i = 1; i <= adjMatrix.length; i++)
			findCycle(i);
	}

}
