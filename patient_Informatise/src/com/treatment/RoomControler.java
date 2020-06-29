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

/**
 * <b>RoomControler class contains all functions needed to certify the information sent by the user to the Chambre Object</b>
 * </br>
 * This class contains 6 public functions and 5 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class RoomControler {
	/**
	 * <b>this function is used to certify that the information sent by the user are corrects</b>
	 * </br>
	 * Six different functions are used 
	 * If all the functions return true so the boolean fieldOk keep is status on true
	 * </br>
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param withRoomRButton : Radio Button if selected return true
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * @param withAccompangyingRButton : Radio Button if selected return true
	 * @param withoutAccompangyingRButton : Radio Button if selected return true
	 * @param LengthOfStaySelectionBox : several values are available for the user to select
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see RoomControler#checkUpJRadioButtonInput(JRadioButton, JRadioButton)
	 * @see RoomControler#checkUpJTextFieldIntInput(JTextField)
	 * @see RoomControler#checkUpJComboBoxInput(JComboBox)
	 * @see RoomControler#checkUpJDateChooserDateInput(JDateChooser)
	 * @see RoomControler#checkUpJTextFieldIntInput(JTextField)
	 * @see RoomControler#ifExist(JTextField)
	 */
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
	
	/**
	 * <b>this function is used to certify that the information sent by the user are corrects</b>
	 * </br>
	 * two different functions are used 
	 * If all the functions return true so the boolean fieldOk keep is status on true
	 * </br>
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param withRoomRButton : Radio Button if selected return true
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see RoomControler#checkUpJRadioButtonInput(JRadioButton, JRadioButton)
	 * @see RoomControler#checkUpJTextFieldIntInput(JTextField)
	 */
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

	/**
	 * <b>this function is used to certify that the information sent by the user are corrects</b>
	 * </br>
	 * two different functions are used 
	 * If all the functions return true so the boolean fieldOk keep is status on true
	 * </br>
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param withRoomRButton : Radio Button if selected return true
	 * @param withAccompangyingRButton : Radio Button if selected return true
	 * @param withoutAccompangyingRButton : Radio Button if selected return true
	 * @param LengthOfStaySelectionBox : several values are available for the user to select
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see RoomControler#checkUpJRadioButtonInput(JRadioButton, JRadioButton)
	 * @see RoomControler#checkUpJComboBoxInput(JComboBox)
	 */
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
		
	/**
	 * <b>this function is used to certify that the information sent by the user are corrects</b>
	 * </br>
	 * Three different functions are used 
	 * If all the functions return true so the boolean fieldOk keep is status on true
	 * </br>
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 * @see RoomControler#checkUpJDateChooserDateInput(JDateChooser)
	 * @see RoomControler#checkUpJTextFieldIntInput(JTextField)
	 * @see RoomControler#ifExist(JTextField)
	 */
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
	 * <b>this function is used to certify that the information sent by the user is correct</b>
	 * </br>
	 * If the index selected in the JComboVBox is over 0  
	 * The boolean fieldOk is set on true
	 * </br> 
	 * @param LengthOfStaySelectionBox : several values are available for the user to select
	 * </br>
	 * @return a true or false boolean
	 */
	private static boolean checkUpJComboBoxInput(JComboBox LengthOfStaySelectionBox) {
		boolean fieldOk = false;
		
		if(LengthOfStaySelectionBox.getSelectedIndex() > 0) {
			fieldOk = true;
		}
		
		return fieldOk;
	}
	
	/**
	 * <b>this function is used to certify that the information sent by the user is correct</b>
	 * </br>
	 * If the text is null or void
	 * An error message is sent to the user , fieldOk is set on false 
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
	 *<b>This function disable the following parameter</b>
	 *This action is activated if the user don't want to book a room 
	 *In this case the only available Button is the one needed to validate the choice
	 *To select "Oui" next to "reservation" to put the following parameter back to enable mode 
	 * </br>
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param LengthOfStaySelectionBox : several values are available for the user to select
	 * @param withAccompangyingRButton : Radio Button if selected return true
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * @param showRoomButton : button activation the functions needed to show the available Chambre Object from the user's selection
	 * @param bookingRoomButton : Radio Button if selected return true
	 * @param deleteBookingRoomButton : button activating the functions needed to delete a Chambre Object
	 */
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
	
	/**
	 *<b>This function enable the following parameter</b>
	 *This action is activated if the user want to book a room 
	 *To select "Non" next to "reservation" to put the following parameter in disable mode 
	 * </br>
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param LengthOfStaySelectionBox : several values are available for the user to select
	 * @param withAccompangyingRButton : Radio Button if selected return true
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * @param showRoomButton : button activation the functions needed to show the available Chambre Object from the user's selection
	 * @param bookingRoomButton : Radio Button if selected return true
	 * @param deleteBookingRoomButton : button activating the functions needed to delete a Chambre Object
	 */
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
	
	/**
	 * <b>This function check the room number</b>
	 * Usually the following parameter is disable 
	 * This function is used if an error with the settings occurs
	 * It certify that the number selected is one selectable after the choices made by the user
	 * </br> 
	 * @param text : a String information writen by the user
	 * </br>
	 * @return a true or false boolean
	 * </br>
	 */
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
