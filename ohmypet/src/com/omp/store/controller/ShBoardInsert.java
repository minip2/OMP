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
import com.omp.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/shboard/insert")
public class ShBoardInsert extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upload = "C:/java97/server-work/wtpwebapps/ohmypet/upload";
		String path = new SimpleDateFormat("/yyyy/MM/").format(new Date());
		File f = new File(upload+path);
		ShBoardDAO dao = new ShBoardDAO();
		ShBoardDM dm = new ShBoardDM();
		if(f.exists() == false) f.mkdirs();
		String e = "";
		MultipartRequest mRequest = new MultipartRequest(
				request,
				upload + path, //디렉토리 경로
				1024*1024*30,//업로드 최대사이즈 
				"utf-8", //파라미터 인코딩 지정
				new MlecFileRenamePolicy()); //rename 호출



		
		Enumeration<String> fNames = mRequest.getFileNames();
		while(fNames.hasMoreElements()) {

			String fileName = fNames.nextElement();
			File file = mRequest.getFile(fileName);

			if(file != null) {
				String orgName = mRequest.getOriginalFileName(fileName);
				String sysName = mRequest.getFilesystemName(fileName);
				e = mRequest.getFilesystemName(fileName);
				dm.setSname(sysName);
				dm.setDname(orgName);
			}
		}
	
		



	dm.setPhotoPath(path);
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
