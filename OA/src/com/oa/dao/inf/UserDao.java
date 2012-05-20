package com.oa.dao.inf;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TUser;

public interface UserDao {
	TUser login(TUser user);

	void addUser(TUser user);

	/**
	 * 按用户账号或姓名模糊查询、按所属部门精确查询
	 * 分页
	 * */ 
	void findUsers(UserInfo userInfo);
	
	
	void deleteUser(TUser user);
	
	
	TUser getUser(String userid);
}
