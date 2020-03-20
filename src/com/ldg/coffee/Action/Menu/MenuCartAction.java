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
import com.ldg.coffee.Dao.BillDao;
import com.ldg.coffee.Dao.ProductDao;
import com.ldg.coffee.Model.Product;
import com.ldg.coffee.Model.User;
import com.ldg.coffee.ViewModel.BillUserProductVM;

public class MenuCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    ProductDao pDao = new ProductDao();		
		 
		List<Product> searcheproducts = pDao.findByAll();
		
		List<Product> products = new ArrayList();		
		
		Cookie[] cookies = request.getCookies(); 
		
		if (cookies != null) { 
			for (int i = 0; i<cookies.length; i++){ 
				for(int j = 0; j<searcheproducts.size(); j++) {
					if(cookies[i].getName().equals(searcheproducts.get(j).getId()+"")) {
						Product product = pDao.findById(Integer.parseInt(cookies[i].getName()));
						products.add(product);
					}
				}
			}
		}	
		



		if(request.getSession().getAttribute("user") != null) {		
			BillDao bDao = BillDao.getinstance();
			User principal = (User) request.getSession().getAttribute("user");
			List<BillUserProductVM> bupVMs = bDao.findByUserid(principal.getId());		
			request.setAttribute("bupVMs", bupVMs);
			request.setAttribute("products", products);
			RequestDispatcher dis1 = request.getRequestDispatcher("/menu/cart.jsp");
			dis1.forward(request, response);
		}else {
			request.setAttribute("products", products);
			RequestDispatcher dis = request.getRequestDispatcher("/menu/cart.jsp");
			dis.forward(request, response);
		}		
	 
	}

}
