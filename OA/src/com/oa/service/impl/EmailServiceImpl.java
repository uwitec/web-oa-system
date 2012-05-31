package com.oa.service.impl;

import com.oa.dao.inf.EmailDao;
import com.oa.service.inf.EmailService;

public class EmailServiceImpl implements EmailService {
	private EmailDao emailDao;

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	public EmailDao getEmailDao() {
		return emailDao;
	}
}
