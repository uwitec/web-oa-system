package com.oa.service.impl;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.inf.RoleDao;
import com.oa.dao.pojo.TRole;
import com.oa.service.inf.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Override
	public void addRole(TRole role) {
		roleDao.addRole(role);
	}

	@Override
	public void deleteRole(TRole role) {
		roleDao.deleteRole(role);
	}

	@Override
	public TRole getRole(Integer roleid) {
		return roleDao.getRole(roleid);
	}

	@Override
	public void selfUpdate(TRole role) {
		roleDao.selfUpdate(role);
	}

	@Override
	public void updateRole(TRole role) {
		roleDao.updateRole(role);
	}

	@Override
	public boolean isRoleNameExists(String rolename) {
		return roleDao.isRoleNameExists(rolename);
	}

	@Override
	public void findRoles(UserInfo userInfo) {
		roleDao.findRoles(userInfo);
	}

	@Override
	public List<TRole> getRoles(UserInfo userInfo) {
		return roleDao.findRoles(userInfo);
	}

}
