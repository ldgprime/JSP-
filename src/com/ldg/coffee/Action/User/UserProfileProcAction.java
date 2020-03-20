package com.ldg.coffee.Action.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.UserDao;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.Util.Script;

public class UserProfileProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("username") == null ||
			request.getParameter("email") == null ||
			request.getParameter("address") == null ||
			request.getParameter("username").equals("") ||
			request.getParameter("email").equals("") ||
			request.getParameter("address").equals("")
	    ) {
			Script.back(response, "잘못된 접근입니다.");
			return;
	    }
		
		User principal = (User) request.getSession().getAttribute("user");
		
		
		int id = principal.getId();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
				

		UserDao userDao = UserDao.getInstance();
		
		
		int rs = userDao.updateUser(id, username, email, address);
	
		
		if(rs == 1 ) {
			//세션업데이트			
			User user = userDao.findById(id);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);	
			
			Script.href(response, "회원정보 수정 완료", "/coffee/user?cmd=profile");
		}else {
			Script.back(response,"수정 실패입니다!");
			return;
		}
	}

}
