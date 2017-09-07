package com.omp.common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.common.dao.MembershipDAO;
@WebServlet("/com/omp/common/controller/loginidoverlap")
public class LoginIdOverlap extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("아이디 중복체크 서블릿 호출");
			
			MembershipDAO dao = new MembershipDAO();
			String id = request.getParameter("id");
			System.out.println(id);
			
			boolean result = dao.loginIdOverlap(id);
			String msg = "";
			if(!result) {
				System.out.println("이미 존재하는 아이디");
				msg = " 이미 존재하는 아이디 입니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/join.jsp");
				rd.forward(request, response);
				
			}
			else {
				System.out.println("중복되는 아이디 없음");
				msg = " 사용할 수 있는 아이디입니다";
				request.setAttribute("msg", msg);
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/join.jsp");
				rd.forward(request, response);
				
			}
		
			
		
	}
	

}
