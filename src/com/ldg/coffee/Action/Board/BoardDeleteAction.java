package com.ldg.coffee.Action.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.BoardDao;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.Util.Script;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if
		(
			request.getParameter("id") == null || 
			request.getParameter("userid") == null || 
			request.getParameter("id").equals("") ||
			request.getParameter("userid").equals("")
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;//응답이 두번이다.
		}

				
		int id = Integer.parseInt(request.getParameter("id"));
		int userid = Integer.parseInt(request.getParameter("userid"));		
		User principal = (User) request.getSession().getAttribute("user");
		
		if(userid != principal.getId()) {
			Script.back(response, "삭제할 권한이 없습니다.");
			return;
		}
		
        BoardDao boardDao = BoardDao.getinstance();
		
		int result = boardDao.deleteById(id);

		
		
		if(result == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("/");			
			dis.forward(request, response);
		}else {
			Script.back(response, "글 삭제 실패하였습니다.");
		}

	}

}
