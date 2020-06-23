package objectsPackage;

public class Patient 
{
	private int 				id;
	private String 				name;
	private String 				firstName;
	private String			 	address;
	private int 				cp;
	private String 				city;
	private String 				email;
	private long 				ssn;
	private String 				phone;
	private String 				cellPhone; 
	private String 				birthDate;
	private boolean 			male = false;
	private boolean 			female = false;
	private boolean 			bookingRoom = false;
	public boolean 				save = false;
	private static final String MALE = "Homme";
	private static final String FEMALE = "Femme";
	private static final String BOOKING = "Pas de chambre";
	
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
	public void setMasculin(boolean pMale) {
		this.male = pMale;
	}

	public boolean isFemale() {
		return female;
	}
	public void setFemale(boolean pFemale) {
		this.female = pFemale;
	}

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
