package patient_Informatise;

public class Chambre 
{

	private String 	entryDate;
	private String 	releaseDate;
	private int 	roomNumber;
	private int 	numberOfBed;
	private boolean alone;
	private boolean accompanying;
	private boolean available= true;
	private boolean bookingRoom = false;
	private Examen 	examination;
	private static final String WITH = "Avec";
	private static final String WITHOUT = "Sans";
	private static final String BOOKINGSTATUS = "pas de r�servation de chambre";


	
	public Chambre(String pEntryDate, String pReleaseDate, int pRoomNumber, boolean pAlone, boolean pAccompanying, Examen pExamination, boolean pAvailable, int pNumberOfBed, boolean pBookingRoom) {
	
		this.entryDate 		= pEntryDate;
		this.releaseDate 	= pReleaseDate;
		this.roomNumber 	= pRoomNumber;
		this.alone 			= pAlone;
		this.accompanying 	= pAccompanying;
		this.examination 	= pExamination;
		this.available 		= pAvailable;
		this.numberOfBed	= pNumberOfBed;
		this.bookingRoom 	= pBookingRoom;
	}
	
	public boolean isBookingRoom() {
		return bookingRoom;
	}
	public void setBookingRoom(boolean pBookingRoom) {
		bookingRoom = pBookingRoom;
	}
	
	public boolean isAvailable() {
		return available;
	}	
	public void SetAvailble (boolean pAvailable) {
		available = pAvailable;
	}	
	
	public int getNumberOfBed() {
		return numberOfBed;
	}
	public void setNumberOfBed(int pNumberOfBed) {
		numberOfBed = pNumberOfBed;
	}
	
	public Examen getExamination() {
		return examination;
	}
	public void setExamination(Examen pExamination) {
		examination = pExamination;
	}
	
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String pEntryDate) {
		this.entryDate = pEntryDate;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String pReleaseDate) {
		this.releaseDate = pReleaseDate;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int pRoomNumber) {
		this.roomNumber = pRoomNumber;
	}
	
	public boolean isAlone() {
		return alone;
	}
	public void setAlone(boolean pAlone) {
		this.alone = pAlone;
	}
	
	public boolean isAccompanying() {
		return accompanying;
	}
	public void setAccompanying(boolean pAccompanying) {
		this.accompanying = pAccompanying;
	}


	@Override
	public String toString() {
		
		if(isBookingRoom() == false) {
			return getExamination().getPatient().getId()+", "+ BOOKINGSTATUS;
		}else {
			if(isAvailable() == true) {
				return "Chambre N� : " + roomNumber;
			}else{
				if (isAlone() == true){
					return "Chambre N� : " + roomNumber+", "+ getExamination().getPatient().getName()+", "+ getExamination().getPatient().getFirstName()+
						   ", " + getExamination().getTypeExamen()+", "+ WITHOUT;
				}else {
					return "Chambre N� : " + roomNumber+", "+ getExamination().getPatient().getName()+", "+getExamination().getPatient().getFirstName()+
						   ", "+ getExamination().getTypeExamen()+", "+ WITH;
				}		
			}
		}
	}


	
	
}
