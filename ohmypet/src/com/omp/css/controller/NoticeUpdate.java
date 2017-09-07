package com.omp.css.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.css.dao.NoticeDAO;
import com.omp.css.domain.NoticeDM;

@WebServlet("/com/omp/css/controller/noticeupdate")
public class NoticeUpdate extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("수정 서블릿 호출 성공");
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		NoticeDAO dao = new NoticeDAO();
		
		NoticeDM notice = dao.selectNoticeByNo(no);
		
		
		request.setAttribute("notice", notice);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/noticeupdate.jsp");
		rd.forward(request, response);
		
		
		
		
	}
	
	

}
