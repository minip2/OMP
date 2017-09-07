package com.omp.common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omp.common.dao.MembershipDAO;

@WebServlet("/com/omp/common/controller/membershipdelete")
public class Membershipdelete extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 삭제 호출 성공");
		
		String id = request.getParameter("id");
		System.out.println(id);
		MembershipDAO dao = new MembershipDAO();
		String msg = dao.deleteMembership(id);
		System.out.println(msg);
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/com/omp/css/controller/cssselect");
		rd.forward(request, response);
		
		
	}
	

}
