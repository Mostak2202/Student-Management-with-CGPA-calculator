import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cgpacalculator5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField c1TF;
	private JTextField c2TF;
	private JTextField c3TF;
	private JTextField c4TF;
	private JTextField c5TF;
	private JTextField c6TF;
	private JTextField c7TF;
	private JTextField c8TF;
	private JTextField p1TF;
	private JTextField p2TF;
	private JTextField p3TF;
	private JTextField p4TF;
	private JTextField p5TF;
	private JTextField p6TF;
	private JTextField p7TF;
	private JTextField p8TF;
	private JTextField Point1TF;
	private JTextField Grade1TF;
	private JButton btnNewButton_1;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cgpacalculator5 frame = new Cgpacalculator5();
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

	public Cgpacalculator5() {
		design();
		disabled();
	}

	private void disabled() {
		c1TF.setEnabled(false);
		c2TF.setEnabled(false);
		c3TF.setEnabled(false);
		c4TF.setEnabled(false);
		c5TF.setEnabled(false);
		c6TF.setEnabled(false);
		c7TF.setEnabled(false);
		c8TF.setEnabled(false);
		p1TF.setEnabled(false);
		p2TF.setEnabled(false);
		p3TF.setEnabled(false);
		p4TF.setEnabled(false);
		p5TF.setEnabled(false);
		p6TF.setEnabled(false);
		p7TF.setEnabled(false);
		p8TF.setEnabled(false);

	}

	private void countCGPA() {

		Double subject = 0.0;
		Double sub1 = 0.0;
		Double sub2 = 0.0;
		Double sub3 = 0.0;
		Double sub4 = 0.0;
		Double sub5 = 0.0;
		Double sub6 = 0.0;
		Double sub7 = 0.0;
		Double sub8 = 0.0;

		Double p1 = 0.0;
		Double p2 = 0.0;
		Double p3 = 0.0;
		Double p4 = 0.0;
		Double p5 = 0.0;
		Double p6 = 0.0;
		Double p7 = 0.0;
		Double p8 = 0.0;

		subject = Double.parseDouble(textField.getText());

		sub1 = Double.parseDouble(c1TF.getText());
		sub2 = Double.parseDouble(c2TF.getText());
		sub3 = Double.parseDouble(c3TF.getText());
		sub4 = Double.parseDouble(c4TF.getText());
		sub5 = Double.parseDouble(c5TF.getText());
		sub6 = Double.parseDouble(c6TF.getText());
		sub7 = Double.parseDouble(c7TF.getText());
		sub8 = Double.parseDouble(c8TF.getText());

		p1 = Double.parseDouble(p1TF.getText());
		p2 = Double.parseDouble(p2TF.getText());
		p3 = Double.parseDouble(p3TF.getText());
		p4 = Double.parseDouble(p4TF.getText());
		p5 = Double.parseDouble(p5TF.getText());
		p6 = Double.parseDouble(p6TF.getText());
		p7 = Double.parseDouble(p7TF.getText());
		p8 = Double.parseDouble(p8TF.getText());

		Double credit = sub1 + sub2 + sub3 + sub4 + sub5 + sub6 + sub7 + sub8;

		Double result = ((sub1 * p1) + (sub2 * p2) + (sub3 * p3) + (sub4 * p4) + (sub5 * p5) + (sub6 * p6) + (sub7 * p7)
				+ (sub8 * p8)) / credit;

		if(result> 0.0 && result <= 4.0)
		{
			Point1TF.setText(String.format("%.2f", result));
		}
		else
		{
			Point1TF.setText("0.0");
		}
		

		if(result == 4.0) {
			Grade1TF.setText("A+");
		}
		
		else if(result>= 3.75 && result<= 3.99) {
			
			Grade1TF.setText("A");
		}
        else if(result>=3.50 && result<=3.74 ) {
			
			Grade1TF.setText("A-");
		}
       else if(result>=3.25 && result<=3.49 ) {
			
			Grade1TF.setText("B+");
		}
       else if(result>=3.00 && result<=3.24 ) {

       Grade1TF.setText("B");
       }
       else if(result>=2.75 && result<=2.99 ) {
			
			Grade1TF.setText("B");
		}
       else if(result>=2.50 && result<=2.74 ) {
			
			Grade1TF.setText("C+");
		}
       else if(result>=2.25 && result<=2.49 ) {
			
			Grade1TF.setText("C");
		}
       else if(result>=2.00 && result<=2.24 ) {
			
			Grade1TF.setText("D");
		}
       else if(result<2.0 ) {
			
			Grade1TF.setText("F");
		}
       else
       {
    	   Grade1TF.setText(null);
       }
		
   
		
		
	
		
		
	}

	private void design() {

		{
			setTitle(
					"                                                                                                            \r\n   Calculator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 832, 493);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblNewLabel = new JLabel(" HERE YOU CAN CALCULATE YOUR CGPA");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(148, 11, 489, 14);
			contentPane.add(lblNewLabel);

			JLabel lblEnterSubjectNo = new JLabel("Enter subject no:");
			lblEnterSubjectNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEnterSubjectNo.setBounds(29, 41, 121, 14);
			contentPane.add(lblEnterSubjectNo);

			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					int sub = Integer.parseInt(textField.getText());
					if (sub == 1) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
					} else if (sub == 2) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
						c2TF.setEnabled(true);
						p2TF.setEnabled(true);
					} else if (sub == 3) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
						c2TF.setEnabled(true);
						p2TF.setEnabled(true);
						c3TF.setEnabled(true);
						p3TF.setEnabled(true);
					}

					else if (sub == 4) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
						c2TF.setEnabled(true);
						p2TF.setEnabled(true);
						c3TF.setEnabled(true);
						p3TF.setEnabled(true);
						c4TF.setEnabled(true);
						p4TF.setEnabled(true);
					} else if (sub == 5) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
						c2TF.setEnabled(true);
						p2TF.setEnabled(true);
						c3TF.setEnabled(true);
						p3TF.setEnabled(true);
						c4TF.setEnabled(true);
						p4TF.setEnabled(true);
						c5TF.setEnabled(true);
						p5TF.setEnabled(true);
					} else if (sub == 6) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
						c2TF.setEnabled(true);
						p2TF.setEnabled(true);
						c3TF.setEnabled(true);
						p3TF.setEnabled(true);
						c4TF.setEnabled(true);
						p4TF.setEnabled(true);
						c5TF.setEnabled(true);
						p5TF.setEnabled(true);
						c6TF.setEnabled(true);
						p6TF.setEnabled(true);
					} else if (sub == 7) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
						c2TF.setEnabled(true);
						p2TF.setEnabled(true);
						c3TF.setEnabled(true);
						p3TF.setEnabled(true);
						c4TF.setEnabled(true);
						p4TF.setEnabled(true);
						c5TF.setEnabled(true);
						p5TF.setEnabled(true);
						c6TF.setEnabled(true);
						p6TF.setEnabled(true);
						c7TF.setEnabled(true);
						p7TF.setEnabled(true);
					} else if (sub == 8) {
						c1TF.setEnabled(true);
						p1TF.setEnabled(true);
						c2TF.setEnabled(true);
						p2TF.setEnabled(true);
						c3TF.setEnabled(true);
						p3TF.setEnabled(true);
						c4TF.setEnabled(true);
						p4TF.setEnabled(true);
						c5TF.setEnabled(true);
						p5TF.setEnabled(true);
						c6TF.setEnabled(true);
						p6TF.setEnabled(true);
						c7TF.setEnabled(true);
						p7TF.setEnabled(true);
						c8TF.setEnabled(true);
						p8TF.setEnabled(true);
					
						
					} else if (textField.getText().equals("")) {
						disabled();
					}

					else {
						disabled();
					}

				}
			});
			textField.setBounds(148, 40, 86, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			JLabel lblPoint = new JLabel("Credit");
			lblPoint.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPoint.setBounds(41, 78, 54, 20);
			contentPane.add(lblPoint);

			JLabel lblGrade = new JLabel("Point");
			lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGrade.setBounds(154, 81, 46, 14);
			contentPane.add(lblGrade);

			c1TF = new JTextField();
			c1TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					c1TF.setText("");
					
				}
			});
			c1TF.setHorizontalAlignment(SwingConstants.CENTER);
			c1TF.setText("0.0");
			c1TF.setBounds(10, 109, 86, 20);
			contentPane.add(c1TF);
			c1TF.setColumns(10);

			c2TF = new JTextField();
			c2TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					c2TF.setText("");
				}
			});
			c2TF.setHorizontalAlignment(SwingConstants.CENTER);
			c2TF.setText("0.0");
			c2TF.setBounds(10, 140, 86, 20);
			contentPane.add(c2TF);
			c2TF.setColumns(10);
			
			c3TF = new JTextField();
			c3TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					c3TF.setText("");
				}
			});
			c3TF.setHorizontalAlignment(SwingConstants.CENTER);
			c3TF.setText("0.0");
			c3TF.setBounds(10, 171, 86, 20);
			contentPane.add(c3TF);
			c3TF.setColumns(10);
			c2TF.setText("0.0");
			c4TF = new JTextField();
			c4TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					c4TF.setText("");
				}
			});
			c4TF.setHorizontalAlignment(SwingConstants.CENTER);
			c4TF.setText("0.0");
			c4TF.setBounds(10, 202, 86, 20);
			contentPane.add(c4TF);
			c4TF.setColumns(10);
			c4TF.setText("0.0");
			c5TF = new JTextField();
			c5TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					c5TF.setText("");
				}
			});
			c5TF.setHorizontalAlignment(SwingConstants.CENTER);
			c5TF.setText("0.0");
			c5TF.setBounds(10, 233, 86, 20);
			contentPane.add(c5TF);
			c5TF.setColumns(10);

			c6TF = new JTextField();
			c6TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					c6TF.setText("");
				}
			});
			c6TF.setHorizontalAlignment(SwingConstants.CENTER);
			c6TF.setText("0.0");
			c6TF.setBounds(10, 264, 86, 20);
			contentPane.add(c6TF);
			c6TF.setColumns(10);

			c7TF = new JTextField();
			c7TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					c7TF.setText("");
				}
			});
			c7TF.setHorizontalAlignment(SwingConstants.CENTER);
			c7TF.setText("0.0");
			c7TF.setBounds(10, 295, 86, 20);
			contentPane.add(c7TF);
			c7TF.setColumns(10);

			c8TF = new JTextField();
			c8TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					c8TF.setText("");
				}
			});
			c8TF.setHorizontalAlignment(SwingConstants.CENTER);
			c8TF.setText("0.0");
			c8TF.setBounds(10, 328, 86, 20);
			contentPane.add(c8TF);
			c8TF.setColumns(10);
			c8TF.setText("0.0");
			p1TF = new JTextField();
			p1TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p1TF.setText("");
				}
			});
			p1TF.setHorizontalAlignment(SwingConstants.CENTER);
			p1TF.setText("0.0");
			p1TF.setColumns(10);
			p1TF.setBounds(137, 109, 86, 20);
			contentPane.add(p1TF);

			p2TF = new JTextField();
			p2TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p2TF.setText("");
				}
			});
			p2TF.setHorizontalAlignment(SwingConstants.CENTER);
			p2TF.setText("0.0");
			p2TF.setColumns(10);
			p2TF.setBounds(137, 140, 86, 20);
			contentPane.add(p2TF);

			p3TF = new JTextField();
			p3TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p3TF.setText("");
				}
			});
			p3TF.setHorizontalAlignment(SwingConstants.CENTER);
			p3TF.setText("0.0");
			p3TF.setColumns(10);
			p3TF.setBounds(137, 171, 86, 20);
			contentPane.add(p3TF);

			p4TF = new JTextField();
			p4TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					p4TF.setText("");
				}
			});
			p4TF.setHorizontalAlignment(SwingConstants.CENTER);
			p4TF.setText("0.0");
			p4TF.setColumns(10);
			p4TF.setBounds(137, 202, 86, 20);
			contentPane.add(p4TF);

			p5TF = new JTextField();
			p5TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p5TF.setText("");
				}
			});
			p5TF.setHorizontalAlignment(SwingConstants.CENTER);
		    p5TF.setText("0.0");
			p5TF.setColumns(10);
			p5TF.setBounds(137, 233, 86, 20);
			contentPane.add(p5TF);

			p6TF = new JTextField();
			p6TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 p6TF.setText("");
					
				}
			});
			p6TF.setHorizontalAlignment(SwingConstants.CENTER);
			 p6TF.setText("0.0");
			p6TF.setColumns(10);
			p6TF.setBounds(137, 264, 86, 20);
			contentPane.add(p6TF);

			p7TF = new JTextField();
			p7TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p7TF.setText("");
					
				}
			});
			p7TF.setHorizontalAlignment(SwingConstants.CENTER);
			 p7TF.setText("0.0");
			p7TF.setColumns(10);
			p7TF.setBounds(137, 295, 86, 20);
			contentPane.add(p7TF);

			p8TF = new JTextField();
			p8TF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					p8TF.setText("");
				}
			});
			p8TF.setHorizontalAlignment(SwingConstants.CENTER);
			 p8TF.setText("0.0");
			 p8TF.setColumns(10);
			p8TF.setBounds(137, 328, 86, 20);
			contentPane.add(p8TF);

			JLabel lblPpoint = new JLabel("Point");
			lblPpoint.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPpoint.setBounds(525, 231, 46, 20);
			contentPane.add(lblPpoint);

			Point1TF = new JTextField();
			Point1TF.setBounds(581, 233, 86, 20);
			contentPane.add(Point1TF);
			Point1TF.setColumns(10);

			JLabel lblGrade_1 = new JLabel("Grade");
			lblGrade_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGrade_1.setBounds(525, 203, 46, 14);
			contentPane.add(lblGrade_1);

			Grade1TF = new JTextField();
			Grade1TF.setBounds(581, 202, 86, 20);
			contentPane.add(Grade1TF);
			Grade1TF.setColumns(10);

			JButton btnNewButton = new JButton("Calculate");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					/*
					 * float calculate = Float.parseFloat(p1TF.getText()) *
					 * Float.parseFloat(c1TF.getText()) + Float.parseFloat(p2TF.getText()) *
					 * Float.parseFloat(c2TF.getText()) + Float.parseFloat(p3TF.getText()) *
					 * Float.parseFloat(c3TF.getText()) + Float.parseFloat(p4TF.getText()) *
					 * Float.parseFloat(c4TF.getText()) + Float.parseFloat(p5TF.getText()) *
					 * Float.parseFloat(c5TF.getText()) + Float.parseFloat(p6TF.getText()) *
					 * Float.parseFloat(c6TF.getText()) + Float.parseFloat(p7TF.getText()) *
					 * Float.parseFloat(c7TF.getText()) + Float.parseFloat(p8TF.getText()) *
					 * Float.parseFloat(c8TF.getText()) + Float.parseFloat(p9TF.getText()) *
					 * Float.parseFloat(c9TF.getText()) + Float.parseFloat(p10TF.getText()) *
					 * Float.parseFloat(c10TF.getText());
					 * 
					 * float credit = Float.parseFloat(c1TF.getText()) +
					 * Float.parseFloat(c2TF.getText()) + Float.parseFloat(c3TF.getText()) +
					 * Float.parseFloat(c4TF.getText()) + Float.parseFloat(c5TF.getText()) +
					 * Float.parseFloat(c6TF.getText()) + Float.parseFloat(c7TF.getText()) +
					 * Float.parseFloat(c8TF.getText()) + Float.parseFloat(c9TF.getText()) +
					 * Float.parseFloat(c10TF.getText());
					 * 
					 * float result = calculate / credit; Point1TF.setText("" + result);
					 */

					countCGPA();

				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(369, 214, 127, 23);
			contentPane.add(btnNewButton);

			btnNewButton_1 = new JButton("Back");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CPGPA frame = new CPGPA();
					frame.setVisible(true);
					dispose();
				}

			});
			btnNewButton_1.setBounds(461, 420, 89, 23);
			contentPane.add(btnNewButton_1);

			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnClose.setBounds(578, 420, 89, 23);
			contentPane.add(btnClose);

		}
	}
}
