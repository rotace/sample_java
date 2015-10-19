package sample;

public class Sample91 {

	String s = "0123";
	public void test() {
		String s0 = s.substring(0,1);
		String s1 = s.substring(1,2);
		String s2 = s.substring(2,3);
		System.out.print(s0 + ":");
		System.out.println(s.startsWith(s0));
		System.out.print(s1 + ":");
		System.out.println(s.startsWith(s1));
		System.out.print(s2 + ":");
		System.out.println(s.startsWith(s2));
	}
	
	public static void main(String[] args) {
		Sample91 sample91 = new Sample91();
		sample91.test();
	}

}
