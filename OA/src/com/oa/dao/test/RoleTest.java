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
		TRole role = new TRole(8,"�����û�", "���Ǹ������û�", null, null);
		roleDao.addRole(role);
	}
//
//	private static void deleteRole() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
//		RoleDao roleDao = (RoleDao) context.getBean("roleDao");
//		List<TRole> roleList = roleDao.getRoles("���Խ�ɫ");
//		for (TRole tRole : roleList) {
//			System.out.println(tRole.getRolename());
//			roleDao.deleteRole(tRole);
//		}
//	}
	
//	private static void updateRole(){
//		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
//		RoleDao roleDao = (RoleDao) context.getBean("roleDao");
//		List<TRole> roleList = roleDao.getRoles("�����û�");
//		for (TRole tRole : roleList) {
//			System.out.println("����ǰ��ɫ��:"+tRole.getRolename());
//			tRole.setRolename("�����û�");
//			roleDao.updateRole(tRole);
//			System.out.println("���º��ɫ��:"+tRole.getRolename());
//		}
//	}
}
