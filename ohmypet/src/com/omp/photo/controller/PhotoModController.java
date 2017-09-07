package com.omp.photo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.photo.dao.PhotoBoardDAO;
import com.omp.photo.domain.PhotoBoardDM;

@WebServlet("/com/omp/photo/mod")
public class PhotoModController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("모드폼에 들어옴");
		/*PhotoBoardDAO dao = new PhotoBoardDAO();
		PhotoBoardDM dm = dao.selectPhotoDetail(no);
		
		request.setAttribute("updatecheck", "true");
		request.setAttribute("dm", dm);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/photo/photoupdate.jsp");
		rd.forward(request, response);*/
	}
	
	
}
