import it.polito.utility.files.CsvParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Scanner;

import it.polito.utility.files.CsvParser;

public class InputOutput {
	
	private char[][] map;
	private int rows;
	private int columns;
	
	private int n_products;
	private int[] products;
	private String inputPath;
	private String outPath;
	
	private String first_line;
	private String second_line;
	
	private int drones;
	private int deadline;
	private int max_load;
	
	//strutture richieste per salvare il file di input
	
	public InputOutput(String in, String out){
		inputPath = in;
		outPath = out;
	}
	
	public void start() throws IOException{
		//open the file
		BufferedReader reader = new BufferedReader(new FileReader(inputPath));
		
		//open first line and "allocate" the matrix
		first_line=reader.readLine();
		Scanner sc= new Scanner(first_line);
		sc.useDelimiter(" ");
		rows=sc.nextInt();
		columns=sc.nextInt();
		drones=sc.nextInt();
		deadline=sc.nextInt();
		max_load=sc.nextInt();
		sc.close();
		
		//open second_line
		
		second_line=reader.readLine();
		sc=new Scanner(second_line);
		n_products=sc.nextInt();
		products=new int[n_products];
			
	}
	
	public void end() throws IOException{
		
		
	}

	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

	public int getDrones() {
		return drones;
	}

	public void setDrones(int drones) {
		this.drones = drones;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public int getMax_load() {
		return max_load;
	}

	public void setMax_load(int max_load) {
		this.max_load = max_load;
	}
	
	
	//getter methods
	
	
}
