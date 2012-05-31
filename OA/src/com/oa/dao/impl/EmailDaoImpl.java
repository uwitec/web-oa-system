package com.oa.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TUser;

public class EmailDaoImpl extends HibernateDaoSupport implements EmailDao {

	@Override
	public void deleteEmail(TEmail email) {
		
	}

	@Override
	public void deleteToDust(TEmail email) {

	}

	@Override
	public List<TEmail> getEmails(int emailType, boolean isRead) {
		return null;
	}

	@Override
	public TEmail getSingleEmail(int emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmail(TEmail email, int emailType) {
		//TEmail T_USER_EMAIL
		
	}

}
