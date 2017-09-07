package com.omp.css.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.css.dao.QuestionDAO;

@WebServlet("/com/omp/css/controller/questiondelete")
public class QuestionDelete extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("문의 삭제 서블릿 호출");
		int no = Integer.parseInt(request.getParameter("no"));
		QuestionDAO dao = new QuestionDAO();
		dao.deleteQuestion(no);
		response.sendRedirect("/ohmypet/com/omp/css/controller/cssselect");
		
	}
	
}