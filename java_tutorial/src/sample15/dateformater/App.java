package sample15.dateformater;

import java.util.Calendar;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		DateFormatter df = new DateFormatterImpl1();
		df.setFormatString("yyyy/MM/dd");
		System.out.println(df.format(c));
		df.setFormatString("yyyy/MM");
		System.out.println(df.format(c));
		
		df = new DateFormatterImpl2();
		df.setFormatString("%1tY/%1$tm/%1$td");
		System.out.println(df.format(c));
		df.setFormatString("%1tY/%1$tm");
		System.out.println(df.format(c));
	}

}
