package sample13;

public class ConstructorTestBase2 {
	
	int n;

	public ConstructorTestBase2() {
		this(0);
		System.out.println("ConstructorTestBase2:引数なしのコンストラクタ");
	}
	public ConstructorTestBase2(int n) {
		super();
		this.n = n;
		System.out.println("ConstructorTestBase2:" + n);
	}
	
}
