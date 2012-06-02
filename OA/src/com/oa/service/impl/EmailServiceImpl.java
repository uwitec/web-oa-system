package com.oa.service.impl;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.oa.common.FileUtil;
import com.oa.dao.inf.DataDao;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.dao.pojo.TUserEmailId;
import com.oa.service.inf.EmailService;

public class EmailServiceImpl implements EmailService {
	private EmailDao emailDao;

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	public EmailDao getEmailDao() {
		return emailDao;
	}

	@Override
	public void saveEmail(TUserEmail userEmail, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {

		
		TEmail email = userEmail.getId().getEmail();
		Set<TEmailFile> emailFiles = new HashSet<TEmailFile>();
		if (null != upload) {
			for (int i = 0; i < upload.size(); ++i) {
				String newFileName = FileUtil.makeNewFileName(uploadFileName
						.get(i));
				String newFilePath = savePath + newFileName;
				File newFile = new File(newFilePath);
				FileUtil.copyFile(upload.get(i), newFile);
				TEmailFile emailFile = new TEmailFile();
				emailFile.setDel(false);
				emailFile.setNewname(newFileName);
				emailFile.setOldname(uploadFileName.get(i));
				emailFile.setEmail(email);
				emailFiles.add(emailFile);
			}
		}
		email.setEmailFiles(emailFiles);
		Integer emailid = emailDao.saveEmail(email);

		email.setEmailid(emailid);
		emailDao.saveUserEmail(userEmail);

		String receusers = userEmail.getId().getEmail().getReceusers();
		for (String userid : receusers.split(";")) {
			TUser user = new TUser(userid.trim());
			TUserEmail receUserEmail = new TUserEmail();
			TUserEmailId id = new TUserEmailId();
			id.setEmail(email);
			id.setUser(user);
			receUserEmail.setId(id);
			receUserEmail.setType(EmailDao.TYPE_RECE);
			emailDao.saveUserEmail(receUserEmail);
		}
	}

	@Override
	public void saveEmailToDraft(TUserEmail userEmail) {

	}

}
