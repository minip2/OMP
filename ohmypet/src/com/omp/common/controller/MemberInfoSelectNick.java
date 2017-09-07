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
import com.omp.common.domain.LoginDM;
import com.omp.common.domain.MembershipDM;

@WebServlet("/com/omp/common/controller/memberinfoselectnick")
public class MemberInfoSelectNick extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("닉네임 중복수정 서블릿 호출");
		
		//String nick_msg = request.getParameter("nick_msg");
		String nick_name = request.getParameter("nick_name");
		//System.out.println(nick_msg+"----");
		System.out.println(nick_name+"----");
		
		
		HttpSession session = request.getSession();
		LoginDM user = (LoginDM)session.getAttribute("user");
		String id = user.getId();
		MembershipDAO dao = new MembershipDAO();
		MembershipDM member = dao.selectMembershipById(id);
		member.setNick_name(nick_name);
		
		//request.setAttribute("nick_msgg", nick_msg);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/memberinfoupdate.jsp");
		rd.forward(request, response);
		
	}
	

}
