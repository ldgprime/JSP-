package com.ldg.coffee.ViewModel;

import com.ldg.coffee.Model.Board;
import com.ldg.coffee.Model.Comment;
import com.ldg.coffee.Model.User;

public class UserCommentVM {
	
	private User user;
	private Comment comment;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public UserCommentVM( User user, Comment comment) {
		super();
	   
		this.user = user;
		this.comment = comment;
	}	
}
