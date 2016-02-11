

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

	public static void main(String[] args) throws IOException {
		
		
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(chooser.getParent());
		
		String in = chooser.getSelectedFile().getAbsolutePath();
		String out = chooser.getSelectedFile().getParent()+"\\out.txt";
		InputOutput tim;
		
		tim = new InputOutput(in,out);
		tim.start();
		tim.end();

	}

}
