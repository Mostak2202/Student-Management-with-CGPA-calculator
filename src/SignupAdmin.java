import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupAdmin extends JFrame {
	private JTextField NameTF;
	private JTextField EmailTF;
	private JTextField UsernameTF;
	private JPasswordField passField;
	private JTextField AgeTF;
	private JTextField ContactTF;
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JCheckBox chckbxIAcceptAll;
	private JPanel contentPane;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	String v = "";

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JButton btnBack;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupAdmin frame = new SignupAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignupAdmin() {
		setTitle("Admin Signup");

		design();
		conn = SQLConnection.ConnecrDb();

	}

	private void register() {

		try {

			String query = "INSERT INTO adminsignup(Name,Email,Username,Password,Age,Contact,Gender) VALUES(?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, NameTF.getText());
			pst.setString(2, EmailTF.getText());
			pst.setString(3, UsernameTF.getText());
			pst.setString(4, passField.getText());
			pst.setString(5, AgeTF.getText());
			pst.setString(6, ContactTF.getText());

			if (rdbtnMale.isSelected()) {
				v = rdbtnMale.getText().toString();
			} else if (rdbtnFemale.isSelected()) {

				v = rdbtnFemale.getText().toString();
			} else {

				JOptionPane.showMessageDialog(null, "Select Gender");
			}

			pst.setString(7, String.valueOf(v));


			pst.execute();
			pst.close();
			//JOptionPane.showMessageDialog(null, "Signup successful");
			
			LoginAdmin f = new LoginAdmin();
			f.setVisible(true);
			dispose();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSignuphere = new JLabel("Sign up Here");
		lblSignuphere.setBackground(Color.GRAY);
		lblSignuphere.setBounds(48, 11, 374, 24);
		lblSignuphere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSignuphere.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblSignuphere);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 34, 70, 26);
		getContentPane().add(lblNewLabel);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 65, 70, 26);
		getContentPane().add(lblEmail);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 90, 70, 26);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 127, 70, 26);
		getContentPane().add(lblPassword);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 160, 70, 26);
		getContentPane().add(lblAge);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(10, 197, 70, 26);
		getContentPane().add(lblContact);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 228, 70, 26);
		getContentPane().add(lblGender);

		NameTF = new JTextField();
		NameTF.setBounds(71, 37, 351, 20);
		NameTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(NameTF);
		NameTF.setColumns(10);

		EmailTF = new JTextField();
		EmailTF.setBounds(71, 65, 351, 20);
		EmailTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(EmailTF);
		EmailTF.setColumns(10);

		UsernameTF = new JTextField();
		UsernameTF.setBounds(71, 95, 351, 20);
		UsernameTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(UsernameTF);
		UsernameTF.setColumns(10);

		passField = new JPasswordField();
		passField.setBounds(71, 127, 351, 20);
		passField.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(passField);

		AgeTF = new JTextField();
		AgeTF.setBounds(71, 163, 351, 20);
		AgeTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(AgeTF);
		AgeTF.setColumns(10);

		ContactTF = new JTextField();
		ContactTF.setBounds(71, 197, 351, 20);
		ContactTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(ContactTF);
		ContactTF.setColumns(10);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(71, 230, 109, 23);
		buttonGroup.add(rdbtnMale);
		getContentPane().add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(196, 230, 109, 23);
		buttonGroup.add(rdbtnFemale);
		getContentPane().add(rdbtnFemale);

		JButton btnResigter = new JButton("Register");
		btnResigter.setBounds(137, 350, 118, 23);
		btnResigter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (chckbxIAcceptAll.isSelected()) {
					register();
				} else {
					JOptionPane.showMessageDialog(null, "Read tearms and conditions");
				}

			}
		});
		getContentPane().add(btnResigter);

		chckbxIAcceptAll = new JCheckBox("I accept all the terms and conditions.");
		chckbxIAcceptAll.setBounds(85, 304, 232, 23);
		getContentPane().add(chckbxIAcceptAll);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginAdmin frame = new LoginAdmin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(361, 336, 89, 23);
		contentPane.add(btnBack);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(361, 370, 89, 23);
		contentPane.add(btnExit);
	}
}
