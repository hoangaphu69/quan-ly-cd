package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.TacGiaDAO;
import entity.TacGiaEntity;

public class AddTacGiaAction implements ActionListener{
	
	private JButton btn_add;
	private JTextField txt_diachi,txt_phone,txt_ten;
	private TacGiaDAO tacGiaDAO = new TacGiaDAO();
	private JComboBox cbbTG;
	
	
	
	public AddTacGiaAction() {
		// TODO Auto-generated constructor stub
	}

	public AddTacGiaAction( JButton btn_add, JTextField txt_diachi, JTextField txt_phone, JTextField txt_ten,JComboBox cbbTG) {
		super();
		this.btn_add = btn_add;
		this.txt_diachi = txt_diachi;
		this.txt_phone = txt_phone;
		this.txt_ten = txt_ten;
		this.cbbTG = cbbTG;
	}
	
	
	
	public JComboBox getCbbTG() {
		return cbbTG;
	}

	public void setCbbTG(JComboBox cbbTG) {
		this.cbbTG = cbbTG;
	}

	public JButton getBtn_add() {
		return btn_add;
	}

	public void setBtn_add(JButton btn_add) {
		this.btn_add = btn_add;
	}

	public JTextField getTxt_diachi() {
		return txt_diachi;
	}

	public void setTxt_diachi(JTextField txt_diachi) {
		this.txt_diachi = txt_diachi;
	}

	public JTextField getTxt_phone() {
		return txt_phone;
	}

	public void setTxt_phone(JTextField txt_phone) {
		this.txt_phone = txt_phone;
	}

	public JTextField getTxt_ten() {
		return txt_ten;
	}

	public void setTxt_ten(JTextField txt_ten) {
		this.txt_ten = txt_ten;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ten = txt_ten.getText();
		String diachi = txt_diachi.getText();
		String phone = txt_phone.getText();
		
		if(ten.equalsIgnoreCase("") || diachi.equalsIgnoreCase("") || phone.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Khong duoc null",
	                  "Title", JOptionPane.WARNING_MESSAGE);
		}else {
			
			List<TacGiaEntity> tacGiaEntities =  tacGiaDAO.getAll();
			boolean co = false;
			for(TacGiaEntity tacGiaEntity : tacGiaEntities) {
				if(tacGiaEntity.getTenTG().equalsIgnoreCase(ten)) {
					JOptionPane.showMessageDialog(null, "Tac Gia Ban Da Co TRong Danh Sach",
			                  "Title", JOptionPane.WARNING_MESSAGE);
					co = true;
					break;
				}
			}
			if(!co) {
				
				TacGiaEntity tacGiaEntity = new TacGiaEntity();
				tacGiaEntity.setDiachiTG(diachi);
				tacGiaEntity.setPhoneTG(phone);
				tacGiaEntity.setTenTG(ten);
				
				boolean save =  tacGiaDAO.save(tacGiaEntity);
				
				if(save) {
					cbbTG.addItem(tacGiaEntity.getTenTG());
				}else {

					JOptionPane.showMessageDialog(null, "Save Khong Thanh Cong",
			                  "Title", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}

}
