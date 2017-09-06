package com.omp.freeboard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.freeboard.dao.FreeBoardDAO;
import com.omp.freeboard.domain.FreeBoardDM;

//등록 서블릿
@WebServlet("/com/omp/freeboard/controller/freeinsert")
public class FreeInsert extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod(); 
		if(method.equals("POST")) {
			request.setCharacterEncoding("utf-8"); 
		}	
		System.out.println("뭐가 문제야4");
	String title = request.getParameter("title");  
	String name = request.getParameter("name");
	String content  = request.getParameter("content");
	String pw = request.getParameter("pw");
	System.out.println(request.getParameter("category_val"));
	int category_val = Integer.parseInt(request.getParameter("category_val"));
	
	System.out.println("뭐가 문제야1");
	String filepath = "파일경로"; 
    File f = new File(filepath);//파일디렉토리생성 

    System.out.println("뭐가 문제야1");
	FreeBoardDM dm = new FreeBoardDM();
     dm.setName(name);
     dm.setTitle(title);
     dm.setContent(content); 
     dm.setPw(pw);
     dm.setCategoryVal(category_val);
     dm.setFilePath(filepath);
     System.out.println("뭐가 문제야2");
	FreeBoardDAO dao = new FreeBoardDAO(); 
	dao.insertBoard(dm);
	System.out.println("뭐가 문제야3");
	//목록페이지 호출
	//request.getContextPath()
     response.sendRedirect(request.getContextPath()+"/com/omp/freeboard/controller/freelist");
	  

	}
}
