
package guiCD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.AddPhanMemAction;
import dao.PhanMemDAO;
import dao.TacGiaDAO;
import dao.TinhNangDAO;
import entity.TacGiaEntity;
import entity.TinhNangPMEntity;

public class GuiAddPhanMem extends JDialog{

	
	private JPanel pn_center;
	private JTextField txt_tenPM;
	private JButton btn_add;
	private JLabel lb_tenPM;
	private JButton btn_addTinhNang;
	private JButton btn_addTacGia;
	private JLabel lb_tinhnang;
	private JComboBox cbb_tinhnang;
	private JLabel lb_tacgia;
	private JComboBox cbb_tacgia;
	private TinhNangDAO tinhNangDAO = new TinhNangDAO();
	private PhanMemDAO phanMemDAO = new PhanMemDAO();
	private TacGiaDAO tacGiaDAO = new TacGiaDAO();
	private JButton btn_them;
	private JComboBox cbb_PM;
	private String TG = "";
	private String TN = "";

	public GuiAddPhanMem(JComboBox cbb_PM) {
		
		this.cbb_PM = cbb_PM;
		
		setSize(600, 250);
		setLocation(400, 200);
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Them Loai");
		add(title,BorderLayout.NORTH);
		
		
		pn_center = new JPanel();
		pn_center.setLayout(new GridBagLayout());
		
		GridBagConstraints bagConstraints = new GridBagConstraints();
		
		
		btn_them = new JButton("THEM");
		btn_them.setPreferredSize(new Dimension(330, 30));
		btn_addTacGia = new JButton("Add");
		btn_addTacGia.setPreferredSize(new Dimension(70, 30));
		btn_addTinhNang = new JButton("Add");
		btn_addTinhNang.setPreferredSize(new Dimension(70, 30));
		
		lb_tinhnang = new JLabel("tinh nang:");
		cbb_tinhnang = new JComboBox<>();
		List<TinhNangPMEntity> tinhNangPMEntities =tinhNangDAO.getAll();
		for(TinhNangPMEntity tinhNangPMEntity : tinhNangPMEntities) {
			cbb_tinhnang.addItem(tinhNangPMEntity.getTinhnang());
		}
		
		lb_tacgia = new JLabel("tac gia:");
		cbb_tacgia = new JComboBox<>();
		List<TacGiaEntity> tacGiaEntities =tacGiaDAO.getAll();
		for(TacGiaEntity tacGiaEntitie : tacGiaEntities) {
			cbb_tacgia.addItem(tacGiaEntitie.getTenTG());
		}
		
		cbb_tinhnang.setPreferredSize(new Dimension(330, 30));
		cbb_tacgia.setPreferredSize(new Dimension(330, 30));
		
		lb_tenPM = new JLabel("TenPM:");
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 0, 0, 13);
		pn_center.add(lb_tenPM, bagConstraints);
		
		txt_tenPM = new JTextField(30);
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_center.add(txt_tenPM, bagConstraints);
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 10);
		pn_center.add(lb_tinhnang,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_center.add(cbb_tinhnang,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_center.add(btn_addTinhNang,bagConstraints);
		
		//b
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 13);
		pn_center.add(lb_tacgia,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_center.add(cbb_tacgia,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 2;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_center.add(btn_addTacGia,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 3;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		pn_center.add(btn_them,bagConstraints);
		
		
//		btn_add = new JButton("Add");
//		btn_add.setPreferredSize(new Dimension(100, 30));
		txt_tenPM.setPreferredSize(new Dimension(300, 30));
		
		
//		pn_center.add(btn_add);
		add(pn_center, BorderLayout.CENTER);
		
		
		btn_addTacGia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GuiAddTacGia(cbb_tacgia).setVisible(true);
				
			}
		});
		
		btn_addTinhNang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GuiAddTinhNang(cbb_tinhnang).setVisible(true);
				
			}
		});
		

		AddPhanMemAction phanMemAction = new AddPhanMemAction(txt_tenPM, cbb_PM, cbb_tacgia, cbb_tinhnang);
		
		btn_them.addActionListener(phanMemAction);
		
		
	}

	
}
