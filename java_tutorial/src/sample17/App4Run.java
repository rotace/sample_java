package sample17;

public class App4Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws Exception{
		App4 app4 = new App4();
		App4.RemainView remainView = app4.new RemainView();
		
		app4.view.addObserver(remainView);
		app4.execute();

	}

}
