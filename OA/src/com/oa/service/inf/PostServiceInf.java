package com.oa.service.inf;

import java.util.List;

import com.oa.dao.pojo.TPost;

public interface PostServiceInf {
		TPost addTPost(TPost tPost);
		void selectPost(int postid);
		List<TPost>  getPosts();
}
