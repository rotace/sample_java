package sample15.dateformater;

import java.util.Calendar;

public abstract class DateFormatter {

	private String formatString = "";

	public String getFormatString() {
		return formatString;
	}

	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
	
	public abstract String format(Calendar c);


}
