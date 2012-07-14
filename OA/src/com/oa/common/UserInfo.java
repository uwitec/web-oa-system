package com.oa.common;

import java.io.Serializable;
import java.util.List;

import com.oa.dao.pojo.TMenu;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TUser;

public class UserInfo implements Serializable {

	// ·ÖÒ³
	public static int PAGE_SIZE = 5;
	private int currPage;
	private int totalCount;
	private int totalPage;
	private String url;

	private List<TUser> userList;
	private List<TRole> roleList;
	private List<TPost> tpostList;
	private List<TMenu> menuList;
	private String message;
	private String vcode;
	private String newPassword;
	private String repeatPassword;

	private TUser user = new TUser();
	private TRole role = new TRole();
	private TPost tpost =new TPost();
	private TMenu menu = new TMenu();
	
	private int emailCount;
	

	public TMenu getMenu() {
		return menu;
	}

	public void setMenu(TMenu menu) {
		this.menu = menu;
	}

	public List<TMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<TMenu> menuList) {
		this.menuList = menuList;
	}

	public List<TPost> getTpostList() {
		return tpostList;
	}

	public void setTpostList(List<TPost> tpostList) {
		this.tpostList = tpostList;
	}

	public TPost getTpost() {
		return tpost;
	}

	public void setTpost(TPost tpost) {
		this.tpost = tpost;
	}

	public List<TRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<TRole> roleList) {
		this.roleList = roleList;
	}

	public TRole getRole() {
		return role;
	}

	public void setRole(TRole role) {
		this.role = role;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<TUser> getUserList() {
		return userList;
	}

	public void setUserList(List<TUser> userList) {
		this.userList = userList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public TUser getUser() {
		return user;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setTotalPage(0 == totalCount ? 0
				: (0 == totalCount % PAGE_SIZE) ? totalCount / PAGE_SIZE
						: totalCount / PAGE_SIZE + 1);
		setCurrPage(totalCount == 0 ? 0 : currPage == 0 ? 1 : currPage);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setEmailCount(int emailCount) {
		this.emailCount = emailCount;
	}

	public int getEmailCount() {
		return emailCount;
	}


}
