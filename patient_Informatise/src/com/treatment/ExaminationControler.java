package com.treatment;

import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class ExaminationControler {
	
	public static boolean inputFieldControler(JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,JDateChooser examinationDateField) {
		boolean fieldOk = true;
		
		if(checkUpJTextFieldIntInput(patientNumberExamPanelField) == false) {
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
	
	private static boolean checkUpJTextFieldIntInput(JTextField text) {
		boolean fieldOk = true;
		
		if(ExceptionControler.numericException(text) == true) {
			fieldOk = false;
			text.setText("erreur");
		}	
		return fieldOk;
	}

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
	
	private static boolean checkUpJComboBoxInput(JComboBox examinationTypeSelection) {
		boolean fieldOk = false;
		
		if(examinationTypeSelection.getSelectedIndex() > 0) {
			fieldOk = true;
		}
		
		return fieldOk;
	}
}
