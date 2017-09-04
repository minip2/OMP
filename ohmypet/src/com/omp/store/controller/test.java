package com.omp.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.dao.ProductDAO;
import com.omp.store.domain.ProductDM;

public class test{
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductDM dm = new ProductDM();
		
		List<ProductDM> list = dao.ProductList();
		for(ProductDM l : list) {
			System.out.println(l.getCategoryVal());// 1000
			System.out.println(l.getProductId());// null
	}
	
		
	}
}