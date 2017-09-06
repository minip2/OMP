package com.omp.css.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.css.dao.QuestionDAO;
import com.omp.css.domain.QuestionDM;

@WebServlet("/com.omp.css.controller/questionselect")
public class QuestionSelect extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionDAO dao = new QuestionDAO();
		List<QuestionDM> question = dao.selectQuestion();
		
		request.setAttribute("question", question);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/notice.jsp");
		rd.forward(request, response);
		
	}
	
	
}
