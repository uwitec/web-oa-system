package com.oa.dao.inf;

import java.util.List;

import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;

public interface EmailDao {

	int TYPE_SEND = 1;
	int TYPE_RECE = 2;
	int TYPE_DRAFT = 3;
	int TYPE_DUST = 4;
	int TYPE_NEW = 0;

	Integer saveEmail(TEmail email);

	void saveUserEmail(TUserEmail userEmail);

	List<TEmail> getEmails(int emailType, boolean isRead);

	void deleteToDust(TEmail email);

	TEmail getSingleEmail(int emailId);

	void deleteEmail(TEmail email);
}
