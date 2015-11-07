package test.array;

import java.util.ArrayList;

public class App {
	
	public static void arrayListTest() {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		
		list.add(0);
		
		list.set(0, 0);
		list.set(1, 1);
		list.set(2, 2);
		list.set(5, 5);
		list.set(9, 9);
		
	}
	
	public static void main(String[] args) {
		System.out.println("## arrayListTest");
		arrayListTest();
	}

}
