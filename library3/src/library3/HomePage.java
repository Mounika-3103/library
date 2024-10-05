package library3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 0, 503, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\library\\caaff7b20a9060dd70597c178f68fbb8.jpg"));
		lblNewLabel.setBounds(10, 10, 483, 643);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(504, 0, 572, 663);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("home page");
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\N67RVULS\\icons8-home-50[1].png"));
		lblNewLabel_1.setBounds(23, 21, 289, 51);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  welcome user");
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2.setBounds(144, 82, 266, 40);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-students-50.png"));
		lblNewLabel_3.setBounds(61, 146, 50, 51);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-bookshelf-50.png"));
		lblNewLabel_4.setBounds(61, 217, 50, 51);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8_Sell_50px.png"));
		lblNewLabel_5.setBounds(61, 291, 50, 51);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\N67RVULS\\icons8-return-book-50[1].png"));
		lblNewLabel_6.setBounds(61, 359, 50, 51);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-logout-50.png"));
		lblNewLabel_9.setBounds(61, 559, 50, 51);
		panel_1.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("manage students");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ManageStudents ms=new ManageStudents();
				ms.initialize();
			}
		});
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(147, 146, 289, 48);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("manage books");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ManageBooks mb=new ManageBooks();
				mb.initialize();
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setBounds(144, 223, 292, 45);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("issue books");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				IssueBook i=new IssueBook();
				i.initialize();
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setBounds(144, 289, 292, 40);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("return books");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ReturnBook r=new ReturnBook();
				r.initialize();
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.setBounds(144, 359, 292, 40);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("logout");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login l=new login();
				l.initialize();
				}
		});
		btnNewButton_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_6.setBackground(Color.BLUE);
		btnNewButton_6.setBounds(144, 570, 292, 40);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("view issued books");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ViewIssuedBooks v=new ViewIssuedBooks();
				v.initialize();
					
			}
		});
		btnNewButton_4.setBackground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(144, 430, 289, 40);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("defaulter list");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DefaulterList d=new DefaulterList();
				d.initialize();
				
			}
		});
		btnNewButton_5.setBackground(Color.BLUE);
		btnNewButton_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_5.setBounds(144, 496, 280, 40);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-books-50.png"));
		lblNewLabel_7.setBounds(61, 433, 50, 51);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\r\n");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\W5ZQ1M53\\icons8-books-50[1].png"));
		lblNewLabel_8.setBounds(61, 495, 50, 48);
		panel_1.add(lblNewLabel_8);
		frame.setVisible(true);
	}
}
