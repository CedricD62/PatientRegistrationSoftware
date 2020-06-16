package functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class ParseFunctions {

	
	public static String dateFormat(JDateChooser date) throws ParseException {
		
		SimpleDateFormat dateString = new SimpleDateFormat("yyyy/MM/dd");
		String dateFormat = dateString.format(date);
		
		return dateFormat;
	}
	
}
