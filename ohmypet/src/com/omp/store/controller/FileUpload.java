package com.omp.store.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.dao.ProductDAO;
import com.omp.store.domain.ProductDM;
import com.omp.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/product/upload")
public class FileUpload extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getMethod();
		if(method.equals("POST")) {
			request.setCharacterEncoding("utf-8");
		}
		
		String upload = "C:/java97/server-work/wtpwebapps/ohmypet/upload";
		String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
		File f = new File(upload+path);
		if(f.exists() == false) f.mkdirs();
		
		MultipartRequest mRequest = new MultipartRequest(
				request,
				upload + path, //디렉토리 경로
				1024*1024*30,//업로드 최대사이즈 
				"utf-8", //파라미터 인코딩 지정
				new MlecFileRenamePolicy()); //rename 호출
		
		
		System.out.println("업로드 성공");
		String msg = mRequest.getParameter("msg");
		System.out.println(msg);
		
		
		
			
		
		
		
//		dm.setPhotoPath(upload+path);
		
		ProductDAO dao = new ProductDAO();
		ProductDM dm = new ProductDM();
		
		List<ProductDM> list = dao.ProductList();
		
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/productmod.jsp");
		rd.forward(request, response);
	}
	
	
	
}
