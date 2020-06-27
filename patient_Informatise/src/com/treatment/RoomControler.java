package com.treatment;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.functions.ParseFunctions;
import com.functions.RoomFunction;
import com.objectsPackage.Chambre;
import com.toedter.calendar.JDateChooser;

public class RoomControler {
	public static boolean inputFieldControlerGlobalCheckUp(JRadioButton withoutRoomRButton,JRadioButton withRoomRButton,JTextField patientNumberBookingRoomPanelField,JRadioButton withAccompangyingRButton,
														   JRadioButton withoutAccompangyingRButton,JComboBox LengthOfStaySelectionBox,JDateChooser entryDateField,JDateChooser releaseDateField,
														   JTextField bedRoomNumberField) {
		boolean fieldOk = true;
		
		if(checkUpJRadioButtonInput(withRoomRButton, withoutRoomRButton) == false) {
			fieldOk = false;
		}
		if(checkUpJTextFieldIntInput(patientNumberBookingRoomPanelField) == false) {
			fieldOk = false; 
		}
		if(checkUpJRadioButtonInput(withAccompangyingRButton, withoutAccompangyingRButton) == false) {
			fieldOk = false;
		}
		if(checkUpJComboBoxInput(LengthOfStaySelectionBox) == false) {
			fieldOk = false;
		}
		if(checkUpJDateChooserDateInput(entryDateField) == false) {
			fieldOk = false;
		}
		if(checkUpJDateChooserDateInput(releaseDateField) == false) {
			fieldOk = false;
		}
		if(checkUpJTextFieldIntInput(bedRoomNumberField) == false) {
			fieldOk = false; 
		}else {
			if(ifExist(bedRoomNumberField) == false) {
				fieldOk = false;
			}
		}
		return fieldOk;
	}
	
	public static boolean inputFieldControlerBookingRoomRButton(JRadioButton withoutRoomRButton,JRadioButton withRoomRButton,JTextField patientNumberBookingRoomPanelField) {
		boolean fieldOk = true;
		
		if(checkUpJRadioButtonInput(withRoomRButton, withoutRoomRButton) == false) {
			fieldOk = false;
		}
		if(checkUpJTextFieldIntInput(patientNumberBookingRoomPanelField) == false) {
			fieldOk = false; 
		}
		
		return fieldOk;
	}

	public static boolean inputFieldControlerBeforeRoomSelection(JRadioButton withoutRoomRButton,JRadioButton withRoomRButton,JRadioButton withAccompangyingRButton,
			 													JRadioButton withoutAccompangyingRButton,JComboBox LengthOfStaySelectionBox) {
		boolean fieldOk = true;
		
		if(checkUpJRadioButtonInput(withAccompangyingRButton, withoutAccompangyingRButton) == false) {
			fieldOk = false;
		}
		if(checkUpJComboBoxInput(LengthOfStaySelectionBox) == false) {
			fieldOk = false;
		}
		
		return fieldOk;
	}
		
	public static boolean inputFieldControlerBeforeRoomBooking(JDateChooser entryDateField,JDateChooser releaseDateField,JTextField bedRoomNumberField) {
		
		boolean fieldOk = true;
		
		if(checkUpJDateChooserDateInput(entryDateField) == false) {
			fieldOk = false;
		}
		if(checkUpJDateChooserDateInput(releaseDateField) == false) {
			fieldOk = false;
		}
		if(checkUpJTextFieldIntInput(bedRoomNumberField) == false) {
			fieldOk = false; 
		}else {
			if(ifExist(bedRoomNumberField) == false) {
				fieldOk = false;
			}
		}
		
		return fieldOk;
	}
	
	private static boolean checkUpJRadioButtonInput(JRadioButton JR1, JRadioButton JR2) {
		boolean fieldOk = true;
		
		if(JR1.isSelected() == false && JR2.isSelected() == false) {
			fieldOk = false;
		}
		return fieldOk;
	}
	
	private static boolean checkUpJComboBoxInput(JComboBox LengthOfStaySelectionBox) {
		boolean fieldOk = false;
		
		if(LengthOfStaySelectionBox.getSelectedIndex() > 0) {
			fieldOk = true;
		}
		
		return fieldOk;
	}
	
	private static boolean checkUpJTextFieldIntInput(JTextField text) {
		boolean fieldOk = true;
		
		if(text.getText().equals(null) || text.getText().equals("")) {
			text.setText("erreur");
			fieldOk = false;
		}
		
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
	
	public static void disableActionOnJRadio (JRadioButton withoutAccompanyingRButton, JComboBox lengthOfStayTypeSelection, JRadioButton withAccompangyingRButton,JRadioButton withoutRoomRButton,
			  JTextField bedRoomNumberField,JDateChooser entryDateField,JDateChooser releaseDateField,JButton showRoomButton,JButton bookingRoomButton, 
			  JButton deleteBookingRoomButton) {

		if(withoutRoomRButton.isSelected()) {
		
			lengthOfStayTypeSelection.setEnabled(false);
			withAccompangyingRButton.setEnabled(false);
			withoutAccompanyingRButton.setEnabled(false);
			bedRoomNumberField.setEnabled(false);
			entryDateField.setEnabled(false);
			releaseDateField.setEnabled(false);
			showRoomButton.setEnabled(false);
			deleteBookingRoomButton.setEnabled(false);
		
		}
	}
	
	public static void ableActionOnJRadio (JRadioButton withoutAccompanyingRButton, JComboBox lengthOfStayTypeSelection, JRadioButton withAccompangyingRButton,JRadioButton withRoomRButton,
			   JTextField bedRoomNumberField,JDateChooser entryDateField,JDateChooser releaseDateField,JButton showRoomButton,JButton bookingRoomButton, 
			   JButton deleteBookingRoomButton) {
	
		if(withRoomRButton.isSelected()){
			
			lengthOfStayTypeSelection.setEnabled(true);
			withAccompangyingRButton.setEnabled(true);
			withoutAccompanyingRButton.setEnabled(true);
			bedRoomNumberField.setEnabled(true);
			entryDateField.setEnabled(true);
			releaseDateField.setEnabled(true);
			showRoomButton.setEnabled(true);
			deleteBookingRoomButton.setEnabled(true);
		
		}
	}
	
	private static boolean ifExist(JTextField text){
		boolean fieldOk = false;
		
		int roomNumber = ParseFunctions.numericConversion(text.getText());
		Chambre room;
		
		for(int i = 0; i < RoomFunction.temporaryListRoom.size(); i++) {
			
			room = RoomFunction.temporaryListRoom.get(i);
			
			if(roomNumber == room.getRoomNumber()) {
				fieldOk = true;
				break;
			}
		}
		if(fieldOk == false) {
			text.setText("erreur");	
		}	
		
		return fieldOk;
	}
}
