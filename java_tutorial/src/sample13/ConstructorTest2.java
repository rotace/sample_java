package sample13;

public class ConstructorTest2 extends ConstructorTestBase2 {

	int n;
	

	public ConstructorTest2() {
		super();
		System.out.println("ConstructorTest2:");
	}

	public ConstructorTest2(int n) {
		super(n);
		System.out.println("ConstructorTest2:" + n);
	}
	
	ConstructorTest2(int m, int n){
		this(m*n);
		System.out.println("ConstructorTest2(m*n):" + m*n );
	}
	
	
}
