package com.ldg.coffee.Action.Board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.BoardDao;
import com.ldg.coffee.Model.Board;
import com.ldg.coffee.ViewModel.BoardUserVM;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BoardUserVM> buVMs = new ArrayList<>();
		
		BoardDao boardDao = BoardDao.getinstance();
		
		buVMs = boardDao.findByAll();		
		
		request.setAttribute("buVMs", buVMs);
		RequestDispatcher dis = request.getRequestDispatcher("/board/list.jsp");
		dis.forward(request, response);
		
	}

}
