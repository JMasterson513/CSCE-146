//Joseph Masterson

public class ProcessScheduler {
	
	//Instance variables
	private LinkedListQueue<Process> processes = new LinkedListQueue<Process>();
	private Process currentProcess;
	
	//Returns the current process
	public Process getCurrentProcess()
	{
		if(currentProcess == null)
			return null;
		return currentProcess;
	}

	//sets the current process if it is null or adds the process to the queue
	public void addProcess(Process aProcess)
	{
		if(currentProcess == null)
		{
			currentProcess = aProcess;
			return;
		}
		
		else
			processes.enqueue(aProcess);
	}
	
	//Sets the current process as the next process in the queue
	public void runNextProcess()
	{
		currentProcess = processes.dequeue(); 
	}
	
	//Cancels the current process and sets the next process as the currents
	public void cancelCurrentProcess()
	{
		currentProcess = null; //cancels the current process by making it null
		currentProcess = processes.dequeue(); //dequeues and then sets the current as the value
	}

	//prints the queue - uses the method from LinkedListQueue
	public void printProcessQueue() 
	{
		processes.print();
	}
	
}
