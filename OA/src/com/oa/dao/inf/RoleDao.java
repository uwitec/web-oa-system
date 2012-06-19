package com.oa.dao.inf;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TRole;

public interface RoleDao {
	/**
	 * @param rolename
	 *            ���ݽ�ɫ��ģ����ѯ
	 * */
	List<TRole> findRoles(UserInfo userInfo);
	
	void updateRole(TRole role);

	void selfUpdate(TRole role);

//	TRole getRole(Integer roleid);

	void addRole(TRole role);

	void deleteRole(TRole role);

	boolean isRoleNameExists(String rolename);

	TRole getRole(Integer roleid);

}
