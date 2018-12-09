import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginStudent extends JFrame {

	private JPanel contentPane;
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection conn = null;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnSignup;
	private JButton btnBack;
	private JButton btnExit;
	private JLabel lblNewLabel;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStudent frame = new LoginStudent();
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
	public LoginStudent() {
		setTitle("                                                    Student Login");
		
		design();
		conn = SQLConnection.ConnecrDb();
		
	}
	
	

	private void login1() {

		try {

			String query = "SELECT * FROM studentsignup WHERE UserName = ? AND Password = ?";
			pst = (PreparedStatement) conn.prepareStatement(query);  
			pst.setString(1, textField.getText()); 
			pst.setString(2, textField_1.getText());

			
			rs = pst.executeQuery();

			if (rs.next()) {

				//JOptionPane.showMessageDialog(null, "login successful");
				
				 StudentPortal m = new  StudentPortal();
				m.setVisible(true);
				dispose();
				
				
			} else {

				JOptionPane.showMessageDialog(null, "login failed");
			}

			pst.close();
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	
	
	
	private void design()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(47, 96, 71, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(47, 136, 71, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(128, 93, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 133, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login1();
				
			}
		});
		btnLogin.setBounds(128, 178, 89, 23);
		contentPane.add(btnLogin);
		
		btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignupStudent frame = new SignupStudent();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSignup.setBounds(128, 227, 89, 23);
		contentPane.add(btnSignup);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CPGPA frame = new CPGPA();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(231, 227, 89, 23);
		contentPane.add(btnBack);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("log2.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(251, 11, 242, 205);
		contentPane.add(label);
		
		
	}

}
