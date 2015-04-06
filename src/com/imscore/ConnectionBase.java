package com.imscore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBase {
	Connection getConnection(){
		Connection con=null;
		try {
			
			
			//for oracle
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:IMS/IMS@localhost:1521/XE");
			
			
			
			//for mysql
			/*
			
			String host="jdbc:mysql://550eebe34382eca92e000056@ims-firstappjboss.rhcloud.com/IMS";
			String username="adminGyD2PFz";
			String password="ge_jfCRy2ITr";
			
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(host,username,password);
			
			DriverManager.getConnection("jdbc:mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/");
			
			*/
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
	}
}
