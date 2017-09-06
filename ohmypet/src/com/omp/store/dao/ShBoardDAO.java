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
			sql.append("select no, title, photo_path, reg_Date, price,sname ,dname  ");
			sql.append("  from t97_ShBoard ");
			sql.append(" order by no desc");
			
			stmt=con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ShBoardDM dm = new ShBoardDM();
				
				dm.setNo(rs.getInt("no"));
				dm.setPrice(rs.getInt("price"));
				dm.setTitle(rs.getString("title"));
				dm.setPhotoPath(rs.getString("photo_path"));
				dm.setSname(rs.getString("sname"));
				dm.setDname(rs.getString("dname"));
				dm.setRegDate(rs.getDate("reg_Date"));
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
	
	public List<ShBoardDM> ShBoardListSel(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		List<ShBoardDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.no no, s.title title, s.photo_path photo_path, s.reg_Date reg_Date, s.price price,sname , dname ");
			sql.append("  from t97_ShBoard s, t97_Product p");
			sql.append("  where p.category_val = ? and s.PRODUCT_ID = p.PRODUCT_ID ");
			sql.append(" order by no desc");
			
			stmt=con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ShBoardDM dm = new ShBoardDM();
				
				dm.setNo(rs.getInt("no"));
				dm.setPrice(rs.getInt("price"));
				dm.setTitle(rs.getString("title"));
				dm.setPhotoPath(rs.getString("photo_path"));
				dm.setSname(rs.getString("sname"));
				dm.setDname(rs.getString("dname"));
				dm.setRegDate(rs.getDate("reg_Date"));
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
			sql.append("select no, ");
			sql.append("photo_path, ");
			sql.append("sname, ");
			sql.append("dname, ");
			sql.append("price, ");
			sql.append("title, ");
			sql.append("product_Detail, ");
			sql.append("reg_Date ");
			sql.append(" from t97_shboard ");
			sql.append(" where no = ? ");
			stmt=con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				ProductDM pdm = new ProductDM();
				ShBoardDM dm = new ShBoardDM();
				dm.setNo(rs.getInt("no"));
				dm.setPhotoPath(rs.getString("photo_path"));
				dm.setSname(rs.getString("sname"));
				dm.setDname(rs.getString("dname"));
				dm.setPrice(rs.getInt("price"));
				dm.setTitle(rs.getString("title"));
				dm.setProductDetail(rs.getString("product_Detail"));
				dm.setRegDate(rs.getTimestamp("reg_Date"));
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
		sql.append("insert into t97_shboard(Product_Id, ");
		sql.append("no, ");
		sql.append("id, ");
		sql.append("title, ");
		sql.append("price, ");
		sql.append("photo_path, ");
		sql.append("sname, ");
		sql.append("dname, ");
		sql.append("product_detail) ");
		sql.append("values(?, ");	
		sql.append("s_shboard_no.nextval, ");				//작성자(스트링)
		sql.append("?, ");				//작성자(스트링)
		sql.append("?, ");			//제목(스트링)
		sql.append("?, ");			//제목(스트링)
		sql.append("?, ");			//제목(스트링)
		sql.append("?, ");			//제목(스트링)
		sql.append("?, ");			//제목(스트링)
		sql.append("?) ");				//제품상세(스트링)
		
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, dm.getProductId());
		stmt.setString(2, dm.getId());
		stmt.setString(3, dm.getTitle());
		stmt.setInt(4, dm.getPrice());
		stmt.setString(5, dm.getPhotoPath());
		stmt.setString(6, dm.getSname());
		stmt.setString(7, dm.getDname());
		stmt.setString(8, dm.getProductDetail());
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
			sql.append("       price = ?, ");
			sql.append("       product_detail = ? ");
			sql.append(" where no = ? ");
			
			stmt = con.prepareStatement(sql.toString());;
			stmt.setString(1, domain.getTitle());
			stmt.setInt(2, domain.getPrice());
			stmt.setString(3, domain.getProductDetail());
			stmt.setInt(4, domain.getNo());
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
