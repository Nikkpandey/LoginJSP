package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String sql="select * from login where uname=? and upass=?";
	String url="jdbc:mysql://localhost:3306/userDetails";
	String username="root";
	String password="Nikk123@";
	public boolean check(String uname,String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
