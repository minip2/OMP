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

@WebServlet("/com/omp/photo/writer")
public class PhotoWriteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String dog_val = request.getParameter("dog_val");
		String file_path = request.getParameter("file_path");
		String file_sys_name = request.getParameter("file_sys_name");
		String file_org_name = request.getParameter("file_org_name");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		
		PhotoBoardDM dm = new PhotoBoardDM();
		dm.setFile_org_name(file_org_name);
		dm.setFile_sys_name(file_sys_name);
		dm.setTitle(title);
		dm.setDog_val(Integer.parseInt(dog_val));
		dm.setFile_path(file_path);
		dm.setContent(content);
		dm.setId(id);
		
		//파일 경로  <img src="a.jpg" width="200px" height = "150px">
		
		PhotoBoardDAO dao = new PhotoBoardDAO();
		dao.insertPhotoBoard(dm);
		
		response.sendRedirect("/ohmypet/com/omp/photo/list");
	}
	
}
