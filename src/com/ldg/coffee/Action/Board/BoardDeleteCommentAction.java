package com.ldg.coffee.Action.Board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.CommentDao;

public class BoardDeleteCommentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));		
		
		CommentDao cDao = CommentDao.getInstance();
		int result = cDao.deleteById(id);
		
		if(result ==1 ) {
			PrintWriter out = response.getWriter();
			out.print("ok");
			out.flush();
			
		} 
		
		
	}

}
