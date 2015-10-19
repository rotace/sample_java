package sample17;

import sample17.App4.RemainView;

public class App6 extends App4 {

	class RemainViewEx extends RemainView {

		int count = -2;
		@Override
		public void update() {
			System.out.println("残り時間：" + App6.super.count + "秒");
			System.out.println("App6 :" + App6.this.count + "秒");
			System.out.println("Inner:" + count + "秒");
		}
	}


	int count = -1;
	
	public App6() {
		super();
		view.addObserver(new RemainViewEx());
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws Exception{
		App6 app6 = new App6();
		app6.execute();

	}

}
