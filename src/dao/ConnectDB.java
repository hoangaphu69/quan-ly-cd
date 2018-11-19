package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	
	public static Connection con = null;
	public static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance()
	{
		return instance;
	}
	public void connect()
	{
		try{
			System.out.println("ok");
			String url = "jdbc:sqlserver://localhost:1433;databasename=CD";
			String user = "sa";
			String password = "sapassword";
			con = DriverManager.getConnection(url,user,password);
		}catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("conect that bai");
		}
	}
	public void disconnect()
	{
		if(con!=null)
			try{
				con.close();
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getconnection()
	{

		try{
			System.out.println("ok");
			String url = "jdbc:sqlserver://localhost:1433;databasename=CD";
			String user = "sa";
			String password = "sapassword";
			con = DriverManager.getConnection(url,user,password);
		}catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("conect that bai");
		}
		System.out.println("DM");
		return con;
	}

}

