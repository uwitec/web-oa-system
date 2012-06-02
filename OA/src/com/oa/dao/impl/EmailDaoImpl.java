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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.common.UserInfo;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<TUserEmail> getEmails(final int emailType,
			final boolean isRead, final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TEmail>>() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.springframework.orm.hibernate3.HibernateCallback#
					 * doInHibernate(org.hibernate.Session)
					 */
					@Override
					public List<TEmail> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = null;
						String hql = null;
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;
						switch (emailType) {
						case TYPE_SEND:// 发件箱
							hql = " from TUserEmail t where t.id.user.userid = :userid";
							query = session.createQuery(hql);
							query.setParameter("userid", userInfo.getUser()
									.getUserid());
							break;
						default:
							break;
						}
						userInfo.setTotalCount(query.list().size());
						System.out.println(userInfo.getTotalCount());
						query.setFirstResult((currPage - 1)
								* UserInfo.PAGE_SIZE);
						query.setMaxResults(currPage * UserInfo.PAGE_SIZE);

						return query.list();
					}
				});

	}

	@Override
	public TEmail getSingleEmail(int emailId) {

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
