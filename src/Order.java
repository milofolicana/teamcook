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
}