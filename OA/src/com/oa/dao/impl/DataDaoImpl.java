package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TUser;

public class DataDaoImpl extends HibernateDaoSupport implements DataDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TData> getDatas(int type) {
		return getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(TData.class).add(
						Restrictions.eq("type", type)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TData> getDatasWithUsers(final List<TData> dataList) {

		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TData>>() {

					@Override
					public List<TData> doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "select new TUser(userid) from TUser user where user.department.dataid = :dataid";
						Query query = null;
						for (TData tData : dataList) {
							query = session.createQuery(hql);
							query.setParameter("dataid", tData.getDataid());
							Set<TUser> users = new HashSet<TUser>();
							for (TUser user : (List<TUser>) query.list()) {
								users.add(user);
							}
							tData.setDepartmentUsers(users);
						}
						return dataList;
					}
				});
	}

}
