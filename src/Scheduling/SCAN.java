package Scheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SCAN implements Strategies{

	private String fileName;
	private File file;
	private ArrayList<Integer> cylinderData;
	private int headStart;
	private int totalHeadMovement;
	private String moveToward;
	private ArrayList<Integer> theLeft;
	private ArrayList<Integer> theRight;
	
	public SCAN() {
		this.fileName = "";
		this.file = null;
		this.cylinderData = new ArrayList<Integer>();
		this.headStart = 0;
		this.totalHeadMovement = 0;
		this.moveToward = "";
		this.theLeft = new ArrayList<Integer>();
		this.theRight = new ArrayList<Integer>(); 
	}
	public SCAN(String fileName , String moveToward)
	{
		this.fileName = fileName;
		this.moveToward = moveToward;
	}
	
	 
	
	public int getHeadStart() {
		return headStart;
	}
	public void setHeadStart(int headStart) {
		this.headStart = headStart;
	}
	
	private ArrayList<Integer> readFile()
	{
		this.file = new File(this.fileName);
		
		try {
			Scanner scan = new Scanner(this.file);
			int i = 0; 
			ArrayList<Integer> tall = new ArrayList<Integer>();
			while(scan.hasNextInt()) {
				tall.add(scan.nextInt());
			}
			return tall;
		} catch (FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
			return null;
		}

	}
	
	private void splitTheCylinderArray()
	{
		
	}
	
	@Override
	public void applyAlgorithm() {
		this.cylinderData = readFile();
		ArrayList<Integer> data = new ArrayList<Integer>();
		data = readFile();
		boolean pass = false;
		/*Collections.sort(data , Collections.reverseOrder());
		Collections.sort(this.cylinderData , Collections.reverseOrder());*/
		
		System.out.print("The head sequence will be: ");
		System.out.print("<");
		System.out.print(this.headStart + " ");
		
		
		
		System.out.print(">");
		System.out.println();
		System.out.println("The total movement = " + this.totalHeadMovement);

		}

}
