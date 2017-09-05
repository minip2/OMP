package com.omp.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.dao.ProductDAO;
import com.omp.store.domain.ProductDM;

@WebServlet("/product/mod")
public class ProductMod extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.sendRedirect("/ohmypet/com/omp/store/storeproductadd.jsp");
		ProductDAO dao = new ProductDAO();
		ProductDM dm = new ProductDM();
		
		List<ProductDM> list = dao.ProductList();
		
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/productmod.jsp");
		rd.forward(request, response);
	}
	
	
	
}
