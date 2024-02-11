import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
public class MobileTopups implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JButton btn = new JButton();
	JButton btn1 = new JButton(); 
	JTextField txt = new JTextField();
	JTextField amount = new JTextField();
	String acc;
	MobileTopups(String acc){
		this.acc = acc;
		label.setText("Hi there!!");
		label.setForeground(new Color(0x09de5e));
		label.setFont(new Font(null,Font.PLAIN,25));
		
		panel1.add(label);
		panel1.setBackground(new Color(0x090f12));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setSize(200,200);
		
		label1.setText("Phone_Number: ");
		label1.setForeground(new Color(0x09de5e));
		label1.setFont(new Font(null,Font.PLAIN,25));
		
		txt.setPreferredSize(new Dimension(150,40));
		txt.setForeground(Color.white);
		txt.setBackground(new Color(0x090f12));
		txt.setCaretColor(Color.white);
		txt.setFont(new Font(null,Font.PLAIN,25));
		
		label2.setText("Amount: ");
		label2.setForeground(new Color(0x09de5e));
		label2.setFont(new Font(null,Font.PLAIN,25));
		
		amount.setPreferredSize(new Dimension(150,40));
		amount.setForeground(Color.white);
		amount.setBackground(new Color(0x090f12));
		amount.setCaretColor(Color.white);
		amount.setFont(new Font(null,Font.PLAIN,25));
		
		panel2.add(label1);
		panel2.add(txt);
		panel2.add(label2);
		panel2.add(amount);
		panel2.setBackground(new Color(0x090f12));
		panel2.setLayout(new GridLayout(3,2,10,10));
		panel2.setSize(200,200);
		
		btn.setText("Submit");
		btn.addActionListener(this);
	    btn.setFont(new Font(null,Font.BOLD,19));
	    btn.setBackground(new Color(0x1d2e));
	    btn.setForeground(Color.WHITE);
	    btn.setFocusable(false);
	    
	    btn1.setText("Back to Home Page");
		btn1.addActionListener(this);
	    btn1.setFont(new Font(null,Font.BOLD,19));
	    btn1.setBackground(new Color(0x1d2e));
	    btn1.setForeground(Color.WHITE);
	    btn1.setFocusable(false);
		
		panel3.add(btn);
		panel3.add(btn1);
		panel3.setBackground(new Color(0x090f12));
		panel3.setLayout(new GridLayout(2,1,10,10));
		panel3.setSize(200,200);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.getContentPane().setBackground(new Color(0x090f12));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setTitle("FS-birr");
        frame.setSize(450,370);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String PhoneNumber = txt.getText();
	     String Amount =  amount.getText();
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	 Connection con;
		Statement stmt;
         if(e.getSource() == btn) {
  			try {
				con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/fs-birr","root","");
				stmt = con.createStatement();
				if (e.getSource() == btn) {
				 String sql = "SELECT * FROM `account` WHERE `Account_Number` =  '"+acc+"'";
			     ResultSet rs = stmt.executeQuery(sql);
		        if(PhoneNumber.equals("")) {
					 JOptionPane.showMessageDialog(frame, "Phone_Number is empty ");
				 } else if(Amount.equals("") || Amount.equals("0")) {
					 JOptionPane.showMessageDialog(frame, "Amount is empty or 0 can't be transferd");
					 }else{
	 				    try {
 				        if (rs.next()) {
 				            String balance = rs.getString("Balance");
 				            int Old = Integer.valueOf(balance);
 				            int New = Integer.valueOf(Amount);
 				            if(New > Old) {
 				            
 				            }else {
			            	int sub = Old - New;
			                String NewAmount = String.valueOf(sub);
			                sql = " UPDATE `account` SET `Balance` = '" + NewAmount + "' WHERE `Account_Number` = '" + acc + "'";
			                stmt.executeUpdate(sql);
			                JOptionPane.showMessageDialog(frame, "Successfully recharged!!");
			                frame.dispose();
 				                      }
	 						  }
		    } catch (SQLException e1) {
			    e1.printStackTrace(); 
			 }
		   }
	}
	 } catch (SQLException e1) {
		    e1.printStackTrace(); 
		 }

     }
	if (e.getSource() == btn1) {
		MainPage New = new MainPage(acc);
		frame.dispose();
    }
}
}
