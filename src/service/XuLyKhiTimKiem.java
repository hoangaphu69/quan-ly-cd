package service;

import java.util.ArrayList;
import java.util.List;

import dao.PhanMemDAO;
import dao.TinhNangDAO;
import entity.CDEntity;
import entity.GiaTriFinal;
import entity.PhanMemEntity;
import entity.TinhNangPMEntity;

public class XuLyKhiTimKiem {
	
	private PhanMemDAO phanMemDAO = new PhanMemDAO();
	private TinhNangDAO tinhNangDAO = new TinhNangDAO();
	
	
	//
	public List<CDEntity> checkLoaiPM(List<CDEntity> cdEntities, String loaiPM){
		
		List<CDEntity> cdList = new ArrayList<>();
		List<PhanMemEntity> phanMemEntities =  phanMemDAO.getAll();
		int IDPM = 0;
		for(PhanMemEntity phanMemEntity : phanMemEntities) {
			if (phanMemEntity.getTenPM().equalsIgnoreCase(loaiPM)) {
				IDPM = phanMemEntity.getId();
				break;
			}
		}
		for(CDEntity cdEntity : cdEntities) {
			if(cdEntity.getPhanMemEntity() == IDPM) {
				cdList.add(cdEntity);
			}
		}
		return cdList;
		
	}
	//
	public List<CDEntity> checkTNPM(List<CDEntity> cdEntities, String tinhNangPM){
		List<CDEntity> cdList = new ArrayList<>();
		
		for(CDEntity cdEntity : cdEntities) {
			PhanMemEntity phanMemEntity = phanMemDAO.findOne(cdEntity.getPhanMemEntity());
			if(phanMemEntity.getTinhNangPMEntity().equalsIgnoreCase(tinhNangPM)) {
				cdList.add(cdEntity);
			}
		}
		
		return cdList;
	}
	//
	public List<CDEntity> checkPhienBanPM(List<CDEntity> cdEntities, String phienbanPM){
		List<CDEntity> cdList = new ArrayList<>();
		
		for(CDEntity cdEntity : cdEntities) {
			if(cdEntity.getPhienban().equalsIgnoreCase(phienbanPM)) {
				cdList.add(cdEntity);
			}
		}
		
		return cdList;
		
	}
	public List<CDEntity> checkTimTheo(List<CDEntity> cdEntities, String timTheo , String name){
		
		List<CDEntity> cdList = new ArrayList<>();
		
		if(timTheo.equalsIgnoreCase(GiaTriFinal.MaCD.toString())) {
			for(CDEntity cdEntity :cdEntities) {
				if(cdEntity.getMaCD().equalsIgnoreCase(name)) {
					cdList.add(cdEntity);
				}
			}
		}
		
		if(timTheo.equalsIgnoreCase(GiaTriFinal.TenCD.toString())) {
			for(CDEntity cdEntity :cdEntities) {
				if(cdEntity.getTenCD().equalsIgnoreCase(name)) {
					cdList.add(cdEntity);
				}
			}
		}
		
		return cdList;
		
	}
}
