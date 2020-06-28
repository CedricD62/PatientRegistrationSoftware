package com.functions;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.objectsPackage.Chambre;
import com.objectsPackage.Examen;
import com.objectsPackage.Patient;
import com.toedter.calendar.JDateChooser;
import com.treatment.PatientControler; 

/**
 * <b>PatientFunction class contains all functions needed tp Patient Object</b>
 * </br>
 * This class contains 8 public functions and 11 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class PatientFunction 
{
	/**
	 * {@code ArrayList<Patient> temporaryList} stores patient object
	 */
	private static ArrayList<Patient> temporaryList = new ArrayList<Patient>();
	/**
	 * {@code ArrayList<Examen> arraySummaryExamination} stores Examen object
	 */
	private static ArrayList<Examen> arraySummaryExamination = new ArrayList<Examen>();
	/**
	 *  * {@code ArrayLis<Chambre>arraySummaryRoom } stores Chambre object
	 */
	private static ArrayList<Chambre>arraySummaryRoom = new ArrayList<Chambre>();
	
	/**
	 * <b>this function is used to create a Patient object</b>
	 * </br>
	 * before the creation of the Patient all the field are check
	 * Then those informations are used to instantiate a Patient
	 * The Patient stored in the arrayPatient are displayed in the JList
	 * Finally the fields are cleared automatically of the previous informations
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param maleRButton : store the gender of the patient
	 * @param femaleRButton : store the gender of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * @param button : store the selection result of gender JRadioButton with boolean type 
	 * @param examinationDateField : store the examination's date of the patient
	 * </br>
	 * <pre>
	 * @see PatientControler#inputFieldControler(JTextField,JRadioButton,JRadioButton,JTextField,JTextField,JTextField,JTextField,
	 * 											 JTextField,JTextField,JTextField,JTextField,JTextField,JDateChooser)
	 * </pre>
	 * @see ParseFunctions#numericConversion
	 * @see ParseFunctions#numericConversionLong
	 * @see ParseFunctions#dateFormating(JDateChooser)
	 * @see Patient #Patient(int, boolean, boolean, String, String, String, int, String, String, long, String, String, String, boolean)
	 * @see clearInformationField
	 */
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
			
			clearInformationField(idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
		}
	}
	
	/**
	 * <b>this function is used to change the informations of a patient</b>
	 * </br> 
	 *The function used is related to the state of the temporaryList
	 * 		if the temporaryList is empty changePatientArrayPatient() if put in action
	 * 		else changePatientTemporaryList() is used
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param maleRButton : store the gender of the patient
	 * @param femaleRButton : store the gender of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * </br>
	 * @see changePatientArrayPatient
	 * @see changePatientTemporaryList
	 */
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
	
	/**
	 * <b>this function is used to dispatch the information of a Patient object in the related fields</b>
	 * </br> 
	 * This function is related to the state of the temporaryList
	 * 		if the temporaryList is empty showPatientArrayPatient() if put in action
	 * 		else showPatientTemporaryList() is used
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param maleRButton : store the gender of the patient
	 * @param femaleRButton : store the gender of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param summaryExaminationList : display in a JList all the Examen whose have been registered for a patient 
	 * @param summaryBookingroomList : display in a JList all the informations related to the object Chambre for a patient 
	 * </br>
	 * @see showPatientArrayPatient
	 * @see showPatientTemporaryList
	 */
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
	
	/**
	 * <b>this function is used to delete a Patient</b>
	 * </br> 
	 * This function is related to the state of the temporaryList
	 * 		if the temporaryList is empty deleteFromArrayPatient() if put in action
	 * 		else deleteFromTemporaryList() is used
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param button : store the selection result of gender JRadioButton with boolean type 
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * </br>
	 * @see deleteFromArrayPatient
	 * @see deleteFromTemporaryList
	 */
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
	
	/**
	 * <b>this function is used to look for informations related to a Patient</b>
	 * </br>
	 * Three private functions are available, the function used is related to the information written by the user
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param text : field available for the user to search for informations related to Examen object 
	 * </br>
	 * @see serchPatientMale
	 * @see searchPatientFemale
	 * @see searchPatientOtherInfo
	 */
	public static void searchPatient(JList list,ArrayList<Patient> arrayPatient, String text) {
		
		if(text.contentEquals("homme")) {
			
			serchPatientMale(list,arrayPatient);
			
		}else if (text.contentEquals("femme")) {
			
			searchPatientFemale(list,arrayPatient);
			
		}else if(!text.contentEquals("homme") || text.contentEquals("femme")) {
			
			searchPatientOtherInfo(list,arrayPatient,text);
		}
	}
	
	/**
	 * <b>this function clears all the following parameters</b>
	 * </br>
	 * @param idField : store the id of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * @param button : store the selection result of gender JRadioButton with boolean type 
	 * </br>
	 * @see clearInformationField
	 */
	public static void cancelInformationBeforeAddPatient(JTextField idField,JTextField nameField, JTextField fNameField,
														 JTextField addressField, JTextField areaCodeField, JTextField townField,JTextField ssnField,JTextField eMailField, 
														 JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField,ButtonGroup button) {

		clearInformationField(idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
	}
	
	/**
	 * <b>This function is used look for all male Patient</b>
	 * </br>
	 * This function can only be of use through searchPatient() 
	 * Clearing the temporaryList is needed before each research
	 * All male Patient are stored in the temporaryList and their informations shown with JList 
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * </br>
	 * @see Patient#searchPatient
	 */
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
	
	/**
	 * <b>This function is used look for all female Patient</b>
	 * </br>
	 * This function can only be of use through searchPatient() 
	 * Clearing the temporaryList is needed before each research
	 * All female Patient are stored in the temporaryList and their informations shown with JList 
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * </br>
	 * @see Patient#searchPatient
	 */
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
	
	/**
	 * <b>This function is used look for any informations related to Patient except for gender</b>
	 * </br>
	 * This function can only be of use through searchPatient() 
	 * Clearing the temporaryList is needed before each research
	 * If the key wordk is found, all Patient that contains it are stored in the temporaryList and their informations shown with JList 
	 * If no results are found, arrayPatient is displayed by default and no changes occurs  
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param text : field available for the user to search for informations related to Examen object 
	 * </br>
	 * @see Patient#searchPatient
	 * @see searchPatientFemale
	 * @see serchPatientMale
	 */
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
			   ssn.contentEquals(text) || patient.getEmail().contentEquals(text)) {
						
					temporaryList.add(patient);
				}
		}
		if(temporaryList.isEmpty()) {
			list.setListData(arrayPatient.toArray());
		}else {
			list.setListData(temporaryList.toArray());
		}
	}

	/**
	 * <b>This function is used to dispatch in TextFields the informations related to a Patient from arrayPatient</b>
	 * </br> 
	 * This function can only be used through searchPatient() 
	 * If the result of the selected index equals -1 the isn't executed
	 * The Patient stored at the selected index is extracted from the arrayPatient
	 * The information are dispatched in the related fields
	 * Before quitting the function displaySummaryList() is run
	 * </br> 
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param maleRButton : store the gender of the patient
	 * @param femaleRButton : store the gender of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cell phone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param summaryExaminationList : display in a JList all the Examen whose have been registered for a patient 
	 * @param summaryBookingroomList : display in a JList all the informations related to the object Chambre for a patient 
	 * </br>
	 * @see ParseFunctions#dateFormating(String)
	 * @see displaySummaryList
	 */
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
			displaySummaryList(summaryExaminationList,summaryBookingroomList,patient,arrayExamination);
		}
	}
	
	/**
	 * <b>This function is used to dispatch in TextFields the informations related to a Patient from temporaryList</b>
	 * </br> 
	 * If the result of the selected index equals -1 the isn't executed
	 * The Patient stored at the selected index is extracted from the temporaryList
	 * The information are dispatched in the related fields
	 * Before quitting the function displaySummaryList() is run
	 * </br> 
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param maleRButton : store the gender of the patient
	 * @param femaleRButton : store the gender of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cell phone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param summaryExaminationList : display in a JList all the Examen whose have been registered for a patient 
	 * @param summaryBookingroomList : display in a JList all the informations related to the object Chambre for a patient 
	 * </br>
	 * @see ParseFunctions#dateFormating(String)
	 * @see displaySummaryList
	 */
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
			displaySummaryList(summaryExaminationList,summaryBookingroomList,patient,arrayExamination);
		}
	}
	
	/**
	 * <b>this function is used to change the informations of a Patient from arrayPatient</b>
	 * </br> 
	 * This function can only be used through changeInfoPatient() 
	 * If the result of the selected index equals -1 the function isn't executed
	 * The informations in the fields are checked
	 * Then the Patient stored at the selected index in the arrayPatient is extracted and it's values udpated
	 * Finally the updated arrayPatient is displayed in the JList
	 * </br> 
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param maleRButton : store the gender of the patient
	 * @param femaleRButton : store the gender of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cell phone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * </br>
	 * <pre>
	 * @see PatientControler#inputFieldControler(JTextField,JRadioButton,JRadioButton,JTextField,JTextField,JTextField,JTextField,
	 * 											 JTextField,JTextField,JTextField,JTextField,JTextField,JDateChooser)
	 * </pre>
	 * <pre>
	 * @see PatientFunction#changeInfoPatient(JList,ArrayList,JTextField,JRadioButton,JRadioButton,JTextField,JTextField,JTextField,JTextField,JTextField,JTextField,
	 * 										  JTextField,JTextField,JTextField,JDateChooser)
	 * </pre>
	 * @see ParseFunctions#numericConversion(String)
	 * @see ParseFunctions#numericConversionLong(String)
	 * @see ParseFunctions#dateFormating(String)
	 */
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
			patient.setMale(maleRButton.isSelected());
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
	
	/**
	 * <b>this function is used to change the informations of a Patient from temporaryList</b>
	 * </br> 
	 * This function can only be used through changeInfoPatient() 
	 * If the result of the selected index equals -1 the function isn't executed
	 * The informations in the fields are checked
	 * Then the Patient stored at the selected index in the temporaryList is extracted and it's values udpated
	 * The temporaryList is cleared after the changes have been processed 
	 * Finally the updated arrayPatient is displayed in the JList
	 * </br> 
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param maleRButton : store the gender of the patient
	 * @param femaleRButton : store the gender of the patient
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cell phone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * </br>
	 * <pre>
	 * @see PatientControler#inputFieldControler(JTextField,JRadioButton,JRadioButton,JTextField,JTextField,JTextField,JTextField,
	 * 											 JTextField,JTextField,JTextField,JTextField,JTextField,JDateChooser)
	 * </pre>
	 * <pre>
	 * @see PatientFunction#changeInfoPatient(JList,ArrayList,JTextField,JRadioButton,JRadioButton,JTextField,JTextField,JTextField,JTextField,JTextField,JTextField,
	 * 										  JTextField,JTextField,JTextField,JDateChooser)
	 * </pre>
	 * @see ParseFunctions#numericConversion(String)
	 * @see ParseFunctions#numericConversionLong(String)
	 * @see ParseFunctions#dateFormating(String)
	 */
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
			patient.setMale(maleRButton.isSelected());
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
	
	/**
	 * <b>this function is used to extract a Patient from arrayPatient with his id only</b>
	 * </br> 
	 * A loop is used to compare the id of the stored Patients in the arrayPatient with the id selected
	 * When the patient has been found the loop is broken and the Patient is returned
	 * </br> 
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param idP : is related to the id of a specific Patient
	 * </br>
	 * @return this function return a Patient
	 */
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
	
	/**
	 * <b>this function is used to check if a Patient exists in the arrayPatient</b>
	 * </br> 
	 * A loop is used to compare the id of the stored Patients in the arrayPatient with the id selected
	 * If the patient has been found the loop is broken
	 * Else all the Patients in the arrayPatient are checked, then the loop ends
	 * </br> 
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param idP : is related to the id of a specific Patient
	 * </br>
	 * @return this function return a boolean
	 */
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
	
	/**
	 * <b>this function is used to delete a Patient from arrayPatient</b>
	 * </br> 
	 * This function can only be used through deletePatient() 
	 * If the result of the selected index equals -1 the function isn't executed
	 * Then the Patient at the specific row of the arrayPatient is removed
	 * All the fields are cleared and arrayPatient updated is dispatch in the JList
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param button : store the selection result of gender JRadioButton with boolean type 
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * </br>
	 * <pre>
	 * @see PatientFunction#clearInformationField(JTextField, ButtonGroup, JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, 
	 * 											  JTextField, JTextField, JDateChooser)
	 * </pre>
	 * <pre>
	 * @see PatientFunction#deletePatient(JList, ArrayList, JTextField, ButtonGroup, JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, 
	 * 									  JTextField, JTextField, JTextField, JDateChooser)
	 * </pre>
	 */
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
	
	/**
	 * <b>this function is used to delete a Patient from temporaryList</b>
	 * </br> 
	 * This function can only be used through deletePatient() 
	 * If the result of the selected index equals -1 the function isn't executed
	 * Then the Patient at the specific row of the temporaryList is extracted
	 * With a loop the id of this Patient is compared with the one of the Patient stored in the arrayPatient
	 * If the Patient is found in the ArrayPatient it is remove and the loop is broken
	 * Then the Patient is removed from the temporaryList 
	 * All the fields are cleared and arrayPatient updated is dispatch in the JList
	 * </br>
	 * @param list : Graphic list component displaying the informations from  Patient objects existing in arrayPatient
	 * @param arrayPatient : used to store Patient object extracted from external file or created by the user 
	 * @param idField : store the id of the patient
	 * @param button : store the selection result of gender JRadioButton with boolean type 
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 * </br>
	 * <pre>
	 * @see PatientFunction#clearInformationField(JTextField, ButtonGroup, JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, 
	 * 											  JTextField, JTextField, JDateChooser)
	 * </pre>
	 * <pre>
	 * @see PatientFunction#deletePatient(JList, ArrayList, JTextField, ButtonGroup, JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, 
	 * 									  JTextField, JTextField, JTextField, JDateChooser)
	 * </pre>
	 */
	private static void deleteFromTemporaryList(JList list,ArrayList<Patient> arrayPatient, JTextField idField,ButtonGroup button, 
												JTextField nameField, JTextField fNameField,JTextField addressField, JTextField areaCodeField, JTextField townField, 
												JTextField ssnField,JTextField eMailField, JTextField phoneField, JTextField cellphoneField, JDateChooser birthdateField){
		
		int idPatient = list.getSelectedIndex();
			if(idPatient == -1)
				return;
			
		Patient patientTest = temporaryList.get(idPatient);
		
		for(int i = 0; i < arrayPatient.size(); i++) {
			Patient patientRemove = arrayPatient.get(i);
			if(patientTest.getId() == patientRemove.getId()) {
				arrayPatient.remove(i);
				break;
			}
		}
		
		temporaryList.remove(idPatient);
	
		clearInformationField(idField,button,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
		
		list.setListData(arrayPatient.toArray());
		temporaryList.clear();
	}
	
	/**
	 * <b>this function is update all the Examen and Chambre related to a specific Patient</b>
	 * </br> 
	 * the arraySummaryExamination and arraySummaryRoom have to be clear at the beginning of the function
	 * </br> 
	 * A loop is used to check all of the Examen in the arrayExamination
	 * We compare the Patient stored in the Object Examen with the one in the param of the function
	 * When the values are equals the Examen is stored in arraySummaryExamination 
	 * Then an Chambre Object extract the informations related to the Chambre stored in the Examen
	 * if this Object isn't null then it is stored in arraySummaryRoom
	 * </br> 
	 * This process is repeted as long as we haven't reach the end of arrayExamination
	 * </br> 
	 * Then the results are displayed in summaryExaminationList and summaryBookingroomList
	 * </br>
	 * @param summaryExaminationList : display in a JList all the Examen whose have been registered for a patient 
	 * @param summaryBookingroomList : display in a JList all the informations related to the object Chambre for a patient 
	 * @param patient : A specific Patient object 
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 */
	private static void displaySummaryList(JList summaryExaminationList, JList summaryBookingroomList,Patient patient,ArrayList<Examen> arrayExamination) {
		
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
	
	/**
	 * <b>this function is used to clear the fields related of a Patient information in the application</b>
	 * </br> 
	 * All the fields are cleared and no informations remains
	 * </br>
	 * @param idField : store the id of the patient
	 * @param button : store the selection result of gender JRadioButton with boolean type 
	 * @param nameField : store the name of the patient
	 * @param fNameField : store the first name of the patient
	 * @param addressField : store the address of the patient
	 * @param areaCodeField : store the area code of the patient
	 * @param townField : store the town name of the patient
	 * @param ssnField : store the social security number of the patient
	 * @param eMailField : store the email address of the patient
	 * @param phoneField : store the phone number of the patient
	 * @param cellphoneField : store the cellephone number of the patient
	 * @param birthdateField : store the birth date of the patient
	 */
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
