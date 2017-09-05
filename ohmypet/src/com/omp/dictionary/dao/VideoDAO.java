package com.omp.dictionary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class VideoDAO {
	public void insert () {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
//			sql.append("insert into t97_")
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}
