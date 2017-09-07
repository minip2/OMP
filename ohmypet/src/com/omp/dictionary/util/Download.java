package com.omp.dictionary.util;

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
import javax.servlet.http.HttpSession;

/*
 *     다운로드 기능을 구현하기 위한 방식
 *     - 다운로드 할 파일을 자바의 IO 기능을 이용해서 읽어들인 후
 *       응답 객체를 통해서 사용자 브라우저로 출력한다.
 */

@WebServlet("/com/omp/dictionary/util/download")
public class Download extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일을 읽고 사용자 다운로드 이름을 결정하기 위한 필수 파라미터
		// path  : 다운로드할 파일의 서버 경로
		// sname : 서버에 실제 저장된 파일명
		// dname : 다운로드할 파일명
		String path = request.getParameter("path");
		String sname = request.getParameter("sname");
		String dname = request.getParameter("dname");
		HttpSession session = request.getSession();
		session.getAttribute("user");
		
		String upload = "C:/java97/server-work/wtpwebapps/ohmypet/data/dictionary/upload";
		File f = new File(upload + path, sname);
		
		// 파일 다운로드 하기
		response.setHeader("Content-Type", "application/octet-stream");
		// 다운로드할 파일 이름 설정
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(dname.getBytes("utf-8"), "8859_1"));
		// 다운로드 데이터 타입 설정
		response.setHeader("Content-Transfer-Encodiong", "binary");
		// 다운로드할 파일의 사이즈 설정
		response.setHeader("Content-Length", String.valueOf(f.length()));
		
		
		
		// 파일을 읽기 위한 객체
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		// 출력하기 위한 객체
		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
//		out.write(파일의 내용..);
		
		while (true) {
			int ch = bis.read();
			if (ch == -1) break;
			
			bos.write(ch);
		}
		
		fis.close();
		bis.close();
		bos.close();
		out.close();
	}
	
}
