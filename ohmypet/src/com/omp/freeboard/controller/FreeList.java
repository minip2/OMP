package com.omp.freeboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.freeboard.dao.FreeBoardDAO;
import com.omp.freeboard.domain.FreeBoardDM;

@WebServlet("/com/omp/freeboard/controller/freelist")
public class FreeList extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sPageNo = request.getParameter("pageNo");
		int pageNo = 1;
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		FreeBoardDAO dao = new FreeBoardDAO();
		List<FreeBoardDM> list = dao.selectBoard(pageNo);
		// 전체 게시물 개수
		int count = dao.selectBoardCount();
		int lastPage = (count % 10 == 0) ? count / 10 : count / 10 + 1;
		
		request.setAttribute("list", list);
		request.setAttribute("lastPage", lastPage);
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/freeboard/list.jsp"
		);
		rd.forward(request, response);
	}
}		
		
		
		