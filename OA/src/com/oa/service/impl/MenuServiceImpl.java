package com.oa.service.impl;

import java.util.List;

import com.oa.dao.inf.MenuDao;
import com.oa.dao.pojo.TMenu;
import com.oa.service.inf.MenuService;

public class MenuServiceImpl implements MenuService {
	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public void addMenu(TMenu menu) {
		menuDao.addMenu(menu);
	}

	@Override
	public void deleteMenu(TMenu menu) {
		menuDao.deleteMenu(menu);
	}

	@Override
	public TMenu getMenu(Integer menuid) {
		return menuDao.getMenu(menuid);
	}

	@Override
	public List<TMenu> getMenus(String menuname) {
		return (List<TMenu>)menuDao.getMenus(menuname);
	}

	@Override
	public void sortMenu(TMenu menu) {
		menuDao.sortMenu(menu);
	}

	@Override
	public void updateMenu(TMenu menu) {
		menuDao.updateMenu(menu);
	}

	
	@Override
	public List<TMenu> getMenuByPre(Integer premenuid) {
		return (List<TMenu>) menuDao.getMenuByPre(premenuid);
	}

}
