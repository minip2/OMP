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

@WebServlet("/shboard/detail")
public class ShBoardDetail extends HttpServlet{
	@Override	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShBoardDAO dao = new ShBoardDAO();
		int no = Integer.parseInt(request.getParameter("no"));
		ShBoardDM sdm = dao.ShBoardSelect(no);
		request.setAttribute("sdm", sdm);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/shboard.jsp");
		rd.forward(request, response);
	}
	
}