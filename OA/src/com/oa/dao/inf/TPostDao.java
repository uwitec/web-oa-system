package com.oa.dao.inf;
import java.util.List;

import com.oa.dao.pojo.TPost;
import com.oa.util.PostInfo;

public interface TPostDao {
	/*
	 * ��������ӡ����¡�������ģ����ѯ��ͨ��ָ��Id�Ų�ѯ��ͨ��Idɾ����¼
	 */
	public int addPost(TPost tPost);
	public int upadtePost(TPost tPost);
	public List<TPost> selectPosts(String title);
	public TPost selectSinglePost(int postId);
	public boolean deletePost(int postId);
	public List<TPost> findAll(PostInfo postInfo);
}
