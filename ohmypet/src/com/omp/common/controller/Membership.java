package com.omp.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.common.dao.MembershipDAO;
import com.omp.common.domain.MembershipDM;

@WebServlet("/com/omp/common/controller/membership")
public class Membership extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("회원가입 서블릿 호출");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email")+"@"+request.getParameter("domain");
		String name = request.getParameter("name");
		String phon_number = request.getParameter("phon1")+request.getParameter("phon2")+request.getParameter("phon3");
		
		int gender = 1;
		if(request.getParameter("gender").equals("man")) {
			 gender = 0;
		}
		
		int store_check=0;
		if(request.getParameter("store").equals("yes")) {
			 store_check = 1;
		}
		
		String address = request.getParameter("address");
		String nick_name = request.getParameter("nick_name");
		
		MembershipDAO dao = new MembershipDAO();
		MembershipDM member = new MembershipDM();
		
		member.setId(id);
		member.setPassword(password);
		member.setEmail(email);
		member.setName(name);
		member.setPhon_number(phon_number);
		member.setGender(gender);
		member.setStore_check(store_check);
		member.setAddress(address);
		member.setNick_name(nick_name);
		dao.insertMembership(member);
		response.sendRedirect("/ohmypet/com/omp/css/controller/cssselect");
		
	}
	
	

}
