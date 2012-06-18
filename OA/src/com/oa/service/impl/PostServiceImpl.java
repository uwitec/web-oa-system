package com.oa.service.impl;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.oa.common.FileUtil;
import com.oa.common.UserInfo;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.inf.TPostDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.dao.pojo.TUserEmailId;
import com.oa.dao.pojo.TUserPost;
import com.oa.dao.pojo.TUserPostId;
import com.oa.service.inf.PostServiceInf;
import com.oa.util.PostInfo;

public class PostServiceImpl implements PostServiceInf{
	private TPostDao tPostDao;
	
	public TPostDao gettPostDao() {
		return tPostDao;
	}

	public void settPostDao(TPostDao tPostDao) {
		this.tPostDao = tPostDao;
	}



	@Override
	public void deletePost(TUserPost tUserPost) {
		tPostDao.deletePost(tUserPost);
		
	}

 


	@Override
	public void savePost(TUserPost tUserPost, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {
		TPost tPost = tUserPost.getId().gettPost();
		 
		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
		if (null != upload) {
			tPost.setHasfile(true);
			for (int i = 0; i < upload.size(); ++i) {
				String newFileName = FileUtil.makeNewFileName(uploadFileName
						.get(i));
				String newFilePath = savePath + File.separator + newFileName;
				File newFile = new File(newFilePath);
				FileUtil.copyFile(upload.get(i), newFile);
				TPostFile tPostFile = new TPostFile();
				
				tPostFile.setNewname(newFileName);
				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.settPost(tPost);
				tPostFiles.add(tPostFile);
			}
		} else {
			tPost.setHasfile(false);
		}
		tPost.settPostFiles(tPostFiles);

		Integer postid = tPostDao.savePost(tPost);

		tPost.setPostid(postid);
		

		TUser addUser = tUserPost.getId().gettPost().gettUserByAdduser();
		tPost.settUserByAdduser(addUser);
		tPostDao.saveUserPost(tUserPost);
		//.........
		
	}

	@Override
	public void updatePost(TUserPost tUserPost, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TUserPost> findAll(TUserPost tUserPost, UserInfo userInfo) {
		// TODO Auto-generated method stub
		return tPostDao.selectPosts(tUserPost, userInfo);
	}

	@Override
	public void deletePost(TPost tPost) {
		tPostDao.deletePost(tPost);
		
	}

	@Override
	public List<TPost> findAll(TPost tPost, UserInfo userInfo) {
		// TODO Auto-generated method stub
		return tPostDao.selectPosts(tPost, userInfo);
	}

	@Override
	public void savePost(TPost tPost, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {
		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
		if (null != upload) {
			tPost.setHasfile(true);
			for (int i = 0; i < upload.size(); ++i) {
				String newFileName = FileUtil.makeNewFileName(uploadFileName
						.get(i));
				String newFilePath = savePath + File.separator + newFileName;
				File newFile = new File(newFilePath);
				FileUtil.copyFile(upload.get(i), newFile);
				TPostFile tPostFile = new TPostFile();
				
				tPostFile.setNewname(newFileName);
				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.settPost(tPost);
				tPostFiles.add(tPostFile);
			}
		} else {
			tPost.setHasfile(false);
		}
		tPost.settPostFiles(tPostFiles);
		TUser addUser = tPost.gettUserByAdduser();
		tPost.settUserByAdduser(addUser);
		//级联表设置
		Integer postid = tPostDao.savePost(tPost);
		TUserPostId id = new TUserPostId(addUser, tPost);
		TUserPost tUserPost = new TUserPost();
		tUserPost.setId(id);
		tPostDao.saveUserPost(tUserPost);
		
	}

	@Override
	public void updatePost(TPost tPost, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {
		 
		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
		if (null != upload) {
			tPost.setHasfile(true);
			for (int i = 0; i < upload.size(); ++i) {
				String newFileName = FileUtil.makeNewFileName(uploadFileName
						.get(i));
				String newFilePath = savePath + File.separator + newFileName;
				File newFile = new File(newFilePath);
				FileUtil.copyFile(upload.get(i), newFile);
				TPostFile tPostFile = new TPostFile();
				
				tPostFile.setNewname(newFileName);
				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.settPost(tPost);
				tPostFiles.add(tPostFile);
			}
		} else {
			tPost.setHasfile(false);
		}
		tPost.settPostFiles(tPostFiles);

		Integer postid = tPostDao.savePost(tPost);

		tPost.setPostid(postid);
		

		TUser addUser = tPost.gettUserByAdduser();
		tPost.settUserByAdduser(addUser);
		tPostDao.upadtePost(tPost);
		
	}

 


}
