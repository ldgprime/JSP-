package com.ldg.coffee.Action.Menu;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.ProductDao;
import com.ldg.coffee.Model.Product;
import com.ldg.coffee.Util.Script;

public class MenuMenuProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductDao pDao = ProductDao.getInstance();	
		
		Product product = pDao.findById(id);
		
//      URLEncoder.encode(value, "UTF-8")
//		String productname = URLEncoder.encode(product.getProductname(), "UTF-8");
//		String price = URLEncoder.encode(product.getPrice()+"", "UTF-8");			
		
		String price = product.getPrice()+"";
		
		Cookie cookie = new Cookie(id+"", price);
		cookie.setMaxAge(60*60*24*7);//일주일 보관
		response.addCookie(cookie);

		Script.back(response, "장바구니에 추가되었습니다!");
		
		
		
		


		
	}

}
