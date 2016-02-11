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

public class Warehouse {
	
	private int x;
	private int y;
	private int[] products;
    private int P;
    private int items;
	private String input;
	
	private int[] distance_orders;
	private int[] distance_warehouse;
	
	public Warehouse(int x, int y, String input, int P){
		this.x = x;
        this.y = y;
		this.input = input;
        this.P = P;
        
        products = new int[P];
        
        Scanner sc= new Scanner(input);
        sc.useDelimiter(" ");
        for(int i=0; i<P; i++){
            items=sc.nextInt();
            products[i]=items;
        }
        sc.close();
	}
	
	
	
	public int[] getDistance_orders() {
		return distance_orders;
	}



	public void setDistance_orders(int distance, int order) {
		this.distance_orders[order]=distance;
	}



	public int[] getDistance_warehouse() {
		return distance_warehouse;
	}



	public void setDistance_warehouse(int distance, int dw) {
		this.distance_warehouse[dw]=distance;
	}



	public int getProductQuantity(int p){
		return this.products[p];
	}
	
	public boolean hasProduct(int p){
		return this.products[p]!=0;
	}
	
	public int[] getProducts(){
		return this.products;
	}



	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}
	
	
}