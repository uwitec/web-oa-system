package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import sun.security.krb5.internal.PAData;

import com.oa.action.BaseAction;
import com.oa.common.UserInfo;
import com.oa.dao.inf.UserDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TTips;
import com.oa.dao.pojo.TUser;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public TUser login(final TUser user) {
		TUser loginUser = (TUser) getHibernateTemplate().execute(
				new HibernateCallback<TUser>() {
					@Override
					public TUser doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from TUser user where user.userid = :userid and user.password = :password";
						Query query = session.createQuery(hql);
						query.setString("userid", user.getUserid());
						query.setString("password", user.getPassword());
						return (TUser) query.uniqueResult();
					}
				});
		return loginUser;
	}

	@Override
	public void addUser(TUser user) {
		TTips tips = new TTips(user);
		user.setTips(tips);
		getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void findUsers(final UserInfo userInfo) {
		List<TUser> userList = getHibernateTemplate().executeFind(
				new HibernateCallback<List<TUser>>() {
					@Override
					public List<TUser> doInHibernate(Session session)
							throws HibernateException, SQLException {

						StringBuffer hql = new StringBuffer(
								"select new TUser(user.userid, user.realname, user.department, user.job, user.addtime) from TUser user where 1 = 1");
						StringBuffer countHql = new StringBuffer(
								"select count(*) from TUser user where 1 = 1");

						String userid = userInfo.getUser().getUserid();
						String realname = userInfo.getUser().getRealname();
						TData department = userInfo.getUser().getDepartment();
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;

						if (null != userid && !"".equals(userid)) {
							hql.append(" and user.userid like '%" + userid
									+ "%'");
							countHql.append(" and user.userid like '%" + userid
									+ "%'");
						}
						if (null != realname && !"".equals(realname)) {
							hql.append(" and user.realname like '%" + realname
									+ "%'");
							countHql.append(" and user.realname like '%"
									+ realname + "%'");
						}
						if (department != null && department.getDataid() != 0) {
							hql.append(" and user.department = "
									+ department.getDataid());
							countHql.append(" and user.department = "
									+ department.getDataid());
						}
						Query countQuery = session.createQuery(countHql
								.toString());
						userInfo.setTotalCount(((Long) countQuery
								.uniqueResult()).intValue());

						Query query = session.createQuery(hql.toString());
						query.setFirstResult((currPage - 1)
								* UserInfo.PAGE_SIZE);
						query.setMaxResults(UserInfo.PAGE_SIZE);
						return query.list();
					}
				});
		userInfo.setUserList(userList);
	}

	@Override
	public void deleteUser(TUser user) {
		getHibernateTemplate().delete(user);
	}

	@Override
	public TUser getUser(final String userid) {
		return getHibernateTemplate().execute(new HibernateCallback<TUser>() {
			@Override
			public TUser doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from TUser user where user.userid = :userid";
				Query query = session.createQuery(hql);
				query.setString("userid", userid);
				return (TUser) query.uniqueResult();
			}

		});
	}

	@Override
	public boolean isUserIdExists(final String userid) {

		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select count(*) from TUser user where user.userid = :userid";
				Query query = session.createQuery(hql);
				query.setString("userid", userid);
				return (Long) query.uniqueResult() == 0 ? false : true;
			}
		});
	}

	@Override
	public void updateUser(TUser user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public void selfUpdate(final TUser user) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "update TUser user set user.realname = :realname,user.sex = :sex,user.idcard = :idcard, user.phone = :phone"
						+ ",user.handset = :handset , user.email = :email , user.address = :address where user.userid = :userid";
				Query query = session.createQuery(hql);
				query.setProperties(user);
				return query.executeUpdate();
			}
		});
	}
}