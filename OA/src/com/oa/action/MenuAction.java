package com.oa.action;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TMenu;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TRoleMenu;
import com.oa.service.inf.MenuService;

public class MenuAction extends BaseAction {
	private TMenu menu;
	private TRoleMenu roleMenu;
	private MenuService menuService;
	
	private UserInfo userInfo = new UserInfo();
	
	public TMenu getMenu() {
		return menu;
	}

	public void setMenu(TMenu menu) {
		this.menu = menu;
	}

	public TRoleMenu getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(TRoleMenu roleMenu) {
		this.roleMenu = roleMenu;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getMenus(){
		menuService.getMenus(userInfo);
		request.setAttribute("userInfo",userInfo);
		return SUCCESS;
	}
	
	public String getSingleMenu(){
		TMenu menu = menuService.getMenu(userInfo.getMenu().getMenuid());
		while(menu.getPmenu() != null){
			TMenu pmenu = menuService.getMenu(menu.getPmenu().getMenuid());
			menu.setPmenu(pmenu);
		}
		request.setAttribute(SINGLE_MENU, menu);
		return SUCCESS;
	}
	
	public String addMenu(){
		TRole role = (TRole) request.getSession().getAttribute(LOGIN_USER);
		roleMenu.getId().setTRole(role);
		roleMenu.getId().getTMenu().setMenuid(menu.getMenuid());
		
		menuService.addMenu(userInfo.getMenu());
		return SUCCESS;
	}
	
	public String deleteMenu(){
		menuService.deleteMenu(userInfo.getMenu());
		return SUCCESS;
	}
	
	public String updateMenu(){
		menuService.updateMenu(userInfo.getMenu());
		return SUCCESS;
	}
	
	public String preUpdateMenu() {
		TMenu menu = menuService.getMenu(userInfo.getMenu().getMenuid());
		request.setAttribute(SINGLE_MENU, menu);
		return SUCCESS;
	}
}
