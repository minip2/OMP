package com.omp.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.common.domain.CommentDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class commentDAO {
	// 댓글 내용 보여주기
	public List<CommentDM> selectComment() {
		Connection con = null;
		PreparedStatement stmt = null;
		List<CommentDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select no, group_val, reg_date, content,"
					+ " id, nickname ");
			sql.append("  from t97_comment ");
			sql.append(" order by no desc ");
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CommentDM comt = new CommentDM();
				comt.setNo(rs.getInt("no"));
				comt.setGroupVal(rs.getInt("group_val"));
				comt.setRegDate(rs.getTimestamp("reg_date"));
				comt.setContent(rs.getString("content"));
				comt.setId(rs.getString("id"));
				comt.setNickname(rs.getString("nickname"));
				list.add(comt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	// 댓글 저장
	public void insertComment(CommentDM comt) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_comment (no, group_val, "
					+ "content, id, nickname ");
			sql.append("values (s_dictionary_no.nextval, ?, ?, ?, ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, comt.getGroupVal());
			stmt.setString(2, comt.getContent());
			stmt.setString(3, comt.getId());
			stmt.setString(4, comt.getNickname());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 댓글 수정
	public void updateComment(CommentDM comt) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update t97_comment ");
			sql.append("   set reg_date = sysdate, ");
			sql.append("       content = ?, ");
			sql.append(" where no = ?, ");
			sql.append("   and group_val = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, comt.getContent());
			stmt.setInt(2, comt.getNo());
			stmt.setInt(3, comt.getGroupVal());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 댓글 삭제
	public boolean deleteComment(int no) {
		Connection con = null;
			PreparedStatement stmt = null;
			int delNo = -1;
			try {
				con = ConnectionPool.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("delete t97_comment ");
				sql.append(" where no = ? ");
				stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, no);
				delNo = stmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(stmt);
				ConnectionPool.releaseConnection(con);
			}
			if (delNo == -1) {
				return false;
			}
			return true;
		}
}








