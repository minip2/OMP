package com.omp.css.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.css.domain.QuestionDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class QuestionDAO {
	public List<QuestionDM> selectQuestion(){
		List<QuestionDM> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select  no, id, title, question_content, question_date ");
			sql.append(" from t97_question  ");
			sql.append(" order by no desc  ");
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				QuestionDM question = new QuestionDM();
				question.setNo(rs.getInt("no"));
				question.setId(rs.getString("id"));
				question.setTitle(rs.getString("title"));
				question.setQuestion_content(rs.getString("question_content"));
				question.setQuestion_date(rs.getDate("question_date"));
				list.add(question);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	public QuestionDM selectQuestionByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			QuestionDM question = new QuestionDM();
			
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select no, id, title,  question_content, question_date ");
			sql.append(" from t97_question ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no );
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				question.setNo(rs.getInt("no"));
				question.setId(rs.getString("id"));
				question.setTitle(rs.getString("title"));
				question.setQuestion_content(rs.getString("question_content"));
				question.setQuestion_date(rs.getDate("question_date"));
				
				return question;
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
	public void insertQuestion(QuestionDM question) {
			Connection con = null;
			PreparedStatement stmt = null;
			try {
				con = ConnectionPool.getConnection();
				
				StringBuffer sql = new StringBuffer();
				sql.append(" insert into t97_question ( ");
				sql.append(" no, id, title,  question_content ");
				sql.append(" ) values( ");
				sql.append(" s_question_no.nextval, ?, ?, ? ");
				sql.append(") ");
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, question.getId());
				stmt.setString(2, question.getTitle());
				stmt.setString(3, question.getQuestion_content());
				stmt.executeUpdate();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(stmt);
				ConnectionPool.releaseConnection(con);
			}
		}

	public void updateQuestion(QuestionDM question) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			String title = question.getTitle();
			String question_content = question.getQuestion_content();
			
			sql.append(" update t97_question  ");
			sql.append("   set title = ?, ");
			sql.append("        question_content = ? ");
			sql.append(" where no = ? " );
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, title);
			stmt.setString(2, question_content);
			stmt.setInt(3, question.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	
	}
	
	
	public boolean deleteQuestion(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" delete ");
			sql.append(" from t97_question ");
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
