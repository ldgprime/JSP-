package com.ldg.coffee.Action.User;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.UserDao;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.Util.Script;

public class UserLoginProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1번
				if
				(
					request.getParameter("username") == null || 
					request.getParameter("password") == null 
				){
					response.sendRedirect("/");
					return;//if가 끝나고 자바소스가 컴파일 되지 않게
				}		
				
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//null일 경우 off의 값을 준다. ofNullable(값) null인지 아닌지 확신할 수 없는 객체를 담을 때 사용
				String rememberMe = Optional.ofNullable(request.getParameter("rememberMe")).orElse("off");			

				UserDao userDao = UserDao.getInstance();
				
		
				
				
				//(2)
				User user = userDao.login(username, password);
				
				
				//쿠키
				if(rememberMe.equals("on")) {
					Cookie cookie = new Cookie("usernameCookie",username);///???????
					cookie.setMaxAge(60*60*24*7);//일주일 보관
					response.addCookie(cookie);			
				}else {
					Cookie cookie = new Cookie("usernameCookie", "");
					cookie.setMaxAge(0);//0초 보관 
					response.addCookie(cookie);	
				}
								
				//(3)
				if(user != null) {
					//세션
					HttpSession session = request.getSession();//session 인증!!!!
					session.setAttribute("user", user);						
					
					RequestDispatcher dis = request.getRequestDispatcher("/");//welcome fill list 호출
					dis.forward(request,response);
					
				}else {
					Script.back(response, "로그인이 실패하였습니다.");
				}
	}

}
