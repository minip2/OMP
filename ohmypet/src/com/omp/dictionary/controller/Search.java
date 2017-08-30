package com.omp.dictionary.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.dictionary.dao.DictionaryDAO;

@WebServlet("/com/omp/dictionary/searchcontroller")
public class Search extends HttpServlet {
	DictionaryDAO dao = new DictionaryDAO();
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if(method.equals("POST")) {
			request.setCharacterEncoding("utf-8");
		}
		String groupName = request.getParameter("groupName");
		String keyword = request.getParameter("keyword");
		
		List<String> dog = dao.searchDog(keyword, groupName);
		
		request.setAttribute("dog", dog);
		request.setAttribute("keyword", keyword);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/Html/dictionary/dogSearch.jsp"
		);
		rd.forward(request, response);
	}
	
}
