package com.omp.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/store/download")
public class StoreDownload extends HttpServlet {

	@Override
	protected void service
	(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		String path  = request.getParameter("path");
		String sname = request.getParameter("sname");
		String dname = request.getParameter("dname");
		String upload = "c:/java97/server-work/wtpwebapps/ohmypet/upload/";
		File f = new File(upload+path,sname);
		
		response.setHeader("Content-Type","application/octet-stream");
		
		response.setHeader("Content-Disposition","attachment;filename="+
		new String(dname.getBytes("utf-8"), "8859_1"));
		
		response.setHeader("Content-Teansfer-Encoding","binary");

		response.setHeader("Content-Length", String.valueOf(f.length()));
		
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
				
		while(true) {
			int ch = bis.read();
			if(ch==-1) break;
			
			bos.write(ch);
		}
		bis.close();
		fis.close();
		bos.close();
		out.close();
	}
}