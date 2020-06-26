package filesActions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JList;

import functions.ExaminationFunction;
import functions.ParseFunctions;
import functions.PatientFunction;
import functions.RoomFunction;
import objectsPackage.Chambre;
import objectsPackage.Examen;
import objectsPackage.Patient;
import treatment.FileControler;

public class ReadExternalFiles {

	private static File 			file = null;
	private static FileReader 		fileR= null;
	private static BufferedReader 	buffer=null;
	public static ArrayList<String> arrayAreaCode = new  ArrayList<String>();
	public static ArrayList<String> arrayMail= new ArrayList <String>(); 
	
	public static void dispatchInfoFromFiles(JList patientList,JList examinationList, JList switchRoomAndExaminationList,
			ArrayList<Examen>arrayExamination,ArrayList<Patient>arrayPatient,ArrayList<Chambre>arrayRoom,JList listOfBookedRoom) {
		if(FileControler.filePatientExist() == true) {
			readPatientFile(patientList, arrayPatient);
		}
		
		if(FileControler.fileExamenExist() == true) {
			readExaminationFile(examinationList, arrayExamination, arrayPatient);
		}
		
		if(FileControler.fileRoomExist() == true) {
			readRoomFile(arrayRoom, arrayExamination,listOfBookedRoom,switchRoomAndExaminationList);
		}else {
			RoomFunction.creatRoomIfFileIsEmpty(switchRoomAndExaminationList, arrayRoom);
		}
		
		areaCode();
		mailEndings();
	}
	
	private static void mailEndings() {
		
		try {
			file = new File("externalFiles/mailTerminaisons.csv");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;
			
			while((line = buffer.readLine()) != null) {
				
				if(counter != 0) {
					arrayMail.add(line);
				}
				counter++;
			}
			
			if(buffer != null) {
				buffer.close();
			}			
		}catch(IOException ex) {
			ex.printStackTrace();
			System.err.println("erreur d'impression");
		}finally {
			try {
				if(buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("erreur d'impression");
			}			
		}
	}
	
	private static void areaCode() {
		
		try {
			file = new File("externalFiles/areaCode.csv");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;	
			
			while((line = buffer.readLine()) != null) {
								
				if(counter != 0) {
					String [] fileAreaCode;
					fileAreaCode = line.split(";");
					arrayAreaCode.add(fileAreaCode[2]);
				}
				counter++;
			}
			
			if(buffer != null) {
				buffer.close();
			}			
		}catch(IOException ex) {
			ex.printStackTrace();
			System.err.println("erreur d'impression");
		}finally {
			try {
				if(buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("erreur d'impression");
			}			
		}
	}
	
	private static void readPatientFile(JList patientList,ArrayList<Patient>arrayPatient) {
		
		try {
			
			file = new File("Patient.txt");
			fileR = new FileReader(file);
			buffer = new BufferedReader(fileR);
			String line;
			Patient patient;
			
			while((line = buffer.readLine()) != null) {
				
				String [] splitPatient;
				splitPatient = line.split(",");
				int id = ParseFunctions.numericConversion(splitPatient[0]);
				String name = splitPatient[1];
				String firstName = splitPatient[2];
				String address = splitPatient[3];
				int cp = ParseFunctions.numericConversion(splitPatient[4]);
				String city = splitPatient[5];
				String email = splitPatient[6];
				long ssn = ParseFunctions.numericConversionLong(splitPatient[7]);
				String phone = splitPatient[8];
				String cellPhone = splitPatient[9];
				String birthDate = splitPatient[10];
				boolean male = Boolean.parseBoolean(splitPatient[11]);
				boolean female =  Boolean.parseBoolean(splitPatient[12]);
				boolean bookingRoom =  Boolean.parseBoolean(splitPatient[13]);
				
				patient = new Patient(id, male, female, name, firstName, address, cp, city, email, ssn, phone, cellPhone, birthDate, bookingRoom);
				patient.save = false;
				arrayPatient.add(patient);
			}
			
			patientList.setListData(arrayPatient.toArray());
		}catch(IOException ex) {
			
		}
	}
	
	private static void readExaminationFile(JList examinationList,ArrayList<Examen>arrayExamination,ArrayList<Patient>arrayPatient) {
		
		try {
			
			file = new File("Examen.txt");
			fileR = new FileReader(file);
			buffer = new BufferedReader(fileR);
			String line;
			Examen examination;
			
			while((line = buffer.readLine()) != null) {
				
				String [] splitExamination;
				splitExamination = line.split(",");
				
				int idPatient		= ParseFunctions.numericConversion(splitExamination[0]);
				Patient patient 	= PatientFunction.extractPatientFromArray(arrayPatient, idPatient);
				String typeExamen	= splitExamination[1];
				String dateExamen	= splitExamination[2];
				boolean bookingRoom = Boolean.parseBoolean(splitExamination[3]);

				examination = new Examen(patient,null,typeExamen,dateExamen);
				examination.setBookingRoom(bookingRoom);
				examination.save = false;
				arrayExamination.add(examination);
			}
		}catch(IOException ex) {
			
		}
	}
	
	private static void readRoomFile(ArrayList<Chambre>arrayRoom,ArrayList<Examen>arrayExamination,JList listOfBookedRoom,JList switchRoomAndExaminationList) {
		
		try {
			
			file = new File("Chambre.txt");
			fileR = new FileReader(file);
			buffer = new BufferedReader(fileR);
			String line;
			Chambre room;
			
			while((line = buffer.readLine()) != null) {
				
					String [] splitRoom;
					splitRoom = line.split(",");
					
					if(splitRoom.length > 8) {
					int roomNumber			= ParseFunctions.numericConversion(splitRoom[0]); 
					int idPatient			= ParseFunctions.numericConversion(splitRoom[1]);
					String examinationType 	= splitRoom[2];
					String examinationDate 	= splitRoom[3];
					Examen examination 		= ExaminationFunction.extractExaminationFromArray(arrayExamination,idPatient, examinationType, examinationDate);
					int numberOfBed			= ParseFunctions.numericConversion(splitRoom[4]);
					String entryDate		= splitRoom[5];
					String releaseDate		= splitRoom[6];
					boolean alone 			= Boolean.parseBoolean(splitRoom[7]);
					boolean accompanying 	= Boolean.parseBoolean(splitRoom[8]);
					boolean available 		= Boolean.parseBoolean(splitRoom[9]);
					boolean bookingRoom 	= Boolean.parseBoolean(splitRoom[10]);
	
					room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom,examination);
					room.save = false;
					RoomFunction.bookedRoomList.add(room);
					arrayRoom.add(room);
				}else {
					int roomNumber			= ParseFunctions.numericConversion(splitRoom[0]); 
					boolean accompanying 	= Boolean.parseBoolean(splitRoom[1]);
					boolean alone 			= Boolean.parseBoolean(splitRoom[2]);
					boolean available 		= Boolean.parseBoolean(splitRoom[3]);
					boolean bookingRoom 	= Boolean.parseBoolean(splitRoom[4]);
					String entryDate		= splitRoom[5];
					String releaseDate		= splitRoom[6];
					int numberOfBed			= ParseFunctions.numericConversion(splitRoom[7]);
					
					room = new Chambre(entryDate,releaseDate,roomNumber,alone,accompanying,available,numberOfBed,bookingRoom);
					room.save = false;
					arrayRoom.add(room);
				}
			}
			
			//switchRoomAndExaminationList.setListData(arrayRoom.toArray());
			listOfBookedRoom.setListData(RoomFunction.bookedRoomList.toArray());
		}catch(IOException ex) {
			
		}
	}
}
