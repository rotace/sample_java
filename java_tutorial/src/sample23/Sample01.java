package sample23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(
							new InputStreamReader(System.in));
		System.out.print("Input name:");
		String name;
		try {
			name = in.readLine();
			System.out.println("hello, "+name);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

	}

}
