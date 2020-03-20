package com.ldg.coffee.Action.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.UserDao;
import com.ldg.coffee.Dto.UserJoinDto;

public class UserUsernameCheckAction implements Action {
	private final static String TAG = "UserUsernameCheckAction: ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    BufferedReader br = request.getReader(); 
	    String responseData= br.readLine();
	    //System.out.println(TAG+responseData);
	    
	    Gson gson = new Gson();
	    //toJson()==JSON.stringify()    fromJson()==JSON.parse()
	    
	    UserJoinDto userJoinDto =gson.fromJson(responseData, UserJoinDto.class);
	    

	    
	    UserDao userDao = UserDao.getInstance();
	    int result = userDao.findByUsernameInt(userJoinDto.getUsername());
	    
	    
	    if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("fail");
			out.flush();
	    }else {
			PrintWriter out = response.getWriter();
			out.print("ok");
			out.flush();
	    }
	}

}
