package com.ldg.coffee.Action.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.ProductDao;
import com.ldg.coffee.Model.Product;
import com.ldg.coffee.Util.Script;

public class MenuCartDeleteProcAction implements Action {

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
		
		String id = request.getParameter("id");
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null){
			
			for(int i=0; i < cookies.length; i++){				
				if(cookies[i].getName().equals(id)) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}				
			}	
		}
		
//		
//	    ProductDao pDao = ProductDao.getInstance();
//		 
//		List<Product> searcheproducts = pDao.findByAll();
//		List<Product> products = new ArrayList();
//		
//		if (cookies != null) { 
//			for (int i = 0; i<cookies.length; i++){ 			
//				for(int j = 0; j<searcheproducts.size(); j++) {
//					if(cookies[i].getName().equals(searcheproducts.get(j).getId()+"")) {
//						Product product = pDao.findById(Integer.parseInt(cookies[i].getName()));
//						products.add(product);
//					}
//				}
//			}
//		}
		
		Script.href(response, "상품이 제외되었습니다.", "/coffee/menu?cmd=cart");
	
	}

}
