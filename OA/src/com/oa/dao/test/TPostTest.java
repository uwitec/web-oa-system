package com.oa.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.dao.inf.TPostDao;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TRole;
import com.oa.util.PostInfo;

public class TPostTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext_user.xml" };

	public static void main(String[] args) {
		getTPosts();
	}

	private static void getTPosts() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpotDao");
		PostInfo postInfo =new PostInfo();
		List<TPost> tPostList = tPostDao.findAll(postInfo);
		for (TPost tPost : tPostList) {
			System.out.println(tPost.getTitle());
		}
	}
}
