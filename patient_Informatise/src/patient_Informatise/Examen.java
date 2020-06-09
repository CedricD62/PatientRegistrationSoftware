package patient_Informatise;

public class Examen 
{
	
	private String 				typeExamen;
	private String 				dateExamen;
	private Patient 			patient;

	
	public Examen(Patient pPatient, String pTypeExamen, String pDateExamen) {
		
		patient 	= pPatient;
		typeExamen 	= pTypeExamen;
		dateExamen 	= pDateExamen;
	 
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
		return "patient N° : "+patient.getId() +", Examen : "+typeExamen+", date : "+dateExamen;
	}
}
