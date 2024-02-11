import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
public class Signuppage implements ActionListener {
	JFrame frame = new JFrame();
	JPanel gap = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JPasswordField pass = new JPasswordField();
	JPasswordField con_pass = new JPasswordField();
	JButton btn = new JButton();
	Signuppage(){
		gap.setLayout(new FlowLayout(FlowLayout.CENTER));
		gap.setSize(200,200);
		
		label.setText("Hi there Wellcome to FS-birr:");
		label.setFont(new Font(null,Font.PLAIN,25));
		
		panel1.add(label);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setSize(200,200);
		
		label1.setText("First_Name: ");
		label1.setFont(new Font(null,Font.PLAIN,25));
		
		txt1.setPreferredSize(new Dimension(150,40));
		txt1.setCaretColor(Color.BLACK);
		txt1.setFont(new Font(null,Font.PLAIN,25));
		
		label2.setText("Last_Name: ");
		label2.setFont(new Font(null,Font.PLAIN,25));
		
		txt2.setPreferredSize(new Dimension(150,40));
		txt2.setCaretColor(Color.BLACK);
		txt2.setFont(new Font(null,Font.PLAIN,25));
		
		label3.setText("Account_Number: ");
		label3.setFont(new Font(null,Font.PLAIN,25));
		
		txt3.setPreferredSize(new Dimension(150,40));
		txt3.setCaretColor(Color.BLACK);
		txt3.setFont(new Font(null,Font.PLAIN,25));
		
		label4.setText("pass: ");
		label4.setFont(new Font(null,Font.PLAIN,25));
		
		pass.setPreferredSize(new Dimension(150,40));
		pass.setCaretColor(Color.BLACK);
		pass.setFont(new Font(null,Font.PLAIN,25));
		
		label5.setText("Confirm_pass: ");
		label5.setFont(new Font(null,Font.PLAIN,25));
		
		con_pass.setPreferredSize(new Dimension(150,40));
		con_pass.setCaretColor(Color.BLACK);
		con_pass.setFont(new Font(null,Font.PLAIN,25));
		
		panel2.add(label1);
		panel2.add(txt1);
		panel2.add(label2);
		panel2.add(txt2);
		panel2.add(label3);
		panel2.add(txt3);
		panel2.add(label4);
		panel2.add(pass);
		panel2.add(label5);
		panel2.add(con_pass);
		panel2.setLayout(new GridLayout(6,2,10,10));
		panel2.setSize(200,200);
		
		btn.setText("Submit");
		btn.addActionListener(this);
	    btn.setFont(new Font(null,Font.BOLD,19));
	    btn.setForeground(Color.WHITE);
	    btn.setBackground(Color.BLACK);
	    btn.setFocusable(false);
	    
	    panel3.add(btn);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setSize(200,200);
		
		frame.add(gap);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setTitle("FS-birr");
        frame.setSize(490,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ReSuccess New = new ReSuccess();
		  frame.dispose();
	}
}
