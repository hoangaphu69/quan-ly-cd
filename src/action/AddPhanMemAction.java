package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.PhanMemDAO;
import entity.PhanMemEntity;

public class AddPhanMemAction implements ActionListener {
	
	private JTextField txt_tenPM;
	private PhanMemDAO  phanMemDAO = new PhanMemDAO();
	private JComboBox cbb_PM,cbb_TG,cbb_TN ;
	
	
	public AddPhanMemAction(JTextField txt_tenPM, JComboBox cbb_PM, JComboBox cbb_TG,
			JComboBox cbb_TN) {
		super();
		this.txt_tenPM = txt_tenPM;
		this.cbb_PM = cbb_PM;
		this.cbb_TG = cbb_TG;
		this.cbb_TN = cbb_TN;
	}





	public JTextField getTxt_tenPM() {
		return txt_tenPM;
	}





	public void setTxt_tenPM(JTextField txt_tenPM) {
		this.txt_tenPM = txt_tenPM;
	}





	public PhanMemDAO getPhanMemDAO() {
		return phanMemDAO;
	}





	public void setPhanMemDAO(PhanMemDAO phanMemDAO) {
		this.phanMemDAO = phanMemDAO;
	}





	public JComboBox getCbb_PM() {
		return cbb_PM;
	}





	public void setCbb_PM(JComboBox cbb_PM) {
		this.cbb_PM = cbb_PM;
	}





	public JComboBox getCbb_TG() {
		return cbb_TG;
	}





	public void setCbb_TG(JComboBox cbb_TG) {
		this.cbb_TG = cbb_TG;
	}





	public JComboBox getCbb_TN() {
		return cbb_TN;
	}





	public void setCbb_TN(JComboBox cbb_TN) {
		this.cbb_TN = cbb_TN;
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		
		String tenPM = txt_tenPM.getText();
		
		
		if(tenPM.equalsIgnoreCase("") ) {
			JOptionPane.showMessageDialog(null, "Ten Phan Mem NULL",
	                  "Title", JOptionPane.WARNING_MESSAGE);
		}else {
			
			String TG = cbb_TG.getSelectedItem().toString(),TN = cbb_TN.getSelectedItem().toString();
			PhanMemEntity  phanMemEntity = new PhanMemEntity();
			phanMemEntity.setTacGiaEntity(TG);
			phanMemEntity.setTinhNangPMEntity(TN);
			phanMemEntity.setTenPM(tenPM);
			
			boolean save = phanMemDAO.save(phanMemEntity);
			
			System.out.println("vclllllllllllllll=="+TG);
			System.out.println("vclllllllllllllll=="+TN);
			
			if(save) {
				
				cbb_PM.addItem(phanMemEntity.getTenPM());
				
			}else {
				JOptionPane.showMessageDialog(null, "Save Errro",
		                  "Title", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
	}
	
	
	

}
