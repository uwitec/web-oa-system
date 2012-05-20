package com.oa.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.dao.inf.RoleDao;
import com.oa.dao.pojo.TRole;

public class RoleTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext-role.xml" };

	public static void main(String[] args) {
		getRoles();
	}

	private static void getRoles() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		RoleDao roleDao = (RoleDao) context.getBean("roleDao");
		List<TRole> roleList = roleDao.getRoles("นค");
		for (TRole tRole : roleList) {
			System.out.println(tRole.getRolename());
		}
	}
}
