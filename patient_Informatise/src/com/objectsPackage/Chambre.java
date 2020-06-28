package com.objectsPackage;

import com.filesActions.ReadExternalFiles;
import com.filesActions.WriteInExternalFiles;
import com.functions.RoomFunction;

/**
 * <b>Chambre class is the representation of all Chambre Object of this application</b>
 * </br>
 * @author C.DEBAISIEUX
 * @version 1.0
 *
 */

public class Chambre {

		/**
		 * examination is an Examen object it's informations are given by the user
		 * </br>
		 * @see Chambre#getExamination()
		 * @see Chambre#setExamination(Examen)
		 */
		private Examen	examination;
		/**
		 * entryDate specify from when the Patient will come in the hospital, the date is specified by the user
		 * </br>
		 * @see Chambre#getEntryDate()
		 * @see Chambre#setEntryDate(String)
		 */
		private String 	entryDate;
		/**
		 * releaseDate specify from when the Patient will leave in the hospital, the date is specified by the user
		 * </br>
		 * @see Chambre#getreleaseDate()
		 * @see Chambre#setreleaseDate(String)
		 */
		private String 	releaseDate;
		/**
		 * roomNumber specify the location of the room, the user can choose from the available room
		 * </br>
		 * @see Chambre#getRoomNumber()
		 * @see Chambre#setRoomNumber(int)
		 */
		private int 	roomNumber;
		/**
		 * numberOfBed this value can't be changed by the user, it depends of each rooms
		 * </br>
		 * @see Chambre#getNumberOfBed()
		 * @see Chambre#setNumberOfBed(int)
		 */
		private int 	numberOfBed;
		/**
		 * alone need to be specified by the user to show the available room
		 * </br>
		 * @see Chambre#isAlone()
		 * @see Chambre#setAlone(boolean)
		 */
		private boolean alone;
		/**
		 * accompanying need to be specified by the user to show the available room
		 * </br>
		 * @see Chambre#isAccompanying()
		 * @see Chambre#setAccompanying(boolean)
		 */
		private boolean accompanying;
		/**
		 * available this information can't be change by the user it is automatically updated when a room is booked or not 
		 * </br>
		 * @see Chambre#isAvailable()
		 * @see Chambre#SetAvailable(boolean)
		 */
		private boolean available= true; 
		/**
		 * bookingRoom this information can't be change by the user it is automatically updated when a room is booked or not 
		 * </br>
		 * @see Chambre#isBookingRoom()
		 * @see Chambre#setBookingRoom(boolean)
		 */
		private boolean bookingRoom = false;
		/**
		 * save this information can only be used automatically when the informations are written in files, it changes the toString function of the Chambre object 
		 * </br>
		 * @see Chambre#save
		 * @see Chambre#toString()
		 * @see WriteInExternalFiles#writeRoomFile(java.util.ArrayList)
		 * @see ReadExternalFiles#dispatchInfoFromFiles(javax.swing.JList, javax.swing.JList, javax.swing.JList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, javax.swing.JList)
		 */
		public boolean save = false;
		/**
		 * WITH used in the toString function to specify the status of the Patient  
		 * </br>
		 * @see Chambre#toString()
		 */
		private static final String WITH = "Accompagné";
		/**
		 * WITHOUT used in the toString function to specify the status of the Patient  
		 * </br>
		 * @see Chambre#toString()
		 */
		private static final String WITHOUT = "Sans accompagnement";
		/**
		 * BOOKINGSTATUS used in the toString function to specify the status of the Patient  
		 * </br>
		 * @see Chambre#toString()
		 */
		private static final String BOOKINGSTATUS = "pas de réservation de chambre";

		/**
		 * <b>This is the first constructor of Chambre Object</b>
		 * </br>
		 * @param pEntryDate
		 * @param pReleaseDate
		 * @param pRoomNumber
		 * @param pAlone
		 * @param pAccompanying
		 * @param pAvailable
		 * @param pNumberOfBed
		 * @param pBookingRoom
		 * </br>
		 * @see RoomFunction#creatRoomIfFileIsEmpty(java.util.ArrayList)
		 */
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
		
		/**
		 * <b>This is the second constructor of Chambre class</b>
		 * </br>
		 * This one is used for every interactions with Chambre object
		 * </br>
		 * @param pEntryDate
		 * @param pReleaseDate
		 * @param pRoomNumber
		 * @param pAlone
		 * @param pAccompanying
		 * @param pAvailable
		 * @param pNumberOfBed
		 * @param pBookingRoom
		 * @param pExamination
		 */
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
		
		/**
		 * <b> The toString function for the Chambre object</b>
		 * </br>
		 * The informations displayed are related of the status of the boolean variables
		 * </br>
		 */
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


