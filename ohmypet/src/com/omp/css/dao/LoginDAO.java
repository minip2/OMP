package com.omp.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.omp.css.domain.LoginDM;
import com.omp.util.ConnectionPool;

public class LoginDAO {
	
	public LoginDM login(String id, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			LoginDM login = new LoginDM();
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" select id, password, nick_name ");
			sql.append(" from t97_member ");
			sql.append(" where id = ? ");
			sql.append(" and password = ? ");
			stmt= con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			System.out.println(id);
			System.out.println(password);
			if(rs.next()) {
				login.setId(rs.getString("id"));
				
				login.setPassword(rs.getString("password"));
				login.setNick_name(rs.getString("nick_name"));
				
				return login;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
