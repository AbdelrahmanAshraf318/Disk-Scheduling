package Scheduling;

public class Main {

	public static void main(String[] args) {
		FCFS fcfs = new FCFS("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt");
		
		System.out.println("********************** First Come First Serve ***********************");
		fcfs.setHeadStart(53);
		fcfs.applyAlgorithm();
		
		SSTF sstf = new SSTF("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt");
		
		System.out.println("********************** Shortest Seek Time First ***********************");
		sstf.setHeadStart(53);
		sstf.applyAlgorithm();
		
		SCAN scan = new SCAN("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt" , "Left");
		
		System.out.println("********************** SCAN Algorithm ***********************");
		scan.setHeadStart(53);
		scan.applyAlgorithm();
	}

}
