import it.polito.utility.files.CsvParser;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import it.polito.utility.files.CsvParser;

public class InputOutput {
	
	private char[][] map;
	private int rows;
	private int columns;
	
	private int n_products;
	private int[] products;
	
	private ArrayList<Warehouse> dw = new ArrayList<>();
	private int n_dw;
	
	private ArrayList<Order> orders= new ArrayList<>();
	private int n_orders;
	
	int x,y;
	
	private String inputPath;
	private String outPath;
	
	private String first_line;
	private String second_line;
	private String third_line;
	private String fourth_line;
	
	private int n_drones;
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
		
		//first line---->MAP DRONES DEADLINE MAXLOAD
		first_line=reader.readLine();
		Scanner sc= new Scanner(first_line);
		sc.useDelimiter(" ");
		rows=sc.nextInt();
		columns=sc.nextInt();
		n_drones=sc.nextInt();
		deadline=sc.nextInt();
		max_load=sc.nextInt();
		sc.close();
		
		//second_line---->P
		second_line=reader.readLine();
		sc=new Scanner(second_line);
		sc.useDelimiter(" ");
		n_products=sc.nextInt();
		products=new int[n_products];
		sc.close();
		
		//read products
		sc=new Scanner(reader.readLine());
		sc.useDelimiter(" ");
		for(int i=0;i<n_products;i++){
			products[i]=sc.nextInt();
		}
		sc.close();
		
		//thirdline--->DW
		third_line=reader.readLine();
		sc=new Scanner(third_line);
		sc.useDelimiter(" ");
		n_dw=sc.nextInt();
		sc.close();
		
		//read warehouse
		for(int i=0;i<n_dw;i++){
		sc=new Scanner(reader.readLine());
		sc.useDelimiter(" ");
		x=sc.nextInt();
		y=sc.nextInt();
		sc.close();
		dw.add(new Warehouse(x,y,reader.readLine(),n_products));
		}
		
		//4th line
		fourth_line=reader.readLine();
		sc=new Scanner(fourth_line);
		sc.useDelimiter(" ");
		n_orders=sc.nextInt();
		sc.close();
		
		//read orders
		for(int i=0;i<n_orders;i++){
			sc=new Scanner(reader.readLine());
			sc.useDelimiter(" ");
			x=sc.nextInt();
			y=sc.nextInt();
			sc.close();
	
			sc=new Scanner(reader.readLine());
			sc.useDelimiter(" ");
			int n_p = sc.nextInt();
			sc.close();
			
			reader.readLine();
			orders.add(new Order(x,y,n_p,reader.readLine()));				
		}
		
		reader.close();
		
		
	}
	
	public void end() throws IOException{
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(outPath));
		System.out.println("col= "+ this.getColumns() + " rows= " + this.getRows() + 
				" n_dw= " + this.getN_dw() +" dw= "+ this.getDw() 
				+ " n_products= " + this.getN_products() + " products= "+ this.getProducts() + 
				"n_orders= "+ this.getN_orders()+ " orders= " + this.getOrders());
	
		
	}

	//getter methods
	
	public char[][] getMap() {
		return map;
	}


	public int getDrones() {
		return drones;
	}


	public int getDeadline() {
		return deadline;
	}


	public int getMax_load() {
		return max_load;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int getN_products() {
		return n_products;
	}

	public int[] getProducts() {
		return products;
	}

	public ArrayList<Warehouse> getDw() {
		return dw;
	}

	public int getN_dw() {
		return n_dw;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public int getN_orders() {
		return n_orders;
	}

	
}
