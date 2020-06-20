package functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class ParseFunctions {

	public static String dateFormating(JDateChooser date){
		
		SimpleDateFormat dateString = new SimpleDateFormat("dd/MM/yyy");
		String dateFormat = dateString.format(date.getDate());
		
		return dateFormat;
	}
	
	public static String dateFormating(Date date){
		
		SimpleDateFormat dateString = new SimpleDateFormat("dd/MM/yyy");
		String dateFormat = dateString.format(date);
		
		return dateFormat;
	}
	
	public static Date dateFormating(String date){
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
		Date dateFormat = null;
		
		try {
			dateFormat = format.parse(date);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
	
		return dateFormat;
	}
	
	public static int numericConversion(String field) {
		
		int value = Integer.parseInt(field);
		return value;
	}
	
	public static long numericConversionLong(String field) {
		
		long value = Long.parseLong(field);
		return value;
	}
}
