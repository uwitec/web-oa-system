package com.oa.service.impl;

import java.util.List;

import com.oa.dao.inf.RoleDao;
import com.oa.dao.pojo.TRole;
import com.oa.service.inf.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;

	@Override
	public List<TRole> getRoles(String rolename) {
		return roleDao.getRoles(rolename);
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

}
