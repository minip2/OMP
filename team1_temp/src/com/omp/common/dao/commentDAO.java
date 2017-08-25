/*package com.omp.common.dao;

public class commentDAO {
	public void selectComment () {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select no, reg_date, content, id ");
			sql.append("  from t97_dictionary_comment");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}
*/