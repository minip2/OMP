package com.omp.css.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.omp.css.dao.QuestionDAO;
import com.omp.css.domain.QuestionDM;

@WebServlet("/com/omp/css/controller/questionupdateselect")
public class QuestionUpdateSelect extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("문의 수정 서블릿 호출");
		
		int no = Integer.parseInt(request.getParameter("no"));
		QuestionDAO dao = new QuestionDAO();
		QuestionDM question = dao.selectQuestionByNo(no);
		request.setAttribute("question", question);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/questionupdate.jsp");
		rd.forward(request, response);
	}
	
}
