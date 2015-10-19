package sample15.dateformat;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.text.Format f = new java.text.SimpleDateFormat("yyyy/MM/dd");
		System.out.println(f.format(new java.util.Date()));

	}

}
