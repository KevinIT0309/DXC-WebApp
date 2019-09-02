package com.techzone.springmvc.util;
import java.io.File;
import org.springframework.stereotype.Service;

@Service
public class SizeFolderUtil {
	
	private long calFolderSize(File folder) {
		long length = 0;
		File[] files = folder.listFiles();
		int count = files.length;
		for (int i = 0; i < count; i++) {
			if (files[i].isFile()) {
				length += files[i].length();
			} else {
				length += calFolderSize(files[i]);
			}
		}
		return length;
	}

	public long SizeOfFolder(String nameProduct) {
		File folder = new File("src/main/webapp/resources/images/" + nameProduct);
		long size = calFolderSize(folder);
		return size;
	}

}
