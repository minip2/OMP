//공지사항 상세보기
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
import com.omp.css.domain.NoticeDM;

@WebServlet("/com/omp/css/controller/noticeinsert")
public class NoticeInsert extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("호출 성공");
		
		String id = "관리자";
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(title != null) {
		NoticeDM notice = new NoticeDM();
		notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		NoticeDAO dao = new NoticeDAO();
		dao.insertNotice(notice);
		}
		response.sendRedirect("/ohmypet/com/omp/css/controller/cssselect");
		
		/*request.setAttribute("notice", notice);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/notice.jsp");
		rd.forward(request, response);*/
		
	}
	

}
