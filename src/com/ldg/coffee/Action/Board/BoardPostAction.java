package com.ldg.coffee.Action.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Util.Script;

public class BoardPostAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			Script.back(response, "잘못된 접근입니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/board/post.jsp");
		dis.forward(request, response);
	}

}
