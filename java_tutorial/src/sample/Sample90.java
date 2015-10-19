package sample;

public class Sample90 {

	char [] cs = { '0', '1', '2', '3'};
	String[] ss = new String[4];
	
	public Sample90() {
		ss[0] = "0123";
		ss[1] = ss[0];
		ss[2] = new String(cs);
		ss[3] = String.valueOf(cs);
	}
	public void test() {
		System.out.println(ss[0].length());
		System.out.println("----");
		System.out.println(ss[0]==ss[0]);
		System.out.println(ss[0]==ss[1]);
		System.out.println(ss[0]==ss[2]);
		System.out.println(ss[0]==ss[3]);
		System.out.println("----");
		System.out.println(ss[0].equals(ss[0]));
		System.out.println(ss[0].equals(ss[1]));
		System.out.println(ss[0].equals(ss[2]));
		System.out.println(ss[0].equals(ss[3]));
	}
	public static void main(String[] args) {
		Sample90 sample90 = new Sample90();
		sample90.test();
	}

}
