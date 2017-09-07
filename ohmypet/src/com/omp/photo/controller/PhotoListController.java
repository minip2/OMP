package com.omp.photo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.photo.dao.PhotoBoardDAO;
import com.omp.photo.domain.PhotoBoardDM;

@WebServlet("/com/omp/photo/list")
public class PhotoListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PhotoBoardDAO dao = new PhotoBoardDAO();
		List<PhotoBoardDM> list = dao.selectPhotoList();
		
		request.setAttribute("photolist", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/photo/photolist.jsp");
		rd.forward(request, response);
	}
}
