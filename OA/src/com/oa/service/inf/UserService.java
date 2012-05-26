package com.oa.service.inf;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TUser;

public interface UserService {
	TUser login(TUser user);

	void findUsers(UserInfo userInfo);

	List<TData> getDatas(int type);

	TUser getUser(String userid);

	void deleteUser(TUser user);
	
	
	void addUser(TUser user);
	
}
