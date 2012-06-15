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
import com.sun.org.apache.xpath.internal.operations.Bool;

public class EmailDaoImpl extends HibernateDaoSupport implements EmailDao {

	@Override
	public void deleteEmail(final TUserEmail userEmail) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "delete from TUserEmail t where t.id.user.userid = :userid and t.id.email.emailid = :emailid";
				Query query = session.createQuery(hql);
				query.setParameter("userid", userEmail.getId().getUser()
						.getUserid());
				query.setParameter("emailid", userEmail.getId().getEmail()
						.getEmailid());

				return query.executeUpdate();
			}
		});
	}

	@Override
	public void deleteToDust(final TUserEmail userEmail) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "update TUserEmail t set t.type = "
						+ EmailDao.TYPE_DUST
						+ " where t.id.user.userid = :userid and t.id.email.emailid = :emailid";
				Query query = session.createQuery(hql);
				query.setParameter("userid", userEmail.getId().getUser()
						.getUserid());
				query.setParameter("emailid", userEmail.getId().getEmail()
						.getEmailid());
				return query.executeUpdate();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TUserEmail> getEmails(final TUserEmail userEmail,
			final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TEmail>>() {
					@Override
					public List<TEmail> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = null;
						String hql = "from TUserEmail t where t.id.user.userid = :userid and t.type = :type";
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;

						// 收件箱有未读 已读
						int emailType = userEmail.getType();
						Boolean isread = userEmail.getIsread();

						if (emailType == TYPE_RECE && isread != null) {

							hql += " and t.isread = :isread";
							query = session.createQuery(hql);
							query.setParameter("isread", isread.booleanValue());
							query.setParameter("userid", userInfo.getUser()
									.getUserid());
							query.setParameter("type", userEmail.getType());

						} else {
							query = session.createQuery(hql);
							query.setParameter("userid", userInfo.getUser()
									.getUserid());
							query.setParameter("type", userEmail.getType());
						}
						
						
						List<TUserEmail> emails = query.list();
						
						userInfo.setTotalCount(emails.size());

						query.setFirstResult((currPage - 1)
								* UserInfo.PAGE_SIZE);
						query.setMaxResults(currPage * UserInfo.PAGE_SIZE);

						return query.list();
					}
				});

	}

	@Override
	public TEmail getSingleEmail(final TUserEmail userEmail) {

		return getHibernateTemplate().execute(new HibernateCallback<TEmail>() {
			// 如果邮件类型为收件 设为已读
			@Override
			public TEmail doInHibernate(Session session)
					throws HibernateException, SQLException {
				TEmail email = (TEmail) session.load(TEmail.class, userEmail
						.getId().getEmail().getEmailid());
				Clob content = email.getContent();
				email.setStrContent(content.getSubString(1L, (int) content
						.length()));
				if (userEmail.getType() == TYPE_RECE
						&& userEmail.getIsread() == false) {
					userEmail.setIsread(true);
					session.update(userEmail);
					session.flush();
				}
				return email;
			}
		});
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
								.beginTransaction();
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

	@Override
	public void dustToInbox(final TUserEmail userEmail) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "update TUserEmail t set t.type = "
						+ EmailDao.TYPE_RECE
						+ " where t.id.user.userid = :userid and t.id.email.emailid = :emailid";
				Query query = session.createQuery(hql);
				query.setParameter("userid", userEmail.getId().getUser()
						.getUserid());
				query.setParameter("emailid", userEmail.getId().getEmail()
						.getEmailid());
				return query.executeUpdate();
			}
		});

	}
}
