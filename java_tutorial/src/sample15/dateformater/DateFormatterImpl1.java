package sample15.dateformater;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatterImpl1 extends DateFormatter {

	@Override
	public String format(Calendar c) {
		SimpleDateFormat df = new SimpleDateFormat(super.getFormatString());
		return df.format(new Date(c.getTimeInMillis()));
	}

}
