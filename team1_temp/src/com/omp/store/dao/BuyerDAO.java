package com.omp.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.store.domain.BuyerDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class BuyerDAO {
BuyerDM pdm = new BuyerDM();
	
	public List<BuyerDM> BuyerList() {
		Connection con = null;
		PreparedStatement stmt = null;
		List<BuyerDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("b.select buy_no, ");
			sql.append("b.product_id , ");
			sql.append("b.buy_amount , ");
			sql.append("b.buy_date , ");
			sql.append("b.id  ");
			sql.append("  from t97_buyer b,t97_Product p");
			sql.append(" where b.product_id =p.product_id ");
			stmt=con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BuyerDM dm = new BuyerDM();
				dm.setBuyNo(rs.getString("buy_no"));
				dm.setProductId(rs.getString("product_id"));
				dm.setBuysAmount(rs.getInt("buy_amount"));
				dm.setBuyDate(rs.getDate("buy_date"));
				dm.setId(rs.getString("id"));
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

	public BuyerDM BuyerSelect(String buyNo) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select buy_no, ");
			sql.append("category_val, ");
			sql.append("product_name, ");
			sql.append("photo_path, ");
			sql.append("quantity, ");
			sql.append("price ");
			sql.append("  from t97_Product ");
			sql.append(" where buy_no = ? ");
			stmt=con.prepareStatement(sql.toString());
			stmt.setString(1, buyNo);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				BuyerDM dm = new BuyerDM();
				dm.setProductId(rs.getString("buy_no"));
				dm.setCategoryVal(rs.getInt("category_val"));
				dm.setProductName(rs.getString("product_name"));
				dm.setQuantity(rs.getInt("quantity"));
				dm.setPrice(rs.getInt("price"));
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
	
	public void BuyerInsert(BuyerDM dm) {
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = ConnectionPool.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into t97_Product(buy_no, ");
		sql.append("category_val, ");
		sql.append("product_name, ");
		sql.append("photo_path, ");
		sql.append("quantity, ");
		sql.append("price) ");
		sql.append("values(?, ");	//상품코드(스트링)
		sql.append("?, ");				//카테고리 밸류(인트)
		sql.append("?, ");			//상품명(스트링)
		sql.append("?, ");		//사진경로(스트링)
		sql.append("?, ");				//총수량(인트)
		sql.append("?) ");				//가격(인트)
		
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, dm.getProductId());
		stmt.setInt(2, dm.getCategoryVal());
		stmt.setString(3, dm.getProductName());
		stmt.setString(4, dm.getPhotoPath());
		stmt.setInt(5, dm.getQuantity());
		stmt.setInt(6, dm.getPrice());
		stmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(stmt);
		ConnectionPool.releaseConnection(con);
	}
	
	}
	
	public void BuyerUpdate(BuyerDM domain) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update t97_Product ");
			sql.append("   set product_name = ?, ");
			sql.append("       category_val = ?, ");
			sql.append("       price = ?, ");
			sql.append("       photo_path = ?, ");
			sql.append("       quantity = ? " );
			sql.append(" where buy_no = ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, domain.getProductName());
			stmt.setInt(2, domain.getCategoryVal());
			stmt.setInt(3, domain.getPrice());
			stmt.setString(4, domain.getPhotoPath());
			stmt.setInt(5, domain.getQuantity());
			stmt.setString(6, domain.getProductId());
			int no = stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public boolean BuyerDelete(String id) {

		int delNo = 0;
		Connection con = null;
		PreparedStatement stmt = null;
			try {
				con = ConnectionPool.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("delete " );
				sql.append("  from t97_Product " );
				sql.append(" where buy_no = ? " );
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, id);
				
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
