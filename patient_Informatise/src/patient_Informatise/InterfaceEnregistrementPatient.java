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
	private JScrollPane scrollPane;
	private JList patientList;
	private JList examinationList;
	private JList summaryExaminationList;
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
	private JTextField serchExaminationField;
	private JTextField summaryNameField;
	private JTextField summaryFNameField;
	private JTextField summaryCellphoneField;
	private JTextField summarySsnField;
	private JTextField summaryBedRoomNumberField;
	private JTextField summaryEntryDateField;
	private JTextField summaryReleaseDateField;
	private JComboBox examinationTypeSelection;
	private JComboBox lengthOfStaySelectionList;
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
	private JRadioButton withRoomRButton;
	private JRadioButton withoutRoomRButton;
	private ButtonGroup genderGroup;
	private ButtonGroup accompanyingGroup;
	private ButtonGroup summaryGenderGroup;
	private ButtonGroup bookingGroup;
	
	private ArrayList<Patient>arrayPatient;
	private ArrayList<Chambre>arrayRoom;
	private ArrayList<Examen>arrayExamination;
	private JTextField searchBookingRoomField;
	
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
		frame.setBounds(100, 100, 1500, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(39, 491, 1411, 327);
		frame.getContentPane().add(tabbedPane);
		
		addExaminationPanel = new JPanel();
		tabbedPane.addTab("Ajouter examen", null, addExaminationPanel, null);
		addExaminationPanel.setLayout(null);
		
		patientNumberTextExam = new JLabel("N\u00B0 Patient");
		patientNumberTextExam.setBounds(60, 72, 90, 24);
		addExaminationPanel.add(patientNumberTextExam);
		
		examinationTypeText = new JLabel("Type d'examen");
		examinationTypeText.setBounds(60, 135, 90, 24);
		addExaminationPanel.add(examinationTypeText);
		
		examinationDateText = new JLabel("Date d'examen");
		examinationDateText.setBounds(60, 202, 90, 24);
		addExaminationPanel.add(examinationDateText);
		
		accompanyingGroup = new ButtonGroup();
		
		bookingGroup = new ButtonGroup();
		
		bookRoomPanel = new JPanel();
		tabbedPane.addTab("R\u00E9servation chambre", null, bookRoomPanel, null);
		bookRoomPanel.setLayout(null);
		
		lengthOfStayText = new JLabel("dur\u00E9e d'hospitalisation");
		lengthOfStayText.setBounds(10, 135, 150, 20);
		bookRoomPanel.add(lengthOfStayText);
		
		releaseDateText = new JLabel("Date de sortie");
		releaseDateText.setBounds(865, 141, 90, 24);
		bookRoomPanel.add(releaseDateText);
		
		entryDateText = new JLabel("Date d'entr\u00E9e");
		entryDateText.setBounds(865, 92, 90, 24);
		bookRoomPanel.add(entryDateText);
		
		accompanyingText = new JLabel("Accompagnement");
		accompanyingText.setBounds(10, 181, 123, 20);
		bookRoomPanel.add(accompanyingText);
		
		bedRoomNumberText = new JLabel("N\u00B0 de chambre");
		bedRoomNumberText.setBounds(865, 46, 90, 24);
		bookRoomPanel.add(bedRoomNumberText);
		
		bookingRoomPatientNumberText = new JLabel("N\u00B0 Patient");
		bookingRoomPatientNumberText.setBounds(10, 40, 90, 20);
		bookRoomPanel.add(bookingRoomPatientNumberText);
		
		entryDateField = new JTextField();
		entryDateField.setColumns(10);
		entryDateField.setBounds(1018, 98, 110, 20);
		bookRoomPanel.add(entryDateField);
		
		releaseDateField = new JTextField();
		releaseDateField.setColumns(10);
		releaseDateField.setBounds(1018, 145, 110, 20);
		bookRoomPanel.add(releaseDateField);
		
		bedRoomNumberField = new JTextField();
		bedRoomNumberField.setColumns(10);
		bedRoomNumberField.setBounds(1018, 50, 110, 20);
		bookRoomPanel.add(bedRoomNumberField);
		
		patientNumberBookingRoomPanelField = new JTextField();
		patientNumberBookingRoomPanelField.setColumns(10);
		patientNumberBookingRoomPanelField.setBounds(170, 40, 201, 20);
		bookRoomPanel.add(patientNumberBookingRoomPanelField);
		
		lengthOfStaySelectionList = new JComboBox();
		lengthOfStaySelectionList.setModel(new DefaultComboBoxModel(new String[] {"courte ", "longue"}));
		lengthOfStaySelectionList.setBounds(170, 135, 201, 20);
		bookRoomPanel.add(lengthOfStaySelectionList);
		
		withoutAccompanyingRButton = new JRadioButton("Sans");
		withoutAccompanyingRButton.setBounds(286, 181, 62, 24);
		bookRoomPanel.add(withoutAccompanyingRButton);
		
		withAccompangyingRButton = new JRadioButton("Avec");
		withAccompangyingRButton.setBounds(199, 181, 71, 24);
		bookRoomPanel.add(withAccompangyingRButton);
		accompanyingGroup.add(withAccompangyingRButton);
		accompanyingGroup.add(withoutAccompanyingRButton);
		
		showRoomButton = new JButton("Afficher Chambres");
		showRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		showRoomButton.setBounds(170, 240, 201, 48);
		bookRoomPanel.add(showRoomButton);		
		
		bookingRoomButton = new JButton("Valider");
		bookingRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bookingRoomButton.setBounds(1178, 43, 166, 48);
		bookRoomPanel.add(bookingRoomButton);
		
		deleteBookingRoomButton = new JButton("Annuler");
		deleteBookingRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteBookingRoomButton.setBounds(1178, 117, 166, 48);
		bookRoomPanel.add(deleteBookingRoomButton);	
		
		roomReservationText = new JLabel("Reservation");
		roomReservationText.setBounds(10, 86, 90, 20);
		bookRoomPanel.add(roomReservationText);
		
		
		withRoomRButton = new JRadioButton("Oui");
		withRoomRButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomFunction.ableActionOnJRadio(withoutAccompanyingRButton, lengthOfStaySelectionList, withAccompangyingRButton, withRoomRButton, bedRoomNumberField, entryDateField, releaseDateField, showRoomButton, bookingRoomButton, deleteBookingRoomButton);
			}
		});
		withRoomRButton.setBounds(199, 86, 48, 24);
		bookRoomPanel.add(withRoomRButton);
		
		withoutRoomRButton = new JRadioButton("Non");
		withoutRoomRButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RoomFunction.disableActionOnJRadio(withoutAccompanyingRButton, lengthOfStaySelectionList, withAccompangyingRButton, withoutRoomRButton, bedRoomNumberField, 
												   entryDateField, releaseDateField, showRoomButton, bookingRoomButton, deleteBookingRoomButton);
				
			}
		});
		withoutRoomRButton.setBounds(286, 86, 56, 24);
		bookRoomPanel.add(withoutRoomRButton);
		bookingGroup.add(withRoomRButton);
		bookingGroup.add(withoutRoomRButton);
		
		searchBookingRoomField = new JTextField();
		searchBookingRoomField.setBounds(381, 11, 352, 20);
		bookRoomPanel.add(searchBookingRoomField);
		searchBookingRoomField.setColumns(10);
		
		JList switchRoomAndExaminationList = new JList();
		switchRoomAndExaminationList.setBounds(391, 40, 463, 248);
		bookRoomPanel.add(switchRoomAndExaminationList);
		
		JButton searchBookingButtonRoom = new JButton("Rechercher");
		searchBookingButtonRoom.setBounds(743, 10, 111, 23);
		bookRoomPanel.add(searchBookingButtonRoom);
		
		RoomFunction.creatRoomIfFileIsEmpty(switchRoomAndExaminationList, arrayRoom);

		staySummaryPanel = new JPanel();
		tabbedPane.addTab("R\u00E9capitulatif du s\u00E9jour", null, staySummaryPanel, null);
		staySummaryPanel.setLayout(null);
		
		summaryPatientInfoPanel = new JPanel();
		summaryPatientInfoPanel.setBounds(10, 28, 424, 242);
		staySummaryPanel.add(summaryPatientInfoPanel);
		summaryPatientInfoPanel.setLayout(null);
		
		summaryBookingRoomPanel = new JPanel();
		summaryBookingRoomPanel.setLayout(null);
		summaryBookingRoomPanel.setBounds(972, 28, 424, 242);
		staySummaryPanel.add(summaryBookingRoomPanel);
		
		examinationDateField = new JTextField();
		examinationDateField.setColumns(10);
		examinationDateField.setBounds(160, 204, 201, 20);
		addExaminationPanel.add(examinationDateField);
		
		patientNumberExamPanelField = new JTextField();
		patientNumberExamPanelField.setColumns(10);
		patientNumberExamPanelField.setBounds(160, 74, 201, 20);
		addExaminationPanel.add(patientNumberExamPanelField);
		
		examinationTypeSelection = new JComboBox();
		examinationTypeSelection.setModel(new DefaultComboBoxModel(new String[] {"Liste d'examens ", "Arthroscopie", "Alcool\u00E9mie", "Appendicectomie", "Arthroscanner", "Audiogramme", "Avortement", "Bact\u00E9riologique", "Biopsie", 
																				 "C\u00E9sarienne", "Coelioscopie", "ECG", "Endoscopie", "F\u00E9condation in vitro", "Fibroscopie", "IRM", "Mammographie", "Radiographie", "S\u00E9rodiagnostic", 
																				 "Tension art\u00E9rielle ", "Urographie", "Ventriculographie", "Volum\u00E9trique "}));
		examinationTypeSelection.setBounds(160, 137, 201, 20);
		addExaminationPanel.add(examinationTypeSelection);
		
		addExaminationButton = new JButton("Ajouter Examen");
		addExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.creatExamination(examinationList,arrayPatient,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}
		});
		addExaminationButton.setBounds(395, 56, 142, 47);
		addExaminationPanel.add(addExaminationButton);
		
		changeExaminationButton = new JButton("Modifier Examen");
		changeExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExaminationFunction.changeInfoExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}
		});
		changeExaminationButton.setBounds(395, 191, 142, 47);
		addExaminationPanel.add(changeExaminationButton);
		
		examinationList = new JList();
		examinationList.setBounds(653, 56, 507, 182);
		addExaminationPanel.add(examinationList);
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
		searchExaminationListButton.setBounds(1189, 11, 163, 23);
		addExaminationPanel.add(searchExaminationListButton);
		
		serchExaminationField = new JTextField();
		serchExaminationField.setColumns(10);
		serchExaminationField.setBounds(653, 12, 507, 20);
		addExaminationPanel.add(serchExaminationField);
		
		cancelExaminationButton = new JButton("Effacer");
		cancelExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.cancelInformationBeforeAddExamination(examinationDateField,patientNumberExamPanelField,examinationTypeSelection);
			}
		});
		cancelExaminationButton.setBounds(395, 124, 142, 47);
		addExaminationPanel.add(cancelExaminationButton);
		
		deleteExaminationButton = new JButton("Supprimer");
		deleteExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExaminationFunction.deleteExamination(examinationList,arrayExamination,patientNumberExamPanelField,examinationTypeSelection,examinationDateField);
			}
		});
		deleteExaminationButton.setBounds(1189, 268, 163, 20);
		addExaminationPanel.add(deleteExaminationButton);
		
		patientInformationPanel = new JPanel();
		patientInformationPanel.setBounds(39, 80, 684, 362);
		frame.getContentPane().add(patientInformationPanel);
		patientInformationPanel.setLayout(null);
		
		showPatientPanel = new JPanel();
		showPatientPanel.setBounds(751, 66, 699, 362);
		frame.getContentPane().add(showPatientPanel);
		showPatientPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 679, 340);
		showPatientPanel.add(scrollPane);
		
		patientList = new JList();
		scrollPane.setViewportView(patientList);
		patientList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PatientFunction.showPatient(patientList,arrayPatient,idField,maleRButton,femaleRButton,nameField,fNameField,addressField,
											areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField,patientNumberExamPanelField);
			}
		});
		
		nameText = new JLabel("Nom");
		nameText.setBounds(20, 68, 90, 24);
		patientInformationPanel.add(nameText);
		
		fNameText = new JLabel("Pr\u00E9nom");
		fNameText.setBounds(20, 103, 90, 24);
		patientInformationPanel.add(fNameText);
		
		addressText = new JLabel("Adresse");
		addressText.setBounds(20, 138, 90, 24);
		patientInformationPanel.add(addressText);
		
		areaCodeText = new JLabel("Code Postal");
		areaCodeText.setBounds(20, 173, 90, 24);
		patientInformationPanel.add(areaCodeText);
		
		townText = new JLabel("Ville");
		townText.setBounds(20, 208, 90, 24);
		patientInformationPanel.add(townText);
		
		emailText = new JLabel("E-mail");
		emailText.setBounds(20, 243, 90, 24);
		patientInformationPanel.add(emailText);
		
		idPatientText = new JLabel("N\u00B0 Patient");
		idPatientText.setBounds(20, 36, 90, 24); 
		patientInformationPanel.add(idPatientText);
		
		lblNTelephoneFixe = new JLabel("N\u00B0 T\u00E9l\u00E9phone fixe");
		lblNTelephoneFixe.setBounds(331, 68, 156, 24);
		patientInformationPanel.add(lblNTelephoneFixe);
		
		lblNTlphonePortable = new JLabel("N\u00B0 T\u00E9l\u00E9phone portable");
		lblNTlphonePortable.setBounds(331, 103, 156, 24);
		patientInformationPanel.add(lblNTlphonePortable);
		
		ssnNumberField = new JLabel("N\u00B0 S\u00E9curit\u00E9 social");
		ssnNumberField.setBounds(331, 138, 156, 24);
		patientInformationPanel.add(ssnNumberField);
		
		genderText = new JLabel("Sexe");
		genderText.setBounds(20, 272, 90, 24);
		patientInformationPanel.add(genderText);
		
		summaryNameText = new JLabel("Nom");
		summaryNameText.setBounds(27, 39, 53, 14);
		summaryPatientInfoPanel.add(summaryNameText);
		
		summaryFNameText = new JLabel("Pr\u00E9nom");
		summaryFNameText.setBounds(27, 67, 37, 14);
		summaryPatientInfoPanel.add(summaryFNameText);
		
		summarySsnText = new JLabel("N\u00B0 S\u00E9curit\u00E9 social");
		summarySsnText.setBounds(27, 101, 86, 14);
		summaryPatientInfoPanel.add(summarySsnText);
		
		summaryCellphoneText = new JLabel("N\u00B0 T\u00E9l\u00E9phone portable");
		summaryCellphoneText.setBounds(27, 135, 110, 14);
		summaryPatientInfoPanel.add(summaryCellphoneText);
		
		summaryGenderText = new JLabel("Sexe");
		summaryGenderText.setBounds(27, 169, 90, 24);
		summaryPatientInfoPanel.add(summaryGenderText);
		
		summaryRoomSectorText = new JLabel("Service");
		summaryRoomSectorText.setBounds(54, 39, 90, 24);
		summaryBookingRoomPanel.add(summaryRoomSectorText);
		
		summaryBedRoomNumberText = new JLabel("N\u00B0 de chambre");
		summaryBedRoomNumberText.setBounds(54, 88, 90, 24);
		summaryBookingRoomPanel.add(summaryBedRoomNumberText);
		
		summaryEntryDateText = new JLabel("Date d'entr\u00E9e");
		summaryEntryDateText.setBounds(54, 134, 90, 24);
		summaryBookingRoomPanel.add(summaryEntryDateText);
		
		summaryReleaseDateText = new JLabel("Date de sortie");
		summaryReleaseDateText.setBounds(54, 183, 90, 24);
		summaryBookingRoomPanel.add(summaryReleaseDateText);
		
		idField = new JTextField();
		idField.setBounds(120, 38, 201, 20);
		patientInformationPanel.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(120, 70, 201, 20);
		patientInformationPanel.add(nameField);
		
		fNameField = new JTextField();
		fNameField.setColumns(10);
		fNameField.setBounds(120, 105, 201, 20);
		patientInformationPanel.add(fNameField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(120, 140, 201, 20);
		patientInformationPanel.add(addressField);
		
		areaCodeField = new JTextField();
		areaCodeField.setColumns(10);
		areaCodeField.setBounds(120, 175, 201, 20);
		patientInformationPanel.add(areaCodeField);
		
		townField = new JTextField();
		townField.setColumns(10);
		townField.setBounds(120, 210, 201, 20);
		patientInformationPanel.add(townField);
		
		eMailField = new JTextField();
		eMailField.setColumns(10);
		eMailField.setBounds(120, 245, 201, 20);
		patientInformationPanel.add(eMailField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(497, 72, 177, 20);
		patientInformationPanel.add(phoneField);
		
		cellphoneField = new JTextField();
		cellphoneField.setColumns(10);
		cellphoneField.setBounds(497, 107, 177, 20);
		patientInformationPanel.add(cellphoneField);
		
		ssnField = new JTextField();
		ssnField.setColumns(10);
		ssnField.setBounds(497, 142, 177, 20);
		patientInformationPanel.add(ssnField);
		
		summaryNameField = new JTextField();
		summaryNameField.setBounds(168, 39, 173, 20);
		summaryPatientInfoPanel.add(summaryNameField);
		summaryNameField.setColumns(10);
		
		summaryFNameField = new JTextField();
		summaryFNameField.setBounds(168, 70, 173, 20);
		summaryPatientInfoPanel.add(summaryFNameField);
		summaryFNameField.setColumns(10);
		
		summarySsnField = new JTextField();
		summarySsnField.setBounds(168, 101, 173, 20);
		summaryPatientInfoPanel.add(summarySsnField);
		summarySsnField.setColumns(10);
		
		summaryCellphoneField = new JTextField();
		summaryCellphoneField.setBounds(168, 132, 173, 20);
		summaryPatientInfoPanel.add(summaryCellphoneField);
		summaryCellphoneField.setColumns(10);
		
		summaryBedRoomNumberField = new JTextField();
		summaryBedRoomNumberField.setColumns(10);
		summaryBedRoomNumberField.setBounds(154, 90, 201, 20);
		summaryBookingRoomPanel.add(summaryBedRoomNumberField);
		
		summaryEntryDateField = new JTextField();
		summaryEntryDateField.setColumns(10);
		summaryEntryDateField.setBounds(154, 140, 201, 20);
		summaryBookingRoomPanel.add(summaryEntryDateField);
		
		summaryReleaseDateField = new JTextField();
		summaryReleaseDateField.setColumns(10);
		summaryReleaseDateField.setBounds(154, 187, 201, 20);
		summaryBookingRoomPanel.add(summaryReleaseDateField);
		
		summaryRoomselectionSectorList = new JComboBox();
		summaryRoomselectionSectorList.setBounds(154, 39, 201, 20);
		summaryBookingRoomPanel.add(summaryRoomselectionSectorList);
		
		maleRButton = new JRadioButton("Homme");
		maleRButton.setBounds(130, 272, 90, 24);
		patientInformationPanel.add(maleRButton);
		
		femaleRButton = new JRadioButton("Femme");
		femaleRButton.setBounds(235, 272, 86, 24);
		patientInformationPanel.add(femaleRButton);
		
		genderGroup = new ButtonGroup();
		genderGroup.add(maleRButton);
		genderGroup.add(femaleRButton);
		
		summaryMaleRButton = new JRadioButton("Homme");
		summaryMaleRButton.setBounds(172, 169, 90, 24);
		summaryPatientInfoPanel.add(summaryMaleRButton);
		
		summaryFemaleRButton = new JRadioButton("Femme");
		summaryFemaleRButton.setBounds(277, 169, 86, 24);
		summaryPatientInfoPanel.add(summaryFemaleRButton);
		
		summaryGenderGroup = new ButtonGroup();
		summaryGenderGroup.add(summaryMaleRButton);
		summaryGenderGroup.add(summaryFemaleRButton);
		
		summaryExaminationList = new JList();
		summaryExaminationList.setBounds(486, 28, 424, 242);
		staySummaryPanel.add(summaryExaminationList);
		
		cancelPatientButton = new JButton("Effacer");
		cancelPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientFunction.cancelInformationBeforeAddPatient(idField,nameField,fNameField,addressField,areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField, genderGroup);
			}
		});
		cancelPatientButton.setBounds(280, 317, 110, 23);
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
		addPatientButton.setBounds(141, 317, 90, 23);
		patientInformationPanel.add(addPatientButton);
		
		birthdateText = new JLabel("Date de naissance");
		birthdateText.setBounds(331, 173, 156, 24);
		patientInformationPanel.add(birthdateText);
		
		birthdateField = new JTextField();
		birthdateField.setColumns(10);
		birthdateField.setBounds(497, 175, 177, 20);
		patientInformationPanel.add(birthdateField);
		
		changePatientInfoButton = new JButton("Modifier");
		changePatientInfoButton.setBounds(434, 317, 89, 23);
		patientInformationPanel.add(changePatientInfoButton);
		changePatientInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientFunction.changeInfoPatient(patientList,arrayPatient,idField.getText(),maleRButton.isSelected(), femaleRButton.isSelected(),
												  nameField.getText(),fNameField.getText(),addressField.getText(),areaCodeField.getText(),townField.getText(),
												  ssnField.getText(),eMailField.getText(),phoneField.getText(),cellphoneField.getText(),birthdateField.getText(),searchFiel);
	
			}
		});
		
		searchPatientListButton = new JButton("Rechercher");
		searchPatientListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientFunction.searchPatient(patientList, arrayPatient, searchFiel.getText());
			}
		});
		searchPatientListButton.setBounds(1287, 32, 163, 23);
		frame.getContentPane().add(searchPatientListButton);
		
		deletePatientButton = new JButton("Supprimer");
		deletePatientButton.setBounds(1340, 457, 110, 23);
		frame.getContentPane().add(deletePatientButton);
		deletePatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idPatient = patientList.getSelectedIndex();
				
				PatientFunction.deletePatient(patientList,arrayPatient,idPatient,idField,genderGroup,nameField,fNameField,addressField,
						areaCodeField,townField,ssnField,eMailField,phoneField,cellphoneField,birthdateField);
				
			}
		});
		
		searchFiel = new JTextField();
		searchFiel.setColumns(10);
		searchFiel.setBounds(751, 33, 507, 20);
		frame.getContentPane().add(searchFiel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(542, 439, 5, 22);
		frame.getContentPane().add(textArea);
	}
}
