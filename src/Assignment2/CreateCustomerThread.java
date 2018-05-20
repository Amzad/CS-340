package Assignment2;

public class CreateCustomerThread extends Thread {
	
	public CreateCustomerThread(int numberOfTellers, int arrivalAverage, int serviceTimeAverage, int length) {
		int customerNumber = 0;
		while (length > 0) {
			try {
				sleep(new Random_Int_Mean().random_int(arrivalAverage));
				if (length > 0) {
					Thread customer = new Thread(new Customer(customerNumber, serviceTimeAverage));
					customer.start();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}

}
