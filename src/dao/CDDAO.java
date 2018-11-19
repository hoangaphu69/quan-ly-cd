package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import entity.CDEntity;
import entity.PhanMemEntity;

public class CDDAO implements GenericDAO<CDEntity>{
	

	@Override
	public List<CDEntity> getAll() {
		List<CDEntity> cdEntities = new ArrayList<>();
		
		try {
			Connection con = ConnectDB.instance.getconnection();
			String sql = "Select* from CD";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				
				String ten  = rs.getString(2);
				Date ngayphathanh = rs.getDate(3);
				double gia = rs.getDouble(4);
				int soluong = rs.getInt(5);
				int idPM = rs.getInt(6);
				String maCD = rs.getString(7);
				String phienban = rs.getString(8);
				
				CDEntity cdEntity = new CDEntity(maCD, ten, ngayphathanh , gia, soluong, phienban, idPM);
				
				cdEntities.add(cdEntity);
				
						
			}
			
		} catch (Exception e) {
			System.out.println("errro CD DAO");
		}
		return cdEntities;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean save(CDEntity e) {
		
		int n =0;
		
		try {
			Connection con = ConnectDB.instance.getconnection();
			PreparedStatement stmt=null;
			
			stmt=con.prepareStatement("INSERT INTO CD values(?,?,?,?,?,?,?)");
		
			stmt.setString(1, e.getTenCD());
			stmt.setDate (2, (Date) e.getNgayPhatHanh());
			stmt.setDouble(3, e.getGia());
			stmt.setInt(4, e.getSoluong());
			stmt.setInt (5, e.getPhanMemEntity());
			stmt.setString(6, e.getMaCD());
			stmt.setString(7, e.getPhienban());
			n = stmt.executeUpdate();
			
			
			
		} catch (Exception e1) {
			System.out.println("errro"+e1.getMessage());
		}
		return n>0;
	}

	@Override
	public boolean update(CDEntity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CDEntity findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
