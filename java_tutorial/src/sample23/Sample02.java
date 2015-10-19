package sample23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample02 {
	
	
	public void exec() throws IOException{
		BufferedReader in = new BufferedReader(
							new InputStreamReader(System.in));
		System.out.print("Input name:");
		String name;
		try {
			name = in.readLine();
			System.out.println("hello, "+name);
		} catch (IOException e) {
			System.err.println("in.readLine()でIOExceptionが発生");
		}
		in.close();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sample02 app = new Sample02();
		
		try {
			app.exec();
		} catch (IOException e) {
			System.err.println("in.close()でIOExceptionが発生");
		}

	}

}
