package com.omp.store.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.store.dao.ShBoardDAO;
import com.omp.store.domain.ShBoardDM;
import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.util.MelcFileRenamePolicy;

@WebServlet("/shboard/insert")
public class ShBoardInsert extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upload = "C:/java97/server-work/wtpwebapps/ohmypet/upload";
		String path = new SimpleDateFormat("/yyyy/MM/").format(new Date());
		File f = new File(upload+path);
		if(f.exists() == false) f.mkdirs();
		String e = "";
		MultipartRequest mRequest = new MultipartRequest(
				request,
				upload + path, //디렉토리 경로
				1024*1024*30,//업로드 최대사이즈 
				"utf-8", //파라미터 인코딩 지정
				new MelcFileRenamePolicy()); //rename 호출


		System.out.println("업로드 성공");
		String msg = mRequest.getParameter("msg");
		System.out.println(msg);


		Enumeration<String> fNames = mRequest.getFileNames();
		while(fNames.hasMoreElements()) {

			String fileName = fNames.nextElement();
			File file = mRequest.getFile(fileName);

			if(file != null) {
				System.out.println("파일 사이즈 : " + file.length());
				System.out.println("파일 경로 : "+ path);
				String orgName = mRequest.getOriginalFileName(fileName);
				System.out.println("사용자가 올린 파일 이름 : "+ orgName);
				String sysName = mRequest.getFilesystemName(fileName);
				System.out.println("서버에 저장된 퐈일 이름 : "+ sysName);
				e = mRequest.getFilesystemName(fileName);
			}
		}
	


	ShBoardDAO dao = new ShBoardDAO();
	ShBoardDM dm = new ShBoardDM();

	dm.setPhotoPath(upload+path+e);
	dm.setId(mRequest.getParameter("id"));
	dm.setTitle(mRequest.getParameter("title"));	
	dm.setProductDetail(mRequest.getParameter("productDetail"));
	dm.setProductId(mRequest.getParameter("productId"));
	dm.setPrice(Integer.parseInt(mRequest.getParameter("price")));
	dao.ShBoardInsert(dm);

	RequestDispatcher rd = request.getRequestDispatcher("/store/main");
	rd.forward(request, response);


}



}
