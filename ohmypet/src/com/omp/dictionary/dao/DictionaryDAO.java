package com.omp.dictionary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Dictionary;
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
			sql.append("select * ");
			sql.append("  from t97_dog ");
			sql.append(" where dog_name = ? ");
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
				dogDM.setVersion(rs.getInt("version"));
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
	public List<DictionaryDM> selectDictionaryList(int dogVal) {
		Connection con = null;
		PreparedStatement stmt = null;
		List<DictionaryDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from t97_dictionary ");
			sql.append(" where dog_val = ? ");			
			sql.append(" order by version desc ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, dogVal);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				DictionaryDM dic = new DictionaryDM();
				dic.setDogVal(rs.getInt("dog_val"));
				dic.setVersion(rs.getInt("version"));
				dic.setId(rs.getString("id"));
				dic.setDetail(rs.getString("detail"));
				dic.setModDate(rs.getTimestamp("mod_date"));
				dic.setNick_name(rs.getString("nick_name"));
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
	
	// 디테일 정보 참조
	public DictionaryDM selectDictionary(int dogVal, int version) {
		Connection con = null;
		PreparedStatement stmt = null;
		DictionaryDM dic = new DictionaryDM();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select dog_val, version, id, detail, mod_date, nick_name ");
			sql.append("  from t97_dictionary ");
			sql.append(" where dog_val = ? ");
			sql.append("   and version = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, dogVal);
			stmt.setInt(2, version);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				dic.setDogVal(rs.getInt("dog_val"));
				dic.setVersion(rs.getInt("version"));
				dic.setId(rs.getString("id"));
				dic.setDetail(rs.getString("detail"));
				dic.setModDate(rs.getTimestamp("mod_date"));
				dic.setNick_name(rs.getString("nick_name"));
				
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
	
	// 최신 디테일 참조
	public DictionaryDM selectPreDictionary(int dogVal) {
		Connection con = null;
		PreparedStatement stmt = null;
		DictionaryDM dic = new DictionaryDM();
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select dog_val, version, id, detail, mod_date, nick_name ");
			sql.append("  from (select * ");
			sql.append("          from t97_dictionary ");
			sql.append("         where dog_val = ? ");
			sql.append("         order by version desc) a ");
			sql.append(" where rownum = 1 ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, dogVal);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				dic.setDogVal(rs.getInt("dog_val"));
				dic.setVersion(rs.getInt("version"));
				dic.setId(rs.getString("id"));
				dic.setDetail(rs.getString("detail"));
				dic.setModDate(rs.getTimestamp("mod_date"));
				dic.setNick_name(rs.getString("nick_name"));
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
	public void insertDictionary(DictionaryDM dic, String sequenceName) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_dictionary(dog_val, version, id, detail, mod_date, nick_name) ");
			sql.append("values (?, " + sequenceName + ".nextval, ?, ?, sysdate, ? ) ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, dic.getDogVal());
			stmt.setString(2, dic.getId());
			stmt.setString(3, dic.getDetail());
			stmt.setString(4, dic.getNick_name());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
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
			stmt.setInt(2, dog.getVersion());
			stmt.setInt(3, dog.getDogVal());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 디테일 정보 삭제
	public int deleteDetail(int dogVal, int version) {
		Connection con = null;
		PreparedStatement stmt = null;
		int delNo = -1;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("delete t97_dictionary ");
			sql.append(" where dog_val = ? ");
			sql.append("   and version = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, dogVal);
			stmt.setInt(2, version);
			delNo = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		if (delNo == -1) {
			return -1;
		}
		return version;
	}
	
	// 도그 검색..
	public List<String> searchDog(String groupName, String keyword) {
		Connection con = null;
		PreparedStatement stmt = null;
		List<String> list = new ArrayList<>();
		keyword = "%" + keyword + "%";
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select dog_name ");
			sql.append("  from t97_dog ");
			sql.append(" where " + groupName + " like ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, keyword);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("dog_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	// 디테일 시퀀스 생성
	public String insertSequence(int dogVal) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sequenceName = "s_dictionary_" + dogVal;

		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("create sequence " + sequenceName);
			stmt = con.prepareStatement(sql.toString());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return sequenceName;
	}
}



