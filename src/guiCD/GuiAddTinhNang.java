
package guiCD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.TinhNangDAO;
import entity.TinhNangPMEntity;

public class GuiAddTinhNang extends JDialog{

	
	private JPanel pn_center;
	private JTextField txt_tinhnang;
	private JButton btn_add;
	private TinhNangDAO tinhNangDAO = new TinhNangDAO();
	private JComboBox cbb_tinhnang;

	public GuiAddTinhNang(JComboBox cbb_tinhnang) {
		this.cbb_tinhnang = cbb_tinhnang;
		
		setSize(400, 130);
		setLocation(400, 200);
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Tinh Nang");
		add(title,BorderLayout.NORTH);
		
		pn_center = new JPanel();
		
		txt_tinhnang = new JTextField(20);
		btn_add = new JButton("Them");
		btn_add.setPreferredSize(new Dimension(100, 30));
		txt_tinhnang.setPreferredSize(new Dimension(300, 30));
		
		pn_center.add(txt_tinhnang);
		pn_center.add(btn_add);
		add(pn_center, BorderLayout.CENTER);
		
		
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tinhnang = txt_tinhnang.getText();
				
				if(tinhnang == null || tinhnang.contentEquals("")) {
					
					JOptionPane.showMessageDialog(null, "tinh nang khong duoc null",
			                  "Title", JOptionPane.WARNING_MESSAGE);
				}else {
					
					List<TinhNangPMEntity> tinhNangPMEntities = tinhNangDAO.getAll();
					boolean co = false;
					for(TinhNangPMEntity tinhNangPMEntity : tinhNangPMEntities) {
						if(tinhNangPMEntity.getTinhnang().equalsIgnoreCase(tinhnang)) {
							
							 co = true;
							 JOptionPane.showMessageDialog(null, "tinh nang ban vua nhap da co",
					                  "Title", JOptionPane.WARNING_MESSAGE);
							 break;
						}
					}
					if(!co) {
						TinhNangPMEntity tinhNangPMEntity = new TinhNangPMEntity();
						tinhNangPMEntity.setTinhnang(tinhnang);
						boolean save = tinhNangDAO.save(tinhNangPMEntity);
						
						if(save) {
							cbb_tinhnang.addItem(tinhNangPMEntity.getTinhnang());
						}else {
							 JOptionPane.showMessageDialog(null, "tinh nang ban vua nhap da co",
					                  "Title", JOptionPane.WARNING_MESSAGE);
						}
					}

				}
				
				
				
			}
		});
		
	}
	
	
}
