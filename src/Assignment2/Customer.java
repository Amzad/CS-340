package Assignment2;

public class Customer implements Runnable {
	int customerNumber;
	int customerCount = 0;
	int arrivalTime = 0;
	int waitingTIme = 0;
	
	
	public Customer() {
		
	}

	public Customer(int customerNumber, int serviceTimeAverage) {
		this.customerCount = customerNumber;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void sleep(int serviceTimeAverage) {
		new Random_Int_Mean().random_int(serviceTimeAverage);
	}
	
	public void inLine() {
		
	}

}
