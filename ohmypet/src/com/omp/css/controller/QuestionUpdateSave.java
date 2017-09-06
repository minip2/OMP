package com.omp.css.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.css.dao.QuestionDAO;
import com.omp.css.domain.QuestionDM;

@WebServlet("/com.omp.css.controller/questionupdatesave")
public class QuestionUpdateSave extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("문의 수정 저장하기 서블릿 호출");
		int no = Integer.parseInt(request.getParameter("no"));
		QuestionDAO dao = new QuestionDAO();
		QuestionDM question = dao.selectQuestionByNo(no);
		String title = request.getParameter("title");
		String question_content = request.getParameter("question_content");
		question.setTitle(title);
		question.setQuestion_content(question_content);
		
		
		dao.updateQuestion(question);
		response.sendRedirect("/ohmypet/com.omp.css.controller/cssselect");
	}
	

}
