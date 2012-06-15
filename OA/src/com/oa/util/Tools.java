package com.oa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tools {
	public static void copyFile(File oldName, File newName) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = new FileInputStream(oldName);
			outputStream = new FileOutputStream(newName);
			byte[] buf = new byte[102400];
			int read = -1;
			 
			while ((read = inputStream.read(buf, 0, buf.length)) != -1) {
				outputStream.write(buf, 0, read);
				 

			}
			outputStream.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				inputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static  String makeNewFileName(String oldName) {
		// tt.test.txt-->20120324164155444
		String ext = oldName.substring(oldName.lastIndexOf("."));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmssSSS");
		String time = simpleDateFormat.format(new Date());
		Random random = new Random();
		int r = random.nextInt(10000);
		String newFileName = time + r + ext;

		return newFileName;

	}

}
