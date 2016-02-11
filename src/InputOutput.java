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
	
	private char[][] matrix;
	private char[][] matrix_bis;
	private int rows;
	private int columns;
	
	private String inputPath;
	private String outPath;
	private String first_line;
	
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
		sc.close();
		matrix= new char[rows][columns];
		matrix_bis=new char[rows][columns];
		matrix= new char[rows][columns+1];
		matrix_bis= new char[rows][columns+1];

		//start reading in the matrix
		int i=0;
		String line=reader.readLine();
		while(line!=null){
			matrix[i]=line.toCharArray();
			matrix_bis[i]=line.toCharArray();
			nicolaFunction(matrix_bis[i]);
			i++;
			line=reader.readLine();
		}
			
	}
	
	public void end() throws IOException{
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(outPath));
		for(int i=0;i<rows;i++){
			writer.write(matrix_bis[i]);
			writer.write("\n");
		}
		
	}
	
	public void miloFunction(char[] row){
		for(int i=0;i<row.length;i++){
			if(row[i]=='#')
				row[i]='1';
			else row[i]='0';
		}
	}
	
	//getter methods
	
}
