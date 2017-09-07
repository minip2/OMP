package com.omp.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.freeboard.dao.FreeBoardDAO;
import com.omp.freeboard.domain.FreeBoardDM;

@WebServlet("/com/omp/freeboard/controller/freeupdate")
public class FreeUpdate extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("no"));
		FreeBoardDAO dao = new FreeBoardDAO();
		
		FreeBoardDM board = dao.selectBoardByNo(no);
		
		request.setAttribute("board", board);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/board/update.jsp"
				);
				
			rd.forward(request, response);	
	
	}
  
	
	 
}
