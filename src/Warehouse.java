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
	
	public int getProductQuantity(int p){
		return this.products[p];
	}
	
	public int[] getProducts(){
		return this.products;
	}
}