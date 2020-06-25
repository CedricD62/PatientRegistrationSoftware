package treatment;

import java.io.File;
import java.io.FileNotFoundException;

public class FileControler {
	
	public static boolean filePatientExist() {
		boolean exist = false;
		
		//try {
			File file = new File("Patient.txt");
			exist = file.exists();
			
		/*}catch(FileNotFoundException fx) {
			exist = false;
		}*/
		
		return exist;
	}
	
	public static boolean fileExamenExist() {
		boolean exist = false;
		
		File file = new File("Examen.txt");
		exist = file.exists();
		
		return exist;
	}

	public static boolean fileRoomExist() {
		boolean exist = false;
		
		File file = new File("Chambre.txt");
		exist = file.exists();
		
		return exist;
	}
}
