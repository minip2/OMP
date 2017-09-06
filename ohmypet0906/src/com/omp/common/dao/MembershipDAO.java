package com.omp.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.omp.common.domain.MembershipDM;
import com.omp.css.domain.LoginDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class MembershipDAO {
	
	public void insertMembership(MembershipDM member) {
	
	Connection con = null;
	PreparedStatement stmt = null;
	
	try {
		
		con = ConnectionPool.getConnection();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" insert into t97_member( ");
		sql.append(" id, password, email, name, phon_number, gender, store_check, address, nick_name   ");
		sql.append(" ) values( ");
		sql.append(" ?, ?, ?, ?, ?, ?, ?, ?, ? ");
		sql.append(")");
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, member.getId());
		stmt.setString(2, member.getPassword());
		stmt.setString(3, member.getEmail());
		stmt.setString(4, member.getName());
		stmt.setString(5, member.getPhon_number());
		stmt.setInt(6, member.getGender());
		stmt.setInt(7, member.getStore_check());
		stmt.setString(8, member.getAddress());
		stmt.setString(9, member.getNick_name());
		stmt.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		JdbcUtil.close(stmt);
		ConnectionPool.releaseConnection(con);
	}
	}
	
	public boolean loginIdOverlap(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			LoginDM login = new LoginDM();
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" select id ");
			sql.append(" from t97_member ");
			sql.append(" where id = ? ");
			stmt= con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			System.out.println(id);
			
			if(rs.next()) {
				login.setId(rs.getString("id"));
			}
			if(login.getId() != null) return false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return true;
	}
	
	public boolean nick_nameOverlap(String nick_name) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			LoginDM login = new LoginDM();
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" select nick_name ");
			sql.append(" from t97_member ");
			sql.append(" where nick_name = ? ");
			stmt= con.prepareStatement(sql.toString());
			stmt.setString(1, nick_name);
			
			ResultSet rs = stmt.executeQuery();
			System.out.println(nick_name);
			
			if(rs.next()) {
				login.setNick_name(rs.getString("nick_name"));
			}
			if(login.getNick_name() != null) return false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return true;
	}
	
	public MembershipDM selectMembershipById(String id) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			MembershipDM member = new MembershipDM();
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select id, password, email, name, phon_number, gender, store_check, address, nick_name  ");
			sql.append(" from t97_member ");
			sql.append(" where id = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPhon_number(rs.getString("phon_number"));
				member.setGender(rs.getInt("gender"));
				member.setStore_check(rs.getInt("store_check"));
				member.setAddress(rs.getString("address"));
				member.setNick_name(rs.getString("nick_name"));
				
				return member;
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}