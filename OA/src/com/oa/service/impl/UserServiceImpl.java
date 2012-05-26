package com.oa.service.impl;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.inf.DataDao;
import com.oa.dao.inf.RoleDao;
import com.oa.dao.inf.UserDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TUser;
import com.oa.service.inf.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private DataDao dataDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Override
	public TUser login(TUser user) {
		return userDao.login(user);
	}

	@Override
	public void findUsers(UserInfo userInfo) {
		userDao.findUsers(userInfo);
	}

	public void setDataDao(DataDao dataDao) {
		this.dataDao = dataDao;
	}

	public DataDao getDataDao() {
		return dataDao;
	}

	@Override
	public List<TData> getDatas(int type) {
		return dataDao.getDatas(type);
	}

	@Override
	public TUser getUser(String userid) {
		return userDao.getUser(userid);
	}

	@Override
	public void deleteUser(TUser user) {
		userDao.deleteUser(user);
	}

	@Override
	public void addUser(TUser user) {
		userDao.addUser(user);
	}

}
