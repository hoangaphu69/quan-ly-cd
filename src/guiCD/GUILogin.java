package guiCD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.LoginAction;

public class GUILogin extends JFrame{
	private JLabel lb_title;
	private JLabel lb_name;
	private JLabel lb_pwd;
	private JTextField txt_name;
	private JTextField txt_pwd;
	private JButton btn_ok;
	public GUILogin() {
		this.setLayout(new BorderLayout());
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400, 100);
		
		lb_title = new JLabel("Login");
		lb_title.setFont(new Font("aria", 0, 40));

		lb_title.setBounds(240,30, 300, 80);
		this.add(lb_title);
		
		lb_name = new JLabel("User Name:");
		lb_pwd = new JLabel("Password:");
		txt_name = new JTextField(20);
		txt_pwd = new JTextField(20);
		btn_ok = new JButton("Login");
		
		lb_name.setBounds(100,100, 300, 80);
		lb_name.setFont(new Font("aria", 0, 18));
		this.add(lb_name);
		lb_pwd.setBounds(100,160, 300, 80);
		lb_pwd.setFont(new Font("aria", 0, 18));
		this.add(lb_pwd);
		txt_name.setBounds(220,130, 300, 20);
		this.add(txt_name);
		txt_pwd.setBounds(220,190, 300, 20);
		this.add(txt_pwd);
		btn_ok.setBounds(220,250, 300, 25);
		this.add(btn_ok);
		
		this.add(new JLabel(new ImageIcon("C:\\Users\\hoangaphu\\eclipse-workspace\\CD\\images\\img.jpg")));
		
		// add btn_ok
		LoginAction action =  new LoginAction(btn_ok, txt_name, txt_pwd,this);
		btn_ok.addActionListener(action);
		
		
	}
}
