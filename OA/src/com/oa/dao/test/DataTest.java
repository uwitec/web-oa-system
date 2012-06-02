package com.oa.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TUser;

public class DataTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext-user.xml" };

	public static void main(String[] args) {
		getdata();
	}

	private static void getdata() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		DataDao dataDao = (DataDao) context.getBean("dataDao");
		List<TData> datas = dataDao.getDatas(DataDao.TYPE_DEPARTMENT);
		datas = dataDao.getDatasWithUsers(datas);
		for (TData tData : datas) {
			System.out.println(tData.getDataname() + "--");
			for (TUser user : tData.getDepartmentUsers()) {
				System.out.println(user.getUserid());
			}
		}
	}
}
