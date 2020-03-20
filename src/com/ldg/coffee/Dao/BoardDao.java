package com.ldg.coffee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ldg.coffee.DB.DBUtil;
import com.ldg.coffee.Model.Board;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.ViewModel.BoardUserVM;


public class BoardDao {
	
	public static  BoardDao instance = new BoardDao();
	public static BoardDao getinstance () {
		return instance;
	}
	
	public int writePost(String title, String content, int userid) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into board(title, content, userid, createtime) value(?, ?, ?, now())";
		
		PreparedStatement psmt = null;
		int rs = -1;
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, userid);
			
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
	

	
	public BoardUserVM findById(int id) {
		Connection conn = DBUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();// StringBuffer 동기화 적용 o StringBuilder 동기화 적용 x		
		sb.append(" SELECT b.id, b.userId, b.title, b.createTime, u.username, b.content ");
		sb.append(" FROM board b ");
		sb.append(" INNER JOIN user u ");
		sb.append(" ON b.userId = u.id ");
		sb.append(" WHERE b.id = ? ");//세미콜론은 절대 금지, 끝에 띄어쓰기			

		PreparedStatement pstmt= null;
		ResultSet rs = null;
		BoardUserVM buVM = null;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("b.id");
				String title = rs.getString("b.title");
				String content = rs.getString("b.content");
				int userid = rs.getInt("b.userid");
				Timestamp createtime = rs.getTimestamp("b.createtime");
				String username = rs.getString("u.username");
				
				//Board board = new Board(id,title,content,userId,createTime);
				
				//boardBuillder
				Board board = Board.builder()
						.id(id)
						.title(title)
						.content(content)
						.userid(userid)
						.createtime(createtime)
						.build();		
								
				//UserBuilder
				User user = User.builder()
							.id(id)
							.username(username)
						    .build();
				
				buVM = new BoardUserVM(board,user);
				
			}	
			
			return buVM;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
 	
	public List<BoardUserVM> findByAll(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null; 						
		List<BoardUserVM> buVMs = new ArrayList<BoardUserVM>();
		String sql = "SELECT b.id bid, b.title btitle, b.content bcontent, b.userid buserid, b.createtime bcreatetime, u.username uusername FROM board b inner join user u where b.userid = u.id order by b.id desc     ";
	     
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("bid");
				String title = rs.getString("btitle");
				String content = rs.getString("bcontent");
				int userid = rs.getInt("buserid");
				Timestamp createtime = rs.getTimestamp("bcreatetime");
				String username = rs.getString("uusername");
				
				Board board = Board.builder()
						.id(id)
						.title(title)
						.content(content)
						.userid(userid)
						.createtime(createtime)
						.build();
				
				User user = User.builder()
						.username(username)
						.build();				
				
				
				BoardUserVM buVM = new BoardUserVM(board, user);		
				buVMs.add(buVM);				
			}
			
			return buVMs;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public int update(String title, String content, int id) {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
				
			final String SQL = "UPDATE board SET title = ?, content = ? WHERE id = ?";
			                    
			
			pstmt = conn.prepareStatement(SQL);
					
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, id);
			
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
	
	public int deleteById(int id) {
		Connection conn = DBUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();// StringBuffer 동기화 적용 o StringBuilder 동기화 적용 x		
		sb.append("  delete from board where id = ?  ");			
		PreparedStatement pstmt= null;
		int rs = -1;
		
		try {
			
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	

}
