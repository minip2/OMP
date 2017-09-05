package kr.co.mlec.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MelcFileRenamePolicy implements FileRenamePolicy{

	public File rename(File f) {
		String parent = f.getParent();
		String name = f.getName(); 
		String ext = "";
		int index = name.lastIndexOf(".");
		if(index != -1) {
			ext = name.substring(index);
		}// 확장자 구하기
		String fName = UUID.randomUUID().toString();
		return new File(parent,fName+ext);
	}
	
	public String getExt(File f) {
		String parent = f.getParent();
		String name = f.getName(); 
		String ext = "";
		int index = name.lastIndexOf(".");
		if(index != -1) {
			ext = name.substring(index+1);
		}// 확장자 구하기
		return ext;
	}
}