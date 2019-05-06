
public class TesterProc {

	public static void main(String[] args)
	{
		ProcessScheduler ps = new ProcessScheduler();
		
		Process process1 = new Process("1", 10.0);
		Process process2 = new Process("2", 11.0);
		Process process3 = new Process("3", 12.0);
		Process process4 = new Process("4", 13.0);
		Process process5 = new Process("5", 14.0);
		ps.addProcess(process1);
		ps.addProcess(process2);
		ps.addProcess(process3);
		ps.addProcess(process4);
		ps.addProcess(process5);
		System.out.println(ps.getCurrentProcess());
		System.out.println("Queque: ");
		ps.printProcessQueue();
		ps.cancelCurrentProcess();
		System.out.println("Current: " + ps.getCurrentProcess());
		System.out.println("Deleted Proc. 2");
		ps.printProcessQueue();
		
		ps.runNextProcess();
		System.out.println("\nNew Current should be 3: " + ps.getCurrentProcess());
		System.out.println("Queue: ");
		ps.printProcessQueue();
		
	}
}
