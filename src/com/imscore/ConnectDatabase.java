package com.imscore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase extends ConnectionBase{
	
	static final String ORACLE_JDBC_DRIVER = "";  
	static final String ORACLE_DB_URL = "";
	static final String USER = "IMS";
	static final String PASS = "IMS";
	
	
	
	
	public boolean checkCredentials(String uname,String pwd)  {
		boolean approvedLogin=false;
		Connection con =null;
		String dbpassword=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con= getConnection();
			String sql = "SELECT * FROM users where username=?";
			//Statement statement = con.createStatement();
			ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			rs= ps.executeQuery();
			
			while (rs.next()) {
				//System.out.println("got here while");
				dbpassword=rs.getString("password");
			}
			System.out.println("dbpasswod "+dbpassword);
			if(dbpassword !=null){
				if(dbpassword.equals(pwd)){
					System.out.println("successfull login");
					approvedLogin=true;
				}
				else{
					System.out.println("wrong password");
				}
			}
			else{
				System.out.println("user not exists");
			}
			con.close();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error while create statement");
			e.printStackTrace();
		}
		return approvedLogin;
	}
		
	
}
