package com.omp.store.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.dao.ShBoardDAO;

@WebServlet("/shboard/del")
public class ShboardDel extends HttpServlet{
	@Override	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShBoardDAO dao = new ShBoardDAO();
		
		int no = Integer.parseInt(request.getParameter("no"));
		dao.ShBoardDelete(no);
		
		RequestDispatcher rd = request.getRequestDispatcher("/store/main");
		rd.forward(request, response);
	}
}