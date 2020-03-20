package com.ldg.coffee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ldg.coffee.DB.DBUtil;
import com.ldg.coffee.Model.User;



public class UserDao {
	
	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}
	
	
	public int save(String username, String password, String email, String address) {

		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO user(username, password, email, address, createTime)	VALUES(?, ?, ?, ?, now())";
		PreparedStatement pstmt = null;
		int rs = -1;

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, address);

			rs = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}

		return rs;
	}
	public User login(String username, String password) {

		// 1. Stream 연결

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. 쿼리(메시지) 전송 클래스 (규약에 맞게 = 프로토콜)
			final String SQL = "SELECT * FROM user WHERE username = ? and password = ?";
			pstmt = conn.prepareStatement(SQL);

			// 3. SQL문 완성하기
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// 4. SQL전송

			rs = pstmt.executeQuery();

			User user = null;
			if (rs.next()) {

				int id = rs.getInt("id");				
				String email = rs.getString("email");
				String address = rs.getString("address");
				Timestamp createTime = rs.getTimestamp("createTime");
				
				//userBuilder
				user = User.builder()
						.id(id)
						.username(username)	
						.password(password)
						.email(email)
						.address(address)
						.createtime(createTime)
					    .build();

			}

			return user;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	
	public int updateUser(int id, String username, String email, String address) {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
				
			final String SQL = "UPDATE user SET username = ?, email = ?, address= ?  WHERE id = ?";
			pstmt = conn.prepareStatement(SQL);
					
			
			pstmt.setString(1, username);	
			pstmt.setString(2, email);
			pstmt.setString(3, address);
			pstmt.setInt(4, id);
			
			
			int result = pstmt.executeUpdate();
			
			return result;
			               
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		
		return -1;
	}
	
	public User findById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM user WHERE id = ?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String username = rs.getString("username");				
				String email = rs.getString("email");
				String address = rs.getString("address");
				Timestamp createTime = rs.getTimestamp("createTime");
				
				//userBuilder
				user = User.builder()
						.id(id)
						.username(username)						
						.email(email)
						.createtime(createTime)
						.address(address)
					    .build();
				
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}
	public int findByUsernameInt(String username) {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT count(*) as count FROM user WHERE username = ?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int result = -1;	
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			    result = rs.getInt(1);
			}
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return result;
	}
	
	public User findByUsername(String username) {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM user WHERE username = ?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				Timestamp createtime = rs.getTimestamp("createtime");
				
				//userBuilder
				user = User.builder()
						.id(id)
						.username(username)
						.password(password)
						.email(email)
						.createtime(createtime)
						.address(address)
					    .build();
				
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}
	
	public List<User> findByAll() {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM user where not username = 'admin' order by id desc";
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		
		
		try {
			psmt = conn.prepareStatement(sql);			
		
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				Timestamp createtime = rs.getTimestamp("createtime");
				
				//userBuilder
				User user = User.builder()
						.id(id)
						.username(username)
						.password(password)
						.email(email)
						.address(address)
						.createtime(createtime)
						.build();
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
				
		return null;
	}
	
	public int deleteUser(int id) {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
				
			final String SQL = "DELETE from user WHERE id = ?  ";
			pstmt = conn.prepareStatement(SQL);
					
			
			pstmt.setInt(1, id);	
			
			int result = pstmt.executeUpdate();
			
			return result;
			               
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		
		return -1;
	}
	
	
	
	
	
}
