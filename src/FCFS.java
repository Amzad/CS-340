
public class FCFS extends Scheduler{

	@Override
	public void addProcessToReadyQueue(Process p) {
		readyQueue.enqueue(p);
		System.out.println("Process ID " + p.getID() + " added to queue.");
		
	}

	@Override
	public Process removeProcessFromReadyQueue() {
		readyQueue.dequeue();
		return null;
	}
	
	public boolean isEmpty() {
		boolean value = false;
		if (isReadyQueueEmpty()) {
			value = true;
		}
		return value;
	}
	
	public void print() {
		Process p = readyQueue.first();
		System.out.println("Process ID " + p.getID());
		readyQueue.enqueue(p);
		readyQueue.dequeue();
		while (p.getID() != readyQueue.first().getID()) {
			Process q = readyQueue.first();
			System.out.println("Process ID " + q.getID());
			readyQueue.enqueue(q);
			readyQueue.dequeue();	
		}
		
		
	}

}
