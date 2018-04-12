
public class Process {
	int ID, arrivalTime, burstLength;
	int waitTime, responseTime, TurnaroundTime;
	
	public Process(int ID, int arrivalTime, int burstLength) {
		setID(ID);
		setArrivalTime(arrivalTime);
		setBurstLength(burstLength);
		
	}
	
	public int getID() {
		return ID;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getBurstLength() {
		return burstLength;
	}
	
	public void setID(int newID) {
		ID = newID;
	}

	public void setArrivalTime(int newTime) {
		arrivalTime = newTime;
	}
	
	public void setBurstLength(int newLength) {
		burstLength = newLength;
	}
}
