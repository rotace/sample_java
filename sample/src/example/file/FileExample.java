package example.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class FileExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = new File("test.txt");
		try {
			FileReader filereader = new FileReader(file);
			List list = new ArrayList();
			System.out.print("test");
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
