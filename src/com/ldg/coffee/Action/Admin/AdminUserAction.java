package com.ldg.coffee.Action.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.UserDao;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.Util.Script;

public class AdminUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User principal = (User) request.getSession().getAttribute("user");
		
		
		if(!principal.getUsername().equals("admin")) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
		
		
		
		UserDao udao = UserDao.getInstance();
		List<User> users = udao.findByAll();
		
		
		request.setAttribute("users", users);
		RequestDispatcher dis = request.getRequestDispatcher("/admin/userAdmin.jsp");
		dis.forward(request, response);
		
		
		
		
		
		
		
	}	

}
