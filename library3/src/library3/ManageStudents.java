package library3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageStudents {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudents window = new ManageStudents();
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
	public ManageStudents() {
		initialize();
	}
	public void setStudentDetailsToTable(){
		try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
			 Statement st=con.createStatement();
		     ResultSet rs=st.executeQuery("select * from student_details");
		       
		       while(rs.next()){
		           int student_id=rs.getInt(1);
		           String name=rs.getString(2);
		           String course=rs.getString(3);
		           String branch=rs.getString(4);
		           
		           Object[] obj={student_id,name,course,branch};
		           DefaultTableModel model=(DefaultTableModel)table.getModel();
		           model.addRow(obj);
		       }
		    }catch(Exception e){
		        e.printStackTrace();
		    }
    }
	public boolean addStudent(){
        boolean isAdded = false;
        int studentId=Integer.parseInt(textField.getText());
        String studentName=textField_1.getText();
        String course=textField_2.getText();
        String branch=textField_3.getText();
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            String sql="insert into student_details values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,studentId);
            pst.setString(2,studentName);
            pst.setString(3,course);
            pst.setString(4,branch);
            
            int rowCount=pst.executeUpdate();
            if(rowCount > 0){
                isAdded=true;
            }else{
                isAdded=false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
         return isAdded;    
    }
	public void clearTable(){
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
	public boolean updateStudent(){
        boolean isUpdated = false;
        int studentId=Integer.parseInt(textField.getText());
        String studentName=textField_1.getText();
        String course=textField_2.getText();
        String branch=textField_3.getText();
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            String sql="update student_details set name = ? ,course = ? ,branch = ? where student_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,studentName);
            pst.setString(2,course);
            pst.setString(3,branch);
            pst.setInt(4,studentId);
            
            int rowCount=pst.executeUpdate();
            if(rowCount > 0){
                isUpdated=true;
            }else{
                isUpdated=false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
         return isUpdated;    
    }
	public  boolean deleteStudent(){
		 boolean isDeleted = false;
	        int student_id=Integer.parseInt(textField.getText());
	        
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
	            String sql="delete from student_details where student_id = ?";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setInt(1,student_id);
	            
	           int rowCount=pst.executeUpdate();
	            if(rowCount > 0){
	                isDeleted=true;
	            }else{
	                isDeleted=false;
	            }
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	         return isDeleted;    
	    
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
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 534, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage h=new HomePage();
				h.initialize();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-back-50.png"));
		btnNewButton.setBounds(0, 0, 142, 52);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(124, 74, 220, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-student-id-50.png"));
		lblNewLabel_1.setBounds(47, 142, 50, 52);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-name-50.png"));
		lblNewLabel_2.setBounds(47, 250, 50, 52);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-course-50.png"));
		lblNewLabel_3.setBounds(47, 355, 50, 52);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-branch-50.png"));
		lblNewLabel_4.setBounds(47, 452, 50, 52);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("student id");
		lblNewLabel_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(124, 128, 220, 31);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("student name");
		lblNewLabel_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(124, 237, 220, 31);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("course");
		lblNewLabel_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(124, 337, 220, 31);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("branch");
		lblNewLabel_8.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(124, 436, 220, 22);
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(124, 159, 280, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 269, 280, 33);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addStudent() == true){
		            JOptionPane.showMessageDialog(frame,"Student Added!!");
		            clearTable();
		            setStudentDetailsToTable();
		        }else{
		            JOptionPane.showMessageDialog(frame, "Error occured while adding a student");
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setBounds(47, 557, 85, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(updateStudent() == true){
			            JOptionPane.showMessageDialog(frame,"student Record Updated!!");
			            clearTable();
			            setStudentDetailsToTable();
			        }else{
			            JOptionPane.showMessageDialog(frame, "Error occured while updating a student record");
			        }

			}
		});
		btnNewButton_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setBounds(189, 557, 100, 36);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deleteStudent() == true){
		            JOptionPane.showMessageDialog(frame,"student Deleted!!");
		            clearTable();
		            setStudentDetailsToTable();
		        }else{
		            JOptionPane.showMessageDialog(frame, "Error occured while Deleting a student");
		        } 
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.setBounds(352, 557, 85, 36);
		panel.add(btnNewButton_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 378, 280, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(124, 468, 280, 31);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(530, 0, 546,663);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("manage students");
		lblNewLabel_9.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-students-50 (1).png"));
		lblNewLabel_9.setBounds(122, 61, 294, 50);
		panel_1.add(lblNewLabel_9);
		
		table = new JTable();
		table.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo=table.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel)table.getModel();
		        
		        textField.setText(model.getValueAt(rowNo, 0).toString());
		        textField_1.setText(model.getValueAt(rowNo, 1).toString());
		        textField_2.setText(model.getValueAt(rowNo, 2).toString());
		        textField_3.setText(model.getValueAt(rowNo, 3).toString());
			}
		});
		table.setForeground(Color.WHITE);
		table.setBackground(Color.GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Book Id", "Book Name", "Author Name", "Quantity"
			}
		));
		table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setGridColor(new java.awt.Color(153, 153, 255));
        table.setRowHeight(25);
		
		table.setBounds(20, 123, 494, 415);
		panel_1.add(table);
		
		JButton btnNewButton_4 = new JButton("view students");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStudentDetailsToTable();
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_4.setBackground(Color.MAGENTA);
		btnNewButton_4.setBounds(191, 572, 225, 43);
		panel_1.add(btnNewButton_4);
		frame.setVisible(true);
		
	}
}
