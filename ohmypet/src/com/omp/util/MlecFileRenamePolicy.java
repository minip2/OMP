package com.omp.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MlecFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		String parent = f.getParent();
		String name = f.getName();
		
		String ext = "";
		int index = name.lastIndexOf(".");
		if (index != -1) {
			ext = name.substring(index);
		}
		String fName = UUID.randomUUID().toString();
		return new File(parent, fName + ext);
	}

}
