package sample17;

public class Sample1App {

	public static void printSample1(Sample1 o){
//		System.out.println("o.v2:" + o.v2);
		System.out.println("v3  :" + o.v3);
		System.out.println("vi1 :" + Sample1.Ic.vi1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sample1.Ic ic = new Sample1.Ic();
		ic.print();
		Sample1 enclosingClassObject = new Sample1();
		ic.printSample1(enclosingClassObject);
		Sample1App.printSample1(enclosingClassObject);

	}

}
