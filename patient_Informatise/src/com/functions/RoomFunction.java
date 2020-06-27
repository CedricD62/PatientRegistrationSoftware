package com.functions;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.filesActions.WriteInExternalFiles;
import com.objectsPackage.Chambre;
import com.objectsPackage.Examen;
import com.objectsPackage.Patient;
import com.toedter.calendar.JDateChooser;
import com.treatment.ExaminationControler;
import com.treatment.RoomControler;

/**
 * <b>RoomFunction class contains all functions needed to Chambre Object</b>
 * </br>
 * This class contains 9 public functions and 20 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class RoomFunction 
{
	/**
	 * {@code ArrayList<Chambre> temporaryListRoom} stores Chambre object after filters have been used
	 */
	public static ArrayList<Chambre> temporaryListRoom 			= new ArrayList<Chambre>();
	/**
	 * {@code ArrayList<Chambre> temporaryListNoBooking} stores Chambre object with no bookingRoom
	 */
	public static ArrayList<Chambre> temporaryListNoBooking		= new ArrayList<Chambre>(); 
	/**
	 * {@code ArrayList<Chambre> bookedRoomList} stores Chambre object for which a room has been booked
	 */
	public static ArrayList<Chambre> bookedRoomList 			= new ArrayList<Chambre>(); 
	/**
	 * {@code ArrayList<Chambre> temporaryListExamination} stores Examen to display in JList switchRoomAndExaminationList
	 */
	public static ArrayList<Examen> temporaryListExamination 	= new ArrayList<Examen>();
	
	/**
	 * This function is needed when the Application is started for the first time
	 * It creates Chambre objects whose are stored in arrayRoom
	 * Then those Chambre Objects are saved in a txt file
	 * </br>
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * </br>
	 * @see Chambre#Chambre(String, String, int, boolean, boolean, boolean, int, boolean)
	 * @see WriteInExternalFiles#writeRoomFile(ArrayList)
	 */
	public static void creatRoomIfFileIsEmpty(ArrayList<Chambre>arrayRoom) {
	
		Chambre room;
		int cpt = 0;
		
		for(int i = 0; i < 42; i++) {
			
			if(cpt == 21) 
				cpt = 0;
			
			if(i < 15) {
	
				boolean accompanying	= false;
				boolean alone 			= true;
				boolean available 		= true;
				boolean bookingRoom 	= true;
				String entryDate		= "";
				String releaseDate		= "";
				int numberOfBed 		= 1;
				int roomNumber 			= 100 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else if (i >= 15 && i <= 20) {
				
				boolean accompanying 	= true;
				boolean alone 			= false;
				boolean available 		= true;
				boolean bookingRoom 	= true;
				String entryDate		= "";
				String releaseDate		= "";
				int numberOfBed 		= 2;
				int roomNumber 			= 100 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else if (i >= 21 && i <= 35 ) {
				
				boolean accompanying 	= false;
				boolean alone 			= true;
				boolean available 		= true;
				boolean bookingRoom 	= true;
				String entryDate		= "";
				String releaseDate		= "";
				int numberOfBed 		= 1; 
				int roomNumber 			= 200 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
				arrayRoom.add(room);
				
			}else {

				boolean accompanying 	= true;
				boolean alone 			= false;
				boolean available 		= true;
				boolean bookingRoom 	= true;
				String entryDate		= "";
				String releaseDate		= "";
				int numberOfBed 		= 2;
				int roomNumber 			= 200 + cpt;
				
				room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
				arrayRoom.add(room);
			}
			cpt++;	
		}	
		WriteInExternalFiles.writeRoomFile(arrayRoom);
	}
	
	/**
	 * <b>this function is used to select the Chambre Object available from the choices of the user</b>
	 * </br>
	 * before the selection of the Chambre is done all the field are check
	 * If the result of the selected index equals -1 the isn't executed
	 * If withoutRoomRButton is selected, the Examination is updated and the function ends
	 * Else the other fields are checked , the Examination is updated
	 * The default range for the entry and realese date are updated
	 * Finally filterRoomWithSelection() is used 
	 * </br>
	 * @param list ; switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * @param withRoomRButton : Radio Button if selected return true
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param withAccompangyingRButton : Radio Button if selected return true
	 * @param withoutAccompangyingRButton : Radio Button if selected return true
	 * @param LengthOfStaySelectionBox : several values are available for the user to select 
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * </br>
	 * @see RoomControler#inputFieldControlerBookingRoomRButton(JRadioButton, JRadioButton, JTextField)
	 * @see RoomControler#inputFieldControlerBeforeRoomSelection(JRadioButton, JRadioButton, JRadioButton, JRadioButton, JComboBox)
	 * @see DefaultValueLuncher#setDefaultRangeForBookingRoomDate(JDateChooser, JDateChooser, Examen)
	 * @see RoomFunction#filterRoomWithSelection(JList, ArrayList, JComboBox, JRadioButton, JRadioButton)
	 */
	public static void updateListOfAvailableRoom(JList list,ArrayList<Chambre> arrayRoom,JTextField patientNumberBookingRoomPanelField,JRadioButton withRoomRButton,JRadioButton withoutRoomRButton, JRadioButton withAccompangyingRButton, 
										   JRadioButton withoutAccompangyingRButton, JComboBox LengthOfStaySelectionBox,JDateChooser entryDateField, 
											 JDateChooser releaseDateField) {
		if(RoomControler.inputFieldControlerBookingRoomRButton(withoutRoomRButton,withRoomRButton,patientNumberBookingRoomPanelField) == true) {
			Examen examination = null;
			
			int ligneNumber = list.getSelectedIndex();
			
				if(ligneNumber == -1)
					return ;
				if(withoutRoomRButton.isSelected()) {
					examination = temporaryListExamination.get(ligneNumber);	
					examination.setBookingRoom(true);
				}else {				
					if(RoomControler.inputFieldControlerBeforeRoomSelection(withoutRoomRButton, withRoomRButton, withAccompangyingRButton, withoutAccompangyingRButton, LengthOfStaySelectionBox) == true) {
						
						examination = temporaryListExamination.get(ligneNumber);
						examination.setBookingRoom(true);
						DefaultValueLuncher.setDefaultRangeForBookingRoomDate(entryDateField,releaseDateField,examination);
						filterRoomWithSelection(list, arrayRoom, LengthOfStaySelectionBox, withAccompangyingRButton, withAccompangyingRButton);
					}
				}
			}
	}

	public static void bookingAvailableRoom(JList list,JDateChooser entryDateField,JDateChooser releaseDateField, JRadioButton withoutRoomRButton, ArrayList<Examen> arrayExamination,JTextField patientNumberBookingRoomPanelField,
											JRadioButton withRoomRButton,ButtonGroup accompanyingGroup,JComboBox LengthOfStaySelectionBox,JTextField bedRoomNumberField, ArrayList<Chambre> arrayRoom, JList bookedRoomList,
											ButtonGroup bookingGroup,JRadioButton withAccompangyingRButton,JRadioButton withoutAccompangyingRButton) {
		Chambre room = null;
		
		Examen examination = extractExaminationFromList(list);
		if(withoutRoomRButton.isSelected() == false) {
			room = extractRoomFromArray(list);
		}
		if(RoomControler.inputFieldControlerGlobalCheckUp(withoutRoomRButton,withRoomRButton,patientNumberBookingRoomPanelField,withAccompangyingRButton,withoutAccompangyingRButton,LengthOfStaySelectionBox,
														  entryDateField,releaseDateField,bedRoomNumberField) == true) {	
			if(RoomControler.inputFieldControlerBeforeRoomBooking(entryDateField, releaseDateField, bedRoomNumberField)== true) {
				
				updateRoomInformation(list, examination, room, entryDateField, releaseDateField, withoutRoomRButton);
				updadeExaminationListForBooking(list, arrayExamination);
				clearInformationOnPannel(patientNumberBookingRoomPanelField, accompanyingGroup, LengthOfStaySelectionBox, entryDateField, releaseDateField, bedRoomNumberField,bookingGroup);
				printRoomInList(bookedRoomList,arrayRoom);
				temporaryListRoom.clear();
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
	
	public static void cancelDataBeforeBookingRoom(JList list,JTextField patientNumberBookingRoomPanelField,ButtonGroup accompanyingGroup,ButtonGroup bookingGroup, JComboBox lengthOfStayTypeSelection,
												   JTextField bedRoomNumberField,JDateChooser entryDateField,JDateChooser releaseDateField) {
	
		patientNumberBookingRoomPanelField.setText("");
		accompanyingGroup.clearSelection();
		accompanyingGroup.clearSelection();
		lengthOfStayTypeSelection.setSelectedIndex(0);
		bedRoomNumberField.setText("");
		entryDateField.setDate(new Date());
		releaseDateField.setDate(new Date());
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
		deleteDataFromExamination(room);
		resetRoomDataToDefault(room);
		updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
		printRoomInList(bookedList, room);
	}
	
	private static void updateRoomInformation(JList list, Examen examination, Chambre room, JDateChooser entryDateField, JDateChooser releaseDateField,
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
			if(selection == 1) {
				selectRoomShorStaytAccompanying(list,arrayRoom);
			}else{
				selectRoomLongStaytAccompanying(list,arrayRoom);
			}
		}else{
			if(selection == 1) {
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
		room = new Chambre(null, null, 0, false, false, false, 0, false, examination);
		examination.setChambre(room);
	}
	
	private static void bookingRoom(Examen examination, Chambre room, JDateChooser entryDateField, JDateChooser releaseDateField) {
		room.setEntryDate(ParseFunctions.dateFormating(entryDateField.getDate()));
		room.setReleaseDate(ParseFunctions.dateFormating(releaseDateField.getDate()));
		room.setExamination(examination);
		room.SetAvailable(false);
		examination.setChambre(room);
		examination.setBookingRoom(true);
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
	
	private static void clearInformationOnPannel(JTextField patientNumberBookingRoomPanelField,ButtonGroup accompanyingGroup,JComboBox LengthOfStaySelectionBox, 
												 JDateChooser entryDateField, JDateChooser releaseDateField,JTextField bedRoomNumberField,ButtonGroup bookingGroup) {
		patientNumberBookingRoomPanelField.setText("");
		bookingGroup.clearSelection();
		accompanyingGroup.clearSelection();
		bedRoomNumberField.setText("");
		entryDateField.setDate(new Date());
		releaseDateField.setDate(new Date());
		LengthOfStaySelectionBox.setSelectedIndex(0);
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
		
		for(int i = 0; i < bookedRoomList.size(); i++) {
			
			if(room.equals(bookedRoomList.get(i))) {
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
	
	private static void deleteDataFromExamination(Chambre room) {
		
		Examen examination = room.getExamination();
		examination.setBookingRoom(false);
		examination.setChambre(null);
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
