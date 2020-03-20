package com.ldg.coffee.Action.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.BoardDao;
import com.ldg.coffee.Util.Script;
import com.ldg.coffee.ViewModel.BoardUserVM;

public class BoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if
		(
			request.getParameter("id") == null || 				
			request.getParameter("id").equals("")				
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;//응답이 두번이다.
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BoardDao bDao = BoardDao.getinstance();
		BoardUserVM buVM = bDao.findById(id);
		
		
		
		
		request.setAttribute("buVM", buVM);
		RequestDispatcher dis = request.getRequestDispatcher("/board/detail.jsp");
		dis.forward(request, response);
	}

}
