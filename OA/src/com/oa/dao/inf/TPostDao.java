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
	//public int addPost(TPost tPost);
	//���湫���͸�����
	public Integer savePost(TPost tPost);
//	public void saveUserPost(TUserPost userPost);	
	
	
	public void deletePost(final TPost tpost);
	//ɾ��
	public void deletePostFile(TPostFile tPostFile);;
//	public void deletePost(TUserPost tUserPost);
//	public void deletePost(TPost tPost);
	
	public int upadtePost(TPost tPost);	

	//�鿴���˷����Ĺ���
//	public List<TUserPost> getPosts(final TUserPost tUserPost,
//			final UserInfo userInfo); 
	public TPost selectSinglePost(final int postid);
//	public TPost selectSinglePost(TUserPost tUserPost);
	//�鿴ȫ������
	public List<TPost> findAll(UserInfo userInfo);	
	
	
}
