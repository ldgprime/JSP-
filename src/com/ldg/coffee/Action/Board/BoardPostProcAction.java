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

public class BoardPostProcAction implements Action {
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if
		(
			request.getParameter("title") == null || 
			request.getParameter("content") == null || 
			request.getParameter("title").equals("") || 
			request.getParameter("content").equals("")			
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;//응답이 두번이다.
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		User user = (User) request.getSession().getAttribute("user");
		
		
		BoardDao bDao = BoardDao.getinstance();
		
		int rs = bDao.writePost(title, content, user.getId());
		
		if(rs == 1) {
		RequestDispatcher dis = request.getRequestDispatcher("/board?cmd=list");
		dis.forward(request, response);
		}else {
			Script.back(response, "글 작성 실패하였습니다.");
		}
		
		

	}

}
