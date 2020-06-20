package functions;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import patient_Informatise.Chambre;
import patient_Informatise.Examen;
import patient_Informatise.Patient;
import treatment.ExaminationControler;

public class ExaminationFunction 
{

	public static ArrayList<Examen> temporaryList = new ArrayList<Examen>();
	
	public static void creatExamination (JList listExaminationPanel,JList listBookingRoomPannel,ArrayList<Patient> arrayPatient,ArrayList<Examen> arrayExamination,
										 JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,JDateChooser examinationDateField,JDateChooser entryDateField, 
										 JDateChooser releaseDateField){
		if(ExaminationControler.inputFieldControler(patientNumberExamPanelField) == true) {
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
					listBookingRoomPannel.setListData(RoomFunction.temporaryListExamination.toArray());
					
					DefaultValueLuncher.setDefaultRangeForBookingRoomDate(entryDateField,releaseDateField,examination);
					cancelInformationBeforeAddExamination(examinationDateField, patientNumberExamPanelField, examinationTypeSelection);
				}
			}
		}
	}
	
	public static void cancelInformationBeforeAddExamination (JDateChooser examinationDateField,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection) {
		
		examinationDateField.setDate(new Date());
		patientNumberExamPanelField.setText("");
		examinationTypeSelection.setSelectedIndex(0);
		}
	
	public static void searchExamination (JList list,ArrayList<Examen> arrayExamination,JTextField searchExaminationField) {
		
		Examen examination;
		temporaryList.clear();
		
		for(int i = 0; i < arrayExamination.size(); i++) {
			
			examination = arrayExamination.get(i);
			String idPatient =""+examination.getPatient().getId();
			String text = searchExaminationField.getText();
			
			if(idPatient.equalsIgnoreCase(text) || examination.getTypeExamen().equalsIgnoreCase(text) /*|| examination.getDateExamen().equalsIgnoreCase(text)*/) {
				temporaryList.add(examination);
			}
		}
		
		if(temporaryList.isEmpty()) {
			list.setListData(arrayExamination.toArray());
		}else {
			list.setListData(temporaryList.toArray());
		}
	}
	
	public static void showExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
									   JDateChooser examinationDateField) {
		
		if(temporaryList.isEmpty()) {
			showExaminationFromArrayExamination(list,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		}else {
			showExaminationFronTemporaryList(list,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		}
	}
	
	public static void deleteExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
										 JDateChooser examinationDateField,JList switchRoomAndExaminationList, JList bookedList) {

		int idExamination = list.getSelectedIndex();
		
		if(idExamination == -1) 
		return;
		
		if(temporaryList.isEmpty()) {
			deleteFromArrayExamination(list,arrayExamination,idExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField,
									   switchRoomAndExaminationList,bookedList);
		} else {
			deleteFromTemporaryList(list,arrayExamination,idExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField, 
									switchRoomAndExaminationList,bookedList);	
		}
	}
	
	public static void changeInfoExamination(JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
											 JDateChooser examinationDateField) {

		if(temporaryList.isEmpty()) {
			
			changeInfoExaminationFronArrayExamination(list,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		
		}else {
		
			changeInfoExaminationFromTemporaryList(list,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
		
		}
	}
	
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
	
	private static void showExaminationFronTemporaryList(JList list,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,JDateChooser examinationDateField) {

		int idExamination = list.getSelectedIndex();
		
		if(idExamination == -1) 
			return;
		
		Examen examination = temporaryList.get(idExamination);
		
		patientNumberExamPanelField.setText(""+examination.getPatient().getId());
		examinationTypeSelection.setSelectedItem(examination.getTypeExamen());
		examinationDateField.setDate(ParseFunctions.dateFormating(examination.getDateExamen()));	
	}
	
	private static void deleteFromArrayExamination(JList list,ArrayList<Examen> arrayExamination,int indexSelection,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
												   JDateChooser examinationDateField, JList switchRoomAndExaminationList, JList bookedList) {
		
		Examen examination = arrayExamination.get(indexSelection);
		if(examination.getChambre() == null) {
			arrayExamination.remove(indexSelection);
		}else {
			Chambre room = examination.getChambre();
			RoomFunction.resetRoomDataToDefault(room);
			arrayExamination.remove(indexSelection);
			RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
			RoomFunction.printRoomInList(bookedList, room);
		}
		
		cancelInformationBeforeAddExamination(examinationDateField, patientNumberExamPanelField, examinationTypeSelection);
		
		list.setListData(arrayExamination.toArray());
	}
	
	private static void deleteFromTemporaryList(JList list,ArrayList<Examen> arrayExamination,int indexSelection,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
												JDateChooser examinationDateField,JList switchRoomAndExaminationList, JList bookedList) {
		
		Examen examinationTest = temporaryList.get(indexSelection);
		
		for (int i = 0; i < arrayExamination.size(); i ++) {
			Examen examination = arrayExamination.get(i);
			if(examination.getPatient().getId() == examinationTest.getPatient().getId() && examination.getDateExamen().equals(examinationTest.getDateExamen()) 
			   && examination.getTypeExamen().equals(examinationTest.getTypeExamen()) ) {
				if(examination.getChambre() == null) {
					arrayExamination.remove(i);
				}else {
					Chambre room = examination.getChambre();
					RoomFunction.resetRoomDataToDefault(room);
					arrayExamination.remove(i);
					RoomFunction.updadeExaminationListForBooking(switchRoomAndExaminationList, arrayExamination);
					RoomFunction.printRoomInList(bookedList, room);
				}
			}
		}	
		temporaryList.remove(indexSelection);
		cancelInformationBeforeAddExamination(examinationDateField, patientNumberExamPanelField, examinationTypeSelection);
			
		list.setListData(arrayExamination.toArray());
	}
	
	private static void changeInfoExaminationFronArrayExamination (JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
																   JDateChooser examinationDateField) {
		int selection = list.getSelectedIndex();
			if(selection == -1)
				return;
		
		Examen examination = arrayExamination.get(selection);
		
		examination.getPatient().setId(Integer.parseInt(patientNumberExamPanelField.getText()));
		examination.setTypeExamen(examinationTypeSelection.getSelectedItem().toString());
		examination.setDateExamen(ParseFunctions.dateFormating(examinationDateField.getDate()));
		
		list.setListData(arrayExamination.toArray());
	}
	
	private static void changeInfoExaminationFromTemporaryList (JList list,ArrayList<Examen> arrayExamination,JTextField patientNumberExamPanelField,JComboBox examinationTypeSelection,
																JDateChooser examinationDateField) {
		int selection = list.getSelectedIndex();
		if(selection == -1)
			return;
	
		Examen examination = temporaryList.get(selection);
		
		examination.getPatient().setId(Integer.parseInt(patientNumberExamPanelField.getText()));
		examination.setTypeExamen(examinationTypeSelection.getSelectedItem().toString());
		examination.setDateExamen(ParseFunctions.dateFormating(examinationDateField.getDate()));
		
		temporaryList.clear();
		
		list.setListData(arrayExamination.toArray());	
	}
	
	public static Examen extractExaminationFromArray(ArrayList<Examen> arrayExamination,int idP, String examinationType) {
		
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

}
