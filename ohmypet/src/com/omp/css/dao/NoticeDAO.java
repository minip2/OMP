package com.omp.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.css.domain.NoticeDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;





public class NoticeDAO {
	public int maxNo() {
		int no =1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" select Max(no) as no ");
			sql.append(" from t97_notice ");
			stmt = con.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) no = rs.getInt("no");
				
			
		} catch (Exception e) {
			e.printStackTrace(); System.out.println("맥스넘 에러");
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return no;
	}
	
	public List<NoticeDM> selectNotice(){
		List<NoticeDM> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select  no, id, title, content, reg_Date ");
			sql.append(" from t97_notice  ");
			sql.append(" order by no desc  ");
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NoticeDM notice = new NoticeDM();
				notice.setNo(rs.getInt("no"));
				notice.setId(rs.getString("id"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegDate(rs.getDate("reg_Date"));
				list.add(notice);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	public NoticeDM selectNoticeByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			NoticeDM notice = new NoticeDM();
			
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select no, id, title,  content, reg_Date ");
			sql.append(" from t97_notice ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no );
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				notice.setNo(rs.getInt("no"));
				notice.setId(rs.getString("id"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegDate(rs.getDate("reg_Date"));
				
				return notice;
				
			}
			else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return null;
	}
	public void insertNotice(NoticeDM notice) {
			Connection con = null;
			PreparedStatement stmt = null;
			try {
				con = ConnectionPool.getConnection();
				
				StringBuffer sql = new StringBuffer();
				sql.append(" insert into t97_notice ( ");
				sql.append(" no, id, title,  content ");
				sql.append(" ) values ( ");
				sql.append(" s_notice_no.nextval, ?, ?, ? ");
				sql.append(") ");
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, notice.getId());
				stmt.setString(2, notice.getTitle());
				stmt.setString(3, notice.getContent());
				stmt.executeUpdate();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(stmt);
				ConnectionPool.releaseConnection(con);
			}
		}

	public void updateNotice(NoticeDM notice) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			String title = notice.getTitle();
			String content = notice.getContent();
			
			sql.append(" update t97_notice  ");
			sql.append("   set title = ?, ");
			sql.append("        content = ? ");
			sql.append(" where no = ? " );
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, notice.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	
	}
	
	
	public boolean deleteNotice(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" delete ");
			sql.append(" from t97_notice ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			int cnt =stmt.executeUpdate();
			if(cnt ==1) {
				return true;
			}
			else return false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
			
		}
		 return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
