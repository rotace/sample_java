package sample;

public class Sample100 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Sample100().excute();

	}
	
	public void excute(){
		test(new java.util.ArrayList()  );
		test(new java.util.LinkedList() );

	}
	
	public void test(java.util.List list) {
		list.add("A");
		list.add("B");
		for (int i=0; i<list.size(); i++){
			String s = (String)list.get(i);
			System.out.print(s+" ");
		}
		System.out.println("");
	}

}
