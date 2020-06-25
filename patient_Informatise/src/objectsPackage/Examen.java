package objectsPackage;

public class Examen 
{
	private String 	typeExamen;
	private String 	dateExamen;
	private Patient patient;
	private Chambre	room;
	private boolean bookingRoom;
	public boolean save = false;
	
	public Examen(Patient pPatient,Chambre pRoom ,String pTypeExamen, String pDateExamen) {
		
		patient 	= pPatient;
		room 		= pRoom;
		typeExamen 	= pTypeExamen;
		dateExamen 	= pDateExamen; 
	}
	
	public boolean isBookingRoom() {
		return bookingRoom; 
	}
	public void setBookingRoom( boolean pBookingRoom)
	{
		this.bookingRoom = pBookingRoom;
	}
	
	public Chambre getChambre() {
		return room;
	}
	public void setChambre (Chambre pRoom) {
		this.room = pRoom;
	}

	public Patient getPatient() {
		return patient;
	}
	
	public void SetPatient(Patient pPatient) {
		this.patient = pPatient;
	}
	
	public String getTypeExamen() {
		return typeExamen;
	}

	public void setTypeExamen(String pTypeExamen) {
		this.typeExamen = pTypeExamen;
	}

	public String getDateExamen() {
		return dateExamen;
	}

	public void setDateExamen(String pDateExamen) {
		this.dateExamen = pDateExamen;
	}

	@Override
	public String toString() {
		if(save == false) {
			return "patient N° : "+patient.getId() +", Examen : "+typeExamen+", date : "+dateExamen;			
		}else {
			return patient.getId() +","+typeExamen+","+dateExamen+","+bookingRoom;
		}
	}
}
