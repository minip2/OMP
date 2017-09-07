package com.omp.css.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omp.css.dao.QuestionDAO;
import com.omp.common.domain.LoginDM;
import com.omp.css.domain.QuestionDM;

@WebServlet("/com/omp/css/controller/questioninsert")
public class QuestionInsert extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("문의등록 서블릿 호출");
		LoginDM login = new LoginDM();
		
		HttpSession session = request.getSession();
		login = (LoginDM)session.getAttribute("user");
		String id = login.getId();
		String title = request.getParameter("title");
		String question_content = request.getParameter("question_content");
		String category_val = request.getParameter("category_val");

		
		
		QuestionDAO dao = new QuestionDAO();
		QuestionDM question = new QuestionDM();
		question.setId(id);
		question.setTitle(title);
		question.setQuestion_content(question_content);
		question.setCategory_val(category_val);
		dao.insertQuestion(question);
		
		response.sendRedirect("/ohmypet/com/omp/css/controller/cssselect");
		
		
	}
	
	

}
