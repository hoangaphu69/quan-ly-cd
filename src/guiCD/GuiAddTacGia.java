package guiCD;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.AddTacGiaAction;

public class GuiAddTacGia extends JDialog {
	
	private JLabel lb_ten;
	private JLabel lb_diachi;
	private JLabel lb_phone;
	private JTextField txt_ten;
	private JTextField txt_diachi;
	private JTextField txt_phone;
	private JButton btn_them;
	private JComboBox cbbTG;

	public GuiAddTacGia(JComboBox cbbTG) {
		
		this.cbbTG = cbbTG;
		
		setSize(600, 300);
		setLocation(50, 50);
		setLayout(new GridBagLayout());
		GridBagConstraints bagConstraints = new GridBagConstraints();
		
		lb_ten = new JLabel("Ten Tac Gia:");
		lb_diachi = new JLabel("Dia Chi:");
		lb_phone = new JLabel("Phone:");
		txt_ten = new JTextField(30);
		txt_ten.setPreferredSize(new Dimension(300, 30));
		txt_diachi = new JTextField(30);
		txt_diachi.setPreferredSize(new Dimension(300, 30));
		txt_phone = new JTextField(30);
		txt_phone.setPreferredSize(new Dimension(300, 30));
		
		btn_them = new JButton("THEM");
		btn_them.setPreferredSize(new Dimension(330, 30));
		
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 0, 0, 13);
		add(lb_ten,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		add(txt_ten,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 13);
		add(lb_phone,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		add(txt_phone,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 13);
		add(lb_diachi,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		add(txt_diachi,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 3;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		add(btn_them,bagConstraints);
		
		
		//action
		AddTacGiaAction action= new AddTacGiaAction(btn_them, txt_diachi, txt_phone, txt_ten,cbbTG);
		btn_them.addActionListener(action);
		
	}

}
