package com.omp.dictionary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.dictionary.dao.DictionaryDAO;
import com.omp.dictionary.domain.DictionaryDM;
import com.omp.dictionary.domain.DogDM;

@WebServlet("/com/omp/dictionary/controller/dictionaryEdit")
public class DictionaryEditController extends HttpServlet{
	DictionaryDAO dao = new DictionaryDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dogName = request.getParameter("dogName");
		DogDM dog = dao.selectDog(dogName);
		int dogVal = dog.getDogVal();
		DictionaryDM dictionary = dao.selectDictionary(dogVal, dog.getVersion());
		
		request.setAttribute("dogName", dogName);
		request.setAttribute("dog", dog);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/dictionary/dictionaryEdit.jsp"
		);
		rd.forward(request, response);
		
	}

}
