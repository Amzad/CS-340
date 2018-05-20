package Assignment2;

public class Customer implements Runnable {
	int customerNumber;
	int customerCount = 0;
	int arrivalTime = 0;
	int waitingTIme = 0;
	int currentTime = 0;
	int serviceTimeAverage = 0;
	
	
	public Customer() {
		
	}

	public Customer(int customerNumber, int serviceTimeAverage, int currentTime) {
		this.customerCount = customerNumber;
		this.currentTime = currentTime;
		this.serviceTimeAverage = serviceTimeAverage;
	}

	@Override
	public void run() {
		
			try {
				//inLine();
				Controller.sem.acquire();
				startedBeingServed();
				leavingTheBank();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				Controller.sem.release();
			}
			
		
		
	}
	
	public void startedBeingServed() {
		System.out.println("At time " + currentTime + " " + customerNumber + " starts being served.");
		sleep(serviceTimeAverage);
		currentTime = currentTime + serviceTimeAverage;
	}
	
	public void leavingTheBank() {
		System.out.println("At time " + currentTime + " " + customerNumber + " leaves the bank.");
	}
	
	public void sleep(int serviceTimeAverage) {
		new Random_Int_Mean().random_int(serviceTimeAverage);
	}
	
	public void inLine() {
		System.out.println("At time " + currentTime + " " + customerNumber + " arrives in line.");
	}

}
