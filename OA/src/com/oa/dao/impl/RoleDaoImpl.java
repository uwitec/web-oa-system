package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.common.UserInfo;
import com.oa.dao.inf.RoleDao;
import com.oa.dao.pojo.TRole;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<TRole> getRoles(final String rolename) {
//
//		if (null == rolename || "".equals(rolename)) {
//			return getHibernateTemplate().find("from TRole");
//		} else {
//			return getHibernateTemplate().findByCriteria(
//					DetachedCriteria.forClass(TRole.class).add(
//							Restrictions.like("rolename", rolename,
//									MatchMode.ANYWHERE)));
//		}
//
//	}

	@Override
	public void addRole(TRole role) {
		role.setDel(false);
		getHibernateTemplate().save(role);
	}

	@Override
	public void deleteRole(final TRole role) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "update TRole role set role.del = 1" +
						"where role.roleid = :roleid";
				Query query =session.createQuery(hql);
				query.setProperties(role);
				return query.executeUpdate();
			}
		});
	}
	
	@Override
	public void updateRole(final TRole role) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "update TRole role set role.rolename = :rolename," +
						"role.roleinfo = :roleinfo where role.roleid = :roleid";
				Query query =session.createQuery(hql);
				query.setProperties(role);
				return query.executeUpdate();
			}
		});
	}

	@Override
	public TRole getRole(final Integer roleid) {
		return getHibernateTemplate().execute(new HibernateCallback<TRole>() {
			@Override
			public TRole doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from TRole role where role.roleid = :roleid";
				Query query = session.createQuery(hql);
				query.setInteger("roleid", roleid);
				return (TRole) query.uniqueResult();
			}
		});
	}

	@Override
	public void selfUpdate(final TRole role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "update TRole role set role.rolename = :rolename,role.roleinfo = :roleinfo where role.roleid = :roleid";
				Query query =session.createQuery(hql);
				query.setProperties(role);
				return query.executeUpdate();
			}
		});
	}
	
	@Override
	public boolean isRoleNameExists(final String rolename) {
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "select count(*) from TRole role where role.rolename = :rolename";
				Query query = session.createQuery(hql);
				query.setString("rolename", rolename);
				return (Long) query.uniqueResult() == 0 ? false : true;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TRole> findRoles(final UserInfo userInfo) {
		List<TRole> roleList = getHibernateTemplate().executeFind(
				new HibernateCallback<List<TRole>>() {
					@Override
					public List<TRole> doInHibernate(Session session)
							throws HibernateException, SQLException {

						StringBuffer hql = new StringBuffer(
								"select new TRole(role.id, role.rolename, role.roleinfo) from TRole role where role.del != 1");
						StringBuffer countHql = new StringBuffer(
								"select count(*) from TRole role where role.del !=1");
						String rolename = userInfo.getRole().getRolename();
						String roleinfo = userInfo.getRole().getRoleinfo();
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;

						if (null != rolename && !"".equals(rolename)) {
							hql.append(" and role.rolename like '%" + rolename
									+ "%'");
							countHql.append(" and role.rolename like '%"
									+ rolename + "%'");
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
		userInfo.setRoleList(roleList);
		return roleList;
	}
}
