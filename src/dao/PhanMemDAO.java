package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.CDEntity;
import entity.PhanMemEntity;
import entity.TacGiaEntity;
import entity.TinhNangPMEntity;

public class PhanMemDAO implements GenericDAO<PhanMemEntity>{
	
	TacGiaDAO tacgiaDao = new TacGiaDAO();
	TinhNangDAO tinhnangDao = new TinhNangDAO();
	CDDAO cdDAO = new CDDAO();
	
	
	@Override
	public List<PhanMemEntity> getAll() {
		ArrayList<PhanMemEntity> phanMemEntities = new ArrayList<>();
		List<CDEntity> cDEntitylist = cdDAO.getAll();
		List<CDEntity> cDEntitylistInPM = new ArrayList<>();
		// Statement statement =null;
		try {
			Connection con = ConnectDB.instance.getconnection();
			String sql = "Select* from PhanMemCD";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maPM = rs.getInt(1);
				String tenPM = rs.getString(2);
				int idTG = rs.getInt(3);
				int idTN = rs.getInt(4);
				
				TacGiaEntity tacGiaEntity  = tacgiaDao.findOne(idTG);
				TinhNangPMEntity tinhNangPMEntity = tinhnangDao.findOne(idTN);
				
				
				for(CDEntity cdEntity :cDEntitylist) {
					if(cdEntity.getPhanMemEntity() == maPM) {
						cDEntitylistInPM.add(cdEntity);
					}
				}
				
				PhanMemEntity phanMemEntity=new PhanMemEntity(maPM, tenPM,cDEntitylistInPM, tinhNangPMEntity.getTinhnang(), tacGiaEntity.getTenTG());
				
				phanMemEntities.add(phanMemEntity);
			}
		} catch (Exception e) {
			System.out.println("errro"+e.getMessage());
		}
		return phanMemEntities;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean save(PhanMemEntity e) {
		
		
		System.out.println("SAVE---------------------");
		
		int n =0;
		
		try {
			Connection con = ConnectDB.instance.getconnection();
			PreparedStatement stmt=null;
			
			stmt=con.prepareStatement("INSERT INTO PhanMemCD values(?,?,?)");
		
			stmt.setString(1, e.getTenPM());
			
			int maTG=0,maTN=0;
			
			System.out.println("lai 1 = " +e.getTacGiaEntity());
			System.out.println("lai 2 = " +e.getTinhNangPMEntity());
			for(TacGiaEntity tacGiaEntity : tacgiaDao.getAll()) {
				if(tacGiaEntity.getTenTG().equalsIgnoreCase(e.getTacGiaEntity())) {
					maTG = tacGiaEntity.getMaTG();
					break;
				}
			}
			
			for(TinhNangPMEntity tinhNangPMEntity : tinhnangDao.getAll()) {
				if(tinhNangPMEntity.getTinhnang().equalsIgnoreCase(e.getTinhNangPMEntity())) {
					maTN = tinhNangPMEntity.getId();
					break;
				}
			} 	
			
			System.out.println("aaa="+maTG);
			System.out.println("bbb="+maTN);
			stmt.setInt(2,maTG);
			stmt.setInt(3,maTN);
			n = stmt.executeUpdate();
			
			
			
		} catch (Exception e1) {
			System.out.println("errro"+e1.getMessage());
		}
		return n>0;
	}

	@Override
	public boolean update(PhanMemEntity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhanMemEntity findOne(int id) {
		ArrayList<PhanMemEntity> phanMemEntities = new ArrayList<>();
		List<CDEntity> cDEntitylist = cdDAO.getAll();
		List<CDEntity> cDEntitylistInPM = new ArrayList<>();
		// Statement statement =null;
		try {
			Connection con = ConnectDB.instance.getconnection();
			String sql = "Select* from PhanMemCD WHERE id = " + id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maPM = rs.getInt(1);
				String tenPM = rs.getString(2);
				int idTG = rs.getInt(3);
				int idTN = rs.getInt(4);
				
				TacGiaEntity tacGiaEntity  = tacgiaDao.findOne(idTG);
				TinhNangPMEntity tinhNangPMEntity = tinhnangDao.findOne(idTN);
//				
//				
				for(CDEntity cdEntity :cDEntitylist) {
					if(cdEntity.getPhanMemEntity() == maPM) {
						cDEntitylistInPM.add(cdEntity);
					}
				}
				
				PhanMemEntity phanMemEntity=new PhanMemEntity(maPM, tenPM,cDEntitylistInPM,tacGiaEntity.getTenTG(), tinhNangPMEntity.getTinhnang());
				
				phanMemEntities.add(phanMemEntity);
			}
		} catch (Exception e) {
			System.out.println("errro roi"+e.getMessage());
		}
		return phanMemEntities.get(0);
	}

	
}
