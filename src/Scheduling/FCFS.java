package Scheduling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

public class FCFS implements Strategies{/** First Come First Serve **/
	
	private String fileName;
	private File file;
	private ArrayList<Integer> cylinderData;
	private int headStart;
	private int totalHeadMovement;
	
	public FCFS() {
		this.fileName = "";
		this.file = null;
		this.cylinderData = new ArrayList<Integer>();
		this.headStart = 0;
		this.totalHeadMovement = 0;
	}
	public FCFS(String fileName)
	{
		this.fileName = fileName;
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
	
	@Override
	public void applyAlgorithm() {
		readFile();
		this.cylinderData = readFile();
		System.out.print("The head sequence will be: ");
		System.out.print("<");
		System.out.print(this.headStart + " ");
		for(int i=0 ; i<this.cylinderData.size() ; i++)
		{
			System.out.print(this.cylinderData.get(i) + " ");
			this.totalHeadMovement = this.totalHeadMovement + 
					(Math.abs(this.headStart - this.cylinderData.get(i)));
			this.headStart = this.cylinderData.get(i);
		}
		System.out.print(">");
		System.out.println();
		System.out.println("The total movement = " + this.totalHeadMovement);
	}

}
