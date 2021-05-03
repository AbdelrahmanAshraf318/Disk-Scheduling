package Scheduling;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int headStart = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the initial head start cylinder: ");
		headStart = input.nextInt();
		System.out.println();
		
		
		FCFS fcfs = new FCFS("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt");
		
		System.out.println("********************** First Come First Serve ***********************");
		fcfs.setHeadStart(headStart);
		fcfs.applyAlgorithm();
		
		SSTF sstf = new SSTF("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt");
		
		System.out.println("********************** Shortest Seek Time First ***********************");
		sstf.setHeadStart(headStart);
		sstf.applyAlgorithm();
		
		SCAN scan = new SCAN("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt" , "left" , 199);
		
		System.out.println("********************** SCAN Algorithm ***********************");
		scan.setHeadStart(headStart);
		scan.applyAlgorithm();
		
		C_SCAN cscan = new C_SCAN("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt" , "right" , 199);
		
		System.out.println("********************** C-SCAN Algorithm ***********************");
		cscan.setHeadStart(headStart);
		cscan.applyAlgorithm();
		
		LOOK look = new LOOK("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt" , "right");
		
		System.out.println("********************** LOOK Algorithm ***********************");
		look.setHeadStart(headStart);
		look.applyAlgorithm();
		
		C_LOOK clook = new C_LOOK("H:/Computer Science Department/Level 3_Second Semester/Advanced Operating System/Assignments/Assignment 2/Disk Scheduling/src/Scheduling/data.txt" , "right");
		
		System.out.println("********************** C-LOOK Algorithm ***********************");
		clook.setHeadStart(headStart);
		clook.applyAlgorithm();
		
	}

}
