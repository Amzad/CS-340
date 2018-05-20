package Assignment2;

public class Assignment2 {
	public static void main(String[] args) {
		args = new String[4];
		args[0] = "3";
		args[1] = "10";
		args[2] = "30";
		args[3] = "70";
		int numberOfTellers= Integer.parseInt(args[0]);
		int arrivalAverage = Integer.parseInt(args[1]);
		int serviceTimeAverage = Integer.parseInt(args[2]);
		int length = Integer.parseInt(args[3]);
		
		new Controller(numberOfTellers, arrivalAverage, serviceTimeAverage, length);
	}

}
