package com.ldg.coffee.Action.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.CommentDao;
import com.ldg.coffee.Dto.CommentDto;

public class BoardPostCommentAction implements Action {
	
	private final static String TAG = "BoardPostCommentAction: ";										

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    BufferedReader br = request.getReader(); 
	    String responseData= br.readLine();	    
	    
	    Gson gson = new Gson();
	    //toJson()==JSON.stringify()    fromJson()==JSON.parse()
	    
	    CommentDto cDto =gson.fromJson(responseData, CommentDto.class);
	    
	    CommentDao cDao = CommentDao.getInstance();
	    int result = cDao.post(cDto.getBoardid(), cDto.getUserid(), cDto.getContent());
	    


	    if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("ok");
			out.flush();
	    }else {
			PrintWriter out = response.getWriter();
			out.print("fail");
			out.flush();
	    }
	    
	    

	    
	    
	    
	    
	    
	    


	}

}
