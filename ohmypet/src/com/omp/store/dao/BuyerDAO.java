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
			sql.append("select b.buy_no, ");
			sql.append("p.product_id , ");
			sql.append("b.buys_amount , ");
			sql.append("b.buy_date , ");
			sql.append("b.id  ");
			sql.append("  from t97_buyer b,t97_Product p");
			sql.append(" where b.product_id =p.product_id ");
			stmt=con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BuyerDM dm = new BuyerDM();
				dm.setBuyNo(rs.getString("b.buy_no"));
				dm.setProductId(rs.getString("p.product_id"));
				dm.setBuysAmount(rs.getInt("b.buy_amount"));
				dm.setBuyDate(rs.getDate("b.buy_date"));
				dm.setId(rs.getString("b.id"));
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
			sql.append("select b.buy_no, ");
			sql.append("p.product_id, ");
			sql.append("b.buys_amount, ");
			sql.append("b.buy_date, ");
			sql.append("b.id, ");
			sql.append("p.price * b.buys_amount as total_price , ");
			sql.append("b.name, ");
			sql.append("b.phon_number, ");
			sql.append("b.email, ");
			sql.append("b.address, ");
			sql.append("b.buy_date, ");
			sql.append(" from t97_buyer b,t97_Product p ");
			sql.append(" where buy_no = ? and b.product_id = p.product_id");
			stmt=con.prepareStatement(sql.toString());
			stmt.setString(1, buyNo);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				BuyerDM dm = new BuyerDM();
				dm.setBuyNo(rs.getString("b.buy_no"));
				dm.setProductId(rs.getString("p.product_id"));
				dm.setBuysAmount(rs.getInt("b.buys_amount"));
				dm.setBuyDate(rs.getDate("b.buy_date"));
				dm.setId(rs.getString("b.id"));
				dm.setTotalPrice(rs.getInt("total_price"));
				dm.setName(rs.getString("b.name"));
				dm.setPhonNumber(rs.getString("b.phon_number"));
				dm.setEmail(rs.getString("b.email"));
				dm.setAdress(rs.getString("b.address"));
				dm.setBuyDate(rs.getTimestamp("b.buy_date"));
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
		sql.append("insert into t97_buyer(buy_no, ");
		sql.append("product_id, ");
		sql.append("buys_amount, ");
		sql.append("id, ");
		sql.append("name, ");
		sql.append("phon_number) ");
		sql.append("email) ");
		sql.append("address) ");
		sql.append("values(?, ");	//주문번호(스트링)
		sql.append("?, ");				//상품코드(스트링)
		sql.append("?, ");			//구매갯수(인트)
		sql.append("?, ");		//아이디(스트링)
		sql.append("?, ");				//구매자이름(인트)
		sql.append("?) ");				//폰번호(인트)
		sql.append("?) ");				//이메일(인트)
		sql.append("?) ");				//배송지(인트)
		
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, dm.getBuyNo());
		stmt.setString(2, dm.getProductId());
		stmt.setInt(3, dm.getBuysAmount());
		stmt.setString(4, dm.getId());
		stmt.setString(5, dm.getName());
		stmt.setString(6, dm.getPhonNumber());
		stmt.setString(7, dm.getEmail());
		stmt.setString(8, dm.getAddress());
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
			sql.append("update t97_buyer ");
			sql.append("   set buys_amount = ?, ");
			sql.append("       phon_number = ?, ");
			sql.append("       email = ?, ");
			sql.append("       address = ?, ");
			sql.append(" where buy_no = ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, domain.getBuysAmount());
			stmt.setString(2, domain.getPhonNumber());
			stmt.setString(3, domain.getEmail());
			stmt.setString(4, domain.getAddress());
			stmt.setString(5, domain.getBuyNo());
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
				sql.append("  from t97_buyer " );
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
