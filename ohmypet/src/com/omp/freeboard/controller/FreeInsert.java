package com.omp.freeboard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omp.freeboard.dao.FreeBoardDAO;
import com.omp.freeboard.domain.FreeBoardDM;
import com.omp.freeboard.domain.FreeBoardFile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//등록 서블릿
@WebServlet("/com/omp/freeboard/controller/freeinsert")
public class FreeInsert extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
	
		String saveDirectory  = "c:/java97";
		MultipartRequest mRequest = new MultipartRequest(
				request,
				saveDirectory,
				1024*1024*100,
				"utf-8",
				new DefaultFileRenamePolicy()				
				);
		
	String title = mRequest.getParameter("title");  
	String name = mRequest.getParameter("name");
	String content  = mRequest.getParameter("content");
	String pw = mRequest.getParameter("pw");
	System.out.println(mRequest.getParameter("category_val"));
	int category_val = Integer.parseInt(mRequest.getParameter("category_val"));
	
	FreeBoardDM dm = new FreeBoardDM();
    dm.setName(name);
    dm.setTitle(title);
    dm.setContent(content); 
    dm.setPw(pw);
    dm.setCategoryVal(category_val);
    
	FreeBoardDAO dao = new FreeBoardDAO();
	//게시글 번호 가져오기 
	int no = dao.selectBoardNo();
	dm.setNo(no);
	dao.insertBoard(dm);
	
	File f = mRequest.getFile("filePath");
	
     if(f != null) {
    	String orgName = mRequest.getOriginalFileName("filePath"); 
    	String systemName = mRequest.getFilesystemName("filePath"); 
    	 
    FreeBoardFile file = new FreeBoardFile();
     file.setNo(no);
     file.setFilePath(saveDirectory); 
     file.setFileOrgName(orgName); 
     file.setFileSystemName (systemName); 
     file.setFileSize((int)f.length()); 
     dao.insertBoardFile(file);
	 
     }
	
	//목록페이지 호출
	//request.getContextPath()
     response.sendRedirect(request.getContextPath()+"/com/omp/freeboard/controller/freelist");
	  

	}
}
