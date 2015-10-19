package sample12;

public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		B b = new B();
		A bb = (A)b;
		
		System.out.println("b.baseField      :" + bb.baseField);
		System.out.println("b.baseMethod()   :" + bb.baseMethod());
		System.out.println("b.aMethod()      :" + bb.aMethod());
		System.out.println("-------------------------");
		
		A a = new A();
		System.out.println("a.baseField      :" + a.baseField);
		System.out.println("a.baseMethod()   :" + a.baseMethod());
		System.out.println("a.aMethod()      :" + a.aMethod());
	}

}
