package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.RoleDao;
import com.oa.dao.pojo.TRole;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TRole> getRoles(final String rolename) {

		if (null == rolename || "".equals(rolename)) {
			return getHibernateTemplate().find("from TRole");
		} else {
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(TRole.class).add(
							Restrictions.like("rolename", rolename,
									MatchMode.ANYWHERE)));
		}

	}
}
