package com.functions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JList;

import com.filesActions.ReadExternalFiles;
import com.objectsPackage.Chambre;
import com.objectsPackage.Examen;
import com.objectsPackage.Patient;
import com.toedter.calendar.JDateChooser;

/**
 * 
 * <b>DefaultValueLuncher class contains all the functions needed to be running when the application is lunched</b>
 * </br>
 * This class contains 2 public function and 3 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class DefaultValueLuncher {
	
	/**
	 * <b>this function is used to dispatch informations extracted from files and to set to default the Date field</b>
	 * </br>
	 * @param birthdateField : Graphic componant input text field, the user can change the value of this field 
	 * @param patientList : Graphic list componant displaying the informations from the patient objects existing in arrayPatient
	 * @param examinationList : Graphic list componant displaying the informations from the Examen objects existing in arrayExamination
	 * @param switchRoomAndExaminationList : Graphic list componant  switching display informations between Examen objects and Chambre object
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param arrayRoom : used to keep the Chambre object extracted from external file 
	 * @param examinationDateField : Graphic componant input text field, the user can change the value of this field 
	 * @param listOfBookedRoom : Graphic list componant displaying the informations from the booked Chambre object extracted from external file or booked by the user
	 * </br>
	 * @see setDefaultRangeForBirthdate
	 * @see setDefaultRangeExaminationDate
	 * @see ReadExternalFiles#dispatchInfoFromFiles(JList, JList, JList, ArrayList, ArrayList, ArrayList, JList)
	 * @see setRoomInExamination
	 * @see RoomFunction#updadeExaminationListForBooking(JList, ArrayList)
	 */
	public static void defaultValuesStartSoftware(JDateChooser birthdateField,JList patientList,JList examinationList, JList switchRoomAndExaminationList,
												  ArrayList<Examen>arrayExamination,ArrayList<Patient>arrayPatient,ArrayList<Chambre>arrayRoom,
												  JDateChooser examinationDateField,JList listOfBookedRoom) {
		
		setDefaultRangeForBirthdate(birthdateField);
		setDefaultRangeExaminationDate(examinationDateField);
		ReadExternalFiles.dispatchInfoFromFiles(patientList,examinationList,switchRoomAndExaminationList,arrayExamination,arrayPatient,arrayRoom,listOfBookedRoom);
		setRoomInExamination();
		RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
	}
	
	/**
	 * <b>This function is used to set an available range for the patient's birthdate </b>
	 * </br>
	 * the range is automatically updated with a fixed value at 110 in the past since today 
	 * it forbids the user can't select a futur date as a birthdate
	 * </br>
	 * @param birthdateField : Graphic componant input text field, the user can change the value of this field 
	 */
	private static void setDefaultRangeForBirthdate(JDateChooser birthdateField) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -110);
		
		Date dateMin = cal.getTime();
		Date dateMax = new Date();
		birthdateField.setSelectableDateRange(dateMin,dateMax);
	}
	
	/**
	 * <b>This function is used to set an available range for the Examen's date </b>
	 * </br>
	 * The minimum selectable date for the registration of an Examen is fixed at today
	 * it forbids the user to select a past date for the registration of an examination
	 * </br>
	 * @param examinationDateField : Graphic componant input text field, the user can change the value of this field 
	 */
	private static void setDefaultRangeExaminationDate(JDateChooser examinationDateField) {	
		
		examinationDateField.setMinSelectableDate(new Date());
	}
	
	/**
	 * <b>This function is used to set an available range for the Chambre's entry and release date </b>
	 * </br>
	 * The minimum selectable entryDate for booking a room is put at today and it's maximum selectable entryDate is fixed at the examinationDate
	 * it constrains the user to select a date in a certain available range
	 * The minimum selectable releaseDate is set ad the examinationDate and has no further limits
	 * </br>
	 * @param entryDateField : Graphic componant input text field, the user can change the value of this field 
	 * @param releaseDateField : Graphic componant input text field, the user can change the value of this field 
	 * @param examination : Examen Object extracted from arrayExamination and used in RoomFunction
	 * </br>
	 * @see ParseFunctions#dateFormating
	 */
	public static void setDefaultRangeForBookingRoomDate(JDateChooser entryDateField,JDateChooser releaseDateField,Examen examination) {
		
		Date examinationDate = ParseFunctions.dateFormating(examination.getDateExamen());
		Date dateMin = new Date();
		entryDateField.setSelectableDateRange(dateMin,examinationDate);
		releaseDateField.setMinSelectableDate(examinationDate);
	}
	
	/**
	 * <b>This function is used to set the Chambre object in the Examen object </b>
	 * </br>
	 * It is only used after the extraction of Examen from external file because the room selection status in unkonwn at that moment
	 * 
	 * @see ReadExternalFiles#readExaminationFile
	 */
	private static void setRoomInExamination() {
		
		for(int i = 0; i < RoomFunction.bookedRoomList.size(); i++) {
			Chambre room = RoomFunction.bookedRoomList.get(i);
				Examen examination = room.getExamination();
				examination.setChambre(room);
				examination.setBookingRoom(true);
			}
	}
		
	
	
}
