package sample17;

public class Sample1 {
	private static int v1 = 1;
	private int v2 = 2;
	public int v3 = 3;
	static class Ic {
		public static int vi1 = 11;
		public int vi2 = 12;
		public void print(){
			System.out.println("v1  :" + v1  );
			System.out.println("vi2 :" + vi2 );
//			System.out.println("v2  :" + v2  );
		}
		public void printSample1(Sample1 o){
			System.out.println("o.v2:" + o.v2);
		}
	}
}
