package com.omp.dictionary.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omp.common.domain.LoginDM;
import com.omp.dictionary.dao.VideoDAO;
import com.omp.dictionary.domain.VideoDM;
import com.omp.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/com/omp/dictionary/controller/insertVideo")
public class insertVideoController extends HttpServlet{
	VideoDAO dao = new VideoDAO();
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String upload = "C:/java97/server-work/wtpwebapps/ohmypet/data/dictionary/upload";
//		String upload = "C:/java97/workspace/ohmypet/data/dictionary/upload";
		String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
		
		File f = new File(upload + path);
		if(!f.exists()) f.mkdirs();
		
		MultipartRequest mRequest = new MultipartRequest(
				request,
				upload + path,
				1024 * 1024 * 1024,
				"utf-8",
				new MlecFileRenamePolicy()
		);
		
		String title = mRequest.getParameter("title");
		HttpSession session = request.getSession();
		LoginDM login = (LoginDM)session.getAttribute("user");
		String nickname = login.getNick_name();
		
		Enumeration<String> fNames = mRequest.getFileNames();
		while (fNames.hasMoreElements()) {
			String fileName = fNames.nextElement();
			File file = mRequest.getFile(fileName);
			
			if (file != null) {
				VideoDM video = new VideoDM();
				video.setTitle(title);
				video.setVideoOrgName(mRequest.getOriginalFileName(fileName));
				video.setVideoSystemName(mRequest.getFilesystemName(fileName));
				video.setVideoPath(path);
				video.setVideoSize(file.length());
				video.setNick_name(nickname);
				dao.insertVideo(video);
			}
		}
		
		List<VideoDM> videoList = dao.videoList();
		request.setAttribute("videoList", videoList); 
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/dictionary/video.jsp");
		rd.forward(request, response);
	}

}










