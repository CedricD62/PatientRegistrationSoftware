package com.treatment;

import java.util.InputMismatchException;

import javax.swing.JTextField;

public class ExceptionControler {

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
