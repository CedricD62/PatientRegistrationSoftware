package com.filesActions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JList;

import com.functions.ExaminationFunction;
import com.functions.ParseFunctions;
import com.functions.PatientFunction;
import com.functions.RoomFunction;
import com.objectsPackage.Chambre;
import com.objectsPackage.Examen;
import com.objectsPackage.Patient;
import com.treatment.FileControler;

/**
 * <b>ReadExternalFiles class contains all functions needed tp extract informations from files to run the application</b>
 * </br>
 * This class contains 1 public function and 5 private functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class ReadExternalFiles {
	
	/**
	 * file, fileR and buffer are File related objects put in private static to be used only by all the functions of this class 
	 */
	private static File 			file = null;
	private static FileReader 		fileR= null;
	private static BufferedReader 	buffer=null;
	
	/**
	 * arrayAreaCode ArrayList type collection used to keep the areaCode extracted from external file 
	 * this Array is used for checking available AreaCode of France country 
	 * </br>
	 * <ul>
	 * <li> @see areaCode </li>  
	 * <li> @see checkUpAvailableAreaCode </li>  
	 * </ul>   
	 */
	public static ArrayList<String> arrayAreaCode = new  ArrayList<String>();
	
	/**
	 * arrayExaminationType ArrayList type collection used to keep the areaCode extracted from external file 
	 * </br>
	 * <ul>
	 * <li> @see areaCode </li>  
	 * <li> @see checkUpAvailableAreaCode </li>  
	 * </ul>   
	 */
	public static ArrayList<String> arrayExaminationType = new  ArrayList<String>();
	
	/**
	 * arrayLengthOfStay ArrayList type collection used to keep the length of stay in the hospital extracted from external file 
	 * </br>
	 * @see areaCode  
	 * @see checkUpAvailableAreaCode 
	 */
	public static ArrayList<String> arrayLengthOfStay = new  ArrayList<String>();
	
	/**
	 * arrayCellphoneNumber ArrayList type collection used to keep the two first number of a cellphone number  extracted from external file 
	 * </br>
	 * @see areaCode  
	 * @see checkUpAvailableAreaCode 
	 */
	public static ArrayList<String> arrayCellphoneNumber = new  ArrayList<String>();
	
	/**
	 * arrayPhoneNumber ArrayList type collection used to keep the two first number of phone number  extracted from external file 
	 * </br>
	 * @see areaCode  
	 * @see checkUpAvailableAreaCode 
	 */
	public static ArrayList<String> arrayPhoneNumber = new  ArrayList<String>();
	
	/**
	 * arrayMail ArrayList type collection used to keep the mail extracted from external file 
	 * this Array is used for checking available email endings 
	 * </br>
	 * <ul>
	 * <li> @see mailEndings </li>  
	 * <li> @see checkUpAvailableEmail </li>  
	 * </ul>   
	 */
	public static ArrayList<String> arrayMail= new ArrayList <String>();
	//public static  ArrayList<String> JcomboSelection = new ArrayList <String>();
	
	/**
	 * <b>The only public function of this class lunched in starting application and dispaitching informations from files if files exist</b>
	 *  </br>
	 * <ul>
	 * <li> @see FileControler </li>  
	 * <li> @see readPatientFile</li>  
	 * <li> @see readExaminationFile </li>  
	 * <li> @see readRoomFile() </li>  
	 * <li> @see RoomFunction#creatRoomIfFileIsEmpty </li>  
	 * <li> @see areaCode </li>  
	 * <li> @see mailEndings </li>  
	 * </ul>  
	 * 
	 * @param patientList : Graphic list componant displaying the informations from the patient objects existing in arrayPatient
	 * @param examinationList : Graphic list componant displaying the informations from the Examen objects existing in arrayExamination
	 * @param switchRoomAndExaminationList : Graphic list componant  switching display informations between Examen objects and Chambre object
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user 
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user 
	 * @param arrayRoom : used to keep the Chambre object extracted from external file 
	 * @param listOfBookedRoom : Graphic list componant displaying the informations from the booked Chambre object extracted from external file or booked by the user 
	 */
	public static void dispatchInfoFromFiles(JList patientList,JList examinationList, JList switchRoomAndExaminationList,ArrayList<Examen>arrayExamination,
											 ArrayList<Patient>arrayPatient,ArrayList<Chambre>arrayRoom,JList listOfBookedRoom) {
		if(FileControler.filePatientExist() == true) {
			readPatientFile(patientList, arrayPatient);
		}
		
		if(FileControler.fileExamenExist() == true) {
			readExaminationFile(examinationList, arrayExamination, arrayPatient);
		}
		
		if(FileControler.fileRoomExist() == true) {
			readRoomFile(arrayRoom, arrayExamination,listOfBookedRoom,switchRoomAndExaminationList);
		}else {
			RoomFunction.creatRoomIfFileIsEmpty(arrayRoom);
		}
		
		areaCode();
		mailEndings();
		examinationTypeFromFile();
		lengthOfStayFromFile();
		cellphoneNumberFromFile();
		phoneNumberFromFile();
	}
	
	/**
	 * <b>This function extract mail endings from csv file and add it to {@code ArrayList<String> arrayMail}</b>
	 * </br>
	 * The first line for the csv file is ignored by the extraction function
	 * If a problem occur it is shoulder by the catch part
	 * The function ends with the finally block in which the buffer is closed
	 */
	private static void mailEndings() {
		
		try {
			file = new File("C:/externalFiles/mailTerminaisons.csv");
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
	
	/**
	 * <b>This function extract examination type from csv file and add it to {@code ArrayList<String> arrayExaminationType}</b>
	 * </br>
	 * If a problem occur it is shoulder by the catch part
	 * The function ends with the finally block in which the buffer is closed
	 */
	private static void examinationTypeFromFile() {
		
		try {
			file = new File("C:/externalFiles/examinationType.csv");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;
			
			while((line = buffer.readLine()) != null) {
				arrayExaminationType.add(line);
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
	
	/**
	 * <b>This function extract length of stay from csv file and add it to {@code ArrayList<String> arrayLengthOfStay}</b>
	 * </br>
	 * If a problem occur it is shoulder by the catch part
	 * The function ends with the finally block in which the buffer is closed
	 */
	private static void lengthOfStayFromFile() {
		
		try {
			file = new File("C:/externalFiles/lengthOfStay.csv");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;
			
			while((line = buffer.readLine()) != null) {
				arrayLengthOfStay.add(line);
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
	
	/**
	 * <b>This function extract teh two first number of cellphone number available in France from csv file and add it to {@code ArrayList<String> arrayCellphoneNumber}</b>
	 * </br>
	 * If a problem occur it is shoulder by the catch part
	 * The function ends with the finally block in which the buffer is closed
	 */
	private static void cellphoneNumberFromFile() {
		
		try {
			file = new File("C:/externalFiles/cellphoneNumber.txt");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;
			
			while((line = buffer.readLine()) != null) {
				arrayCellphoneNumber.add(line);
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
	
	/**
	 * <b>This function extract teh two first number of phone number available in France from csv file and add it to {@code ArrayList<String> arrayCellphoneNumber}</b>
	 * </br>
	 * If a problem occur it is shoulder by the catch part
	 * The function ends with the finally block in which the buffer is closed
	 */
	private static void phoneNumberFromFile() {
		
		try {
			file = new File("C:/externalFiles/phoneNumber.txt");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;
			
			while((line = buffer.readLine()) != null) {
				arrayPhoneNumber.add(line);
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
	
	/**
	 * <b>This function extract area codes from csv file and add it to {@code ArrayList<String> arrayAreaCode}</b>
	 * </br>
	 * The first line for the csv file is ignored by the extraction function
	 * Only the third columns (the one which contains the area code) is extracted from the CSV file
	 * If a problem occur it is shoulder by the catch part
	 * The function ends with the finally block in which the buffer is closed
	 * </br>
	 * The following URL needs to be parametized before <b>jar compilation</b> for the extraction to be working 
	 * {@code file = new File("C:/Users/final/Desktop/externalFiles/areaCode.csv") }
	 * </br>
	 */
	private static void areaCode() {
		
		try {
			file = new File("C:/externalFiles/areaCode.csv");
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
	
	/**
	 * <b>This function extract Patients  from csv file and add it to {@code ArrayList<Patient>arrayPatient}</b>
	 * </br>
	 * Each rows are extracted from the file, stocked in a String [] splitPatient and split
	 * Then each index of the array are stored in variables and parsed if needed before being used in Patient constructor.
	 * Reach created Patient are stored in arrayPatient and displayed in patientList.
	 * </br>
	 * {@code patient.save = false} is only used in writing and reading Object and allow the application to switch beetween toString options
	 * 						   this param doesn't have Getter and Setter functions to reduce all wrong using
	 * </br>
	 * @param patientList : Graphic list componant showing the patient objects existing in arrayPatient
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user
	 *  </br>
	 * @see ParseFunctions#numericConversion()
	 * @see ParseFunctions#numericConversionLong()
	 * @see Patient#Patient(int, boolean, boolean, String, String, String, int, String, String, long, String, String, String, boolean)
	 */
	private static void readPatientFile(JList patientList,ArrayList<Patient>arrayPatient) {
		
		try {
			
			file = new File("C:/externalFiles/Patient.txt");
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
	
	/**
	 * <b>This function extract Examen from csv file and add it to {@code ArrayList<Examen>arrayExamination}</b>
	 * </br>
	 * Each rows are extracted from the file, stocked in a String [] splitExamination and split
	 * Then each index of the array are stored in variables and parsed if needed 
	 * The patient for whom the examination has been registerd is extracted from arrayPatient 
	 * thoses variables are used in Examen constructor.
	 * Reach created Examen are stored in arrayExamination and displayed in examinationList.
	 * </br>
	 * {@code examination.save = false} is only used in writing and reading Object and allow the application to switch beetween toString options
	 * 								   this param doesn't have Getter and Setter functions to reduce all wrong using
	 * </br>
	 * @param examinationList : Graphic list componant displaying the informations from the Examen objects existing in arrayExamination
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user
	 * @param arrayPatient : used to keep the Patient object extracted from external file or created by the user
	 * </br>
	 * @see ParseFunctions#numericConversion
	 * @see PatientFunction@extractPatientFromArray
	 * @see Examen#Examen(Patient, Chambre, String, String)
	 */
	private static void readExaminationFile(JList examinationList,ArrayList<Examen>arrayExamination,ArrayList<Patient>arrayPatient) {
		
		try {
			
			file = new File("C:/externalFiles/Examen.txt");
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
	
	/**
	 * <b>This function extract Chambre from csv file and add it to {@code ArrayList<Chambre>arrayRoom or RoomFunction.bookedRoomList }</b>
	 * </br>
	 * Each rows are extracted from the file, stocked in a String [] splitRoom and split
	 * Then each index of the array are stored in variables and parsed if needed 
	 * The examination for which a room has been booked is extracted from arrayExamination 
	 * those variables are used in Chambre constructor.
	 * each created Chambre are stored in arrayRoom and/or RoomFunction.bookedRoomList, it depends of the existing Examen or not.
	 * This information is known thank to the length of the array [] splitRoom which determined the process followed for the instanciation of Chambre Object
	 * Then those informations are displayed in examinationList
	 * </br>
	 * {@code room.save = false} is only used in writing and reading Object and allow the application to switch beetween toString options
	 * 						this param doesn't have Getter and Setter functions to reduce all wrong using
	 * </br>
	 * @param arrayRoom : used to keep the Chambre object extracted from external file
	 * @param arrayExamination : used to keep the Examen object extracted from external file or created by the user
	 * @param listOfBookedRoom : Graphic list componant displaying the informations from the booked Chambre object extracted from external file or booked by the user 
	 * @param switchRoomAndExaminationList : Graphic list componant  switching display informations between Examen objects and Chambre object
	 * * </br>
	 * @see ParseFunctions#numericConversion
	 * @see ExaminationFunction#extractExaminationFromArray
	 * @see Chambre#Chambre(String, String, int, boolean, boolean, boolean, int, boolean, Examen)
	 * @see Chambre#Chambre(String, String, int, boolean, boolean, boolean, int, boolean)
	 */
	private static void readRoomFile(ArrayList<Chambre>arrayRoom,ArrayList<Examen>arrayExamination,JList listOfBookedRoom,JList switchRoomAndExaminationList) {
		
		try {
			
			file = new File("C:/externalFiles/Chambre.txt");
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
