package com.oa.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TRole;

public class DataDaoImpl extends HibernateDaoSupport implements DataDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TData> getDatas(int type) {
		return getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(TData.class).add(
						Restrictions.eq("type", type)));
	}


}
