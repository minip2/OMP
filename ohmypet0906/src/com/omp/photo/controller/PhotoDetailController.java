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

@WebServlet("/com/omp/photo/detail")
public class PhotoDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int no = Integer.parseInt(request.getParameter("no"));		
		
		PhotoBoardDAO dao = new PhotoBoardDAO();
		PhotoBoardDM dm = dao.selectPhotoDetail(no);
		
		request.setAttribute("dm", dm);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/photo/photoprint.jsp");
		rd.forward(request, response);
	}
	
}
