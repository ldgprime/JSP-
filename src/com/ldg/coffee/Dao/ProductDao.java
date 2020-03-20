package com.ldg.coffee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ldg.coffee.DB.DBUtil;
import com.ldg.coffee.Model.Product;

public class ProductDao {
	
	
	private static ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}
	
	public List<Product> findByAll(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt= null;
		ResultSet rs = null;
		List<Product> products= new ArrayList<>();
		
		String sql = "SELECT * FROM product";
		
		try {
			psmt = conn.prepareStatement(sql);			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String productname = rs.getString("productname");
				int price = rs.getInt("price");
				String content1 = rs.getString("content1");
				String content2 = rs.getString("content2");
				String content3 = rs.getString("content3");
				
				Product product = Product.builder()
						.id(id)
						.productname(productname)
						.price(price)
						.content1(content1)
						.content2(content2)
						.content3(content3)
						.build();
				
				products.add(product);
			}
			
			return products;
			
		} catch (SQLException e) {
			
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
	
	public Product findById(int id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt= null;
		ResultSet rs = null;
		Product product = null;
		
		String sql = "SELECT * FROM product WHERE id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);			
			psmt.setInt(1, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				String productname = rs.getString("productname");
				int price = rs.getInt("price");
				
				product = Product.builder()
						.id(id)
						.productname(productname)
						.price(price)
						.build();
				
			}
			
			return product;

					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

}
