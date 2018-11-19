package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	
	private Connection connection;
	
	public DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:49933;databasename=CD","sa","sapassword");	
			System.out.println("OKOKOK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DAO();

	}
}
