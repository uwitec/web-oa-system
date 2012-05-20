package com.oa.dao.inf;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TUser;

public interface UserDao {
	TUser login(TUser user);

	void addUser(TUser user);

	/**
	 * ���û��˺Ż�����ģ����ѯ�����������ž�ȷ��ѯ
	 * ��ҳ
	 * */ 
	void findUsers(UserInfo userInfo);
	
	
	void deleteUser(TUser user);
	
	
	TUser getUser(String userid);
}
