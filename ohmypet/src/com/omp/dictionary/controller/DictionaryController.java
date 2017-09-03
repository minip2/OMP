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

@WebServlet("/com/omp/dictionary/controller/dictionary")
public class DictionaryController extends HttpServlet{
	DictionaryDAO dao = new DictionaryDAO();
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String detail = request.getParameter("detail");
	String dogName = request.getParameter("dogName");
	DogDM dog = dao.selectDog(dogName);
	int dogVal = dog.getDogVal();
	double version = dog.getVersion();
	DictionaryDM dictionary = dao.selectDictionaryByNo(dogVal, version);
	if (detail != null) {
		version = Math.floor(version*10)/10;
		dictionary.setDetail(detail);
		dictionary.setVersion(version + 0.1);
		dao.insertDetail(dictionary);

		dog.setDetail(detail);
		dog.setVersion(version + 0.1);
		dao.updateDetail(dog);
	}
	
	request.setAttribute("dog", dog);
	request.setAttribute("dogName", dogName);
	
	RequestDispatcher rd = request.getRequestDispatcher(
			"/jsp/dictionary/dictionary.jsp"
	);
	rd.forward(request, response);
	}

}
