import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentPortal extends JFrame {


	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection conn = null;
	
	
	
	private JPanel contentPane;
	private JTable dataTable1;
	private JTextField SearchTF1;
	
	private JComboBox SearchCB1;
	private JButton btnNewButton;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPortal frame = new StudentPortal();
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
	public StudentPortal() {
		setTitle("Student Portal");
		
		design();
		conn = SQLConnection.ConnecrDb();
		loadTable1();
	}
	
	
private void loadTable1() {
		
		try {
			
			String query = "Select E_serial,Name,Id,Semester,Section,Point,Grade FROM ADMINWORK1";
			pst = (PreparedStatement) conn.prepareStatement(query);
			rs = pst.executeQuery();
			dataTable1.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
private void searchData1() {
	
	try {
		
		String selection = (String)SearchCB1.getSelectedItem();
		
		String query = "SELECT E_serial,Name,Id,Semester,Section,Point,Grade FROM Adminwork1 WHERE "+selection+" LIKE '"+SearchTF1.getText()+"%'";
		pst = (PreparedStatement) conn.prepareStatement(query);
		
		//pst.setString(1, SearchTF.getText());
		rs = pst.executeQuery();
		dataTable1.setModel(DbUtils.resultSetToTableModel(rs));
		
		pst.close();
		rs.close();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	 

	
	
	private void design()
	
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 668, 134);
		contentPane.add(scrollPane);
		
		dataTable1 = new JTable();
		scrollPane.setViewportView(dataTable1);
		
		SearchCB1 = new JComboBox();
		SearchCB1.setModel(new DefaultComboBoxModel(new String[] {"Name", "Id", "Semester", "Section", "Point", "Grade"}));
		SearchCB1.setBounds(20, 9, 83, 20);
		contentPane.add(SearchCB1);
		
		SearchTF1 = new JTextField();
		SearchTF1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
				searchData1();
			}
		});
		SearchTF1.setBounds(129, 9, 197, 20);
		contentPane.add(SearchTF1);
		SearchTF1.setColumns(10);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginStudent frame = new LoginStudent();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(490, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(589, 209, 89, 23);
		contentPane.add(btnExit);
	}
}
