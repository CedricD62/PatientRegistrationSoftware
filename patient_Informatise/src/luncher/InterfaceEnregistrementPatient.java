package luncher;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import functions.DefaultValueLuncher;
import functions.ExaminationFunction;
import functions.ParseFunctions;
import functions.PatientFunction;
import functions.RoomFunction;
import objectsPackage.Chambre;
import objectsPackage.Examen;
import objectsPackage.Patient;
import treatment.RoomControler;

public class InterfaceEnregistrementPatient {
	
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel patientInformationPanel;
	private JPanel addExaminationPanel;
	private JPanel bookRoomPanel;
	private JPanel staySummaryPanel;
	private JPanel showPatientPanel;
	private JList summaryBookingroomList;
	private JList patientList;
	private JList examinationList;
	private JList summaryExaminationList;
	private JList switchRoomAndExaminationList;
	private JList listOfBookedRoom;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane;
	private JLabel nameText;
	private JLabel fNameText;
	private JLabel addressText;
	private JLabel areaCodeText;
	private JLabel townText;
	private JLabel emailText;
	private JLabel idPatientText;
	private JLabel lblNTelephoneFixe;
	private JLabel lblNTlphonePortable;
	private JLabel ssnNumberField;
	private JLabel genderText;
	private JLabel patientNumberTextExam;
	private JLabel examinationTypeText;
	private JLabel examinationDateText;
	private JLabel lengthOfStayText;
	private JLabel releaseDateText;
	private JLabel entryDateText;
	private JLabel accompanyingText;
	private JLabel bedRoomNumberText;
	private JLabel bookingRoomPatientNumberText;
	private JLabel birthdateText;
	private JLabel roomReservationText;
	private JDateChooser examinationDateField;
	private JDateChooser birthDateField;
	private JDateChooser entryDateField;
	private JDateChooser releaseDateField;
	private JTextField idField;
	private JTextField nameField;
	private JTextField fNameField;
	private JTextField addressField;
	private JTextField areaCodeField;
	private JTextField townField;
	private JTextField eMailField;
	private JTextField phoneField;
	private JTextField cellphoneField;
	private JTextField ssnField;
	private JTextField searchFiel;
	private JTextField patientNumberExamPanelField;
	private JTextField bedRoomNumberField;
	private JTextField patientNumberBookingRoomPanelField;
	private JTextField serchExaminationField;
	private JComboBox examinationTypeSelection;
	private JComboBox LengthOfStaySelectionBox;
	private JRadioButton maleRButton;
	private JRadioButton femaleRButton;
	private JRadioButton withoutAccompanyingRButton;
	private JRadioButton withAccompangyingRButton;
	private JButton addPatientButton;
	private JButton deletePatientButton;
	private JButton searchPatientListButton;
	private JButton changePatientInfoButton;
	private JButton addExaminationButton;
	private JButton cancelExaminationButton;
	private JButton changeExaminationButton;
	private JButton deleteBookedRoom;
	private JButton deleteExaminationButton;
	private JButton searchExaminationListButton;
	private JButton bookingRoomButton;
	private JButton cancelPatientButton;
	private JButton cancelRoomDataButton;
	private JButton showRoomButton; 
	private JButton showExaminationBookroomPannelButton;
	private JRadioButton withRoomRButton;
	private JRadioButton withoutRoomRButton;
	private ButtonGroup genderGroup;
	private ButtonGroup accompanyingGroup;
	private ButtonGroup summaryGenderGroup;
	private ButtonGroup bookingGroup;
	
	private ArrayList<Patient>arrayPatient;
	private ArrayList<Chambre>arrayRoom;
	private ArrayList<Examen>arrayExamination;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceEnregistrementPatient window = new InterfaceEnregistrementPatient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	/**
	 * Create the application.
	 */
	public InterfaceEnregistrementPatient() {
		initialize();
 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		arrayPatient 	 = new ArrayList<Patient>();
		arrayExamination = new ArrayList<Examen>();
		arrayRoom 		 = new ArrayList<Chambre>();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1230, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 283, 1197, 254);
		frame.getContentPane().add(tabbedPane);
		
		addExaminationPanel = new JPanel();
		tabbedPane.addTab("Ajouter examen", null, addExaminationPanel, null);
		addExaminationPanel.setLayout(null);
		
		patientNumberTextExam = new JLabel("N\u00B0 Patient");
		patientNumberTextExam.setBounds(10, 54, 90, 24);
		addExaminationPanel.add(patientNumberTextExam);
		
		examinationTypeText = new JLabel("Type d'examen");
		examinationTypeText.setBounds(10, 111, 90, 24);
		addExaminationPanel.add(examinationTypeText);
		
