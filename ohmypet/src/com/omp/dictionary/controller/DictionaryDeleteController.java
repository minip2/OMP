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

@WebServlet("/com/omp/dictionary/controller/dictionaryDelete")
public class DictionaryDeleteController extends HttpServlet{
	DictionaryDAO dao = new  DictionaryDAO();
	DogDM dog = new DogDM();
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dogName = request.getParameter("dogName");
		int version = Integer.parseInt((request.getParameter("version")));
		DogDM dog = dao.selectDog(dogName);
		int dogVal = dog.getDogVal();
		if(version != 0) {
			//최신 버전
			int deleteVersion = dao.deleteDetail(dogVal, version);
			DictionaryDM preDictionary = dao.selectPreDictionary(dogVal);
			
			dog.setVersion(preDictionary.getVersion());
			dog.setDetail(preDictionary.getDetail());
			dao.updateDetail(dog);
		}
		
		List<DictionaryDM> history = dao.selectDictionaryList(dog.getDogVal());
		
		request.setAttribute("history", history);
		request.setAttribute("dogName", dogName);
		// 자바스크립트로 삭제된 버전 팝업창으로 띄우기
//		request.setAttribute("deleteVersion", deleteVersion);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/dictionary/history.jsp");
		rd.forward(request, response);
	}

}
