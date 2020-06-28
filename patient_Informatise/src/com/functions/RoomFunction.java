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
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
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
	
	/**
	 * <b>this function is used to instantiate a Chambre Object from the choices of the user</b>
	 * </br>
	 * First The extractExaminationFromList is used and an Examen is created
	 * If withoutRoomRButton is not selected, the extractRoomFromArray is used and a Chambre is identified
	 * Then all the field are checked 
	 * Several functions are used to update the several List and Array before updating the values of the selected Chambre and Examen
	 * temporaryListRoom must be cleared before quitting the function
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * @param withRoomRButton : Radio Button if selected return true
	 * @param accompanyingGroup : store the selection result of a JRadioButton group with boolean type 
	 * @param LengthOfStaySelectionBox : several values are available for the user to select 
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * @param bookedRoomList : Graphic list componant displaying the informations from the booked Chambre object
	 * @param bookingGroup : store the selection result of a JRadioButton group with boolean type 
	 * @param withAccompangyingRButton : Radio Button if selected return true
	 * @param withoutAccompangyingRButton : Radio Button if selected return true
	 * </br>
	 * @see RoomFunction#extractExaminationFromList(JList)
	 * @see RoomFunction#extractRoomFromArray(JList)
	 * @see RoomControler#inputFieldControlerGlobalCheckUp(JRadioButton,JRadioButton,JTextField,JRadioButton,JRadioButton,JComboBox,JDateChooser,JDateChooser,JTextField)
	 * @see RoomControler#inputFieldControlerBeforeRoomBooking(JDateChooser, JDateChooser, JTextField)
	 * @see RoomFunction#updateRoomInformation(JList, Examen, Chambre, JDateChooser, JDateChooser, JRadioButton)
	 * @see RoomFunction#updadeExaminationListForBooking(JList, ArrayList)
	 * @see RoomFunction#clearInformationOnPannel(JTextField, ButtonGroup, JComboBox, JDateChooser, JDateChooser, JTextField, ButtonGroup)
	 * @see RoomFunction#printRoomInList(JList, ArrayList)
	 */
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
			
	/**
	 * <b>this function is used to dispatch the information of a Chambre object in the related fields</b>
	 * </br> 
	 *The function used is related to the state of the temporaryListRoom
	 * 		if the temporaryListRoom is empty showInformationFromArrayExamination() if put in action
	 * 		else showInformationFromTemporaryListRoom() is used
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * </br>
	 * @see RoomFunction#showInformationFromArrayExamination(JList, ArrayList, JTextField)
	 * @see RoomFunction#showInformationFromTemporaryListRoom(JList, JTextField, ArrayList)
	 */
	public static void showInformationRoomAndExamination(JList list,ArrayList<Chambre> arrayRoom,ArrayList<Examen> arrayExamination,JTextField patientNumberBookingRoomPanelField,
														 JTextField bedRoomNumberField) {
		if(temporaryListRoom.isEmpty()) {
			showInformationFromArrayExamination(list,arrayExamination,patientNumberBookingRoomPanelField);
		}else {
			showInformationFromTemporaryListRoom(list, bedRoomNumberField, arrayRoom);
		}
	}
	
	/**
	 * <b>this function is used to clear the fields related of a Chambre information in the application</b>
	 * </br> 
	 * All the fields are cleared and no informations remains
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * @param accompanyingGroup : store the selection result of a JRadioButton group with boolean type 
	 * @param bookingGroup : store the selection result of a JRadioButton group with boolean type 
	 * @param lengthOfStayTypeSelection : several values are available for the user to select 
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 */
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
	
	/**
	 * <b>this function is used to delete the booking of a Chambre Object</b>
	 * </br>
	 * If the result of the selected index equals -1 the function isn't executed
	 * Else a Chambre Object is instantiate with the informations stores in the bookedRoomList at the specific index
	 * Several functions are used to reset all the informations related to the Examen and the Chambre objects
	 * </br> 
	 * @param switchRoomAndExaminationList : switch between temporaryListExamination informations and temporaryListRoom
	 * @param bookedList : Graphic list componant displaying the informations from the booked Chambre object
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * </br>
	 * @see RoomFunction#deleteDataFromExamination(Chambre)
	 * @see RoomFunction#resetRoomDataToDefault(Chambre)
	 * @see RoomFunction#updadeExaminationListForBooking(JList, ArrayList)
	 * @see RoomFunction#printRoomInList(JList, Chambre)
	 */
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
	
	/**
	 * <b>this function is used to update the information of a Chambre object</b>
	 * </br> 
	 *The function used is related to the state of the withoutRoomRButton
	 * 		if the withoutRoomRButton is selected noBookingRoom() is put in action
	 * 		else bookingRoom() is used
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param examination : a specific Examen Object
	 * @param room : a specific Chambre Object
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * @param withoutRoomRButton : Radio Button if selected return true
	 * </br>
	 * @see RoomFunction#noBookingRoom(JList, Examen, Chambre)
	 * @see RoomFunction#bookingRoom(Examen, Chambre, JDateChooser, JDateChooser)
	 */
	private static void updateRoomInformation(JList list, Examen examination, Chambre room, JDateChooser entryDateField, JDateChooser releaseDateField,
			  JRadioButton withoutRoomRButton) {

		if(withoutRoomRButton.isSelected() == true) {
			noBookingRoom(list, examination, room);
		}else {
			bookingRoom(examination, room, entryDateField, releaseDateField);
		}
	}
	
	/**
	 * <b>this function is used to filter the available Chambre object with the informations selected by the user</b>
	 * </br> 
	 *The function used is related to the state of the withAccompangyingRButton and LengthOfStaySelectionBox
	 * 		If withAccompangyingRButton and the first index of LengthOfStaySelectionBox are selected selectRoomShorStaytAccompanying() is put in action
	 * 		Else if withAccompangyingRButton and the Second index of LengthOfStaySelectionBox are selected selectRoomLongStaytAccompanying() is put in action
	 * 		Else if withoutAccompanyingRButton and the first index of LengthOfStaySelectionBox are selected selectRoomShorStayAlone() is put in action
	 * 		Else if withoutAccompanyingRButton and the Second index of LengthOfStaySelectionBox are selected selectRoomLongStayAlone() is put in action
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * @param LengthOfStaySelectionBox : several values are available for the user to select 
	 * @param withAccompangyingRButton : Radio Button if selected return true
	 * @param withoutAccompangyingRButton : Radio Button if selected return true
	 * </br>
	 * @see RoomFunction#selectRoomShorStaytAccompanying(JList, ArrayList)
	 * @see RoomFunction#selectRoomLongStaytAccompanying(JList, ArrayList)
	 * @see RoomFunction#selectRoomShorStayAlone(JList, ArrayList)
	 * @see RoomFunction#selectRoomLongStayAlone(JList, ArrayList)
	 */
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
	
	/**
	 * <b>this function is used to reduce the number of available Chambre with the choices of the user</b>
	 * </br> 
	 * This function can only be used through filterRoomWithSelection()
	 * TemporaryListRoom must be cleared at the beginning of this function
	 * In a loop all the available Chambre objects are checked
	 * All Chambre Object matching the choices of the user are add to TemporaryListRoom
	 * Then they are shown through the JList
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * </br>
	 * @see RoomFunction#filterRoomWithSelection(JList, ArrayList, JComboBox, JRadioButton, JRadioButton)
	 */
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
	
	/**
	 * <b>this function is used to reduce the number of available Chambre with the choices of the user</b>
	 * </br> 
	 * This function can only be used through filterRoomWithSelection()
	 * TemporaryListRoom must be cleared at the beginning of this function
	 * In a loop all the available Chambre objects are checked
	 * All Chambre Object matching the choices of the user are add to TemporaryListRoom
	 * Then they are shown through the JList
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * </br>
	 * @see RoomFunction#filterRoomWithSelection(JList, ArrayList, JComboBox, JRadioButton, JRadioButton)
	 */
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
	
	/**
	 * <b>this function is used to reduce the number of available Chambre with the choices of the user</b>
	 * </br> 
	 * This function can only be used through filterRoomWithSelection()
	 * TemporaryListRoom must be cleared at the beginning of this function
	 * In a loop all the available Chambre objects are checked
	 * All Chambre Object matching the choices of the user are add to TemporaryListRoom
	 * Then they are shown through the JList
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * </br>
	 * @see RoomFunction#filterRoomWithSelection(JList, ArrayList, JComboBox, JRadioButton, JRadioButton)
	 */
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
	
	/**
	 * <b>this function is used to reduce the number of available Chambre with the choices of the user</b>
	 * </br> 
	 * This function can only be used through filterRoomWithSelection()
	 * TemporaryListRoom must be cleared at the beginning of this function
	 * In a loop all the available Chambre objects are checked
	 * All Chambre Object matching the choices of the user are add to TemporaryListRoom
	 * Then they are shown through the JList
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * </br>
	 * @see RoomFunction#filterRoomWithSelection(JList, ArrayList, JComboBox, JRadioButton, JRadioButton)
	 */
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
	
	/**
	 * <b>this function is used to dispatch the information of an Examen from arrayExamination in the related fields</b>
	 * </br> 
	 * This function can only be used through showInformationRoomAndExamination()
	 * If the result of the selected index equals -1 the function isn't executed
	 * Then the Examen is extracted from the temporaryListExamination and the id of the Patient Object is displayed in the specific field
	 * </br> 
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * </br>
	 * @see RoomFunction#showInformationRoomAndExamination(JList, ArrayList, ArrayList, JTextField, JTextField)
	 */
	private static void showInformationFromArrayExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberBookingRoomPanelField) {
		
		int idExamination = list.getSelectedIndex();
		
			if(idExamination == -1) 
				return;
		
		Examen examination = temporaryListExamination.get(idExamination);
		patientNumberBookingRoomPanelField.setText(""+examination.getPatient().getId());
	}
	
	/**
	 * <b>this function is used to dispatch the information of a Chambre object in the related fields</b>
	 * </br> 
	 * This function can only be used through showInformationRoomAndExamination()
	 * If the result of the selected index equals -1 the function isn't executed
	 * Then if temporaryListRoom is empty the Chambre is extracted from the arrayRoom and the room number is displayed in the specific field
	 * Else the Chambre is extracted from the temporaryListRoom and the room number is displayed in the specific field
	 * </br> 
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 * </br>
	 * @see RoomFunction#showInformationRoomAndExamination(JList, ArrayList, ArrayList, JTextField, JTextField)
	 */
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
	
	/**
	 * <b>this function is used to extract an Examen from temporaryListExamination</b>
	 * </br>
	 * A loop is used to check for each Examen the status of the boolean isBookingRoom (parameter of Examen)
	 * The loop is broken avec the first occurence of the boolean with a true value
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * </br>
	 * @see Examen#isBookingRoom()
	 * </br> 
	 * @return an Examen Object
	 */
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
	
	/**
	 * <b>this function is used to extract a Chambre from temporaryListRoom</b>
	 * </br>
	 * If the result of the selected index equals -1 the function isn't executed
	 * The Chambre is extracted from the temporaryListRoom 
	 * </br>
	 * @param  list : switch between temporaryListExamination informations and temporaryListRoom
	 * </br> 
	 * @return a Chambre Object
	 */
	private static Chambre extractRoomFromArray(JList list) {
		
		Chambre room = null;

		int ligneNumber = list.getSelectedIndex();
			if(ligneNumber == -1)
				return room;
		
		room = temporaryListRoom.get(ligneNumber);
		return room;
	}
	
	/**
	 * <b>this function is used to update the information of a Chambre and Examen object</b>
	 * </br> 
	 * This function can only be used through updateRoomInformation
	 * The Parameter bookingRoom of the specific Examen is updated
	 * A Chambre object is instantiate with specific values
	 * The Examen update its Chambre parameter Object with those new informations
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param examination : a specific Examen Object
	 * @param room : a specific Chambre Object
	 * </br>
	 * @see RoomFunction#updateRoomInformation(JList, Examen, Chambre, JDateChooser, JDateChooser, JRadioButton)
	 */
	private static void noBookingRoom (JList list, Examen examination, Chambre room) {
		
		examination.setBookingRoom(true);
		room = new Chambre(null, null, 0, false, false, false, 0, false, examination);
		examination.setChambre(room);
	}
	
	/**
	 * <b>this function is used to update the information of a Chambre and Examen object</b>
	 * </br> 
	 * This function can only be used through updateRoomInformation
	 * The values writen by the user are registered in the specific Chambre Object
	 * The values of the Examen object related to this booking are updated
	 * </br>
	 * @param examination : a specific Examen Object
	 * @param room : a specific Chambre Object
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * </br>
	 * @see RoomFunction#updateRoomInformation(JList, Examen, Chambre, JDateChooser, JDateChooser, JRadioButton)
	 * @see ParseFunctions#dateFormating(JDateChooser)
	 */
	private static void bookingRoom(Examen examination, Chambre room, JDateChooser entryDateField, JDateChooser releaseDateField) {
		room.setEntryDate(ParseFunctions.dateFormating(entryDateField.getDate()));
		room.setReleaseDate(ParseFunctions.dateFormating(releaseDateField.getDate()));
		room.setExamination(examination);
		room.SetAvailable(false);
		examination.setChambre(room);
		examination.setBookingRoom(true);
	}

	/**
	 * <b>this function is used to update the temporaryListExamination</b>
	 * </br> 
	 * At the beginning of this function the temporaryListExamination must be cleared
	 * A loop is used to check all the Examen Object stored in arrayExamination
	 * If the parameter booking of the Examen is put to false
	 * Then Examen is add to the temporaryListExamination
	 * Finally the temporaryListExamination updated is shown through the JList
	 * </br>
	 * @param list : switch between temporaryListExamination informations and temporaryListRoom
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 */
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
	
	/**
	 * <b>this function is used to clear the fields related of a Chambre information in the application</b>
	 * </br> 
	 * All the fields are cleared and no informations remains
	 * </br>
	 * @param patientNumberBookingRoomPanelField : store the id of the Patient for whom the Examen has been registered
	 * @param accompanyingGroup : store the selection result of a JRadioButton group with boolean type 
	 * @param LengthOfStaySelectionBox : several values are available for the user to select 
	 * @param entryDateField : the user can choose the entry date from a pre determined range 
	 * @param releaseDateField : the minimum available release date is set to be the current date
	 * @param bedRoomNumberField : store the number allocated for a specific room
	 * @param bookingGroup : store the selection result of a JRadioButton group with boolean type 
	 */
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
	
	/**
	 * <b>this function is used to show only the booked Chambre information in the specific JList</b>
	 * </br> 
	 * At the beginning of this function the bookedRoomList must be cleared
	 * A loop is used to check all the Chambre Object stored in arrayRoom
	 * If the parameter examination of the Chambre is not null
	 * The Chambre is store in bookedRoomList
	 * Finally the Chambre stored in bookedRoomList are shown through the JList 
	 * </br>
	 * @param list : Graphic list componant displaying the informations from the booked Chambre object
	 * @param arrayRoom : used to store the Chambre object extracted from external file or updated by the user 
	 */
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
	
	/**
	 * <b>this function is used to remove the booked Chambre from bookedRoomList</b>
	 * </br> 
	 * A loop is used to check all the Chambre Object stored in arrayRoom
	 * When the specific Chambre object is found, it is removed from the bookedRoomList
	 * Finally the bookedRoomList updated is shown through the JList 
	 * </br>
	 * @param list : Graphic list componant displaying the informations from the booked Chambre object
	 * @param room : a specific Chambre Object selected by the user
	 */
	public static void printRoomInList(JList list, Chambre room) {
		
		for(int i = 0; i < bookedRoomList.size(); i++) {
			
			if(room.equals(bookedRoomList.get(i))) {
				bookedRoomList.remove(i);
			}
		}
		
		list.setListData(bookedRoomList.toArray());
	}
	
	/**
	 * <b>This function is used to reset to default the values of a specific Chambre object</b>
	 * </br>
	 * One of the following funtions is used if it matches the parameters of the Chambre object
	 * </br>
	 * @param room : a specific Chambre Object selected by the user
	 * </br>
	 * @see RoomFunction#defaultDataShorStaytAccompanying(Chambre)
	 * @see RoomFunction#defaultDataLongStaytAccompanying(Chambre)
	 * @see RoomFunction#defaultDataShorStayAlone(Chambre)
	 * @see RoomFunction#defaultDataLongStayAlone(Chambre)
	 */
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
	
	/**
	 * <b>This function is used to reset to default the values of a specific Chambre object</b>
	 * </br>
	 * This function can only be used through resetRoomDataToDefault
	 * </br>
	 * @param room : a specific Chambre Object selected by the user
	 * </br>
	 * @see RoomFunction#resetRoomDataToDefault(Chambre)
	 */
	private static void defaultDataShorStaytAccompanying(Chambre room) {
		room.setAccompanying(true);
		room.setAlone(false);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	/**
	 * <b>This function is used to reset to default the values of a specific Chambre object</b>
	 * </br>
	 * This function can only be used through resetRoomDataToDefault
	 * </br>
	 * @param room : a specific Chambre Object selected by the user
	 * </br>
	 * @see RoomFunction#resetRoomDataToDefault(Chambre)
	 */
	private static void defaultDataLongStaytAccompanying(Chambre room) {	
		room.setAccompanying(true);
		room.setAlone(false);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	/**
	 * <b>This function is used to reset to default the values of a specific Chambre object</b>
	 * </br>
	 * This function can only be used through resetRoomDataToDefault
	 * </br>
	 * @param room : a specific Chambre Object selected by the user
	 * </br>
	 * @see RoomFunction#resetRoomDataToDefault(Chambre)
	 */
	private static void defaultDataShorStayAlone(Chambre room) {
		room.setAccompanying(false);
		room.setAlone(true);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	/**
	 * <b>This function is used to reset to default the values of a specific Chambre object</b>
	 * </br>
	 * This function can only be used through resetRoomDataToDefault
	 * </br>
	 * @param room : a specific Chambre Object selected by the user
	 * </br>
	 * @see RoomFunction#resetRoomDataToDefault(Chambre)
	 */
	private static void defaultDataLongStayAlone(Chambre room) {
		room.setAccompanying(false);
		room.setAlone(true);
		room.SetAvailable(true);
		room.setBookingRoom(true);
		room.setEntryDate("");
		room.setReleaseDate("");
		room.setExamination(null);
	}
	
	/**
	 * <b>This function is used to reset to default the values of a specific Examen object</b>
	 * </br>
	 * @param room : a specific Chambre Object selected by the user
	 * </br>
	 * @see RoomFunction#deleteBookedRoom(JList, JList, ArrayList, ArrayList)
	 */
	private static void deleteDataFromExamination(Chambre room) {
		
		Examen examination = room.getExamination();
		examination.setBookingRoom(false);
		examination.setChambre(null);
	}
	/**
	 * <b>This function is used to reset to default the values of a specific Examen object</b>
	 * A loop is used to check the parameter of each Examen object stored in temporaryListExamination
	 * If the Examen is found its bookingRoom value is update to false and the loop is broken
	  */
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
