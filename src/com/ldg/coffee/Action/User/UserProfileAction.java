package com.ldg.coffee.Action.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.UserDao;
import com.ldg.coffee.Model.User;

public class UserProfileAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao userDao = new UserDao();
		Cookie[] cookies = request.getCookies();
		
	
		
		
		String username = cookies[0].getValue();
		
		
		User user = userDao.findByUsername(username);			
	
		
		request.setAttribute("user", user);
		RequestDispatcher dis = request.getRequestDispatcher("/user/profile.jsp");
		dis.forward(request, response);

	}

}
