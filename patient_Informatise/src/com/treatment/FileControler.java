package com.treatment;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * <b>FileControler class check if the files are existing</b>
 * </br>
 * This class contains 3 public functions
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class FileControler {
	
	/**
	 * <b>filePatientExist class check if Patient.txt exists</b>
	 * </br>
	 * @return a boolean true or false 
	 */
	public static boolean filePatientExist() {
		boolean exist = false;
		
			File file = new File("Patient.txt");
			exist = file.exists();
		
		return exist;
	}
	
	/**
	 * <b>fileExamenExist class check if Examen.txt exists</b>
	 * </br>
	 * @return a boolean true or false 
	 */
	public static boolean fileExamenExist() {
		boolean exist = false;
		
		File file = new File("Examen.txt");
		exist = file.exists();
		
		return exist;
	}

	/**
	 * <b>fileRoomExist class check if Chambre.txt exists</b>
	 * </br>
	 * @return a boolean true or false 
	 */
	public static boolean fileRoomExist() {
		boolean exist = false;
		
		File file = new File("Chambre.txt");
		exist = file.exists();
		
		return exist;
	}
}
