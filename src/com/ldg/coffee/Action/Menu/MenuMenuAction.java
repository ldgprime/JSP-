package com.ldg.coffee.Action.Menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldg.coffee.Action.Action;
import com.ldg.coffee.Dao.ProductDao;
import com.ldg.coffee.Model.Product;

public class MenuMenuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductDao pDao = ProductDao.getInstance();
 		List<Product> products = pDao.findByAll();		
		
		
		request.setAttribute("products", products);
		RequestDispatcher dis = request.getRequestDispatcher("/menu/menu.jsp");
		dis.forward(request, response);

	}

}
