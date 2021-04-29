package Scheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FCFS implements Strategies{
	
	private String fileName;
	private File file;
	ArrayList<Integer> cylinderData;
	
	public FCFS() {
		this.fileName = "";
		this.file = null;
		this.cylinderData = new ArrayList<Integer>();
	}
	public FCFS(String fileName)
	{
		this.fileName = fileName;
		 try {
			this.file = new File(fileName);
			Scanner myReader = new Scanner(this.file);
			while(myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		 }catch (FileNotFoundException  e) {
			 System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	@Override
	public void applyAlgorithm() {
		// TODO Auto-generated method stub
		
	}

}
