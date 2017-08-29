package com.omp.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.store.domain.ProductDM;
import com.omp.store.domain.ShBoardDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class ShBoardDAO {
ShBoardDM pdm = new ShBoardDM();
	
	public List<ShBoardDM> ShBoardList() {
		Connection con = null;
		PreparedStatement stmt = null;
		List<ShBoardDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.no, ");
			sql.append("p.product_id , ");
			sql.append("s.id , ");
			sql.append("s.title , ");
			sql.append("s.reg_Date  ");
			sql.append("  from t97_Product p, t97_ShBoard s ");
			sql.append(" where s.product_id = p.product_id ");
			sql.append(" order by b.no desc");
			
			stmt=con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ShBoardDM dm = new ShBoardDM();
				dm.setNo(rs.getInt("s.no"));
				dm.setProductId(rs.getString("p.product_id"));
				dm.setId(rs.getString("s.id"));
				dm.setTitle(rs.getString("s.title"));
				dm.setRegDate(rs.getDate("s.reg_Date"));
				list.add(dm);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}

		return list;
	}

	public ShBoardDM ShBoardSelect(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.no, ");
			sql.append("p.product_id, ");
			sql.append("p.product_name, ");
			sql.append("p.category_val, ");
			sql.append("p.photo_path, ");
			sql.append("p.quantity, ");
			sql.append("p.price, ");
			sql.append("s.title, ");
			sql.append("s.id, ");
			sql.append("s.product_Detail, ");
			sql.append("s.sales_Amount + b.buys_amount as total_sales_amount, ");
			sql.append("s.reg_Date ");
			sql.append(" from t97_shboard b,t97_Product p,t97_ShBoard s  ");
			sql.append(" where s.no = ? ");
			stmt=con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				ProductDM pdm = new ProductDM();
				ShBoardDM dm = new ShBoardDM();
				dm.setNo(rs.getInt("s.no"));
				dm.setProductId(rs.getString("p.product_id"));
				pdm.setProductName(rs.getString("p.product_name"));
				pdm.setCategoryVal(rs.getInt("p.category_val"));
				pdm.setPhotoPath(rs.getString("p.photo_path"));
				pdm.setQuantity(rs.getInt("p.quantity"));
				pdm.setPrice(rs.getInt("p.price"));
				dm.setTitle(rs.getString("s.title"));
				dm.setId(rs.getString("s.id"));
				dm.setProductDetail(rs.getString("s.product_Detail"));
				dm.setSalesAmount(rs.getInt("total_sales_amount"));
				dm.setRegDate(rs.getTimestamp("s.reg_Date"));
				return dm;
			}
			else {return null;}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
		
	}
	
	public void ShBoardInsert(ShBoardDM dm) {
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = ConnectionPool.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into t97_shboard(no, ");
		sql.append("id, ");
		sql.append("title, ");
		sql.append("product_detail ");
		sql.append("values(s_shboard_no.nextval, ");	
		sql.append("?, ");				//작성자(스트링)
		sql.append("?, ");			//제목(스트링)
		sql.append("?, ");				//제품상세(스트링)
		
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, dm.getId());
		stmt.setString(2, dm.getTitle());
		stmt.setString(3, dm.getProductDetail());
		stmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(stmt);
		ConnectionPool.releaseConnection(con);
	}
	
	}
	
	public void ShBoardUpdate(ShBoardDM domain) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update t97_shboard ");
			sql.append("   set title = ?, ");
			sql.append("       product_detail = ?, ");
			sql.append(" where no = ? ");
			
			stmt = con.prepareStatement(sql.toString());;
			stmt.setString(1, domain.getTitle());
			stmt.setString(2, domain.getProductDetail());
			stmt.setInt(3, domain.getNo());
			int no = stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public boolean ShBoardDelete(int no) {

		int delNo = 0;
		Connection con = null;
		PreparedStatement stmt = null;
			try {
				con = ConnectionPool.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("delete " );
				sql.append("  from t97_shboard " );
				sql.append(" where no = ? " );
				stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, no);
				
				delNo = stmt.executeUpdate(); 
				if(delNo == 0) {
					return false;
				}
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(stmt);
				ConnectionPool.releaseConnection(con);
			}
			return false;
			
	}

	
}
