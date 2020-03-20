package com.ldg.coffee.ViewModel;

import com.ldg.coffee.Model.Board;
import com.ldg.coffee.Model.User;

public class BoardUserVM {
	private Board board;
	private User user;
	
	public BoardUserVM(Board board, User user) {
		this.board = board;
		this.user = user;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}



