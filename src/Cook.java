import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Cook extends JFrame {
	static JFrame frame;
	
	public static void main(String[] args) throws IOException {
		
		//1
		
		frame = new JFrame();
		JFileChooser chooser = new JFileChooser();
		
		int returnVal = chooser.showOpenDialog(frame);
		
		String in = chooser.getSelectedFile().getAbsolutePath();
		String out = chooser.getSelectedFile().getParent()+File.separator+"out1.txt";
			
		InputOutput tim = new InputOutput(in,out);
		tim.start();
		tim.initializeDistances();
		tim.end();
		
		//2
		for (int i = 0; i < tim.getN_orders(); i++) {
			
		}
		
		frame = new JFrame();
		chooser = new JFileChooser();
		
		returnVal = chooser.showOpenDialog(frame);
		
		in = chooser.getSelectedFile().getAbsolutePath();
		out = chooser.getSelectedFile().getParent()+File.separator+"out2.txt";
			
		tim = new InputOutput(in,out);
		tim.start();
		tim.initializeDistances();
		tim.end();
		
		//3
		
		frame = new JFrame();
		chooser = new JFileChooser();
		
		returnVal = chooser.showOpenDialog(frame);
		
		in = chooser.getSelectedFile().getAbsolutePath();
		out = chooser.getSelectedFile().getParent()+File.separator+"out3.txt";
			
		tim = new InputOutput(in,out);
		tim.start();
		tim.initializeDistances();
		tim.end();
		
		
	}

}
