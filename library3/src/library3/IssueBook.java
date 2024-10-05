package library3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class IssueBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtYyyymmdd;
	private JTextField txtYyyymmdd_1;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_6;
	JLabel lblNewLabel_7;
	JLabel lblNewLabel_8;
	JLabel lblNewLabel_9;
	JLabel lblNewLabel_10;
	JLabel lblNewLabel_11;
	JLabel lblNewLabel_12;
	JLabel lblNewLabel_13;
	JLabel lblNewLabel_14;
	JLabel lblNewLabel_15;
	JLabel lblNewLabel_16;
	JLabel lblNewLabel_17;
	JLabel lblNewLabel_18;
	JLabel lblNewLabel_19;
	JLabel lblNewLabel_20;
	JLabel lblNewLabel_21;
	JLabel lblNewLabel_22;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook window = new IssueBook();
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
	public IssueBook() {
		initialize();
	}
	public void getBookDetails(){
        int bookId= Integer.parseInt(textField.getText());
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            PreparedStatement pst=con.prepareStatement("select  * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
            	 lblNewLabel_19.setText(String.valueOf(rs.getInt(1)));
            	 lblNewLabel_20.setText(rs.getString(2));
            	 lblNewLabel_21.setText(rs.getString(3));
            	lblNewLabel_22.setText(rs.getString(4));   
            }else{
                clearDetails();
                JOptionPane.showMessageDialog(frame, "invalid book details");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	public void getStudentDetails(){
        int studentId= Integer.parseInt(textField_1.getText());
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            PreparedStatement pst=con.prepareStatement("select  * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
            	 lblNewLabel_11.setText(rs.getString(1));
            	 lblNewLabel_12.setText(rs.getString(2));
            	 lblNewLabel_13.setText(rs.getString(3));
            	 lblNewLabel_14.setText(rs.getString(4));   
            }else{
                clearDetails();
                 JOptionPane.showMessageDialog(frame,"Invalid Student Id!!!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	public boolean issueBook(){
        boolean isIssued=false;
        int bookId=Integer.parseInt(textField.getText());
        int studentId=Integer.parseInt(textField_1.getText());
        String studentName=lblNewLabel_12.getText();
        String bookName=lblNewLabel_20.getText();
        String IssueDate=txtYyyymmdd.getText();
        String DueDate=txtYyyymmdd_1.getText();
            
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
        String sql= "insert into issue_books values(?,?,?,?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1, bookId);
        pst.setString(2, bookName);
        pst.setInt(3, studentId);
        pst.setString(4, studentName);
        pst.setString(5, IssueDate);
        pst.setString(6, DueDate);
        pst.setString(7, "pending");
        
        int rowCount = pst.executeUpdate();
        if( rowCount > 0){
            isIssued=true;
        }else{
            isIssued=false;
        }
    }catch(Exception e){
        e.printStackTrace();
    }
      return isIssued;  
    }
	public void updateBookCount(){
        
	       int bookId=Integer.parseInt(textField.getText());
	       
	       try{
	    	   Class.forName("com.mysql.jdbc.Driver");
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
	        String sql="update book_details set quantity=quantity - 1 where book_id = ? ";
	        PreparedStatement pst=con.prepareStatement(sql);
	        pst.setInt(1, bookId);
	        int rowCount = pst.executeUpdate();
	        
	        if( rowCount > 0){
	            JOptionPane.showMessageDialog(frame,"book count Updated");
	            int initialCount=Integer.parseInt(lblNewLabel_22.getText());
	            lblNewLabel_22.setText(Integer.toString(initialCount - 1));
	        }else{
	            JOptionPane.showMessageDialog(frame,"can't issue the Book");
	        }
	        
	       }catch(Exception e){
	        e.printStackTrace();
	    }
	    }
	public boolean isAlreadyIssued(){
        boolean isAlreadyIssued=false;
        int bookId=Integer.parseInt(textField.getText());
        int studentId=Integer.parseInt(textField_1.getText());
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            String sql="select * from issue_books where book_id = ? and student_id= ? and status = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                isAlreadyIssued=true;
            }else{
                isAlreadyIssued=false;
            }
        }catch(Exception e){
        e.printStackTrace();
    }
       return isAlreadyIssued; 
    }
	public void clearDetails(){
		lblNewLabel_19.setText("");
		lblNewLabel_20.setText("");
		lblNewLabel_21.setText("");
		lblNewLabel_22.setText("");
		lblNewLabel_11.setText("");
        lblNewLabel_12.setText("");
        lblNewLabel_13.setText("");
        lblNewLabel_14.setText(""); 
        textField.setText("");
        textField_1.setText("");
        txtYyyymmdd.setText("YYYY-MM-DD");
        txtYyyymmdd_1.setText("YYYY-MM-DD");
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
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 370, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage h=new HomePage();
				h.initialize();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-back-50.png"));
		btnNewButton.setBounds(0, 0, 142, 50);
		panel.add(btnNewButton);
		
		lblNewLabel = new JLabel("book details");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-book-50 (1).png"));
		lblNewLabel.setBounds(46, 77, 247, 50);
		panel.add(lblNewLabel);
		
		 lblNewLabel_15 = new JLabel("book id");
		lblNewLabel_15.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_15.setBounds(28, 167, 91, 29);
		panel.add(lblNewLabel_15);
		
		 lblNewLabel_16 = new JLabel("book name");
		lblNewLabel_16.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_16.setBounds(21, 241, 98, 29);
		panel.add(lblNewLabel_16);
		
		 lblNewLabel_17 = new JLabel("author");
		lblNewLabel_17.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_17.setBounds(28, 319, 91, 23);
		panel.add(lblNewLabel_17);
		
		 lblNewLabel_18 = new JLabel("quantity");
		lblNewLabel_18.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_18.setBounds(28, 382, 91, 29);
		panel.add(lblNewLabel_18);
		
		 lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setBounds(129, 161, 176, 29);
		panel.add(lblNewLabel_19);
		
		 lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setBounds(129, 235, 176, 29);
		panel.add(lblNewLabel_20);
		
		 lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(129, 319, 164, 29);
		panel.add(lblNewLabel_21);
		
		 lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(129, 382, 164, 29);
		panel.add(lblNewLabel_22);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.MAGENTA);
		panel_1.setBounds(365, 0, 370, 663);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		

		lblNewLabel_1 = new JLabel("student details");
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-person-50.png"));
		lblNewLabel_1.setBounds(22, 70, 278, 50);
		panel_1.add(lblNewLabel_1);
		

		lblNewLabel_7 = new JLabel("student id");
		lblNewLabel_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(22, 152, 88, 23);
		panel_1.add(lblNewLabel_7);
		
		 lblNewLabel_8 = new JLabel("name");
		lblNewLabel_8.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(22, 225, 98, 23);
		panel_1.add(lblNewLabel_8);
		
		 lblNewLabel_9 = new JLabel("course");
		lblNewLabel_9.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(22, 291, 88, 29);
		panel_1.add(lblNewLabel_9);
		
		 lblNewLabel_10 = new JLabel("branch");
		lblNewLabel_10.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_10.setBounds(22, 369, 88, 29);
		panel_1.add(lblNewLabel_10);
		
		 lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(137, 152, 163, 20);
		panel_1.add(lblNewLabel_11);
		

		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(137, 224, 184, 29);
		panel_1.add(lblNewLabel_12);
		
		 lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBounds(137, 291, 184, 29);
		panel_1.add(lblNewLabel_13);
		
		 lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(137, 363, 184, 29);
		panel_1.add(lblNewLabel_14);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(736, 0, 350, 663);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		

		lblNewLabel_2 = new JLabel("issue book");
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-books-50.png"));
		lblNewLabel_2.setBounds(52, 69, 188, 50);
		panel_2.add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel("book id");
		lblNewLabel_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(23, 158, 88, 29);
		panel_2.add(lblNewLabel_3);
		

		lblNewLabel_4 = new JLabel("student id");
		lblNewLabel_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(23, 226, 88, 29);
		panel_2.add(lblNewLabel_4);
		

		lblNewLabel_5 = new JLabel("issue date");
		lblNewLabel_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(23, 302, 88, 29);
		panel_2.add(lblNewLabel_5);
		
		 lblNewLabel_6 = new JLabel("due date");
		lblNewLabel_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(23, 375, 88, 29);
		panel_2.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(123, 155, 195, 29);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 223, 197, 32);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		txtYyyymmdd.setText("YYYY-MM-DD");
		txtYyyymmdd.setBounds(121, 295, 197, 36);
		panel_2.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		txtYyyymmdd_1 = new JTextField();
		txtYyyymmdd_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		txtYyyymmdd_1.setText("YYYY-MM--DD");
		txtYyyymmdd_1.setBounds(121, 365, 197, 36);
		panel_2.add(txtYyyymmdd_1);
		txtYyyymmdd_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("issue book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblNewLabel_22.getText().equals("0")){
		            JOptionPane.showMessageDialog(frame, "Book is Not available");
		            clearDetails();
		        }else{
		        if(isAlreadyIssued() == false){ 
		            if(issueBook() == true){
		            JOptionPane.showMessageDialog(frame, "Book Issued!!");
		            updateBookCount();
		            //clearDetails();
		            }else{
		           JOptionPane.showMessageDialog(frame, "Error occured while Book Issuing!!"); 
		           clearDetails();
		            }
		        }else{
		            JOptionPane.showMessageDialog(frame,"Book is Already issued to this Student!!");
		            //clearDetails();
		        }
		       }
		    }
		
		});
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(83, 503, 157, 42);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("find");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getBookDetails();
				getStudentDetails();
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(109, 439, 85, 43);
		panel_2.add(btnNewButton_2);
		frame.setVisible(true);
	}
}
