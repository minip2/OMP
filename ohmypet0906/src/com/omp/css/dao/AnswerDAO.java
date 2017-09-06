package com.omp.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.css.domain.AnswerDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class AnswerDAO {
	public List<AnswerDM> selectAnswer(){
		List<AnswerDM> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select  no, id, title, answer_content, answer_date ");
			sql.append(" from t97_answer  ");
			sql.append(" order by no desc  ");
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				AnswerDM answer = new AnswerDM();
				answer.setNo(rs.getInt("no"));
				answer.setId(rs.getString("id"));
				answer.setTitle(rs.getString("title"));
				answer.setAnswer_content(rs.getString("answer_content"));
				answer.setAnswer_date(rs.getDate("answer_date"));
				list.add(answer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	public AnswerDM selectAnswerByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			AnswerDM answer = new AnswerDM();
			
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select no, id, title,  answer_content, answer_date ");
			sql.append(" from t97_answer ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no );
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				answer.setNo(rs.getInt("no"));
				answer.setId(rs.getString("id"));
				answer.setTitle(rs.getString("title"));
				answer.setAnswer_content(rs.getString("answer_content"));
				answer.setAnswer_date(rs.getDate("answer_date"));
				
				return answer;
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
	public void insertAnswer(AnswerDM answer) {
			Connection con = null;
			PreparedStatement stmt = null;
			try {
				con = ConnectionPool.getConnection();
				
				StringBuffer sql = new StringBuffer();
				sql.append(" insert into t97_answer ( ");
				sql.append(" no, id, title,  answer_content ");
				sql.append(" ) values ( ");
				sql.append(" s_answer_no.nextval, ?, ?, ? ");
				sql.append(") ");
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, answer.getId());
				stmt.setString(2, answer.getTitle());
				stmt.setString(3, answer.getAnswer_content());
				stmt.executeUpdate();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(stmt);
				ConnectionPool.releaseConnection(con);
			}
		}

	public void updateAnswer(AnswerDM answer) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			String title = answer.getTitle();
			String answer_content = answer.getAnswer_content();
			
			sql.append(" update t97_answer  ");
			sql.append("   set title = ?, ");
			sql.append("        answer_content = ? ");
			sql.append(" where no = ? " );
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, title);
			stmt.setString(2, answer_content);
			stmt.setInt(3, answer.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	
	}
	
	
	public boolean deleteAnswer(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" delete ");
			sql.append(" from t97_answer ");
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
