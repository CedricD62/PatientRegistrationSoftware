package com.treatment;

import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.functions.ParseFunctions;
import com.functions.PatientFunction;
import com.objectsPackage.Chambre;
import com.objectsPackage.Examen;
import com.objectsPackage.Patient;
import com.toedter.calendar.JDateChooser;

/**
 * <b>ExaminationControler class contains all functions needed to certify the information sent by the user to the Examen Object</b>
 * </br>
 * This class contains 2 public functions and 3 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class ExaminationControler {
	/**
	 * <b>this function is used to certify that the information sent by the user are corrects</b>
	 * </br>
	 * Three different functions are used 
	 * If all the functions return true so the boolean fieldOk keep is status on true
	 * </br>
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination  
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see ExaminationControler#checkUpJTextFieldIntInput(JTextField)
	 * @see ExaminationControler#checkUpJDateChooserDateInput(JDateChooser)
	 * @see ExaminationControler#checkUpJComboBoxInput(JComboBox)
	 */
	public static boolean inputFieldControler( JLabel patientNumberExamPanelLabeld,JComboBox examinationTypeSelection,JDateChooser examinationDateField) {
		boolean fieldOk = true;
		
		if(checkUpJTextFieldIntInput(patientNumberExamPanelLabeld) == false) {
			fieldOk = false; 
		}
		if(checkUpJDateChooserDateInput(examinationDateField) == false) {
			fieldOk = false;
		}
		if(checkUpJComboBoxInput(examinationTypeSelection) == false) {
			fieldOk = false;
		}
		return fieldOk;
	}
	
	/**
	 * <b>this function is used to certify that the information sent by the user are corrects</b>
	 * </br>
	 * two different functions are used 
	 * If all the functions return true so the boolean fieldOk keep is status on true
	 * </br> 
	 * @param examinationTypeSelection : display a list of several type of examination  
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see ExaminationControler#checkUpJDateChooserDateInput(JDateChooser)
	 * @see ExaminationControler#checkUpJComboBoxInput(JComboBox)
	 */
	public static boolean inputFieldControler(JComboBox examinationTypeSelection,JDateChooser examinationDateField) {
		boolean fieldOk = true;

		if(checkUpJDateChooserDateInput(examinationDateField) == false) {
			fieldOk = false;
		}
		if(checkUpJComboBoxInput(examinationTypeSelection) == false) {
			fieldOk = false;
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
	 * @param text : a String information writen by the user
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
	 * If the ExceptionControler.numericException return true
	 * The information isn't correct the boolean fieldOk is set on false 
	 * An error message is sent to the user 
	 * </br> 
	 * @param text : a String information writen by the user
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see ExceptionControler#numericException(JTextField)
	 */
	private static boolean checkUpJTextFieldIntInput(JLabel text) {
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
	 * In a try / catch block the date selected in the JDateChooser field is stored in a Date Object
	 * If the Date isn't null boolean fieldOk is set on true
	 * if an error occurs, the catch block set the examination date to default date at today 
	 * </br> 
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * </br>
	 * @return a true or false boolean
	 */
	private static boolean checkUpJDateChooserDateInput(JDateChooser examinationDateField) {
		boolean fieldOk = false;
		
		try {
			Date date = examinationDateField.getDate();
			if(!date.equals(null)) {
				fieldOk = true;
			}
		}catch(NullPointerException n) {
			examinationDateField.setDate(new Date());
		}	
		return fieldOk;
	}
	
	/**
	 * <b>this function is used to certify that the information sent by the user is correct</b>
	 * </br>
	 * If the index selected in the JComboVBox is over 0  
	 * The boolean fieldOk is set on true
	 * </br> 
	 * @param examinationTypeSelection : display a list of several type of examination  
	 * </br>
	 * @return a true or false boolean
	 */
	private static boolean checkUpJComboBoxInput(JComboBox examinationTypeSelection) {
		boolean fieldOk = false;
		
		if(examinationTypeSelection.getSelectedIndex() > 0) {
			fieldOk = true;
		}
		
		return fieldOk;
	}
}
