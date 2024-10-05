package library3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1101, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 10, 658, 588);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\library\\library-3.png"));
		lblNewLabel.setBounds(23, 90, 611, 456);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  library management system");
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(62, 10, 507, 48);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.MAGENTA);
		panel_1.setBounds(659, 10, 428, 598);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("  login page");
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel_2.setBounds(98, 43, 229, 58);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("welcome to library");
		lblNewLabel_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_3.setBounds(98, 111, 251, 34);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\library\\icons8-student-64.png"));
		lblNewLabel_4.setBounds(34, 179, 74, 73);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("student id");
		lblNewLabel_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(121, 185, 171, 25);
		panel_1.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(118, 220, 231, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\library\\icons8-password-50.png"));
		lblNewLabel_6.setBounds(34, 292, 63, 58);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("password");
		lblNewLabel_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(121, 283, 181, 25);
		panel_1.add(lblNewLabel_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 318, 228, 32);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("  login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
		        String pwd=passwordField.getText();
		        
		        if(id.equals("")){
		            JOptionPane.showMessageDialog(frame,"Please Enter StudentId");
		        }
		        if(pwd.equals("")){
		            JOptionPane.showMessageDialog(frame,"Please Enter Password");
		            
		        }
		        Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
					stmt = con.createStatement();
					PreparedStatement pst=con.prepareStatement("select * from users where id=? and password=?");
		            pst.setString(1, id);
		            pst.setString(2, pwd);
		            rs=pst.executeQuery();
		            if(rs.next()){
		            	frame.setVisible(false);
		                HomePage home = new HomePage();
		                home.initialize();
		                
		            }else{
		                JOptionPane.showMessageDialog(frame,"Login Credentials are wrong");
		            }
		        }catch(Exception e1){
		            e1.printStackTrace();
		        }
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(153, 394, 116, 49);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SignUp s=new SignUp();
				s.initialize();
				}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBounds(153, 477, 116, 49);
		panel_1.add(btnNewButton_1);
		frame.setVisible(true);
		
	}

		
		
		
	}

