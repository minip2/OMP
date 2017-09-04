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
import com.omp.dictionary.domain.DictionaryDM;
import com.omp.dictionary.domain.DogDM;

@WebServlet("/com/omp/dictionary/controller/history")
public class historyController extends HttpServlet{
	DictionaryDAO dao = new DictionaryDAO();
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dogName = request.getParameter("dogName");
		DogDM dog = dao.selectDog(dogName);
		
		List<DictionaryDM> history = dao.selectDictionaryList(dog.getDogVal());
		
		request.setAttribute("history", history);
		request.setAttribute("dogName", dogName);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/dictionary/history.jsp");
		rd.forward(request, response);
	}

}
