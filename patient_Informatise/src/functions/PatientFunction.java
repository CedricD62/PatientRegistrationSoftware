package functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class PatientFunction 
{
	
	private static ArrayList<Patient> temporaryList = new ArrayList<Patient>();
	private static ArrayList<Examen> arraySummaryExamination = new ArrayList<Examen>();
	private static ArrayList<Chambre>arraySummaryRoom = new ArrayList<Chambre>();
	
	public static Patient creatPatient(String id,boolean male,boolean female,String name,String fName,String address,String cp, 
									   String town,String ssn,String mail,String phone,String cellPhone,Date birthDate) {
		
		
		int idP 			= Integer.parseInt(id);
		int cpP 			= Integer.parseInt(cp);
		int ssnP 			= Integer.parseInt(ssn); 
		boolean bookingRoom = false;

		
		Patient patient = new Patient(idP, male, female, name, fName, address, cpP, town,mail, ssnP, phone, cellPhone, birthDate,bookingRoom);
		
		return patient;
	}
	
	public static void changeInfoPatient(JList list,ArrayList<Patient> arrayPatient,String id,boolean male,boolean female,String name,String fName,String address,String cp,
										String town,String ssn,String mail,String phone,String cellPhone,Date birthDate, JTextField text) {
		
		if(temporaryList.isEmpty()) {
			changePatientArrayPatient(list,arrayPatient,id,male,female,name,fName,address,cp,town,ssn,mail,phone,cellPhone,birthDate);
		}else {
			changePatientTemporaryList(list,arrayPatient,id,male,female,name,fName,address,cp,town,ssn,mail,phone,cellPhone,birthDate,text);
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
	
	public static void deletePatient(JList list,ArrayList<Patient> arrayPatient, int idPatient, JTextField idField,ButtonGroup button, 
									 JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
									 JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField) {

		if(temporaryList.isEmpty()) {
			deleteFromArrayPatient(list,arrayPatient,idPatient,idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,
								   cellphoneField,birthdateField);
		}else {
			deleteFromTemporaryList(list,arrayPatient,idPatient,idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,
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
		birthdateField.setDate(null);
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
			birthdateField.setDate(patient.getBirthDate());
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
			birthdateField.setDate(patient.getBirthDate());
			patientNumberExamPanelField.setText(""+patient.getId());
			
			if(!arrayExamination.isEmpty()) {
				displaySummaryExamination(summaryExaminationList,summaryBookingroomList,patient,arrayExamination);
			}
	}
	
	private static void changePatientArrayPatient (JList list,ArrayList<Patient> arrayPatient,String id,boolean male,boolean female,String name,String fName,String address,String cp,
												  String town,String ssn,String mail,String phone,String cellPhone,Date birthDate) {
		
		int idPatient = list.getSelectedIndex();
		
		if(idPatient == -1)
			return;
		
		Patient patient = arrayPatient.get(idPatient);
		
		patient.setId(Integer.parseInt(id));
		patient.setMasculin(male);
		patient.setFemale(female);
		patient.setName(name);
		patient.setFirstName(fName);
		patient.setAddress(address);
		patient.setCp(Integer.parseInt(cp));
		patient.setCity(town);
		patient.setSsn(Integer.parseInt(ssn));
		patient.setEmail(mail);
		patient.setPhone(phone);
		patient.setCellPhone(cellPhone);
		patient.setBirthDate(birthDate);
		
		list.setListData(arrayPatient.toArray());
		
	}
	
	private static void changePatientTemporaryList (JList list,ArrayList<Patient> arrayPatient,String id,boolean male,boolean female,String name,String fName,String address,String cp,
			  									  String town,String ssn,String mail,String phone,String cellPhone,Date birthDate,JTextField text) {

		int idPatient = list.getSelectedIndex();
		text.setText("");
		
		if(idPatient == -1)
			return;
		
		Patient patient = temporaryList.get(idPatient);
		
		patient.setId(Integer.parseInt(id));
		patient.setMasculin(male);
		patient.setFemale(female);
		patient.setName(name);
		patient.setFirstName(fName);
		patient.setAddress(address);
		patient.setCp(Integer.parseInt(cp));
		patient.setCity(town);
		patient.setSsn(Integer.parseInt(ssn));
		patient.setEmail(mail);
		patient.setPhone(phone);
		patient.setCellPhone(cellPhone);
		patient.setBirthDate(birthDate);
		
		temporaryList.clear();
		
		list.setListData(arrayPatient.toArray());
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
	
	private static void deleteFromArrayPatient(JList list,ArrayList<Patient> arrayPatient, int idPatient, JTextField idField,ButtonGroup button, 
			   								   JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
			   								   JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField)  {
		
		if(idPatient == -1)
			return;
		
		arrayPatient.remove(idPatient);
		
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
		birthdateField.setDate(null);
		
		list.setListData(arrayPatient.toArray());
		
	}
	
	private static void deleteFromTemporaryList(JList list,ArrayList<Patient> arrayPatient, int idPatient, JTextField idField,ButtonGroup button, 
												JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
												JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField)  {
		
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
		birthdateField.setDate(null);
		
		
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
	
	
	
}
