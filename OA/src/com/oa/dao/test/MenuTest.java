package com.oa.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.MenuDao;
import com.oa.dao.inf.RoleDao;
import com.oa.dao.pojo.TMenu;
import com.oa.dao.pojo.TRole;

public class MenuTest {
	private static String[] PATH = { "applicationContext.xml",
	"applicationContext-menu.xml" };

	public static void main(String[] args) {
		getMenus();
//		addMenus();
	}
	
	private static void getMenus(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		MenuDao menuDao = (MenuDao) context.getBean("menuDao");
		
		TMenu menu = new TMenu();
		menu.setMenuname("");
		menu.setMenuid(null);
		List<TMenu> tmenu = menuDao.getMenus(menu.getMenuname());
		for (TMenu amenu : tmenu) {
			System.out.println(amenu.getMenuname());
		}
	}
	
	private static void addMenus(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		MenuDao menuDao = (MenuDao) context.getBean("menuDao");
		
		TMenu menu = new TMenu("测试菜单", "这是个测试用户", null, 50);
		menuDao.addMenu(menu);
	}
	
	
}
