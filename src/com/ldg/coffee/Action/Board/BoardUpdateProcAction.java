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

public class BoardUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("title") == null || request.getParameter("content") == null || 
			request.getParameter("id") == null || request.getParameter("userId") == null ||
			request.getParameter("title").equals("") || request.getParameter("content").equals("")	||
			request.getParameter("id").equals("") || request.getParameter("userId").equals("")
		   ) {
			Script.back(response, "잘못된 접근입니다.");
			return;// 응답이 두번이다.
		}

		int id = Integer.parseInt(request.getParameter("id"));
		int userid = Integer.parseInt(request.getParameter("userid"));

		User principal = (User) request.getSession().getAttribute("user");

		if (userid != principal.getId()) {
			Script.back(response, "권한이 없습니다!");
			return;
		}

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDao boardDao = BoardDao.getinstance();
		int rs = boardDao.update(title, content, id);

		if (rs == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("/board?cmd=detail&id=" + id);
			dis.forward(request, response);
		} else {
			Script.back(response, "글 수정에 실패하였습니다.");
		}

	}

}
