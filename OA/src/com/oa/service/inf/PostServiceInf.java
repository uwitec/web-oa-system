package com.oa.service.inf;

import java.io.File;
import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TUserPost;
import com.oa.util.PostInfo;

public interface PostServiceInf {
//		TPost addTPost(TPost tPost);
//		void selectPost(int postid);
//		List<TPost>  getPosts();
		
		/**
		 * 保存公告
		 * */
		void savePost(TUserPost tUserPost, List<File> upload,
				List<String> uploadFileName, List<String> uploadContentType,
				String savePath);

		void savePost(TPost tPost, List<File> upload,
				List<String> uploadFileName, List<String> uploadContentType,
				String savePath);
		/**
		 * 更新
		 * */
		void updatePost(TPost tPost, List<File> upload,
				List<String> uploadFileName, List<String> uploadContentType,
				String savePath);
		
		void updatePost(TUserPost tUserPost, List<File> upload,
				List<String> uploadFileName, List<String> uploadContentType,
				String savePath);
		
		List<TPost>  findAll(final UserInfo userInfo);
		TPost selectSinglePost(int postid);
		
		void deletePost(TPost tPost);
		void deletePost(TUserPost tUserPost);
}
