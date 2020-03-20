package com.ldg.coffee.Action.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.UserDao;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.Util.Script;

public class AdminUserProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if
		(
			request.getParameter("id") == null || 				
			request.getParameter("id").equals("")				
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;//응답이 두번이다.
		}	
		User principal = (User) request.getSession().getAttribute("user");
		if(!principal.getUsername().equals("admin")) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao uDao = UserDao.getInstance();
		int rs = uDao.deleteUser(id);
		
		if(rs == 1) {
			Script.href(response, "회원삭제 성공하였습니다.", "/coffee/admin?cmd=user");
		}else {
			Script.back(response, "회원삭제 실패하였습니다.");
		}
		
		

	}

}
