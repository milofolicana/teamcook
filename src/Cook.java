import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


public class Cook {

	public static void main(String[] args) throws IOException {
		
		String in = "C:\\Users\\Utente\\Desktop\\HashCode\\in.in";
		String out = "C:\\Users\\Utente\\Desktop\\HashCode\\out.txt";
		InputOutput tim;
		
		tim = new InputOutput(in,out);
		tim.start();

	}

}
