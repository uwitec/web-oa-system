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
	 * 公告的增加、更新、按标题模糊查询、通过指定Id号查询、通过Id删除记录
	 */
 
	//保存公告表和附件表
	public Integer savePost(TPost tPost);
	
	
	public void deletePost(final TPost tpost);
	//删除
	public void deletePostFile(TPostFile tPostFile);;
	
	public int upadtePost(TPost tPost);	

	//查看个人发布的公告
	public TPost selectSinglePost(final int postid);
	//查看全部公告
	public List<TPost> findSelfAll(UserInfo userInfo);	
	//普通用户查看审核通过的公告
	public List<TPost> findAll(UserInfo userInfo);	
	
	
}
