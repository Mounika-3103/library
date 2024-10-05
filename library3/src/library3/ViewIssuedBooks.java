package library3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewIssuedBooks {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewIssuedBooks window = new ViewIssuedBooks();
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
	public ViewIssuedBooks() {
		initialize();
	}
	public void setIssueBookDetailsToTable(){
		   
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","manager");
            PreparedStatement pst=con.prepareStatement("select * from issue_books ");
            
            ;
            ResultSet rs=pst.executeQuery();
            
            while (rs.next()){
              String bookId= String.valueOf(rs.getInt(1));
              String bookName= rs.getString(2);
              String studentName= rs.getString(4);
              String issueDate= rs.getString(5);
              String dueDate= rs.getString(6);
              String status= rs.getString(7);
              
              Object[] obj={bookId, bookName,studentName,issueDate,dueDate,status};
              DefaultTableModel model = (DefaultTableModel) table.getModel();
              model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
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
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 1086, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("view issued books");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-books-50.png"));
		lblNewLabel.setBounds(394, 48, 344, 52);
		panel.add(lblNewLabel);
		
		
	
		
		JButton btnNewButton = new JButton("view");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setIssueBookDetailsToTable();
			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(448, 584, 202, 52);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		table.setForeground(Color.WHITE);
		table.setBackground(Color.GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"Issue Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
			}
		));
		table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setGridColor(new java.awt.Color(153, 153, 255));
        table.setRowHeight(25);
		table.setBounds(72, 112,  930, 433);
		panel.add(table);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(448, 584, 202, 52);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage h=new HomePage();
				h.initialize();
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Radhamadhava\\Downloads\\icons8-back-50.png"));
		btnNewButton_1.setBounds(0, 0, 147, 52);
		panel.add(btnNewButton_1);
		frame.setVisible(true);
	}

}
