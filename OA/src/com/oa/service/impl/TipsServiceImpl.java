package com.oa.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.oa.dao.inf.EmailDao;
import com.oa.dao.inf.TPostDao;
import com.oa.dao.pojo.TTips;
import com.oa.dao.pojo.TUser;
import com.oa.service.inf.TipsService;

public class TipsServiceImpl implements TipsService {
	private EmailDao emailDao;
	private TPostDao postDao;

	// @Override
	// public List<Integer> countEmailAndPost(TUser user) {
	// List<Integer> numbers = new ArrayList<Integer>();
	// Integer emailCount = emailDao.countEmail(user);
	// numbers.add(emailCount);
	// return numbers;
	// }

	@Override
	public void updateTips(TTips tips) {

	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	public EmailDao getEmailDao() {
		return emailDao;
	}

	public void setPostDao(TPostDao postDao) {
		this.postDao = postDao;
	}

	public TPostDao getPostDao() {
		return postDao;
	}

	@Override
	public String countEmail(TUser user) {

		return emailDao.countEmail(user).toString();
	}

	@Override
	public String countPost(TUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
