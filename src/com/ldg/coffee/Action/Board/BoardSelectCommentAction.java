package com.ldg.coffee.Action.Board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.CommentDao;

import com.ldg.coffee.ViewModel.UserCommentVM;

public class BoardSelectCommentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int boardid = Integer.parseInt(request.getParameter("boardid"));
		
		CommentDao cDao = CommentDao.getInstance();
		List<UserCommentVM> bucVM =  cDao.selectByBoardid(boardid);
		
		Gson gson = new Gson();
		String str = gson.toJson(bucVM);	

		PrintWriter out = response.getWriter();
		out.print(str);  // 클라이언트(브라우저)에 출력
		out.flush();
		
	}

}
