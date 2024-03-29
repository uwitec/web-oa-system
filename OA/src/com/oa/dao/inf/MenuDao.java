package com.oa.dao.inf;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TMenu;

public interface MenuDao {

	void addMenu(TMenu menu);

	void deleteMenu(TMenu menu);

	TMenu getMenu(Integer menuid);

	void sortMenu(TMenu menu);

	void updateMenu(TMenu menu);
	
	List<TMenu> getMenus(UserInfo userInfo);

	List<TMenu> getMenuByPre(Integer premenuid);
}
