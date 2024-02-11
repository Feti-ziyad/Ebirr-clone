import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
public class Balance implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JButton btn = new JButton();
    String acc;
	Balance(String acc){
		this.acc = acc;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		 Connection con;
			Statement stmt;
			try {
				con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/fs-birr","root","");
				stmt = con.createStatement();
				String sql = "SELECT *  FROM `account` WHERE `Account_Number` = '"+acc+"' ";
				 stmt.execute(sql);
				 ResultSet rs = stmt.executeQuery(sql);
				 if(rs.next()){
					   String balance = rs.getString("Balance");
					   
						label.setText("Hi there!!");
						label.setForeground(new Color(0x09de5e));
						label.setFont(new Font(null,Font.PLAIN,25));
						
						panel.add(label);
						panel.setBackground(new Color(0x090f12));
						panel.setLayout(new FlowLayout(FlowLayout.CENTER));
						panel.setSize(200,200);
					   
						label1.setText("Your Account Balence is: " + balance);
						label1.setForeground(new Color(0x09de5e));
						label1.setFont(new Font(null,Font.PLAIN,25));
						
						btn.setText("Back to Home Page");
						btn.addActionListener(this);
					    btn.setFont(new Font(null,Font.BOLD,19));
					    btn.setForeground(Color.WHITE);
					    btn.setBackground(new Color(0x1d2e));
					    btn.setFocusable(false);
					    
					    panel1.add(label1);
					    panel1.add(btn);
					    panel1.setBackground(new Color(0x090f12));
						panel1.setLayout(new GridLayout(2,2,10,10));
						panel1.setSize(200,200);
						
						frame.add(panel);
						frame.add(panel1);
						frame.getContentPane().setBackground(new Color(0x090f12));
						frame.setLayout(new FlowLayout(FlowLayout.CENTER));
						frame.setTitle("FS-birr");
				        frame.setSize(490,250);
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame.setResizable(false);
				        frame.setVisible(true);
				 }
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
 	       MainPage New = new MainPage(acc);
		  frame.dispose();
	}
}
