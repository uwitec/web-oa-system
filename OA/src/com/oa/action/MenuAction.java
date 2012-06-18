package com.oa.action;

import com.oa.service.inf.DataService;
import com.oa.service.inf.MenuService;
import com.oa.service.inf.RoleService;

public class MenuAction extends BaseAction {
	private RoleService roleService;
	private DataService dataService;
	private MenuService menuService;
	
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public DataService getDataService() {
		return dataService;
	}
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	public MenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
//
//	public String getRoles(){
//		menuService.getMenus(null);
//		return SUCCESS;
//	}
	
	
}
