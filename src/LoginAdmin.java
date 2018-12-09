import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection conn = null;
	private JButton btnSignup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setTitle("                                                    Admin Login");
		 design();
		 conn = SQLConnection.ConnecrDb();
		
	}
	
	
	private void login() {

		try {

			String query = "SELECT * FROM adminsignup WHERE Username = ? AND Password = ?";
			pst = (PreparedStatement) conn.prepareStatement(query);  
			pst.setString(1, textField.getText()); 
			pst.setString(2, textField_1.getText());

			
			rs = pst.executeQuery();

			if (rs.next()) {

				//JOptionPane.showMessageDialog(null, "login successful");
				
				CGPAadminWork m = new CGPAadminWork();
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
	
	
	private void design(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 393);
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(38, 121, 68, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 176, 68, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(143, 118, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 login();
			}
		});
		btnNewButton.setBounds(140, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 173, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnSignup = new JButton("signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignupAdmin frame = new SignupAdmin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSignup.setBounds(140, 276, 89, 23);
		contentPane.add(btnSignup);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CPGPA frame = new CPGPA();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(239, 276, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(343, 276, 89, 23);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("log.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(239, 29, 251, 236);
		contentPane.add(label);
	}
}
