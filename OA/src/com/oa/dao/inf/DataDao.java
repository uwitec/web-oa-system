package com.oa.dao.inf;

import java.util.List;

import com.oa.dao.pojo.TData;

public interface DataDao {
	public static int TYPE_PROVINCE = 1;
	public static int TYPE_CITY = 2;
	public static int TYPE_DEPARTMENT = 3;
	public static int TYPE_JOB = 4;


	List<TData> getDatas(int type);
}
