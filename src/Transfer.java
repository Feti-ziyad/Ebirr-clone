import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
public class Transfer implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JTextField txt4 = new JTextField();
	JButton btn = new JButton();
	JButton btn1 = new JButton(); 
	JButton btn2 = new JButton(); 
	String acc;
	Transfer(String acc){
		this.acc = acc;
		label.setText("Hi there!!");
		label.setForeground(new Color(0x09de5e));
		label.setFont(new Font(null,Font.PLAIN,25));
		
		panel.add(label);
		panel.setBackground(new Color(0x090f12));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setSize(200,200);
		
		label1.setText("Account_Number: ");
		label1.setForeground(new Color(0x09de5e));
		label1.setFont(new Font(null,Font.PLAIN,25));
		
		txt1.setPreferredSize(new Dimension(150,40));
		txt1.setForeground(Color.white);
		txt1.setBackground(new Color(0x090f12));
		txt1.setCaretColor(Color.white);
		txt1.setFont(new Font(null,Font.PLAIN,25));
		
		
		panel1.add(label1);
		panel1.add(txt1);
		panel1.setBackground(new Color(0x090f12));
		panel1.setLayout(new GridLayout(1,2,10,10));
		panel1.setSize(200,200);
		
		btn.setText("Verify Reciver");
		btn.addActionListener(this);
	    btn.setFont(new Font(null,Font.BOLD,19));
	    btn.setBackground(new Color(0x1d2e));
	    btn.setForeground(Color.WHITE);
	    btn.setFocusable(false);
	    
	    panel2.add(btn);
	    panel2.setBackground(new Color(0x090f12));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setSize(200,200);
		

		label2.setText("Resiver_Name: ");
		label2.setForeground(new Color(0x09de5e));
		label2.setFont(new Font(null,Font.PLAIN,25));
		
		txt2.setPreferredSize(new Dimension(150,40));
		txt2.setForeground(Color.white);
		txt2.setBackground(new Color(0x090f12));
		txt2.setCaretColor(Color.white);
		txt2.setFont(new Font(null,Font.PLAIN,25));
		
		label3.setText("Amount: ");
		label3.setForeground(new Color(0x09de5e));
		label3.setFont(new Font(null,Font.PLAIN,25));
		
		txt3.setPreferredSize(new Dimension(150,40));
		txt3.setForeground(Color.white);
		txt3.setBackground(new Color(0x090f12));
		txt3.setCaretColor(Color.white);
		txt3.setFont(new Font(null,Font.PLAIN,25));
		
		panel3.add(label2);
		panel3.add(txt2);
		panel3.add(label3);
		panel3.add(txt3);
		panel3.setBackground(new Color(0x090f12));
		panel3.setLayout(new GridLayout(2,2,10,10));
		panel3.setSize(200,200);
		
	    btn1.setText("Submit");
		btn1.addActionListener(this);
	    btn1.setFont(new Font(null,Font.BOLD,19));
	    btn1.setBackground(new Color(0x1d2e));
	    btn1.setForeground(Color.WHITE);
	    btn1.setFocusable(false);
	    
	    btn2.setText("Back to Home Page");
		btn2.addActionListener(this);
	    btn2.setFont(new Font(null,Font.BOLD,19));
	    btn2.setBackground(new Color(0x1d2e));
	    btn2.setForeground(Color.WHITE);
	    btn2.setFocusable(false);
	    
	    panel4.add(btn1);
		panel4.add(btn2);
		panel4.setBackground(new Color(0x090f12));
		panel4.setLayout(new GridLayout(3,2,10,10));
		panel4.setSize(200,200);
		
		frame.add(panel);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.getContentPane().setBackground(new Color(0x090f12));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setTitle("FS-birr");
        frame.setSize(490,430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String account = txt1.getText();
	     String amount =  txt3.getText();
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
		if (e.getSource() == btn) {
		 String sql = "SELECT `Account_Number` , `F_name` FROM `customers` WHERE `Account_Number` =  '"+account+"'";
	     ResultSet rs = stmt.executeQuery(sql);
        if(account.equals("")) {
			 JOptionPane.showMessageDialog(frame, "Account is empty ");
		 }else if (!rs.next()) {
//		        	        String notfound_acc = rs.getString("Account_Number");
    	        JOptionPane.showMessageDialog(frame, "user not found");
    	    }else {
    	    	   String Acc = rs.getString("F_name");
    	    	txt2.setText(Acc);
    	    	txt2.setEditable(false);
		}    
	}
			if(e.getSource() == btn1) {
			   if(amount.equals("") || amount.equals("0")) {
			 JOptionPane.showMessageDialog(frame, "Amount is empty or 0 can't be transferd");
			 }else{
				 try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
			    e1.printStackTrace();
			}
		
		    try {
		    	 String sql = "SELECT * FROM `account` WHERE `Account_Number` = '" + acc + "'";
		         ResultSet rs = stmt.executeQuery(sql);
		        if (rs.next()) {
		            String balance = rs.getString("Balance");
		            int Old = Integer.valueOf(balance);
		            int New = Integer.valueOf(amount);
		            if(New > Old) {
		            
		            }else {
		            	int sub = Old - New;
		                String NewAmount = String.valueOf(sub);
		                sql = " UPDATE `account` SET `Balance` = '" + NewAmount + "' WHERE `Account_Number` = '" + acc + "'";
		                stmt.executeUpdate(sql);
		            }
				 }
			    } catch (SQLException e1) {
			    e1.printStackTrace(); 
			 }
            try {
            	String sqlup = "SELECT * FROM `account` WHERE `Account_Number` = '" + account + "'";
		         ResultSet Nrs = stmt.executeQuery(sqlup);
	            if (Nrs.next()) {
	            	String Account = Nrs.getString("Account_Number");
	                String N_balance = Nrs.getString("Balance");
	                int Old_A = Integer.valueOf(N_balance);
	                int New_A = Integer.valueOf(amount);
	                	if(New_A > Old_A) {
	                	JOptionPane.showMessageDialog(frame, "Your amount is not sufficient");
		                }else {
	                	 int sum = Old_A + New_A;
	 	                String New_Amount = String.valueOf(sum);
	 	                sqlup = " UPDATE `account` SET `Balance` = '" + New_Amount + "' WHERE `Account_Number` = '" + account + "' ";
	 	                JOptionPane.showMessageDialog(frame, "Transferd Successfully!");
	 	               stmt.executeUpdate(sqlup);
	 	              frame.dispose();
		                }    
	            }
            } catch(SQLException e1) {
            e1.printStackTrace(); 
    	} 
	 }
}
			if (e.getSource() == btn2) {
		    	 MainPage New = new MainPage(acc);
		    	 frame.dispose();
		    }	
	}catch (SQLException e1) {
		// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}


