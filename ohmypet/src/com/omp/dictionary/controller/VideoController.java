package com.omp.dictionary.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/com/omp/dictionary/controller/video")
public class VideoController extends HttpServlet{

	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String upload = "C:/java97/server-work/wtpwebapps/ohmypet/upload";
		String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
		
		File f = new File(upload + path);
		if(!f.exists()) f.mkdirs();
		
		MultipartRequest mRequest = new MultipartRequest(
				request,
				upload + path,
				1024 * 1024 * 1024,
				"utf-8",
				new MlecFileRenamePolicy()
		);
		
		Enumeration<String> fNames = mRequest.getFileNames();
		while (fNames.hasMoreElements()) {
			String fileName = fNames.nextElement();
			File file = mRequest.getFile(fileName);
			
			if (file != null) {
				
			}
		}
		
		String title = mRequest.getParameter("title");
		
		response.sendRedirect("/ohmypet/jsp/dictionary/video.jsp");
	}

}










