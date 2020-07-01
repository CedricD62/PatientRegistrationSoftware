package com.filesActions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.functions.RoomFunction;
import com.objectsPackage.Chambre;
import com.objectsPackage.Examen;
import com.objectsPackage.Patient;

import luncher.InterfaceEnregistrementPatient;

/**
 * <b>WriteInExternalFiles extratcs informations from ArrayLists needed to be saved in external files</b>
 * </br>
 * This class contains 3 public functions :
 * <ul>
 * <li> @see writePatientFile </li>
 * <li> @see writeExaminationFile</li>
 * <li> @see writeRoomFile</li>
 * </ul>
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class WriteInExternalFiles {
	
	/**
	 * file, fileW and bufferW are File related objects put in private static to be used only by all the functions of this class 
	 */
	
	private static File 			file = null;
	private static FileWriter 		fileW= null;
	private static BufferedWriter 	bufferW=null;
	
	/**
	 * <b>This function is used for saving Patients' informations</b>
	 * </br>
	 * Each Patient stored in arrayPatient are extracted thanks to a loop
	 * The patient's informations are saved in Patient.txt that is created at the project's root
	 * For saving those informations a toString function is override in Patient class
	 * The finally block is used to certify that the buffer has weel been closed before quitting the function
	 * </br>
	 * {@code patient.save} is only used in writing and reading Object and allow the application to switch beetween toString options
	 * 				  		this param doesn't have Getter and Setter functions to reduce all wrong using
	 * </br>
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user
	 * </br>
	 * @see Patient#toString()
	 */
	public static void writePatientFile(ArrayList<Patient>arrayPatient){
		
		 	file 		= null;
		 	fileW 		= null;
		 	bufferW 	= null;
		
		try {
			file = new File("C:/externalFiles/Patient.txt");
			fileW = new FileWriter(file, false);
			bufferW = new BufferedWriter(fileW);
			
			for(int i = 0; i < arrayPatient.size(); i++) {
				
				Patient patient = arrayPatient.get(i);
				patient.save = true;
				
				bufferW.write(patient.toString());
				patient.save = false;
				bufferW.newLine();
				bufferW.flush();
			}
			
			if(bufferW != null) {
				bufferW.close();
			}
			
		}catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("erreur d'impression");
		}finally { 
			try {
				
				if(bufferW != null) {
					bufferW.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("erreur d'impression");
			}				
		}
	}
	
	/**
	 * <b>This function is used for saving Examens' informations</b>
	 * </br>
	 * Each Examen stored in arrayExamination is extracted thanks to a loop
	 * The Examen's informations are saved in Examen.txt that is created at the project's root
	 * For saving those informations a toString function is override in Examen class
	 * The finally block is used to certify that the buffer has weel been closed before quitting the function
	 * </br>
	 * {@code Examen.save} is only used in writing and reading Object and allow the application to switch beetween toString options
	 * 				  	   this param doesn't have Getter and Setter functions to reduce all wrong using
	 * </br>
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * </br>
	 * @see Examen#toString()
	 */
	public static void writeExaminationFile(ArrayList<Examen>arrayExamination){
		
		 	file 		= null;
		 	fileW 		= null;
		 	bufferW 	= null;
		
		try {
			file = new File("C:/externalFiles/Examen.txt");
			fileW = new FileWriter(file, false);
			bufferW = new BufferedWriter(fileW);
			
			for(int i = 0; i < arrayExamination.size(); i++) {
				
				Examen examination = arrayExamination.get(i);
				examination.save = true;
				
				bufferW.write(examination.toString());
				examination.save = false;
				bufferW.newLine();
				bufferW.flush();
			}
			
			if(bufferW != null) {
				bufferW.close();
			}
			
		}catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("erreur d'impression");
		}finally {
			try {
				
				if(bufferW != null) {
					bufferW.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("erreur d'impression");
			}				
		}
	}

	/**
	 * <b>This function is used for saving Chambres' informations</b>
	 * </br>
	 * Each Chambre stored in arrayRoom is extracted thanks to a loop
	 * The Chambre's informations are saved in Chambre.txt that is created at the project's root
	 * For saving those informations a toString function is override in Chambre class
	 * The finally block is used to certify that the buffer has weel been closed before quitting the function
	 * </br>
	 * {@code Chambre.save} is only used in writing and reading Object and allow the application to switch beetween toString options
	 * 				  	    this param doesn't have Getter and Setter functions to reduce all wrong using
	 * </br>
	 * @param arrayRoom : used to keep the Chambre object extracted from external file
	 * </br>
	 * @see Chambre#toString()
	 */
	public static void writeRoomFile(ArrayList<Chambre>arrayRoom){
			
		 	file 		= null;
		 	fileW 		= null;
		 	bufferW 	= null;
		
		try {
			file = new File("C:/externalFiles/Chambre.txt");
			fileW = new FileWriter(file, false);
			bufferW = new BufferedWriter(fileW);
			
			for(int i = 0; i < arrayRoom.size(); i++) {
				
				Chambre room = arrayRoom.get(i);
				room.save = true;
				
				bufferW.write(room.toString());
				room.save = false;
				bufferW.newLine();
				bufferW.flush();
			}
			
			if(bufferW != null) {
				bufferW.close();
			}
			
		}catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("erreur d'impression");
		}finally {
			try {
				
				if(bufferW != null) {
					bufferW.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("erreur d'impression");
			}				
		}
	}
}
