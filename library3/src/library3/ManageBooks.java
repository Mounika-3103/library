package library3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ManageBooks {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBooks window = new ManageBooks();
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
	public boolean addBook(){
		boolean isAdded = false;
        int bookId=Integer.parseInt(textField.getText());
        String bookName=textField_1.getText();
        String author=textField_2.getText();
        int quantity=Integer.parseInt(textField_3.getText());
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            String sql="insert into book_details values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookName);
            pst.setString(3,author);
            pst.setInt(4,quantity);
            int rowCount=pst.executeUpdate();
            if(rowCount > 0){
                isAdded=true;
            }else{
                isAdded=false;
            }
            
        }catch(Exception e1){
            e1.printStackTrace();
        }
        return isAdded;
	}
	public void clearTable(){
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
	public void setBookDetailsToTable(){
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
			 Statement st=con.createStatement();
		     ResultSet rs=st.executeQuery("select * from book_details");
		       
		       while(rs.next()){
		           int bookid=rs.getInt(1);
		           String bookname=rs.getString(2);
		           String author=rs.getString(3);
		           int quantity=rs.getInt(4);
		           
		           Object[] obj={bookid,bookname,author,quantity};
		           DefaultTableModel model=(DefaultTableModel)table.getModel();
		           model.addRow(obj);
		       }
		    }catch(Exception e){
		        e.printStackTrace();
		    }
		    }
	public boolean updateBook(){
        boolean isUpdated = false;
        int bookId=Integer.parseInt(textField.getText());
        String bookName=textField_1.getText();
        String author=textField_2.getText();
        int quantity=Integer.parseInt(textField_3.getText());
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            String sql="update book_details set bookname = ? ,author_name = ? ,quantity = ? where book_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,bookName);
            pst.setString(2,author);
            pst.setInt(3,quantity);
            pst.setInt(4,bookId);
            
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
	public  boolean deleteBook(){
        boolean isDeleted = false;
        int bookId=Integer.parseInt(textField.getText());
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            String sql="delete from book_details where book_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            
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
        
        	
        
	public ManageBooks() {
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
		panel.setBackground(Color.MAGENTA);
		panel.setBounds(0, 0, 561, 663);
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-back-50.png"));
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(0, 0, 135, 47);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(" Book details");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(174, 55, 204, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-book-50.png"));
		lblNewLabel_1.setBounds(50, 144, 50, 52);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-book-50 (1).png"));
		lblNewLabel_2.setBounds(50, 230, 50, 52);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-person-50.png"));
		lblNewLabel_3.setBounds(50, 330, 50, 47);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-quantity-50.png"));
		lblNewLabel_4.setBounds(60, 443, 50, 52);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Book id");
		lblNewLabel_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(142, 125, 265, 29);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Book Name");
		lblNewLabel_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(142, 214, 236, 29);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Author Name");
		lblNewLabel_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(142, 323, 236, 29);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Quantity");
		lblNewLabel_8.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(146, 427, 232, 29);
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(142, 164, 288, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 253, 288, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 362, 288, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 468, 288, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addBook() == true){
		            JOptionPane.showMessageDialog(frame,"Book Added!!");
		            clearTable();
		            setBookDetailsToTable();
		        }else{
		            JOptionPane.showMessageDialog(frame, "Error occured while adding a book");
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(50, 557, 85, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(updateBook() == true){
			            JOptionPane.showMessageDialog(frame,"Book Record Updated!!");
			            clearTable();
			            setBookDetailsToTable();
			        }else{
			            JOptionPane.showMessageDialog(frame, "Error occured while updating a book record");
			        }
			}
		});
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_2.setBounds(206, 559, 102, 47);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deleteBook() == true){
		            JOptionPane.showMessageDialog(frame,"Book Deleted!!");
		            clearTable();
		            setBookDetailsToTable();
		        }else{
		            JOptionPane.showMessageDialog(frame, "Error occured while Deleting a book");
		        } 
			}
		});
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_3.setBounds(377, 557, 97, 47);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(557, 0, 1114,663);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Manage Books");
		lblNewLabel_9.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\W5ZQ1M53\\icons8-books-50[1].png"));
		lblNewLabel_9.setBounds(128, 50, 269, 50);
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
		
		table.setBounds(20, 123, 494, 433);
		panel_1.add(table);
		
		JButton btnNewButton_4 = new JButton("view books");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBookDetailsToTable();
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setBounds(144, 592, 231, 42);
		panel_1.add(btnNewButton_4);
		frame.setVisible(true);
		
		
		
	}
}
