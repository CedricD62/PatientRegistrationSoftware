package functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class ParseFunctions {

	
	public static String dateFormat(JDateChooser date){
		
		SimpleDateFormat dateString = new SimpleDateFormat("dd/MM/yyy");
		String dateFormat = dateString.format(date);
		
		return dateFormat;
	}
	
	public static String dateFormat(Date date){
		
		SimpleDateFormat dateString = new SimpleDateFormat("dd/MM/yyy");
		String dateFormat = dateString.format(date);
		
		return dateFormat;
	}
	
	public static Date dateFormat(String date){
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
		Date dateFormat = null;
		
		try {
			dateFormat = format.parse(date);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
	
		return dateFormat;
	}
	
}
