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

@WebServlet("/product/search")
public class ProductSearch extends HttpServlet{
	@Override	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		ProductDM dm = new ProductDM();
		String sKeyword = request.getParameter("keyword");
		String option = request.getParameter("option");
		String category = "product_name";
		int iKeyword = 0;
		
		List<ProductDM> list;
		
		if(option.equals("분류")){
			category = "category_val";
			iKeyword = Integer.parseInt(request.getParameter("keyword"));
			list = dao.KeywordSearch(category,iKeyword);
		}
		 list = dao.KeywordSearch(category,sKeyword);
		
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/productresult.jsp");
		
		rd.forward(request, response);
	}
}