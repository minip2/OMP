package com.omp.dictionary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.dictionary.domain.DictionaryDM;
import com.omp.dictionary.domain.DogDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class DictionaryDAO {
	// 도그테이블 참조
	public DogDM selectDog(String dogName) {
		Connection con = null;
		PreparedStatement stmt = null;
		DogDM dogDM = new DogDM();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select dog_val, detail, category_val, dog_name,"
					+ " origin, size, color ");
			sql.append("  from t97_dog ");
			sql.append(" where dog_val = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, dogName);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				dogDM.setDogVal(rs.getInt("dog_val"));
				dogDM.setDetail(rs.getString("detail"));
				dogDM.setCategoryVal(rs.getInt("category_val"));
				dogDM.setDogName(rs.getString("dog_name"));
				dogDM.setOrigin(rs.getString("origin"));
				dogDM.setDogSize(rs.getString("dog_size"));
				dogDM.setColor(rs.getString("color"));
				return dogDM;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	// 히스토리 리스트 출력
	public List<DictionaryDM> selectDictionary() {
		Connection con = null;
		PreparedStatement stmt = null;
		List<DictionaryDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select version, mod_date, id, detail, nickname ");
			sql.append("  from t97_dictionary ");
			sql.append(" order by version desc ");
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				DictionaryDM dic = new DictionaryDM();
				dic.setVersion(rs.getString("version"));
				dic.setModDate(rs.getDate("mod_date"));
				dic.setId(rs.getString("id"));
				dic.setDetail(rs.getString("detail"));
				dic.setNickname(rs.getString("nickname"));
				list.add(dic);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	// 디테일 정보 출력
	public DictionaryDM selectDictionaryByNo(String version) {
		Connection con = null;
		PreparedStatement stmt = null;
		DictionaryDM dic = new DictionaryDM();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select dog_val, version, id, detail, mod_date, nickname ");
			sql.append("  from t97_dictionary ");
			sql.append(" where version = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, version);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				dic.setDogVal(rs.getInt("dog_val"));
				dic.setVersion(rs.getString("version"));
				dic.setId(rs.getString("id"));
				dic.setDetail(rs.getString("detail"));
				dic.setModDate(rs.getTimestamp("mod_date"));
				dic.setNickname(rs.getString("nickname"));
				return dic;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	// 현재 입력받은 디테일 정보 사전도메인에 저장
	public void insertDetail(DictionaryDM dic) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_dictionary(mod_date, dog_val, version,"
					+ " id, detail, nickname ");
			sql.append("values (sysdate, ?, ?, ?, ?, ? ) ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, dic.getDogVal());
			stmt.setString(2, dic.getVersion());
			stmt.setString(3, dic.getId());
			stmt.setString(4, dic.getDetail());
			stmt.setString(5, dic.getNickname());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	
	
	// 디테일 정보 삭제
	public boolean deleteDetail(String version) {
		Connection con = null;
		PreparedStatement stmt = null;
		int delNo = -1;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("delete t97_dictionary ");
			sql.append(" where version = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, version);
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
	
	// 도그도메인 디테일 정보 수정
	public void updateDetail(DogDM dog) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("update t97_dog ");
			sql.append("   set detail = ?, ");
			sql.append("       version = ? ");
			sql.append(" where dog_val = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, dog.getDetail());
			stmt.setString(2, dog.getVersion());
			stmt.setInt(3, dog.getDogVal());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 도그 검색..
	
	
}



