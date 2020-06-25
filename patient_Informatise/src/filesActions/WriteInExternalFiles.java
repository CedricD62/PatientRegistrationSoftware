package filesActions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import functions.RoomFunction;
import luncher.InterfaceEnregistrementPatient;
import objectsPackage.Chambre;
import objectsPackage.Examen;
import objectsPackage.Patient;

public class WriteInExternalFiles {
	
	private static File 			file = null;
	private static FileWriter 		fileW= null;
	private static BufferedWriter 	bufferW=null;
	
	public static void writePatientFile(ArrayList<Patient>arrayPatient){
		
		 	file 		= null;
		 	fileW 		= null;
		 	bufferW 	= null;
		
		try {
			file = new File("Patient.txt");
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
		}finally { // passage dans le block finally pour la fermeture du buffer
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
	
	public static void writeExaminationFile(ArrayList<Examen>arrayExamination){
		
		 	file 		= null;
		 	fileW 		= null;
		 	bufferW 	= null;
		
		try {
			file = new File("Examen.txt");
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
		}finally { // passage dans le block finally pour la fermeture du buffer
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

	public static void writeRoomFile(ArrayList<Chambre>arrayRoom){
			
		 	file 		= null;
		 	fileW 		= null;
		 	bufferW 	= null;
		
		try {
			file = new File("Chambre.txt");
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
		}finally { // passage dans le block finally pour la fermeture du buffer
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
