package com.omp.css.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.css.dao.NoticeDAO;
import com.omp.css.dao.QuestionDAO;
import com.omp.css.domain.NoticeDM;
import com.omp.css.domain.QuestionDM;

@WebServlet("/com/omp/css/controller/cssselect")
public class CssSelect extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
		QuestionDAO Qdao = new QuestionDAO();
		List<QuestionDM> question = Qdao.selectQuestion();
	
		NoticeDAO Ndao = new NoticeDAO();
		List<NoticeDM> notice = Ndao.selectNotice();
	
		request.setAttribute("question", question);
		request.setAttribute("notice", notice);
	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/notice.jsp");
		rd.forward(request, response);
	
	}
	
	
}
