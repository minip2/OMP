package com.omp.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.css.domain.FaqDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class FaqDAO {
	public List<FaqDM> selectFaq(){
		List<FaqDM> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select  no, nick_name, title, content  ");
			sql.append(" from t97_faq, t97_member ");
			sql.append(" order by no desc  ");
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				FaqDM faq = new FaqDM();
				faq.setNo(rs.getInt("no"));
				faq.setNick_name(rs.getString("id"));
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				list.add(faq);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	public FaqDM selectFaqByNo(int no) {
		updateFaqViewCnt(no);
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			FaqDM faq = new FaqDM();
			
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select no, nick_name, title,  content,  ");
			sql.append(" from t97_faq, t97_member ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no );
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				faq.setNo(rs.getInt("no"));
				faq.setNick_name(rs.getString("nick_name"));
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				
				return faq;
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
	public void insertFaq(FaqDM faq) {
			Connection con = null;
			PreparedStatement stmt = null;
			try {
				con = ConnectionPool.getConnection();
				
				StringBuffer sql = new StringBuffer();
				sql.append(" insert into t97_faq ( ");
				sql.append(" no, nick_name, title,  content ");
				sql.append(" ) values ( ");
				sql.append(" s_faq_no.nextval, ?, ?, ? ");
				sql.append(") ");
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, faq.getNick_name());
				stmt.setString(2, faq.getTitle());
				stmt.setString(3, faq.getContent());
				stmt.executeUpdate();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(stmt);
				ConnectionPool.releaseConnection(con);
			}
		}

	public void updateFaq(FaqDM faq) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			String title = faq.getTitle();
			String content = faq.getContent();
			
			sql.append(" update t97_faq  ");
			sql.append("   set title = ?, ");
			sql.append("        content = ? ");
			sql.append(" where no = ? " );
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, faq.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	
	}
	public void updateFaqViewCnt(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" update ");
			sql.append(" set view_cnt = view_cnt+1 ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1,no);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	
	
	public boolean deleteFaq(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" delete ");
			sql.append(" from t97_faq ");
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
