import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
public class MainPage  implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	JButton btn3 = new JButton();
	JButton btn4 = new JButton();
	 String acc;
	 MainPage(String acc){
		  this.acc = acc;
		
		btn1.setText("Check Balance Query");
		btn1.addActionListener(this);
	    btn1.setFont(new Font(null,Font.BOLD,19));
	    btn1.setForeground(Color.WHITE);
	    btn1.setBackground(new Color(0x1d2e));
	    btn1.setFocusable(false);
	    
	    btn2.setText("Transfer Money");
		btn2.addActionListener(this);
	    btn2.setFont(new Font(null,Font.BOLD,19));
	    btn2.setForeground(Color.WHITE);
	    btn2.setBackground(new Color(0x1d2e));
	    btn2.setFocusable(false);
	    
	    btn3.setText("Cash Out");
		btn3.addActionListener(this);
	    btn3.setFont(new Font(null,Font.BOLD,19));
	    btn3.setForeground(Color.WHITE);
	    btn3.setBackground(new Color(0x1d2e));
	    btn3.setFocusable(false);
	    
	    btn4.setText("Mobile to ups");
		btn4.addActionListener(this);
		btn4.setPreferredSize(new Dimension(250,250));
	    btn4.setFont(new Font(null,Font.BOLD,19));
	    btn4.setForeground(Color.WHITE);
	    btn4.setBackground(new Color(0x1d2e));
	    btn4.setFocusable(false);
	    
	    panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.setBackground(new Color(0x090f12));
		panel.setLayout(new GridLayout(2,2,10,10));
		panel.setSize(200,200);
		
		frame.add(panel);
		frame.getContentPane().setBackground(new Color(0x090f12));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setTitle("FS-birr");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

			 if(e.getSource() == btn1) {
					Balance New = new Balance(acc);
					  frame.dispose();
				}
				else if(e.getSource() == btn2) {
					Transfer tf = new Transfer(acc);
					  frame.dispose();
				}
				else if(e.getSource() == btn3) {
					Cash_Out New = new Cash_Out(acc);
					  frame.dispose();
				}
				else if(e.getSource() == btn4) {
					MobileTopups New = new MobileTopups(acc);
					  frame.dispose();
				}
				
		}

}
