package com.objectsPackage;

import com.filesActions.ReadExternalFiles;
import com.filesActions.WriteInExternalFiles;
import com.functions.ExaminationFunction;
import com.functions.PatientFunction;

/**
 * <b>Patient class is the representation of all Patient Object of this application</b>
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class Patient 
{
	/**
	 * id specify the id of the Patient for the moment writting manually but will be improve to be set automatically
	 * </br>
	 * @see Patient#getId()
	 * @see Patient#setId(int)
	 */
	private int id;
	/**
	 * the name of the patient
	 * </br>
	 * @see Patient#getName()
	 * @see Patient#setName(String)
	 */
	private String name;
	/**
	 * the first Name of the patient
	 * </br>
	 * @see Patient#getFirstName()
	 * @see Patient#setFirstName(String)
	 */
	private String firstName;
	/**
	 * the address of the patient
	 * </br>
	 * @see Patient#getAddress()
	 * @see Patient#setAddress(String)
	 */
	private String address;
	/**
	 * the area code of the patient
	 * </br>
	 * @see Patient#getCp()
	 * @see Patient#setCp(int)
	 */
	private int cp;
	/**
	 * the city of the patient
	 * </br>
	 * @see Patient#getCity()
	 * @see Patient#setCity(String)
	 */
	private String city;
	/**
	 * the email address of the patient
	 * </br>
	 * @see Patient#getEmail()
	 * @see Patient#setEmail(String)
	 */
	private String email;
	/**
	 * the social security number of the patient
	 * </br>
	 * @see Patient#getSsn()
	 * @see Patient#setSsn(long)
	 */
	private long ssn;
	/**
	 * the phone number of the patient
	 * </br>
	 * @see Patient#getPhone()
	 * @see Patient#setPhone(String)
	 */
	private String phone;
	/**
	 * the cellPhone number of the patient
	 * </br>
	 * @see Patient#getCellPhone()
	 * @see Patient#setCellPhone(String)
	 */
	private String cellPhone; 
	/**
	 * the birthDate of the patient
	 * </br>
	 * @see Patient#getBirthDate()
	 * @see Patient#setBirthDate(String)
	 */
	private String birthDate;
	/**
	 * the gender of the patient male is set on true if the Patient is a male else set on false 
	 * </br>
	 * @see Patient#isMale()
	 * @see Patient#setMale(boolean)
	 */
	private boolean male = false;
	/**
	 * the gender of the patient female is set on true if the Patient is a female else set on false 
	 * </br>
	 * @see Patient#isFemale()
	 * @see Patient#setFemale(boolean)
	 */
	private boolean female = false;
	/**
	 * if a room is booked the boolean bookingRoom is set on true else false 
	 * </br>
	 * @see Patient#isBookingRoom()
	 * @see Patient#setBookingRoom(boolean)
	 */
	private boolean bookingRoom = false;
	/**
	 * save this information can only be used automatically when the informations are written in files, it changes the toString function of the Patient object 
	 * </br>
	 * @see Patient#save
	 * @see Patient#toString()
	 * @see WriteInExternalFiles#writePatientFile(java.util.ArrayList)
	 * @see ReadExternalFiles#dispatchInfoFromFiles(javax.swing.JList, javax.swing.JList, javax.swing.JList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, javax.swing.JList)
	 */
	public boolean save = false;
	/**
	 * the constant MALE is used in toString function if the Patient is a male 
	 * </br>
	 * @see Patient#toString()
	 */
	private static final String MALE = "Homme";
	/**
	 * the constant FEMALE is used in toString function if the Patient is a FEMALE 
	 * </br>
	 * @see Patient#toString()
	 */
	private static final String FEMALE = "Femme";
	/**
	 * the constant BOOKING is used in toString function if no room has been booked 
	 * </br>
	 * @see Patient#toString()
	 */
	private static final String BOOKING = "Pas de chambre";
	
	/**
	 * <b>This is the constructor of Patient Object</b>
	 * </br
	 * @param pId
	 * @param pMale
	 * @param pFemale
	 * @param pName
	 * @param pFirstName
	 * @param pAddress
	 * @param pCp
	 * @param pCity
	 * @param pEmail
	 * @param pSsn
	 * @param pPhone
	 * @param pCellPhone
	 * @param pBirthDate
	 * @param pBookingRoom
		 * </br>
		 * <pre>
		 * @see PatientFunction#creatPatient(javax.swing.JList, java.util.ArrayList, javax.swing.JTextField, javax.swing.JRadioButton, javax.swing.JRadioButton, 
		 * 									 javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, 
		 * 									 javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, 
		 * 									 com.toedter.calendar.JDateChooser, javax.swing.ButtonGroup, com.toedter.calendar.JDateChooser)
		 * </pre>
		 */
	public Patient(int pId,boolean pMale,boolean pFemale,String pName,String pFirstName,String pAddress,int pCp,String pCity,String pEmail, 
			long pSsn,String pPhone,String pCellPhone,String pBirthDate, boolean pBookingRoom) {		
			id 			= pId;
			male 		= pMale;
			female 		= pFemale;
			name 		= pName;
			firstName 	= pFirstName;
			address	 	= pAddress;
			cp 			= pCp;
			city 		= pCity;
			email 		= pEmail;
			ssn 		= pSsn;
			phone 		= pPhone;
			cellPhone 	= pCellPhone;
			birthDate 	= pBirthDate;	
			male 		= pMale;
			female 		= pFemale;
			bookingRoom = pBookingRoom;
	}
	
	public boolean isBookingRoom() {
		return bookingRoom;
	}
	public void setBookingRoom(boolean pBookingRoom) {
		this.bookingRoom = pBookingRoom;
	}
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		this.name = pName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String pFirstName) {
		this.firstName = pFirstName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String pAddress) {
		this.address = pAddress;
	}
	
	public int getCp() {
		return cp;
	}
	public void setCp(int pCp) {
		this.cp = pCp;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String pCity) {
		this.city = pCity;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String pEmail) {
		this.email = pEmail;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long pSsn) {
		this.ssn = pSsn;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String pBirthDate) {
		this.birthDate = pBirthDate;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String pPhone) {
		this.phone = pPhone;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String pCellPhone) {
		this.cellPhone = pCellPhone;
	}
	
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean pMale) {
		this.male = pMale;
	}

	public boolean isFemale() {
		return female;
	}
	public void setFemale(boolean pFemale) {
		this.female = pFemale;
	}

	/**
	 * <b> The toString function for the Patient object</b>
	 * </br>
	 * The informations displayed are related of the status of the boolean variables
	 * </br>
	 */
	@Override
	public String toString() {
		if(save == false) {
			if(isMale() == true) {
				return "Patient : "+id+", "+name+", "+firstName+", "+address+", "+cp+", "+city+", "+email+", "+ssn+", "+phone+", "+cellPhone+", "+birthDate+ ", "+MALE;
			}else {
				return "Patient : "+id+", "+name+", "+firstName+", "+address+", "+cp+", "+city+", "+email+", "+ssn+", "+phone+", "+cellPhone+", "+birthDate+ ", "+FEMALE;
			}
		}else {
			return id+","+name+","+firstName+","+address+","+cp+","+city+","+email+","+ssn+","+phone+","+cellPhone+","+birthDate+","+male+","+female+","+bookingRoom;
		}
		
	}
}
