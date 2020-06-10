package patient_Informatise;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import functions.ExaminationFunction;
import functions.PatientFunction;
import functions.RoomFunction;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class InterfaceEnregistrementPatient {
	
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel patientInformationPanel;
	private JPanel addExaminationPanel;
	private JPanel bookRoomPanel;
	private JPanel staySummaryPanel;
	private JPanel summaryPatientInfoPanel;
	private JPanel summaryBookingRoomPanel;
	private JPanel showPatientPanel;
	private JList patientList;
	private JList examinationList;
	private JList summaryExaminationList;
	private JList switchRoomAndExaminationList;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
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
	private JLabel summaryNameText;
	private JLabel summaryFNameText;
	private JLabel summarySsnText;
	private JLabel summaryCellphoneText;
	private JLabel summaryGenderText;
	private JLabel summaryRoomSectorText;
	private JLabel summaryBedRoomNumberText;
	private JLabel summaryEntryDateText;
	private JLabel summaryReleaseDateText;
	private JLabel birthdateText;
	private JLabel roomReservationText;
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
	private JTextField birthdateField;
	private JTextField searchFiel;
	private JTextField examinationDateField;
	private JTextField patientNumberExamPanelField;
	private JTextField entryDateField;
	private JTextField releaseDateField;
	private JTextField bedRoomNumberField;
	private JTextField patientNumberBookingRoomPanelField;
	private JTextField searchBookingRoomField;
	private JTextField serchExaminationField;
	private JTextField summaryNameField;
	private JTextField summaryFNameField;
	private JTextField summaryCellphoneField;
	private JTextField summarySsnField;
	private JTextField summaryBedRoomNumberField;
	private JTextField summaryEntryDateField;
	private JTextField summaryReleaseDateField;
	private JComboBox examinationTypeSelection;
	private JComboBox LengthOfStaySelectionBox;
	private JComboBox summaryRoomselectionSectorList;
	private JRadioButton maleRButton;
	private JRadioButton femaleRButton;
	private JRadioButton summaryMaleRButton;
	private JRadioButton summaryFemaleRButton;
	private JRadioButton withoutAccompanyingRButton;
	private JRadioButton withAccompangyingRButton;
	private JButton addPatientButton;
	private JButton deletePatientButton;
	private JButton searchPatientListButton;
	private JButton changePatientInfoButton;
	private JButton addExaminationButton;
	private JButton cancelExaminationButton;
	private JButton changeExaminationButton;
	private JButton deleteExaminationButton;
	private JButton searchExaminationListButton;
	private JButton bookingRoomButton;
	private JButton cancelPatientButton;
	private JButton deleteBookingRoomButton;
	private JButton showRoomButton; 
	private JButton searchBookingButtonRoom;
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
		tabbedPane.setBounds(10, 283, 1197, 233);
		frame.getContentPane().add(tabbedPane);
		
		addExaminationPanel = new JPanel();
		tabbedPane.addTab("Ajouter examen", null, addExaminationPanel, null);
		addExaminationPanel.setLayout(null);
		
		patientNumberTextExam = new JLabel("N\u00B0 Patient");
		patientNumberTextExam.setBounds(10, 42, 90, 24);
		addExaminationPanel.add(patientNumberTextExam);
		
		examinationTypeText = new JLabel("Type d'examen");
		examinationTypeText.setBounds(10, 90, 90, 24);
		addExaminationPanel.add(examinationTypeText);
		
		examinationDateText = new JLabel("Date d'examen");
		examinationDateText.setBounds(10, 135, 90, 24);
		addExaminationPanel.add(examinationDateText);
		
		examinationDateField = new JTextField();
		examinationDateField.setColumns(10);
		examinationDateField.setBounds(137, 135, 135, 20);
		addExaminationPanel.add(examinationDateField);
		
		patientNumberExamPanelField = new JTextField();
		patientNumberExamPanelField.setColumns(10);
		patientNumberExamPanelField.setBounds(137, 42, 135, 20);
		addExaminationPanel.add(patientNumberExamPanelField);
		
		examinationTypeSelection = new JComboBox();
		examinationTypeSelection.setModel(new DefaultComboBoxModel(new String[] {"Liste d'examens ", "Arthroscopie", "Alcool\u00E9mie", "Appendicectomie", "Arthroscanner", "Audiogramme", "Avortement", "Bact\u00E9riologique", "Biopsie", 
																				 "C\u00E9sarienne", "Coelioscopie", "ECG", "Endoscopie", "F\u00E9condation in vitro", "Fibroscopie", "IRM", "Mammographie", "Radiographie", "S\u00E9rodiagnostic", 
																				 "Tension art\u00E9rielle ", "Urographie", "Ventriculographie", "Volum\u00E9trique "}));
		examinationTypeSelection.setBounds(137, 90, 135, 20);
		addExaminationPanel.add(examinationTypeSelection);
		
		addExaminationButton = new JButton("Ajouter Examen");
		addExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.creatExamination(examinationList,switchRoomAndExaminationList,arrayPatient,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}
		});
		addExaminationButton.setBounds(321, 43, 136, 23);
		addExaminationPanel.add(addExaminationButton);
		
		changeExaminationButton = new JButton("Modifier Examen");
		changeExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExaminationFunction.changeInfoExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}
		});
		changeExaminationButton.setBounds(324, 136, 136, 23);
		addExaminationPanel.add(changeExaminationButton);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(497, 42, 507, 134);
		addExaminationPanel.add(scrollPane_3);
		
		examinationList = new JList();
		scrollPane_3.setViewportView(examinationList);
		examinationList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ExaminationFunction.showExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}
		});
		
		searchExaminationListButton = new JButton("Rechercher");
		searchExaminationListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.searchExamination(examinationList,arrayExamination,serchExaminationField);
			}
		});
		searchExaminationListButton.setBounds(1014, 11, 110, 23);
		addExaminationPanel.add(searchExaminationListButton);
		
		serchExaminationField = new JTextField();
		serchExaminationField.setColumns(10);
		serchExaminationField.setBounds(497, 11, 507, 20);
		addExaminationPanel.add(serchExaminationField);
		
		cancelExaminationButton = new JButton("Effacer");
		cancelExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.cancelInformationBeforeAddExamination(examinationDateField,patientNumberExamPanelField,examinationTypeSelection);
			}
		});
		cancelExaminationButton.setBounds(324, 91, 136, 23);
		addExaminationPanel.add(cancelExaminationButton);
		
		deleteExaminationButton = new JButton("Supprimer");
		deleteExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.deleteExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}
		});
		deleteExaminationButton.setBounds(1014, 153, 110, 23);
		addExaminationPanel.add(deleteExaminationButton);
		
		bookRoomPanel = new JPanel();
		tabbedPane.addTab("R\u00E9servation chambre", null, bookRoomPanel, null);
		bookRoomPanel.setLayout(null);
		
		lengthOfStayText = new JLabel("dur\u00E9e d'hospitalisation");
		lengthOfStayText.setBounds(10, 140, 123, 20);
		bookRoomPanel.add(lengthOfStayText);
		
		releaseDateText = new JLabel("Date de sortie");
		releaseDateText.setBounds(898, 116, 90, 24);
		bookRoomPanel.add(releaseDateText);
		
		entryDateText = new JLabel("Date d'entr\u00E9e");
		entryDateText.setBounds(898, 81, 90, 24);
		bookRoomPanel.add(entryDateText);
		
		accompanyingText = new JLabel("Accompagnement");
		accompanyingText.setBounds(10, 104, 123, 20);
		bookRoomPanel.add(accompanyingText);
		
		bedRoomNumberText = new JLabel("N\u00B0 de chambre");
		bedRoomNumberText.setBounds(898, 46, 90, 24);
		bookRoomPanel.add(bedRoomNumberText);
		
		bookingRoomPatientNumberText = new JLabel("N\u00B0 Patient");
		bookingRoomPatientNumberText.setBounds(10, 36, 90, 20);
		bookRoomPanel.add(bookingRoomPatientNumberText);
		
		entryDateField = new JTextField();
		entryDateField.setColumns(10);
		entryDateField.setBounds(998, 81, 110, 20);
		bookRoomPanel.add(entryDateField);
		
		releaseDateField = new JTextField();
		releaseDateField.setColumns(10);
		releaseDateField.setBounds(998, 118, 110, 20);
		bookRoomPanel.add(releaseDateField);
		
		bedRoomNumberField = new JTextField();
		bedRoomNumberField.setColumns(10);
		bedRoomNumberField.setBounds(998, 48, 110, 20);
		bookRoomPanel.add(bedRoomNumberField);
		
		patientNumberBookingRoomPanelField = new JTextField();
		patientNumberBookingRoomPanelField.setColumns(10);
		patientNumberBookingRoomPanelField.setBounds(143, 37, 201, 20);
		bookRoomPanel.add(patientNumberBookingRoomPanelField);
		
		withoutAccompanyingRButton = new JRadioButton("Sans");
		withoutAccompanyingRButton.setBounds(259, 105, 62, 24);
		bookRoomPanel.add(withoutAccompanyingRButton);
		
		withAccompangyingRButton = new JRadioButton("Avec");
		withAccompangyingRButton.setBounds(172, 105, 71, 24);
		bookRoomPanel.add(withAccompangyingRButton);
		accompanyingGroup = new ButtonGroup();
		accompanyingGroup.add(withAccompangyingRButton);
		accompanyingGroup.add(withoutAccompanyingRButton);
		
		showRoomButton = new JButton("Afficher Chambres");
		showRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomFunction.updateAvailableRoomFromSelection(switchRoomAndExaminationList,arrayRoom,arrayExamination,arrayPatient,patientNumberBookingRoomPanelField,
															  LengthOfStaySelectionBox,withRoomRButton,withoutAccompanyingRButton,withAccompangyingRButton);
			}
		});
		showRoomButton.setBounds(178, 171, 166, 23);
		bookRoomPanel.add(showRoomButton);		
		
		bookingRoomButton = new JButton("Valider");
		bookingRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomFunction.creatRooom(switchRoomAndExaminationList, arrayRoom, arrayExamination,arrayPatient, entryDateField, releaseDateField,
									    patientNumberBookingRoomPanelField, bedRoomNumberField, withoutRoomRButton);
			}
		});
		bookingRoomButton.setBounds(887, 170, 110, 23);
		bookRoomPanel.add(bookingRoomButton);
		
		deleteBookingRoomButton = new JButton("Annuler");
		deleteBookingRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteBookingRoomButton.setBounds(1018, 171, 110, 23);
		bookRoomPanel.add(deleteBookingRoomButton);	
		
		roomReservationText = new JLabel("Reservation");
		roomReservationText.setBounds(10, 68, 90, 20);
		bookRoomPanel.add(roomReservationText);
		
		
		withRoomRButton = new JRadioButton("Oui");
		withRoomRButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomFunction.ableActionOnJRadio(withoutAccompanyingRButton, LengthOfStaySelectionBox, withAccompangyingRButton, withRoomRButton, bedRoomNumberField, entryDateField, releaseDateField,
												showRoomButton, bookingRoomButton, deleteBookingRoomButton);
			}
		});
		withRoomRButton.setBounds(172, 69, 48, 24);
		bookRoomPanel.add(withRoomRButton);
		
		withoutRoomRButton = new JRadioButton("Non");
		withoutRoomRButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomFunction.disableActionOnJRadio(withoutAccompanyingRButton, LengthOfStaySelectionBox, withAccompangyingRButton, withoutRoomRButton, bedRoomNumberField, 
												   entryDateField, releaseDateField, showRoomButton, bookingRoomButton, deleteBookingRoomButton);
				
			}
		});
		withoutRoomRButton.setBounds(259, 69, 56, 24);
		bookRoomPanel.add(withoutRoomRButton);
		bookingGroup = new ButtonGroup();
		bookingGroup.add(withRoomRButton);
		bookingGroup.add(withoutRoomRButton);
		
		searchBookingRoomField = new JTextField();
		searchBookingRoomField.setBounds(374, 12, 339, 20);
		bookRoomPanel.add(searchBookingRoomField);
		searchBookingRoomField.setColumns(20);
		
		
		searchBookingButtonRoom = new JButton("Rechercher");
		searchBookingButtonRoom.setBounds(721, 11, 111, 23);
		bookRoomPanel.add(searchBookingButtonRoom);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(374, 44, 459, 149);
		bookRoomPanel.add(scrollPane_2);
		
		switchRoomAndExaminationList = new JList();
		scrollPane_2.setViewportView(switchRoomAndExaminationList);
		switchRoomAndExaminationList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomFunction.showInformationRoomAndExamination(switchRoomAndExaminationList, arrayRoom, arrayExamination, patientNumberBookingRoomPanelField, 
															   bedRoomNumberField);
			}
		});
		
				RoomFunction.creatRoomIfFileIsEmpty(switchRoomAndExaminationList, arrayRoom);
				
		LengthOfStaySelectionBox = new JComboBox();
		LengthOfStaySelectionBox.setModel(new DefaultComboBoxModel(new String[] {"courte", "longue"}));
		LengthOfStaySelectionBox.setBounds(143, 139, 201, 20);
		bookRoomPanel.add(LengthOfStaySelectionBox);
		

		staySummaryPanel = new JPanel();
		tabbedPane.addTab("R\u00E9capitulatif du s\u00E9jour", null, staySummaryPanel, null);
		staySummaryPanel.setLayout(null);
		
		summaryPatientInfoPanel = new JPanel();
		summaryPatientInfoPanel.setBounds(10, 11, 343, 178);
		staySummaryPanel.add(summaryPatientInfoPanel);
		summaryPatientInfoPanel.setLayout(null);
		
		summaryBookingRoomPanel = new JPanel();
		summaryBookingRoomPanel.setLayout(null);
		summaryBookingRoomPanel.setBounds(797, 11, 333, 178);
		staySummaryPanel.add(summaryBookingRoomPanel);
		
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
				
				PatientFunction.showPatient(patientList,arrayPatient,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,
											areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField,patientNumberExamPanelField);
			}
		});
		deletePatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idPatient = patientList.getSelectedIndex();
				
				PatientFunction.deletePatient(patientList,arrayPatient,idPatient,idField,genderGroup,nameField,fNameField,addressField,
						areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
				
			}
		});
		searchPatientListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientFunction.searchPatient(patientList, arrayPatient, searchFiel.getText());
			}
		});
		
		nameText = new JLabel("Nom");
		nameText.setBounds(230, 46, 90, 24);
		patientInformationPanel.add(nameText);
		
		fNameText = new JLabel("Pr\u00E9nom");
		fNameText.setBounds(10, 46, 90, 24);
		patientInformationPanel.add(fNameText);
		
		addressText = new JLabel("Adresse");
		addressText.setBounds(10, 81, 90, 24);
		patientInformationPanel.add(addressText);
		
		areaCodeText = new JLabel("Code Postal");
		areaCodeText.setBounds(10, 116, 90, 24);
		patientInformationPanel.add(areaCodeText);
		
		townText = new JLabel("Ville");
		townText.setBounds(10, 151, 90, 24);
		patientInformationPanel.add(townText);
		
		emailText = new JLabel("E-mail");
		emailText.setBounds(10, 186, 90, 24);
		patientInformationPanel.add(emailText);
		
		idPatientText = new JLabel("N\u00B0 Patient");
		idPatientText.setBounds(10, 11, 90, 24); 
		patientInformationPanel.add(idPatientText);
		
		lblNTelephoneFixe = new JLabel("N\u00B0 T\u00E9l\u00E9phone fixe");
		lblNTelephoneFixe.setBounds(230, 81, 118, 24);
		patientInformationPanel.add(lblNTelephoneFixe);
		
		lblNTlphonePortable = new JLabel("N\u00B0 T\u00E9l\u00E9phone portable");
		lblNTlphonePortable.setBounds(230, 116, 125, 24);
		patientInformationPanel.add(lblNTlphonePortable);
		
		ssnNumberField = new JLabel("N\u00B0 S\u00E9curit\u00E9 social");
		ssnNumberField.setBounds(230, 151, 104, 24);
		patientInformationPanel.add(ssnNumberField);
		
		genderText = new JLabel("Sexe");
		genderText.setBounds(230, 11, 90, 24);
		patientInformationPanel.add(genderText);
		
		summaryNameText = new JLabel("Nom");
		summaryNameText.setBounds(10, 11, 53, 14);
		summaryPatientInfoPanel.add(summaryNameText);
		
		summaryFNameText = new JLabel("Pr\u00E9nom");
		summaryFNameText.setBounds(10, 39, 50, 14);
		summaryPatientInfoPanel.add(summaryFNameText);
		
		summarySsnText = new JLabel("N\u00B0 S\u00E9curit\u00E9 social");
		summarySsnText.setBounds(10, 73, 138, 14);
		summaryPatientInfoPanel.add(summarySsnText);
		
		summaryCellphoneText = new JLabel("N\u00B0 T\u00E9l\u00E9phone portable");
		summaryCellphoneText.setBounds(10, 107, 142, 14);
		summaryPatientInfoPanel.add(summaryCellphoneText);
		
		summaryGenderText = new JLabel("Sexe");
		summaryGenderText.setBounds(10, 141, 90, 24);
		summaryPatientInfoPanel.add(summaryGenderText);
		
		summaryRoomSectorText = new JLabel("Service");
		summaryRoomSectorText.setBounds(10, 11, 90, 24);
		summaryBookingRoomPanel.add(summaryRoomSectorText);
		
		summaryBedRoomNumberText = new JLabel("N\u00B0 de chambre");
		summaryBedRoomNumberText.setBounds(10, 46, 90, 24);
		summaryBookingRoomPanel.add(summaryBedRoomNumberText);
		
		summaryEntryDateText = new JLabel("Date d'entr\u00E9e");
		summaryEntryDateText.setBounds(10, 81, 90, 24);
		summaryBookingRoomPanel.add(summaryEntryDateText);
		
		summaryReleaseDateText = new JLabel("Date de sortie");
		summaryReleaseDateText.setBounds(10, 116, 90, 24);
		summaryBookingRoomPanel.add(summaryReleaseDateText);
		
		idField = new JTextField();
		idField.setBounds(110, 13, 104, 20);
		patientInformationPanel.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(367, 45, 104, 20);
		patientInformationPanel.add(nameField);
		
		fNameField = new JTextField();
		fNameField.setColumns(10);
		fNameField.setBounds(110, 48, 104, 20);
		patientInformationPanel.add(fNameField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(110, 83, 104, 20);
		patientInformationPanel.add(addressField);
		
		areaCodeField = new JTextField();
		areaCodeField.setColumns(10);
		areaCodeField.setBounds(110, 118, 104, 20);
		patientInformationPanel.add(areaCodeField);
		
		townField = new JTextField();
		townField.setColumns(10);
		townField.setBounds(110, 153, 104, 20);
		patientInformationPanel.add(townField);
		
		eMailField = new JTextField();
		eMailField.setColumns(10);
		eMailField.setBounds(110, 188, 104, 20);
		patientInformationPanel.add(eMailField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(367, 82, 104, 20);
		patientInformationPanel.add(phoneField);
		
		cellphoneField = new JTextField();
		cellphoneField.setColumns(10);
		cellphoneField.setBounds(367, 117, 104, 20);
		patientInformationPanel.add(cellphoneField);
		
		ssnField = new JTextField();
		ssnField.setColumns(10);
		ssnField.setBounds(367, 152, 104, 20);
		patientInformationPanel.add(ssnField);
		
		summaryNameField = new JTextField();
		summaryNameField.setBounds(151, 11, 173, 20);
		summaryPatientInfoPanel.add(summaryNameField);
		summaryNameField.setColumns(10);
		
		summaryFNameField = new JTextField();
		summaryFNameField.setBounds(151, 42, 173, 20);
		summaryPatientInfoPanel.add(summaryFNameField);
		summaryFNameField.setColumns(10);
		
		summarySsnField = new JTextField();
		summarySsnField.setBounds(151, 73, 173, 20);
		summaryPatientInfoPanel.add(summarySsnField);
		summarySsnField.setColumns(10);
		
		summaryCellphoneField = new JTextField();
		summaryCellphoneField.setBounds(151, 104, 173, 20);
		summaryPatientInfoPanel.add(summaryCellphoneField);
		summaryCellphoneField.setColumns(10);
		
		summaryBedRoomNumberField = new JTextField();
		summaryBedRoomNumberField.setColumns(10);
		summaryBedRoomNumberField.setBounds(110, 48, 201, 20);
		summaryBookingRoomPanel.add(summaryBedRoomNumberField);
		
		summaryEntryDateField = new JTextField();
		summaryEntryDateField.setColumns(10);
		summaryEntryDateField.setBounds(110, 87, 201, 20);
		summaryBookingRoomPanel.add(summaryEntryDateField);
		
		summaryReleaseDateField = new JTextField();
		summaryReleaseDateField.setColumns(10);
		summaryReleaseDateField.setBounds(110, 120, 201, 20);
		summaryBookingRoomPanel.add(summaryReleaseDateField);
		
		summaryRoomselectionSectorList = new JComboBox();
		summaryRoomselectionSectorList.setBounds(110, 11, 201, 20);
		summaryBookingRoomPanel.add(summaryRoomselectionSectorList);
		
		maleRButton = new JRadioButton("Homme");
		maleRButton.setBounds(344, 11, 69, 24);
		patientInformationPanel.add(maleRButton);
		
		femaleRButton = new JRadioButton("Femme");
		femaleRButton.setBounds(415, 11, 69, 24);
		patientInformationPanel.add(femaleRButton);
		
		genderGroup = new ButtonGroup();
		genderGroup.add(maleRButton);
		genderGroup.add(femaleRButton);
		
		summaryMaleRButton = new JRadioButton("Homme");
		summaryMaleRButton.setBounds(155, 141, 90, 24);
		summaryPatientInfoPanel.add(summaryMaleRButton);
		
		summaryFemaleRButton = new JRadioButton("Femme");
		summaryFemaleRButton.setBounds(260, 141, 86, 24);
		summaryPatientInfoPanel.add(summaryFemaleRButton);
		
		summaryGenderGroup = new ButtonGroup();
		summaryGenderGroup.add(summaryMaleRButton);
		summaryGenderGroup.add(summaryFemaleRButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 11, 424, 178);
		staySummaryPanel.add(scrollPane);
		
		summaryExaminationList = new JList();
		scrollPane.setViewportView(summaryExaminationList);
		
		cancelPatientButton = new JButton("Effacer");
		cancelPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientFunction.cancelInformationBeforeAddPatient(idField,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField, genderGroup);
			}
		});
		cancelPatientButton.setBounds(240, 219, 104, 23);
		patientInformationPanel.add(cancelPatientButton);
		
		addPatientButton = new JButton("Ajouter");
		addPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				arrayPatient.add((PatientFunction.creatPatient(idField.getText(),maleRButton.isSelected(), femaleRButton.isSelected(),nameField.getText(),
						          fNameField.getText(),addressField.getText(),areaCodeField.getText(),townField.getText(),ssnField.getText(),eMailField.getText(),
						          phoneField.getText(),cellphoneField.getText(),birthdateField.getText())));
				
				patientList.setListData(arrayPatient.toArray());
			}
		});
		addPatientButton.setBounds(110, 219, 104, 23);
		patientInformationPanel.add(addPatientButton);
		
		birthdateText = new JLabel("Date de naissance");
		birthdateText.setBounds(230, 186, 136, 24);
		patientInformationPanel.add(birthdateText);
		
		birthdateField = new JTextField();
		birthdateField.setColumns(10);
		birthdateField.setBounds(367, 185, 104, 20);
		patientInformationPanel.add(birthdateField);
		
		changePatientInfoButton = new JButton("Modifier");
		changePatientInfoButton.setBounds(367, 218, 104, 23);
		patientInformationPanel.add(changePatientInfoButton);
		changePatientInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientFunction.changeInfoPatient(patientList,arrayPatient,idField.getText(),maleRButton.isSelected(), femaleRButton.isSelected(),
												  nameField.getText(),fNameField.getText(),addressField.getText(),areaCodeField.getText(),townField.getText(),
												  ssnField.getText(),eMailField.getText(),phoneField.getText(),cellphoneField.getText(),birthdateField.getText(),searchFiel);
	
			}
		});
	}
}
