package com.oa.dao.impl;

import java.io.IOException;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transaction;

import oracle.sql.CLOB;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;

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

	// 保存邮件表 邮件附件
	@Override
	public Integer saveEmail(final TEmail email) {
		Integer emailId = getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {

					@Override
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						org.hibernate.Transaction ts = session
								.beginTransaction();// 尼玛
						// 保存TEmail
						email.setContent(Hibernate.createClob(" "));
						session.save(email);
						session.flush();// insert emailFIle 级联
						session.refresh(email, LockMode.UPGRADE);
						Clob clob = email.getContent();
						Writer writer = clob.setCharacterStream(0);
						try {
							writer.write(email.getStrContent());
							writer.flush();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						Integer emailId = (Integer) session.save(email);
						ts.commit();
						return emailId;
					}
				});
		return emailId;
	}

	@Override
	public void saveUserEmail(TUserEmail userEmail) {
		getHibernateTemplate().save(userEmail);
	}
}
