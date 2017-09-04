package com.omp.photo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.photo.domain.PhotoBoardDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class PhotoBoardDAO {
	//포토리스트 출력
	public List<PhotoBoardDM> selectPhotoList(){
			List<PhotoBoardDM> list = new ArrayList<>();
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select no, id, title, content, dog_val, file_path, reg_date ");
			sql.append(" from t97_photo ");
			sql.append(" order by no ");
			//sql.append("from t97_photo,t97_member;");
			//System.out.println(sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			//System.out.println("객체 만듬");
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("쿼리 실행완료");
			while(rs.next()) {
				PhotoBoardDM photoBoard = new PhotoBoardDM();
				photoBoard.setNo(rs.getInt("no"));
				photoBoard.setId(rs.getNString("id"));
				photoBoard.setTitle(rs.getString("title"));
				photoBoard.setContent(rs.getString("content"));
				photoBoard.setDog_val(rs.getInt("dog_val"));
				photoBoard.setFile_path(rs.getString("file_path"));
				//photoBoard.setView_cnt(rs.getInt("view_cnt"));
				photoBoard.setReg_date(rs.getDate("reg_date"));
				list.add(photoBoard);
			}
		}catch (Exception e) {
			System.out.println("셀렉트 DAO 오류");
			e.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	//포토 글 출력
	public PhotoBoardDM selectPhotoDetail(int no){
		Connection con = null;
		PreparedStatement pstmt = null;
		PhotoBoardDM photoBoard = new PhotoBoardDM();
		try {
			//System.out.println("셀렉트에 들어온 no :"+ no);
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select no, id, title, content, file_path, dog_val, view_cnt, recommend_cnt, reg_date ");
			sql.append(" from t97_photo ");
			sql.append(" where no= ? ");
			//sql.append("from t97_photo,t97_member;");
			//System.out.println("1 : "+sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			//System.out.println("2 : "+sql.toString());
			//System.out.println("객체 만듬");
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("퀴리 실행");
			if(rs.next()) {	
				photoBoard.setNo(rs.getInt("no"));
				photoBoard.setId(rs.getNString("id"));
				photoBoard.setTitle(rs.getString("title"));
				photoBoard.setContent(rs.getString("content"));
				photoBoard.setFile_path(rs.getString("file_path"));
				photoBoard.setDog_val(rs.getInt("dog_val"));
				photoBoard.setView_cnt(rs.getInt("view_cnt"));
				photoBoard.setRecommend_cnt(rs.getInt("recommend_cnt"));
				photoBoard.setReg_date(rs.getDate("reg_date"));
			}
	}catch (Exception e) {
		System.out.println("셀렉트 디테일 DAO 오류");
		e.printStackTrace();
		return null;
	}finally {
		JdbcUtil.close(pstmt);
		ConnectionPool.releaseConnection(con);
	}
		return photoBoard;
}
	
	//게시판 입력
	public void insertPhotoBoard(PhotoBoardDM photoBoard) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_photo(no, id, title, content,file_path, dog_val"); 
			sql.append(" ) values (");
			sql.append("s_photo_no.nextval,?,?,?,?,? ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, photoBoard.getId());
			pstmt.setString(2, photoBoard.getTitle());
			pstmt.setString(3, photoBoard.getContent());
			pstmt.setString(4, photoBoard.getFile_path());
			pstmt.setInt(5, photoBoard.getDog_val());
			pstmt.executeUpdate();			
		} catch (Exception e) {
			System.out.println("인설트 DAO 오류");
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	//게시판 수정
	public void updatePhotoBoard(PhotoBoardDM photoBoard) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update t97_photo");
			sql.append(" set id=?");
			sql.append("	 title=?	");
			sql.append("	 content=?	");
			sql.append("	 file_path=?	");
			sql.append("	 dog_val=?	");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, photoBoard.getId());
			pstmt.setString(2, photoBoard.getTitle());
			pstmt.setString(3, photoBoard.getContent());
			pstmt.setString(4, photoBoard.getFile_path());
			pstmt.setInt(5, photoBoard.getDog_val());
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("업데이트 DAO 오류");
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	//게시판 삭제
	public void deletePhotoBoard(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
		} catch (Exception e) {
			System.out.println("삭제 DAO 오류");
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
	}
	
	
}
