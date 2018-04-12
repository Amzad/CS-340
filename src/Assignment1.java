import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment1 {

	static FCFS fcfs;
	static RoundRobin rr4;
	static RoundRobin rr8;
	static int SystemTime;

	public static void main(String[] args) {
		SystemTime = 0;
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

				Process p = new Process(Integer.parseInt(processArray[0]), Integer.parseInt(processArray[1]),
						Integer.parseInt(processArray[2]));
				rr4.addProcessToReadyQueue(p);
			}

			System.out.println("Multilevel Feedback Queue Scheduling Algorithm");

			// First Instance of Round Robin with a quantom of 4.
			Process p = rr4.readyQueue.first();
			int quantom = 4;

			// Iterate through each process
			for (int i = 0; i < p.getID(); i++) {

				// Runs the current Process
				// If the burstlength is greater than the quantom, run up to quantom and pass to next algorithm.
				int length = 0;
				if (p.getBurstLength() > quantom) {
					for (int j = (p.getBurstLength() -quantom);j < p.getBurstLength(); j++) {
						System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is running");
						length++;
						SystemTime++;
					}
					p.setBurstLength(p.getBurstLength()-quantom);
					rr8.addProcessToReadyQueue(p);
					//rr4.removeProcessFromReadyQueue();
				}
				else if (p.getBurstLength() <= quantom) {
					while (length < p.getBurstLength()) {
						System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is running");
						length++;
						SystemTime++;	
					}
					p.setBurstLength(p.getBurstLength()-quantom);
					System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is finished");
					SystemTime++;
				}

				
				rr4.removeProcessFromReadyQueue();
				if (rr4.isEmpty()) {
					break;
				}
				else {
					p = rr4.readyQueue.first();
				}
				
			}
			
			// First Instance of Round Robin with a quantom of 4.
			p = rr8.readyQueue.first();
			quantom = 8;

			// Iterate through each process
			for (int i = 0; i < p.getID(); i++) {

				// Runs the current Process
				// If the burstlength is greater than the quantom, run up to quantom and pass to next algorithm.
				int length = 0;
				if (p.getBurstLength() > quantom) {
					for (int j = (p.getBurstLength() -quantom);j < p.getBurstLength(); j++) {
						System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is running");
						length++;
						SystemTime++;
					}
					p.setBurstLength(p.getBurstLength()-quantom);
					fcfs.addProcessToReadyQueue(p);
					//rr4.removeProcessFromReadyQueue();
				}
				else if (p.getBurstLength() <= quantom) {
					while (length < p.getBurstLength()) {
						System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is running");
						length++;
						SystemTime++;	
					}
					p.setBurstLength(p.getBurstLength()-quantom);
					System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is finished");
					SystemTime++;
				}

				
				rr8.removeProcessFromReadyQueue();
				if (rr8.isEmpty()) {
					break;
				}
				else {
					p = rr8.readyQueue.first();
				}
				
			}
			
			p = fcfs.readyQueue.first();
			for (int i = 0; i < p.getID(); i++) {
				// System.out.println("<System Time " + SystemTime + ">" + "Process " +
				// p.getID() + " is running");

				// Runs the current Process
				int length = 0;
				while (length < p.getBurstLength()) {
					System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is running");
					length++;
					SystemTime++;
				}
				System.out.println("<System Time " + SystemTime + ">     " + "Process " + p.getID() + " is finished");
				SystemTime++;
				fcfs.removeProcessFromReadyQueue();
				if (fcfs.isEmpty()) {
					System.out.println("All processes are finished.");
					break;
				}
				else {
					p = fcfs.readyQueue.first();
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid file. Format doesn't match what's specified in the project.");
		}

	}


}
