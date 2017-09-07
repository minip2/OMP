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

@WebServlet("/com/omp/common/controller/nick_nameoverlapnick")
public class Nick_nameOverlapNick extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("닉네임 중복체크 서블릿 호출");
		
		MembershipDAO dao = new MembershipDAO();
		String nick_name = request.getParameter("nick_name");
		System.out.println(nick_name);
		
		boolean result = dao.nick_nameOverlap(nick_name);
		String nick_msg = "";
		if(!result) {
			System.out.println("이미 존재하는 닉네임");
			nick_msg = " 이미 존재하는 닉네임 입니다.";
		}
		else {
			System.out.println("중복되는 닉네임 없음");
			nick_msg = " 사용할 수 있는 닉네임입니다";
		}
		
		request.setAttribute("nick_name", nick_name);
		request.setAttribute("nick_msg", nick_msg);
		
		System.out.println(nick_msg+"11111111111");
		System.out.println(nick_name+"11111111111");
		
		RequestDispatcher rd = request.getRequestDispatcher("/com/omp/common/controller/memberinfoselectnick");
		rd.forward(request, response);
	
		
	}
	

}
