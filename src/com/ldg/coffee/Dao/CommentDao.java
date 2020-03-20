package com.ldg.coffee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ldg.coffee.DB.DBUtil;
import com.ldg.coffee.Model.Comment;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.ViewModel.UserCommentVM;



public class CommentDao {
	
	public static CommentDao Instance = new CommentDao();
	public static CommentDao getInstance() {
		return Instance;
	}
	
	public int post(int boardid, int userid, String content) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into comment (boardid, userid, content, createtime) value(?, ?, ?, now())";
		PreparedStatement psmt = null;
		int rs = -1;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, boardid);
			psmt.setInt(2, userid);
			psmt.setString(3, content);
			
			rs = psmt.executeUpdate();
			
			if(rs ==1 )
				System.out.println("댓글입력 성공");
			
			return rs;
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
	
	public List<UserCommentVM> selectByBoardid(int boardid){
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		StringBuffer sb = new StringBuffer();
		ResultSet rs = null;
		List<UserCommentVM> ucVMs = new ArrayList<UserCommentVM>();
		sb.append("  select c.id as cid, c.userid as cuserid, c.content as ccontent, c.createtime as ccreatetime, u.username as uusername      ");
		sb.append("  from comment c      ");
		sb.append("  Inner join user u     ");
		sb.append("  on c.userid = u.id     ");
		sb.append("  where c.boardid = ?    ");		
		sb.append("  order by c.id desc;     ");
		
		try {
			psmt = conn.prepareStatement(sb.toString());
			
			psmt.setInt(1, boardid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("cid");				
				int userid = rs.getInt("cuserid");
				String content = rs.getString("ccontent");
				Timestamp createtime = rs.getTimestamp("ccreatetime");
				String username = rs.getString("uusername");
				
				Comment comment = new Comment();
				comment = Comment.builder()
						.id(id)
						.boardid(boardid)
						.userid(userid)
						.content(content)
						.createtime(createtime)
						.build();
				
				User user = new User();
				user = User.builder()
						.username(username)
						.build();
				
				UserCommentVM ucVM = new UserCommentVM(user, comment);

				ucVMs.add(ucVM);
			}
			
			return ucVMs;
			
			
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
		
		return null;
	}
	
	
	public int deleteById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from comment where id = ?";
		PreparedStatement psmt = null;
		int rs = -1;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, id);
			
			
			rs = psmt.executeUpdate();
			
			if(rs == 1)
				System.out.println("댓글입력 성공");
			
			return rs;
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
