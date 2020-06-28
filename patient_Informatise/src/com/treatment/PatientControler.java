package com.treatment;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.filesActions.ReadExternalFiles;
import com.toedter.calendar.JDateChooser;

/**
 * <b>PatientControler class contains all functions needed to certify the information sent by the user to the Patient Object</b>
 * </br>
 * This class contains 1 public functions and 9 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class PatientControler {
	
	/**
	 * <b>this function is used to certify that the information sent by the user are corrects</b>
	 * </br>
	 * Ten different functions are used 
	 * If all the functions return true so the boolean fieldOk keep is status on true
	 * </br>
	 * @param idField : specify the id of the Patient for the moment writting manually but will be improve to be set automatically
	 * @param maleRButton :  the gender of the patient male is set on true if the Patient is a male else set on false 
	 * @param femaleRButton : the gender of the patient female is set on true if the Patient is a female else set on false 
	 * @param nameField : the name of the patient
	 * @param fNameField : the first Name of the patient
	 * @param addressField : the address of the patient
	 * @param areaCodeField : the area code of the patient
	 * @param townField : the city of the patient
	 * @param ssnField : the social security number of the patient
	 * @param eMailField : the email address of the patient
	 * @param phoneField : the phone number of the patient
	 * @param cellphoneField :  the birthDate of the patient
	 * @param birthdateField :  the birthDate of the patient
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see PatientControler#checkUpJTextFieldIntInput(JTextField)
	 * @see PatientControler#checkUpAvailableEmail(JTextField)
	 * @see PatientControler#checkUpJTextFieldIntInput(JTextField)
	 * @see PatientControler#checkUpAvailablePhoneNumber(JTextField)
	 * @see PatientControler#checkUpAvailableAreaCode(JTextField)
	 * @see PatientControler#checkUpJTextFieldLongInput(JTextField)
	 * @see PatientControler#checkUpSsnLength(JTextField)
	 * @see PatientControler#checkUpJRadioButtonInput(JRadioButton, JRadioButton)
	 * @see PatientControler#checkUpJDateChooserDateInput(JDateChooser)
	 */
	public static boolean inputFieldControler(JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton,JTextField nameField, JTextField fNameField,
											  JTextField addressField, JTextField areaCodeField, JTextField townField,JTextField ssnField,JTextField eMailField, JTextField phoneField, 
											  JTextField cellphoneField, JDateChooser birthdateField) {
		boolean fieldOk = true;
		
		if(checkUpJTextFieldStringInput(nameField) == false) {
			fieldOk = false;
		}
		if(checkUpJTextFieldStringInput(fNameField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldStringInput(addressField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldStringInput(townField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldStringInput(eMailField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailableEmail(eMailField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldIntInput(phoneField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailablePhoneNumber(phoneField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldIntInput(cellphoneField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailablePhoneNumber(cellphoneField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldIntInput(idField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldIntInput(areaCodeField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailableAreaCode(areaCodeField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldLongInput(ssnField) == false) {
			fieldOk = false; 
		} else {
			if(checkUpSsnLength(ssnField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJRadioButtonInput(maleRButton,femaleRButton) == false) {
			fieldOk = false; 
		}
		if(checkUpJDateChooserDateInput(birthdateField) == false) {
			fieldOk = false;
		}
		
		return fieldOk;
	}
	
	/**
	 * <b>this function is used to certify that the information sent by the user is correct</b>
	 * </br>
	 * If the text is null or void
	 * An error message is sent to the user , fieldOk is set on false 
	 * If the ExceptionControler.stringException return false
	 * An error message is sent to the user , fieldOk is set on false 
	 * </br> 
	 * @return a true or false boolean
	 * </br>
	 * @see ExceptionControler#stringException(JTextField)
	 */
	private static boolean checkUpJTextFieldStringInput(JTextField text) {
		boolean fieldOk = true;
		
		if(text.getText().equals(null) || text.getText().equals("")) {
			text.setText("erreur");
			fieldOk = false;
		}
		
		if(ExceptionControler.stringException(text) == false) {
			fieldOk = false;
			text.setText("erreur");
		}
		
		return fieldOk;
	}
	
	/**
	 * <b>this function is used to certify that the information sent by the user is correct</b>
	 * </br>
	 * If the ExceptionControler.numericException return true
	 * The information isn't correct the boolean fieldOk is set on false 
	 * An error message is sent to the user 
	 * </br> 
	 * @param text : a String information written by the user
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see ExceptionControler#numericException(JTextField)
	 */
	private static boolean checkUpJTextFieldIntInput(JTextField text) {
		boolean fieldOk = true;
		
		if(ExceptionControler.numericException(text) == true) {
			fieldOk = false;
			text.setText("erreur");
		}	
		return fieldOk;
	}

	/**
	 * <b>this function is used to certify that the information sent by the user is correct</b>
	 * </br>
	 * If the ExceptionControler.numericLongException return true
	 * The information isn't correct the boolean fieldOk is set on false 
	 * An error message is sent to the user 
	 * </br> 
	 * @param text : a String information written by the user
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see ExceptionControler#numericLongException(JTextField)
	 */
	private static boolean checkUpJTextFieldLongInput(JTextField text) {
		boolean fieldOk = true;
		
		if(ExceptionControler.numericLongException(text) == true) {
			fieldOk = false;
			text.setText("erreur");
		}	
		return fieldOk;
	}
	
	/**
	 * <b>this function is used to certify that the information sent by the user is correct</b>
	 * </br>
	 * Those two JRadioButton are member of a same ButtonGroup, it doesn't allow them to have the same value
	 * If those two have the same value so no selection has been done by the user 
	 * FieldOk is set on false 
	 * </br> 
	 * @param JR1 : a JRadioButton with a specific boolean value
	 * @param JR2 : a JRadioButton with a specific boolean value
	 * </br>
	 * @return a true or false boolean
	 */
	private static boolean checkUpJRadioButtonInput(JRadioButton JR1, JRadioButton JR2) {
		boolean fieldOk = true;
		
		if(JR1.isSelected() == false && JR2.isSelected() == false) {
			fieldOk = false;
		}
		return fieldOk;
	}
	
	/**
	 * <b>this function is used to certify that the Date is correct</b>
	 * </br>
	 * In a try / catch block the date selected in the JDateChooser field is stored in a Date Object
	 * If the Date isn't null boolean fieldOk is set on true
	 * if an error occurs, the catch block set the examination date to default date at today 
	 * </br> 
	 * @param birthdateField :  the birthDate of the patient
	 * </br>
	 * @return a true or false boolean
	 */
	private static boolean checkUpJDateChooserDateInput(JDateChooser birthdateField) {
		boolean fieldOk = false;
		
		try {
			Date date = birthdateField.getDate();
			if(!date.equals(null)) {
				fieldOk = true;
			}
		}catch(NullPointerException n) {
			birthdateField.setDate(new Date());
		}	
		return fieldOk;
	}

	/**
	 * <b>this function is used to certify that the Email is correct</b>
	 * </br>
	 * The email is stored in a String variable
	 * IndexOf is used to check the @ in the email address
	 * The information isn't correct the boolean fieldOk is set on false 
	 * An error message is sent to the user 
	 * </br> 
	 * @param text : a String information writen by the user
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see String#indexOf(String)
	 * @see String#endsWith(String)
	 */
	private static boolean checkUpAvailableEmail(JTextField text) {
		boolean email = false;
		
		int variableTampon = 0;		
		String mailAddress = text.getText();
	
								
			variableTampon = mailAddress.indexOf("@");
			
			for(int i = 0; i < ReadExternalFiles.arrayMail.size(); i++) {
				
				if(variableTampon > 0 && mailAddress.endsWith(ReadExternalFiles.arrayMail.get(i)) == true ) {
					email = true;
					break;
				}
			}
			
			if(email == false) {
				text.setText("erreur");
			}
			
		return email;
	}
	
	private static boolean checkUpAvailablePhoneNumber(JTextField text) {
		boolean phoneNumber = false;
		String [] phoneBegin = {"01","02","03","04","05","06","07","09"};	
		String patientPhoneNumber = text.getText();
		
		if(patientPhoneNumber.length() == 10) {
			for(int i = 0; i < phoneBegin.length; i++) {
				if( patientPhoneNumber.startsWith(phoneBegin[i]) == true) {
					phoneNumber = true;
					break;
				}
			}
		}
		
		if(phoneNumber == false) {
			text.setText("erreur");	
		}	
		
		return phoneNumber;
	}
	
	private static boolean checkUpAvailableAreaCode(JTextField text) {
		boolean codeOk = false;
		String patientAreaCode = text.getText();
		
									
		for(int i = 0; i < ReadExternalFiles.arrayAreaCode.size(); i++) {
			
			if(ReadExternalFiles.arrayAreaCode.get(i).contentEquals(patientAreaCode)) {
				codeOk = true;
				break;
			}
		}
		
		return codeOk;
	}
	
	private static boolean checkUpSsnLength(JTextField text) {
		boolean ssnLength = false;
		
		String patientSsn = text.getText();
		
		if(patientSsn.length() == 15) {
			ssnLength = true;
		}else {
			text.setText("erreur");
		}	
		
		return ssnLength;
	}
}
