package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.MenuDao;
import com.oa.dao.pojo.TMenu;

public class MenuDaoImpl extends HibernateDaoSupport implements MenuDao {

	@Override
	public void addMenu(TMenu menu) {
		menu.setDel(false);
		getHibernateTemplate().save(menu);
	}

	@Override
	public void deleteMenu(final TMenu menu) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "update TMenu menu set menu.del = 1"
						+ "where menu.menuid = :menuid";
				Query query = session.createQuery(hql);
				query.setProperties(menu);
				return query.executeUpdate();
			}
		});
	}

	@Override
	public TMenu getMenu(Integer menuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TMenu> getMenuByPre(Integer premenuid) {
		List<TMenu> menuList = getHibernateTemplate().executeFind(
				new HibernateCallback<List<TMenu>>() {

					@Override
					public List<TMenu> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuffer pHql = new StringBuffer(
						"select new TMenu(menu.menuid, menu.menuname, menu.menuinfo," +
						"menu.menulink,menu.orderid) from TMenu menu where " +
						"menu.del != 1 and premenuid =: premenuid");
						
						Query query = session.createQuery(pHql.toString());
						return query.list();
					}
				}
		);
		return menuList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TMenu> getMenus(final String menuname) {
		List<TMenu> menuList = getHibernateTemplate().executeFind(
				new HibernateCallback<List<TMenu>>() {
					@Override
					public List<TMenu> doInHibernate(Session session)
							throws HibernateException, SQLException {

						StringBuffer pHql = new StringBuffer(
								"select new TMenu(menu.menuid, menu.menuname, menu.menuinfo,menu.menulink,menu.orderid) from TMenu menu where menu.del != 1 ");
						if (null != menuname && !"".equals(menuname)) {
							pHql.append(" and menu.menuname like '%" + menuname
									+ "%'");
						}

						Query query = session.createQuery(pHql.toString());
						return query.list();
					}
				});
		return menuList;
	}

	@Override
	public void sortMenu(TMenu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMenu(final TMenu menu) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "update TMenu menu set menu.menuname = :menuname,"
						+ "menu.menuinfo = :menuinfo,menu.menulink = :menulink,"
						+ "menu.orderid = :orderid where menu.menuid = :menuid";
				Query query = session.createQuery(hql);
				query.setProperties(menu);
				return query.executeUpdate();
			}
		});
	}
}
