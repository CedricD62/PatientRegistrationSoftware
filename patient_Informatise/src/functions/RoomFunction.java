package functions;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import patient_Informatise.Chambre;
import patient_Informatise.Examen;
import patient_Informatise.Patient;

public class RoomFunction 
{

	private static ArrayList<Chambre> temporaryList = new ArrayList<Chambre>();

	
	public static void creatRoomIfFileIsEmpty(JList list,ArrayList<Chambre>arrayRoom) {
		
		Chambre room;
		Examen examination = null;
		int cpt = 0;
		
		for(int i = 0; i < 40; i++) {
			
			if(i <= 15) {
				
				boolean accompanying = false;
				boolean alone = true;
				boolean availble = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 1;
				int roomNumber = 100 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,examination,availble,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else if (i > 15 && i < 20) {
				
				boolean accompanying = true;
				boolean alone = false;
				boolean availble = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 2;
				int roomNumber = 100 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,examination,availble,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else if (i >= 20 && i <= 35 ) {
				
				boolean accompanying = false;
				boolean alone = true;
				boolean availble = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 1;
				int roomNumber = 200 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,examination,availble,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else {

				boolean accompanying = true;
				boolean alone = false;
				boolean availble = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 2;
				int roomNumber = 200 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,examination,availble,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}
			cpt++;
			if(cpt == 20) 
				cpt = 0;
			
		}
		
		list.setListData(arrayRoom.toArray());
	}
	
	public void updateAvailableRoomFromSelection(JList list,ArrayList<Chambre> arrayRoom,ArrayList<Patient> arrayPatient ,JTextField patientNumberBookingRoomPanelField,
												 JComboBox lengthOfStaySelectionList,JRadioButton withRoomRButton,JRadioButton withoutRoomRButton,JRadioButton withoutAccompanyingRButton,
												 JRadioButton withAccompangyingRButton,ButtonGroup accompanyingGroup) {
		
		int id = Integer.parseInt(patientNumberBookingRoomPanelField.getText());
		
		Patient patient = PatientFunction.extractPatientFromArray(arrayPatient,id);
		
		if(patient == null) {
			patientNumberBookingRoomPanelField.setText("Patient introuvable");
		}
		
		
		
		
		
			
	}
	
	public static void disableActionOnJRadio (JRadioButton withoutAccompanyingRButton, JComboBox lengthOfStaySelectionList, JRadioButton withAccompangyingRButton,JRadioButton withoutRoomRButton,
											  JTextField bedRoomNumberField,JTextField entryDateField,JTextField releaseDateField,JButton showRoomButton,JButton bookingRoomButton, 
											  JButton deleteBookingRoomButton) {
		
		if(withoutRoomRButton.isSelected()) {
			
			lengthOfStaySelectionList.setEnabled(false);
			withAccompangyingRButton.setEnabled(false);
			withoutAccompanyingRButton.setEnabled(false);
			bedRoomNumberField.setEnabled(false);
			entryDateField.setEnabled(false);
			releaseDateField.setEnabled(false);
			showRoomButton.setEnabled(false);
			deleteBookingRoomButton.setEnabled(false);
		}
	}
	
	public static void ableActionOnJRadio (JRadioButton withoutAccompanyingRButton, JComboBox lengthOfStaySelectionList, JRadioButton withAccompangyingRButton,JRadioButton withRoomRButton,
										   JTextField bedRoomNumberField,JTextField entryDateField,JTextField releaseDateField,JButton showRoomButton,JButton bookingRoomButton, 
										   JButton deleteBookingRoomButton) {
		
		if(withRoomRButton.isSelected()){
			lengthOfStaySelectionList.setEnabled(true);
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
