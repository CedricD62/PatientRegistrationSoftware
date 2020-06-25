package functions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JList;

import com.toedter.calendar.JDateChooser;

import filesActions.ReadExternalFiles;
import objectsPackage.Chambre;
import objectsPackage.Examen;
import objectsPackage.Patient;

public class DefaultValueLuncher {
	
	public static void defaultValuesStartSoftware(JDateChooser birthdateField,JList patientList,JList examinationList, JList switchRoomAndExaminationList,
												  ArrayList<Examen>arrayExamination,ArrayList<Patient>arrayPatient,ArrayList<Chambre>arrayRoom,
												  JDateChooser examinationDateField,JList listOfBookedRoom) {
		
		setDefaultRangeForBirthdate(birthdateField);
		setDefaultRangeExaminationDate(examinationDateField);
		ReadExternalFiles.dispatchInfoFromFiles(patientList,examinationList,switchRoomAndExaminationList,arrayExamination,arrayPatient,arrayRoom,listOfBookedRoom);
		setRoomInExamination();
		RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
	}
	
	private static void setDefaultRangeForBirthdate(JDateChooser birthdateField) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -110);
		
		Date dateMin = cal.getTime();
		Date dateMax = new Date();
		birthdateField.setSelectableDateRange(dateMin,dateMax);
	}
	
	private static void setDefaultRangeExaminationDate(JDateChooser examinationDateField) {	
		
		examinationDateField.setMinSelectableDate(new Date());
	}
	
	public static void setDefaultRangeForBookingRoomDate(JDateChooser entryDateField,JDateChooser releaseDateField,Examen examination) {
		
		Date examinationDate = ParseFunctions.dateFormating(examination.getDateExamen());
		Date dateMin = new Date();
		entryDateField.setSelectableDateRange(dateMin,examinationDate);
		releaseDateField.setMinSelectableDate(examinationDate);
	}
	
	private static void setRoomInExamination() {
		
		for(int i = 0; i < RoomFunction.bookedRoomList.size(); i++) {
			Chambre room = RoomFunction.bookedRoomList.get(i);
				Examen examination = room.getExamination();
				examination.setChambre(room);
				examination.setBookingRoom(true);
			}
	}
		
	
	
}
