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

@WebServlet("/product/movemod")
public class ProductMoveMod extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.sendRedirect("/ohmypet/com/omp/store/storeproductadd.jsp");
		ProductDAO dao = new ProductDAO();
		ProductDM dm = new ProductDM();
		
		int val = 1000;
		String value = request.getParameter("categoryVal");
		switch(value) {
		case "간식" :
			val = 1000;
			break;
		case "장난감" :
			val = 2000;
			break;
		case "사료" :
			val = 3000;
			break;
		
		}
		
		dm.setCategoryVal(val);
		dm.setProductId(request.getParameter("productId"));
		dm.setProductName(request.getParameter("productName"));
		dm.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		dm.setPrice(Integer.parseInt(request.getParameter("price")));
		
		dao.ProductUpdate(dm);
//		
		request.setAttribute("categoryVal",dm.getCategoryVal());
		request.setAttribute("price",dm.getPrice());
		request.setAttribute("productName",dm.getProductName());
		request.setAttribute("quantity",dm.getQuantity());
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/product/list");
		rd.forward(request, response);
	}
	
	
	
}
