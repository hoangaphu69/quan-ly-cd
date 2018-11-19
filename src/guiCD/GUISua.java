package guiCD;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.CDEntity;

public class GUISua extends JPanel{
	
	private JLabel lb_maCD;
	private JLabel lb_tenCD;
	private JLabel lb_phanloai;
	private JTextField txt_maCD;
	private JTextField txt_tenCD;
	private JPanel pn_nouth;
	private JButton btn_them;
	private JButton btn_xoa;
	private JComboBox cbb_phanloai;
	private CDEntity cd ;
	private JPanel pn_all;
	
	
	public GUISua(CDEntity cd) {
		this.cd = cd;
		
		pn_all = new JPanel();
		pn_all.setLayout(new BorderLayout());
		
		
		
		pn_nouth = new JPanel();
		pn_nouth.setLayout(new GridBagLayout());
		
		
		GridBagConstraints bagConstraints = new GridBagConstraints();
		lb_maCD = new JLabel("ma CD   :");
		txt_maCD = new JTextField(20);
		lb_tenCD = new JLabel("ten CD   :");
		txt_tenCD = new JTextField(20);
		lb_phanloai = new JLabel("the loai :");
		cbb_phanloai = new JComboBox<>();
		
		cbb_phanloai.addItem("nhac");
		cbb_phanloai.addItem("hai");
		cbb_phanloai.addItem("phim");
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		pn_nouth.add(lb_maCD,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 20, 0, 0);
		pn_nouth.add(txt_maCD,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(lb_tenCD,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 20, 0, 0);
		pn_nouth.add(txt_tenCD,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_nouth.add(lb_phanloai,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 140);
		pn_nouth.add(cbb_phanloai,bagConstraints);
		
		pn_all.add(pn_nouth, BorderLayout.NORTH);
		
		
		pn_nouth = new JPanel();
		btn_them = new JButton("Them");
		btn_xoa = new JButton("Xoa");
		pn_nouth.add(btn_them);
		pn_nouth.add(btn_xoa);
		
		pn_all.add(pn_nouth, BorderLayout.SOUTH);
		
		this.add(pn_all);
		
		
	}

}
