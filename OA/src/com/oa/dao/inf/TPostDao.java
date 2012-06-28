package com.oa.dao.inf;
import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.dao.pojo.TUserPost;
import com.oa.util.PostInfo;

public interface TPostDao {
	int STATUS_UNCHECK = 0;
	int STATUS_PASS = 1;
	int STATUS_FAIL = 2;
 
	/*
	 * ��������ӡ����¡�������ģ����ѯ��ͨ��ָ��Id�Ų�ѯ��ͨ��Idɾ����¼
	 */
 
	//���湫���͸�����
	public Integer savePost(TPost tPost);
	
	
	public void deletePost(final TPost tpost);
	//ɾ��
	public void deletePostFile(TPostFile tPostFile);;
	
	public int upadtePost(TPost tPost);	

	//�鿴���˷����Ĺ���
	public TPost selectSinglePost(final int postid);
	//�鿴ȫ������
	public List<TPost> findSelfAll(UserInfo userInfo);	
	//��ͨ�û��鿴���ͨ���Ĺ���
	public List<TPost> findAll(UserInfo userInfo);	
	
	
}
