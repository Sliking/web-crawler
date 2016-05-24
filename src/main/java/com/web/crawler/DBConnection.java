package com.web.crawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public Connection conn = null;
	
	public DBConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Crawler";
			conn = DriverManager.getConnection(url, "root", "rootroot");
			System.out.println("Connection established");
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public ResultSet runSql(String sql) throws SQLException{
		Statement s = conn.createStatement();
		return s.executeQuery(sql);
	}
	
	public boolean boolSql(String sql) throws SQLException{
		Statement s = conn.createStatement();
		return s.execute(sql);
	}
	
	@Override
	protected void finalize() throws Throwable{
		if(conn != null || !conn.isClosed()){
			conn.close();
		}
	}
}
