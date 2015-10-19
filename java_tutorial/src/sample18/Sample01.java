package sample18;

public class Sample01 {

	
	static class PrintApp {
		public void printInt(int v){
			Integer i = Integer.valueOf(v);
			String  s = i.toString();
			System.out.println(s);
		}
		public void printDouble(double v){
			Double d = Double.valueOf(v);
			String s = d.toString();
			System.out.println(s);
		}
		public void printBoolean(boolean v){
			Boolean b = Boolean.valueOf(v);
			String  s = b.toString();
			System.out.println(s);
		}
		public void printObject(Object v){
			String s = v.toString();
			System.out.println(s);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintApp app = new PrintApp();
		app.printInt(1);
		app.printDouble(2.0);
		app.printBoolean(false);
		app.printObject(new Object());
	}

}
