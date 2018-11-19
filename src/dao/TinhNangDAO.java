package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.TacGiaEntity;
import entity.TinhNangPMEntity;

public class TinhNangDAO implements GenericDAO<TinhNangPMEntity>{

	@Override
	public List<TinhNangPMEntity> getAll() {
		ArrayList<TinhNangPMEntity> tinhNangPMEntities = new ArrayList<>();
		// Statement statement =null;
		try {
			Connection con = ConnectDB.instance.getconnection();
			String sql = "Select* from TinhNang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maTN = rs.getInt(1);
				String tenTN = rs.getString(2);
				TinhNangPMEntity tinhNangPMEntity = new TinhNangPMEntity(maTN, tenTN, null);
				tinhNangPMEntities.add(tinhNangPMEntity);
			}
		} catch (Exception e) {
			System.out.println("errro"+e.getMessage());
		}
		return tinhNangPMEntities;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean save(TinhNangPMEntity e) {
		
		int n =0;
		
		try {
			Connection con = ConnectDB.instance.getconnection();
			PreparedStatement stmt=null;
			
			stmt=con.prepareStatement("INSERT INTO TinhNang values( ?)");
		
			stmt.setString(1, e.getTinhnang());
			n = stmt.executeUpdate();
			
			
		} catch (Exception e1) {
			System.out.println("errro"+e1.getMessage());
		}
		return n>0;
	}

	@Override
	public boolean update(TinhNangPMEntity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TinhNangPMEntity findOne(int id) {
		ArrayList<TinhNangPMEntity> tinhNangPMEntities = new ArrayList<>();
		// Statement statement =null;
		try {
			Connection con = ConnectDB.instance.getconnection();
			String sql = "Select* from TinhNang WHERE id = " + id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maTN = rs.getInt(1);
				String tenTN = rs.getString(2);
				TinhNangPMEntity tinhNangPMEntity = new TinhNangPMEntity(maTN, tenTN, null);
				tinhNangPMEntities.add(tinhNangPMEntity);
			}
		} catch (Exception e) {
			System.out.println("errro"+e.getMessage());
		}
		return tinhNangPMEntities.get(0);
	}

}
