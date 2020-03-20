package com.ldg.coffee.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Action.Admin.AdminFactory;
import com.ldg.coffee.Action.User.UserFactory;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		Action action = AdminFactory.route(cmd);
		action.execute(request, response);	
	}
	
}
