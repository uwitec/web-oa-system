package com.oa.dao.test;

import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.inf.TPostDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.dao.pojo.TUserEmailId;
import com.oa.dao.pojo.TUserPost;
import com.oa.dao.pojo.TUserPostId;
import com.oa.util.PostInfo;

public class TPostTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext_post.xml" };

	public static void main(String[] args) {
//		delete();
		savePost();
//		getTPosts();
//		update();
		
	}

	private static void getTPosts() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");


		UserInfo userInfo = new UserInfo();
		TUser user = new TUser();
		user.setUserid("admin");
		userInfo.setUser(user);
		userInfo.setCurrPage(2);
	}

	private static void delete(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
		
		 
	}
	public static void savePost(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
		TPost tpost=new TPost();
		TUser tuser=new TUser("admin");
		tpost.setPostid(2);
		tpost.setAddtime(new Date());
		tpost.setTitle("题目");
		
		tpost.setBegindate(new Date());
		tpost.setHasfile(true);
		tpost.setStatus(3);
		TUserPost tUserPost =new TUserPost();
		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
		TPostFile tPostFile = new TPostFile(tpost, "old", "new", false);
		tPostFiles.add(tPostFile);
		tpost.settPostFiles(tPostFiles);
		
		TUserPost userPost= new TUserPost();
		TUserPostId id = new TUserPostId();
		userPost.setId(id);
		Set<TUserPost> tUserPosts = new HashSet<TUserPost>();
		tUserPosts.add(userPost);
		tpost.settUserPosts(tUserPosts);
		
		tpost.settUserByAdduser(tuser);
		 String str="超级大字段";
 
		tpost.setStrContent(str);
		tPostDao.savePost(tpost);
		System.out.println("ooo");
	
	}
	
	private static void getsingle() {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
		TPost tpost=new TPost();
		TUser tuser=new TUser();
		TUserPost tUserPost = new TUserPost();
		TUserPostId id = new TUserPostId();
		tuser.setUserid("aaaa2");
		tpost.setPostid(15);
		tpost.setStatus(2);
		//T_USER_POST复合主键设置.
		id.settPost(tpost);
		id.settUser(tuser);
		tUserPost.setId(id);
		TPost tPost2 = tPostDao.selectSinglePost(tUserPost);;
		System.out.println(tPost2.getStrContent());
		for (TPostFile pf : tPost2.gettPostFiles()) {
			System.out.println(pf.getNewname());
		}

	}
	
	 public static void update(){
			ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
			TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
			TPost tpost=new TPost();
			TUser tuser=new TUser("aaaa2");
//			TUserPostId id = new TUserPostId();
//			TUserPost tUserPost = new TUserPost();
//			
//			tpost.setPostid(15);
//			tuser.setUserid("aaaa2");
//			id.settPost(tpost);
//			id.settUser(tuser);
//			tUserPost.setId(id);
			Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
			TPostFile tPostFile = new TPostFile(tpost, "old", "new", false);
			TPostFile tPostFile1 = new TPostFile(tpost, "old1", "new1", false);
			tPostFiles.add(tPostFile);
			tPostFiles.add(tPostFile1);
			tpost.settPostFiles(tPostFiles);
			
			 String str="超级大字段";			 
			tpost.setStrContent(str);
			tpost.setTitle("新标题");
			tpost.settUserByUpdateuser(tuser);
			tpost.setUpdatetime(new Date());
		//	tpost.setBegindate("");
			tPostDao.upadtePost(tpost);
			
			
	 }
}
