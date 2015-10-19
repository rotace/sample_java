package sample;

public class Sample92 {

	String s = "0123";
	public void test() {
		char[] c0123 = s.toCharArray();
		System.out.print("s.toCharArray():");
		for (int i=0; i<c0123.length ; i++) {
			System.out.print(c0123[i]+" ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		Sample92 sample92 = new Sample92();
		sample92.test();

	}

}
