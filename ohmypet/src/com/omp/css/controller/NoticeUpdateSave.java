package com.omp.css.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.css.dao.NoticeDAO;
import com.omp.css.domain.NoticeDM;

@WebServlet("/com/omp/css/controller/noticeupdatesave")
public class NoticeUpdateSave extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("수정 저장하기 호출");
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		NoticeDAO dao = new NoticeDAO();
		NoticeDM notice = dao.selectNoticeByNo(no);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(title);
		System.out.println(content);
		notice.setTitle(title);
		notice.setContent(content);
		dao.updateNotice(notice);
		response.sendRedirect("/ohmypet/com/omp/css/controller/cssselect");
		
	}
	

}
