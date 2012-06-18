package com.oa.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.RoleDao;
import com.oa.dao.pojo.TRole;

public class RoleTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext-user.xml" };

	public static void main(String[] args) {
		findRoles();
		// deleteRole();
		// addRole();
		// updateRole();
	}

	private static void findRoles() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		RoleDao roleDao = (RoleDao) context.getBean("roleDao");
		
		UserInfo roleInfo = new UserInfo();
		TRole role = new TRole();
		role.setRolename("");
		role.setRoleid(null);
		roleInfo.setRole(role);
		roleInfo.setCurrPage(1);
		roleDao.findRoles(roleInfo);
		for (TRole tRole : roleInfo.getRoleList()) {
			System.out.println(tRole.getRolename());
		}
	}
	
	private static void addRole(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		RoleDao roleDao = (RoleDao) context.getBean("roleDao");
		TRole role = new TRole(8,"测试用户", "这是个测试用户", null, null);
		roleDao.addRole(role);
	}
//
//	private static void deleteRole() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
//		RoleDao roleDao = (RoleDao) context.getBean("roleDao");
//		List<TRole> roleList = roleDao.getRoles("测试角色");
//		for (TRole tRole : roleList) {
//			System.out.println(tRole.getRolename());
//			roleDao.deleteRole(tRole);
//		}
//	}
	
//	private static void updateRole(){
//		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
//		RoleDao roleDao = (RoleDao) context.getBean("roleDao");
//		List<TRole> roleList = roleDao.getRoles("测试用户");
//		for (TRole tRole : roleList) {
//			System.out.println("更新前角色名:"+tRole.getRolename());
//			tRole.setRolename("更新用户");
//			roleDao.updateRole(tRole);
//			System.out.println("更新后角色名:"+tRole.getRolename());
//		}
//	}
}
