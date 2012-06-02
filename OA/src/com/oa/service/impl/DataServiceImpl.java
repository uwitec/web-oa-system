package com.oa.service.impl;

import java.util.List;

import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.service.inf.DataService;

public class DataServiceImpl implements DataService {
	private DataDao dataDao;

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
	public List<TData> getDatasWithUsers(List<TData> dataList) {
		return dataDao.getDatasWithUsers(dataList);
	}
}
