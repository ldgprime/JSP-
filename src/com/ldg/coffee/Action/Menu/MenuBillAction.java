package com.ldg.coffee.Action.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.BillDao;
import com.ldg.coffee.Dao.ProductDao;
import com.ldg.coffee.Model.Product;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.Util.Script;

public class MenuBillAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if
		(
			request.getParameterValues("count") == null 
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;//응답이 두번이다.
		}		
		
		String[] count = request.getParameterValues("count");
		User principal =(User) request.getSession().getAttribute("user"); 
		Cookie[] cookies = request.getCookies();
		int rs= -1;
		int num = 0;
		
		if(principal == null) {
			Script.back(response, "로그인 후 결제 가능합니다.");
			return;
		}
		
		ProductDao pDao = ProductDao.getInstance();
		List<Product> searcheproducts = pDao.findByAll();
		
		
		if (cookies != null) { 
			
			for(int i = 0; i<cookies.length; i++){
				
				for(int j = 0; j<searcheproducts.size(); j++) {	
						
					if(cookies[i].getName().equals(searcheproducts.get(j).getId()+"")) {
						BillDao bDao = BillDao.getinstance();							
						rs = bDao.update(searcheproducts.get(j).getId(), Integer.parseInt(count[num]), searcheproducts.get(j).getPrice(), principal.getId());
						num +=1;
					}
				}
			}

		}
		
		
		if(cookies != null){			
			for(int i=0; i < cookies.length; i++){	
				for(int j = 0; j<searcheproducts.size(); j++) {
					if(cookies[i].getName().equals(searcheproducts.get(j).getId()+"")) {
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
					}
				}				
			}	
		}				
	
	
		
		if(rs == 1) {
	    Script.href(response, "결제 성공하였습니다.", "/coffee/menu?cmd=cart");
		}else {
			Script.back(response, "결제 실패하였습니다.");
		}

	}

}
