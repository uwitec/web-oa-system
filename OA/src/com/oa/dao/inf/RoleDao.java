package com.oa.dao.inf;

import java.util.List;

import com.oa.dao.pojo.TRole;

public interface RoleDao {
	/**
	 * @param rolename
	 *            ���ݽ�ɫ��ģ����ѯ
	 * */
	List<TRole> getRoles(String rolename);
}
