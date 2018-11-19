package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import dao.CDDAO;
import dao.PhanMemDAO;
import entity.CDEntity;
import entity.PhanMemEntity;

public class AddCDAction implements ActionListener{
	
	private JTextField txt_maCD,txt_tenCD,txt_ngayphathanh,txt_phienban,txt_soluong,txt_gia;
	private CDDAO cddao = new CDDAO();
	private PhanMemDAO phanMemDAO = new PhanMemDAO();
	private JComboBox cbb_PM ;
	
	
	
	public AddCDAction(JTextField txt_maCD, JTextField txt_tenCD, JTextField txt_ngayphathanh, JTextField txt_phienban,
			JTextField txt_soluong, JTextField txt_gia, JComboBox cbb_PM) {
		super();
		this.txt_maCD = txt_maCD;
		this.txt_tenCD = txt_tenCD;
		this.txt_ngayphathanh = txt_ngayphathanh;
		this.txt_phienban = txt_phienban;
		this.txt_soluong = txt_soluong;
		this.txt_gia = txt_gia;
		this.cbb_PM = cbb_PM;
	}
	public JTextField getTxt_maCD() {
		return txt_maCD;
	}

	public void setTxt_maCD(JTextField txt_maCD) {
		this.txt_maCD = txt_maCD;
	}

	public JTextField getTxt_tenCD() {
		return txt_tenCD;
	}

	public void setTxt_tenCD(JTextField txt_tenCD) {
		this.txt_tenCD = txt_tenCD;
	}
	public JTextField getTxt_ngayphathanh() {
		return txt_ngayphathanh;
	}





	public void setTxt_ngayphathanh(JTextField txt_ngayphathanh) {
		this.txt_ngayphathanh = txt_ngayphathanh;
	}





	public JTextField getTxt_phienban() {
		return txt_phienban;
	}
	public void setTxt_phienban(JTextField txt_phienban) {
		this.txt_phienban = txt_phienban;
	}
	public JTextField getTxt_soluong() {
		return txt_soluong;
	}

	public void setTxt_soluong(JTextField txt_soluong) {
		this.txt_soluong = txt_soluong;
	}
	public JTextField getTxt_gia() {
		return txt_gia;
	}
	public void setTxt_gia(JTextField txt_gia) {
		this.txt_gia = txt_gia;
	}
	public JComboBox getCbb_PM() {
		return cbb_PM;
	}

	public void setCbb_PM(JComboBox cbb_PM) {
		this.cbb_PM = cbb_PM;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String maCD = this.txt_maCD.getText();
		String ten = this.txt_tenCD.getText();
		
		String loai = cbb_PM.getSelectedItem().toString();
		String ngayphathanh = this.txt_ngayphathanh.getText();
		String phienban = this.txt_phienban.getText();
		String soluong = this.txt_soluong.getText();
		String gia = this.txt_gia.getText();
		PhanMemEntity phanMemEntity=new PhanMemEntity();
		
		
		String regexNgay ="(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)";
		
		boolean ca =  ngayphathanh.matches(regexNgay);
		
		System.out.println("maCD="+maCD);
		System.out.println("ten="+ten);
		System.out.println("loai="+loai);
		System.out.println("phienban="+phienban);
		System.out.println("soluong="+soluong);
		System.out.println("gia="+gia);
		
		if(ca) {
			if(!maCD.equalsIgnoreCase("") 
					|| !ten.equalsIgnoreCase("") 
					|| !loai.equalsIgnoreCase("") 
					|| !phienban.equalsIgnoreCase("") 
					|| !soluong.equalsIgnoreCase("") 
					|| !gia.equalsIgnoreCase("") ) {
				
				System.out.println("VAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
				try {
					
					int soluong_int = Integer.parseInt(soluong);
					double gia_double = Double.parseDouble(gia);
					
					List<CDEntity> cdEntities = cddao.getAll();
					
					boolean co = false;
					
					for(CDEntity cdEntity : cdEntities) {
						if(cdEntity.getMaCD().equalsIgnoreCase(maCD)) {
							co = true;
							JOptionPane.showMessageDialog(null, "Trung MaCD!",
					                  "Title", JOptionPane.WARNING_MESSAGE);
						
						}else {
							
							
							List<PhanMemEntity> phanMemEntities = phanMemDAO.getAll();
							for(PhanMemEntity phanMemEntityData : phanMemEntities) {
								if(phanMemEntityData.getTenPM().equalsIgnoreCase(loai)) {
									phanMemEntity.setId(phanMemEntityData.getId());
									System.out.println("ho quang lai =="+phanMemEntityData.getId());
									break;
								}
							
							}
						}
					}

					if (!co) {
						System.out.println("iddddddd=="+phanMemEntity.getId());
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						Date ngay  = new Date(formatter.parse(ngayphathanh).getTime());
						CDEntity cdEntityNew = new CDEntity();
						cdEntityNew.setGia(gia_double);
						cdEntityNew.setMaCD(maCD);
						cdEntityNew.setNgayPhatHanh(ngay);
						cdEntityNew.setPhanMemEntity(phanMemEntity.getId());
						cdEntityNew.setPhienban(phienban);
						cdEntityNew.setSoluong(soluong_int);
						cdEntityNew.setTenCD(ten);
						
						System.out.println("so lan xuat hien ");
						cddao.save(cdEntityNew);
					}
					
				} catch (Exception e2) {
					System.out.println("errro==="+e2.toString());
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Khong duoc de NULL",
		                  "Title", JOptionPane.WARNING_MESSAGE);
			}
			
		  }else {
			JOptionPane.showMessageDialog(null, "Nhap Ngay Sai!",
	                  "Title", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	

}