		examinationDateText = new JLabel("Date d'examen");
		examinationDateText.setBounds(10, 165, 90, 24);
		addExaminationPanel.add(examinationDateText);
		
		patientNumberExamPanelField = new JTextField();
		patientNumberExamPanelField.setColumns(10);
		patientNumberExamPanelField.setBounds(137, 54, 135, 20);
		addExaminationPanel.add(patientNumberExamPanelField);
		
		examinationTypeSelection = new JComboBox();
		examinationTypeSelection.setModel(new DefaultComboBoxModel(new String[] {"Liste d'examens ", "Arthroscopie", "Alcool\u00E9mie", "Appendicectomie", "Arthroscanner", "Audiogramme", "Avortement", "Bact\u00E9riologique", "Biopsie", 
																				 "C\u00E9sarienne", "Coelioscopie", "ECG", "Endoscopie", "F\u00E9condation in vitro", "Fibroscopie", "IRM", "Mammographie", "Radiographie", "S\u00E9rodiagnostic", 
																				 "Tension art\u00E9rielle ", "Urographie", "Ventriculographie", "Volum\u00E9trique "}));
		examinationTypeSelection.setBounds(137, 111, 135, 20);
		addExaminationPanel.add(examinationTypeSelection);
		
		addExaminationButton = new JButton("Ajouter Examen");
		addExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.creatExamination(examinationList,switchRoomAndExaminationList,arrayPatient,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,
													 examinationDateField,entryDateField,releaseDateField);
			}});
		addExaminationButton.setBounds(321, 54, 136, 23);
		addExaminationPanel.add(addExaminationButton);
		
		changeExaminationButton = new JButton("Modifier Examen");
		changeExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				ExaminationFunction.changeInfoExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}});
		changeExaminationButton.setBounds(321, 166, 136, 23);
		addExaminationPanel.add(changeExaminationButton);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(497, 54, 507, 134);
		addExaminationPanel.add(scrollPane_3);
		
		examinationList = new JList();
		scrollPane_3.setViewportView(examinationList);
		examinationList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				ExaminationFunction.showExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}});
		searchExaminationListButton = new JButton("Rechercher");
		searchExaminationListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.searchExamination(examinationList,arrayExamination,serchExaminationField);
			}});
		searchExaminationListButton.setBounds(1014, 16, 110, 23);
		addExaminationPanel.add(searchExaminationListButton);
		
		serchExaminationField = new JTextField();
		serchExaminationField.setColumns(10);
		serchExaminationField.setBounds(497, 17, 507, 23);
		addExaminationPanel.add(serchExaminationField);
		
		cancelExaminationButton = new JButton("Effacer");
		cancelExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.cancelInformationBeforeAddExamination(examinationDateField,patientNumberExamPanelField,examinationTypeSelection);
			}});
		cancelExaminationButton.setBounds(321, 111, 136, 23);
		addExaminationPanel.add(cancelExaminationButton);
		
		deleteExaminationButton = new JButton("Supprimer");
		deleteExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.deleteExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,
													  examinationDateField,switchRoomAndExaminationList, listOfBookedRoom);
				}});
		deleteExaminationButton.setBounds(1014, 166, 110, 23);
		addExaminationPanel.add(deleteExaminationButton);
		
		examinationDateField = new JDateChooser();
		examinationDateField.setBounds(137, 169, 135, 20);
		addExaminationPanel.add(examinationDateField);
		accompanyingGroup = new ButtonGroup();
		bookingGroup = new ButtonGroup();
		
		bookRoomPanel = new JPanel();
		tabbedPane.addTab("R\u00E9servation chambre", null, bookRoomPanel, null);
		bookRoomPanel.setLayout(null);
		
		lengthOfStayText = new JLabel("Hospitalisation");
		lengthOfStayText.setBounds(10, 147, 130, 20);
		bookRoomPanel.add(lengthOfStayText);
		
		releaseDateText = new JLabel("Date de sortie");
		releaseDateText.setBounds(655, 127, 90, 24);
		bookRoomPanel.add(releaseDateText);
		
		entryDateText = new JLabel("Date d'entr\u00E9e");
		entryDateText.setBounds(655, 83, 90, 24);
		bookRoomPanel.add(entryDateText);
		
		accompanyingText = new JLabel("Accompagnement");
		accompanyingText.setBounds(10, 105, 123, 20);
		bookRoomPanel.add(accompanyingText);
		
		bedRoomNumberText = new JLabel("N\u00B0 de chambre");
		bedRoomNumberText.setBounds(655, 39, 90, 24);
		bookRoomPanel.add(bedRoomNumberText);
		
		bookingRoomPatientNumberText = new JLabel("N\u00B0 Patient");
		bookingRoomPatientNumberText.setBounds(10, 15, 90, 20);
		bookRoomPanel.add(bookingRoomPatientNumberText);
		
		bedRoomNumberField = new JTextField();
		bedRoomNumberField.setEnabled(false);
		bedRoomNumberField.setColumns(10);
		bedRoomNumberField.setBounds(782, 39, 110, 20);
		bookRoomPanel.add(bedRoomNumberField);
		
		patientNumberBookingRoomPanelField = new JTextField();
		patientNumberBookingRoomPanelField.setEnabled(false);
		patientNumberBookingRoomPanelField.setColumns(10);
		patientNumberBookingRoomPanelField.setBounds(143, 15, 201, 20);
		bookRoomPanel.add(patientNumberBookingRoomPanelField);
		
		withoutAccompanyingRButton = new JRadioButton("Sans");
		withoutAccompanyingRButton.setBounds(259, 105, 62, 24);
		bookRoomPanel.add(withoutAccompanyingRButton);
		
		withAccompangyingRButton = new JRadioButton("Avec");
		withAccompangyingRButton.setBounds(172, 105, 71, 24);
		bookRoomPanel.add(withAccompangyingRButton);
		accompanyingGroup.add(withAccompangyingRButton);
		accompanyingGroup.add(withoutAccompanyingRButton);
		
		showRoomButton = new JButton("Afficher Chambres");
		showRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomFunction.updateListOfAvailableRoom(switchRoomAndExaminationList, arrayRoom, patientNumberBookingRoomPanelField,withRoomRButton, withoutRoomRButton, withAccompangyingRButton, withoutAccompanyingRButton, LengthOfStaySelectionBox);
			}});
		showRoomButton.setBounds(178, 192, 166, 23);
		bookRoomPanel.add(showRoomButton);		
		
		bookingRoomButton = new JButton("Valider");
		bookingRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomFunction.bookingAvailableRoom(switchRoomAndExaminationList, entryDateField, releaseDateField, withoutRoomRButton, arrayExamination, patientNumberBookingRoomPanelField, 
												  withRoomRButton, accompanyingGroup, LengthOfStaySelectionBox, bedRoomNumberField, arrayRoom, listOfBookedRoom,bookingGroup,
												  withAccompangyingRButton,withoutAccompanyingRButton);
			}});
		bookingRoomButton.setBounds(648, 192, 110, 23);
		bookRoomPanel.add(bookingRoomButton);
		
		cancelRoomDataButton = new JButton("Annuler");
		cancelRoomDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomFunction.cancelDataBeforeBookingRoom(switchRoomAndExaminationList,patientNumberBookingRoomPanelField,accompanyingGroup,bookingGroup,LengthOfStaySelectionBox,
														 bedRoomNumberField,entryDateField,releaseDateField);
				}});
		cancelRoomDataButton.setBounds(789, 192, 110, 23);
		bookRoomPanel.add(cancelRoomDataButton);	
		
		roomReservationText = new JLabel("Reservation");
		roomReservationText.setBounds(10, 57, 90, 20);
		bookRoomPanel.add(roomReservationText);
		
		
		withRoomRButton = new JRadioButton("Oui");
		withRoomRButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomControler.ableActionOnJRadio(withoutAccompanyingRButton, LengthOfStaySelectionBox, withAccompangyingRButton, withRoomRButton, bedRoomNumberField, entryDateField,
												 releaseDateField,showRoomButton, bookingRoomButton, cancelRoomDataButton);
			}});
		withRoomRButton.setBounds(172, 57, 48, 24);
		bookRoomPanel.add(withRoomRButton);
		
		withoutRoomRButton = new JRadioButton("Non");
		withoutRoomRButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomControler.disableActionOnJRadio(withoutAccompanyingRButton, LengthOfStaySelectionBox, withAccompangyingRButton, withoutRoomRButton, bedRoomNumberField, 
												   entryDateField, releaseDateField, showRoomButton, bookingRoomButton, cancelRoomDataButton);
			}});
		withoutRoomRButton.setBounds(259, 57, 56, 24);
		bookRoomPanel.add(withoutRoomRButton);
		bookingGroup.add(withRoomRButton);
		bookingGroup.add(withoutRoomRButton);
					
		LengthOfStaySelectionBox = new JComboBox();
		LengthOfStaySelectionBox.setModel(new DefaultComboBoxModel(new String[] {"- choix", "courte", "longue"}));
		LengthOfStaySelectionBox.setBounds(143, 151, 201, 20);
		bookRoomPanel.add(LengthOfStaySelectionBox);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(365, 15, 253, 156);
		bookRoomPanel.add(scrollPane_2);
		
		switchRoomAndExaminationList = new JList();
		scrollPane_2.setViewportView(switchRoomAndExaminationList);
		switchRoomAndExaminationList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomFunction.showInformationRoomAndExamination(switchRoomAndExaminationList, arrayRoom, arrayExamination, patientNumberBookingRoomPanelField, 
															   bedRoomNumberField);
			}});
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(929, 15, 253, 156);
		bookRoomPanel.add(scrollPane_5);
		
		listOfBookedRoom = new JList();
		scrollPane_5.setViewportView(listOfBookedRoom);
		
		staySummaryPanel = new JPanel();
		tabbedPane.addTab("Historique patient", null, staySummaryPanel, null);
		staySummaryPanel.setLayout(null);
		
		patientInformationPanel = new JPanel();
		patientInformationPanel.setBounds(10, 11, 488, 261);
		frame.getContentPane().add(patientInformationPanel);
		patientInformationPanel.setLayout(null);
		
		showPatientPanel = new JPanel();
		showPatientPanel.setBounds(508, 11, 699, 261);
		frame.getContentPane().add(showPatientPanel);
		showPatientPanel.setLayout(null);
		
		searchFiel = new JTextField();
		searchFiel.setBounds(10, 6, 507, 20);
		showPatientPanel.add(searchFiel);
		searchFiel.setColumns(10);
		
		searchPatientListButton = new JButton("Rechercher");
		searchPatientListButton.setBounds(527, 5, 163, 23);
		showPatientPanel.add(searchPatientListButton);
		
		deletePatientButton = new JButton("Supprimer");
		deletePatientButton.setBounds(580, 227, 110, 23);
		showPatientPanel.add(deletePatientButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 39, 675, 177);
		showPatientPanel.add(scrollPane_1);
		
		patientList = new JList();
		scrollPane_1.setViewportView(patientList);
		patientList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientFunction.showPatient(patientList,arrayPatient,arrayExamination,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,townField,
											ssnField,eMailField,phoneField,cellphoneField,birthDateField,patientNumberExamPanelField,summaryExaminationList,summaryBookingroomList);
			}});
		deletePatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientFunction.deletePatient(patientList,arrayPatient,idField,genderGroup,nameField,fNameField,addressField,
											  areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthDateField);				
			}});
		searchPatientListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientFunction.searchPatient(patientList, arrayPatient, searchFiel.getText());
			}});
		nameText = new JLabel("Nom");
		nameText.setBounds(234, 11, 90, 24);
		patientInformationPanel.add(nameText);
		
		fNameText = new JLabel("Pr\u00E9nom");
		fNameText.setBounds(10, 46, 90, 24);
		patientInformationPanel.add(fNameText);
		
		addressText = new JLabel("Adresse");
		addressText.setBounds(234, 46, 90, 24);
		patientInformationPanel.add(addressText);
		
		areaCodeText = new JLabel("Code Postal");
		areaCodeText.setBounds(10, 81, 90, 24);
		patientInformationPanel.add(areaCodeText);
		
		townText = new JLabel("Ville");
		townText.setBounds(234, 81, 90, 24);
		patientInformationPanel.add(townText);
		
		emailText = new JLabel("E-mail");
		emailText.setBounds(10, 151, 90, 24);
		patientInformationPanel.add(emailText);
		
		idPatientText = new JLabel("N\u00B0 Patient");
		idPatientText.setBounds(10, 11, 90, 24); 
		patientInformationPanel.add(idPatientText);
		
		lblNTelephoneFixe = new JLabel("T\u00E9l\u00E9phone fixe");
		lblNTelephoneFixe.setBounds(10, 116, 118, 24);
		patientInformationPanel.add(lblNTelephoneFixe);
		
		lblNTlphonePortable = new JLabel("T\u00E9l\u00E9phone portable");
		lblNTlphonePortable.setBounds(234, 116, 134, 24);
		patientInformationPanel.add(lblNTlphonePortable);
		
		ssnNumberField = new JLabel("N\u00B0 S\u00E9curit\u00E9 social");
		ssnNumberField.setBounds(10, 184, 104, 24);
		patientInformationPanel.add(ssnNumberField);
		
		idField = new JTextField();
		idField.setBounds(120, 13, 104, 20);
		patientInformationPanel.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(367, 10, 104, 20);
		patientInformationPanel.add(nameField);
		
		fNameField = new JTextField();
		fNameField.setColumns(10);
		fNameField.setBounds(120, 48, 104, 20);
		patientInformationPanel.add(fNameField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(367, 48, 104, 20);
		patientInformationPanel.add(addressField);
		
		areaCodeField = new JTextField();
		areaCodeField.setColumns(10);
		areaCodeField.setBounds(120, 83, 104, 20);
		patientInformationPanel.add(areaCodeField);
		
		townField = new JTextField();
		townField.setColumns(10);
		townField.setBounds(367, 83, 104, 20);
		patientInformationPanel.add(townField);
		
		eMailField = new JTextField();
		eMailField.setColumns(10);
		eMailField.setBounds(120, 153, 104, 20);
		patientInformationPanel.add(eMailField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(120, 118, 104, 20);
		patientInformationPanel.add(phoneField);
		
		cellphoneField = new JTextField();
		cellphoneField.setColumns(10);
		cellphoneField.setBounds(367, 117, 104, 20);
		patientInformationPanel.add(cellphoneField);
		
		ssnField = new JTextField();
		ssnField.setColumns(10);
		ssnField.setBounds(120, 186, 104, 20);
		patientInformationPanel.add(ssnField);
		
		genderGroup = new ButtonGroup();
		
		summaryGenderGroup = new ButtonGroup();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 582, 183);
		staySummaryPanel.add(scrollPane);
		
		summaryExaminationList = new JList();
		scrollPane.setViewportView(summaryExaminationList);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(600, 11, 582, 183);
		staySummaryPanel.add(scrollPane_4);
		
		summaryBookingroomList = new JList();
		scrollPane_4.setViewportView(summaryBookingroomList);
		
		cancelPatientButton = new JButton("Effacer");
		cancelPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				PatientFunction.cancelInformationBeforeAddPatient(idField,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,
																  birthDateField,genderGroup);
			}});
		cancelPatientButton.setBounds(242, 219, 104, 23);
		patientInformationPanel.add(cancelPatientButton);
		
		addPatientButton = new JButton("Ajouter");
		addPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				PatientFunction.creatPatient(patientList,arrayPatient,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,
											townField,ssnField,eMailField,phoneField,cellphoneField,birthDateField,genderGroup,examinationDateField);
			}});
		addPatientButton.setBounds(120, 219, 104, 23);
		patientInformationPanel.add(addPatientButton);
		
		birthdateText = new JLabel("Date de naissance");
		birthdateText.setBounds(234, 151, 118, 24);
		patientInformationPanel.add(birthdateText);
		
		changePatientInfoButton = new JButton("Modifier");
		changePatientInfoButton.setBounds(367, 219, 104, 23);
		patientInformationPanel.add(changePatientInfoButton);
		
		genderText = new JLabel("Sexe");
		genderText.setBounds(234, 184, 55, 24);
		patientInformationPanel.add(genderText);
		
		maleRButton = new JRadioButton("Homme");
		maleRButton.setBounds(342, 184, 69, 24);
		patientInformationPanel.add(maleRButton);
		genderGroup.add(maleRButton);
		
		femaleRButton = new JRadioButton("Femme");
		femaleRButton.setBounds(413, 184, 69, 24);
		patientInformationPanel.add(femaleRButton);
		genderGroup.add(femaleRButton);
		
		birthDateField = new JDateChooser();
		birthDateField.setBounds(367, 151, 104, 20);
		patientInformationPanel.add(birthDateField);
		changePatientInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				PatientFunction.changeInfoPatient(patientList,arrayPatient,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,areaCodeField,
												  townField,ssnField,eMailField,phoneField,cellphoneField,birthDateField);
			}});
		deleteBookedRoom = new JButton("Supprimer");
		deleteBookedRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				RoomFunction.deleteBookedRoom(switchRoomAndExaminationList, listOfBookedRoom, arrayExamination, arrayRoom);
			}});
		deleteBookedRoom.setBounds(1072, 192, 110, 23);
		bookRoomPanel.add(deleteBookedRoom);
		
		entryDateField = new JDateChooser();
		entryDateField.setBounds(782, 83, 110, 20);
		bookRoomPanel.add(entryDateField);
		
		releaseDateField = new JDateChooser();
		releaseDateField.setBounds(783, 131, 110, 20);
		bookRoomPanel.add(releaseDateField);
		
		RoomFunction.creatRoomIfFileIsEmpty(switchRoomAndExaminationList, arrayRoom);
		DefaultValueLuncher.setDefaultRangeForBirthdate(birthDateField);
	}
}
