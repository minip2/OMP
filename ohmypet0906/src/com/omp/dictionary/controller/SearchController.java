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

@WebServlet("/com/omp/dictionary/controller/search")
public class SearchController extends HttpServlet {
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
		
		List<String> dogList = dao.searchDog(groupName, keyword);
		
		request.setAttribute("dogList", dogList);
		request.setAttribute("keyword", keyword);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/dictionary/dogSearch.jsp"
		);
		rd.forward(request, response);
	}
	
}
