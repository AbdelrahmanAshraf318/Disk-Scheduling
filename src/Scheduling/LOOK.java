package Scheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LOOK implements Strategies{

	private String fileName;
	private File file;
	private ArrayList<Integer> cylinderData;
	private int headStart;
	private int totalHeadMovement;
	private String moveToward;
	private ArrayList<Integer> theLeft;
	private ArrayList<Integer> theRight;

	
	public LOOK() {
		this.fileName = "";
		this.file = null;
		this.cylinderData = new ArrayList<Integer>();
		this.headStart = 0;
		this.totalHeadMovement = 0;
		this.moveToward = "";
		this.theLeft = new ArrayList<Integer>();
		this.theRight = new ArrayList<Integer>();
	}
	public LOOK(String fileName , String moveToward)
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
	
	
	private ArrayList<Integer> splitTheLeftData()
	{
		ArrayList<Integer> tempLeftData = new ArrayList<Integer>();
		for(int i=0 ; i<this.cylinderData.size() ; i++)
		{
			if(this.cylinderData.get(i) < this.headStart)
			{
				tempLeftData.add(this.cylinderData.get(i));
			}
		}
		return tempLeftData;
	}
	
	private ArrayList<Integer> splitTheRightData()
	{
		ArrayList<Integer> tempLeftData = new ArrayList<Integer>();
		for(int i=0 ; i<this.cylinderData.size() ; i++)
		{
			if(this.cylinderData.get(i) >= this.headStart)
			{
				tempLeftData.add(this.cylinderData.get(i));
			}
		}
		return tempLeftData;
	}
	
	@Override
	public void applyAlgorithm() {
		this.cylinderData = readFile();
		ArrayList<Integer> data = new ArrayList<Integer>();
		data = readFile();
		boolean pass = false;
		this.theLeft = splitTheLeftData();
		this.theRight = splitTheRightData();
		
		Collections.sort(this.theLeft , Collections.reverseOrder());
		Collections.sort(this.theRight);
		
		System.out.print("The head sequence will be: ");
		System.out.print("<");

		if(this.moveToward.equals("left") || this.moveToward.equals("Left"))
		{
			for(int i=0 ; i<this.theLeft.size() ; i++)
			{
				System.out.print(this.theLeft.get(i) + " ");
				this.totalHeadMovement += Math.abs(this.theLeft.get(i) - 
						this.headStart);
				this.headStart = this.theLeft.get(i);
			}
			for(int i=0 ; i<this.theRight.size() ; i++)
			{
				System.out.print(this.theRight.get(i) + " ");
				this.totalHeadMovement += Math.abs(this.theRight.get(i) - 
						this.headStart);
				this.headStart = this.theRight.get(i);
				
			}
		}
		else
		{
			for(int i=0 ; i<this.theRight.size() ; i++)
			{
				this.totalHeadMovement += Math.abs(this.theRight.get(i) - 
						this.headStart);
				this.headStart = this.theRight.get(i);
				System.out.print(this.theRight.get(i) + " ");
			}
			for(int i=0 ; i<this.theLeft.size() ; i++)
			{
				System.out.print(this.theLeft.get(i) + " ");
				this.totalHeadMovement += Math.abs(this.theLeft.get(i) - 
						this.headStart);
				this.headStart = this.theLeft.get(i);
			}
		}
		
		System.out.print(">");
		System.out.println();
		System.out.println("The total movement = " + this.totalHeadMovement);
		
	}

}
