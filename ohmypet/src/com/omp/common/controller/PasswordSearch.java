package com.omp.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.common.dao.MembershipDAO;
@WebServlet("/com/omp/common/controller/passwordsearch")
public class PasswordSearch extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("비밀번호 찾기 서블릿 호출 성공");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		
		MembershipDAO dao = new MembershipDAO();
		String password = dao.passwordSearch(name, email, id);
		System.out.println(password);
		
		
		
	}
	

}
