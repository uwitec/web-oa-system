package com.oa.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rolename;
	private String roleinfo;
	private Boolean del;
	private Set<TUser> users = new HashSet<TUser>(0);
	private Set<TMenu> menus = new HashSet<TMenu>(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	public TRole(Integer roleid,String rolename, String roleinfo) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.roleinfo = roleinfo;
	}

	/** full constructor */
	public TRole(Integer roleid, String rolename, String roleinfo, Boolean del,
			Set users) {
		this.rolename = rolename;
		this.roleid = roleid;
		this.roleinfo = roleinfo;
		this.del = del;
		this.users = users;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoleinfo() {
		return this.roleinfo;
	}

	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}

	public Boolean getDel() {
		return this.del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public void setUsers(Set<TUser> users) {
		this.users = users;
	}

	public Set<TUser> getUsers() {
		return users;
	}

	public void setMenus(Set<TMenu> menus) {
		this.menus = menus;
	}

	public Set<TMenu> getMenus() {
		return menus;
	}

}