package functions;

import java.util.Calendar;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

import objectsPackage.Examen;
import objectsPackage.Patient;

	public class DefaultValueLuncher {
		
		public static void setDefaultRangeForBirthdate(JDateChooser birthdateField) {
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -110);
			
			Date dateMin = cal.getTime();
			Date dateMax = new Date();
			birthdateField.setSelectableDateRange(dateMin,dateMax);
		}
		
		public static void setDefaultRangeExaminationDate(Patient patient,JDateChooser examinationDateField) {	
			
			Date dateMin = ParseFunctions.dateFormating(patient.getBirthDate());
			examinationDateField.setMinSelectableDate(dateMin);
		}
		
		public static void setDefaultRangeForBookingRoomDate(JDateChooser entryDateField,JDateChooser releaseDateField,Examen examination) {
			
			Date examinationDate = ParseFunctions.dateFormating(examination.getDateExamen());
			Date dateMin = new Date();
			entryDateField.setSelectableDateRange(dateMin,examinationDate);
			releaseDateField.setMinSelectableDate(examinationDate);
		}
	}
