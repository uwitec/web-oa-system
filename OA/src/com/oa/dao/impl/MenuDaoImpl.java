package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.common.UserInfo;
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
				String hql = "update TMenu menu set menu.del = 1"
						+ "where menu.menuid = :menuid";
				Query query = session.createQuery(hql);
				query.setProperties(menu);
				return query.executeUpdate();
			}
		});
	}

	@Override
	public TMenu getMenu(final Integer menuid) {
		return getHibernateTemplate().execute(new HibernateCallback<TMenu>() {
			@Override
			public TMenu doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from TMenu menu where menu.menuid = :menuid";
				Query query = session.createQuery(hql);
				query.setInteger("menuid", menuid);
				return (TMenu) query.uniqueResult();
			}
		});
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
								"select new TMenu(menu.menuid, menu.menuname, menu.menuinfo,"
										+ "menu.menulink,menu.orderid) from TMenu menu where "
										+ "menu.del != 1 and premenuid =: premenuid");

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

	@SuppressWarnings("unchecked")
	@Override
	public List<TMenu> getMenus(final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TMenu>>() {

					@Override
					public List<TMenu> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuffer hql = new StringBuffer(
								"from TMenu menu where menu.del != 1");
						String menuname = userInfo.getMenu().getMenuname();
						if (null != menuname && !"".equals(menuname)) {
							hql.append(" and menu.menuname like '%" + menuname
									+ "%'");
						}
						hql.append(" order by menu.orderid");
						Query query = session.createQuery(hql.toString());
						List<TMenu> menuList = query.list();
						userInfo.setMenuList(menuList);
						return menuList;
					}
				});
	}
}
