package Scheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SSTF implements Strategies{/** Shortest Seek Time First **/

	private String fileName;
	private File file;
	private ArrayList<Integer> cylinderData;
	
	private Map<Integer , Integer> shortestSeekTime;
	
	private int headStart;
	private int totalHeadMovement;
	
	
	public SSTF() {
		this.fileName = "";
		this.file = null;
		this.cylinderData = new ArrayList<Integer>();

		this.shortestSeekTime = new HashMap<>();
		this.headStart = 0;
		this.totalHeadMovement = 0;
	}
	
	public SSTF(String fileName)
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
	
	private Map<Integer, Integer> getShortestSeekTime()
	{
		Map<Integer , Integer> seekTime = new HashMap<Integer, Integer>();
		for(int i=0 ; i<this.cylinderData.size() ; i++)
		{
			/** The variable calc to get the subtraction result of  
			 the seek time **/
			int calc = Math.abs(this.cylinderData.get(i) - this.headStart);
			
			seekTime.put(i , calc);
		}
		Map<Integer, Integer> sortedMap = seekTime.entrySet().stream()
		        .sorted(Comparator.comparingInt(e -> e.getValue()))
		        .collect(Collectors.toMap(
		                Map.Entry::getKey,
		                Map.Entry::getValue,
		                (a, b) -> { throw new AssertionError(); },
		                LinkedHashMap::new
		        ));
		return sortedMap;
	}
	
		
	@Override
	public void applyAlgorithm() {
		this.cylinderData = readFile();
			
		this.shortestSeekTime = getShortestSeekTime();
		
		System.out.print("The head sequence will be: ");
		System.out.print("<");
		System.out.print(this.headStart + " ");
		
		for (Entry<Integer, Integer> entry : this.shortestSeekTime.entrySet()) {
			System.out.print(this.cylinderData.get(entry.getKey()) + " ");
			this.totalHeadMovement = this.totalHeadMovement + 
					(Math.abs(this.headStart - this.cylinderData.get(entry.getKey())));
			this.headStart = this.cylinderData.get(entry.getKey());
		}
		
		System.out.print(">");
		System.out.println();
		System.out.println("The total movement = " + this.totalHeadMovement);
	}

}
