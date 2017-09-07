package com.omp.store.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.dao.ProductDAO;
import com.omp.store.dao.ShBoardDAO;
import com.omp.store.domain.ProductDM;
import com.omp.store.domain.ShBoardDM;

@WebServlet("/shboard/load")
public class ShBoardLoad extends HttpServlet{
	@Override	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		String id = request.getParameter("productId");
		ProductDM pdm = dao.ProductSelect(id)	;
		request.setAttribute("pdm", pdm);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/shboardinsert.jsp");
		
		
		rd.forward(request, response);
	}
	
}