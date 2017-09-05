package com.omp.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.store.domain.ProductDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class ProductDAO {
	ProductDM pdm = new ProductDM();
	
	public List<ProductDM> ProductList() {
		Connection con = null;
		PreparedStatement stmt = null;
		List<ProductDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select Product_id, ");
			sql.append("category_val, ");
			sql.append("product_name, ");
			sql.append("quantity, ");
			sql.append("price, ");
			sql.append("no ");
			sql.append("  from t97_Product ");
			sql.append(" order by no desc");			
			stmt=con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ProductDM dm = new ProductDM();
				dm.setProductId(rs.getString("Product_id"));
				dm.setCategoryVal(rs.getInt("category_val"));
				dm.setProductName(rs.getString("product_name"));
				dm.setQuantity(rs.getInt("quantity"));
				dm.setPrice(rs.getInt("price"));
				dm.setNo(rs.getInt("no"));
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

	public ProductDM ProductSelect(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select Product_id, ");
			sql.append("category_val, ");
			sql.append("product_name, ");
			sql.append("quantity, ");
			sql.append("price ");
			sql.append("  from t97_Product ");
			sql.append(" where Product_id = ? ");
			stmt=con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				ProductDM dm = new ProductDM();
				dm.setProductId(rs.getString("Product_id"));
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
	
	public void ProductInsert(ProductDM dm) {
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = ConnectionPool.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into t97_Product(Product_id, ");
		sql.append("category_val, ");
		sql.append("product_name, ");
		sql.append("quantity, ");
		sql.append("price, ");
		sql.append("no) ");
		sql.append("values(?, ");	//상품코드(스트링)
		sql.append("?, ");				//카테고리 밸류(인트)
		sql.append("?, ");			//상품명(스트링)
		sql.append("?, ");				//총수량(인트)
		sql.append("?, ");				//가격(인트)
		sql.append("s_Product_no.nextval) ");				//글번호(인트)
		
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, dm.getProductId());
		stmt.setInt(2, dm.getCategoryVal());
		stmt.setString(3, dm.getProductName());
		stmt.setInt(4, dm.getQuantity());
		stmt.setInt(5, dm.getPrice());
		stmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(stmt);
		ConnectionPool.releaseConnection(con);
	}
	
	}
	
	public void ProductUpdate(ProductDM domain) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update t97_Product ");
			sql.append("   set product_name = ?, ");
			sql.append("       category_val = ?, ");
			sql.append("       price = ?, ");
			sql.append("       quantity = ? " );
			sql.append(" where Product_id = ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, domain.getProductName());
			stmt.setInt(2, domain.getCategoryVal());
			stmt.setInt(3, domain.getPrice());
			stmt.setInt(4, domain.getQuantity());
			stmt.setString(5, domain.getProductId());
			int no = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public boolean ProductDelete(String id) {

		int delNo = 0;
		Connection con = null;
		PreparedStatement stmt = null;
			try {
				con = ConnectionPool.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("delete " );
				sql.append("  from t97_Product " );
				sql.append(" where Product_id = ? " );
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
	public List<ProductDM> KeywordSearch(String category,String skeyword) {
		Connection con = null;
		PreparedStatement stmt = null;
		List<ProductDM> list = new ArrayList<>();
		
		String str = "%" + skeyword+"%";
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select Product_id, ");
			sql.append("category_val, ");
			sql.append("product_name, ");
			sql.append("quantity, ");
			sql.append("price, ");
			sql.append("no ");
			sql.append("  from t97_Product ");
			sql.append("  where " + category + " like ? ");
			sql.append(" order by no desc");			
			stmt=con.prepareStatement(sql.toString());
			stmt.setString(1, str);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ProductDM dm = new ProductDM();
				dm.setProductId(rs.getString("Product_id"));
				dm.setCategoryVal(rs.getInt("category_val"));
				dm.setProductName(rs.getString("product_name"));
				dm.setQuantity(rs.getInt("quantity"));
				dm.setPrice(rs.getInt("price"));
				dm.setNo(rs.getInt("no"));
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
	public List<ProductDM> KeywordSearch(String category,int ikeyword) {
		Connection con = null;
		PreparedStatement stmt = null;
		List<ProductDM> list = new ArrayList<>();
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select Product_id, ");
			sql.append("category_val, ");
			sql.append("product_name, ");
			sql.append("quantity, ");
			sql.append("price, ");
			sql.append("no ");
			sql.append("  from t97_Product ");
			sql.append("  where " + category + " = ? ");
			sql.append(" order by no desc");			
			stmt=con.prepareStatement(sql.toString());
			stmt.setInt(1, ikeyword);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ProductDM dm = new ProductDM();
				dm.setProductId(rs.getString("Product_id"));
				dm.setCategoryVal(rs.getInt("category_val"));
				dm.setProductName(rs.getString("product_name"));
				dm.setQuantity(rs.getInt("quantity"));
				dm.setPrice(rs.getInt("price"));
				dm.setNo(rs.getInt("no"));
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
	
}
