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

@WebServlet("/com/omp/css/controller/noticedetail")
public class NoticeDetail extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("공지사항 상세보기 호출");
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDAO dao = new NoticeDAO();
		int maxNo = dao.maxNo();
		System.out.println(maxNo);
		if(no == 0) {
		NoticeDM notice = dao.selectNoticeByNo(no+1);
		notice.setContent(notice.getContent().replace("\n", "<br>"));
		request.setAttribute("notice", notice);
		}
		else if(no == maxNo+1) {
			NoticeDM notice = dao.selectNoticeByNo(maxNo);
			notice.setContent(notice.getContent().replace("\n", "<br>"));
			request.setAttribute("notice", notice);
		}
		else {
		NoticeDM notice = dao.selectNoticeByNo(no);
		notice.setContent(notice.getContent().replace("\n", "<br>"));
		request.setAttribute("notice", notice);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/noticedetail.jsp");
		rd.forward(request, response);
	}
	

}
