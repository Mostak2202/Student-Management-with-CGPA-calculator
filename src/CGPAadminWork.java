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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class CGPAadminWork extends JFrame {

	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection conn = null;

	private JPanel contentPane;
	private JTable dataTable;
	private JTextField NameTF;
	private JTextField IdTF;
	private JTextField SemesterTF;
	private JTextField SectionTF;
	private JTextField c1;
	private JTextField c2;
	private JTextField c3;
	private JTextField c4;
	private JTextField c5;
	private JTextField c6;
	private JTextField cr1;
	private JTextField cr2;
	private JTextField cr3;
	private JTextField cr4;
	private JTextField cr5;
	private JTextField cr6;
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p4;
	private JTextField p5;
	private JTextField p6;
	private JTextField pointTF;
	private JTextField SearchTF;
	private JComboBox SearchCB;
	private JTextField PointTF;
	private JTextField GradeTF;
	private JScrollPane scrollPane;

	private int E_serial = 0;
	private JTextField GradeTF1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CGPAadminWork frame = new CGPAadminWork();
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
	public CGPAadminWork() {
		setTitle("                                                                         Aadminwork Place");

		design();
		conn = SQLConnection.ConnecrDb();
		loadTable();

	}

	private void loadTable() {

		try {

			String query = "Select E_serial,Name,Id,Semester,Section,Point,Grade FROM ADMINWORK1";
			pst = (PreparedStatement) conn.prepareStatement(query);
			rs = pst.executeQuery();
			dataTable.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void addData() {

		try {

			String query = "INSERT INTO adminwork1(Name,Id,Semester,Section,Point,Grade) VALUES(?,?,?,?,?,?)";
			pst = (PreparedStatement) conn.prepareStatement(query);
			pst.setString(1, NameTF.getText());
			pst.setString(2, IdTF.getText());
			pst.setString(3, SemesterTF.getText());
			pst.setString(4, SectionTF.getText());
			pst.setString(5, PointTF.getText());
			pst.setString(6, GradeTF.getText());

			pst.execute();
			pst.close();
			//JOptionPane.showMessageDialog(null, "New Info Added");

			loadTable();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void loadToField() {

		try {
			int row = dataTable.getSelectedRow();
			String serial = (dataTable.getModel().getValueAt(row, 0)).toString();
			String query = "Select * from adminwork1 WHERE E_serial = '" + serial + " '";
			pst = (PreparedStatement) conn.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {

				E_serial = rs.getInt("E_serial");

				NameTF.setText(rs.getString("Name"));
				IdTF.setText(rs.getString("Id"));
				SemesterTF.setText(rs.getString("Semester"));
				SectionTF.setText(rs.getString("section"));
				PointTF.setText(rs.getString("Point"));
				GradeTF.setText(rs.getString("Grade"));

			}

			pst.close();
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void updateData() {

		try {

			// String adminwork1 = null;
			String query = "UPDATE adminwork1 SET Name = '" + NameTF.getText() + "', Id = '" + IdTF.getText()
					+ "',Semester = '" + SemesterTF.getText() + "',Section = '" + SectionTF.getText() + "',Point = '"
					+ PointTF.getText() + "',Grade = '" + GradeTF.getText() + "' Where E_serial = '" + E_serial + "'";

			pst = (PreparedStatement) conn.prepareStatement(query);
			pst.execute();

			//JOptionPane.showMessageDialog(null, "Data updated successfully");
			pst.close();
			loadTable();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void delateData() {

		try {

			int action = JOptionPane.showConfirmDialog(null, "Are you sure to Delete?", "Delete",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (action == 0) {
				String query = "DELETE FROM adminwork1 WHERE E_serial = '" + E_serial + "'";
				pst = (PreparedStatement) conn.prepareStatement(query);
				pst.execute();

				//JOptionPane.showMessageDialog(null, "Deleted Successfully");
				pst.close();
				loadTable();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void searchData() {

		try {

			String selection = (String) SearchCB.getSelectedItem();

			String query = "SELECT E_serial,Name,Id,Semester,Section,Point,Grade FROM Adminwork1 WHERE " + selection
					+ " LIKE '" + SearchTF.getText() + "%'";
			pst = (PreparedStatement) conn.prepareStatement(query);

			// pst.setString(1, SearchTF.getText());
			rs = pst.executeQuery();
			dataTable.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCourse() {
		if (SemesterTF.getText().equals("1")) {
			c1.setText("Course 1");
			c2.setText("Course 2");
			c3.setText("Course 3");
			c4.setText("Course 4");
			c5.setText("Course 5");
			c6.setText("Course 6");
		} else if (SemesterTF.getText().equals("2")) {
			{
				c1.setText("Course 1");
				c2.setText("Course 2");
				c3.setText("Course 3");
				c4.setText("Course 4");
				c5.setText("Course 5");
				c6.setText("Course 6");
			}
		}
	}

	private void design() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 490);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setForeground(UIManager.getColor("scrollbar"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 745, 141);
		contentPane.add(scrollPane);

		dataTable = new JTable();
		dataTable.setForeground(new Color(128, 0, 0));
		dataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				loadToField();

			}
		});
		scrollPane.setViewportView(dataTable);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 185, 78, 14);
		contentPane.add(lblNewLabel);

		NameTF = new JTextField();
		NameTF.setBounds(66, 182, 326, 20);
		contentPane.add(NameTF);
		NameTF.setColumns(10);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(421, 185, 46, 14);
		contentPane.add(lblId);

		IdTF = new JTextField();
		IdTF.setBounds(461, 182, 217, 20);
		contentPane.add(IdTF);
		IdTF.setColumns(10);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(10, 210, 56, 14);
		contentPane.add(lblSemester);

		SemesterTF = new JTextField();
		SemesterTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				setCourse();
			}
		});
		SemesterTF.setBounds(66, 210, 120, 20);
		contentPane.add(SemesterTF);
		SemesterTF.setColumns(10);

		SectionTF = new JTextField();
		SectionTF.setBounds(256, 207, 86, 20);
		contentPane.add(SectionTF);
		SectionTF.setColumns(10);

		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(206, 210, 46, 14);
		contentPane.add(lblSection);

		JLabel lblCoursename = new JLabel("Coursename");
		lblCoursename.setForeground(new Color(128, 0, 0));
		lblCoursename.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoursename.setBounds(46, 277, 98, 14);
		contentPane.add(lblCoursename);

		c1 = new JTextField();
		/*c1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cr1.setText("3.0");
			}
		});*/
		c1.setBounds(10, 302, 176, 20);
		contentPane.add(c1);
		c1.setColumns(10);

		c2 = new JTextField();
		/*c2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr2.setText("3.0");
			}
		});*/
		c2.setBounds(10, 324, 176, 20);
		contentPane.add(c2);
		c2.setColumns(10);

		c3 = new JTextField();
		/*c3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr3.setText("3.0");
			}
		});*/
		c3.setBounds(10, 348, 176, 20);
		contentPane.add(c3);
		c3.setColumns(10);

		c4 = new JTextField();
		/*c4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr4.setText("3.0");
			}
		});*/
		c4.setBounds(10, 420, 176, 20);
		contentPane.add(c4);
		c4.setColumns(10);

		c5 = new JTextField();
		/*c5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr5.setText("1.0");
			}
		});*/
		c5.setBounds(10, 397, 176, 20);
		contentPane.add(c5);
		c5.setColumns(10);

		c6 = new JTextField();
		/*c6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr6.setText("1.0");
			}
		});*/
		c6.setBounds(10, 372, 176, 20);
		contentPane.add(c6);
		c6.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Credit");
		lblNewLabel_1.setForeground(new Color(139, 0, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(236, 277, 66, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Point");
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(312, 274, 68, 20);
		contentPane.add(lblNewLabel_2);

		cr1 = new JTextField();

		cr1.setBounds(206, 302, 86, 20);
		contentPane.add(cr1);
		cr1.setColumns(10);

		cr2 = new JTextField();

		cr2.setBounds(206, 324, 86, 20);
		contentPane.add(cr2);
		cr2.setColumns(10);

		cr3 = new JTextField();

		cr3.setBounds(206, 348, 86, 20);
		contentPane.add(cr3);
		cr3.setColumns(10);

		cr4 = new JTextField();

		cr4.setBounds(206, 372, 86, 20);
		contentPane.add(cr4);
		cr4.setColumns(10);

		cr5 = new JTextField();

		cr5.setBounds(206, 397, 86, 20);
		contentPane.add(cr5);
		cr5.setColumns(10);

		cr6 = new JTextField();

		cr6.setBounds(206, 420, 86, 20);
		contentPane.add(cr6);
		cr6.setColumns(10);

		p1 = new JTextField();
		
		p1.setBounds(306, 302, 86, 20);
		contentPane.add(p1);
		p1.setColumns(10);

		p2 = new JTextField();
		p2.setBounds(306, 324, 86, 20);
		contentPane.add(p2);
		p2.setColumns(10);

		p3 = new JTextField();
		p3.setBounds(306, 348, 86, 20);
		contentPane.add(p3);
		p3.setColumns(10);

		p4 = new JTextField();
		p4.setBounds(306, 372, 86, 20);
		contentPane.add(p4);
		p4.setColumns(10);

		p5 = new JTextField();
		p5.setBounds(306, 397, 86, 20);
		contentPane.add(p5);
		p5.setColumns(10);

		p6 = new JTextField();
		p6.setBounds(306, 420, 86, 20);
		contentPane.add(p6);
		p6.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				addData();

			}
		});
		btnAdd.setBounds(55, 243, 89, 23);
		contentPane.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(0, 0, 128));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateData();
			}
		});
		btnUpdate.setBounds(163, 243, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelet = new JButton("Delete");
		btnDelet.setForeground(new Color(255, 0, 0));
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				delateData();
			}
		});
		btnDelet.setBounds(266, 243, 89, 23);
		contentPane.add(btnDelet);

		JButton btnCalculation = new JButton("Calculation");
		btnCalculation.setForeground(new Color(34, 139, 34));
		btnCalculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*float calculate = Float.parseFloat(p1.getText()) * Float.parseFloat(cr1.getText()) + Float.parseFloat(p2.getText())* Float.parseFloat(cr2.getText())
						+ Float.parseFloat(p3.getText())* Float.parseFloat(cr3.getText()) + Float.parseFloat(p4.getText())* Float.parseFloat(cr4.getText())
						+ Float.parseFloat(p5.getText())* Float.parseFloat(cr5.getText()) + Float.parseFloat(p6.getText())* Float.parseFloat(cr6.getText());
				float result = calculate / 14;
				pointTF.setText("" + result);
				//String gradeTF = Float.toString(result); */
				
				float calculate = Float.parseFloat(p1.getText()) * Float.parseFloat(cr1.getText()) + Float.parseFloat(p2.getText())* Float.parseFloat(cr2.getText())
						+ Float.parseFloat(p3.getText())* Float.parseFloat(cr3.getText()) + Float.parseFloat(p4.getText())* Float.parseFloat(cr4.getText())
						+ Float.parseFloat(p5.getText())* Float.parseFloat(cr5.getText()) + Float.parseFloat(p6.getText())* Float.parseFloat(cr6.getText());
				
				float credit = Float.parseFloat(cr1.getText())+Float.parseFloat(cr2.getText())+Float.parseFloat(cr3.getText())+Float.parseFloat(cr4.getText())+Float.parseFloat(cr5.getText())+Float.parseFloat(cr6.getText());
				
				float result = calculate / credit;
				pointTF.setText(String.format("%.2f", result));
				

				if(result == 4.0) {
					GradeTF1.setText("A+");
				}
				
				else if(result>= 3.75 && result<= 3.99) {
					
					GradeTF1.setText("A");
				}
                else if(result>=3.50 && result<=3.74 ) {
					
                	GradeTF1.setText("A-");
				}
               else if(result>=3.25 && result<=3.49 ) {
					
            	   GradeTF1.setText("B+");
				}
               else if(result>=3.00 && result<=3.24 ) {
	
            	   GradeTF1.setText("B");
               }
               else if(result>=2.75 && result<=2.99 ) {
					
            	   GradeTF1.setText("B");
				}
               else if(result>=2.50 && result<=2.74 ) {
					
            	   GradeTF1.setText("C+");
				}
               else if(result>=2.25 && result<=2.49 ) {
					
            	   GradeTF1.setText("C");
				}
               else if(result>=2.00 && result<=2.24 ) {
					
            	   GradeTF1.setText("D");
				}
               else if(result<2.0 ) {
					
            	   GradeTF1.setText("F");
				}
				
				
				
				
				
			}
		});
		btnCalculation.setBounds(464, 369, 110, 23);
		contentPane.add(btnCalculation);

		JLabel lblPoint = new JLabel("Point");
		lblPoint.setForeground(new Color(204, 0, 51));
		lblPoint.setBounds(439, 292, 46, 14);
		contentPane.add(lblPoint);

		JLabel lblNewLabel_3 = new JLabel("Grade");
		lblNewLabel_3.setForeground(new Color(255, 51, 51));
		lblNewLabel_3.setBounds(540, 292, 46, 14);
		contentPane.add(lblNewLabel_3);

		pointTF = new JTextField();
		pointTF.setBounds(421, 322, 86, 20);
		contentPane.add(pointTF);
		pointTF.setColumns(10);
		
		
		SearchCB = new JComboBox();
		SearchCB.setModel(
				new DefaultComboBoxModel(new String[] { "Name", "Id", "Semester", "Section", "Point", "Grade" }));
		SearchCB.setBounds(10, 2, 120, 20);
		contentPane.add(SearchCB);

		SearchTF = new JTextField();
		SearchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				searchData();

			}
		});
		SearchTF.setBounds(166, 2, 199, 20);
		contentPane.add(SearchTF);
		SearchTF.setColumns(10);

		JLabel label = new JLabel("Point");
		label.setBounds(376, 210, 46, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Grade");
		label_1.setBounds(555, 213, 46, 14);
		contentPane.add(label_1);

		PointTF = new JTextField();
		PointTF.setBounds(421, 207, 86, 20);
		contentPane.add(PointTF);
		PointTF.setColumns(10);

		GradeTF = new JTextField();
		GradeTF.setBounds(604, 207, 86, 20);
		contentPane.add(GradeTF);
		GradeTF.setColumns(10);
		
		GradeTF1 = new JTextField();
		GradeTF1.setText("");
		GradeTF1.setBounds(528, 324, 86, 20);
		contentPane.add(GradeTF1);
		GradeTF1.setColumns(10);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LoginAdmin frame = new LoginAdmin();
				frame.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton.setBounds(461, 419, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(576, 419, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
