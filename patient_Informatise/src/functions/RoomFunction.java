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

public class RoomFunction 
{
	
	public static ArrayList<Chambre> temporaryListRoom = new ArrayList<Chambre>();
	public static ArrayList<Chambre> temporaryListNoBooking = new ArrayList<Chambre>(); 
	public static ArrayList<Chambre> bookedRoomList = new ArrayList<Chambre>(); 
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
				boolean available = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 1;
				int roomNumber = 100 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else if (i >= 15 && i <= 20) {
				
				boolean accompanying = true;
				boolean alone = false;
				boolean available = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 2;
				int roomNumber = 100 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else if (i >= 21 && i <= 35 ) {
				
				boolean accompanying = false;
				boolean alone = true;
				boolean available = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 1;
				int roomNumber = 200 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else {

				boolean accompanying = true;
				boolean alone = false;
				boolean available = true;
				boolean bookingRoom = true;
				String entryDate ="";
				String releaseDate ="";
				int numberOfBed = 2;
				int roomNumber = 200 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
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
											JRadioButton withRoomRButton,ButtonGroup accompanyingGroup,JComboBox LengthOfStaySelectionBox,JTextField bedRoomNumberField, ArrayList<Chambre> arrayRoom, JList bookedRoomList) {
		Chambre room = null;
		
		Examen examination = extractExaminationFromList(list);
		if(withoutRoomRButton.isSelected() == false) {
			room = extractRoomFromArray(list);
		}
		
		updateRoomInformation(list, examination, room, entryDateField, releaseDateField, withoutRoomRButton);
		updadeExaminationListForBooking(list, arrayExamination);
		clearInformationOnPannel(patientNumberBookingRoomPanelField, withRoomRButton, accompanyingGroup, LengthOfStaySelectionBox, entryDateField, releaseDateField, bedRoomNumberField);
		printRoomInList(bookedRoomList,arrayRoom);
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
	
	public static void cancelDataBeforeBookingRoom(JList list,JTextField patientNumberBookingRoomPanelField,ButtonGroup accompanyingGroup,ButtonGroup bookingGroup, JComboBox lengthOfStayTypeSelection,
												   JTextField bedRoomNumberField,JTextField entryDateField,JTextField releaseDateField) {
	
		patientNumberBookingRoomPanelField.setText("");
		accompanyingGroup.clearSelection();
		accompanyingGroup.clearSelection();
		lengthOfStayTypeSelection.setSelectedIndex(-1);
		bedRoomNumberField.setText("");
		entryDateField.setText("");
		releaseDateField.setText("");
		temporaryListRoom.clear();
		deleteDataFromExamination();
		list.setListData(temporaryListExamination.toArray());
	}
	
	public static void deleteBookedRoom(JList switchRoomAndExaminationList, JList bookedList,ArrayList<Examen> arrayExamination,ArrayList<Chambre> arrayRoom ) {
		
		int ligneNumbre = bookedList.getSelectedIndex();
		if(ligneNumbre == -1) {
			return ;
		}
		
		Chambre room = bookedRoomList.get(ligneNumbre);
		resetRoomDataToDefault(room);
		deleteDataFromExamination(room, arrayExamination);
		updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
		printRoomInList(bookedList, room);
		
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
		examination.setChambre(room);
	}
	
	private static void bookingRoom(Examen examination, Chambre room, JTextField entryDateField, JTextField releaseDateField) {
		room.setEntryDate(entryDateField.getText());
		room.setReleaseDate(releaseDateField.getText());
		room.setExamination(examination);
		room.SetAvailable(false);
		examination.setChambre(room);
		
	}

	public static void updadeExaminationListForBooking(JList list,ArrayList<Examen> arrayExamination) {
		
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
	
	private static void printRoomInList(JList list,ArrayList<Chambre> arrayRoom) {
		Chambre room = null;
		
		bookedRoomList.clear();
		
		for(int i = 0; i < arrayRoom.size(); i++) {
			room = arrayRoom.get(i);
			if(room.getExamination() != null) {
				bookedRoomList.add(room);
			}
		}
		
		list.setListData(bookedRoomList.toArray());
	}
	
	public static void printRoomInList(JList list, Chambre room) {
		Chambre roomTest = null;
		
		//bookedRoomList.clear();
		
		for(int i = 0; i < bookedRoomList.size(); i++) {
			roomTest = bookedRoomList.get(i);
			if(roomTest.equals(room)) {
				bookedRoomList.remove(i);
			}
		}
		
		list.setListData(bookedRoomList.toArray());
	}
	
	public static void resetRoomDataToDefault(Chambre room) {
		
		if(room.isAccompanying() == true && room.getRoomNumber() > 200) {
			defaultDataShorStaytAccompanying(room);
			
		}else if(room.isAccompanying() == true && room.getRoomNumber() < 200) {
			defaultDataLongStaytAccompanying(room);
			
		}else if(room.isAlone() == true && room.getRoomNumber() > 200) {
			defaultDataShorStayAlone(room);
			
		}else if(room.isAlone() == true && room.getRoomNumber() < 200) {
			defaultDataLongStayAlone(room);
		}
	}
	
	private static void defaultDataShorStaytAccompanying(Chambre room) {
		room.setAccompanying(true);
		room.setAlone(false);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	private static void defaultDataLongStaytAccompanying(Chambre room) {	
		room.setAccompanying(true);
		room.setAlone(false);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	private static void defaultDataShorStayAlone(Chambre room) {
		room.setAccompanying(false);
		room.setAlone(true);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	private static void defaultDataLongStayAlone(Chambre room) {
		room.setAccompanying(false);
		room.setAlone(true);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	private static void deleteDataFromExamination(Chambre room, ArrayList<Examen> arrayExamination) {
		
		Examen examination = null;
		resetRoomDataToDefault(room);
		
		for(int i = 0; i < arrayExamination.size(); i++) {
			examination = arrayExamination.get(i);
			if(examination.getChambre().getRoomNumber() == room.getRoomNumber()) {
				examination.setBookingRoom(false);
				room = examination.getChambre();
				examination.setChambre(null);
				break;
			}
		}
	}
	
	private static void deleteDataFromExamination() {
			
		Examen examination = null;
		
		for(int i = 0; i < temporaryListExamination.size(); i++) {
			examination = temporaryListExamination.get(i);
			if(examination.isBookingRoom() == true && examination.getChambre() == null) {
				examination.setBookingRoom(false);
				break;
			}
		}
	}
	
}
