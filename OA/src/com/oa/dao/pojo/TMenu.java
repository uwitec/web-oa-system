package com.oa.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */

public class TMenu implements java.io.Serializable {

	// Fields

	private Integer menuid;
	private TMenu pmenu;
	private String menuname;
	private String menuinfo;
	private String menulink;
	private Integer orderid;
	private Boolean del;
	private Set<TRole> roles = new HashSet<TRole>(0);
	private Set<TMenu> sonMenus = new HashSet<TMenu>(0);

	// Constructors

	/** default constructor */
	public TMenu() {
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public TMenu getPmenu() {
		return pmenu;
	}

	public void setPmenu(TMenu pmenu) {
		this.pmenu = pmenu;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenuinfo() {
		return menuinfo;
	}

	public void setMenuinfo(String menuinfo) {
		this.menuinfo = menuinfo;
	}

	public String getMenulink() {
		return menulink;
	}

	public void setMenulink(String menulink) {
		this.menulink = menulink;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Set<TRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<TRole> roles) {
		this.roles = roles;
	}

	public Set<TMenu> getSonMenus() {
		return sonMenus;
	}

	public void setSonMenus(Set<TMenu> sonMenus) {
		this.sonMenus = sonMenus;
	}

	/** full constructor */

}