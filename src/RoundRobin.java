
public class RoundRobin extends Scheduler {

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

}
