import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ReSuccess implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JButton btn = new JButton();
	ReSuccess(){
		label1.setText("Hi there Welcome to FS-birr");
		label1.setFont(new Font(null,Font.PLAIN,25));
		
		panel1.add(label1);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setSize(200,200);
		
		label2.setText("Your FS-birr Account "
				+ "has Created Successfully!!");
		label2.setFont(new Font(null,Font.PLAIN,25));
		
		panel2.add(label2);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setSize(200,200);
		
		label3.setText("you have received a gift of 10,000 birr");
		label3.setFont(new Font(null,Font.PLAIN,25));
		
		panel3.add(label3);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setSize(200,200);
		
		btn.setText("Go back to Login Page");
		btn.addActionListener(this);
	    btn.setFont(new Font(null,Font.BOLD,19));
	    btn.setForeground(Color.WHITE);
	    btn.setBackground(Color.BLACK);
	    btn.setFocusable(false);
	    
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(btn);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setTitle("FS-birr");
        frame.setSize(560,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Logninpage New = new Logninpage();
	}
}
