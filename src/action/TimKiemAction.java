package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.CDDAO;
import dao.PhanMemDAO;
import entity.CDEntity;
import entity.GiaTriFinal;
import entity.PhanMemEntity;
import service.XuLyKhiTimKiem;

public class TimKiemAction implements ActionListener {
	
	private JComboBox cbb_PM,cbb_TN,cbb_TimTheo;
	private JTextField txt_tim ,txt_phienban;
	private DefaultTableModel defaultTableModel;
	private CDDAO cddao =  new CDDAO();
	private XuLyKhiTimKiem xuLyKhiTimKiem = new XuLyKhiTimKiem();
	private PhanMemDAO phanMemDAO = new PhanMemDAO();
	
	
	
	public TimKiemAction(JComboBox cbb_loaiPM, JComboBox cbb_TinhNang, JComboBox cbb_timkiemphanloai,
			JTextField txt_tim2, JTextField txt_phienban2, DefaultTableModel defaultTableModel2) {
		super();
		this.cbb_PM = cbb_loaiPM;
		this.cbb_TN = cbb_TinhNang;
		this.cbb_TimTheo = cbb_timkiemphanloai;
		this.txt_tim = txt_tim2;
		this.txt_phienban = txt_phienban2;
		this.defaultTableModel = defaultTableModel2;
	}



	public JComboBox getCbb_PM() {
		return cbb_PM;
	}



	public void setCbb_PM(JComboBox cbb_PM) {
		this.cbb_PM = cbb_PM;
	}



	public JComboBox getCbb_TN() {
		return cbb_TN;
	}



	public void setCbb_TN(JComboBox cbb_TN) {
		this.cbb_TN = cbb_TN;
	}



	public JComboBox getCbb_TimTheo() {
		return cbb_TimTheo;
	}



	public void setCbb_TimTheo(JComboBox cbb_TimTheo) {
		this.cbb_TimTheo = cbb_TimTheo;
	}



	public JTextField getTxt_tim() {
		return txt_tim;
	}



	public void setTxt_tim(JTextField txt_tim) {
		this.txt_tim = txt_tim;
	}



	public JTextField getTxt_phienban() {
		return txt_phienban;
	}



	public void setTxt_phienban(JTextField txt_phienban) {
		this.txt_phienban = txt_phienban;
	}



	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}



	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("vao-----------------------------------------------");
		String loaiPm = cbb_PM.getSelectedItem().toString();
		String tinhNang = cbb_TN.getSelectedItem().toString();
		String timtheo = cbb_TimTheo.getSelectedItem().toString();
		String tim = txt_tim.getText();
		String phienban = txt_phienban.getText();
		
		List<CDEntity> cdEntities = cddao.getAll();
		
		List<CDEntity> listCDTemp = cddao.getAll();
		
		
		if(timtheo.equalsIgnoreCase(GiaTriFinal.All.toString())) {
			
		}else {
			listCDTemp = xuLyKhiTimKiem.checkTimTheo(cdEntities, timtheo, tim);
		}
		if(loaiPm.equalsIgnoreCase(GiaTriFinal.All.toString())) {
			
		}else {
			listCDTemp = xuLyKhiTimKiem.checkLoaiPM(cdEntities, loaiPm);
		}
		if(tinhNang.equalsIgnoreCase(GiaTriFinal.All.toString())) {
			
		}else {
			listCDTemp = xuLyKhiTimKiem.checkTNPM(cdEntities, tinhNang);
		}
		if(phienban.equalsIgnoreCase("")) {
			
		}else {
			listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
		}
		
		// timtheo All
//		if(timtheo.equalsIgnoreCase(GiaTriFinal.All.toString())) {
//			
//			if(loaiPm.equalsIgnoreCase(GiaTriFinal.All.toString())){
//				if(tinhNang.equalsIgnoreCase(GiaTriFinal.All.toString())) {
//					if(phienban.equalsIgnoreCase("")) {
//					}else {
//						listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//					}
//				}else {
//					listCDTemp = xuLyKhiTimKiem.checkTNPM(cdEntities, tinhNang);
//					if(phienban.equalsIgnoreCase("")) {
//					}else {
//						listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//						if(phienban.equalsIgnoreCase("")) {
//							
//						}else {
//							listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//							if(phienban.equalsIgnoreCase("")) {
//							}else {
//								listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//							}
//						}
//					}
//				}
//			}else {
//				listCDTemp = xuLyKhiTimKiem.checkLoaiPM(cdEntities, loaiPm);
//				if(tinhNang.equalsIgnoreCase(GiaTriFinal.All.toString())) {
//					if(phienban.equalsIgnoreCase("")) {
//						
//					}else {
//						listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//						if(phienban.equalsIgnoreCase("")) {
//						}else {
//							listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//						}
//					}
//				}else {
//					listCDTemp = xuLyKhiTimKiem.checkTNPM(cdEntities, tinhNang);
//					if(phienban.equalsIgnoreCase("")) {
//						
//					}else {
//						listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//						if(phienban.equalsIgnoreCase("")) {
//						}else {
//							listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//						}
//					}
//				}
//			}
//		}
//		else {
//			listCDTemp = xuLyKhiTimKiem.checkTimTheo(cdEntities, timtheo, tim);
//			System.out.println("Sizeeeeeeeeee1=="+listCDTemp.size());
//			
//			if(loaiPm.equalsIgnoreCase(GiaTriFinal.All.toString())){
//				if(tinhNang.equalsIgnoreCase(GiaTriFinal.All.toString())) {
//					if(phienban.equalsIgnoreCase("")) {
//						
//					}else {
//						listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//					}
//				}else {
//					listCDTemp = xuLyKhiTimKiem.checkTNPM(cdEntities, tinhNang);
//				}
//			}else {
//				listCDTemp = xuLyKhiTimKiem.checkLoaiPM(cdEntities, loaiPm);
//				System.out.println("Sizeeeeeeeeee2=="+listCDTemp.size());
//				if(tinhNang.equalsIgnoreCase(GiaTriFinal.All.toString())) {
//					if(phienban.equalsIgnoreCase("")) {
//						
//					}else {
//						listCDTemp = xuLyKhiTimKiem.checkPhienBanPM(cdEntities, phienban);
//					}
//				}else {
//					System.out.println("Sizeeeeeeeeee3=="+listCDTemp.size());
//					listCDTemp = xuLyKhiTimKiem.checkTNPM(cdEntities, tinhNang);
//				}
//			}
//		
//		}
		
		
		for(int i=0;i<defaultTableModel.getRowCount(); i++) {
			defaultTableModel.removeRow(i--);
			}
		
		System.out.println("sizeeeeeeeeeeeeeee CUoi Cung =="+listCDTemp.size());
		for(CDEntity cdEntity : listCDTemp) {
			PhanMemEntity phanMemEntity = phanMemDAO.findOne(cdEntity.getPhanMemEntity());
			defaultTableModel.addRow(new Object[] {cdEntity.getMaCD(),cdEntity.getTenCD(),phanMemEntity.getTenPM(),cdEntity.getSoluong(),cdEntity.getGia(),cdEntity.getNgayPhatHanh(),phanMemEntity.getTinhNangPMEntity(),cdEntity.getPhienban(),phanMemEntity.getTacGiaEntity()});
		}
		
	}

}
