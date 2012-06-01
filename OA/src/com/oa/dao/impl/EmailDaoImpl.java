package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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
	public void saveEmail(final TEmail email, final int emailType) {
		// TEmail T_USER_EMAIL T_EMAIL_FILE
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				if (emailType == TYPE_NEW) {// 新建邮件
					session.save(email);
				} else if (emailType == TYPE_DRAFT) {//草稿箱发送
					
				}
				return null;
			}
		});
	}
}
