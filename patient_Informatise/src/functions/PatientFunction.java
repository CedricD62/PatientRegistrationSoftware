package functions;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import patient_Informatise.Chambre;
import patient_Informatise.Examen;
import patient_Informatise.Patient;
import treatment.PatientControler; 

public class PatientFunction 
{
	private static ArrayList<Patient> temporaryList = new ArrayList<Patient>();
	private static ArrayList<Examen> arraySummaryExamination = new ArrayList<Examen>();
	private static ArrayList<Chambre>arraySummaryRoom = new ArrayList<Chambre>();
	
	public static void creatPatient(JList list,ArrayList<Patient> arrayPatient,JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton, 
									JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
									JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField,ButtonGroup button,
									JDateChooser examinationDateField) {
		
		if(PatientControler.inputFieldControler(idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,
												phoneField,cellphoneField,birthdateField) == true) {
			
			int id  			= ParseFunctions.numericConversion(idField.getText());
			boolean male 		= maleRButton.isSelected();
			boolean female 		= femaleRButton.isSelected();
			String name 		= nameField.getText();
			String fName 		= fNameField.getText();
			String address		= addressField.getText();
			int cp  			= ParseFunctions.numericConversion(areaCodeField.getText());
			String town			= townField.getText();
			String mail 		= eMailField.getText(); 
			long ssn  			= ParseFunctions.numericConversionLong(ssnField.getText());
			String phone		= phoneField.getText();
			String cellPhone	= cellphoneField.getText();
			String birthdate 	= ParseFunctions.dateFormating(birthdateField);
			boolean bookingRoom = false;
			
			Patient patient = new Patient(id,male,female,name,fName,address,cp,town,mail,ssn,phone,cellPhone,birthdate,bookingRoom);
			arrayPatient.add(patient);
			list.setListData(arrayPatient.toArray());
			
			DefaultValueLuncher.setDefaultRangeExaminationDate(patient, examinationDateField);
			clearInformationField(idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
		}
	}
	
	public static void changeInfoPatient(JList list,ArrayList<Patient> arrayPatient,JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton, 
			   							 JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
			   							 JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField) {
		
		if(temporaryList.isEmpty()) {
			changePatientArrayPatient(list,arrayPatient,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,
									  ssnField,eMailField,phoneField,cellphoneField,birthdateField);
		}else {
			changePatientTemporaryList(list,arrayPatient,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,
					  				   ssnField,eMailField,phoneField,cellphoneField,birthdateField);
		}
	}
	
	public static void showPatient(JList list,ArrayList<Patient> arrayPatient,ArrayList<Examen> arrayExamination, JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton, 
								   JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
								   JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField,
								   JTextField patientNumberExamPanelField,JList summaryExaminationList, JList summaryBookingroomList) {
		
		if(temporaryList.isEmpty()) {
			showPatientArrayPatient(list,arrayPatient,arrayExamination,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,ssnField,
									eMailField,phoneField,cellphoneField,birthdateField,patientNumberExamPanelField,summaryExaminationList, summaryBookingroomList);
		}else {
			showPatientTemporaryList(list,arrayExamination,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,
									 phoneField,cellphoneField,birthdateField,patientNumberExamPanelField, summaryExaminationList, summaryBookingroomList);
		}
	}
	
	public static void deletePatient(JList list,ArrayList<Patient> arrayPatient, JTextField idField,ButtonGroup button, 
									 JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
									 JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField) {

		if(temporaryList.isEmpty()) {
			deleteFromArrayPatient(list,arrayPatient,idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,
								   cellphoneField,birthdateField);
		}else {
			deleteFromTemporaryList(list,arrayPatient,idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,
									cellphoneField,birthdateField);
		}
	}
	
	public static void searchPatient(JList list,ArrayList<Patient> arrayPatient, String text) {
		
		if(text.contentEquals("homme")) {
			
			serchPatientMale(list,arrayPatient);
			
		}else if (text.contentEquals("femme")) {
			
			searchPatientFemale(list,arrayPatient);
			
		}else if(!text.contentEquals("homme") || text.contentEquals("femme")) {
			
			searchPatientOtherInfo(list,arrayPatient,text);
		}
	}
	
	public static void cancelInformationBeforeAddPatient(JTextField idField,JTextField nameField, JTextField fNameField,
														 JTextField addressField, JTextField areaCodeField, JTextField townField,JTextField ssnField,JTextField eMailField, 
														 JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField,ButtonGroup button) {

		clearInformationField(idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
	}
	
	private static void serchPatientMale(JList list,ArrayList<Patient> arrayPatient) {

		Patient patient;
		temporaryList.clear();
		
		for(int index = 0;index < arrayPatient.size(); index++){
			patient = arrayPatient.get(index);
		
			if(patient.isMale() == true) {
				
				temporaryList.add(patient);
			}
		}
		
		list.setListData(temporaryList.toArray());
	}
	
	private static void searchPatientFemale(JList list,ArrayList<Patient> arrayPatient) {	
	
		Patient patient;
		temporaryList.clear();
		
		for(int index = 0;index < arrayPatient.size(); index++){
			patient = arrayPatient.get(index);
		
			if(patient.isFemale() == true) {
				
				temporaryList.add(patient);
			}
		}
		
		list.setListData(temporaryList.toArray());
	}
	
	private static void searchPatientOtherInfo(JList list,ArrayList<Patient> arrayPatient, String text) {
	
		Patient patient;
		temporaryList.clear();
		
		for(int index = 0;index < arrayPatient.size(); index++){
			patient = arrayPatient.get(index);
			
			String aeraCode =""+ patient.getCp();
			String ssn = ""+patient.getSsn();
			String idPatient = ""+patient.getId();
			
			if(idPatient.contentEquals(text) || patient.getName().contentEquals(text) || patient.getFirstName().contentEquals(text) || patient.getAddress().contentEquals(text) || 
			   aeraCode.contentEquals(text)  || patient.getCity().contentEquals(text) || patient.getPhone().contentEquals(text) || patient.getCellPhone().contentEquals(text) || 
			   ssn.contentEquals(text) || patient.getEmail().contentEquals(text) /*|| patient.getBirthDate().contentEquals(text)*/) {
						
					temporaryList.add(patient);
				}
		}
		if(temporaryList.isEmpty()) {
			list.setListData(arrayPatient.toArray());
		}else {
			list.setListData(temporaryList.toArray());
		}
	}

	private static void showPatientArrayPatient(JList list,ArrayList<Patient> arrayPatient,ArrayList<Examen> arrayExamination,JTextField idField,JRadioButton maleRButton,JRadioButton femaleRButton, 
												JTextField nameField,JTextField fNameField,JTextField addressField,JTextField areaCodeField,JTextField townField, 
												JTextField ssnField,JTextField eMailField,JTextField phoneField,JTextField cellphoneField,JDateChooser birthdateField,
												JTextField patientNumberExamPanelField,JList summaryExaminationList, JList summaryBookingroomList) {
									
		int ligneNumber = list.getSelectedIndex();
		
		if(ligneNumber == -1)
			return;
		
		Patient patient = arrayPatient.get(ligneNumber);
				
			idField.setText(""+patient.getId());
			maleRButton.setSelected(patient.isMale());
			femaleRButton.setSelected(patient.isFemale());
			nameField.setText(patient.getName());
			fNameField.setText(patient.getFirstName());
			addressField.setText(patient.getAddress());
			areaCodeField.setText(""+patient.getCp());
			townField.setText(patient.getCity());
			ssnField.setText(""+patient.getSsn());
			eMailField.setText(patient.getEmail());
			phoneField.setText(""+patient.getPhone());
			cellphoneField.setText(""+patient.getCellPhone());
			birthdateField.setDate(ParseFunctions.dateFormating(patient.getBirthDate()));
			patientNumberExamPanelField.setText(""+patient.getId());
			
		if(!arrayExamination.isEmpty()) {
			displaySummaryExamination(summaryExaminationList,summaryBookingroomList,patient,arrayExamination);
		}
	}
	
	private static void showPatientTemporaryList(JList list,ArrayList<Examen> arrayExamination, JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton, 
												 JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
												 JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField,
												 JTextField patientNumberExamPanelField,JList summaryExaminationList, JList summaryBookingroomList) {
		
		int ligneNumber = list.getSelectedIndex();
		
		if(ligneNumber == -1)
			return;
		
		Patient patient = temporaryList.get(ligneNumber);
		
			idField.setText(""+patient.getId());
			maleRButton.setSelected(patient.isMale());
			femaleRButton.setSelected(patient.isFemale());
			nameField.setText(patient.getName());
			fNameField.setText(patient.getFirstName());
			addressField.setText(patient.getAddress());
			areaCodeField.setText(""+patient.getCp());
			townField.setText(patient.getCity());
			ssnField.setText(""+patient.getSsn());
			eMailField.setText(patient.getEmail());
			phoneField.setText(""+patient.getPhone());
			cellphoneField.setText(""+patient.getCellPhone());
			birthdateField.setDate(ParseFunctions.dateFormating(patient.getBirthDate()));
			patientNumberExamPanelField.setText(""+patient.getId());
			
		if(!arrayExamination.isEmpty()) {
			displaySummaryExamination(summaryExaminationList,summaryBookingroomList,patient,arrayExamination);
		}
	}
	
	private static void changePatientArrayPatient (JList list,ArrayList<Patient> arrayPatient,JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton, 
												   JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
												   JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField) {
		
		int idPatient = list.getSelectedIndex();
		
		if(idPatient == -1)
			return;
		
		if(PatientControler.inputFieldControler(idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,
				phoneField,cellphoneField,birthdateField) == true) {
				
			Patient patient = arrayPatient.get(idPatient);
			
			patient.setId(ParseFunctions.numericConversion(idField.getText()));
			patient.setMasculin(maleRButton.isSelected());
			patient.setFemale(femaleRButton.isSelected());
			patient.setName(nameField.getText());
			patient.setFirstName(fNameField.getText());
			patient.setAddress(addressField.getText());
			patient.setCp(ParseFunctions.numericConversion(areaCodeField.getText()));
			patient.setCity(townField.getText());
			patient.setSsn(ParseFunctions.numericConversionLong(ssnField.getText()));
			patient.setEmail(eMailField.getText());
			patient.setPhone(phoneField.getText());
			patient.setCellPhone(cellphoneField.getText());
			patient.setBirthDate(ParseFunctions.dateFormating(birthdateField));
			
			list.setListData(arrayPatient.toArray());
		}
	}
	
	private static void changePatientTemporaryList (JList list,ArrayList<Patient> arrayPatient,JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton, 
			   										JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
			   										JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField) {
		int idPatient = list.getSelectedIndex();
		if(idPatient == -1)
			return;
		
		if(PatientControler.inputFieldControler(idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,
				phoneField,cellphoneField,birthdateField) == true) {
			
			Patient patient = temporaryList.get(idPatient);
			
			patient.setId(ParseFunctions.numericConversion(idField.getText()));
			patient.setMasculin(maleRButton.isSelected());
			patient.setFemale(femaleRButton.isSelected());
			patient.setName(nameField.getText());
			patient.setFirstName(fNameField.getText());
			patient.setAddress(addressField.getText());
			patient.setCp(ParseFunctions.numericConversion(areaCodeField.getText()));
			patient.setCity(townField.getText());
			patient.setSsn(ParseFunctions.numericConversionLong(ssnField.getText()));
			patient.setEmail(eMailField.getText());
			patient.setPhone(phoneField.getText());
			patient.setCellPhone(cellphoneField.getText());
			patient.setBirthDate(ParseFunctions.dateFormating(birthdateField));
			
			temporaryList.clear();
			
			list.setListData(arrayPatient.toArray());
		}
	}
	
	public static Patient extractPatientFromArray (ArrayList<Patient> arrayPatient,int idP) {
		
		Patient patient = null;
		
		if(checkIfExist(arrayPatient, idP) == true) {
			for(int i = 0; i < arrayPatient.size(); i++) {
				Patient patientTest = arrayPatient.get(i);
				if(patientTest.getId() == idP) { 
					patient= patientTest;
					break;
				}
			}
		}
			
		return patient;
	}
	
	public static boolean checkIfExist(ArrayList<Patient> arrayPatient,int id) {
		boolean exist  = false;
		
		for(int i = 0; i < arrayPatient.size(); i++) {
			Patient patient = arrayPatient.get(i);
			if (patient.getId() == id) {
				exist = true;
				break;
			}
		}
		
		return exist;
	}
	
	private static void deleteFromArrayPatient(JList list,ArrayList<Patient> arrayPatient, JTextField idField,ButtonGroup button, 
			   								   JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
			   								   JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField)  {
		
		int idPatient = list.getSelectedIndex();
			if(idPatient == -1)
				return;
		
		arrayPatient.remove(idPatient);
		
		clearInformationField(idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
		
		list.setListData(arrayPatient.toArray());
	}
	
	private static void deleteFromTemporaryList(JList list,ArrayList<Patient> arrayPatient, JTextField idField,ButtonGroup button, 
												JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
												JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField)  {
		
		int idPatient = list.getSelectedIndex();
			if(idPatient == -1)
				return;
		
		Patient patientTest = temporaryList.get(idPatient);
		
		for(int i = 0; i < arrayPatient.size(); i++) {
			Patient patient = arrayPatient.get(i);
			if(patientTest.getId() == patient.getId()) {
				arrayPatient.remove(i);
				break;
			}
		}
		
		temporaryList.remove(idPatient);
		
		clearInformationField(idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
		
		list.setListData(arrayPatient.toArray());
		temporaryList.clear();
	}
	
	private static void displaySummaryExamination(JList summaryExaminationList, JList summaryBookingroomList,Patient patient,ArrayList<Examen> arrayExamination) {
		
		Examen examination = null;
		arraySummaryExamination.clear();
		arraySummaryRoom.clear();
		
		for(int i = 0; i < arrayExamination.size(); i++) {
			examination = arrayExamination.get(i);
			if(examination.getPatient().equals(patient)) {
				arraySummaryExamination.add(examination);
				Chambre room = examination.getChambre();
				if(room != null){
					arraySummaryRoom.add(room);
				}
			}
		}
		summaryExaminationList.setListData(arraySummaryExamination.toArray());
		summaryBookingroomList.setListData(arraySummaryRoom.toArray());
	}
	
	private static void clearInformationField(JTextField idField,ButtonGroup button,JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, 
											  JTextField townField,JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField) {
		idField.setText("");
		button.clearSelection();
		nameField.setText("");
		fNameField.setText("");
		addressField.setText("");
		areaCodeField.setText("");
		townField.setText("");
		ssnField.setText("");
		eMailField.setText("");
		phoneField.setText("");
		cellphoneField.setText("");
		birthdateField.setDate(new Date());
		
	}
}
