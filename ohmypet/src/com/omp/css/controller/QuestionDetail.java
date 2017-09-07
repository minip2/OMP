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



@WebServlet("/com/omp/css/controller/questiondetail")
public class QuestionDetail extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("문의 상세보기 서블릿 호출 성공");
		int no = Integer.parseInt(request.getParameter("no"));
		QuestionDAO dao = new QuestionDAO();
		int maxNo = dao.maxNo();
		if(no == 0) {
			QuestionDM question = dao.selectQuestionByNo(no+1);
			question.setQuestion_content(question.getQuestion_content().replace("\n", "<br>"));
			request.setAttribute("question", question);
		}
		else if(no== maxNo+1) {
			QuestionDM question = dao.selectQuestionByNo(maxNo);
			question.setQuestion_content(question.getQuestion_content().replace("\n", "<br>"));
			request.setAttribute("question", question);
		}
		else{
		QuestionDM question = dao.selectQuestionByNo(no);
		question.setQuestion_content(question.getQuestion_content().replace("\n", "<br>"));
		request.setAttribute("question", question);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/questiondetail.jsp");
		rd.forward(request, response);
		
		
	}
	

}
