package com.omp.store.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.domain.ShBoardDM;

@WebServlet("/shboard/mod")
public class ShboardMod extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		ShBoardDM sdm = new ShBoardDM();
	
		
		sdm.setTitle(request.getParameter("title"));
		sdm.setPhotoPath(request.getParameter("photoPath"));
		sdm.setSname(request.getParameter("sname"));
		sdm.setDname(request.getParameter("dname"));
		sdm.setProductDetail(request.getParameter("productDetail"));
		sdm.setNo(Integer.parseInt(request.getParameter("no")));
		sdm.setPrice(Integer.parseInt(request.getParameter("price")));
		
		request.setAttribute("sdm",sdm);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/shboradmod.jsp");
		rd.forward(request, response);
	}
	
	
	
}
