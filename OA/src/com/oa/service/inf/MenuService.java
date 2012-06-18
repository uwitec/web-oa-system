package com.oa.service.inf;

import java.util.List;

import com.oa.dao.pojo.TMenu;

public interface MenuService {
	List<TMenu> getMenus(String menuname);
	
	TMenu getMenu(Integer menuid);
	
	void deleteMenu(TMenu menu);
	
	void addMenu(TMenu menu);

	void updateMenu(TMenu menu);
	
	void sortMenu(TMenu menu);
	
	List<TMenu> getMenuByPre(Integer premenuid);
}
