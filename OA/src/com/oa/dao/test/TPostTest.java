package com.oa.dao.test;

import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.TPostDao;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserPost;
import com.oa.dao.pojo.TUserPostId;
import com.oa.util.PostInfo;

public class TPostTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext_post.xml" };

	public static void main(String[] args) {
//   	delete();
//		savePost();
		getTPosts();
//		update();
//		getsingle();
		
	}

	private static void getTPosts() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");


		UserInfo userInfo = new UserInfo();
		TUser user = new TUser();
//		user.setUserid("admin");
//		userInfo.setUser(user);
		//ȡ��һҳ������
		userInfo.setCurrPage(1);
		List<TPost> posts= tPostDao.findAll(userInfo);
		for (TPost tPost : posts) {
			System.out.println("title:"+tPost.getTitle()+"\n addtime::"+tPost.getAddtime());
		}
	}

	private static void delete(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
		
		
		TPost tPost =tPostDao.selectSinglePost(22);
//		TUserPost tUserPost = new TUserPost();
//		TUserPostId id = new TUserPostId();
//		TUser user = new TUser("aaaa1");
//		id.settPost(tpost);
//		id.settUser(user);
//		tUserPost.setId(id);
//		tPostDao.deletePost(tUserPost);
		tPostDao.deletePost(tPost);
		System.out.println("-----------------");
		
		
		 
		
		 
	}
	public static void savePost(){
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
		TPost tpost=new TPost();
		TUser tuser=new TUser("admin");
		tpost.setPostid(2);
		
		tpost.setTitle("��Ŀ");		
		tpost.setHasfile(true);
		tpost.setStatus(0);
		TUserPost tUserPost =new TUserPost();
		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
		TPostFile tPostFile = new TPostFile(tpost, "old", "new", false);
		tPostFiles.add(tPostFile);
		tpost.settPostFiles(tPostFiles);
		
		//���м��Ĳ���
		TUserPost userPost= new TUserPost();
		TUserPostId id = new TUserPostId();		
		id.settPost(tpost);
		id.settUser(tuser);
		userPost.setId(id);//û����ɹ�
		
//		Set<TUserPost> tUserPosts = new HashSet<TUserPost>();
//		tUserPosts.add(userPost);
//		tpost.settUserPosts(tUserPosts);
		
		//������Чʱ��-ʧЧʱ��
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		 try {
			Date d=sdf.parse("2012-1-2 17:50:50");
			tpost.setAddtime(new Date());
			tpost.setBegindate(d);
			Date d2=sdf.parse("2012-12-30 17:50:50");
			tpost.setEnddate(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		tpost.settUserByAdduser(tuser);
		 String str="�������ֶ�";
 
		tpost.setStrContent(str);
		tPostDao.savePost(tpost);
		System.out.println("ooo");
	
	}
	
	private static void getsingle() {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
		TPost tpost=tPostDao.selectSinglePost(24);
//		TUser tuser=tpost.gettUserByAdduser();
//		
//		TUserPost tUserPost = new TUserPost();
//		TUserPostId id = new TUserPostId();
//		tuser.setUserid("aaaa2");
//		
//		tpost.setStatus(2);
//		//T_USER_POST������������.
//		id.settPost(tpost);
//		id.settUser(tuser);
//		tUserPost.setId(id);
//		TPost tPost2 = tPostDao.selectSinglePost(tUserPost);;
//		System.out.println(tPost2.getStrContent());
//		for (TPostFile pf : tPost2.gettPostFiles()) {
//			System.out.println(pf.getNewname());
//		}
		String s=tpost.getStatus() >0 ? "δ���":"����";
		System.out.println("���⣺"+tpost.getTitle()+"\n���ݣ�"+tpost.getStrContent()
				+"\n��ʼʱ��"+tpost.getBegindate()+"\nʧЧʱ��"+tpost.getEnddate()
				+"\n���״̬:"+s);

	}
	
	 public static void update(){
			ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
			TPostDao tPostDao  = (TPostDao) context.getBean("tpostDao");
			//�޸ĵ�21��
			TPost tpost = tPostDao.selectSinglePost(21);		
			tpost.setTitle("updateTitle21");		 
//			TUser tuser = new TUser("aaaa2");
 
			Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
			//�����ļ�δ�����޸�?
			TPostFile tPostFile = new TPostFile(tpost, "old21", "new21", false);
			TPostFile tPostFile1 = new TPostFile(tpost, "old21", "new21", false);
			tPostFiles.add(tPostFile);
			tPostFiles.add(tPostFile1);
			tpost.settPostFiles(tPostFiles);
 		
			 String str="nono�������ֶ�";			 
			tpost.setStrContent(str);
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			 try {
				Date d=sdf.parse("2012-1-2 17:50:50");
				tpost.setAddtime(new Date());
				tpost.setBegindate(d);
				Date d2=sdf.parse("2012-12-30 17:50:50");
				tpost.setEnddate(d2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			 
			tPostDao.upadtePost(tpost);
			
			
	 }
}
