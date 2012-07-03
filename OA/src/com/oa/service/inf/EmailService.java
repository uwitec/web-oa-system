package com.oa.service.inf;

import java.io.File;
import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TUserEmail;

public interface EmailService {

	/**
	 * �����ʼ�
	 * */
	void saveEmail(TUserEmail userEmail, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath);

	/**
	 * ����ݸ���
	 * */
	void saveEmailToDraft(TUserEmail userEmail, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath);

	/**
	 * �ݸ巢��
	 * */
	void draftSend(TUserEmail userEmail, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath);

	/**
	 * ���²ݸ�
	 * */
	void updateDraft(TUserEmail userEmail, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath);

	List<TUserEmail> getEmails(TUserEmail userEmail, UserInfo userInfo);

	void deleteEmail(TUserEmail userEmail);

	void deleteToDust(TUserEmail userEmail);

	void dustToInbox(TUserEmail userEmail);

	TEmail getSingleEmail(TUserEmail userEmail);

	void deleteEmailFile(TEmailFile emailFile);
}
