package filesActions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ReadExternalFiles {

	public static String [] mailEndings() {
		
		String [] mail; 
		
		File 			file = null;
		FileReader 		fileR= null;
		BufferedReader 	buffer=null;
	
		
		try {
			
			file = new File("mailTerminaisons.csv");
			fileR = new FileReader(file); 
			buffer = new BufferedReader(fileR);
			String line;
			int counter = 0;
			
			while((line = buffer.readLine()) != null) {
				
				if(counter != 0) {
					mail[counter] = line;
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
	
}
