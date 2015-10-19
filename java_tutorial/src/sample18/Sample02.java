package sample18;

public class Sample02 {

	
	static class PrintApp {
		public void print(int v){
			Integer i = Integer.valueOf(v);
			String  s = i.toString();
			System.out.println(s);
		}
		public void print(double v){
			Double d = Double.valueOf(v);
			String s = d.toString();
			System.out.println(s);
		}
		public void print(boolean v){
			Boolean b = Boolean.valueOf(v);
			String  s = b.toString();
			System.out.println(s);
		}
		public void print(Object v){
			String s = v.toString();
			System.out.println(s);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintApp app = new PrintApp();
		app.print(1);
		app.print(2.0);
		app.print(false);
		app.print(new Object());
	}

}
