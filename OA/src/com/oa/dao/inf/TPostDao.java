package com.oa.dao.inf;
import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TUserPost;
import com.oa.util.PostInfo;

public interface TPostDao {
	/*
	 * 公告的增加、更新、按标题模糊查询、通过指定Id号查询、通过Id删除记录
	 */
	//public int addPost(TPost tPost);
	
	public Integer savePost(TPost tPost);
	public void saveUserPost(TUserPost userPost);	
	
	public void deletePost(final TPost tpost);
	public void deletePost(TUserPost tUserPost);
	
	public int upadtePost(TPost tPost);	
	
	
	public TPost selectSinglePost(final int postid);
	public List<TPost> selectPosts(final TPost tPost, final UserInfo userInfo);
	

	
	public List<TUserPost> selectPosts(final TUserPost tUserPost,
			final UserInfo userInfo); 
	public TPost selectSinglePost(TUserPost tUserPost);
	public List<TPost> findAll(PostInfo postInfo);	
	
	
}
