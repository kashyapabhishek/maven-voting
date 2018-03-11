package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private Connection con = null;
	
	public MyConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","6380");
			System.out.println("mucon"+con);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		MyConnection conn = new MyConnection();
		System.out.println("conn.con"+conn.con);
		return conn.con;
	}
	
}
