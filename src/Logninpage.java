import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
public class  Logninpage implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JButton btn = new JButton();
	JTextField txt = new JTextField();
	JTextField pass = new JTextField();
	Logninpage(){
		
		label.setText("Hi there!!");
		label.setFont(new Font(null,Font.PLAIN,25));
		label.setForeground(new Color(0x09de5e));
		
		panel1.add(label);
		panel1.setBackground(new Color(0x090f12));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setSize(200,200);
		
		label1.setText("Account_Number: ");
		label1.setForeground(new Color(0x09de5e));
		label1.setFont(new Font(null,Font.PLAIN,25));
		
		txt.setPreferredSize(new Dimension(150,40));
		txt.setForeground(Color.white);
		txt.setBackground(new Color(0x090f12));
		txt.setCaretColor(Color.white);
		txt.setFont(new Font(null,Font.PLAIN,25));
		
		label2.setText("pass: ");
		label2.setForeground(new Color(0x09de5e));
		label2.setFont(new Font(null,Font.PLAIN,25));
		
		pass.setPreferredSize(new Dimension(150,40));
		pass.setForeground(Color.white);
		pass.setBackground(new Color(0x090f12));
		pass.setCaretColor(Color.white);
		pass.setFont(new Font(null,Font.PLAIN,25));
		
		panel2.add(label1);
		panel2.add(txt);
		panel2.add(label2);
		panel2.add(pass);
		panel2.setBackground(new Color(0x090f12));
		panel2.setLayout(new GridLayout(3,2,10,10));
		panel2.setSize(200,200);
		
		btn.setText("Submit");
		btn.addActionListener(this);
	    btn.setFont(new Font(null,Font.BOLD,19));
	    btn.setBackground(new Color(0x1d2e));
	    btn.setForeground(Color.WHITE);
	    btn.setFocusable(false);
		
		panel3.add(btn);
		panel3.setBackground(new Color(0x090f12));
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setSize(200,200);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.getContentPane().setBackground(new Color(0x090f12));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setTitle("FS-birr");
        frame.setSize(450,330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
		
        }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String acc = txt.getText();
		String pas = pass.getText();
	if(e.getSource() == btn) {
		
	 if(acc.equals("") || pas.equals("")) {
		 JOptionPane.showMessageDialog(frame, "Account or Password is empty");
	 }else{
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
				String sql = "SELECT *  FROM `customers` WHERE `Account_Number` = '"+acc+"' AND `password` = '"+pas+"'";
				 stmt.execute(sql);
				 ResultSet rs = stmt.executeQuery(sql);
				 if(rs.next()){
				   String account = rs.getString("Account_Number");
		           String password = rs.getString("password");
		           if(acc.equals(account) && pas.equals(password) ) {
		        	   MainPage New = new MainPage(acc);
		        	   frame.dispose();
		           }
			 }else{
	        	   JOptionPane.showMessageDialog(frame, "Account or Password is incoerct");
	           }
			
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }
		 } 
		 
	 }
}
	

