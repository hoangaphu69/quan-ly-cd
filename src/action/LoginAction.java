package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import guiCD.GUI;
import guiCD.GUILogin;

public class LoginAction implements ActionListener{
	
	JButton btn_ok ;
	JTextField name ,pwd;
	GUILogin guiLogin;
	
	
	public LoginAction(JButton btn_ok, JTextField name, JTextField pwd,GUILogin guiLogin) {
		super();
		this.btn_ok = btn_ok;
		this.name = name;
		this.pwd = pwd;
		this.guiLogin = guiLogin;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object object =  e.getSource();
		if(object.equals(btn_ok)) {
			System.out.println("ok");

				guiLogin.setVisible(false);
				new GUI().setVisible(true);
				System.out.println("ok2");
		}
		
	}

}
