package com.omp.dictionary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/com/omp/dictionary/controller/regVideo")
public class RegVideoController extends HttpServlet{

	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/ohmypet/jsp/dictionary/regVideo.jsp");
	}

}
