package com.oa.service.inf;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TRole;

public interface RoleService {
	
//	TRole getRole(Integer roleid);
	
	void findRoles(UserInfo userInfo);

	void deleteRole(TRole role);
	
	void addRole(TRole role);
	
	void updateRole(TRole role);
	
	void selfUpdate(TRole role);

	boolean isRoleNameExists(String rolename);

	List<TRole> getRoles(UserInfo userInfo);

	TRole getRole(Integer roleid);
}
