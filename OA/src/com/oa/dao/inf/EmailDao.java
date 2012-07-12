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
	int TYPE_DRAFT_SEND = 5;// �ݸ巢��
	int TYPE_DRAFT_UPDATE = 6;// �ݸ����

	/**
	 * �����ʼ��� �ʼ�������
	 * */
	Integer saveEmail(TEmail email);

	/**
	 * �����û��ʼ���
	 * */
	void saveUserEmail(TUserEmail userEmail);

	List<TUserEmail> getEmails(TUserEmail userEmail, UserInfo userInfo);

	/**
	 * ɾ��ֽ������
	 * */
	void deleteToDust(TUserEmail userEmail);

	/**
	 * ���������ռ���
	 * */
	void dustToInbox(TUserEmail userEmail);

	TEmail getSingleEmail(TUserEmail userEmail);

	/**
	 * ����ɾ��
	 * */
	void deleteEmail(TUserEmail userEmail);

	void deleteEmailFile(TEmailFile emailFile);

	/**
	 * �ݸ�ķ���
	 * */
	void draftToSend(TUserEmail userEmail);

	/**
	 * �ݸ��ʼ��޸�
	 * */
	void updateEmail(TEmail email);

	Integer countEmail(TUser user);
}
