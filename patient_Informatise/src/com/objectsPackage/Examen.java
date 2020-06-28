package com.objectsPackage;

import com.filesActions.ReadExternalFiles;
import com.filesActions.WriteInExternalFiles;
import com.functions.ExaminationFunction;
import com.functions.RoomFunction;

/**
 * <b>Examen class is the representation of all Examen Object of this application</b>
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */
public class Examen 
{
	/**
	 * typeExamen specify the type of examination selected by the user from an available list
	 * </br>
	 * @see Examen#getTypeExamen()
	 * @see Examen#setTypeExamen(String)
	 */
	private String 	typeExamen;
	/**
	 * dateExamen specify the date of the examination, the date is specified by the user
	 * </br>
	 * @see Examen#getDateExamen()
	 * @see Examen#setDateExamen(String)
	 */
	private String 	dateExamen;
	/**
	 * patient specify the patient for who the examination is created, he is choosen from the arrayPatient
	 * </br>
	 * @see Examen#getPatient()
	 * @see Examen#SetPatient(Patient)
	 */
	private Patient patient;
	/**
	 * room specify the room selected if needed this object is null if no room is needed
	 * </br>
	 * @see Examen#getChambre()
	 * @see Examen#setChambre(Chambre)
	 */
	private Chambre	room;
	/**
	 * bookingRoom true if a room has been booked for this examination else false
	 * </br>
	 * @see Examen#isBookingRoom()
	 * @see Examen#setBookingRoom(boolean)
	 */
	private boolean bookingRoom;
	/**
	 * save this information can only be used automatically when the informations are written in files, it changes the toString function of the Examen object 
	 * </br>
	 * @see Examen#save
	 * @see Examen#toString()
	 * @see WriteInExternalFiles#writeExaminationFile(java.util.ArrayList)
	 * @see ReadExternalFiles#dispatchInfoFromFiles(javax.swing.JList, javax.swing.JList, javax.swing.JList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, javax.swing.JList)
	 */
	public boolean save = false;
	
	/**
	 * <b>This is the constructor of Examen Object</b>
	 * </br
	 * @param pPatient
	 * @param pRoom
	 * @param pTypeExamen
	 * @param pDateExamen
		 * </br>
		 * <pre>
		 * @see ExaminationFunction#creatExamination(javax.swing.JList, javax.swing.JList, java.util.ArrayList, java.util.ArrayList,
		 * 											 javax.swing.JTextField, javax.swing.JComboBox, com.toedter.calendar.JDateChooser)
		 * </pre>
		 */
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

	/**
	 * <b> The toString function for the Examen object</b>
	 * </br>
	 * The informations displayed are related of the status of the boolean variables
	 * </br>
	 */
	@Override
	public String toString() {
		if(save == false) {
			return "patient N° : "+patient.getId() +", Examen : "+typeExamen+", date : "+dateExamen;			
		}else {
			return patient.getId() +","+typeExamen+","+dateExamen+","+bookingRoom;
		}
	}
}
