package com.oa.service.inf;

import java.io.File;
import java.util.List;

import com.oa.dao.pojo.TUserEmail;

public interface EmailService {

	/**
	 * ·¢ËÍÓÊ¼ş
	 * */
	void saveEmail(TUserEmail userEmail, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,String savePath);

	/**
	 * ±£´æ²İ¸åÏä
	 * */
	void saveEmailToDraft(TUserEmail userEmail);
}
