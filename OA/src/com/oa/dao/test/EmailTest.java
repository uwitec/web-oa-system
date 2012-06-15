package com.oa.dao.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import oracle.sql.CLOB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.dao.pojo.TUserEmailId;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class EmailTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext-email.xml" };

	public static void main(String[] args) {
		// add();
		// slect();
		// delete();
		// deleteTOdUST();
		// dustToiNBOX();

		 getsingle();
	}

	private static void getsingle() {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		EmailDao emailDao = (EmailDao) context.getBean("emailDao");

		TUserEmail userEmail = new TUserEmail();
		TUserEmailId id = new TUserEmailId();
		TEmail email = new TEmail();
		email.setEmailid(46);
		TUser user = new TUser();
		user.setUserid("aaaa1");
		id.setEmail(email);
		id.setUser(user);
		userEmail.setIsread(false);
		userEmail.setType(2);

		userEmail.setId(id);
		
		TEmail email2 = emailDao.getSingleEmail(userEmail);
		System.out.println(email2.getStrContent());
		for (TEmailFile ef : email2.getEmailFiles()) {
			System.out.println(ef.getNewname());
		}
	}

	private static void dustToiNBOX() {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		EmailDao emailDao = (EmailDao) context.getBean("emailDao");

		TUserEmail userEmail = new TUserEmail();
		TUserEmailId id = new TUserEmailId();
		TEmail email = new TEmail();
		email.setEmailid(33);
		TUser user = new TUser();
		user.setUserid("aaaa5");
		id.setEmail(email);
		id.setUser(user);

		userEmail.setId(id);
		emailDao.dustToInbox(userEmail);
	}

	private static void deleteTOdUST() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		EmailDao emailDao = (EmailDao) context.getBean("emailDao");

		TUserEmail userEmail = new TUserEmail();
		TUserEmailId id = new TUserEmailId();
		TEmail email = new TEmail();
		email.setEmailid(33);
		TUser user = new TUser();
		user.setUserid("aaaa5");
		id.setEmail(email);
		id.setUser(user);

		userEmail.setId(id);
		emailDao.deleteToDust(userEmail);
	}

	private static void delete() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		EmailDao emailDao = (EmailDao) context.getBean("emailDao");

		TUserEmail userEmail = new TUserEmail();
		TUserEmailId id = new TUserEmailId();
		TEmail email = new TEmail();
		email.setEmailid(37);
		TUser user = new TUser();
		user.setUserid("admin");
		id.setEmail(email);
		id.setUser(user);

		userEmail.setId(id);
		emailDao.deleteEmail(userEmail);

	}

	private static void slect() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		EmailDao emailDao = (EmailDao) context.getBean("emailDao");

		UserInfo userInfo = new UserInfo();
		TUser user = new TUser();
		user.setUserid("admin");
		userInfo.setUser(user);
		userInfo.setCurrPage(2);

	}

	private static void add() {
		ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		EmailDao emailDao = (EmailDao) context.getBean("emailDao");
		TUserEmail userEmail = new TUserEmail();
		TUser user = new TUser("admin");
		TEmail email = new TEmail();
		email.setStrContent("∑¢ÀÕ” º˛≤‚ ‘");
		email.setHasfile(true);
		email.setReceusers("aaaa1");
		email.setSenduser(user);
		email.setTitle("123");
		TEmailFile emailFile = new TEmailFile(email, "oldname", "newname",
				false);
		Set<TEmailFile> emailFiles = new HashSet<TEmailFile>();
		emailFiles.add(emailFile);
		email.setEmailFiles(emailFiles);

		TUserEmailId id = new TUserEmailId();
		id.setUser(user);
		id.setEmail(email);
		userEmail.setId(id);

	}
}
