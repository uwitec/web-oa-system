package com.oa.dao.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import oracle.sql.CLOB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.dao.pojo.TUserEmailId;

public class EmailTest {
	private static String[] PATH = { "applicationContext.xml",
			"applicationContext-email.xml" };

	public static void main(String[] args) {
		add();

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
