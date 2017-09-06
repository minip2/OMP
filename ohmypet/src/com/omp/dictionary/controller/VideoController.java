package com.omp.dictionary.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.dictionary.dao.VideoDAO;
import com.omp.dictionary.domain.VideoDM;

@WebServlet("/com/omp/dictionary/controller/video")
public class VideoController extends HttpServlet{
	VideoDAO dao = new VideoDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<VideoDM> videoList = dao.videoList();
		request.setAttribute("videoList", videoList); 
		
		for (VideoDM video : videoList) {
			System.out.println(video.getNo());
			System.out.println(video.getTitle());
			System.out.println(video.getVideoOrgName());
			System.out.println(video.getVideoPath());
			System.out.println(video.getVideoSize());
			System.out.println(video.getVideoSystemName());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/dictionary/video.jsp");
		rd.forward(request, response);
	}
	
}
