package com.oa.dao.inf;
import java.util.List;

import com.oa.dao.pojo.TPost;
import com.oa.util.PostInfo;

public interface TPostDao {
	/*
	 * 公告的增加、更新、按标题模糊查询、通过指定Id号查询、通过Id删除记录
	 */
	public int addPost(TPost tPost);
	public int upadtePost(TPost tPost);
	public List<TPost> selectPosts(String title);
	public TPost selectSinglePost(int postId);
	public boolean deletePost(int postId);
	public List<TPost> findAll(PostInfo postInfo);
}
