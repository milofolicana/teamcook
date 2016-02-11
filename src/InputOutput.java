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
	
	private int[][] dw_map;
	private int[][] o_map;
	
	private int rows;
	private int columns;
	
	private int n_products;
	private int[] products;
	
	private ArrayList<Warehouse> dw = new ArrayList<>();
	private int n_dw;
	
	private ArrayList<Order> orders= new ArrayList<>();
	private int n_orders;
	
	private ArrayList<Drone> drones = new ArrayList<>();
	private int n_drones;
	
	
	int x,y;
	
	private String inputPath;
	private String outPath;
	
	private String first_line;
	private String second_line;
	private String third_line;
	private String fourth_line;
	
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
		dw_map=new int[rows][columns];
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
		dw_map[x][y]=i;
		sc.close();
		dw.add(new Warehouse(x,y,reader.readLine(),n_products));
		}
		
		//4th line
		fourth_line=reader.readLine();
		sc=new Scanner(fourth_line);
		sc.useDelimiter(" ");
		n_orders=sc.nextInt();
		o_map=new int[rows][columns];
		sc.close();
		
		//read orders
		for(int i=0;i<n_orders;i++){
			sc=new Scanner(reader.readLine());
			sc.useDelimiter(" ");
			x=sc.nextInt();
			y=sc.nextInt();
			sc.close();
			o_map[x][y]=i;
	
			sc=new Scanner(reader.readLine());
			sc.useDelimiter(" ");
			int Li = sc.nextInt();
			sc.close();
			
			orders.add(new Order(x,y,Li,n_products,reader.readLine()));				
		}
		
		//initializeDrones
		for(int i=0; i<n_drones; i++){
			drones.add(new Drone(i, max_load, n_products, dw.get(0).getX(), dw.get(0).getY()));
		}
		
		reader.close();
		
		
	}
	
	public void initializeDistances(){
		
		for(int i=0;i<n_dw;i++){
			for(int j=0;j<n_orders;j++)
			dw.get(i).setDistance_orders(this.distWareOrd(i, j), j);
		}
		
		for(int i=0;i<n_dw;i++){
			for(int j=0;j<n_dw;j++){
			dw.get(i).setDistance_warehouse(this.distWareWare(i, j), j);
			orders.get(j).setDistance_warehouse(this.distWareWare(i, j), i);
			}
		}
		
		for(int i=0;i<n_orders;i++){
			for(int j=0;j<n_orders;j++)
			orders.get(i).setDistance_orders(this.distOrdOrd(i, j), j);
		}
		
	}
	
	public void sortOrder(){
		
		
		
	}
	
	public int satisfy(int o, int d){
		int count=0;
		Warehouse ware = dw.get(d);
		Order od=orders.get(o);
		for(int i=0;i<od.getProducts().length;i++){
			int p=od.getProductQuantity(i);
			int prod=od.getProducts()[i];
			if(ware.getProductQuantity(prod)>=p)
				count+=1;
		else count+=(p-ware.getProductQuantity(prod))/p;
		}
		return count/od.getProducts().length;
	}
	
	public void end() throws IOException{
	
		
	}
	
	//distances
	
	public int dist(int x1, int y1, int x2, int y2) {
        return (int) Math.ceil(Math.sqrt((x2-x1)*(x2-x1)-(y2-y1)*(y2-y1)));
    }
    
    public int distOrdOrd(int id1, int id2) {
        int x1 = orders.get(id1).getX();
        int x2 = orders.get(id2).getX();
        int y1 = orders.get(id1).getY();
        int y2 = orders.get(id2).getY();
        return dist(x1,x2,y1,y2);
    }
    
    public int distWareWare(int id1, int id2) {
        int x1 = dw.get(id1).getX();
        int x2 = dw.get(id2).getX();
        int y1 = dw.get(id1).getY();
        int y2 = dw.get(id2).getY();
        return dist(x1,x2,y1,y2);
    }
    
    public int distWareOrd(int id1, int id2) {
        int x1 = dw.get(id1).getX();
        int x2 = orders.get(id2).getX();
        int y1 = dw.get(id1).getY();
        int y2 = orders.get(id2).getY();
        return dist(x1,x2,y1,y2);
    }
	
	//getter methods
	
	public int[][] getDw_Map() {
		return dw_map;
	}


	public int[][] getO_map() {
		return o_map;
	}

	public ArrayList<Drone> getDrones() {
		return drones;
	}

	public int getN_Drones() {
		return n_drones;
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
