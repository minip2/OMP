package com.omp.common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.common.dao.MembershipDAO;

@WebServlet("/com/omp/common/controller/idsearch")
public class IdSearch extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("아이디 찾기 서블릿 호출");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name);
		System.out.println(email);
		MembershipDAO dao = new MembershipDAO();
		String id = dao.idSearch(name, email);
		System.out.println("찾은 아이디 : " + id);
		String msg ="";
	if(id != null) {
		msg = "찾으시는 아이디 정보는 "+id+" 입니다.";
	}
	else {
		msg = "해당하는 아이디가 존재하지 않습니다.";
	}
	request.setAttribute("msg", msg);
	request.setAttribute("id", id);
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/idsearch.jsp");
	rd.forward(request, response);
	
	
	

}
}