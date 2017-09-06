package com.omp.freeboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.freeboard.dao.FreeBoardDAO;
import com.omp.freeboard.domain.FreeBoardDM;

@WebServlet("/com/omp/freeboard/controller/freelist")
public class FreeList extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   request.setCharacterEncoding("utf-8");
		
	FreeBoardDAO dao= new FreeBoardDAO();
	 
	List<FreeBoardDM> list = dao.selectBoard();

	request.setAttribute("list", list);
	
	RequestDispatcher rd = request.getRequestDispatcher(

			"/jsp/freeboard/list.jsp");
	
	 rd.forward(request,response);
	}  
}
