package com.oa.service.inf;

import java.io.File;
import java.util.List;

import com.oa.dao.pojo.TUserEmail;

public interface EmailService {

	/**
	 * �����ʼ�
	 * */
	void saveEmail(TUserEmail userEmail, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,String savePath);

	/**
	 * ����ݸ���
	 * */
	void saveEmailToDraft(TUserEmail userEmail);
}
