import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class WelcomePage implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	WelcomePage(){	
		
		label.setText("Welcome to FS-birr");
		label.setForeground(new Color(0x09de5e));
		label.setFont(new Font(null,Font.PLAIN,25));
		
		btn1.setText("login");
	    btn1.setFont(new Font(null,Font.BOLD,19));
	    btn1.setForeground(Color.WHITE);
	    btn1.setBackground(new Color(0x1d2e));
	    btn1.setFocusable(false);
	    btn1.addActionListener(this);
		
		panel.add(label);
		panel.add(btn1);
		panel.setBackground(new Color(0x090f12));
		panel.setLayout(new GridLayout(3,1,0,20));
		panel.setSize(200,200);
		
		frame.add(panel);
		frame.getContentPane().setBackground(new Color(0x090f12));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setTitle("FS-birr");
        frame.setSize(350,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	          if(e.getSource() == btn1){
	        	  Logninpage NEW = new Logninpage();
	        	  frame.dispose();
	          }
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		WelcomePage HomePage = new WelcomePage();

	}
}
