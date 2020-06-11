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
	public static ArrayList<Chambre> temporaryListNoBooking = new ArrayList<Chambre>(); 
	public static ArrayList<Examen> temporaryListExamination = new ArrayList<Examen>();
	
	public static void creatRoomIfFileIsEmpty(JList list,ArrayList<Chambre>arrayRoom) {
	
		Chambre room;
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
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,availble,numberOfBed,bookingRoom);
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
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,availble,numberOfBed,bookingRoom);
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
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,availble,numberOfBed,bookingRoom);
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
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,availble,numberOfBed,bookingRoom);
				arrayRoom.add(room);
			}
			cpt++;	
		}	
		list.setListData(arrayRoom.toArray());
	}
	
	public static void updateListOfAvailableRoom(JList list,ArrayList<Chambre> arrayRoom,JTextField patientNumberBookingRoomPanelField, JRadioButton withoutRoomRButton, JRadioButton withAccompangyingRButton, 
										   JRadioButton withoutAccompangyingRButton, JComboBox LengthOfStaySelectionBox) {
		Examen examination = null;
		
		int ligneNumber = list.getSelectedIndex();
		
			if(ligneNumber == -1)
				return ;
		
		if(withoutRoomRButton.isSelected()) {
			examination = temporaryListExamination.get(ligneNumber);	
			examination.setBookingRoom(true);
		}
		
		examination = temporaryListExamination.get(ligneNumber);
		examination.setBookingRoom(true);
		
		filterRoomWithSelection(list, arrayRoom, LengthOfStaySelectionBox, withAccompangyingRButton, withAccompangyingRButton);
	}
	
	public static void bookingAvailableRoom(JList list,JTextField entryDateField,JTextField releaseDateField, JRadioButton withoutRoomRButton, ArrayList<Examen> arrayExamination,JTextField patientNumberBookingRoomPanelField,
											JRadioButton withRoomRButton,ButtonGroup accompanyingGroup,JComboBox LengthOfStaySelectionBox,JTextField bedRoomNumberField, ArrayList<Chambre> arrayRoom) {
		Chambre room = null;
		
		Examen examination = extractExaminationFromList(list);
		if(withoutRoomRButton.isSelected() == false) {
			room = extractRoomFromArray(list);
		}
		
		updateRoomInformation(list, examination, room, entryDateField, releaseDateField, withoutRoomRButton);
		updadeExaminationListForBooking(list, arrayExamination);
		clearInformationOnPannel(patientNumberBookingRoomPanelField, withRoomRButton, accompanyingGroup, LengthOfStaySelectionBox, entryDateField, releaseDateField, bedRoomNumberField);
		printExamination(arrayExamination);
		printRoom(arrayRoom);
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
	
	private static void updateRoomInformation(JList list, Examen examination, Chambre room, JTextField entryDateField, JTextField releaseDateField,
			  JRadioButton withoutRoomRButton) {

		if(withoutRoomRButton.isSelected() == true) {
			noBookingRoom(list, examination, room);
		}else {
			bookingRoom(examination, room, entryDateField, releaseDateField);
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
		
		Examen examination = temporaryListExamination.get(idExamination);
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
	
	private static Examen extractExaminationFromList (JList list) {
		Examen examination = null;
		
		for(int i = 0; i < temporaryListExamination.size(); i++) {
			examination = temporaryListExamination.get(i);
				if(examination.isBookingRoom() == true) {
					break;
				}
			}
	
		return examination;
	}
	
	private static Chambre extractRoomFromArray(JList list) {
		
		Chambre room = null;

		int ligneNumber = list.getSelectedIndex();
			if(ligneNumber == -1)
				return room;
		
		room = temporaryListRoom.get(ligneNumber);
		
		return room;
	}
	
	
	private static void noBookingRoom (JList list, Examen examination, Chambre room) {
		
		examination.setBookingRoom(true);
		room = new Chambre("", "", 0, false, false, false, 0, false, examination);
	}
	
	
	private static void bookingRoom(Examen examination, Chambre room, JTextField entryDateField, JTextField releaseDateField) {
		room.setEntryDate(entryDateField.getText());
		room.setReleaseDate(releaseDateField.getText());
		room.setExamination(examination);
		room.SetAvailble(false);
	}

	private static void updadeExaminationListForBooking(JList list,ArrayList<Examen> arrayExamination) {
		
		Examen examination = null;
		temporaryListExamination.clear();
		for(int i = 0; i < arrayExamination.size(); i++) {
			examination = arrayExamination.get(i);
				if(examination.isBookingRoom() != true) {
					temporaryListExamination.add(examination);
				}
		}
		
		list.setListData(temporaryListExamination.toArray());
	}
	
	private static void clearInformationOnPannel(JTextField patientNumberBookingRoomPanelField,JRadioButton withRoomRButton,ButtonGroup accompanyingGroup,JComboBox LengthOfStaySelectionBox, 
												 JTextField entryDateField, JTextField releaseDateField,JTextField bedRoomNumberField) {
		patientNumberBookingRoomPanelField.setText("");
		withRoomRButton.setSelected(true);
		accompanyingGroup.clearSelection();
		bedRoomNumberField.setText("");
		entryDateField.setText("");
		releaseDateField.setText("");
	}
	
	public static void printRoom(ArrayList<Chambre> arrayRoom) {
		Chambre room = null;
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			room = arrayRoom.get(i);
				if(room.getExamination() != null) {
					System.out.println(room.toString());
				}
		}
	}
	
	public static void printExamination(ArrayList<Examen> arrayExamination) {
		Examen examination = null;
		
		for(int i = 0; i < arrayExamination.size(); i++) {
			examination = arrayExamination.get(i);
				if(examination.isBookingRoom() == true) {
					System.out.println(examination.toString());
				}
		}
	}
	
	
}
