package com.functions;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;

import com.objectsPackage.Chambre;
import com.objectsPackage.Examen;
import com.objectsPackage.Patient;
import com.toedter.calendar.JDateChooser;
import com.treatment.ExaminationControler;

/**
 * <b>ExaminationFunction class contains all functions needed tp Examen Object</b>
 * </br>
 * This class contains 9 public functions and 6 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class ExaminationFunction 
{
	/**
	 * {@code ArrayList<Examen> temporaryList is used for temporary extraction and display of Examination informations }
	 */
	private static ArrayList<Examen> temporaryList = new ArrayList<Examen>();
	
	/**
	 * <b>this function is used to create an Examen object</b>
	 * </br>
	 * before the creation of the Examen all the field are check
	 * then the Patient for whom this Examen is instantiate is extract from the arrayPatient
	 * The examination's informations are displayed in the JList 
	 * Finally the fields are cleared automatically of the previous informations
	 * </br>
	 * @param listExaminationPanel : Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param switchRoomAndExaminationList : Graphic list component  switching display informations between Examen objects and Chambre object
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination  
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * </br>
	 * @see ExaminationControler#inputFieldControler
	 * @see PatientFunction#extractPatientFromArray
	 * @see ExaminationControler#inputFieldControler(JComboBox, JDateChooser)
	 * @see ParseFunctions#dateFormating
	 * @see Examen#Examen(Patient, Chambre, String, String)
	 * @see cancelInformationBeforeAddExamination
	 */
	public static void creatExamination (JList listExaminationPanel,JList switchRoomAndExaminationList,ArrayList<Patient> arrayPatient,ArrayList<Examen> arrayExamination,
										 JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,JDateChooser examinationDateField){
		if(ExaminationControler.inputFieldControler(patientNumberExamPanelField,examinationTypeSelection, examinationDateField) == true) {
			int id = ParseFunctions.numericConversion(patientNumberExamPanelField.getText());
			Patient patient = PatientFunction.extractPatientFromArray(arrayPatient,id);
			String examinationType="";
			String examinationDate;
			
			if(patient == null) {
			
				patientNumberExamPanelField.setText("Patient introuvable");
				
			}else {
				if(ExaminationControler.inputFieldControler(examinationTypeSelection, examinationDateField) == true) {
					
					examinationType = examinationTypeSelection.getSelectedItem().toString();
					examinationDate = ParseFunctions.dateFormating(examinationDateField);
					Chambre room = null;
					Examen examination = new Examen(patient,room,examinationType,examinationDate);
					arrayExamination.add(examination);
					RoomFunction.temporaryListExamination.add(examination);
					
					listExaminationPanel.setListData(arrayExamination.toArray());
					switchRoomAndExaminationList.setListData(RoomFunction.temporaryListExamination.toArray());
						
					cancelInformationBeforeAddExamination(examinationDateField, patientNumberExamPanelField, examinationTypeSelection);
				}
			}
		}
	}
	
	/**
	 * <b>this function is used to all the field of the following parameters</b>
	 * </br>
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 */
	public static void cancelInformationBeforeAddExamination (JDateChooser examinationDateField,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection) {
		
		examinationDateField.setDate(new Date());
		patientNumberExamPanelField.setText("");
		examinationTypeSelection.setSelectedIndex(0);
		}
	
	/**
	 * <b>this function is used to look for informations related to Examen objects</b>
	 * </br>
	 * Clearing the temporaryList is needed before each research
	 * A loop is used to check in each Examen object if the key work is registered in the fields 
	 * If a result is found the Examen is stored in the temporaryList 
	 * Finally the result is shown by the JList 
	 * 		if the temporaryList is empty there is no results so it display the informations of the arrayExamination
	 * 		else it display the result(s) stored in the temporaryList
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param searchExaminationField : field available for the user to search for informations related to Examen object 
	 */
	public static void searchExamination (JList list,ArrayList<Examen> arrayExamination,JTextField searchExaminationField) {
		
		Examen examination;
		temporaryList.clear();
		
		for(int i = 0; i < arrayExamination.size(); i++) {
			
			examination = arrayExamination.get(i);
			String idPatient =""+examination.getPatient().getId();
			String text = searchExaminationField.getText();
			
			if(idPatient.equalsIgnoreCase(text) || examination.getTypeExamen().equalsIgnoreCase(text)) {
				temporaryList.add(examination);
			}
		}
		
		if(temporaryList.isEmpty()) {
			list.setListData(arrayExamination.toArray());
		}else {
			list.setListData(temporaryList.toArray());
		}
	}
	
	/**
	 * <b>this function is used to put the information of an Examen object in the graphic field</b>
	 * </br>
	 *The function used is related to the state of the temporaryList
	 * 		if the temporaryList is empty showExaminationFromArrayExamination() if put in action
	 * 		else showExaminationFronTemporaryList() is used
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field
	 *  </br>
	 *  @see showExaminationFromArrayExamination  
	 *  @see showExaminationFronTemporaryList
	 */
	public static void showExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
									   JDateChooser examinationDateField) {
		
		if(temporaryList.isEmpty()) {
			showExaminationFromArrayExamination(list,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		}else {
			showExaminationFronTemporaryList(list,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		}
	}
	
	/**
	 * <b>this function is used to delete an Examen</b>
	 * </br> 
	 * The function used is related to the state of the temporaryList
	 * 		if the temporaryList is empty deleteFromArrayExamination() if put in action
	 * 		else deleteFromTemporaryList() is used
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * @param switchRoomAndExaminationList : Graphic list component  switching display informations between Examen objects and Chambre object
	 * @param bookedList : Graphic list componant displaying the informations from the booked Chambre object
	 * </br>
	 * @see deleteFromArrayExamination
	 * @see deleteFromTemporaryList
	 */
	public static void deleteExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
										 JDateChooser examinationDateField,JList switchRoomAndExaminationList, JList bookedList) {


		
		if(temporaryList.isEmpty()) {
			deleteFromArrayExamination(list,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField,
									   switchRoomAndExaminationList,bookedList);
		} else {
			deleteFromTemporaryList(list,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField, 
									switchRoomAndExaminationList,bookedList);	
		}
	}
	
	/**
	 * <b>this function is used to change the informations of an Examen</b>
	 * </br> 
	 *The function used is related to the state of the temporaryList
	 * 		if the temporaryList is empty changeInfoExaminationFronArrayExamination() if put in action
	 * 		else changeInfoExaminationFromTemporaryList() is used
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * </br>
	 * @see changeInfoExaminationFronArrayExamination
	 * @see changeInfoExaminationFromTemporaryList
	 */
	public static void changeInfoExamination(JList list,ArrayList<Examen> arrayExamination,ArrayList<Patient> arrayPatient,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
											 JDateChooser examinationDateField) {

		if(temporaryList.isEmpty()) {
			
			changeInfoExaminationFronArrayExamination(list,arrayExamination,arrayPatient,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		
		}else {
		
			changeInfoExaminationFromTemporaryList(list,arrayExamination,arrayPatient,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		
		}
	}
	
	/**
	 * <b>this function is used to put the information of an Examen object in the graphic field</b>
	 * </br> 
	 * the index of the ligne selected in the graphic list is registered
	 * If the result of the selected index equals -1 the isn't executed
	 * the Examen stored at the selected index is extracted from the arrayExamination
	 * the information are dispatched in the related graphic fields component
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * </br>
	 * @see ParseFunctions#dateFormating
	 */
	private static void showExaminationFromArrayExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
															JDateChooser examinationDateField) {
		
		int idExamination = list.getSelectedIndex();
		
		if(idExamination == -1) 
			return;
		
		Examen examination = arrayExamination.get(idExamination);
		
		patientNumberExamPanelField.setText(""+examination.getPatient().getId());
		examinationTypeSelection.setSelectedItem(examination.getTypeExamen());
		examinationDateField.setDate(ParseFunctions.dateFormating(examination.getDateExamen()));
	}
	
	/**
	 * <b>this function is used to put the information of an Examen object in the graphic field</b>
	 * </br> 
	 * The index of the row selected in the graphic list is registered, if the result of the selected index equals -1 the function isn't executed
	 * The Examen stored at the selected index is extracted from the temporaryList
	 * The information are dispatched in the related graphic fields component
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * </br>
	 * @see ParseFunctions#dateFormating
	 */
	private static void showExaminationFronTemporaryList(JList list,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,JDateChooser examinationDateField) {

		int idExamination = list.getSelectedIndex();
		
		if(idExamination == -1) 
			return;
		
		Examen examination = temporaryList.get(idExamination);
		
		patientNumberExamPanelField.setText(""+examination.getPatient().getId());
		examinationTypeSelection.setSelectedItem(examination.getTypeExamen());
		examinationDateField.setDate(ParseFunctions.dateFormating(examination.getDateExamen()));	
	}
	
	/**
	 * 
	 * <b>this function is used to delete an Examen</b>
	 * </br> 
	 * The index of the row selected in the graphic list is registered, if the result of the selected index equals -1 the function isn't executed
	 * Before deleting an Examen it is imperative to check if a Chambre has already been booked for this one
	 * <pre>
	 * 		If no room has been booked :
	 * 			- The the selected index is used to remove the Examen stored in the index of the arrayExamination
	 * 			- The RoomFunction.updadeExaminationListForBooking() is used
	 * 		</br>
	 * 		Else if a room has been registered
	 * 			- The room is cloned 
	 * 			- The {@code RoomFunction.resetRoomDataToDefault()} is put in action
	 * 			- The the selected index is used to remove the Examen stored in the index of the arrayExamination
	 * 			- The {@code RoomFunction.updadeExaminationListForBooking()} is used 
	 * 			- The {@code RoomFunction.printRoomInList()} is used too
	 * </pre>
	 * After that the fields are cleared
	 * The updated arrayExamination is displayed in the graphic list
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * @param switchRoomAndExaminationList : Graphic list component  switching display informations between Examen objects and Chambre object
	 * @param bookedList : Graphic list componant displaying the informations from the booked Chambre object
	 * </br>
	 * @see RoomFunction#updadeExaminationListForBooking
	 * @see RoomFunction#resetRoomDataToDefault
	 * @see RoomFunction#printRoomInList
	 * @see cancelInformationBeforeAddExamination
	 */
	private static void deleteFromArrayExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
												   JDateChooser examinationDateField, JList switchRoomAndExaminationList, JList bookedList) {
		
		int idExamination = list.getSelectedIndex();
		
		if(idExamination == -1) 
		return;
		
		Examen examination = arrayExamination.get(idExamination);
		if(examination.getChambre() == null) {
			arrayExamination.remove(idExamination);
			RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
		}else {
			Chambre room = examination.getChambre();
			RoomFunction.resetRoomDataToDefault(room);
			arrayExamination.remove(idExamination);
			RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
			RoomFunction.printRoomInList(bookedList, room);
		}
		
		cancelInformationBeforeAddExamination(examinationDateField, patientNumberExamPanelField, examinationTypeSelection);
		
		list.setListData(arrayExamination.toArray());
	}
	
	/**
	 * 
	 * <b>this function is used to delete an Examen</b>
	 * </br> 
	 * The index of the row selected in the graphic list is registered, if the result of the selected index equals -1 the function isn't executed
	 * The Examen at the selected index is extracted of the temporaryList
	 * A loop is used to check all the Examen stored in the arrayExamination
	 * The value of all Examen are checked and to find the one selected by the user
	 * After it has been found and before deleting it, it is imperative to check if a Chambre has already been booked for this one
	 * <pre>
	 * 		If no room has been booked :
	 * 			- The selected index is used to remove the Examen stored in the index of the arrayExamination
	 * 			- The RoomFunction.updadeExaminationListForBooking() is used
	 * 		</br>
	 * 		Else if a room has been registered
	 * 			- The room is cloned 
	 * 			- The {@code RoomFunction.resetRoomDataToDefault()} is put in action
	 * 			- The the selected index is used to remove the Examen stored in the index of the arrayExamination
	 * 			- The {@code RoomFunction.updadeExaminationListForBooking()} is used 
	 * 			- The {@code RoomFunction.printRoomInList()} is used too
	 * </pre>
	 * The Examen at the selected index is removed of the temporaryList
	 * After that the fields are cleared
	 * The updated arrayExamination is displayed in the graphic list
	 * </br> 
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * @param switchRoomAndExaminationList : Graphic list component  switching display informations between Examen objects and Chambre object
	 * @param bookedList : Graphic list componant displaying the informations from the booked Chambre object
	 * </br>
	 * @see RoomFunction#updadeExaminationListForBooking
	 * @see RoomFunction#resetRoomDataToDefault
	 * @see RoomFunction#printRoomInList
	 * @see cancelInformationBeforeAddExamination
	 */
	private static void deleteFromTemporaryList(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
												JDateChooser examinationDateField,JList switchRoomAndExaminationList, JList bookedList) {
		
		int idExamination = list.getSelectedIndex();
		
		if(idExamination == -1) 
		return;
		
		Examen examinationTest = temporaryList.get(idExamination);
		
		for (int i = 0; i < arrayExamination.size(); i ++) {
			Examen examination = arrayExamination.get(i);
			if(examination.getPatient().getId() == examinationTest.getPatient().getId() && examination.getDateExamen().equals(examinationTest.getDateExamen()) 
			   && examination.getTypeExamen().equals(examinationTest.getTypeExamen()) ) {
				if(examination.getChambre() == null) {
					arrayExamination.remove(i);
					RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
				}else {
					Chambre room = examination.getChambre();
					RoomFunction.resetRoomDataToDefault(room);
					arrayExamination.remove(i);
					RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
					RoomFunction.printRoomInList(bookedList, room);
				}
			}
		}	
		temporaryList.remove(idExamination);
		cancelInformationBeforeAddExamination(examinationDateField, patientNumberExamPanelField, examinationTypeSelection);
			
		list.setListData(arrayExamination.toArray());
	}
	
	/**
	 * <b>this function is used to change the informations of an Examen from the arrayExamination</b>
	 * </br> 
	 * The index of the row selected in the graphic list is registered, if the result of the selected index equals -1 the function isn't executed
	 * The informations in the fields are checked
	 * Then the Examen stored at the selected index in the arrayExamination is extracted and it's values udpated
	 * Finally the updated arrayExamination is displayed in the JList
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * </br>
	 * @see ExaminationControler#inputFieldControler(JTextField, JComboBox, JDateChooser)
	 * @see ParseFunctions#numericConversion
	 * @see ExaminationControler#inputFieldControler(JComboBox, JDateChooser)
	 * @see ParseFunctions#dateFormating
	 */
	private static void changeInfoExaminationFronArrayExamination (JList list,ArrayList<Examen> arrayExamination,ArrayList<Patient> arrayPatient,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
																   JDateChooser examinationDateField) {
		
		int selection = list.getSelectedIndex();
		if(selection == -1)
			return;
		
		if(ExaminationControler.inputFieldControler(patientNumberExamPanelField,examinationTypeSelection, examinationDateField) == true) {
			int id = ParseFunctions.numericConversion(patientNumberExamPanelField.getText());
			
			if(PatientFunction.checkIfExist(arrayPatient, id) == false) {
			
				patientNumberExamPanelField.setText("Patient introuvable");
				
			}else {
				if(ExaminationControler.inputFieldControler(examinationTypeSelection, examinationDateField) == true) {
					
					Examen examination = arrayExamination.get(selection);
					
					examination.getPatient().setId(Integer.parseInt(patientNumberExamPanelField.getText()));
					examination.setTypeExamen(examinationTypeSelection.getSelectedItem().toString());
					examination.setDateExamen(ParseFunctions.dateFormating(examinationDateField.getDate()));
					
					list.setListData(arrayExamination.toArray());
				}
			}
		}
	}
	
	/**
	 * <b>this function is used to change the informations of an Examen from the temporaryList</b>
	 * </br> 
	 * The index of the row selected in the graphic list is registered, if the result of the selected index equals -1 the function isn't executed
	 * The informations in the fields are checked
	 * Then the Examen stored at the selected index in the temporaryList is extracted and it's values updated
	 * The temporaryList is cleared
	 * Finally the updated arrayExamination is displayed in the JList
	 * </br>
	 * @param list :  Graphic list component displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param patientNumberExamPanelField : display the id of the Patient for whom the Examen will be affected
	 * @param examinationTypeSelection : display a list of several type of examination
	 * @param examinationDateField : Graphic component input JDate field, the user can change the value of this field 
	 * </br>
	 * @see ExaminationControler#inputFieldControler(JTextField, JComboBox, JDateChooser)
	 * @see ParseFunctions#numericConversion(String)
	 * @see ExaminationControler#inputFieldControler(JComboBox, JDateChooser)
	 * @see ParseFunctions#dateFormating(String)
	 */
	private static void changeInfoExaminationFromTemporaryList (JList list,ArrayList<Examen> arrayExamination,ArrayList<Patient> arrayPatient,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
																JDateChooser examinationDateField) {
		
		int selection = list.getSelectedIndex();
		if(selection == -1)
			return;

		if(ExaminationControler.inputFieldControler(patientNumberExamPanelField,examinationTypeSelection, examinationDateField) == true) {
			int id = ParseFunctions.numericConversion(patientNumberExamPanelField.getText());
			
			if(PatientFunction.checkIfExist(arrayPatient, id) == false) {
			
				patientNumberExamPanelField.setText("Patient introuvable");
				
			}else {
				if(ExaminationControler.inputFieldControler(examinationTypeSelection, examinationDateField) == true) {
				
					Examen examination = temporaryList.get(selection);
					
					examination.getPatient().setId(Integer.parseInt(patientNumberExamPanelField.getText()));
					examination.setTypeExamen(examinationTypeSelection.getSelectedItem().toString());
					examination.setDateExamen(ParseFunctions.dateFormating(examinationDateField.getDate()));
					
					temporaryList.clear();
					
					list.setListData(arrayExamination.toArray());	
				}
			}
		}
	}
	
	/**
	 * <b>this function is used extract an Examen from arrayExamination with only the ID of the Patient </b>
	 * </br> 
	 * In a loop when the id Patient is found the loop is stopped
	 * The examination is returned
	 * </br> 
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param idP : is the value of a specific id from a Patient
	 * </br> 
	 * @return an Object Examen
	 */
	public static Examen extractExaminationFromArray(ArrayList<Examen> arrayExamination,int idP) {
		
		Examen examination = null;
		
			for(int i = 0; i < arrayExamination.size(); i++) {
				Examen examinationTest = arrayExamination.get(i);
				if(examinationTest.getPatient().getId() == idP) { 
					examination= examinationTest;
					break;
				}
			}
			
		return examination;
	}
	
	/**
	 * <b>this function is used extract an Examen from arrayExamination with only the ID of the Patient </b>
	 * </br> 
	 * In a loop when the id Patient, the type of examination and the date of the examination are found the loop is stopped
	 * The examination is returned
	 * </br>
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param idP : is the value of a specific id from a Patient
	 * @param examinationType : store the type of examination 
	 * @param examinationDate : store the date of the examination 
	 * </br>
	 * @return an Object Examen
	 */
	public static Examen extractExaminationFromArray(ArrayList<Examen> arrayExamination,int idP, String examinationType, String examinationDate) {
		
		Examen examination = null;
		
			for(int i = 0; i < arrayExamination.size(); i++) {
				Examen examinationTest = arrayExamination.get(i);
				if(examinationTest.getPatient().getId() == idP && examinationTest.getTypeExamen().equals(examinationType) && examinationTest.getDateExamen().equals(examinationDate)) { 
					examination= examinationTest;
					break;
				}
			}
			
		return examination;
	}

}
