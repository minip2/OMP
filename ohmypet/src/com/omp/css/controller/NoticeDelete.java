package com.omp.css.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.css.dao.NoticeDAO;

@WebServlet("/com/omp/css/controller/noticedelete")
public class NoticeDelete extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제 서블릿 호출");
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDAO dao = new NoticeDAO();
		dao.deleteNotice(no);
		response.sendRedirect("/ohmypet/com/omp/css/controller/cssselect");
	
	}
	
}