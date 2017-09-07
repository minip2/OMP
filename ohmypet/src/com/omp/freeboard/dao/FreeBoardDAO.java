package com.omp.freeboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.freeboard.domain.FreeBoardDM;
import com.omp.freeboard.domain.FreeBoardFile;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;


public class FreeBoardDAO {
	
	public List<FreeBoardDM> selectBoard(int pageNo) {
		List<FreeBoardDM> list = new ArrayList<>();
		Connection con = null ;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append("select * "); 
			sql.append("  from (select rownum rnum, no, category_val,title,id,reg_date "); 
			sql.append("          from (select rownum, a.* "); 
			sql.append("                  from t97_freeboard a "); 
			sql.append("                 order by no desc)) "); 
			sql.append(" where rnum between ? and ? "); 
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pageNo * 10 - 9);
			pstmt.setInt(2, pageNo * 10);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				FreeBoardDM board = new FreeBoardDM();
				board.setNo(rs.getInt("no"));
				board.setCategoryName(rs.getInt("category_val"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("id"));
				board.setRegDate(rs.getDate("reg_date"));
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return list;
	}
	
	public FreeBoardDM selectBoardByNo(int no) {
		FreeBoardDM board = new FreeBoardDM();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select a.no, a.title, a.id, a.content, a.reg_date, a.view_num,"
					   +"a.recommend, a.file_path, b.category_val, c.name");
			sql.append("  from t97_freeboard a, t97_category b,t97_member c ");
			sql.append(" where a.category_val = b.category_val ");
			sql.append("  and a.id = c.id ");
			pstmt = con.prepareStatement(sql.toString());
			//pstmt.setInt(1,no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("id"));
				board.setContent(rs.getString("content"));
				board.setViewNum(rs.getInt("view_num"));
				board.setRecommend(rs.getInt("recommend"));
				board.setFilePath(rs.getString("file_path"));
				board.setRegDate(rs.getTimestamp("reg_date"));
				board.setCategoryName(rs.getInt("category_val"));
				board.setName(rs.getString("name"));
				
			return board;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}

	// 게시글에 들어갈 글번호를 미리 꺼내서 파일에서도 사용하도록 한다.
	public int selectBoardCount() {
		int no = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*) from t97_freeboard "); 
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				no = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}	
		return no;
	}
	
	public int selectBoardNo() {
		int no = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s_freeboard_no.nextval from dual "); 
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				no = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}	
		return no;
	}
	
	
	public void insertBoard(FreeBoardDM board) {
		Connection con = null; 
		PreparedStatement pstmt = null;  
		try {
			
			con = ConnectionPool.getConnection();    
			
			StringBuffer sql = new StringBuffer(); 
	    	 sql.append("insert into t97_freeboard( ");
	    	 sql.append(" no,title,id,content,file_path,category_val,pw");
	    	 sql.append(") values ( ");
	    	 sql.append("?, ?, ?,?,?,?,?) ");
	    	 
	    	 pstmt = con.prepareStatement(sql.toString());
	    	 pstmt.setInt(1, board.getNo());
	    	 pstmt.setString(2, board.getTitle());
	    	 pstmt.setString(3, board.getName());
	    	 pstmt.setString(4, board.getContent());
	    	 pstmt.setString(5, board.getFilePath());
	    	 pstmt.setInt(6, board.getCategoryVal());
	    	 pstmt.setString(7, board.getPw());
	    	 
	    	 pstmt.executeUpdate();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}finally { 
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public void insertBoardFile(FreeBoardFile file) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_freeboard_file(file_no, no, file_size, file_org_name, file_system_name, file_path) "); 
			sql.append("values(s_freeboard_file_no.nextval, ?, ?, ?, ?, ?) "); 
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, file.getNo());	
			pstmt.setInt(2, file.getFileSize());	
			pstmt.setString(3, file.getFileOrgName());	
			pstmt.setString(4, file.getFileSystemName());	
			pstmt.setString(5, file.getFilePath());	
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
	}
	
	public void updateBoard(FreeBoardDM board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			 
			  StringBuffer sql = new StringBuffer(); 
		    	 sql.append("update t97_freeboard ");
		    	 sql.append(" set title = ?,content = ?,file_path = ?,pw =? ");
		    	 sql.append(" where no = ? ");
		    	 
		     	 pstmt = con.prepareStatement(sql.toString());
		    	 pstmt.setString(1, board.getTitle());
		    	 pstmt.setString(2, board.getContent());
		    	 pstmt.setString(3, board.getFilePath());
		    	 pstmt.setString(4, board.getPw());
		    	 pstmt.setInt(5, board.getNo());
		    	 
		    	 pstmt.executeUpdate(); 
		    	 
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public boolean deleteBoard(int no) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 try {
			con= ConnectionPool.getConnection();
			 StringBuffer sql = new StringBuffer();
				sql.append("delete ");
				sql.append("from  t97_freeboard ");
				sql.append("where no =? ");
				
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setInt(1,no);
		int cnt = pstmt.executeUpdate();
		 if(cnt==1) {
			return true;
		}
		
		} catch (Exception e) {
		   e.printStackTrace();
		   
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return false;
	}

	
}



