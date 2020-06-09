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
	
	private static ArrayList<Chambre> temporaryListRoom = new ArrayList<Chambre>();


	
	public static void creatRoomIfFileIsEmpty(JList list,ArrayList<Chambre>arrayRoom) {
		
		Chambre room;
		Examen examination = null;
		int cpt = 0;
		
		for(int i = 0; i < 42; i++) {
			
			if(cpt == 21) 
				cpt = 0;
			if(i < 15) {
				
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
				
			}else if (i >= 15 && i <= 20) {
				
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
				
			}else if (i >= 21 && i <= 35 ) {
				
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
			
		}
		
		list.setListData(arrayRoom.toArray());
	}
	
	/*public static void showInformationInBookingroomPanel(JList list, ArrayList<Examen>arrayExamination, ArrayList<Chambre>arrayRoom, JTextField patientNumberBookingRoomPanelField, JRadioButton ) {
		
	}*/
	
	
	public static void updateAvailableRoomFromSelection(JList list,ArrayList<Chambre> arrayRoom,ArrayList<Patient> arrayPatient,JTextField patientNumberBookingRoomPanelField,
												 JComboBox lengthOfStaySelectionList,JRadioButton withRoomRButton,JRadioButton withoutAccompanyingRButton,
												 JRadioButton withAccompangyingRButton) {
		
		int idPatient = Integer.parseInt(patientNumberBookingRoomPanelField.getText());
		
		if(PatientFunction.checkIfExist(arrayPatient, idPatient) == false) {
			patientNumberBookingRoomPanelField.setText("Patient introuvable");
		} else {
			if(withRoomRButton.isSelected()) {
				filterRoomWithSelection(list,arrayRoom,lengthOfStaySelectionList, withAccompangyingRButton, withoutAccompanyingRButton);
			}
		}	
	}
	
	public static void disableActionOnJRadio (JRadioButton withoutAccompanyingRButton, JComboBox lengthOfStayTypeSelection, JRadioButton withAccompangyingRButton,JRadioButton withoutRoomRButton,
											  JTextField bedRoomNumberField,JTextField entryDateField,JTextField releaseDateField,JButton showRoomButton,JButton bookingRoomButton, 
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
										   JTextField bedRoomNumberField,JTextField entryDateField,JTextField releaseDateField,JButton showRoomButton,JButton bookingRoomButton, 
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
	
	public static Chambre noBookingRoom (JList list,ArrayList<Chambre> arrayRoom,ArrayList<Examen>arrayExamination,int idPatient,JTextField patientNumberBookingRoomPanelField,
									  JComboBox lengthOfStaySelectionList,JRadioButton withRoomRButton,JRadioButton withoutRoomRButton,
									  JRadioButton withoutAccompanyingRButton,JRadioButton withAccompangyingRButton,ButtonGroup accompanyingGroup) {
		Chambre room = null;
		
		return room;
	}
	
	private static void filterRoomWithSelection(JList list,ArrayList<Chambre> arrayRoom,JComboBox LengthOfStaySelectionBox,JRadioButton withAccompangyingRButton,JRadioButton withoutAccompanyingRButton) {
		
		String lengthOfStay = "courte";
		int selection = LengthOfStaySelectionBox.getSelectedIndex();
		if(selection == -1)
			return;
		
		if(withAccompangyingRButton.isSelected()) {
			if(selection == 0) {
				selectRoomShorStaytAccompanying(list,arrayRoom);
			}else{
				selectRoomLongStaytAccompanying(list,arrayRoom);
			}
		}else{
			if(selection == 0) {
				selectRoomShorStayAlone(list,arrayRoom);
			}else {
				selectRoomLongStayAlone(list,arrayRoom);
			}
		}
		
	}
	
	
	private static void selectRoomShorStaytAccompanying(JList list,ArrayList<Chambre> arrayRoom) {
		
		Chambre room = null;
		temporaryListRoom.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			 room = arrayRoom.get(i);
			
			if(room.isAccompanying() == true && room.getRoomNumber() > 200) {
				temporaryListRoom.add(room);
			}
		}
		
		list.setListData(temporaryListRoom.toArray());
	
	}
	
	private static void selectRoomLongStaytAccompanying(JList list,ArrayList<Chambre> arrayRoom) {
		
		Chambre room = null;
		temporaryListRoom.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			 room = arrayRoom.get(i);
			
			if(room.isAccompanying() == true && room.getRoomNumber() < 200) {
				temporaryListRoom.add(room);
			}
		}
		
		list.setListData(temporaryListRoom.toArray());
		
	}
	
	private static void selectRoomShorStayAlone(JList list,ArrayList<Chambre> arrayRoom) {
		
		Chambre room = null;
		temporaryListRoom.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			 room = arrayRoom.get(i);
			
			if(room.isAlone() == true && room.getRoomNumber() > 200) {
				temporaryListRoom.add(room);
			}
		}
		
		list.setListData(temporaryListRoom.toArray());
		
	}
	
	private static void selectRoomLongStayAlone(JList list,ArrayList<Chambre> arrayRoom) {
		
		Chambre room = null;
		temporaryListRoom.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			 room = arrayRoom.get(i);
			
			if(room.isAlone() == true && room.getRoomNumber() < 200) {
				temporaryListRoom.add(room);
			}
		}
		
		list.setListData(temporaryListRoom.toArray());
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
