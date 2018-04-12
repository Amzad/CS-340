import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment1 {
	
	static FCFS fcfs;
	static RoundRobin rr4;
	static RoundRobin rr8;
	
	public static void main(String[] args) {
		try {
			// Read File
			FileInputStream fstream = new FileInputStream("assignment1.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
			
			// Create Queues
			fcfs = new FCFS();
		    rr4 = new RoundRobin();
		    rr8 = new RoundRobin();
			
			while (reader.ready()) {
				String currentProcess = reader.readLine();
				String processArray[] = currentProcess.split(" ");

				Process p = new Process(Integer.parseInt(processArray[0]),Integer.parseInt(processArray[1]),Integer.parseInt(processArray[2]));
				rr4.addProcessToReadyQueue(p);
			}
		
			//fcfs.print();
			startSchedulerRR();
			
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid file. Format doesn't match what's specified in the project.");
		}
		
		
		
		
	}
	
	public static void startScheduler() {
		int SystemTime = 0;
		System.out.println("Multilevel Feedback Queue Scheduling Algorithm");
		Process p = fcfs.readyQueue.first();
		for (int i = 0; i < p.getID(); i++) {
			//System.out.println("<System Time " + SystemTime + ">" + "Process " + p.getID() + " is running");
			
			// Runs the current Process
			int length = 0;
			while (length < p.getBurstLength()) {
				System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is running");
				length++;
				SystemTime++;
			}
			System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is finished");
			SystemTime++;
			fcfs.readyQueue.dequeue();
			if (fcfs.isEmpty()) {
				break;
			}
			p = fcfs.readyQueue.first();
		}
		
	}
	
	public static void startSchedulerRR() {
		int SystemTime = 0;
		System.out.println("Multilevel Feedback Queue Scheduling Algorithm");
		
		// First Instance of Round Robin with a quantom of 4.
		Process p = rr4.readyQueue.first();
		int quantom = 4;
		
		// Iterate through each process
		for (int i = 0; i < p.getID(); i++) {
			
			// Runs the current Process
			int length = 0;
			if (p.getBurstLength() > 3) {
				while (length < p.getBurstLength()) {
				System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is running");
				length++;
				SystemTime++;
				}
			}
            if ( true) {
				
			
			}
			else {
				rr8.addProcessToReadyQueue(p);
				rr4.removeProcessFromReadyQueue();
			}
			
			
			
			System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is finished");
			SystemTime++;
			fcfs.readyQueue.dequeue();
			if (fcfs.isEmpty()) {
				break;
			}
			p = fcfs.readyQueue.first();
		}
		
	}
	
}
