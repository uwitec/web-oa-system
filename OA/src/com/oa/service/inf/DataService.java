package com.oa.service.inf;

import java.util.List;

import com.oa.dao.pojo.TData;

public interface DataService {
	List<TData> getDatas(int type);

	List<TData> getDatasWithUsers(List<TData> dataList);
}
