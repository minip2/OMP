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

import com.omp.store.dao.ShBoardDAO;
import com.omp.store.domain.ShBoardDM;

@WebServlet("/store/main/category")
public class ShBoardListSel extends HttpServlet{
	@Override	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShBoardDAO dao = new ShBoardDAO();
		int no = Integer.parseInt(request.getParameter("no"));
		List<ShBoardDM> list = dao.ShBoardListSel(no);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/storemain.jsp");
		
		rd.forward(request, response);
	}
}