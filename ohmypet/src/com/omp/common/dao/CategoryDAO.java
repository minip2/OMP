package com.omp.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.common.domain.CategoryDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class CategoryDAO {
	public List<CategoryDM> selectCategory (int groupVal) {
		Connection con = null;
		PreparedStatement stmt = null;
		List<CategoryDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select category_val , category_name ");
			sql.append("  from t97_category ");
			sql.append(" where category_group = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, groupVal);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CategoryDM cdm = new CategoryDM();
				cdm.setGroupVal(groupVal);
				cdm.setCategoryVal(rs.getInt("category_val"));
				cdm.setCategoryName(rs.getString("category_name"));
				list.add(cdm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}	
}
