package sample12;

public class Sample02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Base base = new Base();
		A a = new A();
		
		System.out.println("base.baseField   :" + base.baseField);
		System.out.println("base.baseMethod():" + base.baseMethod());
		
		System.out.println("a.baseField      :" + a.baseField);
		System.out.println("a.baseMethod()   :" + a.baseMethod());
		
		System.out.println("a.aField         :" + a.aField);
		System.out.println("a.aMethod()      :" + a.aMethod());
		
		base.baseField = 3;
		System.out.println("base.baseField   :" + base.baseField);
		System.out.println("a.baseField      :" + a.baseField);
		
		a.baseField = 10;
		System.out.println("base.baseField   :" + base.baseField);
		System.out.println("a.baseField      :" + a.baseField);
	}

}
