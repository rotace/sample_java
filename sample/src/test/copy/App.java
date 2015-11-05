package test.copy;

import java.util.Arrays;

public class App {
	
	public static class MyClass {
	}
	
	public static void arrayTest() {
		String[] strs = {
				"test0",
				"test1",
				"test2"
				};
		int size = strs.length;
		
		// shallow copy
		String[] strs0 = strs;
		strs0[0] = "test0-shallow";
		
		// deep copy
		String[] strs1 = Arrays.copyOf(strs, strs.length);
		strs1[1] = "test1-deep";
		
		// deep copy
		String[] strs2 = new String[size];
		for( int i=0; i<size; i++ ){
			strs2[i] = strs[i];
		}
		strs2[2] = "test2-strs2";
		
		// output
		for( String str : strs ){
			System.out.println(str);
		}
	}
	
	public static void stringTest(){
		String str  = "test";
		String str1 = str;
		str1 = "test-shallow";
		System.out.println(str);
	}
	
	public static void myClassTest(){
		MyClass myclass = new App.MyClass();
		MyClass myclass1 = myclass;
		myclass1 = new App.MyClass();
		System.out.println(myclass);
		System.out.println(myclass1);
	}
		
	public static void main(String[] args) {
		System.out.println("## arrayTest");
		arrayTest();
		System.out.println("## stringTest");
		stringTest();
		System.out.println("## myClassTest");
		myClassTest();
	}
}
