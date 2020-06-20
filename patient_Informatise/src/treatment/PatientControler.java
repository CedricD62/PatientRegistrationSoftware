package treatment;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import filesActions.ReadExternalFiles;

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
		if(checkUpJTextFieldIntInput(phoneField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailablePhoneNumber(phoneField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldIntInput(cellphoneField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailablePhoneNumber(cellphoneField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldIntInput(idField) == false) {
			fieldOk = false; 
		}
		if(checkUpJTextFieldIntInput(areaCodeField) == false) {
			fieldOk = false; 
		}else {
			if(checkUpAvailableAreaCode(areaCodeField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJTextFieldLongInput(ssnField) == false) {
			fieldOk = false; 
		} else {
			if(checkUpSsnLength(ssnField) == false) {
				fieldOk = false;
			}
		}
		if(checkUpJRadioButtonInput(maleRButton,femaleRButton) == false) {
			fieldOk = false; 
		}
		if(checkUpJDateChooserDateInput(birthdateField) == false) {
			fieldOk = false;
		}
		
		return fieldOk;
	}
	
	private static boolean checkUpJTextFieldStringInput(JTextField text) {
		boolean fieldOk = true;
		
		if(text.getText().equals(null) || text.getText().equals("")) {
			text.setText("erreur");
			fieldOk = false;
		}
		
		if(stringException(text) == false) {
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

	private static boolean checkUpJTextFieldLongInput(JTextField text) {
		boolean fieldOk = true;
		
		if(numericLongException(text) == true) {
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
		boolean fieldOk = false;
		
		try {
			Date date = birthdateField.getDate();
			if(!date.equals(null)) {
				fieldOk = true;
			}
		}catch(NullPointerException n) {
			birthdateField.setDate(new Date());
		}	
		return fieldOk;
	}
	
	private static boolean numericException(JTextField text) {
		boolean error = false;
			try {
				
				int value = Integer.parseInt(text.getText()); 
				error = false; 
				
			} catch (InputMismatchException e) {
				error = true; 
			} catch (NumberFormatException e) {
				error = true; 
			}	
		return error;
	}
	
	private static boolean numericLongException(JTextField text) {
		boolean error = false;
			try {
				long value = Long.parseLong(text.getText()); 
				error = false; 		
			} catch (InputMismatchException e) {		
				error = true; 
			} catch (NumberFormatException e) {
				error = true; 
			}
		return error;
	}
	
	private static boolean stringException(JTextField text) {
		boolean error = false;
			try {	
				int value = Integer.parseInt(text.getText()); 
				error = false; 			
			} catch (NumberFormatException e) {
				error = true; 
			}
		return error;
	}

	private static boolean checkUpAvailableEmail(JTextField text) {
		boolean email = false;
		
		int variableTampon = 0;		
		String mailAddress = text.getText();
		ArrayList<String> lastIndex = ReadExternalFiles.mailEndings();
								
			variableTampon = mailAddress.indexOf("@");
			
			for(int i = 0; i < lastIndex.size(); i++) {
				
				if(variableTampon > 0 && mailAddress.endsWith(lastIndex.get(i)) == true ) {
					email = true;
					break;
				}
			}
			
			if(email == false) {
				text.setText("erreur");
			}
			
		return email;
	}
	
	private static boolean checkUpAvailablePhoneNumber(JTextField text) {
		boolean phoneNumber = false;
		String [] phoneBegin = {"01","02","03","04","05","06","07","09"};	
		String patientPhoneNumber = text.getText();
		
		if(patientPhoneNumber.length() == 10) {
			for(int i = 0; i < phoneBegin.length; i++) {
				if( patientPhoneNumber.startsWith(phoneBegin[i]) == true) {
					phoneNumber = true;
					break;
				}
			}
		}
		
		if(phoneNumber == false) {
			text.setText("erreur");	
		}	
		
		return phoneNumber;
	}
	
	private static boolean checkUpAvailableAreaCode(JTextField text) {
		boolean codeOk = false;
		String patientAreaCode = text.getText();
		
		ArrayList<String> ArrayAreaCode = ReadExternalFiles.areaCode();
									
		for(int i = 0; i < ArrayAreaCode.size(); i++) {
			
			if(ArrayAreaCode.get(i).contentEquals(patientAreaCode)) {
				codeOk = true;
				break;
			}
		}
		
		return codeOk;
	}
	
	private static boolean checkUpSsnLength(JTextField text) {
		boolean ssnLength = false;
		
		String patientSsn = text.getText();
		
		if(patientSsn.length() == 15) {
			ssnLength = true;
		}else {
			text.setText("erreur");
		}	
		
		return ssnLength;
	}
}
