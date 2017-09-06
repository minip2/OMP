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

@WebServlet("/com/omp/freeboard/controller/selectbyno")
public class FreeSelectByNo extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 글번호를 꺼내
		System.out.println("1");
	    int no  = Integer.parseInt(request.getParameter("no"));
	
		FreeBoardDAO dao = new FreeBoardDAO();
	    FreeBoardDM  board  = dao.selectBoardByNo(no);
		System.out.println("2");
	     // 공유해 
		request.setAttribute("board",board);
		System.out.println("3");
	   RequestDispatcher rd = request.getRequestDispatcher("/jsp/freeboard/select.jsp");
		
		rd.forward(request,response);
		
		System.out.println("4");
		
	}
  
}
