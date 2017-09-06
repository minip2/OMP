package com.omp.css.controller;

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

import com.omp.css.dao.LoginDAO;
import com.omp.css.domain.LoginDM;





@WebServlet("/com.omp.css.controller/login")
public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("로그인 서블릿 호출");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		
		
		
		LoginDAO dao = new LoginDAO();
		
		LoginDM login = dao.login(id, password);
		System.out.println("로그인 성공");
		System.out.println(login.getId());
		//System.out.println(login.getId() + "   :  " + login.getPassword());
		
		// 로그인 쿼리 DAO에
		 
/*		String page = "/com.omp.css.controller/cssselect";
		if("a".equals(login.getId()) && "1".equals(login.getPassword())) {
			
			HttpSession session = request.getSession();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			login.setAccessTime(sdf.format(new Date()));
			session.setAttribute("user", login);
			
			
		}
		else {
			page = "/jsp/css/login";
			request.setAttribute("error", "입력하신 정보가 올바르지 않습니다");
		}*/
		HttpSession session = request.getSession();
		session.setAttribute("user", login);
		
		RequestDispatcher rd = request.getRequestDispatcher("/com.omp.css.controller/cssselect");
		rd.forward(request, response);
		
	}
	
}
