package com.omp.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/com.omp.common.controller/logout")
public class Logout extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	로그아웃 처리 : 세션을 삭제하는 작업
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("/ohmypet/com.omp.css.controller/cssselect");
	}
	

}
