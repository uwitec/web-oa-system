package com.oa.dao.inf;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;

public interface EmailDao {

	int TYPE_SEND = 1;
	int TYPE_RECE = 2;
	int TYPE_DRAFT = 3;
	int TYPE_DUST = 4;
	int TYPE_DRAFT_SEND = 5;// 草稿发送
	int TYPE_DRAFT_UPDATE = 6;// 草稿更新

	/**
	 * 保存邮件表 邮件附件表
	 * */
	Integer saveEmail(TEmail email);

	/**
	 * 保存用户邮件表
	 * */
	void saveUserEmail(TUserEmail userEmail);

	List<TUserEmail> getEmails(TUserEmail userEmail, UserInfo userInfo);

	/**
	 * 删除纸垃圾箱
	 * */
	void deleteToDust(TUserEmail userEmail);

	/**
	 * 垃圾箱至收件箱
	 * */
	void dustToInbox(TUserEmail userEmail);

	TEmail getSingleEmail(TUserEmail userEmail);

	/**
	 * 永久删除
	 * */
	void deleteEmail(TUserEmail userEmail);

	void deleteEmailFile(TEmailFile emailFile);

	/**
	 * 草稿改发件
	 * */
	void draftToSend(TUserEmail userEmail);

	/**
	 * 草稿邮件修改
	 * */
	void updateEmail(TEmail email);

	Integer countEmail(TUser user);
}
