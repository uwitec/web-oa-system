package com.oa.dao.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.UserDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TMenu;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TTips;
import com.oa.dao.pojo.TUser;

public class UserTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext-user.xml" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// getUser();
		login();
		// delete();
		// findUsers();
		// testAdd();
	}

	private static void delete() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		UserDao userDao = (UserDao) context.getBean("userDao");
		TUser user = new TUser();
		user.setUserid("111111");
		userDao.deleteUser(user);

	}

	private static void findUsers() {

		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		UserDao userDao = (UserDao) context.getBean("userDao");

		UserInfo userInfo = new UserInfo();
		TUser user = new TUser("user", "888888");
		user.setRealname("");
		user.setUserid(null);
		userInfo.setUser(user);
		userInfo.setCurrPage(1);
		userDao.findUsers(userInfo);
		for (TUser tUser : userInfo.getUserList()) {
			System.out.println("-----" + tUser.getJob().getDataname());
		}

	}

	private static void testAdd() {
		// 用户表 用户角色表 小贴士表
		TUser user = new TUser();
		user.setUserid("测试添加用户");
		TRole role = new TRole();
		role.setRoleid(1);
		Set<TRole> roles = new HashSet<TRole>();
		roles.add(role);
		user.setRoles(roles);
		TTips tips = new TTips();
		user.setTips(tips);
		tips.setUser(user);

		TData department = new TData();
		department.setDataid(3);
		TData job = new TData();
		job.setDataid(4);
		user.setDepartment(department);
		user.setJob(job);

		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		UserDao userDao = (UserDao) context.getBean("userDao");
		userDao.addUser(user);
	}

	private static void login() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		UserDao userDao = (UserDao) context.getBean("userDao");
		TUser user = new TUser("admin", "888888");
		user = userDao.login(user);
		Set<TRole> roles = user.getRoles();
		for (TRole tRole : roles) {
			System.out.println("角色  " + tRole.getRolename());
			Set<TMenu> pMenus = tRole.getMenus();
			for (TMenu pMenu : pMenus) {
				System.out.println("--大菜单  " + pMenu.getMenuname());
				for (TMenu sonMenu : pMenu.getSonMenus()) {
					System.out.println("-----小菜单  " + sonMenu.getMenuname());
				}
			}
		}
	}

	private static void getUser() {
	}

}
