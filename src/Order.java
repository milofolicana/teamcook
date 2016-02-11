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

public class Order {
	
	private int x;
	private int y;
    private int Li;
    private int item;
    private int[] products;
	
    private int[] distance_orders;
	private int[] distance_warehouse;
    
	public Order(int x, int y, int Li, int p, String types){
		this.x = x;
        this.y = y;
		this.Li = Li;
        
        products = new int[p];
        
        Scanner sc= new Scanner(types);
        sc.useDelimiter(" ");
        for(int i=0; i<Li; i++){
            item=sc.nextInt();
            products[item]++;
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
	
	public void updateProduct(int p, int quantity){
		this.products[p]=this.products[p]-quantity;
	}
	
}