package dao;

import java.util.List;

import entity.CDEntity;
import entity.PhanMemEntity;

public class TestDB {

	public static void main(String[] args) {
		PhanMemDAO dao = new PhanMemDAO();
		CDDAO cddao = new CDDAO();
		
		List<PhanMemEntity> entities = dao.getAll();
		List<CDEntity> cdEntities = cddao.getAll();

	}

}
