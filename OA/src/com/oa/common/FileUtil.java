package com.oa.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
	public static void copyFile(File oldFile, File newFile) {

		BufferedInputStream inputStream = null;
		BufferedOutputStream outputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(oldFile));
			outputStream = new BufferedOutputStream(new FileOutputStream(
					newFile));
			byte[] bytes = new byte[10240];
			int read = 0;
			while ((read = inputStream.read(bytes, 0, bytes.length)) != -1) {
				outputStream.write(bytes, 0, read);
				outputStream.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static String makeNewFileName(String oldFileName) {
		String ext = oldFileName.substring(oldFileName.lastIndexOf("."));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String name = dateFormat.format(new Date());
		return name + ext;

	}
}
