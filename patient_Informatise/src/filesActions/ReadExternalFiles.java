package filesActions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadExternalFiles {

	private static File 			file = null;
	private static FileReader 		fileR= null;
	private static BufferedReader 	buffer=null;
	
	public static ArrayList<String> mailEndings() {
		
		ArrayList<String> mail= new ArrayList <String>(); 
		
		try {
			file = new File("mailTerminaisons.csv");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;
			
			while((line = buffer.readLine()) != null) {
				
				if(counter != 0) {
					mail.add(line);
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
		
		return mail;
	}
	
	public static ArrayList<String> areaCode() {
		
		ArrayList<String> ArrayAreaCode= new ArrayList <String>(); 
		
		try {
			file = new File("areaCode.csv");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;	
			
			while((line = buffer.readLine()) != null) {
								
				if(counter != 0) {
					String [] fileAreaCode;
					fileAreaCode = line.split(";");
					ArrayAreaCode.add(fileAreaCode[2]);
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
		
		return ArrayAreaCode;
	}
}
