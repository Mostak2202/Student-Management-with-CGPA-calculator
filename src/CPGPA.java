import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.UIManager;

public class CPGPA extends JFrame {

	private JPanel contentPane;
	JLabel label_1;
	JLabel label_2;
	
	Connection conn = null;
	
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPGPA frame = new CPGPA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public CPGPA() {
		setForeground(Color.BLACK);
		setType(Type.POPUP);
		setTitle("                                                             BY HUNTER");
		design();
		conn = SQLConnection.ConnecrDb();
	}
	
	
	
	
	
	
	private void design()
	
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 435);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("scrollbar"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToOur = new JLabel("STUDENT MANAGEMENT SYSTEM WITH CGPA CALCULATION");
		lblWelcomeToOur.setBackground(Color.BLACK);
		lblWelcomeToOur.setForeground(Color.BLACK);
		lblWelcomeToOur.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOur.setBounds(66, 24, 389, 32);
		contentPane.add(lblWelcomeToOur);
		
		JLabel label = new JLabel("");
		label.setBounds(190, 151, 46, 14);
		contentPane.add(label);
		
		JButton btnAdminPortal = new JButton("Admin portal");
		btnAdminPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LoginAdmin frame = new LoginAdmin();
				frame.setVisible(true);
				dispose();
			
			}
		});
		btnAdminPortal.setBounds(10, 101, 137, 23);
		contentPane.add(btnAdminPortal);
		
		JButton btnStudentPortal = new JButton("Student portal");
		btnStudentPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				LoginStudent frame = new LoginStudent();
				frame.setVisible(true);
				dispose();
				
				
				
				
			}
		});
		btnStudentPortal.setBounds(10, 158, 137, 23);
		contentPane.add(btnStudentPortal);
		
		JButton btnCgpaCalculator = new JButton("CGPA Calculator");
		btnCgpaCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cgpacalculator5 frame = new Cgpacalculator5();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCgpaCalculator.setBounds(10, 211, 137, 23);
		contentPane.add(btnCgpaCalculator);
		
		JLabel label_1 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("std.png")).getImage();
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(10, 11, 46, 48);
		contentPane.add(label_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnClose.setBounds(501, 364, 89, 23);
		contentPane.add(btnClose);
		
		JLabel label_2 = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("std1.png")).getImage();
		label_2.setIcon(new ImageIcon(img1));
		
		label_2.setBounds(322, 43, 268, 310);
		contentPane.add(label_2);
		
		
		
		
	}
}
