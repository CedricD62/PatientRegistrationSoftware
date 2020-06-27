package com.functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

/**
 * 
 * <b>ParseFunctions class contains all the functions needed for parsing values</b>
 * </br>
 * This class contains 5 public functions
 * @author C.DEBAISIEUX
 * @version 1.0
 */
public class ParseFunctions {

	/**
	 * 
	 * <b>this function parse a Date registered from a JDateChooser field in String</b>
	 * </br>
	 * @param date : contains a date registered by the user
	 * </br>
	 * @return return a date in String format
	 */
	public static String dateFormating(JDateChooser date){
		
		SimpleDateFormat dateString = new SimpleDateFormat("dd/MM/yyy");
		String dateFormat = dateString.format(date.getDate());
		
		return dateFormat;
	}
	
	/**
	 * 
	 * <b>this function parse a Date Object in String</b>
	 * </br>
	 * @param date : contains a date registered by the user
	 * </br>
	 * @return return a date in String format
	 */
	public static String dateFormating(Date date){
		
		SimpleDateFormat dateString = new SimpleDateFormat("dd/MM/yyy");
		String dateFormat = dateString.format(date);
		
		return dateFormat;
	}
	
	/**
	 * 
	 * <b>this function parse a String in Date Object</b>
	 * </br>
	 * @param contains a date registered by the user
	 * </br>
	 * @return return a date in Date format
	 */
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
	
	/**
	 * 
	 * <b>this function parse a String in int </b>
	 * </br>
	 * @param field contains an int value in string format
	 * </br>
	 * @return return an int value
	 */
	public static int numericConversion(String field) {
		
		int value = Integer.parseInt(field);
		return value;
	}
	
	/**
	 * 
	 * <b>this function parse a String in long </b>
	 * </br>
	 * @param field contains a long value in string format
	 * </br>
	 * @return return a long value
	 */
	public static long numericConversionLong(String field) {
		
		long value = Long.parseLong(field);
		return value;
	}
}
