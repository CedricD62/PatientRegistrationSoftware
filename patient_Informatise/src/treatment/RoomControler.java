package treatment;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class RoomControler {
	
	public static boolean inputFieldControler() {
		boolean fieldCheckUpOk = false;
		
		return fieldCheckUpOk;
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
}
