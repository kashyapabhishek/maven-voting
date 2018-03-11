package com.daw;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.MyConnection;
public class UserDaw {
	private static boolean status = false;
	private static Connection con = MyConnection.getConnection();
	public  int yes = 0;
	public  int no = 0;
	
	
	public static int myyes() {
		UserDaw u = new UserDaw();
		u.status();
		return u.yes;
	}
	
	public static int myno() {
		UserDaw u = new UserDaw();
		u.status();
		return u.no;
	}
	public void status(){
		try {
			float countyes = 0;
			float countno = 0;
			PreparedStatement ps = con.prepareStatement("select vote from useraction");
			System.out.println("prepared statement "+con);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				if(rs.getString(1).equals("yes"))
						countyes += 1;
				else
					countno += 1;
			}
			System.out.println(countno);
			float totel = countyes + countno;
			yes =(int)((countyes/totel)*100);
			no = (int)((countno/totel)*100);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	public static boolean post(com.bean.UserBean u) {
		
		System.out.println("Daw con"+con);
		try {
			PreparedStatement ps = con.prepareStatement("insert into useraction values(?,?)");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getVote());
			int rs = ps.executeUpdate();
			if(rs == 1)
				status = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			status = false;
		}
		System.out.println("status"+status);
		return status;
	}
	
	
}
