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

public class ReturnBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public boolean returnBook(){
    boolean isReturned=false;
    int bookId= Integer.parseInt(textField.getText());
    int studentId=Integer.parseInt(textField_1.getText());
     
    try{
    	Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
        String sql="update issue_books set status = ? where student_id = ? and book_id = ? and status = ?";
        
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, "Returned");
        pst.setInt(2,studentId);
        pst.setInt(3, bookId);
        pst.setString(4, "pending");
        
        int rowCount=pst.executeUpdate();
        if(rowCount > 0){
            isReturned= true;
        }else{
           isReturned= false; 
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return isReturned;
}
public void clearDetails(){
	lblNewLabel_9.setText("");
	lblNewLabel_10.setText("");
	lblNewLabel_11.setText("");
	lblNewLabel_12.setText("");
	lblNewLabel_13.setText("");
     
    textField.setText("");
    textField_1.setText("");
    
}
public void updateBookCount(){
    
    int bookId=Integer.parseInt(textField.getText());
    
    try{
    	Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
     String sql="update book_details set quantity=quantity + 1 where book_id = ? ";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setInt(1, bookId);
     int rowCount = pst.executeUpdate();
     
     if( rowCount > 0 ){
         JOptionPane.showMessageDialog(frame,"Book count Updated");
         clearDetails();
     }else{
         JOptionPane.showMessageDialog(frame,"Book count can't updated!");
     }
     
    }catch(Exception e1){
     e1.printStackTrace();
 }
}
	/**
	 * Create the application.
	 */
	public ReturnBook() {
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
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 560, 663);
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
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-back-50.png"));
		btnNewButton.setBounds(0, 0, 142, 50);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("book details");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-book-50 (1).png"));
		lblNewLabel.setBounds(115, 81, 262, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("issue id");
		lblNewLabel_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(42, 169, 100, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("book name");
		lblNewLabel_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(42, 235, 100, 25);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("student name");
		lblNewLabel_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(42, 303, 123, 25);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("issue date");
		lblNewLabel_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(42, 372, 100, 25);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("due date");
		lblNewLabel_8.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(42, 447, 82, 25);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(188, 158, 189, 32);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(188, 224, 189, 32);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(188, 303, 189, 25);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(188, 368, 189, 29);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBounds(188, 435, 189, 39);
		panel.add(lblNewLabel_13);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(557, 0, 529, 663);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("return book");
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-books-50.png"));
		lblNewLabel_1.setBounds(97, 71, 324, 51);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("book id");
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(65, 168, 120, 38);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("student id");
		lblNewLabel_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(65, 250, 118, 31);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("find");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getIssueBookDetails();
				int bookId= Integer.parseInt(textField.getText());
		        int studentId=Integer.parseInt(textField_1.getText());
		        
		        try{
		        	Class.forName("com.mysql.jdbc.Driver");
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
		            String sql="select * from issue_books where book_id = ? and student_id = ? and status = ?";
		            
		            PreparedStatement pst=con.prepareStatement(sql);
		            pst.setInt(1, bookId);
		            pst.setInt(2,studentId);
		            pst.setString(3, "pending");
		            
		            ResultSet rs=pst.executeQuery();
		            if(rs.next()){
		                
		                lblNewLabel_9.setText(String.valueOf(rs.getInt(1)));
		                lblNewLabel_10.setText(rs.getString(2));
		                lblNewLabel_11.setText(rs.getString(4));
		                lblNewLabel_12.setText(rs.getString(5));
		                lblNewLabel_13.setText(rs.getString(6));
		           
		            }else{
		            	lblNewLabel_9.setText("");
		            	lblNewLabel_10.setText("");
		            	lblNewLabel_11.setText("");
		            	lblNewLabel_12.setText("");
		            	lblNewLabel_13.setText("");
		                JOptionPane.showMessageDialog(frame,"No Record Found!!");
		                
		            }
		        }catch(Exception e1){
		            e1.printStackTrace();
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(189, 348, 98, 51);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("return book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (returnBook() == true){
			           JOptionPane.showMessageDialog(frame,"Book returned Successfully!!");
			           updateBookCount();
			           clearDetails();
			       }else{
			           JOptionPane.showMessageDialog(frame,"Error occured while returning the Book !!");
			           clearDetails();
			       }
			}
		});
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(167, 460, 172, 44);
		panel_1.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(195, 176, 216, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 250, 216, 31);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		frame.setVisible(true);
	}

}
