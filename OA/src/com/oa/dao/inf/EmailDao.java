package com.oa.dao.inf;

import java.util.List;

import com.oa.common.UserInfo;
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

	List<TUserEmail> getEmails(int emailType, boolean isRead, UserInfo userInfo);

	void deleteToDust(TEmail email);

	TEmail getSingleEmail(int emailId);

	void deleteEmail(TEmail email);
}
