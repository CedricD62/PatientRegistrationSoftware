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
	
	public static ArrayList<Chambre> temporaryListRoom = new ArrayList<Chambre>();

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
	public static void creatRooom(JList list, ArrayList<Chambre> arrayRoom,ArrayList<Examen> arrayExamination,ArrayList<Patient> arrayPatient, JTextField entryDateField, 
								  JTextField releaseDateField, JTextField patientNumberBookingRoomPanelField, JTextField bedRoomNumberField,JRadioButton withoutRoomRButton) {
		
		if (patientNumberBookingRoomPanelField.getText().equals("") || patientNumberBookingRoomPanelField.getText().contentEquals("Patient introuvable") ) {
			patientNumberBookingRoomPanelField.setText("Patient introuvable");
			list.setListData(arrayExamination.toArray());
			return;
		}
		int idPatient = Integer.parseInt(patientNumberBookingRoomPanelField.getText());
		
		if(PatientFunction.checkIfExist(arrayPatient, idPatient) == false) {
			patientNumberBookingRoomPanelField.setText("Patient introuvable");
			list.setListData(arrayExamination.toArray());
		}
		
		Examen examination = ExaminationFunction.extractExaminationFromArray(arrayExamination, arrayPatient, idPatient);
		Chambre room = extractRoomFromArray(arrayRoom, bedRoomNumberField);
		
		updateRoomInformation(list,examination,room,entryDateField,releaseDateField,withoutRoomRButton);
		
	}
	
	private static void updateRoomInformation(JList list, Examen examination, Chambre room, JTextField entryDateField, JTextField releaseDateField,
											  JRadioButton withoutRoomRButton) {

		if(withoutRoomRButton.isSelected()== true) {
			noBookingRoom(list, examination, room);
		}else {
			bookingRoom(list, examination, room, entryDateField, releaseDateField);
		}
	
	}

	
	public static void updateAvailableRoomFromSelection(JList list,ArrayList<Chambre> arrayRoom,ArrayList<Examen> arrayExamination,ArrayList<Patient> arrayPatient,JTextField patientNumberBookingRoomPanelField,
												 JComboBox lengthOfStaySelectionList,JRadioButton withRoomRButton,JRadioButton withoutAccompanyingRButton,
												 JRadioButton withAccompangyingRButton) {
		if (patientNumberBookingRoomPanelField.getText().equals("") || patientNumberBookingRoomPanelField.getText().contentEquals("Patient introuvable") ) {
			patientNumberBookingRoomPanelField.setText("Patient introuvable");
			list.setListData(arrayExamination.toArray());
			return;
		}
		int idPatient = Integer.parseInt(patientNumberBookingRoomPanelField.getText());
		
		if(PatientFunction.checkIfExist(arrayPatient, idPatient) == false) {
			patientNumberBookingRoomPanelField.setText("Patient introuvable");
			list.setListData(arrayExamination.toArray());
		} else {
			if(withRoomRButton.isSelected()) {
				filterRoomWithSelection(list,arrayRoom,lengthOfStaySelectionList, withAccompangyingRButton, withoutAccompanyingRButton);
			}
		}	
	}
	
	public static void showInformationRoomAndExamination(JList list,ArrayList<Chambre> arrayRoom,ArrayList<Examen> arrayExamination,JTextField patientNumberBookingRoomPanelField,
														 JTextField bedRoomNumberField) {
		
		if(temporaryListRoom.isEmpty()) {
			showInformationFromArrayExamination(list,arrayExamination,patientNumberBookingRoomPanelField);
		}else {
			showInformationFromTemporaryListRoom(list, bedRoomNumberField, arrayRoom);
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
	
	private static void filterRoomWithSelection(JList list,ArrayList<Chambre> arrayRoom,JComboBox LengthOfStaySelectionBox,JRadioButton withAccompangyingRButton,JRadioButton withoutAccompanyingRButton) {
		
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
			 
			if(room.isAvailable() == true) {
				if(room.isAccompanying() == true && room.getRoomNumber() > 200) {
					temporaryListRoom.add(room);
				}
			}
		}
		
		list.setListData(temporaryListRoom.toArray());
	
	}
	
	private static void selectRoomLongStaytAccompanying(JList list,ArrayList<Chambre> arrayRoom) {
		
		Chambre room = null;
		temporaryListRoom.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			 room = arrayRoom.get(i);
			 
			if(room.isAvailable() == true) {
				if(room.isAccompanying() == true && room.getRoomNumber() < 200) {
					temporaryListRoom.add(room);
				}
			}
		}
		
		list.setListData(temporaryListRoom.toArray());
		
	}
	
	private static void selectRoomShorStayAlone(JList list,ArrayList<Chambre> arrayRoom) {
		
		Chambre room = null;
		temporaryListRoom.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			 room = arrayRoom.get(i);
			 
			 if(room.isAvailable() == true) {
				 if(room.isAlone() == true && room.getRoomNumber() > 200) {
					temporaryListRoom.add(room);
				}
			 }
		}
		
		list.setListData(temporaryListRoom.toArray());
		
	}
	
	private static void selectRoomLongStayAlone(JList list,ArrayList<Chambre> arrayRoom) {
		
		Chambre room = null;
		temporaryListRoom.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			 room = arrayRoom.get(i);
			 
			 if(room.isAvailable() == true) {
				if(room.isAlone() == true && room.getRoomNumber() < 200) {
					temporaryListRoom.add(room);
				}
			 }
		}
		
		list.setListData(temporaryListRoom.toArray());
	
	}
	
	private static void showInformationFromArrayExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberBookingRoomPanelField) {
		int idExamination = list.getSelectedIndex();
		
			if(idExamination == -1) 
				return;
		
		Examen examination = arrayExamination.get(idExamination);
		patientNumberBookingRoomPanelField.setText(""+examination.getPatient().getId());
	}
	
	private static void showInformationFromTemporaryListRoom(JList list,JTextField bedRoomNumberField,ArrayList<Chambre> arrayRoom) {
		int idRoom = list.getSelectedIndex();
		
			if(idRoom == -1) 
				return;
		if(temporaryListRoom.isEmpty()) {
			Chambre room = arrayRoom.get(idRoom);
			bedRoomNumberField.setText(""+room.getRoomNumber());
		}else {			
			Chambre room = temporaryListRoom.get(idRoom);
			bedRoomNumberField.setText(""+room.getRoomNumber());
		}
	}
	
	private static Chambre extractRoomFromArray(ArrayList<Chambre> arrayRoom, JTextField bedRoomNumberField) {
		
		int roomNumber = Integer.parseInt(bedRoomNumberField.getText());
		Chambre room = null;
		
		if(checkIfExist(arrayRoom, roomNumber) == true) {
			for(int i = 0; i < arrayRoom.size(); i++) {
				Chambre roomTest = arrayRoom.get(i);
				if(roomTest.getRoomNumber() == roomNumber) {
					room = roomTest;
					break;
				}
			}
		}
		return room;
	}
	
	private static boolean checkIfExist(ArrayList<Chambre> arrayRoom, int roomNumber ) {
		
		boolean exist = false;
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			Chambre room = arrayRoom.get(i);
			if (room.getRoomNumber() == roomNumber) {
				exist = true;
				break;
			}
		}
		
		return exist;
	}
	

	
	private static void noBookingRoom (JList list, Examen examination, Chambre room) {
		
		room.setExamination(examination);
		room.SetAvailble(true);
		room.setBookingRoom(false);
		list.setListData(temporaryListRoom.toArray());
	}
	
	private static void bookingRoom(JList list, Examen examination, Chambre room, JTextField entryDateField, JTextField releaseDateField) {
		room.setExamination(examination);
		room.SetAvailble(false);
		room.setBookingRoom(true);
		room.setEntryDate(entryDateField.getText());
		room.setReleaseDate(releaseDateField.getText());
		list.setListData(temporaryListRoom.toArray());
	}
	
	
	
	
	
	
	
}
