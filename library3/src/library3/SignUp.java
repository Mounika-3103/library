package library3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class SignUp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}
	public void insertSignUpDetails(){
		String uname=textField.getText();
	    String stuid=textField_1.getText();
	    String pwd=textField_2.getText();
	    String mail=textField_3.getText();
	    String rollno=textField_4.getText();
	    int uid=Integer.parseInt(stuid);
	    Connection con=null;
	    try{
        	Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            
            String sql="insert into users values(?,?,?,?,?);";
           PreparedStatement pst1=con.prepareStatement(sql);
           
           pst1.setString(2, uname);
           pst1.setInt(1, uid);
           pst1.setString(3, rollno);
           pst1.setString(4, pwd);
           pst1.setString(5, mail);
           int updatedRowCount =pst1.executeUpdate();
           if(updatedRowCount>0){
               JOptionPane.showMessageDialog(frame, "Created Account Successfully");
               textField.setText("");
	           textField_1.setText("");
	           textField_2.setText("");
	           textField_3.setText("");
	           textField_4.setText("");
           }else{
               JOptionPane.showMessageDialog(frame, "Error occured in Account Creation");
               textField.setText("");
	           textField_1.setText("");
	           textField_2.setText("");
	           textField_3.setText("");
	           textField_4.setText("");
           }
	    }
	    catch(Exception e2)
	    {
	    	System.out.println(e2);
	    }
    }
	boolean validcredentials(String uname,String stuid,String rollno,String pwd,String mail) {
		if(uname.equals("")){
	        JOptionPane.showMessageDialog(frame, "Please Enter UserName");
	        return false;
	        
	    }
	    if(stuid.equals("")){
	        JOptionPane.showMessageDialog(frame, "Please Enter StudentId");
	        return false;
	    }
	    if(rollno.equals("")){
	        JOptionPane.showMessageDialog(frame, "Please Enter RollNumber");
	        return false;
	    }
	    if(pwd.equals("")){
	        JOptionPane.showMessageDialog(frame, "Please Enter Password");
	        return false;
	    }
	    if(mail.equals("") || !mail.matches("^.+@.+\\..+$")){
	        JOptionPane.showMessageDialog(frame, "Please Enter vaild Email address");
	        return false; 
	    }
	    return true;
		
	}
	boolean checkduplicate(int uid)
	{
		boolean isExists=false;
		Connection con=null;
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            PreparedStatement pst=con.prepareStatement("select * from users where id=?");
            pst.setInt(1, uid);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                isExists=true;
            }else{
                isExists=false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExists;
	}
	void signupPerformed(ActionEvent e,String uname,String stuid,String rollno,String pwd,String mail)
	{
		int uid=Integer.parseInt(stuid);
		boolean valid=validcredentials(uname,stuid,rollno,pwd,mail);
	    boolean check=checkduplicate(uid);
		if(valid == true){
			if(check==false)
			{
	        insertSignUpDetails(); 
	        frame.setVisible(false);
	        login lp=new login();
	        lp.initialize();
	        
	    }else{
	         JOptionPane.showMessageDialog(frame,"Student id already exists");   
	        }
	    }
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1101, 699);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 10, 625,699);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\signup-library-icon.png"));
		lblNewLabel.setBounds(10, 119, 613, 515);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("welcome  to  sign up page");
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel_1.setBounds(24, 22, 545, 72);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.MAGENTA);
		panel_1.setBounds(637, 10,440,652);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" sign up");
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel_2.setBounds(130, 28, 197, 36);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("create account");
		lblNewLabel_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_3.setBounds(116, 73, 222, 36);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-person-50.png"));
		lblNewLabel_4.setBounds(41, 144, 50, 50);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-person-50.png"));
		lblNewLabel_5.setBounds(41, 241, 50, 50);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-password-50.png"));
		lblNewLabel_6.setBounds(41, 405, 50, 50);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-email-50.png"));
		lblNewLabel_7.setBounds(41, 487, 50, 50);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("user name");
		lblNewLabel_8.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(116, 144, 222, 20);
		panel_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(116, 175, 240, 36);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("student id");
		lblNewLabel_9.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(116, 221,222, 25);
		panel_1.add(lblNewLabel_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 255, 240, 36);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("password");
		lblNewLabel_10.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_10.setBounds(116, 384, 222, 25);
		panel_1.add(lblNewLabel_10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 419, 240, 36);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("email");
		lblNewLabel_11.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_11.setBounds(120, 465, 207, 20);
		panel_1.add(lblNewLabel_11);
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 495, 240, 36);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=textField.getText();
			    String stuid=textField_1.getText();
			    String pwd=textField_2.getText();
			    String mail=textField_3.getText();
			    String rollno=textField_4.getText();
			    int uid=Integer.parseInt(stuid);
			    signupPerformed(e,uname,stuid,rollno,pwd,mail);
			}
		}
		);
		
		
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(41, 574, 117, 42);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login l=new login();
				l.initialize();}
		});
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setBounds(251, 578, 105, 36);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-register-50.png"));
		lblNewLabel_12.setBounds(41, 324, 50, 50);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("roll no");
		lblNewLabel_13.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_13.setBounds(116, 305, 201, 21);
		panel_1.add(lblNewLabel_13);
		
		textField_4 = new JTextField();
		textField_4.setBounds(116, 336, 240, 38);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		frame.setVisible(true);
		}
}


