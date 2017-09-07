package com.omp.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.common.dao.MembershipDAO;
import com.omp.common.domain.MembershipDM;
@WebServlet("/com/omp/common/controller/membershipupdate")
public class MembershipUpdate extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("`````회원 정보 수정  저장하기 서블릿 호출");
		String id = request.getParameter("id");
		String nicknname = request.getParameter("nicknname");
		System.out.println(id);
		System.out.println(nicknname);
		
		int gender = 1;
		if(request.getParameter("gender").equals("man")) {
			 gender = 0;
		}
		
		int store_check=0;
		if(request.getParameter("store").equals("yes")) {
			 store_check = 1;
		}
		
		MembershipDAO dao = new MembershipDAO();
		MembershipDM member = dao.selectMembershipById(id);
		member.setId(id);
		member.setPassword(request.getParameter("password"));
		member.setNick_name(request.getParameter("nick_name"));
		member.setPhon_number(request.getParameter("phon1")+request.getParameter("phon2")+request.getParameter("phon3"));
		member.setEmail(request.getParameter("email"));
		member.setStore_check(store_check);
		member.setGender(gender);
		member.setAddress(request.getParameter("address"));
		
		dao.updateMembership(member);
		System.out.println("제발 되러ㅏ");
		/*QuestionDAO dao = new QuestionDAO();
		QuestionDM question = dao.selectQuestionByNo(no);
		String title = request.getParameter("title");
		String question_content = request.getParameter("question_content");
		question.setTitle(title);
		question.setQuestion_content(question_content);
		
		
		dao.updateQuestion(question);
		response.sendRedirect("/ohmypet/com/omp/css/controller/cssselect");*/
	}
	

}