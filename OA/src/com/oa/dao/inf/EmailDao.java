package com.oa.dao.inf;

import java.util.List;

import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TUser;

public interface EmailDao {

	int TYPE_SEND = 1;
	int TYPE_RECE = 2;
	int TYPE_DRAFT = 3;
	int TYPE_DUST = 4;

	void sendEmail(TUser user, TEmail email, int emailType);

	List<TEmail> getEmails(int emailType, boolean isRead);

	void deleteToDust(TEmail email);

	TEmail getSingleEmail(int emailId);
	
	void deleteEmail(TEmail email);
}
