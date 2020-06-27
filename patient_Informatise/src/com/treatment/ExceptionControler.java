package com.treatment;

import java.util.InputMismatchException;

import javax.swing.JTextField;

/**
 * 
 * <b>ExceptionControler class contains all the functions needed to avoid an error to occur</b>
 * </br>
 * This class contains 3 public functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class ExceptionControler {

	/**
	 * this function check if the field contains an int
	 * </br>
	 * The text is parsed in int if an error occur it is catched   	 
	 * </br>
	 * @param text contains an unknown type of value needed to be checked with a try / catch
	 * </br>
	 * @return a boolean true or false 
	 */
	public static boolean numericException(JTextField text) {
		boolean error = false;
			try {
				
				int value = Integer.parseInt(text.getText()); 
				error = false; 
				
			} catch (InputMismatchException e) {
				error = true; 
			} catch (NumberFormatException e) {
				error = true; 
			}	
		return error;
	}
	
	/**
	 * this function check if the field contains a long 
	 * </br>
	 * The text is parsed in long if an error occur it is catched   	 
	 * </br>
	 * @param text contains an unknown type of value needed to be checked with a try / catch
	 * </br>
	 * @return a boolean true or false 
	 */
	public static boolean numericLongException(JTextField text) {
		boolean error = false;
			try {
				long value = Long.parseLong(text.getText()); 
				error = false; 		
			} catch (InputMismatchException e) {		
				error = true; 
			} catch (NumberFormatException e) {
				error = true; 
			}
		return error;
	}
	
	/**
	 * this function check if the field contains another type of value than a String 
	 * </br>
	 * The text is parsed in int if an error occur it is catched   	 
	 * </br>
	 * @param text should contains a String but it needs to be checked with a try / catch
	 * </br>
	 * @return a boolean true or false 
	 */
	public static boolean stringException(JTextField text) {
		boolean error = false;
			try {	
				int value = Integer.parseInt(text.getText()); 
				error = false; 			
			} catch (NumberFormatException e) {
				error = true; 
			}
		return error;
	}
}
