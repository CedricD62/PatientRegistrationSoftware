package treatment;

import java.io.File;
import java.io.FileNotFoundException;

public class fileControler {
	
	public static boolean filePatient() {
		boolean exist = false;
		
		//try {
			File file = new File("Patient.txt");
			exist = file.exists();
			
		/*}catch(FileNotFoundException fx) {
			exist = false;
		}*/
		
		return exist;
	}
	
	public static boolean fileExamen() {
		boolean exist = false;
		
		File file = new File("Examen.txt");
		exist = file.exists();
		
		return exist;
	}

	public static boolean fileRoom() {
		boolean exist = false;
		
		File file = new File("Chambre.txt");
		exist = file.exists();
		
		return exist;
	}
}
