package com.ldg.coffee.Action.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.UserDao;
import com.ldg.coffee.Util.Script;

public class UserJoinProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if
		(
			request.getParameter("username") == null || 
			request.getParameter("password") == null || 
			request.getParameter("email") == null || 
			request.getParameter("address") == null ||
			request.getParameter("username").equals("") ||
			request.getParameter("password").equals("") ||
			request.getParameter("email").equals("") ||
			request.getParameter("address").equals("")
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;//응답이 두번이다.
		}

		
		
		
		
		//1. 파라메터를 받기
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				
				//2. Post 요청이기 때문에 DB에 insert
				// (1) DAO 연결
				// (2) 함수 실행 save(username,password,email)
				// (3) return 값이 1일 때 -> index.jsp 이동
				// (4) return 값이 0이 때 -> 자바스크립트로 history.back()

				
				
				//(1)
				UserDao userDao = UserDao.getInstance();
				
				//(2)
				int rs = userDao.save(username, password, email, address);
				
				//(3)
				if(rs == 1) {			
					RequestDispatcher dis = request.getRequestDispatcher("/");//welcome fill list 호출
					dis.forward(request,response);
					
				}else {
					Script.back(response, "회원가입에 실패하였습니다.");
				}
	}

}
