package treatment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class PatientControler {
	
	public static boolean inputFieldControler(JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton,JTextField nameField, JTextField fNameField,
											  JTextField addressField, JTextField areaCodeField, JTextField townField,JTextField ssnField,JTextField eMailField, JTextField phoneField, 
											  JTextField cellphoneField, JDateChooser birthdateField) {
		boolean fieldOk = true;
		
		if(checkUpJTextFieldStringInput(nameField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldStringInput(fNameField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldStringInput(addressField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldStringInput(townField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldStringInput(eMailField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailableEmail(eMailField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldStringInput(phoneField) == false) {
			fieldOk = false; 
		}else {
			
		}
		if(checkUpJTextFieldStringInput(cellphoneField) == false) {
			fieldOk = false; 
		}else {
			
		}
		if(checkUpJTextFieldIntInput(idField) == false) {
			fieldOk = false; 
		}else {
			
		}
		if(checkUpJTextFieldIntInput(areaCodeField) == false) {
			fieldOk = false; 
		}else {
			
		}
		if(checkUpJTextFieldIntInput(ssnField) == false) {
			fieldOk = false; 
		}else {
			
		}
		if(checkUpJRadioButtonInput(maleRButton,femaleRButton) == false) {
			fieldOk = false; 
		}
		if(checkUpJDateChooserDateInput(birthdateField) == false){
			fieldOk = false;
		}
		
		return fieldOk;
	}
	
	/*public static void warningWrongInput(JTextField idField,JRadioButton maleRButton, JRadioButton femaleRButton,JTextField nameField, JTextField fNameField,
			  							 JTextField addressField, JTextField areaCodeField, JTextField townField,JTextField ssnField,JTextField eMailField, JTextField phoneField, 
			  							 JTextField cellphoneField, JDateChooser birthdateField) {
		
		if(checkUpJTextFieldStringInput(nameField) == false) {
			warningWrongStringInput(nameField);
		}
		if(checkUpJTextFieldStringInput(fNameField) == false) {
			warningWrongStringInput(fNameField);
		}
		if(checkUpJTextFieldStringInput(addressField) == false) {
			warningWrongStringInput(addressField);
		}
		if(checkUpJTextFieldStringInput(areaCodeField) == false) {
			warningWrongStringInput(areaCodeField);
		}
		if(checkUpJTextFieldStringInput(townField) == false) {
			warningWrongStringInput(townField);
		}
		if(checkUpJTextFieldStringInput(eMailField) == false) {
			warningWrongStringInput(eMailField);
		}
		if(checkUpJTextFieldStringInput(phoneField) == false) {
			warningWrongStringInput(phoneField);
		}
		if(checkUpJTextFieldStringInput(cellphoneField) == false) {
			warningWrongStringInput(cellphoneField);
		}
		if(checkUpJTextFieldIntInput(idField) == false) {
			warningWrongIntInput(idField);
		}
		if(checkUpJTextFieldIntInput(ssnField) == false) {
			warningWrongIntInput(ssnField);
		}
		if(checkUpJTextFieldIntInput(maleRButton,femaleRButton) == false) {
			warningWrongBooleanInput(maleRButton,femaleRButton);
		}
		
	}*/
	
	
	private static boolean checkUpJTextFieldStringInput(JTextField text) {
		boolean fieldOk = true;
		
		if(text.getText().equals(null) || text.getText().equals("")) {
			text.setText("erreur");
			fieldOk = false;
		}
		
		if(numericException(text) == false) {
			fieldOk = false;
			text.setText("erreur");
		}
		
		return fieldOk;
	}
	
	private static boolean checkUpJTextFieldIntInput(JTextField text) {
		boolean fieldOk = true;
		
		if(numericException(text) == true) {
			fieldOk = false;
			text.setText("erreur");
		}
		
		return fieldOk;
	}
	
	private static boolean checkUpJRadioButtonInput(JRadioButton JR1, JRadioButton JR2) {
		boolean fieldOk = true;
		
		if(JR1.isSelected() == false && JR2.isSelected() == false) {
			fieldOk = false;
		}
		
		return fieldOk;
	}
	
	private static boolean checkUpJDateChooserDateInput(JDateChooser birthdateField) {
		boolean fieldOk = true;
		
		if(birthdateField.equals(null)) {
			fieldOk = false;
			birthdateField.setDate(new Date());
		}
		
		/*SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormated = formatDate.format(birthdateField.getDate());*/
		
		return fieldOk;
	}
	
	private static boolean numericException(JTextField text) {
		boolean error = false;
		int value;
		
			try {
				value = Integer.parseInt(text.getText()); 
	
				error = false; 
			} catch (NumberFormatException e) {
				
				text.setText("erreur");
				
				error = true; 
			}
		
		return error;
	}

	private static boolean checkUpAvailableEmail(JTextField text) {
		boolean email = false;
		boolean endWith = false;
		int variableTampon = 0;		
		
		String [] lastIndex = {".fr",".com",".net",".intra",".eu",".org",".be",".at",".au",".ca",".ch",".cn",".dk",".de",".gb",
							   ".gp",".hk",".in",".ie",".it",".jp",".kr",".lu",".mq",".mx",".nc",".nl",".nz",".pl",".pt",".ro",
							   ".ru",".us"};
								
				variableTampon = text.getText().indexOf("@");
				
				for(int i = 0; i < lastIndex.length; i++) {
					
					endWith = text.getText().endsWith(lastIndex[i]);
					if(variableTampon > 0 && endWith == true ) 
					{
						email = true;
						break;
					}
				}
		
		return email;
	}
}
