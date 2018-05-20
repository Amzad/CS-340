package Assignment2;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
	static int numberOfTellers;
	static Semaphore sem;
	
	
	public Controller(int numberOfTellers, int arrivalAverage, int serviceTimeAverage, int length) {
		//System.out.print(sem.availablePermits());
		sem = new Semaphore(numberOfTellers);
		int customerNumber = 0;
		while (length > 0) {
			try {
				sleep(new Random_Int_Mean().random_int(arrivalAverage));
				if (length > 0) {
					Thread customer = new Thread(new Customer(customerNumber, serviceTimeAverage, length));
					customer.start();
					customerNumber++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}

}
