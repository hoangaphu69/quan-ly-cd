package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.PhanMemEntity;
import entity.TacGiaEntity;

public class TacGiaDAO implements GenericDAO<TacGiaEntity>{

	@Override
	public List<TacGiaEntity> getAll() {
		ArrayList<TacGiaEntity> tacGiaEntities = new ArrayList<>();
		// Statement statement =null;
		try {
			Connection con = ConnectDB.instance.getconnection();
			String sql = "Select* from TacGia";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maTG = rs.getInt(1);
				String diachi = rs.getString(2);
				String phoneTG = rs.getString(3);
				String tenTG = rs.getString(4);
				TacGiaEntity tacGiaEntity =new TacGiaEntity(diachi, maTG, phoneTG, tenTG, null);
				tacGiaEntities.add(tacGiaEntity);
			}
		} catch (Exception e) {
			System.out.println("errro"+e.getMessage());
		}
		return tacGiaEntities;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean save(TacGiaEntity e) {
		
		int n =0;
		
		try {
			Connection con = ConnectDB.instance.getconnection();
			PreparedStatement stmt=null;
			
			stmt=con.prepareStatement("INSERT INTO TacGia values( ?,?,?)");
		
			stmt.setString(1, e.getDiachiTG());
			stmt.setString(2, e.getPhoneTG());
			stmt.setString(3, e.getTenTG());
			n = stmt.executeUpdate();
			
			
		} catch (Exception e1) {
			System.out.println("errro"+e1.getMessage());
		}
		return n>0;
	}

	@Override
	public boolean update(TacGiaEntity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TacGiaEntity findOne(int id) {
		ArrayList<TacGiaEntity> tacGiaEntities = new ArrayList<>();
		// Statement statement =null;
		try {
			Connection con = ConnectDB.instance.getconnection();
			String sql = "Select* from TacGia WHERE id = " + id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maTG = rs.getInt(1);
				String diachi = rs.getString(2);
				String phoneTG = rs.getString(3);
				String tenTG = rs.getString(4);
				TacGiaEntity tacGiaEntity =new TacGiaEntity(diachi, maTG, phoneTG, tenTG, null);
				tacGiaEntities.add(tacGiaEntity);
			}
		} catch (Exception e) {
			System.out.println("errro"+e.getMessage());
		}
		return tacGiaEntities.get(0);
	}

}
