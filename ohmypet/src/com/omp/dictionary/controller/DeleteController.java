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

@WebServlet("/com/omp/dictionary/controller/delete")
public class DeleteController extends HttpServlet{
	DictionaryDAO dao = new  DictionaryDAO();
	DogDM dog = new DogDM();
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dogName = request.getParameter("dogName");
		Double version = Double.parseDouble(request.getParameter("version"));
		DogDM dog = dao.selectDog(dogName);
		if(version != 1.0) {
			//전 버전
			double preVersionNo = Math.floor((version - 0.1)*10)/10;
			DictionaryDM preDic = dao.selectDictionaryByNo(dog.getDogVal(), preVersionNo);
			dog.setVersion(preDic.getVersion());
			dog.setDetail(preDic.getDetail());
			dao.updateDetail(dog);
			
			double deleteVersion = dao.deleteDetail(dog.getDogVal(), version);
		}
		
		List<DictionaryDM> history = dao.selectDictionary(dog.getDogVal());
		
		
		request.setAttribute("history", history);
		request.setAttribute("dogName", dogName);
		// 자바스크립트로 삭제된 버전 팝업창으로 띄우기
//		request.setAttribute("deleteVersion", deleteVersion);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/dictionary/history.jsp");
		rd.forward(request, response);
	}

}
