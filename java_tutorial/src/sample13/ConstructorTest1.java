package sample13;

public class ConstructorTest1 extends ConstructorTestBase1 {
	
	int n;
	ConstructorTest1(){
		super(10);
		System.out.println("ConstructorTest1:" + n);
	}

}
