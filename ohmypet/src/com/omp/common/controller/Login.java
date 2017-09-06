package com.omp.common.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omp.common.dao.LoginDAO;
import com.omp.common.domain.LoginDM;





@WebServlet("/com.omp.common.controller/login")
public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("로그인 서블릿 호출");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		
		LoginDAO dao = new LoginDAO();
		
		LoginDM login = dao.login(id, password);
		
		
		
		// 로그인 쿼리 DAO에
		 
		String page = "/ohmypet/com.omp.css.controller/cssselect";
		if(login !=null) {
			
			HttpSession session = request.getSession();
			
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//login.setAccessTime(sdf.format(new Date()));
			session.setAttribute("user", login);
			
			response.sendRedirect("/ohmypet/com.omp.css.controller/cssselect");
		
		}
		else {
			page = "/jsp/css/login.jsp";
			request.setAttribute("error", "입력하신 정보가 올바르지 않습니다");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		
		
	}
	
}
