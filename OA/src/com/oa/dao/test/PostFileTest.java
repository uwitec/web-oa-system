package com.oa.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.dao.inf.TPostFileDao;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;

public class PostFileTest {
	private static String[] PATH = { "applicationContext.xml",
	"applicationContext_post.xml" };
	public static void main(String[] args) {
//		add();
		delete();
	}
	public static void add(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostFileDao fileDao =(TPostFileDao) context.getBean("tpotFileDao");
	
		TPost post =new TPost();
		post.setPostid(1);
		TPostFile tPostFile = new TPostFile(post, "old", "new", false);
		fileDao.addPostFile(tPostFile);
		
	}
	
	
	public static void delete(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostFileDao fileDao =(TPostFileDao) context.getBean("tpotFileDao");
	
		TPost post =new TPost();
		post.setPostid(1);
		System.out.println(post.getPostid());
		System.out.println("-----------------");
		fileDao.deletePostFile(post.getPostid());
		System.out.println("-----------------");
	}
}
