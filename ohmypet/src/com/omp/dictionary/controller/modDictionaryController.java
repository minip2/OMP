package com.omp.dictionary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omp.common.domain.LoginDM;
import com.omp.dictionary.dao.DictionaryDAO;
import com.omp.dictionary.domain.DictionaryDM;
import com.omp.dictionary.domain.DogDM;

@WebServlet("/com/omp/dictionary/controller/modDictionary")
public class modDictionaryController extends HttpServlet{
	DictionaryDAO dao = new DictionaryDAO();
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		
	String detail = request.getParameter("detail");
	String dogName = request.getParameter("dogName");
	DogDM dog = dao.selectDog(dogName);
	int dogVal = dog.getDogVal();
	int version = dog.getVersion();
	DictionaryDM dictionary = dao.selectDictionary(dogVal, version);
	
	String sequenceName = "s_dictionary_" + dogVal;
	
	if (version == 0) {
		sequenceName = dao.insertSequence(dogVal);
	}
	
	HttpSession session = request.getSession();
	LoginDM login = (LoginDM)session.getAttribute("user");
	String nick_name = login.getNick_name();
	
	dictionary.setNick_name(nick_name);
	dictionary.setDetail(detail);
	dao.insertDictionary(dictionary, sequenceName);

	DictionaryDM predictionary = dao.selectPreDictionary(dogVal);
	
	dog.setDetail(predictionary.getDetail());
	dog.setVersion(predictionary.getVersion());
	dao.updateDetail(dog);

	request.setAttribute("dog", dog);
	request.setAttribute("dogName", dogName);
	
	RequestDispatcher rd = request.getRequestDispatcher(
			"/jsp/dictionary/dictionary.jsp"
	);
	rd.forward(request, response);
	}

}
