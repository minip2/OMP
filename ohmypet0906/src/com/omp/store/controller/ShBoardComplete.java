package com.omp.store.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.dao.ShBoardDAO;
import com.omp.store.domain.ShBoardDM;

@WebServlet("/shboard/complete")
public class ShBoardComplete extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.sendRedirect("/ohmypet/com/omp/store/storeproductadd.jsp");
		ShBoardDAO dao = new ShBoardDAO();
		ShBoardDM sdm = new ShBoardDM();
		
		
		sdm.setTitle(request.getParameter("title"));
		sdm.setProductDetail(request.getParameter("productDetail"));
		sdm.setNo(Integer.parseInt(request.getParameter("no")));
		sdm.setPrice(Integer.parseInt(request.getParameter("price")));
		
		dao.ShBoardUpdate(sdm);
//		
		request.setAttribute("sdm",sdm);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/shboard/detail?no="+sdm.getNo());
		rd.forward(request, response);
	}
	
	
	
}
