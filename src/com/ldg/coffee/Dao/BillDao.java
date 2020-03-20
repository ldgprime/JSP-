package com.ldg.coffee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ldg.coffee.DB.DBUtil;
import com.ldg.coffee.Model.Bill;
import com.ldg.coffee.Model.Product;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.ViewModel.BillUserProductVM;

public class BillDao {
	
	public static BillDao instance = new BillDao();
	public static BillDao getinstance() {
		return instance;
	}
	
	
	public int update(int productid, int count, int price, int userid) {
		int rs = -1;
		Connection conn = DBUtil.getConnection();
		String sql = "insert into bill (productid, count, price, userid, createtime) value(?,?,?,?,now())"; 
		PreparedStatement psmt = null;
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, productid);
			psmt.setInt(2, count);
			psmt.setInt(3, price);
			psmt.setInt(4, userid);	
			
			rs = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}	
		
		return rs;
	}
	
	
	public List<BillUserProductVM> findByUserid(int userid){
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<BillUserProductVM> bupVMs = new ArrayList<BillUserProductVM>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("    select b.id as bid, b.count as bcount, b.price as bpirce, b.createtime as bcreatetime, u.username as uusername, p.productname as pproductname   ");
		sb.append("    from bill b   ");
		sb.append("    Inner join user u   ");
		sb.append("    on b.userid = u.id   ");
		sb.append("    Inner join product p   ");
		sb.append("    on b.productid = p.id   ");
		sb.append("    where u.id = ?   ");
		sb.append("    order by b.id desc   ");	
		
		try {
			psmt = conn.prepareStatement(sb.toString());
			
			psmt.setInt(1, userid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("bid");
				int count = rs.getInt("bcount");
				int price = rs.getInt("bpirce");
				Timestamp createtime = rs.getTimestamp("bcreatetime");
				String username = rs.getString("uusername");
				String productname = rs.getString("pproductname");
				
				Bill bill = Bill.builder()
						.id(id)
						.count(count)
						.price(price)
						.createtime(createtime)
						.build();
				
				User user = User.builder()
						.username(username)
						.build();
				
				Product product = Product.builder()
						.productname(productname)
						.build();
				
				BillUserProductVM bupVM = new BillUserProductVM(bill, user, product);
				bupVMs.add(bupVM);
				
			}
	
			return bupVMs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		return null;
	}
	
	public List<BillUserProductVM> findByAll(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<BillUserProductVM> bupVMs = new ArrayList<BillUserProductVM>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("    select b.id as bid, b.count as bcount, b.price as bpirce, b.createtime as bcreatetime, u.username as uusername, p.productname as pproductname   ");
		sb.append("    from bill b   ");
		sb.append("    Inner join user u   ");
		sb.append("    on b.userid = u.id   ");
		sb.append("    Inner join product p   ");
		sb.append("    on b.productid = p.id   ");	
		sb.append("    order by b.id desc   ");	
		
		try {
			
			psmt = conn.prepareStatement(sb.toString());			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("bid");
				int count = rs.getInt("bcount");
				int price = rs.getInt("bpirce");
				Timestamp createtime = rs.getTimestamp("bcreatetime");
				String username = rs.getString("uusername");
				String productname = rs.getString("pproductname");
				
				Bill bill = Bill.builder()
						.id(id)
						.count(count)
						.price(price)
						.createtime(createtime)
						.build();
				
				User user = User.builder()
						.username(username)
						.build();
				
				Product product = Product.builder()
						.productname(productname)
						.build();
				
				BillUserProductVM bupVM = new BillUserProductVM(bill, user, product);
				bupVMs.add(bupVM);
				
			}
	
			return bupVMs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		return null;
	}
	
	
	public int deleteBill(int id) {
		int rs = -1;
		Connection conn = DBUtil.getConnection();
		String sql = "delete from bill where id = ? "; 
		PreparedStatement psmt = null;
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
	
			rs = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}	
		
		return rs;
	}
	


}
