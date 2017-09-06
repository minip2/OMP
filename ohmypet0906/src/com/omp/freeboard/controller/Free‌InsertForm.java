package com.omp.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//등록폼을 호출하는 서블릿 
@WebServlet("/com/omp/freeboard/controller/freeinsertform")
public class Free‌InsertForm extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher rd= request.getRequestDispatcher( 
    		"/jsp/freeboard/write.jsp" 		
    		);
          rd.forward(request, response);	
	}
  
}
