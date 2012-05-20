package com.oa.dao.inf;

import java.util.List;

import com.oa.dao.pojo.TRole;

public interface RoleDao {
	/**
	 * @param rolename
	 *            根据角色名模糊查询
	 * */
	List<TRole> getRoles(String rolename);
}
