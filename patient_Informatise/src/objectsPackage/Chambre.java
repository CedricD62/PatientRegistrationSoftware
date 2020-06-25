package objectsPackage;

public class Chambre {

		private Examen	examination;
		private String 	entryDate;
		private String 	releaseDate;
		private int 	roomNumber;
		private int 	numberOfBed;
		private boolean alone;
		private boolean accompanying;
		private boolean available= true; 
		private boolean bookingRoom = false;
		public boolean save = false;
		private static final String WITH = "Accompagné";
		private static final String WITHOUT = "Sans accompagnement";
		private static final String BOOKINGSTATUS = "pas de réservation de chambre";

		public Chambre(String pEntryDate, String pReleaseDate, int pRoomNumber, boolean pAlone, boolean pAccompanying, boolean pAvailable, int pNumberOfBed, boolean pBookingRoom) {
		
			this.entryDate 		= pEntryDate;
			this.releaseDate 	= pReleaseDate;
			this.roomNumber 	= pRoomNumber;
			this.alone 			= pAlone;
			this.accompanying 	= pAccompanying;
			this.available 		= pAvailable;
			this.numberOfBed	= pNumberOfBed;
			this.bookingRoom 	= pBookingRoom;
		}
		
		public Chambre(String pEntryDate, String pReleaseDate, int pRoomNumber, boolean pAlone, boolean pAccompanying, boolean pAvailable, int pNumberOfBed, boolean pBookingRoom, Examen pExamination) {
			
			this.entryDate 		= pEntryDate;
			this.releaseDate 	= pReleaseDate;
			this.roomNumber 	= pRoomNumber;
			this.alone 			= pAlone;
			this.accompanying 	= pAccompanying;
			this.available 		= pAvailable;
			this.numberOfBed	= pNumberOfBed;
			this.bookingRoom 	= pBookingRoom;
			this.examination	= pExamination;
		}
		
		public Examen getExamination() {
			return examination;
		}
		public void setExamination (Examen pExamination) {
			examination = pExamination;
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
		public void SetAvailable (boolean pAvailable) {
			available = pAvailable;
		}	
		
		public int getNumberOfBed() {
			return numberOfBed;
		}
		public void setNumberOfBed(int pNumberOfBed) {
			numberOfBed = pNumberOfBed;
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
			if(save == false) {
				if(isBookingRoom() == false) {
					return BOOKINGSTATUS;
				}else {
					if(isAvailable() == true) {
						return "Chambre N° : " + roomNumber;
					}else{
						if (isAlone() == true){
							return "Chambre N° : " + roomNumber+", "+ getExamination().getPatient().getName()+", "+ getExamination().getPatient().getFirstName()+
									", " + getExamination().getTypeExamen()+", "+entryDate+", "+releaseDate+", "+ WITHOUT;
						}else {
							return "Chambre N° : " + roomNumber+", "+ getExamination().getPatient().getName()+", "+getExamination().getPatient().getFirstName()+
									", "+ getExamination().getTypeExamen()+", "+entryDate+", "+releaseDate+", "+ WITH;
						}		
					}
				}
			}else {
				if(isAvailable() == false) {
					if (isAlone() == true){
						return roomNumber+","+getExamination().getPatient().getId()+","+getExamination().getTypeExamen()+","+getExamination().getDateExamen()+","+numberOfBed+","+entryDate+","+releaseDate+","+alone+","+accompanying+","+available+","+bookingRoom;
					}else {
						return roomNumber+","+getExamination().getPatient().getId()+","+getExamination().getTypeExamen()+","+getExamination().getDateExamen()+","+numberOfBed+","+entryDate+","+releaseDate+","+alone+","+accompanying+","+available+","+bookingRoom;
					}		
				}else {
					return ""+roomNumber+","+accompanying+","+alone+","+available+","+bookingRoom+","+entryDate+","+releaseDate+","+numberOfBed; 
				}
			} 
		}
	}


