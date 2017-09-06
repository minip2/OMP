package com.omp.photo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/com/omp/photo/photoupload")
public class PhotoUploadTest extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String realFolder ="C:/java97_2/server-work/wtpwebapps/ohmypet/data/photo";
		String file_sys_name = ""; //서버에 실제 저장된 파일 이름
		int maxSize = 1024*1024*30;
		String encType = "utf-8";
		String savefile = "img";
		ServletContext scontext = getServletContext();
		//realFolder = scontext.getRealPath(savefile);
		File f = new File(realFolder);
		if(f.exists() == false) f.mkdirs(); //f가 가리키는 디렉토리가 존재하지 않을 때, f가 가리키는 디렉토리 생성
		try {
		MultipartRequest multi = new MultipartRequest(request,
				realFolder, maxSize, encType,
				new MlecFileRenamePolicy()
				);
		Enumeration<?> files = multi.getFileNames(); //파일을 가져오는데 여러개일 수 있음
		String fileName = (String)files.nextElement(); //그중 첫번째 파일 가져오기
		String file_org_name = multi.getOriginalFileName(fileName); //사용자가 올린 파일 이름
		file_sys_name = multi.getFilesystemName(fileName);  //서버에 저장된 파일 이름
		} catch (Exception e) {
			System.out.println("포토 업로드 java 에러");
			e.printStackTrace();
		}
		
		String folderpath = "/ohmypet/data/photo";
		String file_path = folderpath + "/" + file_sys_name;
//		String fullpath = "${pageContext.request.contextPath}/data/photo/gold.jpg";
//		String fullpath = "/ohmypet/data/photo/gold.jpg";
		request.setAttribute("file_sys_name", file_sys_name);
		request.setAttribute("file_path", file_path);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/photo/photowrite.jsp");
		rd.forward(request, response);
		
	}

}
